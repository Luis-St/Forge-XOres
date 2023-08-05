package net.luis.xores.data.provider.level;

import com.google.common.collect.Lists;
import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

public class XOPlacedFeatureProvider {
	
	public static void create(@NotNull BootstapContext<PlacedFeature> context) {
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
	
	private static @NotNull List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightPlacement) {
		return Lists.newArrayList(countPlacement, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}
	
	private static @NotNull List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), triangleMaxGeneration(minGeneration)));
	}
	
	private static @NotNull List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(triangleMinGeneration(maxGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	private static @NotNull List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	private static @NotNull List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	private static @NotNull VerticalAnchor triangleMaxGeneration(int minGeneration) {
		return VerticalAnchor.absolute(320 + (320 - minGeneration));
	}
	
	private static @NotNull VerticalAnchor triangleMinGeneration(int maxGeneration) {
		return VerticalAnchor.absolute((64 + maxGeneration) * -1 - 64);
	}
}
