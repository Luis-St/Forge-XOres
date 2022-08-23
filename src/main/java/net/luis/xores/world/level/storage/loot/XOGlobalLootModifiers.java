package net.luis.xores.world.level.storage.loot;

import net.luis.xores.XOres;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOGlobalLootModifiers {
	
	public static final DeferredRegister<GlobalLootModifierSerializer<?>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.LOOT_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	public static final RegistryObject<SmeltingModifier.Serializer> SMELTING_MODIFIER = LOOT_MODIFIERS.register("smelting_modifier", () -> {
		return new SmeltingModifier.Serializer();
	});
	
}
