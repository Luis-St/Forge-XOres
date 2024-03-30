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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * @author Luis-St
 *
 */

public enum XOArmorMaterials implements ArmorMaterial {
	
	JADE("jade", 15, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.BOOTS, 2);
	}), 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(XOItems.JADE_INGOT.get())),
	BLAZING("blazing", 29, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.BOOTS, 3);
	}), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(XOItems.BLAZING_INGOT.get())),
	SAPHIRE("saphire", 35, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.BOOTS, 3);
	}), 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, () -> Ingredient.of(XOItems.SAPHIRE_INGOT.get())),
	LIMONITE("limonite", 44, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 9);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.BOOTS, 4);
	}), 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.2F, () -> Ingredient.of(XOItems.LIMONITE_INGOT.get())),
	ENDERITE("enderite", 51, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 12);
		map.put(ArmorItem.Type.LEGGINGS, 8);
		map.put(ArmorItem.Type.BOOTS, 3);
	}), 26, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, () -> Ingredient.of(Items.BARRIER)),
	NIGHT("night", 59, Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 7);
		map.put(ArmorItem.Type.CHESTPLATE, 15);
		map.put(ArmorItem.Type.LEGGINGS, 11);
		map.put(ArmorItem.Type.BOOTS, 7);
	}), 35, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.4F, () -> Ingredient.of(Items.BARRIER));
	
	private static final Map<ArmorItem.Type, Integer> DURABILITY_PER_TYPE = Util.make(Maps.newEnumMap(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.HELMET, 11);
		map.put(ArmorItem.Type.CHESTPLATE, 16);
		map.put(ArmorItem.Type.LEGGINGS, 15);
		map.put(ArmorItem.Type.BOOTS, 13);
	});
	
	private final ResourceLocation name;
	private final int durabilityMultiplier;
	private final Map<ArmorItem.Type, Integer> slotDefenses;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final Supplier<Ingredient> repairIngredient;
	
	XOArmorMaterials(String name, int durabilityMultiplier, Map<ArmorItem.Type, Integer> slotDefenses, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = new ResourceLocation(XOres.MOD_ID, name);
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotDefenses = slotDefenses;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}
	
	@Override
	public @NotNull String getName() {
		return this.name.toString();
	}
	
	@Override
	public int getDurabilityForType(@NotNull ArmorItem.Type type) {
		return DURABILITY_PER_TYPE.get(type) * this.durabilityMultiplier;
	}
	
	@Override
	public int getDefenseForType(@NotNull ArmorItem.Type type) {
		return this.slotDefenses.get(type);
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	@Override
	public @NotNull SoundEvent getEquipSound() {
		return this.sound;
	}
	
	@Override
	public float getToughness() {
		return this.toughness;
	}
	
	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}
