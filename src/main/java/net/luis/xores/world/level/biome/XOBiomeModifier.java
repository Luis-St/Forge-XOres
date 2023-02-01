package net.luis.xores.world.level.biome;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.luis.xores.XOres;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import net.minecraftforge.registries.ForgeRegistries;

/**
 *
 * @author Luis-st
 *
 */

public record XOBiomeModifier(HolderSet<Biome> overworldBiomes, HolderSet<PlacedFeature> overworldFeatures, HolderSet<Biome> mountainPeakBiomes, HolderSet<PlacedFeature> mountainPeakFeatures, HolderSet<Biome> endBiomes,
							  HolderSet<PlacedFeature> endFeatures) implements BiomeModifier {
	
	public static final ResourceKey<BiomeModifier> KEY = ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(XOres.MOD_ID, "ore_biome_modifier"));
	
	public static final Codec<XOBiomeModifier> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Biome.LIST_CODEC.fieldOf("overworld_biomes").forGetter((biomeModifier) -> {
			return biomeModifier.overworldBiomes();
		}), PlacedFeature.LIST_CODEC.fieldOf("overworld_features").forGetter((biomeModifier) -> {
			return biomeModifier.overworldFeatures();
		}), Biome.LIST_CODEC.fieldOf("peak_biomes").forGetter((biomeModifier) -> {
			return biomeModifier.mountainPeakBiomes();
		}), PlacedFeature.LIST_CODEC.fieldOf("peak_features").forGetter((biomeModifier) -> {
			return biomeModifier.mountainPeakFeatures();
		}), Biome.LIST_CODEC.fieldOf("end_biomes").forGetter((biomeModifier) -> {
			return biomeModifier.endBiomes();
		}), PlacedFeature.LIST_CODEC.fieldOf("end_features").forGetter((biomeModifier) -> {
			return biomeModifier.endFeatures();
		})).apply(instance, XOBiomeModifier::new);
	});
	
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
	
	@Override
	public Codec<XOBiomeModifier> codec() {
		return XOBiomeModifiers.ORE_BIOME_MODIFIER.get();
	}
	
}
