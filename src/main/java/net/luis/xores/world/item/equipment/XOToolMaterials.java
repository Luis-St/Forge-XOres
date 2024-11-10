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

package net.luis.xores.world.item.equipment;

import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;

/**
 *
 * @author Luis-St
 *
 */

public interface XOToolMaterials {
	
	ToolMaterial JADE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 190, 5.0F, 5.0F, 28, XOItems.Tags.REPAIRS_JADE_TOOLS);
	ToolMaterial BLAZING = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 905, 7.0F, 6.0F, 12, XOItems.Tags.REPAIRS_BLAZING_TOOLS);
	ToolMaterial SAPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1718, 8.0F, 8.0F, 42, XOItems.Tags.REPAIRS_SAPHIRE_TOOLS);
	ToolMaterial LIMONITE = new ToolMaterial(XOBlocks.Tags.INCORRECT_FOR_ENDERITE_TOOL, 3178, 10.0F, 10.0F, 26, XOItems.Tags.REPAIRS_LIMONITE_TOOLS);
	ToolMaterial ROSE_QUARTZ = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 7693, 11.0F, 12.0F, 17, XOItems.Tags.REPAIRS_ROSE_QUARTZ_TOOLS);
	ToolMaterial ENDERITE = new ToolMaterial(XOBlocks.Tags.INCORRECT_FOR_ENDERITE_TOOL, 10770, 14.0F, 16.0F, 18, XOItems.Tags.REPAIRS_ENDERITE_TOOLS);
	ToolMaterial STEEL = new ToolMaterial(XOBlocks.Tags.INCORRECT_FOR_STEEL_TOOL, 12924, 18.0F, 5.0F, 9, XOItems.Tags.REPAIRS_STEEL_TOOLS);
	ToolMaterial NIGHT = new ToolMaterial(XOBlocks.Tags.INCORRECT_FOR_ENDERITE_TOOL, 16801, 15.0F, 19.0F, 56, XOItems.Tags.REPAIRS_NIGHT_TOOLS);
	
	static void register() {}
}
