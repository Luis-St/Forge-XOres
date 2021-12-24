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

public class ModOrePlacements {
	
	public static final PlacementModifier RANGE_64_32 = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(-32));
	public static final PlacementModifier RANGE_64_0 = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(0));
	public static final PlacementModifier RANGE_64_64 = HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64));
	public static final PlacementModifier TRI_RANGE_64_32 = HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-32));
	public static final PlacementModifier TRI_RANGE_64_0 = HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(0));
	public static final PlacementModifier TRI_RANGE_64_64 = HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(64));
	
	public static final PlacedFeature JADE_ORE_UPPER = register("jade_ore_upper", ModOreFeatures.JADE_ORE_UPPER.placed(upperOrePlacement(25, 128)));
	public static final PlacedFeature JADE_ORE_MIDDLE = register("jade_ore_middle", ModOreFeatures.JADE_ORE_MIDDLE.placed(uniformOrePlacement(10, -64, 64)));
	
	public static final PlacedFeature LIMONITE_ORE_BURIED = register("limonite_ore_buried", ModOreFeatures.LIMONITE_ORE_BURIED.placed(buriedOrePlacement(7, 0)));
	public static final PlacedFeature LIMONITE_ORE_DEEP_BURIED = register("limonite_ore_deep_buried", ModOreFeatures.LIMONITE_ORE_DEEP_BURIED.placed(buriedOrePlacement(4, -48)));
	
	public static final PlacedFeature SAPHIRE_ORE = register("saphire_ore", ModOreFeatures.SAPHIRE_ORE.placed(uniformOrePlacement(18, -64, 256)));
	public static final PlacedFeature SAPHIRE_ORE_RARE_UPPER = register("saphire_ore_rare_upper", ModOreFeatures.SAPHIRE_ORE_RARE_UPPER.placed(upperOrePlacement(7, 256)));
	public static final PlacedFeature SAPHIRE_ORE_BURIED = register("saphire_ore_buried", ModOreFeatures.SAPHIRE_ORE_BURIED.placed(buriedOrePlacement(5, -32)));
	
	public static final PlacedFeature ROSITE_ORE_RARE = register("rosite_ore_rare", ModOreFeatures.ROSITE_ORE_RARE.placed(triangleOrePlacement(5, -16, 128)));
	public static final PlacedFeature ROSITE_ORE_BURIED = register("rosite_ore_buried", ModOreFeatures.ROSITE_ORE_BURIED.placed(buriedOrePlacement(7, -32)));
	
	public static final PlacedFeature ENDERITE_ORE_RARE = register("enderite_ore_rare", ModOreFeatures.ENDERITE_ORE_RARE.placed(uniformOrePlacement(2, 0, 128)));
	public static final PlacedFeature ENDERITE_ORE_BURIED = register("enderite_ore_buried", ModOreFeatures.ENDERITE_ORE_BURIED.placed(buriedEndOrePlacement(3)));
	
	protected static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier heightPlacement) {
		return List.of(placementModifier, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}

	protected static List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.top()));
	}
	
	protected static List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(maxGeneration)));
	}
	
	protected static List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	protected static List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	protected static List<PlacementModifier> triangleOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	protected static PlacedFeature register(String name, PlacedFeature placedFeature) {
		return PlacementUtils.register(new ResourceLocation(XOres.MOD_ID, name).toString(), placedFeature);
	}

}
