package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.Util;
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
		Util.make(ElytraChestplateItem.ELYTRA_DAMAGE_VALUES, map -> {
			map.put(ModItems.DIAMOND_ELYTRA_CHESTPLATE.get(), 40);
			map.put(ModItems.NETHERITE_ELYTRA_CHESTPLATE.get(), 60);
			map.put(ModItems.ENDERITE_ELYTRA_CHESTPLATE.get(), 80);
			map.put(ModItems.NIGHT_ELYTRA_CHESTPLATE.get(), 100);
		});
		replaceAttributeValue((RangedAttribute) Attributes.ARMOR, 512.0);
		replaceAttributeValue((RangedAttribute) Attributes.KNOCKBACK_RESISTANCE, 64.0);
	}
	
	protected static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
		attribute.maxValue = maxValue;
	}
	
}
