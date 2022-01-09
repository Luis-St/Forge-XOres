package net.luis.xores.event.level;

import net.luis.xores.XOres;
import net.luis.xores.common.levelgen.ModOrePlacements;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID)
public class OnBiomeLoadingEvent {

	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoading(BiomeLoadingEvent event) {
		// Level generation
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		if (event.getCategory() == BiomeCategory.THEEND) {
			if (!event.getName().getPath().equals("the_end")) { // no Enderite in TheEnd Biomes
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.ENDERITE_ORE_RARE);
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.ENDERITE_ORE_BURIED);
			}
		} else if (event.getCategory() == BiomeCategory.NETHER) {
			
		} else {
			if (isPeakBiome(event.getName().getPath())) { // PeakBiome only Ores
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.JADE_ORE_UPPER);
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.SAPHIRE_ORE_RARE_UPPER);
			}
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.JADE_ORE_MIDDLE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.LIMONITE_ORE_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.LIMONITE_ORE_DEEP_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.SAPHIRE_ORE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.SAPHIRE_ORE_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.ROSITE_ORE_RARE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, ModOrePlacements.ROSITE_ORE_BURIED);
		}
	}

	protected static boolean isPeakBiome(String location) {
		return location.equals("meadow") || location.equals("grove") || location.equals("snowy_slopes") || location.equals("frozen_peaks") || location.equals("jagged_peaks") || location.equals("stony_peaks");
	}
	
}
