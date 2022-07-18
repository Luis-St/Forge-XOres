package net.luis.xores.event.fml;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.client.renderer.item.XOresItemProperties;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOresItems;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			for (Item item : XOresItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
				if (item instanceof BowItem bow) {
					XOresItemProperties.registerBow(bow);
				} else if (item instanceof CrossbowItem crossbow) {
					XOresItemProperties.registerCrossbow(crossbow);
				} else if (item instanceof ShieldItem shield) {
					XOresItemProperties.registerShield(shield);	
				} else if (item instanceof ElytraChestplateItem elytraChestplate) {
					XOresItemProperties.registerElytraChestplate(elytraChestplate);
				}
			}
		});
	}
	
}
