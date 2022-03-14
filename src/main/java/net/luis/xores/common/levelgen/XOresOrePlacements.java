package net.luis.xores.common.levelgen;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.xores.XOres;
import net.luis.xores.event.level.OnBiomeLoadingEvent;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

/**
 * registration class for all mod {@link PlacedFeature}s
 * 
 * @author Luis-st
 * 
 * @see {@link PlacedFeature}
 * @see {@link OrePlacements}
 * @see {@link OnBiomeLoadingEvent}
 */

public class XOresOrePlacements {
	
	/**
	 * {@link PlacedFeature} for the upper jade ore
	 * @see {@link XOresOreFeatures#JADE_ORE_UPPER}
	 */
	public static final Holder<PlacedFeature> JADE_ORE_UPPER = register("jade_ore_upper", XOresOreFeatures.JADE_ORE_UPPER, upperOrePlacement(20, 128));
	
	/**
	 * {@link PlacedFeature} for the middle jade ore
	 * @see {@link XOresOreFeatures#JADE_ORE_MIDDLE}
	 */
	public static final Holder<PlacedFeature> JADE_ORE_MIDDLE = register("jade_ore_middle", XOresOreFeatures.JADE_ORE_MIDDLE, uniformOrePlacement(14, -32, 96));
	
	/**
	 * {@link PlacedFeature} for the saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE}
	 */
	public static final Holder<PlacedFeature> SAPHIRE_ORE = register("saphire_ore", XOresOreFeatures.SAPHIRE_ORE, uniformOrePlacement(18, -64, 256));
	
	/**
	 * {@link PlacedFeature} for the rare saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE_RARE_UPPER}
	 */
	public static final Holder<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = register("saphire_ore_rare_upper", XOresOreFeatures.SAPHIRE_ORE_RARE_UPPER, upperOrePlacement(7, 256));
	
	/**
	 * {@link PlacedFeature} for the buried saphire ore
	 * @see {@link XOresOreFeatures#SAPHIRE_ORE_BURIED}
	 */
	public static final Holder<PlacedFeature> SAPHIRE_ORE_BURIED = register("saphire_ore_buried", XOresOreFeatures.SAPHIRE_ORE_BURIED, buriedOrePlacement(5, -32));
	
	/**
	 * {@link PlacedFeature} for the buried limonite ore
	 * @see {@link XOresOreFeatures#LIMONITE_ORE_BURIED}
	 */
	public static final Holder<PlacedFeature> LIMONITE_ORE_BURIED = register("limonite_ore_buried", XOresOreFeatures.LIMONITE_ORE_BURIED, uniformOrePlacement(5, -48, 0));
	
	/**
	 * {@link PlacedFeature} for the deep buried limonite ore
	 * @see {@link XOresOreFeatures#LIMONITE_ORE_DEEP_BURIED}
	 */
	public static final Holder<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = register("limonite_ore_deep_buried", XOresOreFeatures.LIMONITE_ORE_DEEP_BURIED, buriedOrePlacement(2, -48));
	
	/**
	 * {@link PlacedFeature} for the rare rosite ore
	 * @see {@link XOresOreFeatures#ROSITE_ORE_RARE}
	 */
	public static final Holder<PlacedFeature> ROSITE_ORE_RARE = register("rosite_ore_rare", XOresOreFeatures.ROSITE_ORE_RARE, triangleOrePlacement(5, -16, 128));
	
	/**
	 * {@link PlacedFeature} for the buried rosite ore
	 * @see {@link XOresOreFeatures#ROSITE_ORE_BURIED}
	 */
	public static final Holder<PlacedFeature> ROSITE_ORE_BURIED = register("rosite_ore_buried", XOresOreFeatures.ROSITE_ORE_BURIED, buriedOrePlacement(7, -32));
	
	/**
	 * {@link PlacedFeature} for the rare enderite ore
	 * @see {@link XOresOreFeatures#ENDERITE_ORE_RARE}
	 */
	public static final Holder<PlacedFeature> ENDERITE_ORE_RARE = register("enderite_ore_rare", XOresOreFeatures.ENDERITE_ORE_RARE, uniformOrePlacement(2, 0, 128));
	
	/**
	 * {@link PlacedFeature} for the buried enderite ore
	 * @see {@link XOresOreFeatures#ENDERITE_ORE_BURIED}
	 */
	public static final Holder<PlacedFeature> ENDERITE_ORE_BURIED = register("enderite_ore_buried", XOresOreFeatures.ENDERITE_ORE_BURIED, buriedEndOrePlacement(3));
	
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
	protected static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightPlacement) {
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
	protected static List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
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
	protected static List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
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
	protected static List<PlacementModifier> buriedEndOrePlacement(int count) {
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
	protected static List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
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
	protected static List<PlacementModifier> triangleOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * @param minGeneration The minimum generation height
	 * @return the maximum generation height for a triangle ore
	 */
	protected static VerticalAnchor triangleMaxGeneration(int minGeneration) {
		return VerticalAnchor.absolute(320 + (320 - minGeneration));
	}
	
	/**
	 * @param maxGeneration The maximum generation height
	 * @return the minimum generation height for a triangle ore
	 */
	protected static VerticalAnchor triangleMinGeneration(int maxGeneration) {
		return VerticalAnchor.absolute((64 + maxGeneration) * -1 - 64);
	}
	
	/**
	 * register the given {@link PlacedFeature}
	 * @param name Then name of the {@link PlacedFeature} which is used for registry
	 * @param placedFeature The {@link PlacedFeature} which should be registered
	 * @return the given {@link PlacedFeature}
	 */
	protected static Holder<PlacedFeature> register(String name, Holder<? extends ConfiguredFeature<?, ?>> configuredFeature, List<PlacementModifier> placementModifiers) {
		return PlacementUtils.register(new ResourceLocation(XOres.MOD_ID, name).toString(), configuredFeature, placementModifiers);
	}

}
