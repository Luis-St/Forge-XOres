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

import com.google.common.collect.Maps;
import net.luis.xores.tags.XOItemTags;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.*;

import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Luis-St
 *
 */

public class XOArmorMaterials {
	
	private static final Map<ArmorType, Integer> DIAMOND_DEFENSE = Util.make(new EnumMap<>(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.LEGGINGS, 6);
		map.put(ArmorType.CHESTPLATE, 8);
		map.put(ArmorType.HELMET, 3);
		map.put(ArmorType.BODY, 11);
	});
	private static final Map<ArmorType, Integer> NETHERITE_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.LEGGINGS, 6);
		map.put(ArmorType.CHESTPLATE, 8);
		map.put(ArmorType.HELMET, 3);
		map.put(ArmorType.BODY, 11);
	});
	
	private static final Map<ArmorType, Integer> JADE_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 2);
		map.put(ArmorType.CHESTPLATE, 6);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.BOOTS, 2);
		map.put(ArmorType.BODY, 7);
	});
	private static final Map<ArmorType, Integer> BLAZING_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 3);
		map.put(ArmorType.CHESTPLATE, 7);
		map.put(ArmorType.LEGGINGS, 6);
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.BODY, 10);
	});
	private static final Map<ArmorType, Integer> SAPHIRE_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 3);
		map.put(ArmorType.CHESTPLATE, 8);
		map.put(ArmorType.LEGGINGS, 6);
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.BODY, 10);
	});
	private static final Map<ArmorType, Integer> LIMONITE_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 4);
		map.put(ArmorType.CHESTPLATE, 9);
		map.put(ArmorType.LEGGINGS, 5);
		map.put(ArmorType.BOOTS, 4);
		map.put(ArmorType.BODY, 11);
	});
	private static final Map<ArmorType, Integer> ENDERITE_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 6);
		map.put(ArmorType.CHESTPLATE, 12);
		map.put(ArmorType.LEGGINGS, 8);
		map.put(ArmorType.BOOTS, 3);
		map.put(ArmorType.BODY, 14);
	});
	private static final Map<ArmorType, Integer> NIGHT_DEFENSE = Util.make(Maps.newEnumMap(ArmorType.class), map -> {
		map.put(ArmorType.HELMET, 7);
		map.put(ArmorType.CHESTPLATE, 15);
		map.put(ArmorType.LEGGINGS, 11);
		map.put(ArmorType.BOOTS, 7);
		map.put(ArmorType.BODY, 20);
	});
	
	public static final ArmorMaterial JADE = new ArmorMaterial(15, JADE_DEFENSE, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, XOItemTags.REPAIRS_JADE_ARMOR, XOEquipmentModels.JADE);
	public static final ArmorMaterial BLAZING = new ArmorMaterial(29, BLAZING_DEFENSE, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, XOItemTags.REPAIRS_BLAZING_ARMOR, XOEquipmentModels.BLAZING);
	public static final ArmorMaterial SAPHIRE = new ArmorMaterial(35, SAPHIRE_DEFENSE, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, XOItemTags.REPAIRS_SAPHIRE_ARMOR, XOEquipmentModels.SAPHIRE);
	public static final ArmorMaterial LIMONITE = new ArmorMaterial(44, LIMONITE_DEFENSE, 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.2F, XOItemTags.REPAIRS_LIMONITE_ARMOR, XOEquipmentModels.LIMONITE);
	public static final ArmorMaterial ENDERITE = new ArmorMaterial(51, DIAMOND_DEFENSE, 26, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, XOItemTags.REPAIRS_ENDERITE_ARMOR, XOEquipmentModels.ENDERITE);
	public static final ArmorMaterial NIGHT = new ArmorMaterial(59, NETHERITE_DEFENSE, 35, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.4F, XOItemTags.REPAIRS_NIGHT_ARMOR, XOEquipmentModels.NIGHT);
	
	public static final ArmorMaterial DIAMOND_WINGS = new ArmorMaterial(33, DIAMOND_DEFENSE, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, ItemTags.REPAIRS_DIAMOND_ARMOR, EquipmentModels.DIAMOND);
	public static final ArmorMaterial NETHERITE_WINGS = new ArmorMaterial(37, NETHERITE_DEFENSE, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_NETHERITE_ARMOR, EquipmentModels.NETHERITE);
	public static final ArmorMaterial ENDERITE_WINGS = new ArmorMaterial(51, DIAMOND_DEFENSE, 26, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, XOItemTags.REPAIRS_ENDERITE_ARMOR, XOEquipmentModels.ENDERITE_WINGS);
	public static final ArmorMaterial NIGHT_WINGS = new ArmorMaterial(59, NETHERITE_DEFENSE, 35, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.4F, XOItemTags.REPAIRS_NIGHT_ARMOR, XOEquipmentModels.NIGHT_WINGS);
}
