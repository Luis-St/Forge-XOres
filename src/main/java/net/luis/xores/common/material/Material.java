package net.luis.xores.common.material;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class Material {
	
	protected final Optional<Item> item;
	protected final Optional<Named<Item>> tag;
	
	Material(Item item) {
		this(Optional.of(item), Optional.empty());
	}
	
	Material(Named<Item> tag) {
		this(Optional.empty(), Optional.of(tag));
	}
	
	Material(Optional<Item> item, Optional<Named<Item>> tag) {
		this.item = Objects.requireNonNull(item, "Optional can't be null");
		this.tag = Objects.requireNonNull(tag, "Optional can't be null");
	}
	
	public static Material item(Item item) {
		return new Material(item);
	}
	
	public static Material tag(Named<Item> tag) {
		return new Material(tag);
	}
	
	public Material self() {
		return this;
	}
	
	public boolean isItem() {
		return this.item.isPresent();
	}
	
	public Item getItem() {
		return this.item.get();
	}
	
	public Item itemOrElse(Item item) {
		return this.isItem() ? this.getItem() : item;
	}
	
	public Item itemOrThrow() {
		if (this.isItem()) {
			return this.getItem();
		}
		throw new NullPointerException("Material is not a type of Item");
	}
	
	public void ifItemPresent(Consumer<Item> consumer) {
		if (this.isItem()) {
			consumer.accept(this.itemOrThrow());
		}
	}
	
	public boolean isTag() {
		return this.tag.isPresent();
	}
	
	public Named<Item> getTag() {
		return this.tag.get();
	}
	
	public Named<Item> tagOrThrow() {
		if (this.isTag()) {
			return this.getTag();
		}
		throw new NullPointerException("Material is not a type of Tag");
	}
	
	public Named<Item> tagOrElse(Named<Item> tag) {
		return this.isTag() ? this.getTag() : tag;
	}
	
	public void ifTagPresent(Consumer<Named<Item>> consumer) {
		if (this.isTag()) {
			consumer.accept(this.tagOrThrow());
		}
	}
	
	public Ingredient asIngredient() {
		if (this.isItem()) {
			return Ingredient.of(this.item.get());
		} else if (this.isTag()) {
			return Ingredient.of(this.tag.get());
		}
		throw new IllegalStateException("Material can not be empty");
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		} else if (object instanceof Material material) {
			if (this.isItem() && material.isItem()) {
				return this.getItem() == material.getItem();
			} else if (this.isTag() && material.isTag()) {
				return this.getTag() == material.getTag();
			}
		}
		return false;
	}
	
}
