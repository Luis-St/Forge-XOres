package net.luis.xores.world.level.biome;

import com.mojang.serialization.Codec;
import net.luis.xores.XOres;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.*;

/**
 *
 * @author Luis-st
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOBiomeModifiers {
	
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	public static final RegistryObject<Codec<XOBiomeModifier>> ORE_BIOME_MODIFIER = BIOME_MODIFIERS.register("ore_biome_modifier", () -> {
		return XOBiomeModifier.CODEC;
	});
}
