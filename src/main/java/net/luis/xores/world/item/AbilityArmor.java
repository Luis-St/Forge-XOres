package net.luis.xores.world.item;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

/**
 * 
 * @author Luis-st
 *
 */

public interface AbilityArmor {
	
	private ArmorItem self() {
		return (ArmorItem) this;
	}
	
	void onItemApplied(LivingEntity entity, EquipmentSlot slot, ItemStack stack);
	
	default void onItemChanged(LivingEntity entity, EquipmentSlot slot, ItemStack oldStack, ItemStack newStack) {
		
	}
	
	void onItemRemoved(LivingEntity entity, EquipmentSlot slot, ItemStack stack);
	
	default boolean isWearingFullArmor(LivingEntity entity) {
		List<ItemStack> stacks = this.getArmorItems(entity);
		if (stacks.size() != 4) {
			return false;
		}
		return stacks.stream().map(ItemStack::getItem).filter((stack) -> {
			return stack instanceof ArmorItem;
		}).map(ArmorItem.class::cast).filter((stack) -> {
			return stack.getMaterial() != this.self().getMaterial();
		}).findAny().isEmpty();
	}
	
	default List<ItemStack> getArmorItems(LivingEntity entity) {
		List<ItemStack> stacks = Lists.newArrayList();
		for (EquipmentSlot slot : EquipmentSlot.values()) {
			if (slot.getType() == EquipmentSlot.Type.ARMOR) {
				stacks.add(entity.getItemBySlot(slot));
			}
		}
		return stacks.stream().filter((stack) -> {
			return !stack.isEmpty();
		}).collect(Collectors.toList());
	}
	
}
