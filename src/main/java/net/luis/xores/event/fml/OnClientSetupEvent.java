package net.luis.xores.event.fml;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.client.render.item.ModItemProperties;
import net.luis.xores.client.render.overlay.ModArmorOverlay;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * {@link FMLClientSetupEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	/**
	 * register the client stuff of {@link XOres}:<br>
	 * <ul>
	 * 	<li>the {@link ModArmorOverlay}</li>
	 * 	<li>the {@link ItemProperties} of all {@link ModItems#ITEMS}</li>
	 * </ul>
	 */
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		OverlayRegistry.registerOverlayAbove(ForgeIngameGui.ARMOR_LEVEL_ELEMENT, "Armor Bar", new ModArmorOverlay(Minecraft.getInstance()));
		event.enqueueWork(() -> {
			for (Item item : ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
				if (item instanceof BowItem bow) {
					ModItemProperties.registerBow(bow);
				} else if (item instanceof CrossbowItem crossbow) {
					ModItemProperties.registerCrossbow(crossbow);
				} else if (item instanceof ShieldItem shield) {
					ModItemProperties.registerShield(shield);	
				} else if (item instanceof ElytraChestplateItem elytraChestplate) {
					ModItemProperties.registerElytraChestplate(elytraChestplate);
				}
			}
		});
	}
	
}
