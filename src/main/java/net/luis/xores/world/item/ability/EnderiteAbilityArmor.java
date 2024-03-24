package net.luis.xores.world.item.ability;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import static net.luis.xores.world.item.ability.AbilityArmor.*;

/**
 *
 * @author Luis-St
 *
 */

public interface EnderiteAbilityArmor extends AbilityArmor {
	
	@NotNull ArmorMaterial getAbilityMaterial();
	
	@Override
	default void onItemApplied(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (isWearingFullArmor(entity, this.getAbilityMaterial())) {
			entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, -1, 0, false, false, false));
		}
	}
	
	@Override
	default void onItemRemoved(@NotNull LivingEntity entity, @NotNull EquipmentSlot slot, @NotNull ItemStack stack) {
		if (!isWearingFullArmor(entity, this.getAbilityMaterial())) {
			entity.removeEffect(MobEffects.HERO_OF_THE_VILLAGE);
		}
	}
	
	@Override
	default boolean isAbilityEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect) {
		return effect == MobEffects.HERO_OF_THE_VILLAGE;
	}
}
