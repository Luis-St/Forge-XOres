package net.luis.xores.init.level;

import java.util.List;
import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.block.XOresBlocks;
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
 * registration class for all mod {@link ConfiguredFeature}s
 * 
 * @author Luis-st
 * 
 * @see {@link ConfiguredFeature}
 * @see {@link OreFeatures}
 */

public class XOresOreFeatures {
	
	/**
	 * {@link DeferredRegister} for {@link ConfiguredFeature}s, used to register all mod {@link ConfiguredFeature}s
	 */
	public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, XOres.MOD_ID);
	
	/**
	 * {@link TagMatchTest} for the replaceables for overworld ores
	 */
	private static final RuleTest STONE_REPLACEABLES = OreFeatures.STONE_ORE_REPLACEABLES;
	
	/**
	 * {@link TagMatchTest} for the replaceables for deeplsate overworld ores
	 */
	private static final RuleTest DEEPSLATE_REPLACEABLES = OreFeatures.DEEPSLATE_ORE_REPLACEABLES;
	
	/**
	 * {@link TagMatchTest} for the replaceables for end ores
	 */
	private static final RuleTest END_STONE_REPLACEABLES = new TagMatchTest(Tags.Blocks.END_STONES);
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all jade ores
	 */
	private static final Supplier<List<TargetBlockState>> JADE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOresBlocks.JADE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOresBlocks.DEEPSLATE_JADE_ORE.get().defaultBlockState()));
	};                   
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all limonite ores
	 */
	private static final Supplier<List<TargetBlockState>> LIMONITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOresBlocks.LIMONITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOresBlocks.DEEPSLATE_LIMONITE_ORE.get().defaultBlockState()));
	}; 
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all saphire ores
	 */
	private static final Supplier<List<TargetBlockState>> SAPHIRE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOresBlocks.SAPHIRE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOresBlocks.DEEPSLATE_SAPHIRE_ORE.get().defaultBlockState()));
	}; 
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all rosite ores
	 */
	private static final Supplier<List<TargetBlockState>> ROSITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(STONE_REPLACEABLES, XOresBlocks.ROSITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, XOresBlocks.DEEPSLATE_ROSITE_ORE.get().defaultBlockState()));
	}; 
	
	/**
	 * {@link List} of the {@link TargetBlockState}s for all end ores
	 */
	private static final Supplier<List<TargetBlockState>> ENDERITE_ORE_TARGETS = () -> {
		return List.of(OreConfiguration.target(END_STONE_REPLACEABLES, XOresBlocks.ENDERITE_ORE.get().defaultBlockState()));
	}; 
	
	/**
	 * {@link RegistryObject} for the upper jade ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> JADE_ORE_UPPER = CONFIGURED_FEATURES.register("jade_ore_upper", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 5));
	});
	
	/**
	 * {@link RegistryObject} for the middle jade ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> JADE_ORE_MIDDLE = CONFIGURED_FEATURES.register("jade_ore_middle", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JADE_ORE_TARGETS.get(), 7));
	});
	
	/**
	 * {@link RegistryObject} for the saphire ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE = CONFIGURED_FEATURES.register("saphire_ore", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 5));
	});
	
	/**
	 * {@link RegistryObject} for the upper saphire ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE_RARE_UPPER = CONFIGURED_FEATURES.register("saphire_ore_rare_upper", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 2));
	});
	
	/**
	 * {@link RegistryObject} for the buried saphire ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> SAPHIRE_ORE_BURIED = CONFIGURED_FEATURES.register("saphire_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SAPHIRE_ORE_TARGETS.get(), 7, 1.0F));
	});
	
	/**
	 * {@link RegistryObject} for the buried limonite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> LIMONITE_ORE_BURIED = CONFIGURED_FEATURES.register("limonite_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 4, 0.5F));
	});
	
	/**
	 * {@link RegistryObject} for the deep buried limonite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> LIMONITE_ORE_DEEP_BURIED = CONFIGURED_FEATURES.register("limonite_ore_deep_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(LIMONITE_ORE_TARGETS.get(), 10, 1.0F));
	});
	
	/**
	 * {@link RegistryObject} for the rare rosite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> ROSITE_ORE_RARE = CONFIGURED_FEATURES.register("rosite_ore_rare", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ROSITE_ORE_TARGETS.get(), 2, 0.2F));
	});
	
	/**
	 * {@link RegistryObject} for the upper rosite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> ROSITE_ORE_BURIED = CONFIGURED_FEATURES.register("rosite_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ROSITE_ORE_TARGETS.get(), 4, 1.0F));
	});
	
	/**
	 * {@link RegistryObject} for the rare enderite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> ENDERITE_ORE_RARE = CONFIGURED_FEATURES.register("enderite_ore_rare", () -> {
		return new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 1));
	});
	
	/**
	 * {@link RegistryObject} for the buried enderite ore, ore properties:
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
	public static final RegistryObject<ConfiguredFeature<?, ?>> ENDERITE_ORE_BURIED = CONFIGURED_FEATURES.register("enderite_ore_buried", () -> {
		return new ConfiguredFeature<>(Feature.SCATTERED_ORE, new OreConfiguration(ENDERITE_ORE_TARGETS.get(), 3, 1.0F));
	});
	
}
