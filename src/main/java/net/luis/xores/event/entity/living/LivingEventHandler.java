package net.luis.xores.event.entity.living;

import net.luis.xores.XOres;
import net.luis.xores.world.item.AbilityArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID)
public class LivingEventHandler {
	
	@SubscribeEvent
	public static void livingEquipmentChange(@NotNull LivingEquipmentChangeEvent event) {
		EquipmentSlot slot = event.getSlot();
		if (slot.getType() == EquipmentSlot.Type.ARMOR) {
			ItemStack toStack = event.getTo();
			ItemStack fromStack = event.getFrom();
			if (toStack.getItem() instanceof AbilityArmor toItem && fromStack.getItem() instanceof AbilityArmor fromItem && toItem == fromItem) {
				toItem.onItemChanged(event.getEntity(), slot, toStack, fromStack);
			} else if (toStack.getItem() instanceof AbilityArmor toItem) {
				toItem.onItemApplied(event.getEntity(), slot, toStack);
			} else if (fromStack.getItem() instanceof AbilityArmor fromItem) {
				fromItem.onItemRemoved(event.getEntity(), slot, fromStack);
			}
		}
	}
}
