package net.luis.xores.world.level.levelgen.placement;

import java.util.List;

import com.google.common.collect.Lists;

import net.luis.xores.XOres;
import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
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

public class XOOrePlacements {
	
	public static void register() {
	
	}
	
	public static final ResourceKey<PlacedFeature> JADE_ORE_UPPER = createKey("jade_ore_upper");
	public static final ResourceKey<PlacedFeature> JADE_ORE_MIDDLE = createKey("jade_ore_middle");
	
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = createKey("saphire_ore_rare_upper");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE = createKey("saphire_ore");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_BURIED = createKey("saphire_ore_buried");
	
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_BURIED = createKey("limonite_ore_buried");
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = createKey("limonite_ore_deep_buried");
	
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_RARE = createKey("enderite_ore_rare");
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_BURIED = createKey("enderite_ore_buried");
	
	private static ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(XOres.MOD_ID, name));
	}

}
