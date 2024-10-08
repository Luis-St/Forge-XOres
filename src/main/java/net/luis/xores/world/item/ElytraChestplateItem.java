/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.world.item;

import com.google.common.collect.Maps;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Random;

/**
 *
 * @author Luis-St
 *
 */

public class ElytraChestplateItem extends ArmorItem {
	
	private static final Map<ElytraChestplateItem, Integer> ELYTRA_TIME_DAMAGE_VALUES = Maps.newHashMap();
	private static final Random RNG = new Random(System.currentTimeMillis());
	
	public ElytraChestplateItem(@NotNull Holder<ArmorMaterial> material, @NotNull Properties properties) {
		super(material, Type.CHESTPLATE, properties);
	}
	
	public static void register(@NotNull ElytraChestplateItem elytraChestplate, int damageValue) {
		ELYTRA_TIME_DAMAGE_VALUES.put(elytraChestplate, damageValue);
	}
	
	@Override
	public boolean canElytraFly(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
		return ElytraItem.isFlyEnabled(stack);
	}
	
	@Override
	public boolean elytraFlightTick(@NotNull ItemStack stack, @NotNull LivingEntity entity, int flightTicks) {
		if (!entity.level().isClientSide && (flightTicks + 1) % ELYTRA_TIME_DAMAGE_VALUES.getOrDefault(this, 20) == 0) {
			stack.hurtAndBreak(1, entity, EquipmentSlot.CHEST);
		}
		return true;
	}
	
	@Override
	public @NotNull Holder<SoundEvent> getEquipSound() {
		return RNG.nextInt(2) == 0 ? SoundEvents.ARMOR_EQUIP_ELYTRA : super.getEquipSound();
	}
}
