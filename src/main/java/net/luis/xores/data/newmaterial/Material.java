package net.luis.xores.data.newmaterial;

import java.util.Optional;

import net.luis.xores.data.provider.language.ModLanguageProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;

public class Material {
	
	public static final Material EMPTY = new Material();
	
	protected final Optional<Item> item;
	protected final Optional<Named<Item>> tag;
	
	Material() {
		this.item = Optional.empty();
		this.tag = Optional.empty();
	}
	
	Material(Item item) {
		this.item = Optional.of(item);
		this.tag = Optional.empty();
	}
	
	Material(Named<Item> tag) {
		this.item = Optional.empty();
		this.tag = Optional.of(tag);
	}
	
	public static Material item(Item item) {
		return new Material(item);
	}
	
	public static Material tag(Named<Item> tag) {
		return new Material(tag);
	}
	
	public boolean isEmpty() {
		return this == EMPTY;
	}
	
	public boolean isItemMaterial() {
		return !this.isEmpty() && this.item.isPresent() && this.tag.isEmpty();
	}
	
	public Item getItem() {
		return this.item.get();
	}
	
	public boolean isTagMaterial() {
		return !this.isEmpty() && this.item.isEmpty() && this.tag.isPresent();
	}
	
	public Named<Item> getTag() {
		return this.tag.get();
	}
	
	public String getName() {
		if (this.isItemMaterial()) {
			return ModLanguageProvider.getName(this.getItem().getRegistryName());
		} else if (this.isTagMaterial()) {
			ResourceLocation location = this.getTag().getName();
			if (!location.getPath().contains("/")) {
				return ModLanguageProvider.getName(location);
			}
			String[] pathParts = location.getPath().split("/");
			return ModLanguageProvider.getName(new ResourceLocation(location.getNamespace(), pathParts[pathParts.length - 1]));
		}
		return "";
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (object instanceof Material material) {
			if (this.isEmpty() && this.isEmpty()) {
				return true;
			} else if (this.isItemMaterial() && material.isItemMaterial()) {
				return this.getItem() == material.getItem();
			} else if (this.isTagMaterial() && material.isTagMaterial()) {
				return this.getTag() == material.getTag();
			}
		}
		return false;
	}
	
}
