package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.XOresItems;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * {@link FMLCommonSetupEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	/**
	 * register the common stuff of {@link XOres}:<br>
	 * <ul>
	 * 	<li>{@link ElytraChestplateItem#ELYTRA_TIME_DAMAGE_VALUES}</li>
	 * </ul>
	 * replace the max value of the following {@link RangedAttribute}s:
	 * <ul>
	 * 	<li>{@link Attributes#ARMOR}</li>
	 * 	<li>{@link Attributes#KNOCKBACK_RESISTANCE}</li>
	 * </ul>
	 */
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		ElytraChestplateItem.register(XOresItems.DIAMOND_ELYTRA_CHESTPLATE.get(), 40);
		ElytraChestplateItem.register(XOresItems.NETHERITE_ELYTRA_CHESTPLATE.get(), 60);
		ElytraChestplateItem.register(XOresItems.ENDERITE_ELYTRA_CHESTPLATE.get(), 80);
		ElytraChestplateItem.register(XOresItems.NIGHT_ELYTRA_CHESTPLATE.get(), 100);
		event.enqueueWork(() -> {
			replaceAttributeValue((RangedAttribute) Attributes.ARMOR, 512.0);
			replaceAttributeValue((RangedAttribute) Attributes.KNOCKBACK_RESISTANCE, 64.0);
		});
	}
	
	/**
	 * replace the max value of the given {@link RangedAttribute}
	 * @param attribute The {@link RangedAttribute}
	 * @param maxValue The new max value
	 */
	private static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
		attribute.maxValue = maxValue;
	}
	
}
