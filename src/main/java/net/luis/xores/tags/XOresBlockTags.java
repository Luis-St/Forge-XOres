package net.luis.xores.tags;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

/**
 * registration class for all mod {@link Block} {@link TagKey} tags
 * 
 * @author Luis-st
 */

public class XOresBlockTags {
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 1
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_1"));
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 2
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_2"));
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 3
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_3"));
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 4
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_4"));
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 5
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
	
	/**
	 * {@link TagKey} tag for {@link Block}s that needs tool level 6
	 */
	public static final TagKey<Block> NEEDS_TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
	
	/**
	 * {@link TagKey} tag for all jade ores
	 */
	public static final TagKey<Block> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
	
	/**
	 * {@link TagKey} tag for all saphire ores
	 */
	public static final TagKey<Block> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
	
	/**
	 * {@link TagKey} tag for all limonite ores
	 */
	public static final TagKey<Block> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
	
	/**
	 * {@link TagKey} tag for all rosite ores
	 */
	public static final TagKey<Block> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
	
	/**
	 * {@link TagKey} tag for all enderite ores
	 */
	public static final TagKey<Block> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
	
	/**
	 * {@link TagKey} tag for all ore blocks
	 */
	public static final TagKey<Block> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
	
	/**
	 * {@link TagKey} tag for all end base stones
	 */
	public static final TagKey<Block> BASE_STONE_END = bind(new ResourceLocation(XOres.MOD_ID, "base_stone_end"));
	
	/**
	 * {@link TagKey} tag for all stones
	 */
	public static final TagKey<Block> STONES = bind(new ResourceLocation(XOres.MOD_ID, "stones"));
	
	/**
	 * bind a {@link TagKey} tag to the {@link ResourceLocation}
	 * @param name The name of the {@link TagKey} tag as an {@link ResourceLocation}
	 * @return the {@link TagKey} tag for the given name
	 */
	protected static TagKey<Block> bind(ResourceLocation location) {
		return BlockTags.create(location);
	}
	
}
