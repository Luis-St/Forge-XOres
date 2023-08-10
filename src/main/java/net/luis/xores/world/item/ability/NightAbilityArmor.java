package net.luis.xores.world.item.ability;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static net.luis.xores.world.item.ability.AbilityArmor.*;

/**
 *
 * @author Luis-St
 *
 */

public interface NightAbilityArmor extends AbilityArmor {
	
	@Override
	default void onItemApplied(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (isWearingFullArmor(entity, this.getMaterial())) {
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, -1, 1, false, false, false));
			entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, -1, 0, false, false, false));
		}
	}
	
	@Override
	default void onItemRemoved(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (!isWearingFullArmor(entity, this.getMaterial())) {
			entity.removeEffect(MobEffects.DAMAGE_BOOST);
			entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
		}
	}
	
	@Override
	default boolean isAbilityEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect) {
		return effect == MobEffects.DAMAGE_BOOST || effect == MobEffects.DAMAGE_RESISTANCE;
	}
}
