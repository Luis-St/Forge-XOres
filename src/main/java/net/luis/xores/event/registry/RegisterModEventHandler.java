package net.luis.xores.event.registry;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 *
 * @author Luis-st
 *
 */

@Mod.EventBusSubscriber(modid = XOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterModEventHandler {
	
	@SubscribeEvent
	public static void buildContents(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.COMBAT) {
			event.accept(XOItems.GOLDEN_SHIELD.get());
			event.accept(XOItems.COPPER_SHIELD.get());
			event.accept(XOItems.IRON_SHIELD.get());
			event.accept(XOItems.DIAMOND_SHIELD.get());
			event.accept(XOItems.NETHERITE_SHIELD.get());
			event.accept(XOItems.DIAMOND_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_BOW.get());
			event.accept(XOItems.NETHERITE_CROSSBOW.get());
		} else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(XOItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());
			event.accept(XOItems.NIGHT_UPGRADE_SMITHING_TEMPLATE.get());
		}
	}
}
