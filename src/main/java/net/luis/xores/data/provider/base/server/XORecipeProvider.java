/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.data.provider.base.server;

import net.luis.xores.XOres;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.luis.xores.world.item.XOItems.*;
import static net.luis.xores.world.level.block.XOBlocks.*;

/**
 *
 * @author Luis-St
 *
 */

public class XORecipeProvider extends RecipeProvider {
	
	private final HolderGetter<Item> items;
	
	public XORecipeProvider(HolderLookup.@NotNull Provider lookup, @NotNull RecipeOutput output) {
		super(lookup, output);
		this.items = lookup.lookupOrThrow(Registries.ITEM);
	}
	
	@Override
	protected void buildRecipes() {
		//region Vanilla additional recipes
		this.shieldRecipe(Items.GOLD_INGOT, GOLDEN_SHIELD.get());
		this.shieldRecipe(Items.COPPER_INGOT, COPPER_SHIELD.get());
		this.shieldRecipe(Items.IRON_INGOT, IRON_SHIELD.get());
		this.shieldRecipe(Items.DIAMOND, DIAMOND_SHIELD.get());
		this.smithingRecipe(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, DIAMOND_SHIELD.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_SHIELD.get());
		this.elytraChestplateRecipe(DIAMOND_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, DIAMOND_ELYTRA_CHESTPLATE.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.BOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_BOW.get());
		this.smithingRecipe(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.CROSSBOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_CROSSBOW.get());
		//endregion
		//region Jade recipes
		this.oreRecipes(JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.oreRecipes(DEEPSLATE_JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.blockRecipes(JADE_INGOT.get(), JADE_BLOCK.get().asItem());
		this.swordRecipe(JADE_INGOT.get(), JADE_SWORD.get());
		this.pickaxeRecipe(JADE_INGOT.get(), JADE_PICKAXE.get());
		this.axeRecipe(JADE_INGOT.get(), JADE_AXE.get());
		this.shovelRecipe(JADE_INGOT.get(), JADE_SHOVEL.get());
		this.hoeRecipe(JADE_INGOT.get(), JADE_HOE.get());
		this.helmetRecipe(JADE_INGOT.get(), JADE_HELMET.get());
		this.chestplateRecipe(JADE_INGOT.get(), JADE_CHESTPLATE.get());
		this.leggingsRecipe(JADE_INGOT.get(), JADE_LEGGINGS.get());
		this.bootsRecipe(JADE_INGOT.get(), JADE_BOOTS.get());
		//endregion
		//region Blazing recipes
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, BLAZING_INGOT.get()).define('#', Items.BLAZE_ROD).define('I', Items.GOLD_BLOCK).pattern("###").pattern("#I#").pattern("###"), this.getGroup(BLAZING_INGOT.get()),
			Items.BLAZE_ROD, Items.GOLD_BLOCK, BLAZING_INGOT.get()).save(this.output);
		this.swordRecipe(BLAZING_INGOT.get(), BLAZING_SWORD.get());
		this.pickaxeRecipe(BLAZING_INGOT.get(), BLAZING_PICKAXE.get());
		this.axeRecipe(BLAZING_INGOT.get(), BLAZING_AXE.get());
		this.shovelRecipe(BLAZING_INGOT.get(), BLAZING_SHOVEL.get());
		this.hoeRecipe(BLAZING_INGOT.get(), BLAZING_HOE.get());
		this.helmetRecipe(BLAZING_INGOT.get(), BLAZING_HELMET.get());
		this.chestplateRecipe(BLAZING_INGOT.get(), BLAZING_CHESTPLATE.get());
		this.leggingsRecipe(BLAZING_INGOT.get(), BLAZING_LEGGINGS.get());
		this.bootsRecipe(BLAZING_INGOT.get(), BLAZING_BOOTS.get());
		//endregion
		//region Saphire recipes
		this.oreRecipes(SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.oreRecipes(DEEPSLATE_SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.blockRecipes(SAPHIRE_INGOT.get(), SAPHIRE_BLOCK.get().asItem());
		this.swordRecipe(SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get());
		this.shieldRecipe(SAPHIRE_INGOT.get(), SAPHIRE_SHIELD.get());
		this.pickaxeRecipe(SAPHIRE_INGOT.get(), SAPHIRE_PICKAXE.get());
		this.axeRecipe(SAPHIRE_INGOT.get(), SAPHIRE_AXE.get());
		this.shovelRecipe(SAPHIRE_INGOT.get(), SAPHIRE_SHOVEL.get());
		this.hoeRecipe(SAPHIRE_INGOT.get(), SAPHIRE_HOE.get());
		this.helmetRecipe(SAPHIRE_INGOT.get(), SAPHIRE_HELMET.get());
		this.chestplateRecipe(SAPHIRE_INGOT.get(), SAPHIRE_CHESTPLATE.get());
		this.leggingsRecipe(SAPHIRE_INGOT.get(), SAPHIRE_LEGGINGS.get());
		this.bootsRecipe(SAPHIRE_INGOT.get(), SAPHIRE_BOOTS.get());
		//endregion
		//region Limonite recipes
		this.oreRecipes(LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.oreRecipes(DEEPSLATE_LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.blockRecipes(LIMONITE_INGOT.get(), LIMONITE_BLOCK.get().asItem());
		this.swordRecipe(LIMONITE_INGOT.get(), LIMONITE_SWORD.get());
		this.pickaxeRecipe(LIMONITE_INGOT.get(), LIMONITE_PICKAXE.get());
		this.axeRecipe(LIMONITE_INGOT.get(), LIMONITE_AXE.get());
		this.shovelRecipe(LIMONITE_INGOT.get(), LIMONITE_SHOVEL.get());
		this.hoeRecipe(LIMONITE_INGOT.get(), LIMONITE_HOE.get());
		this.helmetRecipe(LIMONITE_INGOT.get(), LIMONITE_HELMET.get());
		this.chestplateRecipe(LIMONITE_INGOT.get(), LIMONITE_CHESTPLATE.get());
		this.leggingsRecipe(LIMONITE_INGOT.get(), LIMONITE_LEGGINGS.get());
		this.bootsRecipe(LIMONITE_INGOT.get(), LIMONITE_BOOTS.get());
		//endregion
		//region Rose quartz recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, ROSE_QUARTZ.get()).requires(Items.QUARTZ, 4).requires(Items.REDSTONE, 4), this.getGroup(POLISHED_ROSE_QUARTZ.get()), Items.QUARTZ, Items.REDSTONE, ROSE_QUARTZ.get())
			.save(this.output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, POLISHED_ROSE_QUARTZ.get()).requires(ROSE_QUARTZ.get(), 9), this.getGroup(POLISHED_ROSE_QUARTZ.get()), ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get())
			.save(this.output);
		this.swordRecipe(POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get());
		this.pickaxeRecipe(POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_PICKAXE.get());
		this.axeRecipe(POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_AXE.get());
		this.shovelRecipe(POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SHOVEL.get());
		this.hoeRecipe(POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_HOE.get());
		//endregion
		//region Enderite recipes
		Item enderiteTemplate = ENDERITE_UPGRADE_SMITHING_TEMPLATE.get();
		this.oreRecipes(ENDERITE_ORE.get().asItem(), ENDERITE_SCRAP.get(), 400);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, ENDERITE_INGOT.get()).requires(ENDERITE_SCRAP.get(), 9), this.getGroup(ENDERITE_INGOT.get()), ENDERITE_SCRAP.get(), ENDERITE_INGOT.get())
			.save(this.output, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, this.getId(ENDERITE_INGOT.get()) + "_from_scrap").toString());
		this.blockRecipes(ENDERITE_INGOT.get(), ENDERITE_BLOCK.get().asItem());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_SWORD, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SWORD.get());
		this.smithingRecipe(enderiteTemplate, NETHERITE_SHIELD.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SHIELD.get());
		this.smithingRecipe(enderiteTemplate, NETHERITE_BOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOW.get());
		this.smithingRecipe(enderiteTemplate, NETHERITE_CROSSBOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CROSSBOW.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_PICKAXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_PICKAXE.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_AXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_AXE.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_SHOVEL, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_SHOVEL.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_HOE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_HOE.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_HELMET, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_HELMET.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_CHESTPLATE, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CHESTPLATE.get());
		this.smithingRecipe(enderiteTemplate, ENDERITE_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, ENDERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_LEGGINGS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_LEGGINGS.get());
		this.smithingRecipe(enderiteTemplate, Items.NETHERITE_BOOTS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOOTS.get());
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, enderiteTemplate, 2).define('D', Items.DIAMOND).define('T', enderiteTemplate).define('B', Items.END_STONE).pattern("DTD").pattern("DBD")
			.pattern("DDD"), this.getGroup(enderiteTemplate), enderiteTemplate, Items.DIAMOND, Items.END_STONE).save(this.output, this.getId(enderiteTemplate) + "_for_duplication");
		//endregion
		//region Steel recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, STEEL_INGOT.get()).requires(Items.IRON_BLOCK, 9), this.getGroup(STEEL_INGOT.get()), Items.IRON_BLOCK, STEEL_INGOT.get()).save(this.output);
		this.swordRecipe(STEEL_INGOT.get(), STEEL_SWORD.get());
		this.pickaxeRecipe(STEEL_INGOT.get(), STEEL_PICKAXE.get());
		this.axeRecipe(STEEL_INGOT.get(), STEEL_AXE.get());
		this.shovelRecipe(STEEL_INGOT.get(), STEEL_SHOVEL.get());
		this.hoeRecipe(STEEL_INGOT.get(), STEEL_HOE.get());
		//endregion
		//region Night recipes
		Item nightTemplate = NIGHT_UPGRADE_SMITHING_TEMPLATE.get();
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, NIGHT_SCRAP.get()).requires(STEEL_INGOT.get(), 4).requires(Items.NETHERITE_INGOT, 4), this.getGroup(NIGHT_INGOT.get()), STEEL_INGOT.get(),
			Items.NETHERITE_INGOT, NIGHT_INGOT.get()).save(this.output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, NIGHT_INGOT.get()).requires(NIGHT_SCRAP.get(), 4), this.getGroup(NIGHT_INGOT.get()), NIGHT_SCRAP.get(), NIGHT_INGOT.get()).save(this.output);
		this.smithingRecipe(nightTemplate, ENDERITE_SWORD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SWORD.get());
		this.smithingRecipe(nightTemplate, ENDERITE_SHIELD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SHIELD.get());
		this.smithingRecipe(nightTemplate, ENDERITE_BOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOW.get());
		this.smithingRecipe(nightTemplate, ENDERITE_CROSSBOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CROSSBOW.get());
		this.smithingRecipe(nightTemplate, ENDERITE_PICKAXE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_PICKAXE.get());
		this.smithingRecipe(nightTemplate, ENDERITE_AXE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_AXE.get());
		this.smithingRecipe(nightTemplate, ENDERITE_SHOVEL.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_SHOVEL.get());
		this.smithingRecipe(nightTemplate, ENDERITE_HOE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_HOE.get());
		this.smithingRecipe(nightTemplate, ENDERITE_HELMET.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_HELMET.get());
		this.smithingRecipe(nightTemplate, ENDERITE_CHESTPLATE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CHESTPLATE.get());
		this.smithingRecipe(nightTemplate, NIGHT_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, NIGHT_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(nightTemplate, ENDERITE_LEGGINGS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_LEGGINGS.get());
		this.smithingRecipe(nightTemplate, ENDERITE_BOOTS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOOTS.get());
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, nightTemplate).requires(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).requires(enderiteTemplate).requires(NIGHT_INGOT.get()),
			this.getGroup(nightTemplate), Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, enderiteTemplate, NIGHT_INGOT.get()).save(this.output);
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.MISC, nightTemplate, 2).define('D', Items.DIAMOND).define('T', nightTemplate).define('B', Items.WITHER_ROSE).pattern("DTD").pattern("DBD")
			.pattern("DDD"), this.getGroup(nightTemplate), nightTemplate, Items.DIAMOND, Items.WITHER_ROSE).save(this.output, this.getId(nightTemplate) + "_for_duplication");
		//endregion
	}
	
	//region Recipe helpers
	private void oreRecipes(@NotNull Item ore, @NotNull Item ingot) {
		this.oreRecipes(ore, ingot, 200);
	}
	
	private void oreRecipes(@NotNull Item ore, @NotNull Item ingot, int time) {
		this.smeltingRecipe(Ingredient.of(ore), ingot, time, this.getGroup(ingot), "_from_smelting_" + this.getId(ore));
		this.blastingRecipe(Ingredient.of(ore), ingot, time / 2, this.getGroup(ingot), "_from_blasting_" + this.getId(ore));
	}
	
	private void blockRecipes(@NotNull Item ingot, @NotNull Item block) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.BUILDING_BLOCKS, block).requires(ingot, 9), this.getGroup(ingot), ingot, block).save(this.output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.MISC, ingot, 9).requires(block), this.getGroup(ingot), ingot, block).save(this.output);
	}
	
	private void swordRecipe(@NotNull Item ingot, @NotNull Item sword) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, sword).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" # ").pattern(" I "), this.getGroup(ingot), ingot, sword).save(this.output);
	}
	
	private void shieldRecipe(@NotNull Item ingot, @NotNull Item shield) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, shield).define('I', Items.IRON_INGOT).define('#', ingot).pattern("#I#").pattern("###").pattern(" # "), this.getGroup(ingot), ingot, shield).save(this.output);
	}
	
	private void pickaxeRecipe(@NotNull Item ingot, @NotNull Item pickaxe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, pickaxe).define('I', Items.STICK).define('#', ingot).pattern("###").pattern(" I ").pattern(" I "), this.getGroup(ingot), ingot, pickaxe).save(this.output);
	}
	
	private void axeRecipe(@NotNull Item ingot, @NotNull Item axe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, axe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("#I ").pattern(" I "), this.getGroup(ingot), ingot, axe).save(this.output);
	}
	
	private void shovelRecipe(@NotNull Item ingot, @NotNull Item shovel) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, shovel).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" I ").pattern(" I "), this.getGroup(ingot), ingot, shovel).save(this.output);
	}
	
	private void hoeRecipe(@NotNull Item ingot, @NotNull Item hoe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.TOOLS, hoe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("I  ").pattern("I  "), this.getGroup(ingot), ingot, hoe).save(this.output);
	}
	
	private void helmetRecipe(@NotNull Item ingot, @NotNull Item helmet) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, helmet).define('#', ingot).pattern("###").pattern("# #").pattern("   "), this.getGroup(ingot), ingot, helmet).save(this.output);
	}
	
	private void chestplateRecipe(@NotNull Item ingot, @NotNull Item chestplate) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, chestplate).define('#', ingot).pattern("# #").pattern("###").pattern("###"), this.getGroup(ingot), ingot, chestplate).save(this.output);
	}
	
	private void elytraChestplateRecipe(@NotNull Item elytraChestplate) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(this.items, RecipeCategory.COMBAT, elytraChestplate).requires(Items.DIAMOND_CHESTPLATE).requires(Items.ELYTRA), this.getGroup(Items.DIAMOND), Items.DIAMOND_CHESTPLATE, Items.ELYTRA, elytraChestplate).save(this.output);
	}
	
	private void leggingsRecipe(@NotNull Item ingot, @NotNull Item leggings) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, leggings).define('#', ingot).pattern("###").pattern("# #").pattern("# #"), this.getGroup(ingot), ingot, leggings).save(this.output);
	}
	
	private void bootsRecipe(@NotNull Item ingot, @NotNull Item boots) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(this.items, RecipeCategory.COMBAT, boots).define('#', ingot).pattern("   ").pattern("# #").pattern("# #"), this.getGroup(ingot), ingot, boots).save(this.output);
	}
	
	private void smithingRecipe(@NotNull Item template, @NotNull Item base, @NotNull Item addition, @NotNull RecipeCategory category, @NotNull Item result) {
		this.unlock(SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), category, result), template, base, addition, result)
			.save(this.output, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, this.getId(result) + "_smithing").toString());
	}
	
	private void smeltingRecipe(@NotNull Ingredient input, @NotNull Item result, int time, @NotNull String group, @NotNull String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.MISC, result, 1.0f, time), group, input, result)
			.save(this.output, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, this.getId(result) + prefix).toString());
	}
	
	private void blastingRecipe(@NotNull Ingredient input, @NotNull Item result, int time, @NotNull String group, @NotNull String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.blasting(input, RecipeCategory.MISC, result, 0.75f, time), group, input, result)
			.save(this.output, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, this.getId(result) + prefix).toString());
	}
	//endregion
	
	//region Group and unlock helpers
	private @NotNull String getId(@NotNull ItemLike item) {
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem())).getPath();
	}
	
	private @NotNull String getGroup(@NotNull Item item) {
		String path = this.getId(item);
		if (!path.contains("_")) {
			return path;
		}
		String[] pathParts = path.split("_");
		if ("polished".equals(pathParts[0]) || "rose".equals(pathParts[0])) {
			return "rose_quartz";
		}
		return pathParts[0];
	}
	
	private @NotNull RecipeBuilder groupAndUnlock(@NotNull RecipeBuilder builder, @NotNull String group, ItemLike @NotNull ... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlockedBy("has_" + this.getId(unlockCriterion), this.has(unlockCriterion));
		}
		return builder.group(group);
	}
	
	private @NotNull SmithingTransformRecipeBuilder unlock(@NotNull SmithingTransformRecipeBuilder builder, ItemLike @NotNull ... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlocks("has_" + this.getId(unlockCriterion), this.has(unlockCriterion));
		}
		return builder;
	}
	
	private @NotNull RecipeBuilder groupAndUnlock(@NotNull RecipeBuilder builder, @NotNull String group, @NotNull Ingredient ingredientCriterion, @NotNull Item itemCriterion) {
		for (Holder<Item> item : ingredientCriterion.items()) {
			Item actualItem = item.get();
			builder.unlockedBy("has_" + this.getId(actualItem), this.has(actualItem));
		}
		return this.groupAndUnlock(builder, group, itemCriterion);
	}
	//endregion
	
	public static class Runner extends RecipeProvider.Runner {
		
		public Runner(@NotNull DataGenerator generator, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider) {
			super(generator.getPackOutput(), lookupProvider);
		}
		
		@Override
		protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider lookup, @NotNull RecipeOutput output) {
			return new XORecipeProvider(lookup, output);
		}
		
		@Override
		public @NotNull String getName() {
			return "XOres Recipes";
		}
	}
}
