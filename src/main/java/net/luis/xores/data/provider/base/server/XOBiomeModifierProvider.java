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

package net.luis.xores.data.provider.base.server;

import net.luis.xores.world.level.biome.XOBiomeModifier;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOBiomeModifierProvider {
	
	public static void create(@NotNull BootstrapContext<BiomeModifier> context) {
		HolderGetter<PlacedFeature> featureRegistry = context.lookup(Registries.PLACED_FEATURE);
		HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
		HolderSet<PlacedFeature> overworldFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.JADE_ORE_MIDDLE), featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE),
			featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE_BURIED), featureRegistry.getOrThrow(XOOrePlacements.LIMONITE_ORE_BURIED), featureRegistry.getOrThrow(XOOrePlacements.LIMONITE_ORE_DEEP_BURIED));
		HolderSet<PlacedFeature> peakFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.JADE_ORE_UPPER), featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE_RARE_UPPER));
		HolderSet<Biome> endBiomes = HolderSet.direct(biomeRegistry.getOrThrow(Biomes.END_HIGHLANDS), biomeRegistry.getOrThrow(Biomes.END_MIDLANDS), biomeRegistry.getOrThrow(Biomes.SMALL_END_ISLANDS),
			biomeRegistry.getOrThrow(Biomes.END_BARRENS));
		HolderSet<PlacedFeature> endFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.ENDERITE_ORE_RARE), featureRegistry.getOrThrow(XOOrePlacements.ENDERITE_ORE_BURIED));
		context.register(XOBiomeModifier.KEY, new XOBiomeModifier(biomeRegistry.getOrThrow(BiomeTags.IS_OVERWORLD), overworldFeatures, biomeRegistry.getOrThrow(Tags.Biomes.IS_MOUNTAIN_PEAK), peakFeatures, endBiomes, endFeatures));
	}
}
