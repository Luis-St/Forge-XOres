package net.luis.xores.common.enums;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.ModItems;
import net.luis.xores.init.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum ModTiers implements Tier {
	
	JADE("jade", 190, 5.0F, 5.0F, 2, ModTags.Blocks.TOOL_LEVEL_2, 28, () -> {
		return Ingredient.of(ModItems.JADE_INGOT.get());
	}),
	BLAZING("blazing", 905, 7.0F, 6.0F, 2, ModTags.Blocks.TOOL_LEVEL_2, 12, () -> {
		return Ingredient.of(ModItems.BLAZING_INGOT.get());
	}),
	SAPHIRE("saphire", 1718, 8.0F, 8.0F, 3, ModTags.Blocks.TOOL_LEVEL_3, 42, () -> {
		return Ingredient.of(ModItems.SAPHIRE_INGOT.get());
	}),
	LIMONITE("limonite", 3178, 10.0F, 10.0F, 5, ModTags.Blocks.TOOL_LEVEL_4, 26, () -> {
		return Ingredient.of(ModItems.LIMONITE_INGOT.get());
	}),
	ROSITE("rosite", 4916, 10.0F, 11.0F, 4, ModTags.Blocks.TOOL_LEVEL_4, 12, () -> {
		return Ingredient.of(ModItems.ROSITE_INGOT.get());
	}),
	ROSE_QUARTZ("rose_quartz", 7693, 11.0F, 12.0F, 4, ModTags.Blocks.TOOL_LEVEL_4, 17, () -> {
		return Ingredient.of(ModItems.ROSE_QUARTZ.get());
	}),
	ENDERITE("enderite", 10770, 14.0F, 16.0F, 5, ModTags.Blocks.TOOL_LEVEL_5, 18, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	STEEL("steel", 12924, 18.0F, 5.0F, 6, ModTags.Blocks.TOOL_LEVEL_6, 9, () -> {
		return Ingredient.of(ModItems.STEEL_INGOT.get());
	}),
	NIGHT("night", 16801, 15.0F, 19.0F, 5, ModTags.Blocks.TOOL_LEVEL_5, 56, () -> {
		return Ingredient.of(Items.BARRIER);
	});

	protected final ResourceLocation name;
	protected final int uses;
	protected final float speed;
	protected final float attackDamage;
	protected final int level;
	protected final Tag<Block> tag;
	protected final int enchantmentValue;
	protected final Supplier<Ingredient> repairIngredient;

	private ModTiers(String name, int uses, float speed, float attackDamage, int level, Tag<Block> tag, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
		this.name = new ResourceLocation(XOres.MOD_ID, name);
		this.uses = uses;
		this.speed = speed;
		this.attackDamage = attackDamage;
		this.level = level;
		this.tag = tag;
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
		return this.attackDamage;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public Tag<Block> getTag() {
		return this.tag ;
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
