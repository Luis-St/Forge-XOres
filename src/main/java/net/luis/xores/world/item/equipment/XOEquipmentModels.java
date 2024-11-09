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

package net.luis.xores.world.item.equipment;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.BiConsumer;

/**
 *
 * @author Luis-St
 *
 */

public interface XOEquipmentModels {
	
	static final ResourceLocation JADE = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "jade");
	static final ResourceLocation BLAZING = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "blazing");
	static final ResourceLocation SAPHIRE = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "saphire");
	static final ResourceLocation LIMONITE = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "limonite");
	static final ResourceLocation ENDERITE = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "enderite");
	static final ResourceLocation NIGHT = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "night");
	
	static final ResourceLocation DIAMOND_WINGS = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "diamond_wings");
	static final ResourceLocation NETHERITE_WINGS = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "netherite_wings");
	static final ResourceLocation ENDERITE_WINGS = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "enderite_wings");
	static final ResourceLocation NIGHT_WINGS = ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "night_wings");
	
	static void register(@NotNull BiConsumer<ResourceLocation, EquipmentModel> consumer) {
		consumer.accept(JADE, onlyHumanoid(JADE));
		consumer.accept(BLAZING, onlyHumanoid(BLAZING));
		consumer.accept(SAPHIRE, onlyHumanoid(SAPHIRE));
		consumer.accept(LIMONITE, onlyHumanoid(LIMONITE));
		consumer.accept(ENDERITE, onlyHumanoid(ENDERITE));
		consumer.accept(NIGHT, onlyHumanoid(NIGHT));
		
		consumer.accept(DIAMOND_WINGS, onlyHumanoidWings(ResourceLocation.withDefaultNamespace("diamond"), "diamond"));
		consumer.accept(NETHERITE_WINGS, onlyHumanoidWings(ResourceLocation.withDefaultNamespace("netherite"), "netherite"));
		consumer.accept(ENDERITE_WINGS, onlyHumanoidWings(ENDERITE, "enderite"));
		consumer.accept(NIGHT_WINGS, onlyHumanoidWings(NIGHT, "night"));
	}
	
	private static @NotNull EquipmentModel onlyHumanoid(@NotNull ResourceLocation location) {
		return EquipmentModel.builder().addHumanoidLayers(location).build();
	}
	
	private static @NotNull EquipmentModel onlyHumanoidWings(@NotNull ResourceLocation location, @NotNull String wings) {
		return EquipmentModel.builder()
			.addHumanoidLayers(location)
			.addLayers(EquipmentModel.LayerType.WINGS, new EquipmentModel.Layer(ResourceLocation.withDefaultNamespace(wings + "_elytra"), Optional.empty(), true))
			.build();
	}
}
