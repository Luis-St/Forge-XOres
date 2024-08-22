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

import net.luis.xores.tags.XOBlockTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 *
 * @author Luis-St
 *
 */

public enum XOresTiers implements Tier {
	
	JADE(190, 5.0F, 5.0F, BlockTags.INCORRECT_FOR_IRON_TOOL, 28, () -> Ingredient.of(XOItems.JADE_INGOT.get())),
	BLAZING(905, 7.0F, 6.0F, BlockTags.INCORRECT_FOR_IRON_TOOL, 12, () -> Ingredient.of(XOItems.BLAZING_INGOT.get())),
	SAPHIRE(1718, 8.0F, 8.0F, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 42, () -> Ingredient.of(XOItems.SAPHIRE_INGOT.get())),
	LIMONITE(3178, 10.0F, 10.0F, XOBlockTags.INCORRECT_FOR_ENDERITE_TOOL, 26, () -> Ingredient.of(XOItems.LIMONITE_INGOT.get())),
	ROSE_QUARTZ(7693, 11.0F, 12.0F, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 17, () -> Ingredient.of(XOItems.POLISHED_ROSE_QUARTZ.get())),
	ENDERITE(10770, 14.0F, 16.0F, XOBlockTags.INCORRECT_FOR_ENDERITE_TOOL, 18, () -> Ingredient.of(Items.BARRIER)),
	STEEL(12924, 18.0F, 5.0F, XOBlockTags.INCORRECT_FOR_STEEL_TOOL, 9, () -> Ingredient.of(XOItems.STEEL_INGOT.get())),
	NIGHT(16801, 15.0F, 19.0F, XOBlockTags.INCORRECT_FOR_ENDERITE_TOOL, 56, () -> Ingredient.of(Items.BARRIER));
	
	private final int uses;
	private final float speed;
	private final float attackDamageBonus;
	private final TagKey<Block> incorrectBlocksForDrops;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;
	
	XOresTiers(int uses, float speed, float attackDamageBonus, @NotNull TagKey<Block> incorrectBlocksForDrops, int enchantmentValue, @NotNull Supplier<Ingredient> repairIngredient) {
		this.uses = uses;
		this.speed = speed;
		this.attackDamageBonus = attackDamageBonus;
		this.incorrectBlocksForDrops = incorrectBlocksForDrops;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}
	
	@Override
	public int getUses() {
		return this.uses;
	}
	
	@Override
	public float getSpeed() {
		return this.speed;
	}
	
	@Override
	public float getAttackDamageBonus() {
		return this.attackDamageBonus;
	}
	
	@Override
	public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
		return this.incorrectBlocksForDrops;
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	@Override
	public @NotNull Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
}
