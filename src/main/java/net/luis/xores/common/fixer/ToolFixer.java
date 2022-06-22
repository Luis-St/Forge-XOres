package net.luis.xores.common.fixer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Either;

import net.luis.xores.init.XOresTags;
import net.luis.xores.mixin.ItemStackMixin;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * implementation of {@link VanillaFixer}, used to fix/handle the logic<br>
 * of {@link TieredItem#isCorrectToolForDrops(ItemStack, BlockState)},<br>
 * manually and in a better way
 * 
 * @author Luis-st
 * 
 * @see {@link VanillaFixer}
 * @see {@link ItemStackMixin}
 */

public class ToolFixer implements VanillaFixer {
	
	/**
	 * {@link ToolFixer} instance use this field,<br>
	 * if you want to use the {@link ToolFixer}
	 */
	public static final ToolFixer INSTANCE = new ToolFixer();
	
	/**
	 * constant for the hand harvest level
	 */
	public static final int HAND_LEVEL = 0;
	
	/**
	 * constant for the wood tool harvest level
	 */
	public static final int WOOD_LEVEL = 0;
	
	/**
	 * constant for the gold tool harvest level
	 */
	public static final int GOLD_LEVEL = 0;
	
	/**
	 * constant for the stone tool harvest level
	 */
	public static final int STONE_LEVEL = 1;
	
	/**
	 * constant for the iron tool harvest level
	 */
	public static final int IRON_LEVEL = 2;
	
	/**
	 * constant for the jade tool harvest level
	 */
	public static final int JADE_LEVEL = 2;
	
	/**
	 * constant for the blazing tool harvest level
	 */
	public static final int BLAZING_LEVEL = 2;
	
	/**
	 * constant for the diamond tool harvest level
	 */
	public static final int DIAMOND_LEVEL = 3;
	
	/**
	 * constant for the saphire tool harvest level
	 */
	public static final int SAPHIRE_LEVEL = 3;
	
	/**
	 * constant for the netherite tool harvest level
	 */
	public static final int NETHERITE_LEVEL = 4;
	
	/**
	 * constant for the rosite tool harvest level
	 */
	public static final int ROSITE_LEVEL = 4;
	
	/**
	 * constant for the rose quartz tool harvest level
	 */
	public static final int ROSE_QUARTZ_LEVEL = 4;
	
	/**
	 * constant for the limonite tool harvest level
	 */
	public static final int LIMONITE_LEVEL = 5;
	
	/**
	 * constant for the enderite tool harvest level
	 */
	public static final int ENDERITE_LEVEL = 5;
	
	/**
	 * constant for the night tool harvest level
	 */
	public static final int NIGHT_LEVEL = 5;
	
	/**
	 * constant for the steel tool harvest level
	 */
	public static final int STEEL_LEVEL = 6;
	
	/**
	 * {@link Map} of all registered {@link Block}s with the related block harvest level
	 */
	protected final Map<Integer, List<Either<TagKey<Block>, Block>>> blocks;
	
	/**
	 * {@link Map} of all registered {@link Item}s with the related tool harvest level
	 */
	protected final Map<Integer, List<Either<TagKey<Item>, Item>>> tools;
	
	/**
	 * constructor for the {@link ToolFixer},<br>
	 * private since the constructor is only use for the instance field
	 */
	private ToolFixer() {
		this.blocks = Maps.newHashMap();
		this.tools = Maps.newHashMap();
		this.register();
	}
	
	/**
	 * regsiter all 
	 * <ul>
	 * 	<li>{@link Block}s from the tool level tags to it's block harvest level</li>
	 * 	<li>{@link Item}s from the tool level tags to it's tool harvest level</li>
	 * </ul>
	 */
	protected void register() {
		this.registerBlockTag(1, XOresTags.Blocks.NEEDS_TOOL_LEVEL_1);
		this.registerBlockTag(2, XOresTags.Blocks.NEEDS_TOOL_LEVEL_2);
		this.registerBlockTag(3, XOresTags.Blocks.NEEDS_TOOL_LEVEL_3);
		this.registerBlockTag(4, XOresTags.Blocks.NEEDS_TOOL_LEVEL_4);
		this.registerBlockTag(5, XOresTags.Blocks.NEEDS_TOOL_LEVEL_5);
		this.registerBlockTag(6, XOresTags.Blocks.NEEDS_TOOL_LEVEL_6);
		this.registerToolTag(0, XOresTags.Items.TOOL_LEVEL_0);
		this.registerToolTag(1, XOresTags.Items.TOOL_LEVEL_1);
		this.registerToolTag(2, XOresTags.Items.TOOL_LEVEL_2);
		this.registerToolTag(3, XOresTags.Items.TOOL_LEVEL_3);
		this.registerToolTag(4, XOresTags.Items.TOOL_LEVEL_4);
		this.registerToolTag(5, XOresTags.Items.TOOL_LEVEL_5);
		this.registerToolTag(6, XOresTags.Items.TOOL_LEVEL_6);
	}
	
	/**
	 * @param registry The {@link Registry} from which the values should get
	 * @param key The {@link TagKey} for which the values should get
	 * @return a {@link List} of all values for the given {@link TagKey}
	 */
	private <T> List<T> getTagValues(Registry<T> registry, TagKey<T> key) {
		return Lists.newArrayList(registry.getTagOrEmpty(key)).stream().map(Holder::value).collect(Collectors.toList());
	}
	
	/**
	 * register the given {@link Block}s to the given block harvest level
	 * @param level The level to which the {@link Block}s are registered to
	 * @param blocks The {@link Block}s which should be registered
	 */
	public void registerBlocks(int level, Block... blocks) {
		this.registerBlocks(level, Lists.newArrayList(blocks).stream().map((block) -> {
			return Either.<TagKey<Block>, Block>right(block);
		}).collect(Collectors.toList()));
	}
	
	/**
	 * register the given {@link TagKey} to the given block harvest level
	 * @param level The level to which the {@link TagKey} is registered to
	 * @param tagKey The {@link TagKey} which should be registered
	 */
	public void registerBlockTag(int level, TagKey<Block> tagKey) {
		this.registerBlocks(level, Lists.newArrayList(Either.left(tagKey)));
	}
	
	/**
	 * register the given values to the given block harvest level
	 * @param level The level to which the values are registered to
	 * @param values The values which should be registered
	 */
	private void registerBlocks(int level, List<Either<TagKey<Block>, Block>> values) {
		if (!this.blocks.containsKey(level)) {
			this.blocks.put(level, Lists.newArrayList());
		}
		this.blocks.get(level).addAll(values);
	}
	
	/**
	 * register the given {@link Item}s to the given tool harvest level
	 * @param level The to which the {@link Item}s are registered to
	 * @param tools The {@link Item}s which should be registered
	 */
	public void registerTools(int level, Item... tools) {
		this.registerTools(level, Lists.newArrayList(tools).stream().map((tool) -> {
			return Either.<TagKey<Item>, Item>right(tool);
		}).collect(Collectors.toList()));
	}
	
	/**
	 * register the given {@link TagKey} to the given tool harvest level
	 * @param level The to which the {@link TagKey} is registered to
	 * @param tools The {@link TagKey} which should be registered
	 */
	public void registerToolTag(int level, TagKey<Item> tagKey) {
		this.registerTools(level, Lists.newArrayList(Either.left(tagKey)));
	}
	
	/**
	 * register the given values to the given tool harvest level
	 * @param level The to which the values are registered to
	 * @param tools The values which should be registered
	 */
	private void registerTools(int level, List<Either<TagKey<Item>, Item>> values) {
		if (!this.tools.containsKey(level)) {
			this.tools.put(level, Lists.newArrayList());
		}
		this.tools.get(level).addAll(values);
	}
	
	/**
	 * @return all registered {@link Block}s as a {@link List}
	 */
	@SuppressWarnings("deprecation")
	public List<Block> getRegisteredBlocks() {
		List<Block> registeredBlocks = Lists.newArrayList();
		for (List<Either<TagKey<Block>, Block>> blocks : Lists.newArrayList(this.blocks.values().iterator())) {
			for (Either<TagKey<Block>, Block> either : blocks) {
				either.ifLeft((tag) -> {
					registeredBlocks.addAll(ToolFixer.this.getTagValues(Registry.BLOCK, tag));
				});
				either.ifRight((block) -> {
					registeredBlocks.add(block);
				});
			}
		}
		return registeredBlocks;
	}
	
	/**
	 * checks if the given {@link Block} is registered
	 * @param block The {@link Block} which should be checked
	 * @return {@code true} if the given {@link Block} is registered else {@code false}
	 */
	public boolean isBlockRegistered(Block block) {
		return this.getRegisteredBlocks().contains(block);
	}
	
	/**
	 * @return all registered {@link Item}s as a {@link List}
	 */
	@SuppressWarnings("deprecation")
	public List<Item> getRegisteredTools() {
		List<Item> registeredTools = Lists.newArrayList();
		for (List<Either<TagKey<Item>, Item>> tools : Lists.newArrayList(this.tools.values().iterator())) {
			for (Either<TagKey<Item>, Item> either : tools) {
				either.ifLeft((tag) -> {
					registeredTools.addAll(ToolFixer.this.getTagValues(Registry.ITEM, tag));
				});
				either.ifRight((tool) -> {
					registeredTools.add(tool);
				});
			}
		}
		return registeredTools;
	}
	
	/**
	 * checks if the given {@link Item} is registered
	 * @param tool The {@link Item} which should be checked
	 * @return {@code true} if the given {@link Item} is registered else {@code false}
	 */
	public boolean isToolRegistered(Item tool) {
		return this.getRegisteredTools().contains(tool);
	}
	
	/**
	 * checks if the tool can mine the {@link BlockState}
	 * @param tool The {@link Item} which is used to mine the {@link BlockState}
	 * @param stack The {@link ItemStack} of the tool can be null, since it's currently unused
	 * @param state The {@link BlockState} which is mined
	 * @return {@code true} if the tool can mine the {@link BlockState} else {@code false}
	 */
	@SuppressWarnings("deprecation")
	public boolean isCorrectToolForDrops(Item tool, ItemStack stack, BlockState state) {
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
					return this.getTagValues(Registry.BLOCK, blocks).contains(block);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param tool The {@link Item} for which the Tag should be get
	 * @return the Tag for the given {@link Item}, if the {@link Item} is a vanilla tool else {@code null}
	 */
	@Nullable
	private TagKey<Block> getTagForTool(Item tool) {
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
	
	/**
	 * @param block The {@link Block} for which the level should be get
	 * @return the block harvest level for the given {@link Block}, if the {@link Block} is registered else {@code 0}
	 */
	@SuppressWarnings("deprecation")
	public int getLevelForBlock(Block block) {
		if (this.getRegisteredBlocks().contains(block)) {
			for (Entry<Integer, List<Block>> entry : this.map(Registry.BLOCK, this.blocks).entrySet()) {
				if (entry.getValue().contains(block)) {
					return entry.getKey();
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * @param tool The {@link Item} for which the level should be get
	 * @return the tool harvest level for the given {@link Item}, if the {@link Item} is registered else {@code 0}
	 */
	@SuppressWarnings("deprecation")
	public int getLevelForTool(Item tool) {
		if (this.getRegisteredTools().contains(tool)) {
			for (Entry<Integer, List<Item>> entry : this.map(Registry.ITEM, this.tools).entrySet()) {
				if (entry.getValue().contains(tool)) {
					return entry.getKey();
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	/**
	 * maps the given {@link Map} to a new {@link Map} with pattern {@code <Integer, List<T>>}
	 * @param registry The {@link Registry} which is used to get the Tag values<br>
	 * from the given {@link TagKey} in the {@link Map}
	 * @param map The {@link Map} which should be mapped to the pattern 
	 * @return a new {@link Map} with pattern {@code <Integer, List<T>>}
	 */
	private <T> Map<Integer, List<T>> map(Registry<T> registry, Map<Integer, List<Either<TagKey<T>, T>>> map) {
		Map<Integer, List<T>> newMap = Maps.newHashMap();
		for (Entry<Integer, List<Either<TagKey<T>, T>>> entry : map.entrySet()) {
			int level = entry.getKey();
			if (!newMap.containsKey(level)) {
				newMap.put(level, Lists.newArrayList());
			}
			for (Either<TagKey<T>, T> either : entry.getValue()) {
				either.ifLeft((tagValue) -> {
					newMap.get(level).addAll(ToolFixer.this.getTagValues(registry, tagValue));
				});
				either.ifRight((value) -> {
					newMap.get(level).add(value);
				});
			}
		}
		return newMap;
	}
	
}
