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

package net.luis.xores.data.provider;

import net.luis.xores.data.provider.level.*;
import net.luis.xores.data.provider.level.rarer.XORarerConfiguredFeatureProvider;
import net.luis.xores.data.provider.level.rarer.XORarerPlacedFeatureProvider;
import net.luis.xores.data.provider.level.very.XOVeryRareConfiguredFeatureProvider;
import net.luis.xores.data.provider.level.very.XOVeryRarePlacedFeatureProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOBuiltinProvider {
	
	public static @NotNull RegistrySetBuilder createProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XOPlacedFeatureProvider::create);
		builder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, XOBiomeModifierProvider::create);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createRarerPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XORarerConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XORarerPlacedFeatureProvider::create);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createVeryRarePackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOVeryRareConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XOVeryRarePlacedFeatureProvider::create);
		return builder;
	}
}
