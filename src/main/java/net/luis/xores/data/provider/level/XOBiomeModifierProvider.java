package net.luis.xores.data.provider.level;

import net.luis.xores.world.level.biome.XOBiomeModifier;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;

/**
 *
 * @author Luis-st
 *
 */

public class XOBiomeModifierProvider {
	
	public static void create(BootstapContext<BiomeModifier> context) {
		HolderGetter<PlacedFeature> featureRegistry = context.lookup(Registries.PLACED_FEATURE);
		HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
		HolderSet<PlacedFeature> overworldFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.JADE_ORE_MIDDLE), featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE),
				featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE_BURIED), featureRegistry.getOrThrow(XOOrePlacements.LIMONITE_ORE_BURIED), featureRegistry.getOrThrow(XOOrePlacements.LIMONITE_ORE_DEEP_BURIED));
		HolderSet<PlacedFeature> peakFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.JADE_ORE_UPPER), featureRegistry.getOrThrow(XOOrePlacements.SAPHIRE_ORE_RARE_UPPER));
		HolderSet<Biome> endBiomes = HolderSet.direct(biomeRegistry.getOrThrow(Biomes.END_HIGHLANDS), biomeRegistry.getOrThrow(Biomes.END_MIDLANDS), biomeRegistry.getOrThrow(Biomes.SMALL_END_ISLANDS), biomeRegistry.getOrThrow(Biomes.END_BARRENS));
		HolderSet<PlacedFeature> endFeatures = HolderSet.direct(featureRegistry.getOrThrow(XOOrePlacements.ENDERITE_ORE_RARE), featureRegistry.getOrThrow(XOOrePlacements.ENDERITE_ORE_BURIED));
		context.register(XOBiomeModifier.KEY, new XOBiomeModifier(biomeRegistry.getOrThrow(BiomeTags.IS_OVERWORLD), overworldFeatures, biomeRegistry.getOrThrow(Tags.Biomes.IS_PEAK), peakFeatures, endBiomes, endFeatures));
	}
	
}
