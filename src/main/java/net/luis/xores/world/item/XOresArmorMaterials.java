package net.luis.xores.world.item;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * implementation of {@link ArmorMaterial}, used for all mod {@link ArmorItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link ArmorMaterial}
 * @see {@link XOresItems}
 */

public enum XOresArmorMaterials implements ArmorMaterial {

	/**
	 * the {@link ArmorMaterial} for the jade armor
	 */
	JADE("jade", 15, new int[] {2, 5, 6, 2}, 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(XOresItems.JADE_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the blazing armor
	 */
	BLAZING("blazing", 0, new int[] {3, 6, 7, 3}, 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
		return Ingredient.of(XOresItems.BLAZING_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the saphire armor
	 */
	SAPHIRE("saphire", 35, new int[] {3, 6, 8, 3}, 12, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.1F, () -> {
		return Ingredient.of(XOresItems.SAPHIRE_INGOT.get());
	}),
	
	/**
	 * the {@link ArmorMaterial} for the limonite armor
	 */
	LIMONITE("limonite", 44, new int[] {4, 5, 9, 4}, 15, SoundEvents.ARMOR_EQUIP_IRON, 3.0F, 0.2F, () -> {
		return Ingredient.of(XOresItems.LIMONITE_INGOT.get());
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
	private static final int[] DURABILITY_PER_SLOT = new int[] {13, 15, 16, 11};
	
	/**
	 * the name of the {@link ArmorMaterial} as a {@link ResourceLocation}
	 */
	private final ResourceLocation name;
	
	/**
	 * the durability multiplier of the {@link ArmorMaterial},<br>
	 * which is applied to the {@link XOresArmorMaterials#DURABILITY_PER_SLOT}<br>
	 * based on the {@link EquipmentSlot}
	 */
	private final int durabilityMultiplier;
	
	/**
	 * the slot defenses of the {@link ArmorMaterial} for the {@link EquipmentSlot},<br>
	 * contains the values in the following order:
	 * <ol>
	 * 	<li>{@link EquipmentSlot#FEET}</li>
	 * 	<li>{@link EquipmentSlot#LEGS}</li>
	 * 	<li>{@link EquipmentSlot#CHEST}</li>
	 * 	<li>{@link EquipmentSlot#HEAD}</li>
	 * </ol>
	 */
	private final int[] slotDefenses;
	
	/**
	 * the enchantment value of the {@link ArmorMaterial}
	 */
	private final int enchantmentValue;
	
	/**
	 * the equip sound of the {@link ArmorMaterial}
	 */
	private final SoundEvent sound;
	
	/**
	 * the toughness of the {@link ArmorMaterial}
	 */
	private final float toughness;
	
	/**
	 * the knockback resistance of the {@link ArmorMaterial}
	 */
	private final float knockbackResistance;
	
	/**
	 * the repair ingredient of the {@link ArmorMaterial} as an {@link Supplier},<br>
	 * since the value of the {@link Ingredient} needs to be lazy load
	 */
	private final Supplier<Ingredient> repairIngredient;

	/**
	 * constructor for the {@link XOresArmorMaterials}
	 */
	private XOresArmorMaterials(String name, int durabilityMultiplier, int[] slotDefenses, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = new ResourceLocation(XOres.MOD_ID, name);
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
	 * @return {@link XOresArmorMaterials#name}
	 */
	@Override
	public String getName() {
		return this.name.toString();
	}
	
	/**
	 * getter for the durability
	 * @return the durability based on the {@link EquipmentSlot} and<br>
	 * multiplied by the {@link XOresArmorMaterials#durabilityMultiplier}
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
	 * @return {@link XOresArmorMaterials#enchantmentValue}
	 */
	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	/**
	 * getter for the equip sound of the material
	 * @return {@link XOresArmorMaterials#sound}
	 */
	@Override
	public SoundEvent getEquipSound() {
		return this.sound;
	}

	/**
	 * getter for the toughness of the material
	 * @return {@link XOresArmorMaterials#toughness}
	 */
	@Override
	public float getToughness() {
		return this.toughness;
	}

	/**
	 * getter for the knockback resistance of the material
	 * @return {@link XOresArmorMaterials#knockbackResistance}
	 */
	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	/**
	 * getter for the repair ingredient
	 * @return {@link XOresArmorMaterials#repairIngredient} as an {@link Ingredient}
	 */
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

}
