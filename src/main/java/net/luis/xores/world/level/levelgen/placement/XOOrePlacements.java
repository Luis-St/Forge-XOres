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

package net.luis.xores.world.level.levelgen.placement;

import net.luis.xores.XOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOOrePlacements {
	
	public static final ResourceKey<PlacedFeature> JADE_ORE_UPPER = createKey("jade_ore_upper");
	public static final ResourceKey<PlacedFeature> JADE_ORE_MIDDLE = createKey("jade_ore_middle");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = createKey("saphire_ore_rare_upper");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE = createKey("saphire_ore");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_BURIED = createKey("saphire_ore_buried");
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_BURIED = createKey("limonite_ore_buried");
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = createKey("limonite_ore_deep_buried");
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_RARE = createKey("enderite_ore_rare");
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_BURIED = createKey("enderite_ore_buried");
	
	public static void register() {
	
	}
	
	private static @NotNull ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(XOres.MOD_ID, name));
	}
}
