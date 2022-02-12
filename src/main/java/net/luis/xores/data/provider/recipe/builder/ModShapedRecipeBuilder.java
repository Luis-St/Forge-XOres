package net.luis.xores.data.provider.recipe.builder;

import net.luis.xores.common.material.Material;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.Tag;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class ModShapedRecipeBuilder extends ShapedRecipeBuilder {

	protected ModShapedRecipeBuilder(ItemLike itemLike, int count) {
		super(itemLike, count);
	}
	
	public static ModShapedRecipeBuilder shaped(ItemLike itemLike) {
		return shaped(itemLike, 1);
	}

	public static ModShapedRecipeBuilder shaped(ItemLike itemLike, int count) {
		return new ModShapedRecipeBuilder(itemLike, count);
	}
	
	public ModShapedRecipeBuilder group(Material material) {
		return this.group(this.getGroup(material));
	}
	
	@Override
	public ModShapedRecipeBuilder group(String group) {
		return (ModShapedRecipeBuilder) super.group(group);
	}
	
	@Override
	public ModShapedRecipeBuilder define(Character character, ItemLike itemLike) {
		return (ModShapedRecipeBuilder) super.define(character, itemLike);
	}
	
	@Override
	public ModShapedRecipeBuilder define(Character character, Tag<Item> tag) {
		return (ModShapedRecipeBuilder) super.define(character, tag);
	}
	
	public ModShapedRecipeBuilder define(Character character, Material material) {
		return this.define(character, material.asIngredient());
	}
	
	@Override
	public ModShapedRecipeBuilder define(Character character, Ingredient ingredient) {
		return (ModShapedRecipeBuilder) super.define(character, ingredient);
	}
	
	public ModShapedRecipeBuilder pattern(String firstLine, String secondLine, String thirdLine) {
		return this.pattern(firstLine).pattern(secondLine).pattern(thirdLine);
	}
	
	@Override
	public ModShapedRecipeBuilder pattern(String pattern) {
		return (ModShapedRecipeBuilder) super.pattern(pattern);
	}
	
	public ModShapedRecipeBuilder unlockedBy(Material material) {
		return this.unlockedBy("has_", material);
	}
	
	public ModShapedRecipeBuilder unlockedBy(String prefix, Material material) {
		return (ModShapedRecipeBuilder) this.unlockedBy(prefix + this.getId(material), this.has(material));
	}
	
	@Override
	public ModShapedRecipeBuilder unlockedBy(String condition, CriterionTriggerInstance triggerInstance) {
		return (ModShapedRecipeBuilder) super.unlockedBy(condition, triggerInstance);
	}
	
	protected final String getId(Item item) {
		return item.getRegistryName().getPath();
	}
	
	protected final String getId(Material material) {
		if (material.isItem()) {
			return this.getId(material.itemOrThrow());
		}
		Named<Item> tag = material.tagOrThrow();
		if (!tag.getName().getPath().contains("/")) {
			return tag.getName().getPath();
		}
		String[] pathParts = tag.getName().getPath().split("/");
		return pathParts[pathParts.length - 1];
	}
	
	protected final String getGroup(Material material) {
		if (material.isItem()) {
			String path = material.itemOrThrow().getRegistryName().getPath();
			if (!path.contains("_")) {
				return path;
			}
			String[] pathParts = path.split("_");
			if (pathParts[0].equals("polished") || pathParts[0].equals("rose")) {
				return "rose_quartz";
			}
			return pathParts[0];
		}
		return this.getId(material);
	}
	
	protected final TriggerInstance has(Material material) {
		if (material.isItem()) {
			return this.inventoryTrigger(ItemPredicate.Builder.item().of(material.itemOrThrow()).build());
		} else if (material.isTag()) {
			return this.inventoryTrigger(ItemPredicate.Builder.item().of(material.tagOrThrow()).build());
		}
		throw new IllegalStateException("Fail to get TriggerInstance for Material since it's not Item and Tag");
	}

	protected final InventoryChangeTrigger.TriggerInstance inventoryTrigger(ItemPredicate... predicates) {
		return new InventoryChangeTrigger.TriggerInstance(EntityPredicate.Composite.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, predicates);
	}
	
}
