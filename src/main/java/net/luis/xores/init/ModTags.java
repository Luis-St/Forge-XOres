package net.luis.xores.init;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
	
	public static class Blocks {
		public static final Tag.Named<Block> MINING_LEVEL_2 = bind(new ResourceLocation(XOres.MOD_ID, "mining/level_2"));
		public static final Tag.Named<Block> MINING_LEVEL_3 = bind(new ResourceLocation(XOres.MOD_ID, "mining/level_3"));
		public static final Tag.Named<Block> MINING_LEVEL_4 = bind(new ResourceLocation(XOres.MOD_ID, "mining/level_4"));
		public static final Tag.Named<Block> MINING_LEVEL_5 = bind(new ResourceLocation(XOres.MOD_ID, "mining/level_5"));
		public static final Tag.Named<Block> MINING_LEVEL_6 = bind(new ResourceLocation(XOres.MOD_ID, "mining/level_6"));
		
		// Ores
		public static final Tag.Named<Block> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
		public static final Tag.Named<Block> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
		public static final Tag.Named<Block> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
		public static final Tag.Named<Block> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
		public static final Tag.Named<Block> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
		public static final Tag.Named<Block> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
		
		public static final Tag.Named<Block> BASE_STONE_END = bind(new ResourceLocation(XOres.MOD_ID, "base_stone_end"));
		
		protected static Tag.Named<Block> bind(ResourceLocation location) {
			return BlockTags.bind(location.toString());
		}
	}
	
	public static class Items {
		public static final Tag.Named<Item> SCRAPS = bind(new ResourceLocation(XOres.MOD_ID, "scraps"));
		public static final Tag.Named<Item> SHARDS = bind(new ResourceLocation(XOres.MOD_ID, "shards"));
		
		public static final Tag.Named<Item> JADE = bind(new ResourceLocation(XOres.MOD_ID, "jade"));
		public static final Tag.Named<Item> BLAZING = bind(new ResourceLocation(XOres.MOD_ID, "blazing"));
		public static final Tag.Named<Item> SAPHIRE = bind(new ResourceLocation(XOres.MOD_ID, "saphire"));
		public static final Tag.Named<Item> LIMONITE = bind(new ResourceLocation(XOres.MOD_ID, "limonite"));
		public static final Tag.Named<Item> ROSITE = bind(new ResourceLocation(XOres.MOD_ID, "rosite"));
		public static final Tag.Named<Item> ROSE_QUARTZ = bind(new ResourceLocation(XOres.MOD_ID, "rose_quartz"));
		public static final Tag.Named<Item> ENDERITE = bind(new ResourceLocation(XOres.MOD_ID, "enderite"));
		public static final Tag.Named<Item> STEEL = bind(new ResourceLocation(XOres.MOD_ID, "steel"));
		public static final Tag.Named<Item> NIGHT = bind(new ResourceLocation(XOres.MOD_ID, "night"));
		
		// Ores
		public static final Tag.Named<Item> JADE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/jade_ore"));
		public static final Tag.Named<Item> SAPHIRE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/saphire_ore"));
		public static final Tag.Named<Item> LIMONITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/limonite_ore"));
		public static final Tag.Named<Item> ROSITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/rosite_ore"));
		public static final Tag.Named<Item> ENDERITE_ORES = bind(new ResourceLocation(XOres.MOD_ID, "ores/enderite_ore"));
		public static final Tag.Named<Item> ORE_BLOCKS = bind(new ResourceLocation(XOres.MOD_ID, "ore_blocks"));
		
		// Tools
		public static final Tag.Named<Item> PICKAXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/pickaxe"));
		public static final Tag.Named<Item> AXES = bind(new ResourceLocation(XOres.MOD_ID, "tools/axe"));
		public static final Tag.Named<Item> SHOVELS = bind(new ResourceLocation(XOres.MOD_ID, "tools/shovel"));
		public static final Tag.Named<Item> HOES = bind(new ResourceLocation(XOres.MOD_ID, "tools/hoe"));
		
		// Weapons
		public static final Tag.Named<Item> SWORDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/sword"));
		public static final Tag.Named<Item> SHIELDS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/shield"));
		public static final Tag.Named<Item> BOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/bow"));
		public static final Tag.Named<Item> CROSSBOWS = bind(new ResourceLocation(XOres.MOD_ID, "weapons/crossbow"));
		
		// Armor
		public static final Tag.Named<Item> ARMOR = bind(new ResourceLocation(XOres.MOD_ID, "armors/armor"));
		public static final Tag.Named<Item> HELMETS = bind(new ResourceLocation(XOres.MOD_ID, "armors/helmet"));
		public static final Tag.Named<Item> CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/chestplate"));
		public static final Tag.Named<Item> ELYTRA_CHESTPLATES = bind(new ResourceLocation(XOres.MOD_ID, "armors/elytra_chestplate"));
		public static final Tag.Named<Item> LEGGINGS = bind(new ResourceLocation(XOres.MOD_ID, "armors/leggings"));
		public static final Tag.Named<Item> BOOTS = bind(new ResourceLocation(XOres.MOD_ID, "armors/boots"));
		
		protected static Tag.Named<Item> bind(ResourceLocation location) {
			return ItemTags.bind(location.toString());
		}
	}
	
}
