package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.AbilityArmor;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import static net.luis.xores.world.item.ability.AbilityArmor.isWearingFullArmor;

/**
 *
 * @author Luis-St
 *
 */

public class BlazingArmorItem extends ArmorItem implements AbilityArmor {
	
	public BlazingArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public void onItemApplied(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (isWearingFullArmor(entity, this.getMaterial())) {
			entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, -1, 0, false, false, false));
		}
	}
	
	@Override
	public void onItemRemoved(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (!isWearingFullArmor(entity, this.getMaterial())) {
			entity.removeEffect(MobEffects.FIRE_RESISTANCE);
		}
	}
	
	
	@Override
	public boolean isAbilityEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect) {
		return effect == MobEffects.FIRE_RESISTANCE;
	}
}
