package net.luis.xores.event.level;

import net.luis.xores.XOres;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
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
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		if (event.getCategory() == BiomeCategory.THEEND) {
			if (!event.getName().getPath().equals("the_end")) {
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.ENDERITE_ORE_RARE.getHolder().orElseThrow());
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.ENDERITE_ORE_BURIED.getHolder().orElseThrow());
			}
		} else if (event.getCategory() == BiomeCategory.NETHER) {
			
		} else {
			if (isPeakBiome(event.getName().getPath())) {
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.JADE_ORE_UPPER.getHolder().orElseThrow());
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.SAPHIRE_ORE_RARE_UPPER.getHolder().orElseThrow());
			}
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.JADE_ORE_MIDDLE.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.LIMONITE_ORE_BURIED.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.LIMONITE_ORE_DEEP_BURIED.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.SAPHIRE_ORE.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.SAPHIRE_ORE_BURIED.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.ROSITE_ORE_RARE.getHolder().orElseThrow());
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOOrePlacements.ROSITE_ORE_BURIED.getHolder().orElseThrow());
		}
	}
	
	private static boolean isPeakBiome(String location) {
		return location.equals("meadow") || location.equals("grove") || location.equals("snowy_slopes") || location.equals("frozen_peaks") || location.equals("jagged_peaks") || location.equals("stony_peaks");
	}
	
}
