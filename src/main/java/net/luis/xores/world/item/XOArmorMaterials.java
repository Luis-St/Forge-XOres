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
import net.luis.xores.XOres;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * @author Luis-St
 *
 */

public class XOArmorMaterials {
	
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, XOres.MOD_ID);
	
	private static final Map<ArmorItem.Type, Integer> JADE_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.BOOTS, 2);
	});
	private static final Map<ArmorItem.Type, Integer> BLAZING_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.BOOTS, 3);
	});
	private static final Map<ArmorItem.Type, Integer> SAPHIRE_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.BOOTS, 3);
	});
	private static final Map<ArmorItem.Type, Integer> LIMONITE_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 9);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.BOOTS, 4);
	});
	private static final Map<ArmorItem.Type, Integer> ENDERITE_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 12);
		map.put(ArmorItem.Type.LEGGINGS, 8);
		map.put(ArmorItem.Type.BOOTS, 3);
	});
	private static final Map<ArmorItem.Type, Integer> NIGHT_DEFENSE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 7);
		map.put(ArmorItem.Type.CHESTPLATE, 15);
		map.put(ArmorItem.Type.LEGGINGS, 11);
		map.put(ArmorItem.Type.BOOTS, 7);
	});
	
	public static final RegistryObject<ArmorMaterial> JADE = ARMOR_MATERIALS.register("jade", () -> {
		return new ArmorMaterial(JADE_DEFENSE, 10, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(XOItems.JADE_INGOT.get()), createLayers("jade"), 0.0F, 0.0F);
	});
	public static final RegistryObject<ArmorMaterial> BLAZING = ARMOR_MATERIALS.register("blazing", () -> {
		return new ArmorMaterial(BLAZING_DEFENSE, 9, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(XOItems.BLAZING_INGOT.get()), createLayers("blazing"), 0.0F, 0.0F);
	});
	public static final RegistryObject<ArmorMaterial> SAPHIRE = ARMOR_MATERIALS.register("saphire", () -> {
		return new ArmorMaterial(SAPHIRE_DEFENSE, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(XOItems.SAPHIRE_INGOT.get()), createLayers("saphire"), 2.0F, 0.1F);
	});
	public static final RegistryObject<ArmorMaterial> LIMONITE = ARMOR_MATERIALS.register("limonite", () -> {
		return new ArmorMaterial(LIMONITE_DEFENSE, 15, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(XOItems.LIMONITE_INGOT.get()), createLayers("limonite"), 3.0F, 0.2F);
	});
	public static final RegistryObject<ArmorMaterial> ENDERITE = ARMOR_MATERIALS.register("enderite", () -> {
		return new ArmorMaterial(ENDERITE_DEFENSE, 26, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Items.BARRIER), createLayers("enderite"), 5.0F, 0.3F);
	});
	public static final RegistryObject<ArmorMaterial> NIGHT = ARMOR_MATERIALS.register("night", () -> {
		return new ArmorMaterial(NIGHT_DEFENSE, 35, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(Items.BARRIER), createLayers("night"), 8.0F, 0.4F);
	});
	
	private static @Unmodifiable @NotNull List<ArmorMaterial.Layer> createLayers(@NotNull String name) {
		return List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
	}
}
