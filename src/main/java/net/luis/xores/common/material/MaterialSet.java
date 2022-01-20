package net.luis.xores.common.material;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import org.apache.logging.log4j.util.TriConsumer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistryEntry;;

public class MaterialSet extends ForgeRegistryEntry<MaterialSet> {

	protected final Map<MaterialType, Material> materialSet;
	protected final Optional<Supplier<MaterialSet>> upgradeSet;

	MaterialSet(Map<MaterialType, Material> materialSet, Optional<Supplier<MaterialSet>> upgradeSet) {
		this.materialSet = materialSet;
		this.upgradeSet = upgradeSet;
	}

	public static MaterialSet.Builder of() {
		return new MaterialSet.Builder();
	}

	public List<MaterialType> getTypes() {
		return MaterialTypes.TYPES;
	}

	public List<MaterialType> getPresentTypes() {
		return this.getTypes().stream().filter((type) -> {
			return this.materialSet.containsKey(type);
		}).collect(Collectors.toList());
	}

	public boolean has(MaterialType type) {
		return this.materialSet.containsKey(type);
	}
	
	public boolean hasAll(MaterialType... ignoredTypes) {
		List<MaterialType> types = Lists.newArrayList(ignoredTypes);
		for (MaterialType type : this.getTypes()) {
			if (!types.contains(type) && !this.has(type)) {
				return false;
			}
		}
		return true;
	}

	@Nullable
	public Material get(MaterialType type) {
		return this.materialSet.get(type);
	}
	
	public boolean hasUpgradeSet() {
		return this.upgradeSet.isPresent();
	}

	@Nullable
	protected MaterialSet getUpgradeSet() {
		return this.upgradeSet.get().get();
	}
	
	public boolean hasUpgrade(MaterialType type) {
		if (this.hasUpgradeSet()) {
			return this.getUpgradeSet().has(type);
		}
		return false;
	}
	
	public boolean hasUpgradeAll(MaterialType... ignoredTypes) {
		if (this.hasUpgradeSet()) {
			return this.getUpgradeSet().hasAll(ignoredTypes);
		}
		return false;
	}
	
	@Nullable
	public Material getUpgrade(MaterialType type) {
		if (this.hasUpgradeSet()) {
			return this.getUpgradeSet().get(type);
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

	public final void valid() {
		if (this.getRegistryName() == null) {
			return;
		}
	}

	public static class Builder {

		protected final Map<MaterialType, Material> materialSet;
		protected Supplier<MaterialSet> upgradeSet = null;

		Builder() {
			this.materialSet = Maps.newHashMap();
		}

		protected boolean has(MaterialType materialType) {
			return this.materialSet.get(materialType) != null;
		}

		public Builder add(MaterialType materialType, Material material) {
			if (materialType == null) {
				throw new IllegalStateException("MaterialType can not be null");
			} else if (material == null) {
				throw new IllegalStateException("Material can not be null");
			}
			Material oldMaterial = this.materialSet.putIfAbsent(materialType, material);
			if (oldMaterial != null) {
				throw new IllegalStateException("Fail to add " + material + " since the MaterialType " + materialType + " does already exist (" + oldMaterial + ") in the MaterialSet.Builder");
			}
			return this;
		}
		
		public Builder add(MaterialType materialType, Named<Item> tag) {
			return this.add(materialType, Material.tag(tag));
		}
		
		public Builder add(MaterialType materialType, Item item) {
			return this.add(materialType, Material.item(item));
		}
		
		public Builder add(Material material) {
			return this.add(this.getMaterialType(material), material);
		}
		
		public Builder add(Item item) {
			Material material = Material.item(item);
			return this.add(this.getMaterialTypeByItem(material), material);
		}

		protected MaterialType getMaterialType(Material material) {
			if (material.isItem()) {
				return this.getMaterialTypeByItem(material);
			} else if (material.isTag()) {
				return this.getMaterialTypeByTag(material.tagOrThrow());
			}
			throw new IllegalStateException("Material can not be empty");
		}

		protected MaterialType getMaterialTypeByItem(Material material) {
			if (!this.has(MaterialTypes.MATERIAL)) {
				return MaterialTypes.MATERIAL;
			} else if (!this.has(MaterialTypes.MATERIAL_PART)) {
				return MaterialTypes.MATERIAL_PART;
			} else if (!this.has(MaterialTypes.UPGRADE_MATERIAL)) {
				return MaterialTypes.UPGRADE_MATERIAL;
			} else if (!this.has(MaterialTypes.WEAPON_MATERIAL)) {
				return MaterialTypes.WEAPON_MATERIAL;
			} else if (!this.has(MaterialTypes.TOOL_MATERIAL)) {
				return MaterialTypes.TOOL_MATERIAL;
			} else if (!this.has(MaterialTypes.ARMOR_MATERIAL)) {
				return MaterialTypes.ARMOR_MATERIAL;
			} else {
				for (MaterialType materialType : MaterialTypes.TYPES.stream()
						.filter(type -> type.getType() != MaterialType.Type.MATERIAL).collect(Collectors.toList())) {
					if (materialType.test(material) && !this.has(materialType)) {
						return materialType;
					}
				}
			}
			return null;
		}

		protected MaterialType getMaterialTypeByTag(Named<Item> tag) {
			if (!this.has(MaterialTypes.MATERIAL)) {
				return MaterialTypes.MATERIAL;
			} else if (!this.has(MaterialTypes.MATERIAL_PART)) {
				return MaterialTypes.MATERIAL_PART;
			} else if (!this.has(MaterialTypes.UPGRADE_MATERIAL)) {
				return MaterialTypes.UPGRADE_MATERIAL;
			} else if (!this.has(MaterialTypes.WEAPON_MATERIAL)) {
				return MaterialTypes.WEAPON_MATERIAL;
			} else if (!this.has(MaterialTypes.TOOL_MATERIAL)) {
				return MaterialTypes.TOOL_MATERIAL;
			} else if (!this.has(MaterialTypes.ARMOR_MATERIAL)) {
				return MaterialTypes.ARMOR_MATERIAL;
			}
			return null;
		}

		public Builder upgradeSet(Supplier<MaterialSet> upgradeSet) {
			this.upgradeSet = upgradeSet;
			return this;
		}
		
		public MaterialSet build() {
			if (this.upgradeSet != null && !this.has(MaterialTypes.MATERIAL)) {
				throw new IllegalStateException("Fail to get the MaterialType " + MaterialTypes.MATERIAL + ", but it's required by the UpgradeSet");
			}
			return new MaterialSet(this.materialSet, Optional.ofNullable(this.upgradeSet));
		}

	}

}
