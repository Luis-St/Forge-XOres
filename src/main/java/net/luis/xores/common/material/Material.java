package net.luis.xores.common.material;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

/**
 * summary of {@link Item} and {@link TagKey} tag, into one class
 * 
 * @author Luis-st
 * 
 * @see {@link Item}
 * @see {@link TagKey}
 */

public class Material {
	
	/**
	 * the {@link Optional} of the {@link Item}
	 */
	private final Optional<Item> item;
	
	/**
	 * the {@link Optional} of the {@link TagKey} tag
	 */
	private final Optional<TagKey<Item>> tag;
	
	/**
	 * @see {@link Material#Material(Optional, Optional)}
	 */
	private Material(Item item) {
		this(Optional.of(item), Optional.empty());
	}
	
	/**
	 * @see {@link Material#Material(Optional, Optional)}
	 */
	private Material(TagKey<Item> tag) {
		this(Optional.empty(), Optional.of(tag));
	}
	
	/**
	 * constructor for the {@link Material},<br>
	 * private since you should use the factory methods
	 * 
	 * @see {@link Material#item(Item)}
	 * @see {@link Material#tag(TagKey)}
	 */
	private Material(Optional<Item> item, Optional<TagKey<Item>> tag) {
		this.item = Objects.requireNonNull(item, "Optional can't be null");
		this.tag = Objects.requireNonNull(tag, "Optional can't be null");
	}
	
	/**
	 * creates a new {@link Material}
	 * @parm item The {@link Item} for the {@link Material}
	 * @return a {@link Material} for the given {@link Item}
	 */
	public static Material item(Item item) {
		return new Material(item);
	}
	
	/**
	 * creates a new {@link Material}
	 * @param tag The {@link TagKey} tag for the {@link Material}
	 * @return a {@link Material} for the given {@link TagKey} tags
	 */
	public static Material tag(TagKey<Item> tag) {
		return new Material(tag);
	}
	
	/**
	 * @return the {@link Material} itself
	 */
	public Material self() {
		return this;
	}
	
	/**
	 * checks if the {@link Material} is a {@link Item} material
	 * @return {@code true} if the {@link Material} is a {@link Item} material else {@code false}
	 */
	public boolean isItem() {
		return this.item.isPresent();
	}
	
	/**
	 * getter for the {@link Material#item}
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
	 * @param item The fallback {@link Item}
	 * @return {@link Material#getItem()} if {@link Material#isItem()} returns {@code true} else the given {@link Item}
	 */
	public Item itemOrElse(Item item) {
		return this.isItem() ? this.getItem() : item;
	}
	
	/**
	 * throw getter for the {@link Material#item}
	 * @return {@link Material#getItem()} if {@link Material#isItem()} returns {@code true}
	 * @throws a {@link NullPointerException} if {@link Material#isItem()} returns {@code false}
	 */
	public Item itemOrThrow() {
		if (this.isItem()) {
			return this.getItem();
		}
		throw new NullPointerException("Material is not a type of Item");
	}
	
	/**
	 * accept the given {@link Consumer} if {@link Material#isItem()} returns {@code true}
	 * @param consumer The {@link Consumer} which is execute
	 */
	public void ifItemPresent(Consumer<Item> consumer) {
		if (this.isItem()) {
			consumer.accept(this.itemOrThrow());
		}
	}
	
	/**
	 * checks if the {@link Material} is a {@link TagKey} tag material
	 * @return {@code true} if the {@link Material} is a {@link TagKey} tag material else {@code false}
	 */
	public boolean isTag() {
		return this.tag.isPresent();
	}
	
	/**
	 * getter for the {@link Material#tag}
	 * @return the {@link TagKey} of the {@link Material} if {@link Material#isTag()} returns {@code true}
	 */
	@Nullable
	public TagKey<Item> getTag() {
		if (this.isTag()) {
			return this.tag.get();
		}
		return null;
	}
	
	/**
	 * @param tag The fallback {@link TagKey} tag
	 * @return {@link Material#getTag()} if {@link Material#getTag()} returns {@code true} else the given {@link TagKey} tag
	 */
	public TagKey<Item> tagOrElse(TagKey<Item> tag) {
		return this.isTag() ? this.getTag() : tag;
	}
	
	/**
	 * throw getter for the {@link Material#tag}
	 * @return {@link Material#getTag()} if {@link Material#isTag()} returns {@code true}
	 * @throws a {@link NullPointerException} if {@link Material#isTag()} returns {@code false}
	 */
	public TagKey<Item> tagOrThrow() {
		if (this.isTag()) {
			return this.getTag();
		}
		throw new NullPointerException("Material is not a type of Tag");
	}
	
	/**
	 * accept the given {@link Consumer} if {@link Material#isTag()} returns {@code true}
	 * @param consumer The {@link Consumer} which is execute
	 */
	public void ifTagPresent(Consumer<TagKey<Item>> consumer) {
		if (this.isTag()) {
			consumer.accept(this.tagOrThrow());
		}
	}
	
	/**
	 * creates an {@link Ingredient} for the {@link Material}
	 * @return a {@link Ingredient}
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
			builder.append("Tag Material of ").append(this.tagOrThrow().location());
		} else {
			throw new IllegalStateException("Material can not be empty");
		}
		return builder.toString();
	}
	
}
