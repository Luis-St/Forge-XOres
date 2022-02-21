package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.loot.SmeltingModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all mod {@link GlobalLootModifierSerializer}s
 * 
 * @author Luis-st
 */

public class ModGlobalLootModifiers {
	
	/**
	 * {@link DeferredRegister} for {@link GlobalLootModifierSerializer}s, used to register all mod {@link GlobalLootModifierSerializer}s
	 */
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	/**
	 * {@link GlobalLootModifierSerializer} for the {@link SmeltingModifier}
	 */
	public static final RegistryObject<SmeltingModifier.Serializer> SMELTING_MODIFIER = LOOT_MODIFIERS.register("smelting_modifier", SmeltingModifier.Serializer::new);
	
}
