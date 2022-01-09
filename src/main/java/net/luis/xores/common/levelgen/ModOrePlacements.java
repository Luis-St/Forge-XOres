package net.luis.xores.common.levelgen;

import java.util.List;

import net.luis.xores.XOres;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

/**
 * Registration class of {@link PlacedFeature}
 * 
 * @author Luis-st
 */

public class ModOrePlacements {
	
	public static final PlacedFeature JADE_ORE_UPPER = register("jade_ore_upper", ModOreFeatures.JADE_ORE_UPPER.placed(upperOrePlacement(20, 128)));
	public static final PlacedFeature JADE_ORE_MIDDLE = register("jade_ore_middle", ModOreFeatures.JADE_ORE_MIDDLE.placed(uniformOrePlacement(14, -32, 96)));
	
	public static final PlacedFeature SAPHIRE_ORE = register("saphire_ore", ModOreFeatures.SAPHIRE_ORE.placed(uniformOrePlacement(18, -64, 256)));
	public static final PlacedFeature SAPHIRE_ORE_RARE_UPPER = register("saphire_ore_rare_upper", ModOreFeatures.SAPHIRE_ORE_RARE_UPPER.placed(upperOrePlacement(7, 256)));
	public static final PlacedFeature SAPHIRE_ORE_BURIED = register("saphire_ore_buried", ModOreFeatures.SAPHIRE_ORE_BURIED.placed(buriedOrePlacement(5, -32)));
	
	public static final PlacedFeature LIMONITE_ORE_BURIED = register("limonite_ore_buried", ModOreFeatures.LIMONITE_ORE_BURIED.placed(uniformOrePlacement(5, -48, 0)));
	public static final PlacedFeature LIMONITE_ORE_DEEP_BURIED = register("limonite_ore_deep_buried", ModOreFeatures.LIMONITE_ORE_DEEP_BURIED.placed(buriedOrePlacement(2, -48)));
	
	public static final PlacedFeature ROSITE_ORE_RARE = register("rosite_ore_rare", ModOreFeatures.ROSITE_ORE_RARE.placed(triangleOrePlacement(5, -16, 128)));
	public static final PlacedFeature ROSITE_ORE_BURIED = register("rosite_ore_buried", ModOreFeatures.ROSITE_ORE_BURIED.placed(buriedOrePlacement(7, -32)));
	
	public static final PlacedFeature ENDERITE_ORE_RARE = register("enderite_ore_rare", ModOreFeatures.ENDERITE_ORE_RARE.placed(uniformOrePlacement(2, 0, 128)));
	public static final PlacedFeature ENDERITE_ORE_BURIED = register("enderite_ore_buried", ModOreFeatures.ENDERITE_ORE_BURIED.placed(buriedEndOrePlacement(3)));
	
	/**
	 * @return a {@link List} of {@link PlacementModifier} for a simple ore
	 */
	protected static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier heightPlacement) {
		return List.of(placementModifier, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}

	/**
	 * @param count of the ore in one chunk
	 * @param minGeneration height of the ore
	 * @return a {@link List} of {@link PlacementModifier} for a upper ore
	 */
	protected static List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), getTriangleTop(minGeneration)));
	}
	
	/**
	 * @param count of the ore in one chunk
	 * @param maxGeneration height of the ore
	 * @return a {@link List} of {@link PlacementModifier} for a buried ore
	 */
	protected static List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(getTriangleDown(maxGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * @param count of the ore in one chunk
	 * @return a {@link List} of {@link PlacementModifier} for a buried End ore
	 */
	protected static List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	/**
	 * @param count of the ore in one chunk
	 * @param minGeneration height of the ore
	 * @param maxGeneration height of the ore
	 * @return a {@link List} of {@link PlacementModifier} for a simple ore between minGeneration and maxGeneration
	 */
	protected static List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * @param count of the ore in one chunk
	 * @param minGeneration height of the ore
	 * @param maxGeneration height of the ore
	 * @return a {@link List} of {@link PlacementModifier} for a triangle ore
	 */
	protected static List<PlacementModifier> triangleOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	/**
	 * @param minGeneration height of the ore
	 * @return the top {@link VerticalAnchor} for the minGeneration
	 */
	protected static VerticalAnchor getTriangleTop(int minGeneration) {
		int maxGeneration = 320 + (320 - minGeneration);
		return VerticalAnchor.absolute(maxGeneration);
	}
	
	/**
	 * @param maxGeneration height of the ore
	 * @return a down {@link VerticalAnchor} for the maxGeneration
	 */
	protected static VerticalAnchor getTriangleDown(int maxGeneration) {
		int minGeneration = (64 + maxGeneration) * -1 - 64;
		return VerticalAnchor.absolute(minGeneration);
	}
	
	/**
	 * Register the {@link PlacedFeature} via the vanilla registration {@link PlacementUtils#register}
	 */
	protected static PlacedFeature register(String name, PlacedFeature placedFeature) {
		return PlacementUtils.register(new ResourceLocation(XOres.MOD_ID, name).toString(), placedFeature);
	}

}
