package net.luis.xores.common.enums;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * implementation of {@link ArmorMaterial},<br>
 * used for all mod {@link ArmorItem}s
 * 
 * @author Luis-st
 */

public enum ModArmorMaterials implements ArmorMaterial {

	/**
	 * the {@link ArmorMaterial} for the jade armor
	 */
	JADE("jade", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.JADE_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the blazing armor
	 */
	BLAZING("blazing", 0, new int[] {3, 6, 7, 3}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(ModItems.BLAZING_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the saphire armor
	 */
	SAPHIRE("saphire", 35, new int[] {3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, () -> {
		return Ingredient.of(ModItems.SAPHIRE_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the limonite armor
	 */
	LIMONITE("limonite", 44, new int[] {4, 5, 9, 4}, 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.2F, () -> {
		return Ingredient.of(ModItems.LIMONITE_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the enderite armor
	 */
	ENDERITE("enderite", 51, new int[] {6, 8, 12, 6}, 26, SoundEvents.ARMOR_EQUIP_NETHERITE, 5.0F, 0.3F, () -> {
		return Ingredient.of(Items.BARRIER);
	}),
	
	/**
	 * the {@link ArmorMaterial} for the night armor
	 */
	NIGHT("night", 59, new int[] {7, 11, 15, 7}, 35, SoundEvents.ARMOR_EQUIP_NETHERITE, 8.0F, 0.4F, () -> {
		return Ingredient.of(Items.BARRIER);
	});
	
	/**
	 * the slot durability for the {@link EquipmentSlot},<br>
	 * contains the values in the following order:
	 * <ol>
	 * 	<li>{@link EquipmentSlot#FEET}</li>
	 * 	<li>{@link EquipmentSlot#LEGS}</li>
	 * 	<li>{@link EquipmentSlot#CHEST}</li>
	 * 	<li>{@link EquipmentSlot#HEAD}</li>
	 * </ol>
	 */
	protected static final int[] DURABILITY_PER_SLOT = new int[] {13, 15, 16, 11};
	
	/**
	 * the name
	 */
	protected final String name;
	
	/**
	 * the durability multiplier,<br>
	 * which is applied to the {@link ModArmorMaterials#DURABILITY_PER_SLOT}<br>
	 * based on the {@link EquipmentSlot}
	 */
	protected final int durabilityMultiplier;
	
	/**
	 * the slot defenses for the {@link EquipmentSlot},<br>
	 * contains the values in the following order:
	 * <ol>
	 * 	<li>{@link EquipmentSlot#FEET}</li>
	 * 	<li>{@link EquipmentSlot#LEGS}</li>
	 * 	<li>{@link EquipmentSlot#CHEST}</li>
	 * 	<li>{@link EquipmentSlot#HEAD}</li>
	 * </ol>
	 */
	protected final int[] slotDefenses;
	
	/**
	 * the enchantment value
	 */
	protected final int enchantmentValue;
	
	/**
	 * the equip sound
	 */
	protected final SoundEvent sound;
	
	/**
	 * the toughness
	 */
	protected final float toughness;
	
	/**
	 * the knockback resistance
	 */
	protected final float knockbackResistance;
	
	/**
	 * the repair ingredient as an {@link Supplier},<br>
	 * since the value of the {@link Ingredient} needs to be lazy load
	 */
	protected final Supplier<Ingredient> repairIngredient;

	/**
	 * constructor for the {@link ModArmorMaterials}
	 */
	private ModArmorMaterials(String name, int durabilityMultiplier, int[] slotDefenses, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = XOres.MOD_ID + ":" + name;
		this.durabilityMultiplier = durabilityMultiplier;
		this.slotDefenses = slotDefenses;
		this.enchantmentValue = enchantmentValue;
		this.sound = sound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.repairIngredient = repairIngredient;
	}
	
	/**
	 * getter for the name of the material
	 * @return {@link ModArmorMaterials#name}
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	/**
	 * getter for the durability
	 * @return the durability based on the {@link EquipmentSlot} and<br>
	 * multiplied by the {@link ModArmorMaterials#durabilityMultiplier}
	 */
	@Override
	public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
		return DURABILITY_PER_SLOT[equipmentSlot.getIndex()] * this.durabilityMultiplier;
	}

	/**
	 * getter for the defense
	 * @return the defense base on the {@link EquipmentSlot}
	 */
	@Override
	public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
		return this.slotDefenses[equipmentSlot.getIndex()];
	}
	
	/**
	 * getter for the enchantment value of the material
	 * @return {@link ModArmorMaterials#enchantmentValue}
	 */
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	/**
	 * getter for the equip sound of the material
	 * @return {@link ModArmorMaterials#sound}
	 */
	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	/**
	 * getter for the toughness of the material
	 * @return {@link ModArmorMaterials#toughness}
	 */
	@Override
	public float getToughness() {
		return this.toughness;
	}

	/**
	 * getter for the knockback resistance of the material
	 * @return {@link ModArmorMaterials#knockbackResistance}
	 */
	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	/**
	 * getter for the repair ingredient
	 * @return {@link ModArmorMaterials#repairIngredient} as an {@link Ingredient}
	 */
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}
