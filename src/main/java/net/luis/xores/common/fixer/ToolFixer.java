package net.luis.xores.common.fixer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.xores.init.ModTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

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
	public static final int ROSITE_LEVEL = 4;
	public static final int ROSE_QUARTZ_LEVEL = 4;
	public static final int LIMONITE_LEVEL = 5;
	public static final int ENDERITE_LEVEL = 5;
	public static final int NIGHT_LEVEL = 5;
	public static final int STEEL_LEVEL = 6;
	
	protected final Map<Integer, List<Block>> blocks;
	protected final Map<Integer, List<Item>> tools;
	
	private ToolFixer() {
		this.blocks = Maps.newHashMap();
		this.tools = Maps.newHashMap();
		this.register();
	}
	
	protected void register() {
		this.registerBlockTag(1, ModTags.Blocks.TOOL_LEVEL_1);
		this.registerBlockTag(2, ModTags.Blocks.TOOL_LEVEL_2);
		this.registerBlockTag(3, ModTags.Blocks.TOOL_LEVEL_3);
		this.registerBlockTag(4, ModTags.Blocks.TOOL_LEVEL_4);
		this.registerBlockTag(5, ModTags.Blocks.TOOL_LEVEL_5);
		this.registerBlockTag(6, ModTags.Blocks.TOOL_LEVEL_6);
		this.registerToolTag(0, ModTags.Items.WOOD);
		this.registerToolTag(0, ModTags.Items.GOLDEN);
		this.registerToolTag(1, ModTags.Items.STONE);
		this.registerToolTag(2, ModTags.Items.IRON);
		this.registerToolTag(3, ModTags.Items.DIAMOND);
		this.registerToolTag(4, ModTags.Items.NETHERITE);
	}
	
	public void registerBlock(int level, Block block) {
		if (this.blocks.get(level) != null) {
			this.blocks.get(level).add(block);
		} else {
			this.blocks.put(level, Lists.newArrayList(block));
		}
	}
	
	public void registerBlockTag(int level, Named<Block> tag) {
		if (this.blocks.get(level) != null) {
			this.blocks.get(level).addAll(tag.getValues());
		} else {
			this.blocks.put(level, Lists.newArrayList(tag.getValues()));
		}
	}
	
	public void registerTool(int level, Item tool) {
		if (this.tools.get(level) != null) {
			this.tools.get(level).add(tool);
		} else {
			this.tools.put(level, Lists.newArrayList(tool));
		}
	}
	
	public void registerToolTag(int level, Named<Item> tag) {
		List<DiggerItem> values = tag.getValues().stream().filter(item -> {
			return item instanceof DiggerItem;
		}).map(item -> {
			return (DiggerItem) item;
		}).collect(Collectors.toList());
		if (this.tools.get(level) != null) {
			this.tools.get(level).addAll(values);
		} else {
			this.tools.put(level, Lists.newArrayList(values));
		}
	}
	
	@SuppressWarnings("deprecation")
	public boolean isCorrectToolForDrops(DiggerItem item, @Nullable ItemStack stack, BlockState state) {
		Block block = state.getBlock();
		int tierLevel = item.getTier().getLevel();
		int toolLevel = this.getLevelForTool(item);
		if (tierLevel != toolLevel) {
			return false;
		} else {
			int blockLevel = this.getLevelForBlock(block);
			if (tierLevel >= blockLevel || blockLevel == 0) {
				return this.getTagForTool(item).getValues().contains(block);
			}
		}
		return false;
	}
	
	protected Named<Block> getTagForTool(DiggerItem item) {
		if (item instanceof PickaxeItem) {
			return BlockTags.MINEABLE_WITH_PICKAXE;
		} else if (item instanceof AxeItem) {
			return BlockTags.MINEABLE_WITH_AXE;
		} else if (item instanceof ShovelItem) {
			return BlockTags.MINEABLE_WITH_SHOVEL;
		} else if (item instanceof HoeItem) {
			return BlockTags.MINEABLE_WITH_HOE;
		}
		return null;
	}
	
	protected int getLevelForBlock(Block block) {
		for (Entry<Integer, List<Block>> entry : Lists.newArrayList(this.blocks.entrySet().iterator())) {
			int level = entry.getKey();
			if (entry.getValue().contains(block)) {
				return level;
			}
		}
		return 0;
	}
	
	protected int getLevelForTool(Item tool) {
		for (Entry<Integer, List<Item>> entry : Lists.newArrayList(this.tools.entrySet().iterator())) {
			int level = entry.getKey();
			if (entry.getValue().contains(tool)) {
				return level;
			}
		}
		return 0;
	}
	
}
