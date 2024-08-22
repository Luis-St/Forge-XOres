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

package net.luis.xores.data.provider.level;

import com.google.common.collect.Lists;
import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

public class XOPlacedFeatureProvider {
	
	public static final PlacementModifier RANGE_64_48 = HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48));
	public static final PlacementModifier RANGE_144_16 = HeightRangePlacement.triangle(triangleMinGeneration(16), VerticalAnchor.absolute(16));
	public static final PlacementModifier RANGE_8_24 = HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(24));
	
	public static void create(@NotNull BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> registry = context.lookup(Registries.CONFIGURED_FEATURE);
		context.register(XOOrePlacements.JADE_ORE_UPPER, new PlacedFeature(registry.getOrThrow(XOOreFeatures.JADE_ORE_UPPER), upperOrePlacement(20, 128)));
		context.register(XOOrePlacements.JADE_ORE_MIDDLE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.JADE_ORE_MIDDLE), uniformOrePlacement(14, -32, 96)));
		context.register(XOOrePlacements.SAPHIRE_ORE_RARE_UPPER, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE_RARE_UPPER), upperOrePlacement(7, 256)));
		context.register(XOOrePlacements.SAPHIRE_ORE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE), uniformOrePlacement(18, -64, 256)));
		context.register(XOOrePlacements.SAPHIRE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE_BURIED), buriedOrePlacement(5, -32)));
		context.register(XOOrePlacements.LIMONITE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.LIMONITE_ORE_BURIED), uniformOrePlacement(5, -48, 0)));
		context.register(XOOrePlacements.LIMONITE_ORE_DEEP_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.LIMONITE_ORE_DEEP_BURIED), buriedOrePlacement(2, -48)));
		context.register(XOOrePlacements.ENDERITE_ORE_RARE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.ENDERITE_ORE_RARE), uniformOrePlacement(2, 0, 128)));
		context.register(XOOrePlacements.ENDERITE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.ENDERITE_ORE_BURIED), buriedEndOrePlacement(3)));
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightPlacement) {
		return Lists.newArrayList(countPlacement, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> triangleOrePlacement(int count, int min, int max) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(min), VerticalAnchor.absolute(max)));
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), triangleMaxGeneration(minGeneration)));
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(triangleMinGeneration(maxGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	public static @Unmodifiable @NotNull List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	public static @NotNull VerticalAnchor triangleMaxGeneration(int minGeneration) {
		return VerticalAnchor.absolute(320 + (320 - minGeneration));
	}
	
	public static @NotNull VerticalAnchor triangleMinGeneration(int maxGeneration) {
		return VerticalAnchor.absolute((64 + maxGeneration) * -1 - 64);
	}
}
