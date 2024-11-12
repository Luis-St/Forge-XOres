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

package net.luis.xores.world.item.ability;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Luis-St
 *
 */

public interface AbilityArmor {
	
	static List<ItemStack> getArmorItems(@NotNull LivingEntity entity) {
		return Stream.of(EquipmentSlot.values()).filter(EquipmentSlot::isArmor).map(entity::getItemBySlot).filter(stack -> !stack.isEmpty()).collect(Collectors.toList());
	}
	
	static boolean isWearingFullAbilityArmor(@NotNull LivingEntity entity, @NotNull ArmorMaterial material) {
		return isWearingFullAbilityArmor(getArmorItems(entity), material);
	}
	
	static boolean isWearingFullAbilityArmor(@NotNull List<ItemStack> stacks, @NotNull ArmorMaterial material) {
		if (stacks.size() != 4) {
			return false;
		}
		Set<EquipmentSlot> types = EnumSet.noneOf(EquipmentSlot.class);
		for (ItemStack stack : stacks) {
			if (!(stack.getItem() instanceof AbilityArmor abilityArmor)) {
				return false;
			}
			if (abilityArmor.getAbilityMaterial() != material) {
				return false;
			}
			if (!stack.has(DataComponents.EQUIPPABLE)) {
				return false;
			}
			if (!types.add(stack.get(DataComponents.EQUIPPABLE).slot())) {
				return false;
			}
		}
		return types.size() == 4;
	}
	
	static Optional<AbilityArmor> getArmorPiece(@NotNull LivingEntity entity, @NotNull ArmorMaterial material) {
		List<ItemStack> stacks = getArmorItems(entity);
		if (stacks.size() != 4 || !isWearingFullAbilityArmor(stacks, material)) {
			return Optional.empty();
		}
		return stacks.stream().map(ItemStack::getItem).filter(AbilityArmor.class::isInstance).map(AbilityArmor.class::cast).filter(abilityArmor -> {
			return abilityArmor.getAbilityMaterial() == material;
		}).findAny();
	}
	
	@NotNull ArmorMaterial getAbilityMaterial();
	
	void onItemApplied(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack);
	
	default void onItemChanged(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack oldStack, @NotNull ItemStack newStack) {}
	
	void onItemRemoved(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack);
	
	boolean isAbilityEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect);
}
