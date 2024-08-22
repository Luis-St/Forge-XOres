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
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockTags {
	
	public static final TagKey<Block> JADE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/jade_ore"));
	public static final TagKey<Block> SAPHIRE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/saphire_ore"));
	public static final TagKey<Block> LIMONITE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/limonite_ore"));
	public static final TagKey<Block> ENDERITE_ORES = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ores/enderite_ore"));
	public static final TagKey<Block> ORE_BLOCKS = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "ore_blocks"));
	
	public static final TagKey<Block> INCORRECT_FOR_ENDERITE_TOOL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "incorrect_for_enderite_tool"));
	public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "incorrect_for_steel_tool"));
	
	public static final TagKey<Block> NEEDS_ENDERITE_TOOL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "needs_enderite_tool"));
	public static final TagKey<Block> NEEDS_STEEL_TOOL = bind(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "needs_steel_tool"));
	
	public static void register() {}
	
	private static @NotNull TagKey<Block> bind(@NotNull ResourceLocation location) {
		return BlockTags.create(location);
	}
}
