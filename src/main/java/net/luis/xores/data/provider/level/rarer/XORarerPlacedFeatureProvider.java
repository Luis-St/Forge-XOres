package net.luis.xores.data.provider.level.rarer;

import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.luis.xores.data.provider.level.XOPlacedFeatureProvider.*;

/**
 *
 * @author Luis-St
 *
 */

public class XORarerPlacedFeatureProvider {
	
	public static void create(@NotNull BootstapContext<PlacedFeature> context) {
	    createVanilla(context);
		createXOres(context);
	}
	
	private static void createVanilla(@NotNull BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> registry = context.lookup(Registries.CONFIGURED_FEATURE);
		context.register(OrePlacements.ORE_COAL_UPPER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_COAL), uniformOrePlacement(25, 136, 320))); // 30, 136, 320
		context.register(OrePlacements.ORE_COAL_LOWER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_COAL_BURIED), triangleOrePlacement(17, 0, 192))); // 20, 0, 192
		context.register(OrePlacements.ORE_COPPER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_COPPPER_SMALL), triangleOrePlacement(13, -16, 112))); // 16, -16, 112
		context.register(OrePlacements.ORE_COPPER_LARGE, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_COPPER_LARGE), triangleOrePlacement(13, -16, 112))); // 16, -16, 112
		context.register(OrePlacements.ORE_IRON_UPPER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_IRON), triangleOrePlacement(75, 80, 384))); // 90, 80, 384
		context.register(OrePlacements.ORE_IRON_MIDDLE, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_IRON), triangleOrePlacement(9, -24, 56))); // 10, -24, 56
		context.register(OrePlacements.ORE_IRON_SMALL, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_IRON_SMALL), uniformOrePlacement(8, -64, 72))); // 10, -64, 72
		context.register(OrePlacements.ORE_GOLD, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_GOLD), triangleOrePlacement(3, -64, 32))); // 4, -64, 32
		context.register(OrePlacements.ORE_GOLD_EXTRA, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_GOLD_BURIED), uniformOrePlacement(42, 32, 256))); // 50, 32, 256
		context.register(OrePlacements.ORE_GOLD_LOWER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_GOLD_BURIED), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), RANGE_64_48)));
		context.register(OrePlacements.ORE_LAPIS, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_LAPIS), triangleOrePlacement(2, -32, 32))); // 2, -32, 32
		context.register(OrePlacements.ORE_LAPIS_BURIED, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_LAPIS_BURIED), uniformOrePlacement(3, -64, 64))); // 4, -64, 64
		context.register(OrePlacements.ORE_REDSTONE, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_REDSTONE), uniformOrePlacement(4, -64, 16))); // 4, -64, 15
		context.register(OrePlacements.ORE_REDSTONE_LOWER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_REDSTONE), buriedOrePlacement(6, -32))); // 8, -32
		context.register(OrePlacements.ORE_DIAMOND, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_DIAMOND_SMALL), buriedOrePlacement(6, 16))); // 7, 16
		context.register(OrePlacements.ORE_DIAMOND_MEDIUM, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_DIAMOND_MEDIUM), uniformOrePlacement(1, -64, -4))); // 2, -64, -4
		context.register(OrePlacements.ORE_DIAMOND_LARGE, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_DIAMOND_LARGE), orePlacement(RarityFilter.onAverageOnceEvery(10), RANGE_144_16))); // 9
		context.register(OrePlacements.ORE_DIAMOND_BURIED, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_DIAMOND_BURIED), buriedOrePlacement(4, 16))); // 4, 16
		context.register(OrePlacements.ORE_EMERALD, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_EMERALD), triangleOrePlacement(85, -16, 480))); // 100, -16, 480
		context.register(OrePlacements.ORE_GOLD_NETHER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_NETHER_GOLD), orePlacement(CountPlacement.of(9), PlacementUtils.RANGE_10_10))); // 10
		context.register(OrePlacements.ORE_GOLD_DELTAS, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_NETHER_GOLD), orePlacement(CountPlacement.of(17), PlacementUtils.RANGE_10_10))); // 20
		context.register(OrePlacements.ORE_QUARTZ_NETHER, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_QUARTZ), orePlacement(CountPlacement.of(13), PlacementUtils.RANGE_10_10))); // 16
		context.register(OrePlacements.ORE_QUARTZ_DELTAS, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_QUARTZ), orePlacement(CountPlacement.of(24), PlacementUtils.RANGE_10_10))); // 32
		context.register(OrePlacements.ORE_ANCIENT_DEBRIS_SMALL, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_ANCIENT_DEBRIS_SMALL), List.of(InSquarePlacement.spread(), PlacementUtils.RANGE_8_8, BiomeFilter.biome())));
		context.register(OrePlacements.ORE_ANCIENT_DEBRIS_LARGE, new PlacedFeature(registry.getOrThrow(OreFeatures.ORE_ANCIENT_DEBRIS_LARGE), List.of(InSquarePlacement.spread(), RANGE_8_24, BiomeFilter.biome())));
	}
	
	private static void createXOres(@NotNull BootstapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> registry = context.lookup(Registries.CONFIGURED_FEATURE);
		context.register(XOOrePlacements.JADE_ORE_UPPER, new PlacedFeature(registry.getOrThrow(XOOreFeatures.JADE_ORE_UPPER), upperOrePlacement(15, 128))); // 20, 128
		context.register(XOOrePlacements.JADE_ORE_MIDDLE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.JADE_ORE_MIDDLE), uniformOrePlacement(10, -32, 96))); // 14, -32, 96
		context.register(XOOrePlacements.SAPHIRE_ORE_RARE_UPPER, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE_RARE_UPPER), upperOrePlacement(6, 256))); // 7, 256
		context.register(XOOrePlacements.SAPHIRE_ORE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE), uniformOrePlacement(14, -64, 256))); // 18, -64, 256
		context.register(XOOrePlacements.SAPHIRE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.SAPHIRE_ORE_BURIED), buriedOrePlacement(4, -32))); // 5, -32
		context.register(XOOrePlacements.LIMONITE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.LIMONITE_ORE_BURIED), uniformOrePlacement(5, -48, 0))); // 5, -48, 0
		context.register(XOOrePlacements.LIMONITE_ORE_DEEP_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.LIMONITE_ORE_DEEP_BURIED), buriedOrePlacement(1, -48))); // 2, -48
		context.register(XOOrePlacements.ENDERITE_ORE_RARE, new PlacedFeature(registry.getOrThrow(XOOreFeatures.ENDERITE_ORE_RARE), uniformOrePlacement(2, 0, 128))); // 2, 0, 128
		context.register(XOOrePlacements.ENDERITE_ORE_BURIED, new PlacedFeature(registry.getOrThrow(XOOreFeatures.ENDERITE_ORE_BURIED), triangleOrePlacement(2, 0, 128))); // 3, 0, 128
	}
}
