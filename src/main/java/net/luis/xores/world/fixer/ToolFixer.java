package net.luis.xores.world.fixer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;
import net.luis.xores.tags.XOBlockTags;
import net.luis.xores.tags.XOItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *
 * @author Luis-St
 *
 */

public class ToolFixer implements VanillaFixer {
	
	public static final ToolFixer INSTANCE = new ToolFixer();
	
	public static final int HAND_LEVEL = 0;
	public static final int WOOD_LEVEL = 0;
	public static final int GOLD_LEVEL = 0;
	public static final int STONE_LEVEL = 1;
	public static final int IRON_LEVEL = 2;
	public static final int JADE_LEVEL = 2;
	public static final int BLAZING_LEVEL = 2;
	public static final int DIAMOND_LEVEL = 3;
	public static final int SAPHIRE_LEVEL = 3;
	public static final int NETHERITE_LEVEL = 4;
	public static final int ROSE_QUARTZ_LEVEL = 4;
	public static final int LIMONITE_LEVEL = 5;
	public static final int ENDERITE_LEVEL = 5;
	public static final int NIGHT_LEVEL = 5;
	public static final int STEEL_LEVEL = 6;
	
	private final Map<Integer, List<Either<TagKey<Block>, Block>>> blocks;
	private final Map<Integer, List<Either<TagKey<Item>, Item>>> tools;
	
	private ToolFixer() {
		this.blocks = Maps.newHashMap();
		this.tools = Maps.newHashMap();
		this.register();
	}
	
	private void register() {
		this.registerBlockTag(1, XOBlockTags.NEEDS_TOOL_LEVEL_1);
		this.registerBlockTag(2, XOBlockTags.NEEDS_TOOL_LEVEL_2);
		this.registerBlockTag(3, XOBlockTags.NEEDS_TOOL_LEVEL_3);
		this.registerBlockTag(4, XOBlockTags.NEEDS_TOOL_LEVEL_4);
		this.registerBlockTag(5, XOBlockTags.NEEDS_TOOL_LEVEL_5);
		this.registerBlockTag(6, XOBlockTags.NEEDS_TOOL_LEVEL_6);
		this.registerToolTag(0, XOItemTags.TOOL_LEVEL_0);
		this.registerToolTag(1, XOItemTags.TOOL_LEVEL_1);
		this.registerToolTag(2, XOItemTags.TOOL_LEVEL_2);
		this.registerToolTag(3, XOItemTags.TOOL_LEVEL_3);
		this.registerToolTag(4, XOItemTags.TOOL_LEVEL_4);
		this.registerToolTag(5, XOItemTags.TOOL_LEVEL_5);
		this.registerToolTag(6, XOItemTags.TOOL_LEVEL_6);
	}
	
	private <T> List<T> getTagValues(@NotNull IForgeRegistry<T> registry, TagKey<T> tag) {
		return Objects.requireNonNull(registry.tags()).getTag(tag).stream().collect(Collectors.toList());
	}
	
	public void registerBlocks(int level, Block... blocks) {
		this.registerBlocks(level, Lists.newArrayList(blocks).stream().map(Either::<TagKey<Block>, Block>right).collect(Collectors.toList()));
	}
	
	public void registerBlockTag(int level, TagKey<Block> tagKey) {
		this.registerBlocks(level, Lists.newArrayList(Either.left(tagKey)));
	}
	
	private void registerBlocks(int level, List<Either<TagKey<Block>, Block>> values) {
		if (!this.blocks.containsKey(level)) {
			this.blocks.put(level, Lists.newArrayList());
		}
		this.blocks.get(level).addAll(values);
	}
	
	public void registerTools(int level, Item... tools) {
		this.registerTools(level, Lists.newArrayList(tools).stream().map(Either::<TagKey<Item>, Item>right).collect(Collectors.toList()));
	}
	
	public void registerToolTag(int level, TagKey<Item> tagKey) {
		this.registerTools(level, Lists.newArrayList(Either.left(tagKey)));
	}
	
	private void registerTools(int level, List<Either<TagKey<Item>, Item>> values) {
		if (!this.tools.containsKey(level)) {
			this.tools.put(level, Lists.newArrayList());
		}
		this.tools.get(level).addAll(values);
	}
	
