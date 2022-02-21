package net.luis.xores.init;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * registration class for all mod {@link Named} tags
 * 
 * @author Luis-st
 */

public class ModTags {
	
	/**
	 * registration sub-class for all mod {@link Block} {@link Named} tags
	 * 
	 * @author Luis-st
	 */
	public static class Blocks {
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 1
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_1"));
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 2
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_2"));
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 3
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_3"));
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 4
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_4"));
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 5
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
		
		/**
		 * {@link Named} tag for {@link Block}s that needs tool level 6
		 */
		public static final Tag.Named<Block> NEEDS_TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
		
		/**
		 * {@link Named} tag for all jade ores
		 */
		public static final Tag.Named<Block> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
		
		/**
		 * {@link Named} tag for all saphire ores
		 */
		public static final Tag.Named<Block> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
		
		/**
		 * {@link Named} tag for all limonite ores
		 */
		public static final Tag.Named<Block> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
		
		/**
		 * {@link Named} tag for all rosite ores
		 */
		public static final Tag.Named<Block> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
		
		/**
		 * {@link Named} tag for all enderite ores
		 */
		public static final Tag.Named<Block> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
		
		/**
		 * {@link Named} tag for all ore blocks
		 */
		public static final Tag.Named<Block> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
		
		/**
		 * {@link Named} tag for all end base stones
		 */
		public static final Tag.Named<Block> BASE_STONE_END = bind(new ResourceLocation(XOres.MOD_ID, "base_stone_end"));
		
		/**
		 * {@link Named} tag for all stones
		 */
		public static final Tag.Named<Block> STONES = bind(new ResourceLocation(XOres.MOD_ID, "stones"));
		
		/**
		 * bind a {@link Named} tag to the {@link ResourceLocation}
		 * @param name The name of the {@link Named} tag as an {@link ResourceLocation}
		 * @return the {@link Named} tag for the given name
		 */
		protected static Tag.Named<Block> bind(ResourceLocation name) {
			return BlockTags.bind(name.toString());
		}
		
	}
	
	/**
	 * registration sub-class for all mod {@link Item} {@link Named} tags
	 * 
	 * @author Luis-st
	 */
	public static class Items {

		/**
		 * {@link Named} tag for all wood tools
		 */
		public static final Tag.Named<Item> WOOD = bind(new ResourceLocation(XOres.MOD_ID, "wood"));
		
		/**
		 * {@link Named} tag for all leather armors
		 */
		public static final Tag.Named<Item> LEATHER = bind(new ResourceLocation(XOres.MOD_ID, "leather"));
		
		/**
		 * {@link Named} tag for all stone tools 
		 */
		public static final Tag.Named<Item> STONE = bind(new ResourceLocation(XOres.MOD_ID, "stone"));
		
		/**
		 * {@link Named} tag for all chainmail armors
		 */
		public static final Tag.Named<Item> CHAINMAIL = bind(new ResourceLocation(XOres.MOD_ID, "chainmail"));
		
		/**
		 * {@link Named} tag for all copper stuff
		 */
		public static final Tag.Named<Item> COPPER = bind(new ResourceLocation(XOres.MOD_ID, "copper"));
		
		/**
		 * {@link Named} tag for all golden tools and armors
		 */
		public static final Tag.Named<Item> GOLDEN = bind(new ResourceLocation(XOres.MOD_ID, "golden"));
		
		/**
		 * {@link Named} tag for all iron tools and armor {@link Item}s
		 */
		public static final Tag.Named<Item> IRON = bind(new ResourceLocation(XOres.MOD_ID, "iron"));
		
		/**
		 * {@link Named} tag for all diamond tools and armors 
		 */
		public static final Tag.Named<Item> DIAMOND = bind(new ResourceLocation(XOres.MOD_ID, "diamond"));
		
		/**
		 * {@link Named} tag for all netherite tools and armors 
		 */
		public static final Tag.Named<Item> NETHERITE = bind(new ResourceLocation(XOres.MOD_ID, "netherite"));
		
		/**
		 * {@link Named} tag for all jade tools and armors 
		 */
		public static final Tag.Named<Item> JADE = bind(new ResourceLocation(XOres.MOD_ID, "jade"));
		
		/**
		 * {@link Named} tag for all blazing tools and armors 
		 */
		public static final Tag.Named<Item> BLAZING = bind(new ResourceLocation(XOres.MOD_ID, "blazing"));
		
		/**
		 * {@link Named} tag for all saphire tools and armors 
		 */
		public static final Tag.Named<Item> SAPHIRE = bind(new ResourceLocation(XOres.MOD_ID, "saphire"));
		
		/**
		 * {@link Named} tag for all limonite tools and armors 
		 */
		public static final Tag.Named<Item> LIMONITE = bind(new ResourceLocation(XOres.MOD_ID, "limonite"));
		
		/**
		 * {@link Named} tag for all rosite tools and armors 
		 */
		public static final Tag.Named<Item> ROSITE = bind(new ResourceLocation(XOres.MOD_ID, "rosite"));
		
