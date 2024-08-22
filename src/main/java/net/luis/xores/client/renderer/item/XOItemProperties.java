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

package net.luis.xores.client.renderer.item;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ChargedProjectiles;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOItemProperties {
	
	public static void registerBow(@NotNull BowItem bow) {
		ItemProperties.register(bow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getUseItem() != stack ? 0.0F : (stack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		ItemProperties.register(bow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	public static void registerCrossbow(@NotNull CrossbowItem crossbow) {
		ItemProperties.register(crossbow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / CrossbowItem.getChargeDuration(stack, livingEntity);
			}
		});
		ItemProperties.register(crossbow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "charged"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbow, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "firework"), (stack, level, livingEntity, seed) -> {
			ChargedProjectiles chargedProjectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
			return chargedProjectiles != null && chargedProjectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
		});
	}
	
	public static void registerShield(@NotNull ShieldItem shield) {
		ItemProperties.register(shield, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "blocking"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	public static void registerElytraChestplate(@NotNull ElytraChestplateItem elytraChestplate) {
		ItemProperties.register(elytraChestplate, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "broken"), (stack, level, livingEntity, seed) -> {
			return ElytraItem.isFlyEnabled(stack) ? 0.0F : 1.0F;
		});
	}
}
