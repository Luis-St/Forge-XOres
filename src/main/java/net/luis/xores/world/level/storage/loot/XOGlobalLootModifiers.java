package net.luis.xores.world.level.storage.loot;

import com.mojang.serialization.Codec;
import net.luis.xores.XOres;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.*;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOGlobalLootModifiers {
	
	public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	public static final RegistryObject<Codec<SmeltingModifier>> SMELTING_MODIFIER = LOOT_MODIFIERS.register("smelting_modifier", () -> {
		return SmeltingModifier.CODEC;
	});
	public static final RegistryObject<Codec<TemplateModifier>> TEMPLATE_MODIFIER = LOOT_MODIFIERS.register("template_modifier", () -> {
		return TemplateModifier.CODEC;
	});
}
