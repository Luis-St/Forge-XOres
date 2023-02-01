package net.luis.xores.tags;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

/**
 *
 * @author Luis-st
 *
 */

public class XOItemTags {
	
	public static final TagKey<Item> WOOD = bind(new ResourceLocation(XOres.MOD_ID, "wood"));
	public static final TagKey<Item> LEATHER = bind(new ResourceLocation(XOres.MOD_ID, "leather"));
	public static final TagKey<Item> STONE = bind(new ResourceLocation(XOres.MOD_ID, "stone"));
	public static final TagKey<Item> CHAINMAIL = bind(new ResourceLocation(XOres.MOD_ID, "chainmail"));
	public static final TagKey<Item> COPPER = bind(new ResourceLocation(XOres.MOD_ID, "copper"));
	public static final TagKey<Item> GOLDEN = bind(new ResourceLocation(XOres.MOD_ID, "golden"));
	public static final TagKey<Item> IRON = bind(new ResourceLocation(XOres.MOD_ID, "iron"));
	public static final TagKey<Item> DIAMOND = bind(new ResourceLocation(XOres.MOD_ID, "diamond"));
	public static final TagKey<Item> NETHERITE = bind(new ResourceLocation(XOres.MOD_ID, "netherite"));
	public static final TagKey<Item> JADE = bind(new ResourceLocation(XOres.MOD_ID, "jade"));
	public static final TagKey<Item> BLAZING = bind(new ResourceLocation(XOres.MOD_ID, "blazing"));
	public static final TagKey<Item> SAPHIRE = bind(new ResourceLocation(XOres.MOD_ID, "saphire"));
	public static final TagKey<Item> LIMONITE = bind(new ResourceLocation(XOres.MOD_ID, "limonite"));
	public static final TagKey<Item> ROSE_QUARTZ = bind(new ResourceLocation(XOres.MOD_ID, "rose_quartz"));
	public static final TagKey<Item> ENDERITE = bind(new ResourceLocation(XOres.MOD_ID, "enderite"));
	public static final TagKey<Item> STEEL = bind(new ResourceLocation(XOres.MOD_ID, "steel"));
	public static final TagKey<Item> NIGHT = bind(new ResourceLocation(XOres.MOD_ID, "night"));
	
	public static final TagKey<Item> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
	public static final TagKey<Item> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
	public static final TagKey<Item> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
	public static final TagKey<Item> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
	public static final TagKey<Item> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
	
	public static final TagKey<Item> SWORDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/sword"));
	public static final TagKey<Item> SHIELDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/shield"));
	public static final TagKey<Item> BOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/bow"));
	public static final TagKey<Item> CROSSBOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/crossbow"));
	
	public static final TagKey<Item> PICKAXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/pickaxe"));
	public static final TagKey<Item> AXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/axe"));
	public static final TagKey<Item> SHOVELS = bind(new ResourceLocation(XOres.MOD_ID, "tools/shovel"));
	public static final TagKey<Item> HOES = bind(new ResourceLocation(XOres.MOD_ID, "tools/hoe"));
	
	public static final TagKey<Item> ARMOR = bind(new ResourceLocation(XOres.MOD_ID, "armors/armor"));
	public static final TagKey<Item> HELMETS = bind(new ResourceLocation(XOres.MOD_ID, "armors/helmet"));
	public static final TagKey<Item> CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/chestplate"));
	public static final TagKey<Item> ELYTRA_CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/elytra_chestplate"));
	public static final TagKey<Item> LEGGINGS = bind(new ResourceLocation(XOres.MOD_ID, "armors/leggings"));
	public static final TagKey<Item> BOOTS = bind(new ResourceLocation(XOres.MOD_ID, "armors/boots"));
	
	public static final TagKey<Item> SCRAPS = bind(new ResourceLocation(XOres.MOD_ID, "scraps"));
	
	public static final TagKey<Item> TOOL_LEVEL_0 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_0"));
	public static final TagKey<Item> TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_1"));
	public static final TagKey<Item> TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_2"));
	public static final TagKey<Item> TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_3"));
	public static final TagKey<Item> TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_4"));
	public static final TagKey<Item> TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
	public static final TagKey<Item> TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
	
	private static TagKey<Item> bind(ResourceLocation location) {
		return ItemTags.create(location);
	}
	
}
