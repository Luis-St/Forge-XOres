package net.luis.xores.tags;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresBlockTags {
	
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_1"));
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_2"));
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_3"));
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_4"));
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
	
	public static final TagKey<Block> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
	public static final TagKey<Block> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
	public static final TagKey<Block> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
	public static final TagKey<Block> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
	public static final TagKey<Block> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
	public static final TagKey<Block> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
	
	private static TagKey<Block> bind(ResourceLocation location) {
		return BlockTags.create(location);
	}
	
}
