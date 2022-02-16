package net.luis.xores.common.material;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * summary of {@link Item} and {@link Named} tag,<br>
 * into one class
 * 
 * @author Luis-st
 * 
 * @see {@link Item}
 * @see {@link Named}
 */

public class Material {
	
	/**
	 * the {@link Optional} of the {@link Item}
	 */
	protected final Optional<Item> item;
	
	/**
	 * the {@link Optional} of the {@link Named} tag
	 */
	protected final Optional<Named<Item>> tag;
	
	/**
	 * @see {@link Material#Material(Optional, Optional)}
	 */
	Material(Item item) {
		this(Optional.of(item), Optional.empty());
	}
	
	/**
	 * @see {@link Material#Material(Optional, Optional)}
	 */
	Material(Named<Item> tag) {
		this(Optional.empty(), Optional.of(tag));
	}
	
	/**
	 * constructor for the {@link Material}
	 */
	Material(Optional<Item> item, Optional<Named<Item>> tag) {
		this.item = Objects.requireNonNull(item, "Optional can't be null");
		this.tag = Objects.requireNonNull(tag, "Optional can't be null");
	}
	
	/**
	 * @return a {@link Material} for the given {@link Item}
	 */
	public static Material item(Item item) {
		return new Material(item);
	}
	
	/**
	 * @return a {@link Material} for the given {@link Named} tags
	 */
	public static Material tag(Named<Item> tag) {
		return new Material(tag);
	}
	
	/**
	 * @return the {@link Material} itself
	 */
	public Material self() {
		return this;
	}
	
	/**
	 * @return {@code true} if the {@link Material} is a {@link Item} material else {@code false}
	 */
	public boolean isItem() {
		return this.item.isPresent();
	}
	
	/**
	 * @return the {@link Item} of the {@link Material} if {@link Material#isItem()} returns {@code true}
	 */
	@Nullable
	public Item getItem() {
		if (this.isItem()) {
			return this.item.get();
		}
		return null;
	}
	
	/**
	 * @return {@link Material#getItem()} if {@link Material#isItem()} returns {@code true} else the given {@link Item}
	 */
	public Item itemOrElse(Item item) {
		return this.isItem() ? this.getItem() : item;
	}
	
	/**
	 * @throws a {@link NullPointerException} if {@link Material#isItem()} returns {@code false}
	 * @return {@link Material#getItem()} if {@link Material#isItem()} returns {@code true}
	 */
	public Item itemOrThrow() {
		if (this.isItem()) {
			return this.getItem();
		}
		throw new NullPointerException("Material is not a type of Item");
	}
	
	/**
	 * accept the given {@link Consumer} if {@link Material#isItem()} returns {@code true}
	 */
	public void ifItemPresent(Consumer<Item> consumer) {
		if (this.isItem()) {
			consumer.accept(this.itemOrThrow());
		}
	}
	
	/**
	 * @return {@code true} if the {@link Material} is a {@link Named} tag material else {@code false}
	 */
	public boolean isTag() {
		return this.tag.isPresent();
	}
	
	/**
	 * @return the {@link Named} of the {@link Material} if {@link Material#isTag()} returns {@code true}
	 */
	@Nullable
	public Named<Item> getTag() {
		if (this.isTag()) {
			return this.tag.get();
		}
		return null;
	}
	
	/**
	 * @return {@link Material#getTag()} if {@link Material#getTag()} returns {@code true} else the given {@link Named} tag
	 */
	public Named<Item> tagOrElse(Named<Item> tag) {
		return this.isTag() ? this.getTag() : tag;
	}
	
	/**
	 * @throws a {@link NullPointerException} if {@link Material#isTag()} returns {@code false}
	 * @return {@link Material#getTag()} if {@link Material#isTag()} returns {@code true}
	 */
	public Named<Item> tagOrThrow() {
		if (this.isTag()) {
			return this.getTag();
		}
		throw new NullPointerException("Material is not a type of Tag");
	}
	
	/**
	 * accept the given {@link Consumer} if {@link Material#isTag()} returns {@code true}
	 */
	public void ifTagPresent(Consumer<Named<Item>> consumer) {
		if (this.isTag()) {
			consumer.accept(this.tagOrThrow());
		}
	}
	
	/**
	 * @return a {@link Ingredient} of the {@link Material}
	 */
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.isItem()) {
			builder.append("Item Material of ").append(this.itemOrThrow().getRegistryName());
		} else if (this.isTag()) {
			builder.append("Tag Material of ").append(this.tagOrThrow().getName());
		} else {
			throw new IllegalStateException("Material can not be empty");
		}
		return builder.toString();
	}
	
}
