package net.luis.xores.common.enums;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum ModArmorMaterials implements ArmorMaterial {

	JADE("jade", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.JADE_INGOT.get());
	}),
	LIMONITE("limonite", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.LIMONITE_INGOT.get());
	}),
	BLAZING("blazing", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.BLAZING_INGOT.get());
	}),
	ROSITE("rosite", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.ROSITE_INGOT.get());
	}),
	SAPHIRE("shphire", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.SAPHIRE_INGOT.get());
	}),
	ENDERITE("enderite", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	NIGHT("night", 0, new int[] {0, 0, 0, 0}, 0, null, 0.0F, 0.0F, () -> {
		return Ingredient.of(Items.BARRIER);
	});
	
	protected static final int[] DURABILITY_PER_SLOT = new int[] {13, 15, 16, 11};
	protected final String name;
	protected final int durabilityMultiplier;
	protected final int[] slotProtections;
	protected final int enchantmentValue;
	protected final SoundEvent sound;
	protected final float toughness;
	protected final float knockbackResistance;
	protected final Supplier<Ingredient> repairIngredient;

	private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = XOres.MOD_ID + ":" + name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotProtections = slotProtections;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
		return DURABILITY_PER_SLOT[equipmentSlot.getIndex()] * this.durabilityMultiplier;
	}

	@Override
	public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
		return this.slotProtections[equipmentSlot.getIndex()];
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public SoundEvent getEquipSound() {
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
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}
