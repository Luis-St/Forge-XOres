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

package net.luis.xores.data.provider.loottable;

import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockLootSubProvider extends BlockLootSubProvider {
	
	XOBlockLootSubProvider(HolderLookup. @NotNull Provider provider) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
	}
	
	@Override
	protected void generate() {
		for (Block block : XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.dropSelf(block);
		}
	}
	
	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
