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

package net.luis.xores.world.level.biome;

import com.mojang.serialization.Codec;
import net.luis.xores.XOres;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.*;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOBiomeModifiers {
	
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, XOres.MOD_ID);
	
	public static final RegistryObject<Codec<XOBiomeModifier>> ORE_BIOME_MODIFIER = BIOME_MODIFIERS.register("ore_biome_modifier", () -> {
		return XOBiomeModifier.CODEC;
	});
}
