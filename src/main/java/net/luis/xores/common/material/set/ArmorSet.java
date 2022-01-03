package net.luis.xores.common.material.set;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialType;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ArmorSet {
	
	public static final ArmorSet EMPTY = new ArmorSet.Builder().build();
	
	public static final MaterialType HELMET = new MaterialType("helmet");
	public static final MaterialType CHESTPLATE = new MaterialType("chestplate");
	public static final MaterialType ELYTRA_CHESTPLATE = new MaterialType("elytra_chestplate");
	public static final MaterialType LEGGINGS = new MaterialType("leggings");
	public static final MaterialType BOOTS = new MaterialType("boots");
	
	protected final Optional<Material> armorMaterial;
	protected final Optional<ArmorItem> helmet;
	protected final Optional<ArmorItem> chestplate;
	protected final Optional<ElytraChestplateItem> elytraChestplate;
	protected final Optional<ArmorItem> leggings;
	protected final Optional<ArmorItem> boots;
	
	ArmorSet(Optional<Material> armorMaterial, Optional<ArmorItem> helmet, Optional<ArmorItem> chestplate, Optional<ElytraChestplateItem> elytraChestplate, Optional<ArmorItem> leggings, Optional<ArmorItem> boots) {
		this.armorMaterial = armorMaterial;
		this.helmet = valid(helmet, EquipmentSlot.HEAD);
		this.chestplate = valid(chestplate, EquipmentSlot.CHEST);
		this.elytraChestplate = elytraChestplate;
		this.leggings = valid(leggings, EquipmentSlot.LEGS);
		this.boots = valid(boots, EquipmentSlot.FEET);
	}
	
	public boolean hasArmorMaterial() {
		return this.armorMaterial.isPresent();
	}
	
	public Material getArmorMaterial() {
		return this.armorMaterial.get();
	}
	
	public List<MaterialType> getTypes() {
		return Lists.newArrayList(HELMET, CHESTPLATE, ELYTRA_CHESTPLATE, LEGGINGS, BOOTS);
	}
	
	public boolean has(MaterialType type) {
		if (type == HELMET) {
			return this.helmet.isPresent();
		} else if (type == CHESTPLATE) {
			return this.chestplate.isPresent();
		} else if (type == ELYTRA_CHESTPLATE) {
			return this.elytraChestplate.isPresent();
		} else if (type == LEGGINGS) {
			return this.leggings.isPresent();
		} else if (type == BOOTS) {
			return this.boots.isPresent();
		}
		return false;
	}
	
	public boolean hasAll() {
		for (MaterialType type : this.getTypes()) {
			if (!this.has(type)) {
				return false;
			}
		}
		return true;
	}
	
	@Nullable
	public ArmorItem get(MaterialType type) {
		if (type == HELMET) {
			return this.helmet.get();
		} else if (type == CHESTPLATE) {
			return this.chestplate.get();
		} else if (type == ELYTRA_CHESTPLATE) {
			return this.elytraChestplate.get();
		} else if (type == LEGGINGS) {
			return this.leggings.get();
		} else if (type == BOOTS) {
			return this.boots.get();
		}
		return null;
	}
	
	public void ifPresent(MaterialType type, Consumer<Item> consumer) {
		if (this.has(type)) {
			consumer.accept(this.get(type));
		}
	}
	
	public void ifPresent(MaterialType firstType, MaterialType secondType, BiConsumer<Item, Item> consumer) {
		if (this.has(firstType) && this.has(secondType)) {
			consumer.accept(this.get(firstType), this.get(secondType));
		}
	}
	
	protected static Optional<ArmorItem> valid(Optional<ArmorItem> optional, EquipmentSlot equipmentSlot) {
		if (optional.isPresent()) {
			ArmorItem armorItem = optional.get();
			if (armorItem.getSlot() != equipmentSlot) {
				throw new IllegalArgumentException("The EquipmentSlot " + armorItem.getSlot() + " is not valid for " + equipmentSlot);
			}
			return optional;
		} else {
			return Optional.empty();
		}
	}
	
	public static class Builder {
		
		protected Material armorMaterial = null;
		protected ArmorItem helmet = null;
		protected ArmorItem chestplate = null;
		protected ElytraChestplateItem elytraChestplate = null;
		protected ArmorItem leggings = null;
		protected ArmorItem boots = null;
		
		ArmorSet.Builder armorMaterial(Material armorMaterial) {
			this.armorMaterial = armorMaterial;
			return this;
		}
		
		public ArmorSet.Builder armorMaterial(Item armorMaterial) {
			return this.armorMaterial(Material.item(armorMaterial));
		}
		
		public ArmorSet.Builder armorMaterial(Named<Item> armorMaterial) {
			return this.armorMaterial(Material.tag(armorMaterial));
		}
		
		public ArmorSet.Builder helmet(ArmorItem helmet) {
			this.helmet = valid(helmet, EquipmentSlot.HEAD);
			return this;
		}
		
		public ArmorSet.Builder chestplate(ArmorItem chestplate) {
			this.chestplate = valid(chestplate, EquipmentSlot.CHEST);
			return this;
		}
		
		public ArmorSet.Builder elytraChestplate(ElytraChestplateItem elytraChestplate) {
			this.elytraChestplate = elytraChestplate;
			return this;
		}
		
		public ArmorSet.Builder leggings(ArmorItem leggings) {
			this.leggings = valid(leggings, EquipmentSlot.LEGS);
			return this;
		}
		
		public ArmorSet.Builder boots(ArmorItem boots) {
			this.boots = valid(boots, EquipmentSlot.FEET);
			return this;
		}
		
		protected static ArmorItem valid(ArmorItem armorItem, EquipmentSlot equipmentSlot) {
			if (armorItem != null && armorItem.getSlot() != equipmentSlot) {
				throw new IllegalArgumentException("The EquipmentSlot " + armorItem.getSlot() + " is not valid for " + equipmentSlot);
			}
			return armorItem;
		}
		
		public ArmorSet build() {
			return new ArmorSet(Optional.ofNullable(this.armorMaterial), Optional.ofNullable(this.helmet), Optional.ofNullable(this.chestplate), Optional.ofNullable(this.elytraChestplate), Optional.ofNullable(this.leggings), 
					Optional.ofNullable(this.boots));
		}
		
	}
	
}
