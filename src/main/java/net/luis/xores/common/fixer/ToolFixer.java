package net.luis.xores.common.fixer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.xores.init.ModBlocks;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

/**
 * {@link VanillaFixer} for the Tool drop of Blocks
 * 
 * @author Luis-st
 */

public class ToolFixer implements VanillaFixer {
	
	/**
	 * Instance of {@link ToolFixer},<br> 
	 * use this as reference if you want to use the {@link ToolFixer}
	 */
	public static final ToolFixer INSTANCE = new ToolFixer() {
		@Override
		public void init() {
			this.register();
		}
	};
	
	/**
	 * Constants
	 */
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
	
	/**
	 * Register the vanilla {@link Blocks} and the {@link ModBlocks},<br>
	 * to the tool level<br>
	 * Register the vanilla Tools and the mod Tools,<br>
	 * to the tool level<br>
	 */
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
	
	/**
	 * Register the blocks to the level
	 * @param level to which the blocks are registered
	 * @param blocks which should be registered
	 */
	public void registerBlocks(int level, Block... blocks) {
		this.registerBlocks(level, Lists.newArrayList(blocks));
	}
	
	/**
	 * Register the blocks to the level
	 * @param level to which the blocks are registered
	 * @param blocks which should be registered
	 */
	protected void registerBlocks(int level, List<Block> blocks) {
		if (!this.blocks.containsKey(level)) {
			this.blocks.put(level, Lists.newArrayList());
		}
		this.blocks.get(level).addAll(blocks);
	}
	
	/**
	 * Register the tools to the level
	 * @param level to which the tools are registered
	 * @param tools which should be registered
	 */
	public void registerTools(int level, Item... tools) {
		this.registerTools(level, Lists.newArrayList(tools));
	}
	
	/**
	 * Register the tools to the level
	 * @param level to which the tools are registered
	 * @param tools which should be registered
	 */
	protected void registerTools(int level, List<Item> tools) {
		if (!this.tools.containsKey(level)) {
			this.tools.put(level, Lists.newArrayList());
		}
		this.tools.get(level).addAll(tools);
	}
	
	/**
	 * @return all registered blocks
	 */
	public List<Block> getRegisteredBlocks() {
		List<Block> registeredBlocks = Lists.newArrayList();
		for (List<Block> blocks : Lists.newArrayList(this.blocks.values().iterator())) {
			registeredBlocks.addAll(blocks);
		}
		return registeredBlocks;
	}
	
	/**
	 * @param block which should be checked if it is registered
	 * @return <code>true</code> if the block is registered
	 */
	public boolean isBlockRegistered(Block block) {
		return this.getRegisteredBlocks().stream().anyMatch(registeredBlock -> {
			return block == registeredBlock;
		});
	}
	
	/**
	 * @return all registered tools 
	 */
	public List<Item> getRegisteredTools() {
		List<Item> registeredTools = Lists.newArrayList();
		for (List<Item> tools : Lists.newArrayList(this.tools.values().iterator())) {
			registeredTools.addAll(tools);
		}
		return registeredTools;
	}
	
	/**
	 * @param tool which should be checked if it is registered
	 * @return <code>true</code> if the tool is registered
	 */
	public boolean isToolRegistered(Item tool) {
		return this.getRegisteredTools().stream().anyMatch(registeredTool -> {
			return tool == registeredTool;
		});
	}
	
	/**
	 * @return <code>true</code> if the item has the correct level for the state
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
				Named<Block> blocks = this.getTagForTool(tool);
				if (blocks != null) {
					return blocks.getValues().contains(block);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @param tool 
	 * @return the {@link Tag}  for the given {@link Item}
	 */
	protected Named<Block> getTagForTool(Item tool) {
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
	 * @param block
	 * @return the {@link Tag} for the given {@link Block}
	 */
	protected int getLevelForBlock(Block block) {
		for (Entry<Integer, List<Block>> entry : this.blocks.entrySet()) {
			int level = entry.getKey();
			if (entry.getValue().contains(block)) {
				return level;
			}
		}
		return 0;
	}
	
	/**
	 * @param tool
	 * @return the level for the given {@link Item}
	 */
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
