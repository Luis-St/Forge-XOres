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

package net.luis.xores.mixin;

import net.luis.xores.world.item.ElytraChestplateItem;
import net.minecraft.Util;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static net.minecraft.world.entity.LivingEntity.*;

/**
 *
 * @author Luis-St
 *
 */

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	
	//region Mixin
	@Shadow
	protected int fallFlyTicks;
	
	private LivingEntityMixin(@NotNull EntityType<?> entityType, @NotNull Level level) {
		super(entityType, level);
	}
	
	@Shadow
	protected abstract boolean canGlide();
	
	@Shadow
	protected abstract @NotNull ItemStack getItemBySlot(@NotNull EquipmentSlot slot);
	//endregion
	
	@SuppressWarnings("DataFlowIssue")
	@Inject(method = "updateFallFlying", at = @At("HEAD"), cancellable = true)
	protected void updateFallFlying(@NotNull CallbackInfo info) {
		this.checkSlowFallDistance();
		if (!this.level().isClientSide) {
			if (!this.canGlide()) {
				this.setSharedFlag(7, false);
				return;
			}
			int fallFlyTicks = this.fallFlyTicks + 1;
			Set<EquipmentSlot> slots = EquipmentSlot.VALUES.stream().filter(slot -> canGlideUsing(this.getItemBySlot(slot), slot)).collect(Collectors.toSet());
			if (slots.contains(EquipmentSlot.CHEST)) {
				ItemStack itemStack = this.getItemBySlot(EquipmentSlot.CHEST);
				int damageTimeValue = 20;
				if (itemStack.getItem() instanceof ElytraChestplateItem item) {
					damageTimeValue = ElytraChestplateItem.getDamageTimeValue(item);
				}
				if (fallFlyTicks % 10 == 0) {
					this.gameEvent(GameEvent.ELYTRA_GLIDE);
				}
				if (fallFlyTicks % damageTimeValue == 0) {
					itemStack.hurtAndBreak(1, (LivingEntity) (Object) this, EquipmentSlot.CHEST);
				}
			} else {
				EquipmentSlot slot = Util.getRandom(List.copyOf(slots), this.random);
				if (fallFlyTicks % 10 == 0) {
					if ((fallFlyTicks / 10) % 2 == 0) {
						this.getItemBySlot(slot).hurtAndBreak(1, (LivingEntity) (Object) this, slot);
					}
					this.gameEvent(GameEvent.ELYTRA_GLIDE);
				}
			}
		}
		info.cancel();
	}
}
