package net.luis.xores.common.fixer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public static final ToolFixer INSTANCE = new ToolFixer() {
		@Override
		public void init() {
			this.register();
		}
	};
	
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
		this.init();
	}
	
	protected void register() {
		this.registerBlocks(1, ModTags.Blocks.NEEDS_TOOL_LEVEL_1.getValues());
		this.registerBlocks(2, ModTags.Blocks.NEEDS_TOOL_LEVEL_2.getValues());
		this.registerBlocks(3, ModTags.Blocks.NEEDS_TOOL_LEVEL_3.getValues());
		this.registerBlocks(4, ModTags.Blocks.NEEDS_TOOL_LEVEL_4.getValues());
		this.registerBlocks(5, ModTags.Blocks.NEEDS_TOOL_LEVEL_5.getValues());
		this.registerBlocks(6, ModTags.Blocks.NEEDS_TOOL_LEVEL_6.getValues());
		
		this.registerTools(0, ModTags.Items.TOOL_LEVEL_0.getValues());
		this.registerTools(1, ModTags.Items.TOOL_LEVEL_1.getValues());
		this.registerTools(2, ModTags.Items.TOOL_LEVEL_2.getValues());
		this.registerTools(3, ModTags.Items.TOOL_LEVEL_3.getValues());
		this.registerTools(4, ModTags.Items.TOOL_LEVEL_4.getValues());
		this.registerTools(5, ModTags.Items.TOOL_LEVEL_5.getValues());
		this.registerTools(6, ModTags.Items.TOOL_LEVEL_6.getValues());
	}
	
	public void registerBlocks(int level, Block... blocks) {
		this.registerBlocks(level, Lists.newArrayList(blocks));
	}
	
	protected void registerBlocks(int level, List<Block> blocks) {
		if (!this.blocks.containsKey(level)) {
			this.blocks.put(level, Lists.newArrayList());
		}
		this.blocks.get(level).addAll(blocks);
	}
	
	public void registerTools(int level, Item... items) {
		this.registerTools(level, Lists.newArrayList(items));
	}
	
	protected void registerTools(int level, List<Item> items) {
		if (!this.tools.containsKey(level)) {
			this.tools.put(level, Lists.newArrayList());
		}
		this.tools.get(level).addAll(items);
	}
	
	public List<Block> getRegisteredBlocks() {
		List<Block> registeredBlocks = Lists.newArrayList();
		for (List<Block> blocks : Lists.newArrayList(this.blocks.values().iterator())) {
			registeredBlocks.addAll(blocks);
		}
		return registeredBlocks;
	}
	
	public boolean isBlockRegistered(Block block) {
		return this.getRegisteredBlocks().stream().anyMatch(registeredBlock -> {
			return block == registeredBlock;
		});
	}
	
	public List<Item> getRegisteredTools() {
		List<Item> registeredItems = Lists.newArrayList();
		for (List<Item> items : Lists.newArrayList(this.tools.values().iterator())) {
			registeredItems.addAll(items);
		}
		return registeredItems;
	}
	
	public boolean isToolRegistered(Item item) {
		return this.getRegisteredTools().stream().anyMatch(registeredItem -> {
			return item == registeredItem;
		});
	}
	
	@SuppressWarnings("deprecation")
	public boolean isCorrectToolForDrops(Item item, ItemStack stack, BlockState state) {
		Block block = state.getBlock();
		int tierLevel = -1;
		int toolLevel = this.getLevelForTool(item);
		if (item instanceof DiggerItem diggerItem) {
			tierLevel = diggerItem.getTier().getLevel();
		}
		if (tierLevel > -1 && tierLevel != toolLevel) {
			return false;
		} else {
			int blockLevel = this.getLevelForBlock(block);
			if (tierLevel >= blockLevel || blockLevel == 0) {
				Named<Block> blocks = this.getTagForTool(item);
				if (blocks != null) {
					return blocks.getValues().contains(block);
				}
				return true;
			}
		}
		return false;
	}
	
	protected Named<Block> getTagForTool(Item item) {
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
		for (Entry<Integer, List<Block>> entry : this.blocks.entrySet()) {
			int level = entry.getKey();
			if (entry.getValue().contains(block)) {
				return level;
			}
		}
		return 0;
	}
	
	protected int getLevelForTool(Item tool) {
		for (Entry<Integer, List<Item>> entry : this.tools.entrySet()) {
			int level = entry.getKey();
			if (entry.getValue().contains(tool)) {
				return level;
			}
		}
		return 0;
	}
	
}
