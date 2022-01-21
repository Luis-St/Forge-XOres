package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.loot.SmeltingModifier;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModGlobalLootModifiers {
	
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.LOOT_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	
	public static final RegistryObject<SmeltingModifier.Serializer> SMELTING_MODIFIER = LOOT_MODIFIERS.register("smelting_modifier", SmeltingModifier.Serializer::new);
	
}
