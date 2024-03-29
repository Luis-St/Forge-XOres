package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.client.renderer.item.XOItemProperties;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOItems;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventHandler {
	
	@SubscribeEvent
	public static void clientSetup(@NotNull FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			for (Item item : XOItems.ITEMS.getEntries().stream().map(RegistryObject::get).toList()) {
				if (item instanceof BowItem bow) {
					XOItemProperties.registerBow(bow);
				} else if (item instanceof CrossbowItem crossbow) {
					XOItemProperties.registerCrossbow(crossbow);
				} else if (item instanceof ShieldItem shield) {
					XOItemProperties.registerShield(shield);
				} else if (item instanceof ElytraChestplateItem elytraChestplate) {
					XOItemProperties.registerElytraChestplate(elytraChestplate);
				}
			}
		});
	}
}
