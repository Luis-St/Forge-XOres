package net.luis.xores.common.enums;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.XOresItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * implementation of {@link Tier}, used for all mod {@link TieredItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link Tier}
 * @see {@link XOresItems}
 */

public enum XOresTiers implements Tier {
	
	/**
	 * the {@link Tier} for the jade tools
	 */
	JADE("jade", 190, 5.0F, 5.0F, 2, 28, () -> {
		return Ingredient.of(XOresItems.JADE_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the blazing tools
	 */
	BLAZING("blazing", 905, 7.0F, 6.0F, 2, 12, () -> {
		return Ingredient.of(XOresItems.BLAZING_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the saphire tools
	 */
	SAPHIRE("saphire", 1718, 8.0F, 8.0F, 3, 42, () -> {
		return Ingredient.of(XOresItems.SAPHIRE_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the limonite tools
	 */
	LIMONITE("limonite", 3178, 10.0F, 10.0F, 5, 26, () -> {
		return Ingredient.of(XOresItems.LIMONITE_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the rosite tools
	 */
	ROSITE("rosite", 4916, 10.0F, 11.0F, 4, 12, () -> {
		return Ingredient.of(XOresItems.ROSITE_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the rose quartz tools
	 */
	ROSE_QUARTZ("rose_quartz", 7693, 11.0F, 12.0F, 4, 17, () -> {
		return Ingredient.of(XOresItems.ROSE_QUARTZ.get());
	}),
	
	/**
	 * the {@link Tier} for the enderite tools
	 */
	ENDERITE("enderite", 10770, 14.0F, 16.0F, 5, 18, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	
	/**
	 * the {@link Tier} for the steel tools
	 */
	STEEL("steel", 12924, 18.0F, 5.0F, 6, 9, () -> {
		return Ingredient.of(XOresItems.STEEL_INGOT.get());
	}),
	
	/**
	 * the {@link Tier} for the night tools
	 */
	NIGHT("night", 16801, 15.0F, 19.0F, 5, 56, () -> {
		return Ingredient.of(Items.BARRIER);
	});

	/**
	 * the name of the {@link Tier} as a {@link ResourceLocation}
	 */
	protected final ResourceLocation name;
	
	/**
	 * the uses of the {@link Tier}
	 */
	protected final int uses;
	
	/**
	 * the mining speed of the {@link Tier}
	 */
	protected final float speed;
	
	/**
	 * the attack damage bonus of the {@link Tier}
	 */
	protected final float attackDamageBonus;
	
	/**
	 * the harvest level of the {@link Tier}
	 */
	protected final int level;
	
	/**
	 * the enchantment value of the {@link Tier}
	 */
	protected final int enchantmentValue;
	
	/**
	 * the repair ingredient of the {@link Tier} as an {@link Supplier},<br>
	 * since the value of the {@link Ingredient} needs to be lazy load
	 */
	protected final Supplier<Ingredient> repairIngredient;

	/**
	 * constructor for the {@link XOresTiers}
	 */
	private XOresTiers(String name, int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.name = new ResourceLocation(XOres.MOD_ID, name);
		this.uses = uses;
		this.speed = speed;
		this.attackDamageBonus = attackDamageBonus;
		this.level = level;
		this.enchantmentValue = enchantmentValue;
		this.repairIngredient = repairIngredient;
	}
	
	/**
	 * getter for the name of the tier
	 * @return {@link XOresTiers#name}
	 */
	public ResourceLocation getName() {
		return this.name;
	}
	
	/**
	 * getter for the uses of the tier
	 * @return {@link XOresTiers#uses}
	 */
	@Override
	public int getUses() {
		return this.uses;
	}

	/**
	 * getter for the mining speed of the tier
	 * @return {@link XOresTiers#speed}
	 */
	@Override
	public float getSpeed() {
		return this.speed;
	}

	/**
	 * getter for the attack damage bonus,<br>
	 * which will be add to the default damge
	 * @return {@link XOresTiers#attackDamageBonus}
	 */
	@Override
	public float getAttackDamageBonus() {
		return this.attackDamageBonus;
	}

	/**
	 * getter for the harvest level of the tier
	 * @return {@link XOresTiers#level}
	 */
	@Override
	public int getLevel() {
		return this.level;
	}
	
	/**
	 * getter for the enchantment value of the tier
	 * @return {@link XOresTiers#enchantmentValue}
	 */
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	/**
	 * getter for the repair ingredient
	 * @return {@link XOresTiers#repairIngredient} as an {@link Ingredient}
	 */
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}
