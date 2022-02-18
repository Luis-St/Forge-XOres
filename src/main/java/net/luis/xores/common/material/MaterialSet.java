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

import com.google.common.collect.Maps;

import net.luis.xores.common.item.ElytraChestplateItem;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistryEntry;;

/**
 * set of {@link Material}s, extension of {@link ForgeRegistryEntry},<br>
 * can be registered via:
 * <ul>
 * 	<li>{@link RegistryEvent}</li>
 * 	<li>{@link DeferredRegister}</li>
 * <ul>
 * 
 * @author Luis-st
 * 
 * @see {@link Material}
 * @see {@link ForgeRegistryEntry}
 */

public class MaterialSet extends ForgeRegistryEntry<MaterialSet> {

	/**
	 * the {@link Map} of {@link MaterialType}s and the related {@link Material}
	 */
	protected final Map<MaterialType, Material> materialSet;
	
	/**
	 * the {@link Optional} of a {@link MaterialSet} which is used as the upgrade set
	 */
	protected final Optional<Supplier<MaterialSet>> upgradeSet;

	/**
	 * constructor for the {@link MaterialSet},<br>
	 * private, since a new {@link MaterialSet} should be create with the {@link Builder}
	 */
	private MaterialSet(Map<MaterialType, Material> materialSet, Optional<Supplier<MaterialSet>> upgradeSet) {
		this.materialSet = materialSet;
		this.upgradeSet = upgradeSet;
	}

	/**
	 * @return a new instance of the {@link Builder}
	 */
	public static MaterialSet.Builder of() {
		return new MaterialSet.Builder();
	}

	/**
	 * @return a {@link List} of all possible {@link MaterialType}s
	 * @deprecated use {@link MaterialTypes#TYPES} directly
	 */
	@Deprecated
	public List<MaterialType> getTypes() {
		return MaterialTypes.TYPES;
	}

	/**
	 * @return a {@link List} of all present {@link MaterialType}s
	 */
	public List<MaterialType> getPresentTypes() {
		return this.getTypes().stream().filter((type) -> {
			return this.materialSet.containsKey(type);
		}).collect(Collectors.toList());
	}

	/**
	 * checks if the given {@link MaterialType} is present
	 * @param type which should be checked
	 * @return {@code true} if the {@link MaterialType} is present else {@code false}
	 */
	public boolean has(MaterialType type) {
		return this.materialSet.containsKey(type);
	}

	/**
	 * getter for the {@link Material}s of the {@link MaterialSet}
	 * @param type for which the {@link Material} should be get
	 * @return the {@link Material} for the given {@link MaterialType},<br>
	 * if {@link MaterialSet#has(MaterialType)} returns {@code true} else {@code null}
	 */
	@Nullable
	public Material get(MaterialType type) {
		return this.materialSet.get(type);
	}
	
	/**
	 * @return {@code true} if there is a upgrade {@link MaterialSet} present else {@code false}
	 */
	public boolean hasUpgradeSet() {
		return this.upgradeSet.isPresent();
	}

	/**
	 * getter for the upgrade {@link MaterialSet}
	 * @return the upgrade {@link MaterialSet} if {@link MaterialSet#hasUpgradeSet()}<br>
	 * returns {@code true} else {@code null}
	 */
	@Nullable
	protected MaterialSet getUpgradeSet() {
		if (this.hasUpgradeSet()) {
			return this.upgradeSet.get().get();
		}
		return null;
	}
	
	/**
	 * checks if the given {@link MaterialType} is present in the upgrade {@link MaterialSet}
	 * @param type which should be checked
	 * @return {@code true} if the {@link MaterialType} is present else {@code false}
	 */
	public boolean hasUpgrade(MaterialType type) {
		if (this.hasUpgradeSet()) {
			return this.getUpgradeSet().has(type);
		}
		return false;
	}
	
	/**
	 * getter for the {@link Material}s of the upgrade {@link MaterialSet}
	 * @param type for which the {@link Material} should be get
	 * @return the {@link Material} for the given {@link MaterialType},<br>
	 * if {@link MaterialSet#hasUpgrade(MaterialType)} returns {@code true} else {@code null}
	 */
	@Nullable
	public Material getUpgrade(MaterialType type) {
		if (this.hasUpgradeSet() && this.hasUpgrade(type)) {
			return this.getUpgradeSet().get(type);
		}
		return null;
	}
	
	/**
	 * performs the given {@link Consumer}, if the given {@link MaterialType} is present
	 * @param type which that must be present for the {@link Consumer}
	 * @param consumer the {@link Consumer} which is performed
	 */
	public void ifPresent(MaterialType type, Consumer<Material> consumer) {
		if (this.has(type)) {
			consumer.accept(this.get(type));
		}
	}
	
