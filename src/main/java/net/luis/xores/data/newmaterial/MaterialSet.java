package net.luis.xores.data.newmaterial;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import net.luis.xores.XOres;
import net.luis.xores.data.newmaterial.stuff.ArmorSet;
import net.luis.xores.data.newmaterial.stuff.ToolSet;
import net.luis.xores.data.newmaterial.stuff.WeaponSet;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistryEntry;;

public class MaterialSet extends ForgeRegistryEntry<MaterialSet> {
	
	protected final Material material;
	protected final Optional<Material> materialPart;
	protected final Optional<Material> ore;
	protected final Optional<Material> deepslateOre;
	protected final Optional<Material> block;
	protected final Optional<Material> upgradeMaterial;
	protected final Optional<MaterialSet> upgradeMaterialSet;
	protected final WeaponSet weaponSet;
	protected final ToolSet toolSet;
	protected final ArmorSet armorSet;
	
	MaterialSet(Material material, Optional<Material> materialPart, Optional<Material> ore, Optional<Material> deepslateOre, Optional<Material> block, Optional<Material> upgradeMaterial, 
			Optional<MaterialSet> upgradeMaterialSet, WeaponSet weaponSet, ToolSet toolSet, ArmorSet armorSet) {
		this.material = Objects.requireNonNull(material, "The Material in a MaterialSet can not be null, use Material.EMPTY instead");
		this.materialPart = materialPart;
		this.ore = ore;
		this.deepslateOre = deepslateOre;
		this.block = block;
		this.upgradeMaterial = upgradeMaterial;
		this.upgradeMaterialSet = upgradeMaterialSet;
		this.weaponSet = weaponSet;
		this.toolSet = toolSet;
		this.armorSet = armorSet;
		this.valid();
	}
	
	public static MaterialSet.Builder of(Material material) {
		return new MaterialSet.Builder(material);
	}
	
	public static MaterialSet.Builder ofItem(Item item) {
		return new MaterialSet.Builder(Material.item(item));
	}
	
	public static MaterialSet.Builder ofTag(Named<Item> tag) {
		return new MaterialSet.Builder(Material.tag(tag));
	}
	
	public Material getMaterial() {
		return this.material;
	}
	
	public boolean hasMaterialPart() {
		return this.materialPart.isPresent();
	}
	
	public Material getMaterialPart() {
		return this.materialPart.get();
	}
	
	public boolean hasOre() {
		return this.ore.isPresent();
	}
	
	public Material getOre() {
		return this.ore.get();
	}
	
	public boolean hasDeepslateOre() {
		return this.deepslateOre.isPresent();
	}
	
	public Material getDeepslateOre() {
		return this.deepslateOre.get();
	}
	
	public boolean hasBlock() {
		return this.block.isPresent();
	}
	
	public Material getBlock() {
		return this.block.get();
	}
	
	public boolean isUpgradeMaterial() {
		if (this.upgradeMaterial.isPresent() && this.upgradeMaterialSet.isPresent()) {
			return true;
		}
		return false;
	}
	
	public Material getUpgradeMaterial() {
		return this.upgradeMaterial.get();
	}
	
	public MaterialSet getUpgradeMaterialSet() {
		return this.upgradeMaterialSet.get();
	}
	
	public boolean hasMaterialOverwrite() {
		return this.weaponSet.hasWeaponMaterial() || this.toolSet.hasToolMaterial() || this.armorSet.hasArmorMaterial();
	}
	
	public WeaponSet getWeaponSet() {
		return this.weaponSet;
	}
	
	public ToolSet getToolSet() {
		return this.toolSet;
	}
	
	public ArmorSet getArmorSet() {
		return this.armorSet;
	}

	protected String getName() {
		if (this.getRegistryName() != null) {
			return this.getRegistryName().getPath();
		} else if (this.material != Material.EMPTY) {
			return this.material.getName();
		} else if (this.weaponSet.hasWeaponMaterial() && this.toolSet.hasToolMaterial() && this.armorSet.hasArmorMaterial()) {
			if (this.weaponSet.getWeaponMaterial().equals(this.toolSet.getToolMaterial()) && this.weaponSet.getWeaponMaterial().equals(this.armorSet.getArmorMaterial())) {
				return this.weaponSet.getWeaponMaterial().getName();
			} else {
				int i = new Random().nextInt(3);
				if (i == 0) {
					return this.weaponSet.getWeaponMaterial().getName();
				} else if (i == 1) {
					return this.toolSet.getToolMaterial().getName();
				} else if (i == 1) {
					return this.armorSet.getArmorMaterial().getName();
				}
			}
		}
		XOres.LOGGER.warn("Fail to get the name from a MaterialSet");
		return "";
	}
	
