package net.luis.xores.event.fml;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.client.render.item.XOresItemProperties;
import net.luis.xores.client.render.overlay.XOresArmorOverlay;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOresItems;
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
	 * 	<li>the {@link XOresArmorOverlay}</li>
	 * 	<li>the {@link ItemProperties} of all {@link XOresItems#ITEMS}</li>
	 * </ul>
	 */
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		OverlayRegistry.registerOverlayAbove(ForgeIngameGui.ARMOR_LEVEL_ELEMENT, "Armor Bar", new XOresArmorOverlay(Minecraft.getInstance()));
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
