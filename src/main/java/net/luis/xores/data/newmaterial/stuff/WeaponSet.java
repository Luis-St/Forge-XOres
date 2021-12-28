package net.luis.xores.data.newmaterial.stuff;

import java.util.Optional;

import net.luis.xores.data.newmaterial.Material;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.SwordItem;

public class WeaponSet {
	
	public static final WeaponSet EMPTY = new WeaponSet.Builder().build();
	
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
	
	public boolean hasSword() {
		return this.sword.isPresent();
	}
	
	public SwordItem getSword() {
		return this.sword.get();
	}
	
	public boolean hasShield() {
		return this.shield.isPresent();
	}
	
	public ShieldItem getShield() {
		return this.shield.get();
	}
	
	public boolean hasBow() {
		return this.bow.isPresent();
	}
	
	public BowItem getBow() {
		return this.bow.get();
	}
	
	public boolean hasCrossbow() {
		return this.crossbow.isPresent();
	}
	
	public CrossbowItem getCrossbow() {
		return this.crossbow.get();
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
