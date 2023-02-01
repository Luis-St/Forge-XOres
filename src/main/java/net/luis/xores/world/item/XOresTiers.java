package net.luis.xores.world.item;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

/**
 * 
 * @author Luis-st
 *
 */

public enum XOresTiers implements Tier {
	
	JADE("jade", 190, 5.0F, 5.0F, 2, 28, () -> {
		return Ingredient.of(XOItems.JADE_INGOT.get());
	}),
	BLAZING("blazing", 905, 7.0F, 6.0F, 2, 12, () -> {
		return Ingredient.of(XOItems.BLAZING_INGOT.get());
	}),
	SAPHIRE("saphire", 1718, 8.0F, 8.0F, 3, 42, () -> {
		return Ingredient.of(XOItems.SAPHIRE_INGOT.get());
	}),
	LIMONITE("limonite", 3178, 10.0F, 10.0F, 5, 26, () -> {
		return Ingredient.of(XOItems.LIMONITE_INGOT.get());
	}),
	ROSE_QUARTZ("rose_quartz", 7693, 11.0F, 12.0F, 4, 17, () -> {
		return Ingredient.of(XOItems.POLISHED_ROSE_QUARTZ.get());
	}),
	ENDERITE("enderite", 10770, 14.0F, 16.0F, 5, 18, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	STEEL("steel", 12924, 18.0F, 5.0F, 6, 9, () -> {
		return Ingredient.of(XOItems.STEEL_INGOT.get());
	}),
	NIGHT("night", 16801, 15.0F, 19.0F, 5, 56, () -> {
		return Ingredient.of(Items.BARRIER);
	});
	
	private final ResourceLocation name;
	private final int uses;
	private final float speed;
	private final float attackDamageBonus;
	private final int level;
	private final int enchantmentValue;
	private final Supplier<Ingredient> repairIngredient;
	
	XOresTiers(String name, int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.name = new ResourceLocation(XOres.MOD_ID, name);
		this.uses = uses;
		this.speed = speed;
		this.attackDamageBonus = attackDamageBonus;
		this.level = level;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}
	
	public ResourceLocation getName() {
		return this.name;
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
	public int getLevel() {
		return this.level;
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
