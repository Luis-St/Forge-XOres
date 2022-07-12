package net.luis.xores.tags;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

/**
 * registration class for all mod {@link Item} {@link TagKey} tags
 * 
 * @author Luis-st
 */

public class XOresItemTags {
	
	/**
	 * {@link TagKey} tag for all wood tools
	 */
	public static final TagKey<Item> WOOD = bind(new ResourceLocation(XOres.MOD_ID, "wood"));
	
	/**
	 * {@link TagKey} tag for all leather armors
	 */
	public static final TagKey<Item> LEATHER = bind(new ResourceLocation(XOres.MOD_ID, "leather"));
	
	/**
	 * {@link TagKey} tag for all stone tools 
	 */
	public static final TagKey<Item> STONE = bind(new ResourceLocation(XOres.MOD_ID, "stone"));
	
	/**
	 * {@link TagKey} tag for all chainmail armors
	 */
	public static final TagKey<Item> CHAINMAIL = bind(new ResourceLocation(XOres.MOD_ID, "chainmail"));
	
	/**
	 * {@link TagKey} tag for all copper stuff
	 */
	public static final TagKey<Item> COPPER = bind(new ResourceLocation(XOres.MOD_ID, "copper"));
	
	/**
	 * {@link TagKey} tag for all golden tools and armors
	 */
	public static final TagKey<Item> GOLDEN = bind(new ResourceLocation(XOres.MOD_ID, "golden"));
	
	/**
	 * {@link TagKey} tag for all iron tools and armor {@link Item}s
	 */
	public static final TagKey<Item> IRON = bind(new ResourceLocation(XOres.MOD_ID, "iron"));
	
	/**
	 * {@link TagKey} tag for all diamond tools and armors 
	 */
	public static final TagKey<Item> DIAMOND = bind(new ResourceLocation(XOres.MOD_ID, "diamond"));
	
	/**
	 * {@link TagKey} tag for all netherite tools and armors 
	 */
	public static final TagKey<Item> NETHERITE = bind(new ResourceLocation(XOres.MOD_ID, "netherite"));
	
	/**
	 * {@link TagKey} tag for all jade tools and armors 
	 */
	public static final TagKey<Item> JADE = bind(new ResourceLocation(XOres.MOD_ID, "jade"));
	
	/**
	 * {@link TagKey} tag for all blazing tools and armors 
	 */
	public static final TagKey<Item> BLAZING = bind(new ResourceLocation(XOres.MOD_ID, "blazing"));
	
	/**
	 * {@link TagKey} tag for all saphire tools and armors 
	 */
	public static final TagKey<Item> SAPHIRE = bind(new ResourceLocation(XOres.MOD_ID, "saphire"));
	
	/**
	 * {@link TagKey} tag for all limonite tools and armors 
	 */
	public static final TagKey<Item> LIMONITE = bind(new ResourceLocation(XOres.MOD_ID, "limonite"));
	
	/**
	 * {@link TagKey} tag for all rosite tools and armors 
	 */
	public static final TagKey<Item> ROSITE = bind(new ResourceLocation(XOres.MOD_ID, "rosite"));
	
	/**
	 * {@link TagKey} tag for all rose quartz tools and armors 
	 */
	public static final TagKey<Item> ROSE_QUARTZ = bind(new ResourceLocation(XOres.MOD_ID, "rose_quartz"));
	
	/**
	 * {@link TagKey} tag for all enderite tools and armors 
	 */
	public static final TagKey<Item> ENDERITE = bind(new ResourceLocation(XOres.MOD_ID, "enderite"));
	
	/**
	 * {@link TagKey} tag for all steel tools and armors 
	 */
	public static final TagKey<Item> STEEL = bind(new ResourceLocation(XOres.MOD_ID, "steel"));
	
	/**
	 * {@link TagKey} tag for all night tools and armors 
	 */
	public static final TagKey<Item> NIGHT = bind(new ResourceLocation(XOres.MOD_ID, "night"));
	
	/**
	 * {@link TagKey} tag for all jade ores
	 */
	public static final TagKey<Item> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
	