		/**
		 * {@link Named} tag for all rose quartz tools and armors 
		 */
		public static final Tag.Named<Item> ROSE_QUARTZ = bind(new ResourceLocation(XOres.MOD_ID, "rose_quartz"));
		
		/**
		 * {@link Named} tag for all enderite tools and armors 
		 */
		public static final Tag.Named<Item> ENDERITE = bind(new ResourceLocation(XOres.MOD_ID, "enderite"));
		
		/**
		 * {@link Named} tag for all steel tools and armors 
		 */
		public static final Tag.Named<Item> STEEL = bind(new ResourceLocation(XOres.MOD_ID, "steel"));
		
		/**
		 * {@link Named} tag for all night tools and armors 
		 */
		public static final Tag.Named<Item> NIGHT = bind(new ResourceLocation(XOres.MOD_ID, "night"));
		
		/**
		 * {@link Named} tag for all jade ores
		 */
		public static final Tag.Named<Item> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
		
		/**
		 * {@link Named} tag for all saphire ores
		 */
		public static final Tag.Named<Item> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
		
		/**
		 * {@link Named} tag for all limonite ores
		 */
		public static final Tag.Named<Item> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
		
		/**
		 * {@link Named} tag for all rosite ores
		 */
		public static final Tag.Named<Item> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
		
		/**
		 * {@link Named} tag for all enderite ores
		 */
		public static final Tag.Named<Item> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
		
		/**
		 * {@link Named} tag for all ore blocks
		 */
		public static final Tag.Named<Item> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
		
		/**
		 * {@link Named} tag for all swords
		 */
		public static final Tag.Named<Item> SWORDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/sword"));
		
		/**
		 * {@link Named} tag for all shields
		 */
		public static final Tag.Named<Item> SHIELDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/shield"));
		
		/**
		 * {@link Named} tag for all bows
		 */
		public static final Tag.Named<Item> BOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/bow"));
		
		/**
		 * {@link Named} tag for all crossbows
		 */
		public static final Tag.Named<Item> CROSSBOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/crossbow"));
		
		/**
		 * {@link Named} tag for all pickaxes
		 */
		public static final Tag.Named<Item> PICKAXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/pickaxe"));
		
		/**
		 * {@link Named} tag for all axes
		 */
		public static final Tag.Named<Item> AXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/axe"));
		
		/**
		 * {@link Named} tag for all shovels
		 */
		public static final Tag.Named<Item> SHOVELS = bind(new ResourceLocation(XOres.MOD_ID, "tools/shovel"));
		
		/**
		 * {@link Named} tag for all hoes
		 */
		public static final Tag.Named<Item> HOES = bind(new ResourceLocation(XOres.MOD_ID, "tools/hoe"));
		
		/**
		 * {@link Named} tag for all {@link ArmorItem}s
		 */
		public static final Tag.Named<Item> ARMOR = bind(new ResourceLocation(XOres.MOD_ID, "armors/armor"));
		
		/**
		 * {@link Named} tag for all helmets
		 */
		public static final Tag.Named<Item> HELMETS = bind(new ResourceLocation(XOres.MOD_ID, "armors/helmet"));
		
		/**
		 * {@link Named} tag for all chestplates
		 */
		public static final Tag.Named<Item> CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/chestplate"));
		
		/**
		 * {@link Named} tag for all elytra chestplates
		 */
		public static final Tag.Named<Item> ELYTRA_CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/elytra_chestplate"));
		
		/**
		 * {@link Named} tag for all leggings
		 */
		public static final Tag.Named<Item> LEGGINGS = bind(new ResourceLocation(XOres.MOD_ID, "armors/leggings"));
		
		/**
		 * {@link Named} tag for all boots
		 */
		public static final Tag.Named<Item> BOOTS = bind(new ResourceLocation(XOres.MOD_ID, "armors/boots"));
		
		/**
		 * {@link Named} tag for all scraps
		 */
		public static final Tag.Named<Item> SCRAPS = bind(new ResourceLocation(XOres.MOD_ID, "scraps"));
		
		/**
		 * {@link Named} tag for all stones
		 */
		public static final Tag.Named<Item> STONES = bind(new ResourceLocation(XOres.MOD_ID, "stones"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 0
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_0 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_0"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 1
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_1 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_1"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 2
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_2"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 3
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_3"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 4
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_4"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 5
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_5"));
		
		/**
		 * {@link Named} tag for {@link Item}s that needs tool level 6
		 */
		public static final Tag.Named<Item> TOOL_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "needs_tool_level_6"));
		
		/**
		 * bind a {@link Named} tag to the {@link ResourceLocation}
		 * @param name The name of the {@link Named} tag as an {@link ResourceLocation}
		 * @return the {@link Named} tag for the given name
		 */
		protected static Tag.Named<Item> bind(ResourceLocation name) {
			return ItemTags.bind(name.toString());
		}
		
	}
	
}
