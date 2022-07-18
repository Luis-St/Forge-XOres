package net.luis.xores.world.item;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

/**
 * 
 * @author Luis-st
 *
 */

public class ElytraChestplateItem extends ArmorItem {
	
	private static final Map<ElytraChestplateItem, Integer> ELYTRA_TIME_DAMAGE_VALUES = Maps.newHashMap();
	private static final Random RNG = new Random(System.currentTimeMillis());
	
	public ElytraChestplateItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.CHEST, properties);
	}
	
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return ElytraItem.isFlyEnabled(stack);
	}
	
	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level.isClientSide && (flightTicks + 1) % ELYTRA_TIME_DAMAGE_VALUES.getOrDefault(stack.getItem(), 20) == 0) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
		}
		return true;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return RNG.nextInt(2) == 0 ? SoundEvents.ARMOR_EQUIP_ELYTRA : super.getEquipSound();
	}
	
	public static void register(ElytraChestplateItem elytraChestplate, int damageValue) {
		ELYTRA_TIME_DAMAGE_VALUES.put(elytraChestplate, damageValue);
	}
	
}