	/**
	 * {@link TagKey} tag for all saphire ores
	 */
	public static final TagKey<Item> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
	
	/**
	 * {@link TagKey} tag for all limonite ores
	 */
	public static final TagKey<Item> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
	
	/**
	 * {@link TagKey} tag for all rosite ores
	 */
	public static final TagKey<Item> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
	
	/**
	 * {@link TagKey} tag for all enderite ores
	 */
	public static final TagKey<Item> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
	
	/**
	 * {@link TagKey} tag for all ore blocks
	 */
	public static final TagKey<Item> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
	
	/**
	 * {@link TagKey} tag for all swords
	 */
	public static final TagKey<Item> SWORDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/sword"));
	
	/**
	 * {@link TagKey} tag for all shields
	 */
	public static final TagKey<Item> SHIELDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/shield"));
	
	/**
	 * {@link TagKey} tag for all bows
	 */
	public static final TagKey<Item> BOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/bow"));
	
	/**
	 * {@link TagKey} tag for all crossbows
	 */
	public static final TagKey<Item> CROSSBOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/crossbow"));
	
	/**
	 * {@link TagKey} tag for all pickaxes
	 */
	public static final TagKey<Item> PICKAXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/pickaxe"));
	
	/**
	 * {@link TagKey} tag for all axes
	 */
	public static final TagKey<Item> AXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/axe"));
	
	/**
	 * {@link TagKey} tag for all shovels
	 */
	public static final TagKey<Item> SHOVELS = bind(new ResourceLocation(XOres.MOD_ID, "tools/shovel"));
	
	/**
	 * {@link TagKey} tag for all hoes
	 */
	public static final TagKey<Item> HOES = bind(new ResourceLocation(XOres.MOD_ID, "tools/hoe"));
	
	/**
	 * {@link TagKey} tag for all {@link ArmorItem}s
	 */
	public static final TagKey<Item> ARMOR = bind(new ResourceLocation(XOres.MOD_ID, "armors/armor"));
	
	/**
	 * {@link TagKey} tag for all helmets
	 */
	public static final TagKey<Item> HELMETS = bind(new ResourceLocation(XOres.MOD_ID, "armors/helmet"));
	
	/**
	 * {@link TagKey} tag for all chestplates
	 */
	public static final TagKey<Item> CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/chestplate"));
	
	/**
	 * {@link TagKey} tag for all elytra chestplates
	 */
	public static final TagKey<Item> ELYTRA_CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/elytra_chestplate"));
	
	/**
	 * {@link TagKey} tag for all leggings
	 */
	public static final TagKey<Item> LEGGINGS = bind(new ResourceLocation(XOres.MOD_ID, "armors/leggings"));
	
	/**
	 * {@link TagKey} tag for all boots
	 */
	public static final TagKey<Item> BOOTS = bind(new ResourceLocation(XOres.MOD_ID, "armors/boots"));
	
	/**
	 * {@link TagKey} tag for all scraps
	 */
	public static final TagKey<Item> SCRAPS = bind(new ResourceLocation(XOres.MOD_ID, "scraps"));
	
	/**
	 * {@link TagKey} tag for all stones
	 */
	public static final TagKey<Item> STONES = bind(new ResourceLocation(XOres.MOD_ID, "stones"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 0
	 */
	public static final TagKey<Item> TOOL_LEVEL_0 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_0"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 1
	 */
	public static final TagKey<Item> TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_1"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 2
	 */
	public static final TagKey<Item> TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_2"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 3
	 */
	public static final TagKey<Item> TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_3"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 4
	 */
	public static final TagKey<Item> TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "tool_level_4"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 5
	 */
	public static final TagKey<Item> TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
	
	/**
	 * {@link TagKey} tag for {@link Item}s that needs tool level 6
	 */
	public static final TagKey<Item> TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
	
	/**
	 * bind a {@link TagKey} tag to the {@link ResourceLocation}
	 * @param name The name of the {@link TagKey} tag as an {@link ResourceLocation}
	 * @return the {@link TagKey} tag for the given name
	 */
	protected static TagKey<Item> bind(ResourceLocation location) {
		return ItemTags.create(location);
	}
	
}
