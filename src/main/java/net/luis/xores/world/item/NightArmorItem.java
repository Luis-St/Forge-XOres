package net.luis.xores.world.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/**
 *
 * @author Luis-st
 *
 */

public class NightArmorItem extends ArmorItem implements AbilityArmor {
	
	public NightArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public void onItemApplied(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (this.isWearingFullArmor(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 9999999, 1, false, false, false));
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 9999999, 0, false, false, false));
		}
	}
	
	@Override
	public void onItemRemoved(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (!this.isWearingFullArmor(entity)) {
			entity.removeEffect(MobEffects.DAMAGE_BOOST);
			entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
		}
	}
	
}
