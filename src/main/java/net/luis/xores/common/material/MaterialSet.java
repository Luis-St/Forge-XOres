package net.luis.xores.common.material;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import org.apache.logging.log4j.util.TriConsumer;

import com.google.common.collect.Lists;

import net.luis.xores.XOres;
import net.luis.xores.common.material.set.ArmorSet;
import net.luis.xores.common.material.set.ToolSet;
import net.luis.xores.common.material.set.WeaponSet;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistryEntry;;

public class MaterialSet extends ForgeRegistryEntry<MaterialSet> {
	
	public static final MaterialType MATERIAL = new MaterialType("material");
	public static final MaterialType MATERIAL_PART = new MaterialType("material_part");
	public static final MaterialType ORE = new MaterialType("ore");
	public static final MaterialType DEEPSLATE_ORE = new MaterialType("deepslate_ore");
	public static final MaterialType BLOCK = new MaterialType("block");
	public static final MaterialType UPGRADE_MATERIAL = new MaterialType("upgrade_material");
	
	protected final Material material;
	protected final Optional<Material> materialPart;
	protected final Optional<Material> ore;
	protected final Optional<Material> deepslateOre;
	protected final Optional<Material> block;
	protected final Optional<Material> upgradeMaterial;
	protected final Optional<Supplier<MaterialSet>> upgradeMaterialSet;
	protected final WeaponSet weaponSet;
	protected final ToolSet toolSet;
	protected final ArmorSet armorSet;
	
	MaterialSet(Material material, Optional<Material> materialPart, Optional<Material> ore, Optional<Material> deepslateOre, Optional<Material> block, Optional<Material> upgradeMaterial, 
			Optional<Supplier<MaterialSet>> upgradeMaterialSet, WeaponSet weaponSet, ToolSet toolSet, ArmorSet armorSet) {
		this.material = Objects.requireNonNull(material, "The Material in a MaterialSet can not be null, use a Material with Items.Air instead");
		this.materialPart = materialPart;
		this.ore = ore;
		this.deepslateOre = deepslateOre;
		this.block = block;
		this.upgradeMaterial = upgradeMaterial;
		this.upgradeMaterialSet = upgradeMaterialSet;
		this.weaponSet = weaponSet;
		this.toolSet = toolSet;
		this.armorSet = armorSet;
	}
	
	public static MaterialSet.Builder ofItem(Item item) {
		return new MaterialSet.Builder(Material.item(item));
	}
	
	public static MaterialSet.Builder ofTag(Named<Item> tag) {
		return new MaterialSet.Builder(Material.tag(tag));
	}
	
	public List<MaterialType> getTypes() {
		return Lists.newArrayList(MATERIAL, MATERIAL_PART, ORE, DEEPSLATE_ORE, BLOCK);
	}
	
	public boolean has(MaterialType type) {
		if (type == MATERIAL) {
			return this.material != null;
		} else if (type == MATERIAL_PART) {
			return this.materialPart.isPresent();
		} else if (type == ORE) {
			return this.ore.isPresent();
		} else if (type == DEEPSLATE_ORE) {
			return this.deepslateOre.isPresent();
		} else if (type == BLOCK) {
			return this.block.isPresent();
		}else if (type == UPGRADE_MATERIAL) {
			return this.upgradeMaterial.isPresent() && this.upgradeMaterialSet.isPresent();
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
	public Material get(MaterialType type) {
		if (type == MATERIAL && this.has(type)) {
			return this.material;
		} else if (type == MATERIAL_PART && this.has(type)) {
			return this.materialPart.get();
		} else if (type == ORE && this.has(type)) {
			return this.ore.get();
		} else if (type == DEEPSLATE_ORE && this.has(type)) {
			return this.deepslateOre.get();
		} else if (type == BLOCK && this.has(type)) {
			return this.block.get();
		} else if (type == UPGRADE_MATERIAL && this.has(type)) {
			return this.upgradeMaterial.get();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <M extends Material, R> void ifPresent(MaterialType type, Function<M, R> function, Consumer<R> consumer) {
		if (this.has(type)) {
			consumer.accept(function.apply((M) this.get(type)));
		}
	}
	
	@SuppressWarnings("unchecked")
	public <M extends Material, R> void ifPresent(MaterialType firstType, MaterialType secondType, Function<M, R> function, BiConsumer<R, R> consumer) {
		if (this.has(firstType) && this.has(secondType)) {
			consumer.accept(function.apply((M) this.get(firstType)), function.apply((M) this.get(secondType)));
		}
	}
	
	@SuppressWarnings("unchecked")
	public <M extends Material, R> void ifPresent(MaterialType firstType, MaterialType secondType, MaterialType thirdType, Function<M, R> function, TriConsumer<R, R, R> consumer) {
		if (this.has(firstType) && this.has(secondType) && this.has(thirdType)) {
			consumer.accept(function.apply((M) this.get(firstType)), function.apply((M) this.get(secondType)), function.apply((M) this.get(thirdType)));
		}
	}
	
	public MaterialSet getUpgradeMaterialSet() {
		return this.upgradeMaterialSet.get().get();
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
	
	public final void valid() {
		if (this.getRegistryName() == null) {
			return;
		}
		if (this.material.isItem() && this.material.getItem() == Items.AIR) {
			XOres.LOGGER.warn("The material of the MaterialSet {} is Items.AIR", this.getRegistryName());
		}
		boolean flag = upgradeMaterial.isPresent();
		if (!flag && upgradeMaterialSet.isPresent()) {
			throw new NullPointerException("No UpgradeMaterial present in MaterialSet " + this.getRegistryName());
		}
		if (flag && upgradeMaterialSet.isEmpty()) {
			throw new NullPointerException("No UpgradeMaterialSet present in MaterialSet " + this.getRegistryName());
		}
	}
	
	public static class Builder {
		
		protected final Material material;
		protected Material materialPart = null;
		protected Material ore = null;
		protected Material deepslateOre = null;
		protected Material block = null;
		protected Material upgradeMaterial = null;
		protected Supplier<MaterialSet> upgradeMaterialSet = null;
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
		
		public MaterialSet.Builder upgradeMaterialSet(Supplier<MaterialSet> upgradeMaterialSet) {
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
