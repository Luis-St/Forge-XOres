package net.luis.xores.event.village;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOresItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * {@link VillagerTradesEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID)
public class OnVillagerTradesEvent {
	
	/**
	 * adds all mod {@link ItemListing}s to the related {@link VillagerProfession}
	 */
	@SubscribeEvent
	public static void villagerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(2).add(new BasicItemListing(9, new ItemStack(XOresItems.IRON_SHIELD.get()), 12, 10, 0.2F));
		}
	}
	
}
