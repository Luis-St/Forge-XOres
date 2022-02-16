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
 * registration class for all mod {@link ConfiguredFeature}s
 * 
 * @author Luis-st
 */

public class ModOreFeatures {

	/**
	 * {@link TagMatchTest} for the replaceables for overworld ores
	 */
	protected static final RuleTest STONE_REPLACEABLES = OreFeatures.STONE_ORE_REPLACEABLES;
	
	/**
	 * {@link TagMatchTest} for the replaceables for deeplsate overworld ores
	 */
	protected static final RuleTest DEEPSLATE_REPLACEABLES = OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
	
	/**
	 * custom {@link TagMatchTest} for the replaceables for end ores
	 */
	protected static final RuleTest END_STONE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.BASE_STONE_END);
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all jade ores
	 */
	protected static final List<TargetBlockState> JADE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.JADE_ORE.get().defaultBlockState()),
		OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all limonite ores
	 */
	protected static final List<TargetBlockState> LIMONITE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.LIMONITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_LIMONITE_ORE.get().defaultBlockState()));
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all saphire ores
	 */
	protected static final List<TargetBlockState> SAPHIRE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.SAPHIRE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPHIRE_ORE.get().defaultBlockState()));
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all rosite ores
	 */
	protected static final List<TargetBlockState> ROSITE_ORE_TARGETS = List.of(OreConfiguration.target(STONE_REPLACEABLES, ModBlocks.ROSITE_ORE.get().defaultBlockState()),
			OreConfiguration.target(DEEPSLATE_REPLACEABLES, ModBlocks.DEEPSLATE_ROSITE_ORE.get().defaultBlockState()));
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all end ores
	 */
	protected static final List<TargetBlockState> ENDERITE_ORE_TARGETS = List.of(OreConfiguration.target(END_STONE_REPLACEABLES, ModBlocks.ENDERITE_ORE.get().defaultBlockState()));
	
	/**
	 * the {@link ConfiguredFeature} for the upper jade ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 5</li>
	 * 	<li>air discard chance: 100%</li>
	 *  <li>chunk count: 20</li>
	 *  <li>minimum generation height: 128</li>
	 *  <li>maximum generation height: 512</li>
	 *  <li>generation range: 384 (theoretical), 192 (practical)</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> JADE_ORE_UPPER = register("jade_ore_upper", Feature.ORE.configured(new OreConfiguration(JADE_ORE_TARGETS, 5)));
	
	/**
	 * the {@link ConfiguredFeature} for the middle jade ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 7</li>
	 * 	<li>air discard chance: 100%</li>
	 *  <li>chunk count: 14</li>
	 *  <li>minimum generation height: -32</li>
	 *  <li>maximum generation height: 96</li>
	 *  <li>generation range: 128</li>
	 *  <li>generation type: uniform</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> JADE_ORE_MIDDLE = register("jade_ore_middle", Feature.ORE.configured(new OreConfiguration(JADE_ORE_TARGETS, 7)));
	
	/**
	 * the {@link ConfiguredFeature} for the saphire ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 5</li>
	 *  <li>air discard chance: 100%</li>
	 *  <li>chunk count: 18</li>
	 *  <li>minimum generation height: -64</li>
	 *  <li>maximum generation height: 256</li>
	 *  <li>generation range: 320</li>
	 *  <li>generation type: uniform</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE = register("saphire_ore", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 5)));
	
	/**
	 * the {@link ConfiguredFeature} for the upper saphire ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 2</li>
	 *  <li>air discard chance: 100%</li>
	 *  <li>chunk count: 7</li>
	 *  <li>minimum generation height: 256</li>
	 *  <li>maximum generation height: 384</li>
	 *  <li>generation range: 128 (theoretical), 64 (practical)</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE_RARE_UPPER = register("saphire_ore_rare_upper", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 2)));
	
	/**
	 * the {@link ConfiguredFeature} for the buried saphire ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 7</li>
	 *  <li>air discard chance: 0%</li>
	 *  <li>chunk count: 5</li>
	 *  <li>minimum generation height: -96</li>
	 *  <li>maximum generation height: -32</li>
	 *  <li>generation range: 64 (theoretical), 32 (practical)</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> SAPHIRE_ORE_BURIED = register("saphire_ore_buried", Feature.ORE.configured(new OreConfiguration(SAPHIRE_ORE_TARGETS, 7, 1.0F)));
	
	/**
	 * the {@link ConfiguredFeature} for the buried limonite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 4</li>
	 *  <li>air discard chance: 50%</li>
	 *  <li>chunk count: 5</li>
	 *  <li>minimum generation height: -48</li>
	 *  <li>maximum generation height: 0</li>
	 *  <li>generation range: 48</li>
	 *  <li>generation type: uniform</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> LIMONITE_ORE_BURIED = register("limonite_ore_buried", Feature.ORE.configured(new OreConfiguration(LIMONITE_ORE_TARGETS, 4, 0.5F)));
	
	/**
	 * the {@link ConfiguredFeature} for the deep buried limonite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 10</li>
	 *  <li>air discard chance: 0%</li>
	 *  <li>chunk count: 2</li>
	 *  <li>minimum generation height: -80</li>
	 *  <li>maximum generation height: -48</li>
	 *  <li>generation range: 32 (theoretical), 16 (practical)</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> LIMONITE_ORE_DEEP_BURIED = register("limonite_ore_deep_buried", Feature.ORE.configured(new OreConfiguration(LIMONITE_ORE_TARGETS, 10, 1.0F)));
	
	/**
	 * the {@link ConfiguredFeature} for the rare rosite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 2</li>
	 *  <li>air discard chance: 80%</li>
	 *  <li>chunk count: 5</li>
	 *  <li>minimum generation height: -16</li>
	 *  <li>maximum generation height: 128</li>
	 *  <li>generation range: 144</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> ROSITE_ORE_RARE = register("rosite_ore_rare", Feature.ORE.configured(new OreConfiguration(ROSITE_ORE_TARGETS, 2, 0.2F)));
	
	/**
	 * the {@link ConfiguredFeature} for the upper rosite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 4</li>
	 *  <li>air discard chance: 0%</li>
	 *  <li>chunk count: 7</li>
	 *  <li>minimum generation height: -96</li>
	 *  <li>maximum generation height: -32</li>
	 *  <li>generation range: 64 (theoretical), 32 (practical)</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> ROSITE_ORE_BURIED = register("rosite_ore_buried", Feature.ORE.configured(new OreConfiguration(ROSITE_ORE_TARGETS, 4, 1.0F)));
	
	/**
	 * the {@link ConfiguredFeature} for the rare enderite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: 1</li>
	 *  <li>air discard chance: 100%</li>
	 *  <li>chunk count: 2</li>
	 *  <li>minimum generation height: 0</li>
	 *  <li>maximum generation height: 128</li>
	 *  <li>generation range: 128</li>
	 *  <li>generation type: uniform</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> ENDERITE_ORE_RARE = register("enderite_ore_rare", Feature.SCATTERED_ORE.configured(new OreConfiguration(ENDERITE_ORE_TARGETS, 1)));
	
	/**
	 * the {@link ConfiguredFeature} for the buried enderite ore, ore properties:
	 * <ul>
	 * 	<li>vine size: </li>
	 *  <li>air discard chance: 0%</li>
	 *  <li>chunk count: 3</li>
	 *  <li>minimum generation height: 0</li>
	 *  <li>maximum generation height: 128</li>
	 *  <li>generation range: 128</li>
	 *  <li>generation type: triangle</li>
	 * </ul>
	 */
	public static final ConfiguredFeature<?, ?> ENDERITE_ORE_BURIED = register("enderite_ore_buried", Feature.SCATTERED_ORE.configured(new OreConfiguration(ENDERITE_ORE_TARGETS, 3, 1.0F)));
	
	/**
	 * register the given {@link ConfiguredFeature}
	 * @param name of the {@link ConfiguredFeature} which is used for registry
	 * @param configuredFeature which should be registered
	 * @return the given {@link ConfiguredFeature}
	 */
	protected static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
		return FeatureUtils.register(new ResourceLocation(XOres.MOD_ID, name).toString(), configuredFeature);
	}
	
}
