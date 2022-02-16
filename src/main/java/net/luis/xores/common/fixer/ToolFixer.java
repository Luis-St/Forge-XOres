package net.luis.xores.common.fixer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.luis.xores.init.ModTags;
import net.luis.xores.mixin.ItemStackMixin;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.Tag.Named;
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
 * implementation of {@link VanillaFixer},<br>
 * used to fix/handle the logic of {@link TieredItem#isCorrectToolForDrops(ItemStack, BlockState)},<br>
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
	public static final ToolFixer INSTANCE = new ToolFixer() {
		@Override
		public void init() {
			this.register();
		}
	};
	
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
	protected final Map<Integer, List<Block>> blocks;
	
	/**
	 * {@link Map} of all registered {@link Item}s with the related tool harvest level
	 */
	protected final Map<Integer, List<Item>> tools;
	
	/**
	 * constructor for the {@link ToolFixer},<br>
	 * private since the constructor is only use for the instance field
	 */
	private ToolFixer() {
		this.blocks = Maps.newHashMap();
		this.tools = Maps.newHashMap();
	}
	
	/**
	 * regsiter all 
	 * <ul>
	 * 	<li>{@link Block}s from the tool level tags to it's block harvest level</li>
	 * 	<li>{@link Items}s from the tool level tags to it's tool harvest level</li>
	 * </ul>
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
	 * @see {@link ToolFixer#registerBlocks(int, List)}
	 */
	public void registerBlocks(int level, Block... blocks) {
		this.registerBlocks(level, Lists.newArrayList(blocks));
	}
	
	/**
	 * register the given {@link Block}s to the given block harvest level
	 * @param level the to which the {@link Block}s are registered to
	 * @param blocks the {@link Block}s which should be registered
	 */
	protected void registerBlocks(int level, List<Block> blocks) {
		if (!this.blocks.containsKey(level)) {
			this.blocks.put(level, Lists.newArrayList());
		}
		this.blocks.get(level).addAll(blocks);
	}
	
	/**
	 * @see {@link ToolFixer#registerTools(int, List)}
	 */
	public void registerTools(int level, Item... tools) {
		this.registerTools(level, Lists.newArrayList(tools));
	}
	
	/**
	 * register the given {@link Item}s to the given tool harvest level
	 * @param level the to which the {@link Item}s are registered to
	 * @param tools the {@link Item}s which should be registered
	 */
	protected void registerTools(int level, List<Item> tools) {
		if (!this.tools.containsKey(level)) {
			this.tools.put(level, Lists.newArrayList());
		}
		this.tools.get(level).addAll(tools);
	}
	
	/**
	 * @return all registered {@link Block}s as a {@link List}
	 */
	public List<Block> getRegisteredBlocks() {
		List<Block> registeredBlocks = Lists.newArrayList();
		for (List<Block> blocks : Lists.newArrayList(this.blocks.values().iterator())) {
			registeredBlocks.addAll(blocks);
		}
		return registeredBlocks;
	}
	
	/**
	 * checks if the given {@link Block} is registered
	 * @param block which should be checked
	 * @return {@code true} if the given {@link Block} is registered else {@code false}
	 */
	public boolean isBlockRegistered(Block block) {
		return this.getRegisteredBlocks().stream().anyMatch(registeredBlock -> {
			return block == registeredBlock;
		});
	}
	
	/**
	 * @return all registered {@link Item}s as a {@link List}
	 */
	public List<Item> getRegisteredTools() {
		List<Item> registeredTools = Lists.newArrayList();
		for (List<Item> tools : Lists.newArrayList(this.tools.values().iterator())) {
			registeredTools.addAll(tools);
		}
		return registeredTools;
	}
	
	/**
	 * checks if the given {@link Item} is registered
	 * @param tool which should be checked
	 * @return {@code true} if the given {@link Item} is registered else {@code false}
	 */
	public boolean isToolRegistered(Item tool) {
		return this.getRegisteredTools().stream().anyMatch(registeredTool -> {
			return tool == registeredTool;
		});
	}
	
	/**
	 * checks if the tool can mine the {@link BlockState}
	 * @param tool which is used to mine the {@link BlockState}
	 * @param stack of the tool can be null, since it's currently unused
	 * @param state which contains the {@link Block} to be checked
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
	 * @param tool for which the {@link Tag} should be get
	 * @return the {@link Tag} for the given {@link Item}, if the {@link Item} is a vanilla tool else {@code null}
	 */
	@Nullable
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
	 * @param block for which the level should be get
	 * @return the block harvest level for the given {@link Block}, if the {@link Block} is registered else {@code 0}
	 */
	public int getLevelForBlock(Block block) {
		for (Entry<Integer, List<Block>> entry : this.blocks.entrySet()) {
			int level = entry.getKey();
			if (entry.getValue().contains(block)) {
				return level;
			}
		}
		return 0;
	}
	
	/**
	 * @param tool for which the level should be get
	 * @return the tool harvest level for the given {@link Item}, if the {@link Item} is registered else {@code 0}
	 */
	public int getLevelForTool(Item tool) {
		for (Entry<Integer, List<Item>> entry : this.tools.entrySet()) {
			int level = entry.getKey();
			if (entry.getValue().contains(tool)) {
				return level;
			}
		}
		return 0;
	}
	
}
