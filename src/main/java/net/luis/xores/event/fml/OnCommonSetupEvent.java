package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOItems;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		ElytraChestplateItem.register(XOItems.DIAMOND_ELYTRA_CHESTPLATE.get(), 40);
		ElytraChestplateItem.register(XOItems.NETHERITE_ELYTRA_CHESTPLATE.get(), 60);
		ElytraChestplateItem.register(XOItems.ENDERITE_ELYTRA_CHESTPLATE.get(), 80);
		ElytraChestplateItem.register(XOItems.NIGHT_ELYTRA_CHESTPLATE.get(), 100);
		event.enqueueWork(() -> {
			replaceAttributeValue((RangedAttribute) Attributes.ARMOR, 512.0);
			replaceAttributeValue((RangedAttribute) Attributes.KNOCKBACK_RESISTANCE, 64.0);
		});
	}
	
	private static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
		attribute.maxValue = maxValue;
	}
	
}
