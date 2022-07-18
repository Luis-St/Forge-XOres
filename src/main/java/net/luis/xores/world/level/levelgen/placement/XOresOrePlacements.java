package net.luis.xores.world.level.levelgen.placement;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.xores.XOres;
import net.luis.xores.world.level.levelgen.feature.XOresOreFeatures;
import net.minecraft.core.Registry;
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
 * 
 * @author Luis-st
 *
 */

public class XOresOrePlacements {
	
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, XOres.MOD_ID);
	
	public static final RegistryObject<PlacedFeature> JADE_ORE_UPPER = PLACED_FEATURES.register("jade_ore_upper", () -> {
		return new PlacedFeature(XOresOreFeatures.JADE_ORE_UPPER.getHolder().orElseThrow(NullPointerException::new), upperOrePlacement(20, 128));
	});
	public static final RegistryObject<PlacedFeature> JADE_ORE_MIDDLE = PLACED_FEATURES.register("jade_ore_middle", () -> {
		return new PlacedFeature(XOresOreFeatures.JADE_ORE_MIDDLE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(14, -32, 96));
	});
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = PLACED_FEATURES.register("saphire_ore_rare_upper", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE_RARE_UPPER.getHolder().orElseThrow(NullPointerException::new), upperOrePlacement(7, 256));
	});
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE = PLACED_FEATURES.register("saphire_ore", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(18, -64, 256));
	});
	public static final RegistryObject<PlacedFeature> SAPHIRE_ORE_BURIED = PLACED_FEATURES.register("saphire_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.SAPHIRE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(5, -32));
	});
	public static final RegistryObject<PlacedFeature> LIMONITE_ORE_BURIED = PLACED_FEATURES.register("limonite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.LIMONITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(5, -48, 0));
	});
	public static final RegistryObject<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = PLACED_FEATURES.register("limonite_ore_deep_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.LIMONITE_ORE_DEEP_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(2, -48));
	});
	public static final RegistryObject<PlacedFeature> ROSITE_ORE_RARE = PLACED_FEATURES.register("rosite_ore_rare", () -> {
		return new PlacedFeature(XOresOreFeatures.ROSITE_ORE_RARE.getHolder().orElseThrow(NullPointerException::new), triangleOrePlacement(5, -16, 128));
	});
	public static final RegistryObject<PlacedFeature> ROSITE_ORE_BURIED = PLACED_FEATURES.register("rosite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.ROSITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedOrePlacement(7, -32));
	});
	public static final RegistryObject<PlacedFeature> ENDERITE_ORE_RARE = PLACED_FEATURES.register("enderite_ore_rare", () -> {
		return new PlacedFeature(XOresOreFeatures.ENDERITE_ORE_RARE.getHolder().orElseThrow(NullPointerException::new), uniformOrePlacement(2, 0, 128));
	});
	public static final RegistryObject<PlacedFeature> ENDERITE_ORE_BURIED = PLACED_FEATURES.register("enderite_ore_buried", () -> {
		return new PlacedFeature(XOresOreFeatures.ENDERITE_ORE_BURIED.getHolder().orElseThrow(NullPointerException::new), buriedEndOrePlacement(3));
	});
	
	private static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightPlacement) {
		return Lists.newArrayList(countPlacement, InSquarePlacement.spread(), heightPlacement, BiomeFilter.biome());
	}
	
	private static List<PlacementModifier> upperOrePlacement(int count, int minGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), triangleMaxGeneration(minGeneration)));
	}
	
	private static List<PlacementModifier> buriedOrePlacement(int count, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(triangleMinGeneration(maxGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	private static List<PlacementModifier> buriedEndOrePlacement(int count) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)));
	}
	
	private static List<PlacementModifier> uniformOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.uniform(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	private static List<PlacementModifier> triangleOrePlacement(int count, int minGeneration, int maxGeneration) {
		return orePlacement(CountPlacement.of(count), HeightRangePlacement.triangle(VerticalAnchor.absolute(minGeneration), VerticalAnchor.absolute(maxGeneration)));
	}
	
	private static VerticalAnchor triangleMaxGeneration(int minGeneration) {
		return VerticalAnchor.absolute(320 + (320 - minGeneration));
	}
	
	private static VerticalAnchor triangleMinGeneration(int maxGeneration) {
		return VerticalAnchor.absolute((64 + maxGeneration) * -1 - 64);
	}

}
