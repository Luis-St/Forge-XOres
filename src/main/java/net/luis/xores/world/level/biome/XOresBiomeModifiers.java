package net.luis.xores.world.level.biome;

import com.mojang.serialization.Codec;

import net.luis.xores.XOres;
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
		return XOresBiomeModifier.CODEC;
	});
	
}
