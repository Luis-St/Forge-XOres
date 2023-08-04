package net.luis.xores.world.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;

/**
 *
 * @author Luis-st
 *
 */

public class BlazingArmorItem extends ArmorItem implements AbilityArmor {
	
	public BlazingArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public void onItemApplied(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (this.isWearingFullArmor(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0, false, false, false));
		}
	}
	
	@Override
	public void onItemRemoved(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (!this.isWearingFullArmor(entity)) {
			entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		}
	}
}
