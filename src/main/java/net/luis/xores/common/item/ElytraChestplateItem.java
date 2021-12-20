package net.luis.xores.common.item;

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

public class ElytraChestplateItem extends ArmorItem {

	public static final Map<ElytraChestplateItem, Integer> ELYTRA_DAMAGE_VALUES = Maps.newHashMap();
	public static final Random RNG = new Random(System.currentTimeMillis());
	
	public ElytraChestplateItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.CHEST, properties);
	}
	
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return ElytraItem.isFlyEnabled(stack);
	}
	
	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level.isClientSide && (flightTicks + 1) % ELYTRA_DAMAGE_VALUES.get(stack.getItem()) == 0) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
		}
		return true;
	}
	
	@Override
	public SoundEvent getEquipSound() {
		return RNG.nextInt(2) == 0 ? SoundEvents.ARMOR_EQUIP_ELYTRA : super.getEquipSound();
	}
	
}
