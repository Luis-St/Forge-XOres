package net.luis.xores.data.provider.recipe;

import net.luis.xores.XOres;
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

import static net.luis.xores.world.item.XOItems.*;
import static net.luis.xores.world.level.block.XOBlocks.*;

/**
 *
 * @author Luis-St
 *
 */

public class XORecipeProvider extends RecipeProvider {
	
	public XORecipeProvider(@NotNull DataGenerator generator) {
		super(generator.getPackOutput());
	}
	
	@Override
	protected void buildRecipes(@NotNull RecipeOutput output) {
		//region Vanilla additional recipes
		this.shieldRecipe(output, Items.GOLD_INGOT, GOLDEN_SHIELD.get());
		this.shieldRecipe(output, Items.COPPER_INGOT, COPPER_SHIELD.get());
		this.shieldRecipe(output, Items.IRON_INGOT, IRON_SHIELD.get());
		this.shieldRecipe(output, Items.DIAMOND, DIAMOND_SHIELD.get());
		this.smithingRecipe(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, DIAMOND_SHIELD.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_SHIELD.get());
		this.elytraChestplateRecipe(output, DIAMOND_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, DIAMOND_ELYTRA_CHESTPLATE.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.BOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_BOW.get());
		this.smithingRecipe(output, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, Items.CROSSBOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_CROSSBOW.get());
		//endregion
		//region Jade recipes
		this.oreRecipes(output, JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.oreRecipes(output, DEEPSLATE_JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.blockRecipes(output, JADE_INGOT.get(), JADE_BLOCK.get().asItem());
		this.swordRecipe(output, JADE_INGOT.get(), JADE_SWORD.get());
		this.pickaxeRecipe(output, JADE_INGOT.get(), JADE_PICKAXE.get());
		this.axeRecipe(output, JADE_INGOT.get(), JADE_AXE.get());
		this.shovelRecipe(output, JADE_INGOT.get(), JADE_SHOVEL.get());
		this.hoeRecipe(output, JADE_INGOT.get(), JADE_HOE.get());
		this.helmetRecipe(output, JADE_INGOT.get(), JADE_HELMET.get());
		this.chestplateRecipe(output, JADE_INGOT.get(), JADE_CHESTPLATE.get());
		this.leggingsRecipe(output, JADE_INGOT.get(), JADE_LEGGINGS.get());
		this.bootsRecipe(output, JADE_INGOT.get(), JADE_BOOTS.get());
		//endregion
		//region Blazing recipes
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BLAZING_INGOT.get()).define('#', Items.BLAZE_ROD).define('I', Items.GOLD_BLOCK).pattern("###").pattern("#I#").pattern("###"), this.getGroup(BLAZING_INGOT.get()),
			Items.BLAZE_ROD, Items.GOLD_BLOCK, BLAZING_INGOT.get()).save(output);
		this.swordRecipe(output, BLAZING_INGOT.get(), BLAZING_SWORD.get());
		this.pickaxeRecipe(output, BLAZING_INGOT.get(), BLAZING_PICKAXE.get());
		this.axeRecipe(output, BLAZING_INGOT.get(), BLAZING_AXE.get());
		this.shovelRecipe(output, BLAZING_INGOT.get(), BLAZING_SHOVEL.get());
		this.hoeRecipe(output, BLAZING_INGOT.get(), BLAZING_HOE.get());
		this.helmetRecipe(output, BLAZING_INGOT.get(), BLAZING_HELMET.get());
		this.chestplateRecipe(output, BLAZING_INGOT.get(), BLAZING_CHESTPLATE.get());
		this.leggingsRecipe(output, BLAZING_INGOT.get(), BLAZING_LEGGINGS.get());
		this.bootsRecipe(output, BLAZING_INGOT.get(), BLAZING_BOOTS.get());
		//endregion
		//region Saphire recipes
		this.oreRecipes(output, SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.oreRecipes(output, DEEPSLATE_SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.blockRecipes(output, SAPHIRE_INGOT.get(), SAPHIRE_BLOCK.get().asItem());
		this.swordRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get());
		this.shieldRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_SHIELD.get());
		this.pickaxeRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_PICKAXE.get());
		this.axeRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_AXE.get());
		this.shovelRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_SHOVEL.get());
		this.hoeRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_HOE.get());
		this.helmetRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_HELMET.get());
		this.chestplateRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_CHESTPLATE.get());
		this.leggingsRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_LEGGINGS.get());
		this.bootsRecipe(output, SAPHIRE_INGOT.get(), SAPHIRE_BOOTS.get());
		//endregion
		//region Limonite recipes
		this.oreRecipes(output, LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.oreRecipes(output, DEEPSLATE_LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.blockRecipes(output, LIMONITE_INGOT.get(), LIMONITE_BLOCK.get().asItem());
		this.swordRecipe(output, LIMONITE_INGOT.get(), LIMONITE_SWORD.get());
		this.pickaxeRecipe(output, LIMONITE_INGOT.get(), LIMONITE_PICKAXE.get());
		this.axeRecipe(output, LIMONITE_INGOT.get(), LIMONITE_AXE.get());
		this.shovelRecipe(output, LIMONITE_INGOT.get(), LIMONITE_SHOVEL.get());
		this.hoeRecipe(output, LIMONITE_INGOT.get(), LIMONITE_HOE.get());
		this.helmetRecipe(output, LIMONITE_INGOT.get(), LIMONITE_HELMET.get());
		this.chestplateRecipe(output, LIMONITE_INGOT.get(), LIMONITE_CHESTPLATE.get());
		this.leggingsRecipe(output, LIMONITE_INGOT.get(), LIMONITE_LEGGINGS.get());
		this.bootsRecipe(output, LIMONITE_INGOT.get(), LIMONITE_BOOTS.get());
		//endregion
		//region Rose quartz recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ROSE_QUARTZ.get()).requires(Items.QUARTZ, 4).requires(Items.REDSTONE, 4), this.getGroup(POLISHED_ROSE_QUARTZ.get()), Items.QUARTZ, Items.REDSTONE,
			ROSE_QUARTZ.get()).save(output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, POLISHED_ROSE_QUARTZ.get()).requires(ROSE_QUARTZ.get(), 9), this.getGroup(POLISHED_ROSE_QUARTZ.get()), ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get())
			.save(output);
		this.swordRecipe(output, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get());
		this.pickaxeRecipe(output, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_PICKAXE.get());
		this.axeRecipe(output, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_AXE.get());
		this.shovelRecipe(output, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SHOVEL.get());
		this.hoeRecipe(output, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_HOE.get());
		//endregion
		//region Enderite recipes
		this.oreRecipes(output, ENDERITE_ORE.get().asItem(), ENDERITE_SCRAP.get(), 400);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ENDERITE_INGOT.get()).requires(ENDERITE_SCRAP.get(), 9), this.getGroup(ENDERITE_INGOT.get()), ENDERITE_SCRAP.get(), ENDERITE_INGOT.get())
			.save(output, new ResourceLocation(XOres.MOD_ID, this.getId(ENDERITE_INGOT.get()) + "_from_scrap"));
		this.blockRecipes(output, ENDERITE_INGOT.get(), ENDERITE_BLOCK.get().asItem());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SWORD, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SWORD.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), NETHERITE_SHIELD.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SHIELD.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), NETHERITE_BOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOW.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), NETHERITE_CROSSBOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CROSSBOW.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_PICKAXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_PICKAXE.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_AXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_AXE.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_SHOVEL, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_SHOVEL.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HOE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_HOE.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_HELMET, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_HELMET.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_CHESTPLATE, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CHESTPLATE.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, ENDERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_LEGGINGS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_LEGGINGS.get());
		this.smithingRecipe(output, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), Items.NETHERITE_BOOTS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOOTS.get());
		//endregion
		//region Steel recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, STEEL_INGOT.get()).requires(Items.IRON_BLOCK, 9), this.getGroup(STEEL_INGOT.get()), Items.IRON_BLOCK, STEEL_INGOT.get()).save(output);
		this.swordRecipe(output, STEEL_INGOT.get(), STEEL_SWORD.get());
		this.pickaxeRecipe(output, STEEL_INGOT.get(), STEEL_PICKAXE.get());
		this.axeRecipe(output, STEEL_INGOT.get(), STEEL_AXE.get());
		this.shovelRecipe(output, STEEL_INGOT.get(), STEEL_SHOVEL.get());
		this.hoeRecipe(output, STEEL_INGOT.get(), STEEL_HOE.get());
		//endregion
		//region Night recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NIGHT_SCRAP.get()).requires(STEEL_INGOT.get(), 4).requires(Items.NETHERITE_INGOT, 4), this.getGroup(NIGHT_INGOT.get()), STEEL_INGOT.get(),
			Items.NETHERITE_INGOT, NIGHT_INGOT.get()).save(output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NIGHT_INGOT.get()).requires(NIGHT_SCRAP.get(), 4), this.getGroup(NIGHT_INGOT.get()), NIGHT_SCRAP.get(), NIGHT_INGOT.get()).save(output);
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_SWORD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SWORD.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_SHIELD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SHIELD.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_BOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOW.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_CROSSBOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CROSSBOW.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_PICKAXE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_PICKAXE.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_AXE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_AXE.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_SHOVEL.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_SHOVEL.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_HOE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_HOE.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_HELMET.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_HELMET.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_CHESTPLATE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CHESTPLATE.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), NIGHT_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, NIGHT_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_LEGGINGS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_LEGGINGS.get());
		this.smithingRecipe(output, NIGHT_UPGRADE_SMITHING_TEMPLATE.get(), ENDERITE_BOOTS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOOTS.get());
		//endregion
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NIGHT_UPGRADE_SMITHING_TEMPLATE.get()).requires(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE).requires(ENDERITE_UPGRADE_SMITHING_TEMPLATE.get()).requires(NIGHT_INGOT.get()),
			this.getGroup(NIGHT_UPGRADE_SMITHING_TEMPLATE.get()), Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), NIGHT_INGOT.get()).save(output);
	}
	
	//region Recipe helpers
	private void oreRecipes(@NotNull RecipeOutput output, Item ore, Item ingot) {
		this.oreRecipes(output, ore, ingot, 200);
	}
	
	private void oreRecipes(@NotNull RecipeOutput output, Item ore, Item ingot, int time) {
		this.smeltingRecipe(output, Ingredient.of(ore), ingot, time, this.getGroup(ingot), "_from_smelting_" + this.getId(ore));
		this.blastingRecipe(output, Ingredient.of(ore), ingot, time / 2, this.getGroup(ingot), "_from_blasting_" + this.getId(ore));
	}
	
	private void blockRecipes(@NotNull RecipeOutput output, Item ingot, Item block) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, block).requires(ingot, 9), this.getGroup(ingot), ingot, block).save(output);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9).requires(block), this.getGroup(ingot), ingot, block).save(output);
	}
	
	private void swordRecipe(@NotNull RecipeOutput output, Item ingot, Item sword) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" # ").pattern(" I "), this.getGroup(ingot), ingot, sword).save(output);
	}
	
	private void shieldRecipe(@NotNull RecipeOutput output, Item ingot, Item shield) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, shield).define('I', Items.IRON_INGOT).define('#', ingot).pattern("#I#").pattern("###").pattern(" # "), this.getGroup(ingot), ingot, shield).save(output);
	}
	
	private void pickaxeRecipe(@NotNull RecipeOutput output, Item ingot, Item pickaxe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe).define('I', Items.STICK).define('#', ingot).pattern("###").pattern(" I ").pattern(" I "), this.getGroup(ingot), ingot, pickaxe).save(output);
	}
	
	private void axeRecipe(@NotNull RecipeOutput output, Item ingot, Item axe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("#I ").pattern(" I "), this.getGroup(ingot), ingot, axe).save(output);
	}
	
	private void shovelRecipe(@NotNull RecipeOutput output, Item ingot, Item shovel) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" I ").pattern(" I "), this.getGroup(ingot), ingot, shovel).save(output);
	}
	
	private void hoeRecipe(@NotNull RecipeOutput output, Item ingot, Item hoe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("I  ").pattern("I  "), this.getGroup(ingot), ingot, hoe).save(output);
	}
	
	private void helmetRecipe(@NotNull RecipeOutput output, Item ingot, Item helmet) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet).define('#', ingot).pattern("###").pattern("# #").pattern("   "), this.getGroup(ingot), ingot, helmet).save(output);
	}
	
	private void chestplateRecipe(@NotNull RecipeOutput output, Item ingot, Item chestplate) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate).define('#', ingot).pattern("# #").pattern("###").pattern("###"), this.getGroup(ingot), ingot, chestplate).save(output);
	}
	
	private void elytraChestplateRecipe(@NotNull RecipeOutput output, Item elytraChestplate) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, elytraChestplate).requires(Items.DIAMOND_CHESTPLATE).requires(Items.ELYTRA), this.getGroup(Items.DIAMOND), Items.DIAMOND_CHESTPLATE, Items.ELYTRA, elytraChestplate).save(output);
	}
	
	private void leggingsRecipe(@NotNull RecipeOutput output, Item ingot, Item leggings) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings).define('#', ingot).pattern("###").pattern("# #").pattern("# #"), this.getGroup(ingot), ingot, leggings).save(output);
	}
	
	private void bootsRecipe(@NotNull RecipeOutput output, Item ingot, Item boots) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots).define('#', ingot).pattern("   ").pattern("# #").pattern("# #"), this.getGroup(ingot), ingot, boots).save(output);
	}
	
	private void smithingRecipe(@NotNull RecipeOutput output, Item template, Item base, Item addition, RecipeCategory category, Item result) {
		this.unlock(SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), category, result), template, base, addition, result)
			.save(output, new ResourceLocation(XOres.MOD_ID, this.getId(result) + "_smithing"));
	}
	
	private void smeltingRecipe(@NotNull RecipeOutput output, Ingredient input, Item result, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.MISC, result, 1.0f, time), group, input, result).save(output, new ResourceLocation(XOres.MOD_ID, this.getId(result) + prefix));
	}
	
	private void blastingRecipe(@NotNull RecipeOutput output, Ingredient input, Item result, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.blasting(input, RecipeCategory.MISC, result, 0.75f, time), group, input, result).save(output, new ResourceLocation(XOres.MOD_ID, this.getId(result) + prefix));
	}
	//endregion
	
	//region Group and unlock helpers
	private @NotNull String getId(@NotNull ItemLike item) {
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem())).getPath();
	}
	
	private String getGroup(Item item) {
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
	
	private @NotNull RecipeBuilder groupAndUnlock(RecipeBuilder builder, String group, ItemLike @NotNull ... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlockedBy("has_" + this.getId(unlockCriterion), has(unlockCriterion));
		}
		return builder.group(group);
	}
	
	private @NotNull SmithingTransformRecipeBuilder unlock(SmithingTransformRecipeBuilder builder, ItemLike @NotNull ... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlocks("has_" + this.getId(unlockCriterion), has(unlockCriterion));
		}
		return builder;
	}
	
	private @NotNull RecipeBuilder groupAndUnlock(RecipeBuilder builder, String group, @NotNull Ingredient ingredientCriterion, Item itemCriterion) {
		for (Ingredient.Value value : ingredientCriterion.values) {
			if (value instanceof Ingredient.ItemValue itemValue) {
				builder.unlockedBy("has_" + this.getId(itemValue.item().getItem()), has(itemValue.item().getItem()));
			} else if (value instanceof Ingredient.TagValue tagValue) {
				builder.unlockedBy("has_" + tagValue.tag().location().getPath(), has(tagValue.tag()));
			}
		}
		return this.groupAndUnlock(builder, group, itemCriterion);
	}
	//endregion
}