	/**
	 * performs the given {@link Function} and hands over the result to the given {@link Consumer}<br>
	 * performs only if given {@link MaterialType} is present
	 * @param <M> the input type of the {@link Function}
	 * @param <R> the result of the {@link Function} which is hand over to the {@link Consumer}
	 * @param type which that must be present for the {@link Function} and the {@link Consumer}
	 * @param function which is performed befor the {@link Consumer}
	 * @param consumer the {@link Consumer} which is performed
	 */
	@SuppressWarnings("unchecked")
	public <M extends Material, R> void ifPresent(MaterialType type, Function<M, R> function, Consumer<R> consumer) {
		if (this.has(type)) {
			consumer.accept(function.apply((M) this.get(type)));
		}
	}
	
	/**
	 * performs the given {@link Function} and hands over the result to the given {@link BiConsumer}<br>
	 * performs only if given {@link MaterialType}s are present
	 * @param <M> the input type of the {@link Function}
	 * @param <R> the result of the {@link Function} which is hand over to the {@link BiConsumer}
	 * @param firstType which that must be present for the {@link Function} and the {@link BiConsumer}
	 * @param secondType which that must be present for the {@link Function} and the {@link BiConsumer}
	 * @param function which is performed befor the {@link BiConsumer}
	 * @param consumer the {@link BiConsumer} which is performe
	 */
	@SuppressWarnings("unchecked")
	public <M extends Material, R> void ifPresent(MaterialType firstType, MaterialType secondType, Function<M, R> function, BiConsumer<R, R> consumer) {
		if (this.has(firstType) && this.has(secondType)) {
			consumer.accept(function.apply((M) this.get(firstType)), function.apply((M) this.get(secondType)));
		}
	}

	/**
	 * 
	 * @author Luis-st
	 *
	 */
	public static class Builder {

		/**
		 * the {@link Map} of {@link MaterialType}s and the related {@link Material}
		 */
		protected final Map<MaterialType, Material> materialSet;
		
		/**
		 * the {@link Supplier} of a {@link MaterialSet}
		 */
		protected Supplier<MaterialSet> upgradeSet = null;

		/**
		 * constructor for the {@link MaterialSet},<br>
		 * package private, since you should use {@link MaterialSet#of()}
		 */
		Builder() {
			this.materialSet = Maps.newHashMap();
		}

		/**
		 * internal check if the given {@link MaterialType} is present
		 * @param type which should be checked
		 * @return {@code true} if the {@link MaterialType} is present else {@code false}
		 */
		protected boolean has(MaterialType type) {
			return this.materialSet.get(type) != null;
		}

		/**
		 * adds the given {@link Material} to the {@link Builder} with the given {@link MaterialType} as key
		 * @param type which is used as key
		 * @param material which should be add
		 * @return the {@link Builder} itself
		 * @throws NullPointerException if the given {@link MaterialType}  or {@link Material} is null
		 * @throws IllegalStateException if the given {@link MaterialType} already exists in the {@link Builder}
		 */
		public Builder add(MaterialType type, Material material) {
			if (type == null) {
				throw new NullPointerException("MaterialType can not be null");
			} else if (material == null) {
				throw new NullPointerException("Material can not be null");
			}
			Material oldMaterial = this.materialSet.putIfAbsent(type, material);
			if (oldMaterial != null) {
				throw new IllegalStateException("Fail to add " + material + " since the MaterialType " + type + " does already exist (" + oldMaterial + ") in the MaterialSet.Builder");
			}
			return this;
		}
		
		/**
		 * adds the given {@link Item} to the {@link Builder} with the given {@link MaterialType} as key
		 * @param type which is used as key
		 * @param item which should be add
		 * @return the {@link Builder} itself
		 */
		public Builder add(MaterialType type, Item item) {
			return this.add(type, Material.item(item));
		}
		
		/**
		 * adds the given {@link Named} tag to the {@link Builder} with the given {@link MaterialType} as key
		 * @param type which is used as key
		 * @param tag which should be add
		 * @return the {@link Builder} itself
		 */
		public Builder add(MaterialType type, Named<Item> tag) {
			return this.add(type, Material.tag(tag));
		}
		
		/**
		 * adds the given {@link Material} to the {@link Builder},<br>
		 * the {@link MaterialType} is got from {@link Builder#getMaterialType(Material)}
		 * @param material which should be add
		 * @return the {@link Builder} itself
		 * @see {@link Builder#getMaterialType(Material)}
		 */
		public Builder add(Material material) {
			return this.add(this.getMaterialType(material), material);
		}
		
		/**
		 * adds the given {@link Item} to the {@link Builder},<br>
		 * the {@link MaterialType} is got from {@link Builder#getMaterialTypeByItem(Item)}
		 * @param item which should be add
		 * @return the {@link Builder} itself
		 * @see {@link Builder#getMaterialTypeByItem(Item)}
		 */
		public Builder add(Item item) {
			return this.add(this.getMaterialTypeByItem(item), Material.item(item));
		}
		
		/**
		 * adds the given {@link Named} tag to the {@link Builder},<br>
		 * the {@link MaterialType} is got from {@link Builder#getMaterialTypeByTag(Named)}
		 * @param tag which should be add
		 * @return the {@link Builder} itself
		 * @see {@link Builder#getMaterialTypeByTag(Named)}
		 */
		public Builder add(Named<Item> tag) {
			return this.add(this.getMaterialTypeByTag(tag), Material.tag(tag));
		}

