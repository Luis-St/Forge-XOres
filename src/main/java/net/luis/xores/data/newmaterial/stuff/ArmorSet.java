package net.luis.xores.data.newmaterial.stuff;

import java.util.Optional;

import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.data.newmaterial.Material;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class ArmorSet {
	
	public static final ArmorSet EMPTY = new ArmorSet.Builder().build();
	
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
	
	public boolean hasHelmet() {
		return this.helmet.isPresent();
	}
	
	public ArmorItem getHelmet() {
		return this.helmet.get();
	}
	
	public boolean hasChestplate() {
		return this.chestplate.isPresent();
	}
	
	public ArmorItem getChestplate() {
		return this.chestplate.get();
	}
	
	public boolean hasElytraChestplate() {
		return this.elytraChestplate.isPresent();
	}
	
	public ElytraChestplateItem getElytraChestplate() {
		return this.elytraChestplate.get();
	}
	
	public boolean hasLeggings() {
		return this.leggings.isPresent();
	}
	
	public ArmorItem getLeggings() {
		return this.leggings.get();
	}
	
	public boolean hasBoots() {
		return this.boots.isPresent();
	}
	
	public ArmorItem getBoots() {
		return this.boots.get();
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
