package net.luis.xores.event.client;

import net.luis.xores.XOres;
import net.luis.xores.client.gui.overlay.XOresArmorOverlay;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * {@link RegisterGuiOverlaysEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnRegisterGuiOverlaysEvent {
	
	/**
	 * register the {@link XOresArmorOverlay}
	 */
	@SubscribeEvent
	public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
		event.registerAbove(VanillaGuiOverlay.ARMOR_LEVEL.id(), "Armor Bar", new XOresArmorOverlay(Minecraft.getInstance()));
	}
	
}
