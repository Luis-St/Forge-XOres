/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.tags;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOItemTags {
	
	public static final TagKey<Item> WOOD = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "wood"));
	public static final TagKey<Item> LEATHER = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "leather"));
	public static final TagKey<Item> STONE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "stone"));
	public static final TagKey<Item> CHAINMAIL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "chainmail"));
	public static final TagKey<Item> COPPER = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "copper"));
	public static final TagKey<Item> GOLDEN = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "golden"));
	public static final TagKey<Item> IRON = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "iron"));
	public static final TagKey<Item> DIAMOND = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "diamond"));
	public static final TagKey<Item> NETHERITE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "netherite"));
	public static final TagKey<Item> JADE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "jade"));
	public static final TagKey<Item> BLAZING = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "blazing"));
	public static final TagKey<Item> SAPHIRE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "saphire"));
	public static final TagKey<Item> LIMONITE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "limonite"));
	public static final TagKey<Item> ROSE_QUARTZ = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "rose_quartz"));
	public static final TagKey<Item> ENDERITE = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "enderite"));
	public static final TagKey<Item> STEEL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "steel"));
	public static final TagKey<Item> NIGHT = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "night"));
	
	public static final TagKey<Item> JADE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/jade_ore"));
	public static final TagKey<Item> SAPHIRE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/saphire_ore"));
	public static final TagKey<Item> LIMONITE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/limonite_ore"));
	public static final TagKey<Item> ENDERITE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/enderite_ore"));
	public static final TagKey<Item> ORE_BLOCKS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ore_blocks"));
	
	public static final TagKey<Item> SHIELDS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "weapons/shield"));
	public static final TagKey<Item> BOWS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "weapons/bow"));
	public static final TagKey<Item> CROSSBOWS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "weapons/crossbow"));
	
	public static final TagKey<Item> ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "armors/armor"));
	public static final TagKey<Item> ELYTRA_CHESTPLATES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "armors/elytra_chestplate"));
	
	public static final TagKey<Item> REPAIRS_JADE_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_jade_armor"));
	public static final TagKey<Item> REPAIRS_BLAZING_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_blazing_armor"));
	public static final TagKey<Item> REPAIRS_SAPHIRE_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_saphire_armor"));
	public static final TagKey<Item> REPAIRS_LIMONITE_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_limonite_armor"));
	public static final TagKey<Item> REPAIRS_ENDERITE_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_enderite_armor"));
	public static final TagKey<Item> REPAIRS_NIGHT_ARMOR = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_night_armor"));
	
	public static final TagKey<Item> REPAIRS_JADE_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_jade_tools"));
	public static final TagKey<Item> REPAIRS_BLAZING_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_blazing_tools"));
	public static final TagKey<Item> REPAIRS_SAPHIRE_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_saphire_tools"));
	public static final TagKey<Item> REPAIRS_LIMONITE_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_limonite_tools"));
	public static final TagKey<Item> REPAIRS_ROSE_QUARTZ_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_rose_quartz_tools"));
	public static final TagKey<Item> REPAIRS_ENDERITE_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_enderite_tools"));
	public static final TagKey<Item> REPAIRS_STEEL_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_steel_tools"));
	public static final TagKey<Item> REPAIRS_NIGHT_TOOLS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "repairs_night_tools"));
	
	public static final TagKey<Item> SCRAPS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "scraps"));
	
	public static void register() {}
	
	private static @NotNull TagKey<Item> bind(@NotNull ResourceLocation location) {
		return ItemTags.create(location);
	}
}
