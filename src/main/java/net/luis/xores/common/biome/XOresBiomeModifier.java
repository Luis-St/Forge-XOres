package net.luis.xores.common.biome;

import com.mojang.serialization.Codec;

import net.luis.xores.init.level.XOresBiomeModifiers;
import net.luis.xores.init.level.XOresOrePlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;

/**
 * implementation of {@link BiomeModifier}, used to generate all mod ores in the level 
 * 
 * @author Luis-st
 * 
 * @see {@link BiomeModifier}
 * @see {@link XOresOrePlacements}
 */

public record XOresBiomeModifier(HolderSet<Biome> overworldBiomes, HolderSet<PlacedFeature> overworldFeatures, HolderSet<Biome> mountainPeakBiomes, HolderSet<PlacedFeature> mountainPeakFeatures, HolderSet<Biome> endBiomes, 
	HolderSet<PlacedFeature> endFeatures) implements BiomeModifier {

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
	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD) {
			BiomeGenerationSettingsBuilder generationBuilder = builder.getGenerationSettings();
			if (this.overworldBiomes.contains(biome)) {
				if (this.mountainPeakBiomes.contains(biome)) {
					for (Holder<PlacedFeature> holder : this.mountainPeakFeatures) {
						generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, holder);
					}
				}
				for (Holder<PlacedFeature> holder : this.overworldFeatures) {
					generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, holder);
				}
			} else if (this.endBiomes.contains(biome)) {
				for (Holder<PlacedFeature> holder : this.endFeatures) {
					generationBuilder.addFeature(Decoration.UNDERGROUND_ORES, holder);
				}
			}
		}
	}

	/**
	 * getter for the {@link Codec} of the {@link XOresBiomeModifier}
	 */
	@Override
	public Codec<XOresBiomeModifier> codec() {
		return XOresBiomeModifiers.ORE_BIOME_MODIFIER.get();
	}

}
