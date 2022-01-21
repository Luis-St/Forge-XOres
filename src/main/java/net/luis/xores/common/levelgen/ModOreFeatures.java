package net.luis.xores.common.levelgen;

import java.util.List;

import net.luis.xores.XOres;
import net.luis.xores.init.ModBlocks;
import net.luis.xores.init.ModTags;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

/**
 * 
 * @author Luis-st
 *
 */

public class ModOreFeatures {

	public static final RuleTest STONE_REPLACEABLES = OreFeatures.STONE_ORE_REPLACEABLES;
	public static final RuleTest DEEPSLATE_REPLACEABLES = OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
	public static final RuleTest END_STONE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.BASE_STONE_END);
	
	protected static final List<TargetBlockState> JADE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.JADE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
	protected static final List<TargetBlockState> LIMONITE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.LIMONITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_LIMONITE_ORE.get().defaultBlockState()));
	protected static final List<TargetBlockState> SAPHIRE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.SAPHIRE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPHIRE_ORE.get().defaultBlockState()));
	protected static final List<TargetBlockState> ROSITE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.ROSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_ROSITE_ORE.get().defaultBlockState()));
	protected static final List<TargetBlockState> ENDERITE_ORE_TARGETS = List.of(OreConfiguration.target(END_STONE_REPLACEABLES, ModBlocks.ENDERITE_ORE.get().defaultBlockState()));
	
	public static final ConfiguredFeature<?, ?> JADE_ORE_UPPER = register("jade_ore_upper", Feature.ORE.configured(new OreConfiguration(JADE_ORE_TARGETS, 5)));
	public static final ConfiguredFeature<?, ?> JADE_ORE_MIDDLE = register("jade_ore_middle", Feature.ORE.configured(new OreConfiguration(JADE_ORE_TARGETS, 7)));
	
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE = register("saphire_ore", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 5)));
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE_RARE_UPPER = register("saphire_ore_rare_upper", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 2)));
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE_BURIED = register("saphire_ore_buried", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 7, 1.0F)));
	
	public static final ConfiguredFeature<?, ?> LIMONITE_ORE_BURIED = register("limonite_ore_buried", Feature.ORE.configured(new OreConfiguration(LIMONITE_ORE_TARGETS, 4, 0.5F)));
	public static final ConfiguredFeature<?, ?> LIMONITE_ORE_DEEP_BURIED = register("limonite_ore_deep_buried", Feature.ORE.configured(new OreConfiguration(LIMONITE_ORE_TARGETS, 10, 1.0F)));
	
	public static final ConfiguredFeature<?, ?> ROSITE_ORE_RARE = register("rosite_ore_rare", Feature.ORE.configured(new OreConfiguration(ROSITE_ORE_TARGETS, 2, 0.2F)));
	public static final ConfiguredFeature<?, ?> ROSITE_ORE_BURIED = register("rosite_ore_buried", Feature.ORE.configured(new OreConfiguration(ROSITE_ORE_TARGETS, 4, 1.0F)));
	
	public static final ConfiguredFeature<?, ?> ENDERITE_ORE_RARE = register("enderite_ore_rare", Feature.SCATTERED_ORE.configured(new OreConfiguration(ENDERITE_ORE_TARGETS, 1)));
	public static final ConfiguredFeature<?, ?> ENDERITE_ORE_BURIED = register("enderite_ore_buried", Feature.SCATTERED_ORE.configured(new OreConfiguration(ENDERITE_ORE_TARGETS, 3, 1.0F)));
	
	/**
	 * Register the {@link ConfiguredFeature} via the vanilla registration {@link FeatureUtils#register}
	 */
	protected static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return FeatureUtils.register(new ResourceLocation(XOres.MOD_ID, name).toString(), configuredFeature);
	}
	
}
