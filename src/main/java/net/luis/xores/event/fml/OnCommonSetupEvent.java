package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.Util;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

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
	}
	
}
