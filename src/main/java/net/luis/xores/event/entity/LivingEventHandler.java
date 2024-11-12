/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.event.entity;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ability.AbilityArmor;
import net.luis.xores.world.item.equipment.XOArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID)
public class LivingEventHandler {
	
	private static final List<ArmorMaterial> ARMOR_MATERIALS = List.of(
		XOArmorMaterials.JADE, XOArmorMaterials.BLAZING, XOArmorMaterials.SAPHIRE, XOArmorMaterials.LIMONITE, XOArmorMaterials.ENDERITE, XOArmorMaterials.NIGHT
	);
	
	@SubscribeEvent
	public static void livingEquipmentChange(@NotNull LivingEquipmentChangeEvent event) {
		EquipmentSlot slot = event.getSlot();
		if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
			ItemStack toStack = event.getTo();
			ItemStack fromStack = event.getFrom();
			if (toStack.getItem() instanceof AbilityArmor toItem && fromStack.getItem() instanceof AbilityArmor fromItem) {
				if (toItem == fromItem) {
					toItem.onItemChanged(event.getEntity(), slot, toStack, fromStack);
				} else {
					toItem.onItemApplied(event.getEntity(), slot, toStack);
					fromItem.onItemRemoved(event.getEntity(), slot, fromStack);
				}
			} else if (toStack.getItem() instanceof AbilityArmor toItem) {
				toItem.onItemApplied(event.getEntity(), slot, toStack);
			} else if (fromStack.getItem() instanceof AbilityArmor fromItem) {
				fromItem.onItemRemoved(event.getEntity(), slot, fromStack);
			}
		}
	}
	
	@SubscribeEvent
	public static void removeMobEffect(MobEffectEvent.@NotNull Remove event) {
		LivingEntity entity = event.getEntity();
		for (ArmorMaterial material : ARMOR_MATERIALS) {
			if (material == XOArmorMaterials.JADE) {
				continue;
			}
			AbilityArmor.getArmorPiece(entity, material).filter(piece -> piece.isAbilityEffect(entity, event.getEffect())).ifPresent(piece -> event.setCanceled(true));
		}
	}
}
