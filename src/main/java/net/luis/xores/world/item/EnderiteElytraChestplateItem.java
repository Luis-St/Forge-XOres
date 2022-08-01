package net.luis.xores.world.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/**
 * 
 * @author Luis-st
 *
 */

public class EnderiteElytraChestplateItem extends ElytraChestplateItem implements AbilityArmor {

	public EnderiteElytraChestplateItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, properties);
	}

	@Override
	public void onItemApplied(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (this.isWearingFullArmor(entity)) {
			entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 9999999, 0, false, false, false));
		}
	}

	@Override
	public void onItemRemoved(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
		if (!this.isWearingFullArmor(entity)) {
			entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
		}
	}

}