	protected final void valid() {
		if (this.material == Material.EMPTY) {
			XOres.LOGGER.warn("The material of the MaterialSet {} is empty", this.getName());
		}
		boolean flag = upgradeMaterial.isPresent();
		if (!flag && upgradeMaterialSet.isPresent()) {
			throw new NullPointerException("No UpgradeMaterial present in MaterialSet " + this.getName());
		}
		if (flag && upgradeMaterialSet.isEmpty()) {
			throw new NullPointerException("No UpgradeMaterialSet present in MaterialSet " + this.getName());
		}
	}
	
	public static class Builder {
		
		protected final Material material;
		protected Material materialPart = null;
		protected Material ore = null;
		protected Material deepslateOre = null;
		protected Material block = null;
		protected Material upgradeMaterial = null;
		protected MaterialSet upgradeMaterialSet = null;
		protected WeaponSet weaponSet = WeaponSet.EMPTY;
		protected ToolSet toolSet = ToolSet.EMPTY;
		protected ArmorSet armorSet = ArmorSet.EMPTY;
		
		Builder(Material material) {
			this.material = material;
		}
		
		MaterialSet.Builder materialPart(Material materialPart) {
			this.materialPart = materialPart;
			return this;
		}
		
		public MaterialSet.Builder materialPart(Item materialPart) {
			return this.materialPart(Material.item(materialPart));
		}
		
		public MaterialSet.Builder materialPart(Named<Item> materialPart) {
			return this.materialPart(Material.tag(materialPart));
		}
		
		MaterialSet.Builder ore(Material ore) {
			this.ore = ore;
			return this;
		}
		
		public MaterialSet.Builder ore(Item ore) {
			return this.ore(Material.item(ore));
		}
		
		public MaterialSet.Builder ore(Named<Item> ore) {
			return this.ore(Material.tag(ore));
		}
		
		MaterialSet.Builder deepslateOre(Material deepslateOre) {
			this.deepslateOre = deepslateOre;
			return this;
		}
		
		public MaterialSet.Builder deepslateOre(Item deepslateOre) {
			return this.deepslateOre(Material.item(deepslateOre));
		}
		
		public MaterialSet.Builder deepslateOre(Named<Item> deepslateOre) {
			return this.deepslateOre(Material.tag(deepslateOre));
		}
		
		MaterialSet.Builder block(Material block) {
			this.block = block;
			return this;
		}
		
		public MaterialSet.Builder block(Item block) {
			return this.block(Material.item(block));
		}
		
		public MaterialSet.Builder block(Named<Item> block) {
			return this.block(Material.tag(block));
		}
		
		MaterialSet.Builder upgradeMaterial(Material upgradeMaterial) {
			this.upgradeMaterial = upgradeMaterial;
			return this;
		}
		
		public MaterialSet.Builder upgradeMaterial(Item upgradeMaterial) {
			return this.upgradeMaterial(Material.item(upgradeMaterial));
		}
		
		public MaterialSet.Builder upgradeMaterial(Named<Item> upgradeMaterial) {
			return this.upgradeMaterial(Material.tag(upgradeMaterial));
		}
		
		public MaterialSet.Builder upgradeMaterialSet(MaterialSet upgradeMaterialSet) {
			this.upgradeMaterialSet = upgradeMaterialSet;
			return this;
		}
		
		public MaterialSet.Builder weaponSet(WeaponSet.Builder builder) {
			this.weaponSet = builder.build();
			return this;
		}
		
		public MaterialSet.Builder toolSet(ToolSet.Builder builder) {
			this.toolSet = builder.build();
			return this;
		}
		
		public MaterialSet.Builder armorSet(ArmorSet.Builder builder) {
			this.armorSet = builder.build();
			return this;
		}
		
		public MaterialSet build() {
			return new MaterialSet(this.material, Optional.ofNullable(this.materialPart), Optional.ofNullable(this.ore), Optional.ofNullable(this.deepslateOre), Optional.ofNullable(this.block),Optional.ofNullable(this.upgradeMaterial), 
					Optional.ofNullable(this.upgradeMaterialSet), this.weaponSet, this.toolSet, this.armorSet);
		}
		
	}
	
}
