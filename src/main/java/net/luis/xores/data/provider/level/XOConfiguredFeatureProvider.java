package net.luis.xores.data.provider.level;

import net.luis.xores.world.level.block.XOBlocks;
import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author Luis-st
 *
 */

public class XOConfiguredFeatureProvider {
	
	private static final RuleTest STONE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
	private static final RuleTest DEEPSLATE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
	private static final RuleTest END_STONE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES);
	
	private static final Supplier<List<OreConfiguration.TargetBlockState>> JADE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.JADE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
	};
	private static final Supplier<List<OreConfiguration.TargetBlockState>> LIMONITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.LIMONITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_LIMONITE_ORE.get().defaultBlockState()));
	};
	private static final Supplier<List<OreConfiguration.TargetBlockState>> SAPHIRE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.SAPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_SAPHIRE_ORE.get().defaultBlockState()));
	};
	private static final Supplier<List<OreConfiguration.TargetBlockState>> ENDERITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(END_STONE_REPLACEABLES, XOBlocks.ENDERITE_ORE.get().defaultBlockState()));
	};
	
	public static void create(@NotNull BootstapContext<ConfiguredFeature<?, ?>> context) {
		context.register(XOOreFeatures.JADE_ORE_UPPER, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 5)));
		context.register(XOOreFeatures.JADE_ORE_MIDDLE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 7)));
		context.register(XOOreFeatures.SAPHIRE_ORE_RARE_UPPER, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 2)));
		context.register(XOOreFeatures.SAPHIRE_ORE, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 5)));
		context.register(XOOreFeatures.SAPHIRE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 7, 1.0F)));
		context.register(XOOreFeatures.LIMONITE_ORE_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 4, 0.5F)));
		context.register(XOOreFeatures.LIMONITE_ORE_DEEP_BURIED, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 10, 1.0F)));
		context.register(XOOreFeatures.ENDERITE_ORE_RARE, new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 1)));
		context.register(XOOreFeatures.ENDERITE_ORE_BURIED, new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 3, 1.0F)));
	}
}
