package net.luis.xores.common.enums;

import java.util.function.Supplier;

import net.luis.xores.init.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModTiers implements Tier {
	
	JADE(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.JADE_INGOT.get());
	}),
	LIMONITE(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.LIMONITE_INGOT.get());
	}),
	BLAZING(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.BLAZING_INGOT.get());
	}),
	ROSITE(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.ROSITE_INGOT.get());
	}),
	ROSE_QUARTZ(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.ROSE_QUARTZ.get());
	}),
	SAPHIRE(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.SAPHIRE_INGOT.get());
	}),
	STEEL(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(ModItems.STEEL_INGOT.get());
	}),
	ENDERITE(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	NIGHT(0, 0.0F, 0.0F, 0, 0, () -> {
		return Ingredient.of(Items.BARRIER);
	});

	protected final int uses;
	protected final float speed;
	protected final float attackDamage;
	protected final int level;
	protected final int enchantmentValue;
	protected final Supplier<Ingredient> repairIngredient;

	private ModTiers(int uses, float speed, float attackDamage, int level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.uses = uses;
		this.speed = speed;
		this.attackDamage = attackDamage;
		this.level = level;
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
		return this.attackDamage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}
