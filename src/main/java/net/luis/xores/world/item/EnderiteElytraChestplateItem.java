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

import net.luis.xores.world.item.ability.EnderiteAbilityArmor;
import net.minecraft.world.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class EnderiteElytraChestplateItem extends ElytraChestplateItem implements EnderiteAbilityArmor {
	
	public EnderiteElytraChestplateItem(ArmorMaterial material, Properties properties) {
		super(material, properties);
	}
	
	@Override
	public @NotNull ArmorMaterial getAbilityMaterial() {
		return XOArmorMaterials.ENDERITE;
	}
}
