package net.luis.xores.data.provider.level.very;

import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import org.jetbrains.annotations.NotNull;

import static net.luis.xores.data.provider.level.XOConfiguredFeatureProvider.*;

/**
 *
 * @author Luis-St
 *
 */

public class XOVeryRareConfiguredFeatureProvider {
	
	public static void create(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context) {
		createVanilla(context);
		createXOres(context);
	}
	
	private static void createVanilla(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(OreFeatures.ORE_COAL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COAL_ORE_TARGETS.get(), 9))); // 17
		context.register(OreFeatures.ORE_COAL_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COAL_ORE_TARGETS.get(), 12, 0.8F))); // 17, 0.5
		context.register(OreFeatures.ORE_COPPPER_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COPPER_ORE_TARGETS.get(), 5))); // 10
		context.register(OreFeatures.ORE_COPPER_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(COPPER_ORE_TARGETS.get(), 10))); // 20
		context.register(OreFeatures.ORE_IRON, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(IRON_ORE_TARGETS.get(), 5))); // 9
		context.register(OreFeatures.ORE_IRON_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(IRON_ORE_TARGETS.get(), 2))); // 4
		context.register(OreFeatures.ORE_GOLD, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GOLD_ORE_TARGETS.get(), 5))); // 9
		context.register(OreFeatures.ORE_GOLD_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(GOLD_ORE_TARGETS.get(), 6, 0.8F))); // 9, 0.5
		context.register(OreFeatures.ORE_LAPIS, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LAPIS_ORE_TARGETS.get(), 4))); // 7
		context.register(OreFeatures.ORE_LAPIS_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LAPIS_ORE_TARGETS.get(), 4, 1.0F))); // 7, 1.0
		context.register(OreFeatures.ORE_REDSTONE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(REDSTONE_ORE_TARGETS.get(), 4))); // 8
		context.register(OreFeatures.ORE_DIAMOND_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_ORE_TARGETS.get(), 3, 0.7F))); // 4, 0.5
		context.register(OreFeatures.ORE_DIAMOND_MEDIUM, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_ORE_TARGETS.get(), 4, 0.7F))); // 8, 0.5
		context.register(OreFeatures.ORE_DIAMOND_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_ORE_TARGETS.get(), 8, 0.9F))); // 12, 0.7
		context.register(OreFeatures.ORE_DIAMOND_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DIAMOND_ORE_TARGETS.get(), 4, 1.0F))); // 8 1.0
		context.register(OreFeatures.ORE_EMERALD, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(EMERALD_ORE_TARGETS.get(), 2))); // 3
		context.register(OreFeatures.ORE_NETHER_GOLD, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHERRACK, Blocks.NETHER_GOLD_ORE.defaultBlockState(), 5))); // 10
		context.register(OreFeatures.ORE_QUARTZ, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHERRACK, Blocks.NETHER_QUARTZ_ORE.defaultBlockState(), 7))); // 14
		context.register(OreFeatures.ORE_ANCIENT_DEBRIS_SMALL, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState(), 1, 1.0F))); // 2, 1.0
		context.register(OreFeatures.ORE_ANCIENT_DEBRIS_LARGE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BASE_STONE_NETHER, Blocks.ANCIENT_DEBRIS.defaultBlockState(), 2, 1.0F))); // 3, 1.0
	}
	
	private static void createXOres(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(XOOreFeatures.JADE_ORE_UPPER, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 3))); // 5
		context.register(XOOreFeatures.JADE_ORE_MIDDLE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 4))); // 7
		context.register(XOOreFeatures.SAPHIRE_ORE_RARE_UPPER, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 1))); // 2
		context.register(XOOreFeatures.SAPHIRE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 3, 0.4F))); // 5, 0.0
		context.register(XOOreFeatures.SAPHIRE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 4, 1.0F))); // 7, 1.0
		context.register(XOOreFeatures.LIMONITE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 2, 0.75F))); // 4, 0.5
		context.register(XOOreFeatures.LIMONITE_ORE_DEEP_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 5, 1.0F))); // 10, 1.0
		context.register(XOOreFeatures.ENDERITE_ORE_RARE, new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 1, 0.4F))); // 1, 0.0
		context.register(XOOreFeatures.ENDERITE_ORE_BURIED, new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 2, 1.0F))); // 3, 1.0
	}
}