		/**
		 * @param material for which a {@link MaterialType} should be found
		 * @return the {@link MaterialType} for the given {@link Material}
		 * @throws IllegalArgumentException if {@link Material#isItem()} and {@link Material#isTag()} returns {@code false}
		 * @throws IllegalStateException if the found {@link MaterialType} already exists
		 */
		protected MaterialType getMaterialType(Material material) {
			MaterialType type = null;
			if (material.isItem()) {
				type = this.getMaterialTypeByItem(material.itemOrThrow());
			} else if (material.isTag()) {
				type = this.getMaterialTypeByTag(material.tagOrThrow());
			}
			if (type == null) {
				throw new IllegalArgumentException("Material can not be empty");
			} else if (this.has(type)) {
				throw new IllegalStateException("The MaterialType " + type +" does alredy exist");
			}
			return type;
		}

		/**
		 * @param item for which a {@link MaterialType} should be found
		 * @return a {@link MaterialType} or {@code null} if all {@link MaterialType}s are already present
		 */
		protected MaterialType getMaterialTypeByItem(Item item) {
			if (item instanceof SwordItem) {
				return MaterialTypes.SWORD;
			} else if (item instanceof ShieldItem) {
				return MaterialTypes.SHIELD;
			} else if (item instanceof BowItem) {
				return MaterialTypes.BOW;
			} else if (item instanceof CrossbowItem) {
				return MaterialTypes.CROSSBOW;
			} else if (item instanceof PickaxeItem) {
				return MaterialTypes.PICKAXE;
			} else if (item instanceof AxeItem) {
				return MaterialTypes.AXE;
			} else if (item instanceof ShovelItem) {
				return MaterialTypes.SHOVEL;
			} else if (item instanceof HoeItem) {
				return MaterialTypes.HOE;
			} else if (item instanceof ArmorItem) {
				if (item instanceof ElytraChestplateItem) {
					return MaterialTypes.ELYTRA_CHESTPLATE;
				} else if (item instanceof ArmorItem armorItem) {
					switch (armorItem.getSlot()) {
						case HEAD: {
							return MaterialTypes.HELMET;
						}
						case CHEST: {
							return MaterialTypes.CHESTPLATE;
						}
						case LEGS: {
							return MaterialTypes.LEGGINGS;
						}
						case FEET: {
							return MaterialTypes.BOOTS;
						}
						default: break;
					}
				}
			} else {
				if (!this.has(MaterialTypes.MATERIAL)) {
					return MaterialTypes.MATERIAL;
				} else if (!this.has(MaterialTypes.MATERIAL_PART)) {
					return MaterialTypes.MATERIAL_PART;
				} else if (!this.has(MaterialTypes.WEAPON_MATERIAL)) {
					return MaterialTypes.WEAPON_MATERIAL;
				} else if (!this.has(MaterialTypes.TOOL_MATERIAL)) {
					return MaterialTypes.TOOL_MATERIAL;
				} else if (!this.has(MaterialTypes.ARMOR_MATERIAL)) {
					return MaterialTypes.ARMOR_MATERIAL;
				}
			}
			return null;
		}

		/**
		 * @param tag for which a {@link MaterialType} should be found
		 * @return a {@link MaterialType} or {@code null} if all {@link MaterialType}s are already present
		 */
		protected MaterialType getMaterialTypeByTag(Named<Item> tag) {
			if (!this.has(MaterialTypes.MATERIAL)) {
				return MaterialTypes.MATERIAL;
			} else if (!this.has(MaterialTypes.MATERIAL_PART)) {
				return MaterialTypes.MATERIAL_PART;
			} else if (!this.has(MaterialTypes.WEAPON_MATERIAL)) {
				return MaterialTypes.WEAPON_MATERIAL;
			} else if (!this.has(MaterialTypes.TOOL_MATERIAL)) {
				return MaterialTypes.TOOL_MATERIAL;
			} else if (!this.has(MaterialTypes.ARMOR_MATERIAL)) {
				return MaterialTypes.ARMOR_MATERIAL;
			}
			return null;
		}

		/**
		 * adds the given {@link MaterialSet} to the {@link Builder}
		 * @param upgradeSet which should be add
		 * @return the {@link Builder} itself
		 */
		public Builder upgradeSet(Supplier<MaterialSet> upgradeSet) {
			this.upgradeSet = upgradeSet;
			return this;
		}
		
		/**
		 * builds a new {@link MaterialSet}
		 * @return a new instance of {@link MaterialSet}
		 */
		public MaterialSet build() {
			if (this.upgradeSet != null && !this.has(MaterialTypes.MATERIAL)) {
				throw new IllegalStateException("Fail to get the MaterialType " + MaterialTypes.MATERIAL + ", but it's required by the UpgradeSet ");
			}
			return new MaterialSet(this.materialSet, Optional.ofNullable(this.upgradeSet));
		}
		
	}

}
