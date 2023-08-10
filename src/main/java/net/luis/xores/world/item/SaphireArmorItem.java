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

public class SaphireArmorItem extends ArmorItem implements AbilityArmor {
	
	public SaphireArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public void onItemApplied(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (isWearingFullArmor(entity, this.getMaterial())) {
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, -1, 1, false, false, false));
			entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, -1, 0, false, false, false));
		}
	}
	
	@Override
	public void onItemRemoved(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (!isWearingFullArmor(entity, this.getMaterial())) {
			entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			entity.removeEffect(MobEffects.DOLPHINS_GRACE);
		}
	}
	
	@Override
	public boolean isAbilityEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect) {
		return effect == MobEffects.MOVEMENT_SPEED || effect == MobEffects.DOLPHINS_GRACE;
	}
}