	public @NotNull List<Block> getRegisteredBlocks() {
		List<Block> registeredBlocks = Lists.newArrayList();
		for (List<Either<TagKey<Block>, Block>> blocks : Lists.newArrayList(this.blocks.values().iterator())) {
			for (Either<TagKey<Block>, Block> either : blocks) {
				either.ifLeft((tag) -> {
					registeredBlocks.addAll(ToolFixer.this.getTagValues(ForgeRegistries.BLOCKS, tag));
				});
				either.ifRight(registeredBlocks::add);
			}
		}
		return registeredBlocks;
	}
	
	public boolean isBlockRegistered(Block block) {
		return this.getRegisteredBlocks().contains(block);
	}
	
	public @NotNull List<Item> getRegisteredTools() {
		List<Item> registeredTools = Lists.newArrayList();
		for (List<Either<TagKey<Item>, Item>> tools : Lists.newArrayList(this.tools.values().iterator())) {
			for (Either<TagKey<Item>, Item> either : tools) {
				either.ifLeft((tag) -> {
					registeredTools.addAll(ToolFixer.this.getTagValues(ForgeRegistries.ITEMS, tag));
				});
				either.ifRight(registeredTools::add);
			}
		}
		return registeredTools;
	}
	
	public boolean isToolRegistered(Item tool) {
		return this.getRegisteredTools().contains(tool);
	}
	
	@SuppressWarnings("deprecation")
	public boolean isCorrectToolForDrops(Item tool, ItemStack stack, @NotNull BlockState state) {
		Block block = state.getBlock();
		int tierLevel = -1;
		int toolLevel = this.getLevelForTool(tool);
		if (tool instanceof DiggerItem diggerItem) {
			tierLevel = diggerItem.getTier().getLevel();
		}
		if (tierLevel > -1 && tierLevel != toolLevel) {
			return false;
		} else {
			int blockLevel = this.getLevelForBlock(block);
			if (tierLevel >= blockLevel || blockLevel == 0) {
				TagKey<Block> blocks = this.getTagForTool(tool);
				if (blocks != null) {
					return this.getTagValues(ForgeRegistries.BLOCKS, blocks).contains(block);
				}
				return true;
			}
		}
		return false;
	}
	
	private @Nullable TagKey<Block> getTagForTool(Item tool) {
		if (tool instanceof PickaxeItem) {
			return BlockTags.MINEABLE_WITH_PICKAXE;
		} else if (tool instanceof AxeItem) {
			return BlockTags.MINEABLE_WITH_AXE;
		} else if (tool instanceof ShovelItem) {
			return BlockTags.MINEABLE_WITH_SHOVEL;
		} else if (tool instanceof HoeItem) {
			return BlockTags.MINEABLE_WITH_HOE;
		}
		return null;
	}
	
	public int getLevelForBlock(Block block) {
		if (this.getRegisteredBlocks().contains(block)) {
			for (Entry<Integer, List<Block>> entry : this.map(ForgeRegistries.BLOCKS, this.blocks).entrySet()) {
				if (entry.getValue().contains(block)) {
					return entry.getKey();
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	public int getLevelForTool(Item tool) {
		if (this.getRegisteredTools().contains(tool)) {
			for (Entry<Integer, List<Item>> entry : this.map(ForgeRegistries.ITEMS, this.tools).entrySet()) {
				if (entry.getValue().contains(tool)) {
					return entry.getKey();
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private <T> @NotNull Map<Integer, List<T>> map(IForgeRegistry<T> registry, @NotNull Map<Integer, List<Either<TagKey<T>, T>>> map) {
		Map<Integer, List<T>> newMap = Maps.newHashMap();
		for (Entry<Integer, List<Either<TagKey<T>, T>>> entry : map.entrySet()) {
			int level = entry.getKey();
			if (!newMap.containsKey(level)) {
				newMap.put(level, Lists.newArrayList());
			}
			for (Either<TagKey<T>, T> either : entry.getValue()) {
				either.ifLeft((tagValue) -> newMap.get(level).addAll(ToolFixer.this.getTagValues(registry, tagValue)));
				either.ifRight((value) -> newMap.get(level).add(value));
			}
		}
		return newMap;
	}
}
