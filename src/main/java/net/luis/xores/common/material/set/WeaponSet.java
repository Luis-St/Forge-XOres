package net.luis.xores.common.material.set;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialType;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.SwordItem;

public class WeaponSet {
	
	public static final WeaponSet EMPTY = new WeaponSet.Builder().build();
	
	public static final MaterialType SWORD = new MaterialType("sword");
	public static final MaterialType SHIELD = new MaterialType("shield");
	public static final MaterialType BOW = new MaterialType("bow");
	public static final MaterialType CROSSBOW = new MaterialType("crossbow");
	
	protected final Optional<Material> weaponMaterial;
	protected final Optional<SwordItem> sword;
	protected final Optional<ShieldItem> shield;
	protected final Optional<BowItem> bow;
	protected final Optional<CrossbowItem> crossbow;
	
	WeaponSet(Optional<Material> weaponMaterial, Optional<SwordItem> sword, Optional<ShieldItem> shield, Optional<BowItem> bow, Optional<CrossbowItem> crossbow) {
		this.weaponMaterial = weaponMaterial;
		this.sword = sword;
		this.shield = shield;
		this.bow = bow;
		this.crossbow = crossbow;
	}
	
	public boolean hasWeaponMaterial() {
		return this.weaponMaterial.isPresent();
	}
	
	public Material getWeaponMaterial() {
		return this.weaponMaterial.get();
	}
	
	public List<MaterialType> getTypes() {
		return Lists.newArrayList(SWORD, SHIELD, BOW, CROSSBOW);
	}
	
	public boolean has(MaterialType type) {
		if (type == SWORD) {
			return this.sword.isPresent();
		} else if (type == SHIELD) {
			return this.shield.isPresent();
		} else if (type == BOW) {
			return this.bow.isPresent();
		} else if (type == CROSSBOW) {
			return this.crossbow.isPresent();
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
	public Item get(MaterialType type) {
		if (type == SWORD) {
			return this.sword.get();
		} else if (type == SHIELD) {
			return this.shield.get();
		} else if (type == BOW) {
			return this.bow.get();
		} else if (type == CROSSBOW) {
			return this.crossbow.get();
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
	
	public static class Builder {
		
		protected Material weaponMaterial = null;
		protected SwordItem sword = null;
		protected ShieldItem shield = null;
		protected BowItem bow = null;
		protected CrossbowItem crossbow = null;
		
		WeaponSet.Builder weaponMaterial(Material weaponMaterial) {
			this.weaponMaterial = weaponMaterial;
			return this;
		}
		
		public WeaponSet.Builder weaponMaterial(Item weaponMaterial) {
			return this.weaponMaterial(Material.item(weaponMaterial));
		}
		
		public WeaponSet.Builder weaponMaterial(Named<Item> weaponMaterial) {
			return this.weaponMaterial(Material.tag(weaponMaterial));
		}
		
		public WeaponSet.Builder sword(SwordItem sword) {
			this.sword = sword;
			return this;
		}
		
		public WeaponSet.Builder shield(ShieldItem shield) {
			this.shield = shield;
			return this;
		}
		
		public WeaponSet.Builder bow(BowItem bow) {
			this.bow = bow;
			return this;
		}
		
		public WeaponSet.Builder crossbow(CrossbowItem crossbow) {
			this.crossbow = crossbow;
			return this;
		}
		
		public WeaponSet build() {
			return new WeaponSet(Optional.ofNullable(this.weaponMaterial), Optional.ofNullable(this.sword), Optional.ofNullable(this.shield), Optional.ofNullable(this.bow), Optional.ofNullable(this.crossbow));
		}
		
	}
	
}
