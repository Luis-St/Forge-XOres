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

package net.luis.xores.data.provider.base.client;

import net.luis.xores.world.item.equipment.XOEquipmentModels;
import net.minecraft.data.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentModel;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Luis-St
 *
 */

public class XOEquipmentModelProvider implements DataProvider {
	
	private final PackOutput.PathProvider pathProvider;
	
	public XOEquipmentModelProvider(@NotNull DataGenerator generator) {
		this.pathProvider = generator.getPackOutput().createPathProvider(PackOutput.Target.RESOURCE_PACK, "models/equipment");
	}
	
	@Override
	public @NotNull CompletableFuture<?> run(@NotNull CachedOutput output) {
		Map<ResourceLocation, EquipmentModel> map = new HashMap<>();
		XOEquipmentModels.register((location, equipmentModel) -> {
			if (map.putIfAbsent(location, equipmentModel) != null) {
				throw new IllegalStateException("Tried to register equipment model twice for id: " + location);
			}
		});
		return DataProvider.saveAll(output, EquipmentModel.CODEC, this.pathProvider, map);
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Equipment Model Definitions";
	}
}
