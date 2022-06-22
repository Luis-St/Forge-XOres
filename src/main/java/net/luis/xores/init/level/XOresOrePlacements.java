package net.luis.xores.init.level;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.xores.XOres;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all mod {@link PlacedFeature}s
 * 
 * @author Luis-st
 * 
 * @see {@link PlacedFeature}
 * @see {@link OrePlacements}
 */

public class XOresOrePlacements {
	
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the upper jade ore
	 * @see {@link XOresOreFeatures#JADE_ORE_UPPER}
	 */
	public static final RegistryObject<PlacedFeature> JADE_ORE_UPPER = PLACED_FEATURES.register("jade_ore_upper", () -> {
		return new PlacedFeature(XOresOreFeatures.JADE_ORE_UPPER.getHolder().orElseThrow(NullPointerException::new), upperOrePlacement(20, 128));
	});
	
	/**
	 * {@link RegistryObject} for the middle jade ore
	 * @see {@link XOresOreFeatures#JADE_ORE_MIDDLE}
	 */
	public static final RegistryObject<PlacedFeature> JADE_ORE_MIDDLE = PLACED_FEATURES.register("jade_ore_middle", () -> {
		return new PlacedFeature(XOresOreFeatures.JADE_ORE_MIDDLE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(14, -32, 96));
	});
	
	/**
	 * {@link RegistryObject} for the saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE}
	 */
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE = PLACED_FEATURES.register("saphire_ore", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(18, -64, 256));
	});
	
	/**
	 * {@link RegistryObject} for the rare saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE_RARE_UPPER}
	 */
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = PLACED_FEATURES.register("saphire_ore_rare_upper", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE_RARE_UPPER.getHolder().orElseThrow(NullPointerException::new), upperOrePlacement(7, 256));
	});
	
	/**
	 * {@link RegistryObject} for the buried saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE_BURIED}
	 */
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE_BURIED = PLACED_FEATURES.register("saphire_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(5, -32));
	});
	
	/**
	 * {@link RegistryObject} for the buried limonite ore
	 * @see {@link XOresOreFeatures#LIMONITE_ORE_BURIED}
	 */
	public static final RegistryObject<PlacedFeature> LIMONITE_ORE_BURIED = PLACED_FEATURES.register("limonite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.LIMONITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(5, -48, 0));
	});
	
	/**
	 * {@link RegistryObject} for the deep buried limonite ore
	 * @see {@link XOresOreFeatures#LIMONITE_ORE_DEEP_BURIED}
	 */
	public static final RegistryObject<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = PLACED_FEATURES.register("limonite_ore_deep_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.LIMONITE_ORE_DEEP_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(2, -48));
	});
	
	/**
	 * {@link RegistryObject} for the rare rosite ore
	 * @see {@link XOresOreFeatures#ROSITE_ORE_RARE}
	 */
	public static final RegistryObject<PlacedFeature> ROSITE_ORE_RARE = PLACED_FEATURES.register("rosite_ore_rare", () -> {
		return new PlacedFeature(XOresOreFeatures.ROSITE_ORE_RARE.getHolder().orElseThrow(NullPointerException::new), triangleOrePlacement(5, -16, 128));
	});
	
	/**
	 * {@link RegistryObject} for the buried rosite ore
	 * @see {@link XOresOreFeatures#ROSITE_ORE_BURIED}
	 */
	public static final RegistryObject<PlacedFeature> ROSITE_ORE_BURIED = PLACED_FEATURES.register("rosite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.ROSITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(7, -32));
	});
	
	/**
	 * {@link RegistryObject} for the rare enderite ore
	 * @see {@link XOresOreFeatures#ENDERITE_ORE_RARE}
	 */
	public static final RegistryObject<PlacedFeature> ENDERITE_ORE_RARE = PLACED_FEATURES.register("enderite_ore_rare", () -> {
		return new PlacedFeature(XOresOreFeatures.ENDERITE_ORE_RARE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(2, 0, 128));
	});
	
	/**
	 * {@link RegistryObject} for the buried enderite ore
	 * @see {@link XOresOreFeatures#ENDERITE_ORE_BURIED}
	 */
	public static final RegistryObject<PlacedFeature> ENDERITE_ORE_BURIED = PLACED_FEATURES.register("enderite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.ENDERITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedEndOrePlacement(3));
	});
	
	/**
	 * creates the {@link PlacementModifier}s for a basic ore
	 * @param countPlacement The count {@link PlacementModifier}
	 * @param heightPlacement The height {@link PlacementModifier}
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>the given {@link PlacementModifier} for the count</li>
	 *  <li>the given {@link PlacementModifier} for the height</li>
	 *  <li>{@link InSquarePlacement}</li>
	 *  <li>{@link BiomeFilter}</li>
	 * </ul>
	 */
	private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightPlacement) {
		return Lists.newArrayList(countPlacement, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}


	/**
	 * creates the {@link PlacementModifier}s for a upper ore
	 * @param count The count of the ore in a chunk
	 * @param minGeneration The minimum generation height in a chunk
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>{@link CountPlacement} for the count of the ore in the chunk</li>
	 *  <li>{@link HeightRangePlacement} for the minimum and maximum generation height</li>
	 * </ul>
	 * @see {@link XOresOrePlacements#orePlacement(PlacementModifier, PlacementModifier)}
	 * @see {@link XOresOrePlacements#triangleMaxGeneration()} for the maximum generation height
	 */
	private static List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), triangleMaxGeneration(minGeneration)));
	}
	
	/**
	 * creates the {@link PlacementModifier}s for a buried ore
	 * @param count The count of the ore in a chunk
	 * @param maxGeneration The maximum generation height in a chunk
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>{@link CountPlacement} for the count of the ore in the chunk</li>
	 *  <li>{@link HeightRangePlacement} for the minimum and maximum generation height</li>
	 * </ul>
	 * @see {@link XOresOrePlacements#orePlacement(PlacementModifier, PlacementModifier)}
	 * @see {@link XOresOrePlacements#triangleMinGeneration(int)} for the minimum generation height
	 */
	private static List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(triangleMinGeneration(maxGeneration), VerticalAnchor.absolute(maxGeneration)));
	}

	/**
	 * creates the {@link PlacementModifier}s for a buried end ore
	 * @param count The count of the ore in a chunk
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>{@link CountPlacement} for the count of the ore in the chunk</li>
	 *  <li>{@link HeightRangePlacement} for the minimum and maximum generation height</li>
	 * </ul>
	 * @see {@link XOresOrePlacements#orePlacement(PlacementModifier, PlacementModifier)}
	 */
	private static List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	/**
	 * creates the {@link PlacementModifier}s for a uniform ore
	 * @param count The count of the ore in a chunk
	 * @param minGeneration The minimum generation height in a chunk
	 * @param maxGeneration The maximum generation height in a chunk
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>{@link CountPlacement} for the count of the ore in the chunk</li>
	 *  <li>{@link HeightRangePlacement} for the minimum and maximum generation height</li>
	 * </ul>
	 * @see {@link XOresOrePlacements#orePlacement(PlacementModifier, PlacementModifier)}
	 */
	private static List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * creates the {@link PlacementModifier}s for a triangle ore
	 * @param count The count of the ore in a chunk
	 * @param minGeneration The minimum generation height in a chunk
	 * @param maxGeneration The maximum generation height in a chunk
	 * @return a {@link List} of {@link PlacementModifier} with:
	 * <ul>
	 * 	<li>{@link CountPlacement} for the count of the ore in the chunk</li>
	 *  <li>{@link HeightRangePlacement} for the minimum and maximum generation height</li>
	 * </ul>
	 * @see {@link XOresOrePlacements#orePlacement(PlacementModifier, PlacementModifier)}
	 */
	private static List<PlacementModifier> triangleOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * @param minGeneration The minimum generation height
	 * @return the maximum generation height for a triangle ore
	 */
	private static VerticalAnchor triangleMaxGeneration(int minGeneration) {
		return VerticalAnchor.absolute(320 + (320 - minGeneration));
	}
	
	/**
	 * @param maxGeneration The maximum generation height
	 * @return the minimum generation height for a triangle ore
	 */
	private static VerticalAnchor triangleMinGeneration(int maxGeneration) {
		return VerticalAnchor.absolute((64 + maxGeneration) * -1 - 64);
	}

}
