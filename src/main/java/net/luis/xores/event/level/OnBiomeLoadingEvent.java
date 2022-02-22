package net.luis.xores.event.level;

import net.luis.xores.XOres;
import net.luis.xores.common.levelgen.XOresOrePlacements;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * {@link BiomeLoadingEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID)
public class OnBiomeLoadingEvent {
	
	/**
	 * add the ores to the level generation:
	 * <ul>
	 * 	<li>
	 * 		add the {@link XOresOrePlacements#ENDERITE_ORE_RARE} and<br> 
	 * 		{@link XOresOrePlacements#ENDERITE_ORE_BURIED} to the extended End Biomes
	 * 	</li>
	 *  <li>
	 * 		add the {@link XOresOrePlacements#JADE_ORE_UPPER} and<br> 
	 * 		{@link XOresOrePlacements#SAPHIRE_ORE_RARE_UPPER} to the Peak Biomes
	 * 	</li>
	 *  <li>
	 *  	add the following ores to all Overworld Biomes:
	 *  	<ul>
	 *			<li>{@link XOresOrePlacements#JADE_ORE_MIDDLE}</li>
	 *			<li>{@link XOresOrePlacements#LIMONITE_ORE_BURIED}</li>
	 *			<li>{@link XOresOrePlacements#LIMONITE_ORE_DEEP_BURIED}</li>
	 *			<li>{@link XOresOrePlacements#SAPHIRE_ORE}</li>
	 *			<li>{@link XOresOrePlacements#SAPHIRE_ORE_BURIED}</li>
	 *			<li>{@link XOresOrePlacements#ROSITE_ORE_RARE}</li>
	 *			<li>{@link XOresOrePlacements#ROSITE_ORE_BURIED}</li>
	 *  	</ul>
	 *  </li>
	 * </ul>
	 */
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void biomeLoading(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generationBuilder = event.getGeneration();
		if (event.getCategory() == BiomeCategory.THEEND) {
			if (!event.getName().getPath().equals("the_end")) {
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.ENDERITE_ORE_RARE);
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.ENDERITE_ORE_BURIED);
			}
		} else if (event.getCategory() == BiomeCategory.NETHER) {
			
		} else {
			if (isPeakBiome(event.getName().getPath())) {
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.JADE_ORE_UPPER);
				generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.SAPHIRE_ORE_RARE_UPPER);
			}
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.JADE_ORE_MIDDLE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.LIMONITE_ORE_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.LIMONITE_ORE_DEEP_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.SAPHIRE_ORE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.SAPHIRE_ORE_BURIED);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.ROSITE_ORE_RARE);
			generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, XOresOrePlacements.ROSITE_ORE_BURIED);
		}
	}

	/**
	 * @param location The name of the {@link Biome} as a {@link String}
	 * @return {@code true} if the biome is a Peak Biome
	 */
	protected static boolean isPeakBiome(String location) {
		return location.equals("meadow") || location.equals("grove") || location.equals("snowy_slopes") || location.equals("frozen_peaks") || location.equals("jagged_peaks") || location.equals("stony_peaks");
	}
	
}
