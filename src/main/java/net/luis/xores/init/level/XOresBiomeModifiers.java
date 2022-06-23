package net.luis.xores.init.level;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.luis.xores.XOres;
import net.luis.xores.common.biome.XOresBiomeModifier;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all mod {@link Codec}s of the of all mod {@link BiomeModifier}
 * 
 * @author Luis-st
 * 
 * @see {@link BiomeModifier}
 */

public class XOresBiomeModifiers {
	
	/**
	 * {@link DeferredRegister} for {@link Codec}s, used to register the {@link Codec}s of all mod {@link BiomeModifier}
	 */
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the {@link Codec} of the {@link XOresBiomeModifier}
	 */
	public static final RegistryObject<Codec<XOresBiomeModifier>> ORE_BIOME_MODIFIER = BIOME_MODIFIERS.register("ore_biome_modifier", () -> {
		return RecordCodecBuilder.create((instance) -> {
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
			})).apply(instance, XOresBiomeModifier::new);
		});
	});
	
}
