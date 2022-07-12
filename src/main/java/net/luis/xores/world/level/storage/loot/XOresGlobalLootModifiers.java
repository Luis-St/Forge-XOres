package net.luis.xores.world.level.storage.loot;

import com.mojang.serialization.Codec;

import net.luis.xores.XOres;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all mod {@link Codec}s of the of all mod {@link IGlobalLootModifier}
 * 
 * @author Luis-st
 */

public class XOresGlobalLootModifiers {
	
	/**
	 * {@link DeferredRegister} for {@link Codec}s, used to register the {@link Codec}s of all mod {@link IGlobalLootModifier}
	 */
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the {@link Codec} of the {@link SmeltingModifier}
	 */
	public static final RegistryObject<Codec<SmeltingModifier>> SMELTING_MODIFIER = LOOT_MODIFIERS.register("smelting_modifier", () -> {
		return SmeltingModifier.CODEC;
	});
	
}
