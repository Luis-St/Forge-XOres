package net.luis.xores.world.level.levelgen.feature;

import java.util.List;
import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOOreFeatures {
	
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, XOres.MOD_ID);
	
	private static final RuleTest STONE_REPLACEABLES = OreFeatures.STONE_ORE_REPLACEABLES;
	private static final RuleTest DEEPSLATE_REPLACEABLES = OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
	private static final RuleTest END_STONE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES);
	
	private static final Supplier<List<TargetBlockState>> JADE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.JADE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
	};              
	private static final Supplier<List<TargetBlockState>> LIMONITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.LIMONITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_LIMONITE_ORE.get().defaultBlockState()));
	};
	private static final Supplier<List<TargetBlockState>> SAPHIRE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOBlocks.SAPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOBlocks.DEEPSLATE_SAPHIRE_ORE.get().defaultBlockState()));
	};
	private static final Supplier<List<TargetBlockState>> ENDERITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(END_STONE_REPLACEABLES, XOBlocks.ENDERITE_ORE.get().defaultBlockState()));
	}; 
	
	public static final RegistryObject<ConfiguredFeature<?, ?>> JADE_ORE_UPPER = CONFIGURED_FEATURES.register("jade_ore_upper", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 5));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> JADE_ORE_MIDDLE = CONFIGURED_FEATURES.register("jade_ore_middle", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 7));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE_RARE_UPPER = CONFIGURED_FEATURES.register("saphire_ore_rare_upper", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 2));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE = CONFIGURED_FEATURES.register("saphire_ore", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 5));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE_BURIED = CONFIGURED_FEATURES.register("saphire_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 7, 1.0F));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> LIMONITE_ORE_BURIED = CONFIGURED_FEATURES.register("limonite_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 4, 0.5F));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> LIMONITE_ORE_DEEP_BURIED = CONFIGURED_FEATURES.register("limonite_ore_deep_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 10, 1.0F));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> ENDERITE_ORE_RARE = CONFIGURED_FEATURES.register("enderite_ore_rare", () -> {
		return new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 1));
	});
	public static final RegistryObject<ConfiguredFeature<?, ?>> ENDERITE_ORE_BURIED = CONFIGURED_FEATURES.register("enderite_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 3, 1.0F));
	});
	
}
