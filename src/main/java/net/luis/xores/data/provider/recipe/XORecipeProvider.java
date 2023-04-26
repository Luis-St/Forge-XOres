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
import java.util.function.Consumer;

import static net.luis.xores.world.item.XOItems.*;
import static net.luis.xores.world.level.block.XOBlocks.*;

/**
 *
 * @author Luis-st
 *
 */

public class XORecipeProvider extends RecipeProvider {
	
	public XORecipeProvider(DataGenerator generator) {
		super(generator.getPackOutput());
	}
	
	private static String getId(ItemLike item) {
		return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem())).getPath();
	}
	
	private static String getGroup(Item item) {
		String path = getId(item);
		if (!path.contains("_")) {
			return path;
		}
		String[] pathParts = path.split("_");
		if (pathParts[0].equals("polished") || pathParts[0].equals("rose")) {
			return "rose_quartz";
		}
		return pathParts[0];
	}
	
	@Override
	protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
		// vanilla additional recipes
		this.shieldRecipe(consumer, Items.GOLD_INGOT, GOLDEN_SHIELD.get());
		this.shieldRecipe(consumer, Items.COPPER_INGOT, COPPER_SHIELD.get());
		this.shieldRecipe(consumer, Items.IRON_INGOT, IRON_SHIELD.get());
		this.shieldRecipe(consumer, Items.DIAMOND, DIAMOND_SHIELD.get());
		this.smithingRecipe(consumer, DIAMOND_SHIELD.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_SHIELD.get());
		this.elytraChestplateRecipe(consumer, Items.DIAMOND, Items.DIAMOND_CHESTPLATE, Items.ELYTRA, DIAMOND_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, DIAMOND_ELYTRA_CHESTPLATE.get(), Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, Items.BOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_BOW.get());
		this.smithingRecipe(consumer, Items.CROSSBOW, Items.NETHERITE_INGOT, RecipeCategory.COMBAT, NETHERITE_CROSSBOW.get());
		// jade recipes
		this.oreRecipes(consumer, JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.oreRecipes(consumer, DEEPSLATE_JADE_ORE.get().asItem(), JADE_INGOT.get());
		this.blockRecipes(consumer, JADE_INGOT.get(), JADE_BLOCK.get().asItem());
		this.swordRecipe(consumer, JADE_INGOT.get(), JADE_SWORD.get());
		this.pickaxeRecipe(consumer, JADE_INGOT.get(), JADE_PICKAXE.get());
		this.axeRecipe(consumer, JADE_INGOT.get(), JADE_AXE.get());
		this.shovelRecipe(consumer, JADE_INGOT.get(), JADE_SHOVEL.get());
		this.hoeRecipe(consumer, JADE_INGOT.get(), JADE_HOE.get());
		this.helmetRecipe(consumer, JADE_INGOT.get(), JADE_HELMET.get());
		this.chestplateRecipe(consumer, JADE_INGOT.get(), JADE_CHESTPLATE.get());
		this.leggingsRecipe(consumer, JADE_INGOT.get(), JADE_LEGGINGS.get());
		this.bootsRecipe(consumer, JADE_INGOT.get(), JADE_BOOTS.get());
		// blazing recipes
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BLAZING_INGOT.get()).define('#', Items.BLAZE_ROD).define('I', Items.GOLD_BLOCK).pattern("###").pattern("#I#").pattern("###"), getGroup(BLAZING_INGOT.get()),
				Items.BLAZE_ROD, Items.GOLD_BLOCK,
				BLAZING_INGOT.get()).save(consumer);
		this.swordRecipe(consumer, BLAZING_INGOT.get(), BLAZING_SWORD.get());
		this.pickaxeRecipe(consumer, BLAZING_INGOT.get(), BLAZING_PICKAXE.get());
		this.axeRecipe(consumer, BLAZING_INGOT.get(), BLAZING_AXE.get());
		this.shovelRecipe(consumer, BLAZING_INGOT.get(), BLAZING_SHOVEL.get());
		this.hoeRecipe(consumer, BLAZING_INGOT.get(), BLAZING_HOE.get());
		this.helmetRecipe(consumer, BLAZING_INGOT.get(), BLAZING_HELMET.get());
		this.chestplateRecipe(consumer, BLAZING_INGOT.get(), BLAZING_CHESTPLATE.get());
		this.leggingsRecipe(consumer, BLAZING_INGOT.get(), BLAZING_LEGGINGS.get());
		this.bootsRecipe(consumer, BLAZING_INGOT.get(), BLAZING_BOOTS.get());
		// saphire recipes
		this.oreRecipes(consumer, SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.oreRecipes(consumer, DEEPSLATE_SAPHIRE_ORE.get().asItem(), SAPHIRE_INGOT.get());
		this.blockRecipes(consumer, SAPHIRE_INGOT.get(), SAPHIRE_BLOCK.get().asItem());
		this.swordRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get());
		this.shieldRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_SHIELD.get());
		this.pickaxeRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_PICKAXE.get());
		this.axeRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_AXE.get());
		this.shovelRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_SHOVEL.get());
		this.hoeRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_HOE.get());
		this.helmetRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_HELMET.get());
		this.chestplateRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_CHESTPLATE.get());
		this.leggingsRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_LEGGINGS.get());
		this.bootsRecipe(consumer, SAPHIRE_INGOT.get(), SAPHIRE_BOOTS.get());
		// limonite recipes
		this.oreRecipes(consumer, LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.oreRecipes(consumer, DEEPSLATE_LIMONITE_ORE.get().asItem(), LIMONITE_INGOT.get());
		this.blockRecipes(consumer, LIMONITE_INGOT.get(), LIMONITE_BLOCK.get().asItem());
		this.swordRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_SWORD.get());
		this.pickaxeRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_PICKAXE.get());
		this.axeRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_AXE.get());
		this.shovelRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_SHOVEL.get());
		this.hoeRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_HOE.get());
		this.helmetRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_HELMET.get());
		this.chestplateRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_CHESTPLATE.get());
		this.leggingsRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_LEGGINGS.get());
		this.bootsRecipe(consumer, LIMONITE_INGOT.get(), LIMONITE_BOOTS.get());
		// rose quartz recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ROSE_QUARTZ.get()).requires(Items.QUARTZ, 4).requires(Items.REDSTONE, 4), getGroup(POLISHED_ROSE_QUARTZ.get()), Items.QUARTZ, Items.REDSTONE,
				ROSE_QUARTZ.get()).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, POLISHED_ROSE_QUARTZ.get()).requires(ROSE_QUARTZ.get(), 9), getGroup(POLISHED_ROSE_QUARTZ.get()), ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get())
				.save(consumer);
		this.swordRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get());
		this.pickaxeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_PICKAXE.get());
		this.axeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_AXE.get());
		this.shovelRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SHOVEL.get());
		this.hoeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_HOE.get());
		// enderite recipes
		this.oreRecipes(consumer, ENDERITE_ORE.get().asItem(), ENDERITE_SCRAP.get(), 400);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ENDERITE_INGOT.get()).requires(ENDERITE_SCRAP.get(), 9), getGroup(ENDERITE_INGOT.get()), ENDERITE_SCRAP.get(), ENDERITE_INGOT.get())
				.save(consumer, new ResourceLocation(XOres.MOD_ID, getId(ENDERITE_INGOT.get()) + "_from_scrap"));
		this.blockRecipes(consumer, ENDERITE_INGOT.get(), ENDERITE_BLOCK.get().asItem());
		this.smithingRecipe(consumer, Items.NETHERITE_SWORD, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SWORD.get());
		this.smithingRecipe(consumer, NETHERITE_SHIELD.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_SHIELD.get());
		this.smithingRecipe(consumer, NETHERITE_BOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOW.get());
		this.smithingRecipe(consumer, NETHERITE_CROSSBOW.get(), ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, Items.NETHERITE_PICKAXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_PICKAXE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_AXE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_AXE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_SHOVEL, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_SHOVEL.get());
		this.smithingRecipe(consumer, Items.NETHERITE_HOE, ENDERITE_INGOT.get(), RecipeCategory.TOOLS, ENDERITE_HOE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_HELMET, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_HELMET.get());
		this.smithingRecipe(consumer, Items.NETHERITE_CHESTPLATE, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_CHESTPLATE.get());
		this.smithingRecipe(consumer, ENDERITE_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, ENDERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_LEGGINGS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_LEGGINGS.get());
		this.smithingRecipe(consumer, Items.NETHERITE_BOOTS, ENDERITE_INGOT.get(), RecipeCategory.COMBAT, ENDERITE_BOOTS.get());
		// steel recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, STEEL_INGOT.get()).requires(Items.IRON_BLOCK, 9), getGroup(STEEL_INGOT.get()), Items.IRON_BLOCK, STEEL_INGOT.get()).save(consumer);
		this.swordRecipe(consumer, STEEL_INGOT.get(), STEEL_SWORD.get());
		this.pickaxeRecipe(consumer, STEEL_INGOT.get(), STEEL_PICKAXE.get());
		this.axeRecipe(consumer, STEEL_INGOT.get(), STEEL_AXE.get());
		this.shovelRecipe(consumer, STEEL_INGOT.get(), STEEL_SHOVEL.get());
		this.hoeRecipe(consumer, STEEL_INGOT.get(), STEEL_HOE.get());
		// night recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NIGHT_SCRAP.get()).requires(STEEL_INGOT.get(), 4).requires(Items.NETHERITE_INGOT, 4), getGroup(NIGHT_INGOT.get()), STEEL_INGOT.get(), Items.NETHERITE_INGOT,
				NIGHT_INGOT.get()).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NIGHT_INGOT.get()).requires(NIGHT_SCRAP.get(), 4), getGroup(NIGHT_INGOT.get()), NIGHT_SCRAP.get(), NIGHT_INGOT.get()).save(consumer);
		this.smithingRecipe(consumer, ENDERITE_SWORD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SWORD.get());
		this.smithingRecipe(consumer, ENDERITE_SHIELD.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_SHIELD.get());
		this.smithingRecipe(consumer, ENDERITE_BOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOW.get());
		this.smithingRecipe(consumer, ENDERITE_CROSSBOW.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CROSSBOW.get());
		this.smithingRecipe(consumer, ENDERITE_PICKAXE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_PICKAXE.get());
		this.smithingRecipe(consumer, ENDERITE_AXE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_AXE.get());
		this.smithingRecipe(consumer, ENDERITE_SHOVEL.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_SHOVEL.get());
		this.smithingRecipe(consumer, ENDERITE_HOE.get(), NIGHT_INGOT.get(), RecipeCategory.TOOLS, NIGHT_HOE.get());
		this.smithingRecipe(consumer, ENDERITE_HELMET.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_HELMET.get());
		this.smithingRecipe(consumer, ENDERITE_CHESTPLATE.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_CHESTPLATE.get());
		this.smithingRecipe(consumer, NIGHT_CHESTPLATE.get(), Items.ELYTRA, RecipeCategory.COMBAT, NIGHT_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, ENDERITE_LEGGINGS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_LEGGINGS.get());
		this.smithingRecipe(consumer, ENDERITE_BOOTS.get(), NIGHT_INGOT.get(), RecipeCategory.COMBAT, NIGHT_BOOTS.get());
	}
	
	private void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot) {
		oreRecipes(consumer, ore, ingot, 200);
	}
	
	private void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot, int time) {
		this.smeltingRecipe(consumer, Ingredient.of(ore), ingot, 1.0F, time, getGroup(ingot), "_from_smelting_" + getId(ore));
		this.blastingRecipe(consumer, Ingredient.of(ore), ingot, 0.75F, time / 2, getGroup(ingot), "_from_blasting_" + getId(ore));
	}
	
	private void blockRecipes(Consumer<FinishedRecipe> consumer, Item ingot, Item block) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, block).requires(ingot, 9), getGroup(ingot), ingot, block).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingot, 9).requires(block), getGroup(ingot), ingot, block).save(consumer);
	}
	
	private void swordRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item sword) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" # ").pattern(" I "), getGroup(ingot), ingot, sword).save(consumer);
	}
	
	private void shieldRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shield) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, shield).define('I', Items.IRON_INGOT).define('#', ingot).pattern("#I#").pattern("###").pattern(" # "), getGroup(ingot), ingot, shield).save(consumer);
	}
	
	private void pickaxeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item pickaxe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe).define('I', Items.STICK).define('#', ingot).pattern("###").pattern(" I ").pattern(" I "), getGroup(ingot), ingot, pickaxe).save(consumer);
	}
	
	private void axeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item axe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("#I ").pattern(" I "), getGroup(ingot), ingot, axe).save(consumer);
	}
	
	private void shovelRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shovel) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" I ").pattern(" I "), getGroup(ingot), ingot, shovel).save(consumer);
	}
	
	private void hoeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item hoe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("I  ").pattern("I  "), getGroup(ingot), ingot, hoe).save(consumer);
	}
	
	private void helmetRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item helmet) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet).define('#', ingot).pattern("###").pattern("# #").pattern("   "), getGroup(ingot), ingot, helmet).save(consumer);
	}
	
	private void chestplateRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item chestplate) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate).define('#', ingot).pattern("# #").pattern("###").pattern("###"), getGroup(ingot), ingot, chestplate).save(consumer);
	}
	
	private void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item chestplate, Item elytra, Item elytraChestplate) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, elytraChestplate).requires(chestplate).requires(elytra), getGroup(ingot), chestplate, elytra, elytraChestplate).save(consumer);
	}
	
	private void leggingsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item leggings) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings).define('#', ingot).pattern("###").pattern("# #").pattern("# #"), getGroup(ingot), ingot, leggings).save(consumer);
	}
	
	private void bootsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item boots) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots).define('#', ingot).pattern("   ").pattern("# #").pattern("# #"), getGroup(ingot), ingot, boots).save(consumer);
	}
	
	private void smithingRecipe(Consumer<FinishedRecipe> consumer, Item base, Item addition, RecipeCategory category, Item result) {
		this.unlock(SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(base), Ingredient.of(addition), category, result), base, addition, result)
				.save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + "_smithing"));
	}
	
	private void smeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.MISC, result, experience, time), group, input, result).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	private void blastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.blasting(input, RecipeCategory.MISC, result, experience, time), group, input, result).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	private RecipeBuilder groupAndUnlock(RecipeBuilder builder, String group, ItemLike... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlockedBy("has_" + getId(unlockCriterion), has(unlockCriterion));
		}
		return builder.group(group);
	}
	
	private SmithingTransformRecipeBuilder unlock(SmithingTransformRecipeBuilder builder, ItemLike... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlocks("has_" + getId(unlockCriterion), has(unlockCriterion));
		}
		return builder;
	}
	
	private RecipeBuilder groupAndUnlock(RecipeBuilder builder, String group, Ingredient ingredientCriterion, Item itemCriterion) {
		for (Ingredient.Value value : ingredientCriterion.values) {
			if (value instanceof Ingredient.ItemValue itemValue) {
				builder.unlockedBy("has_" + getId(itemValue.item.getItem()), has(itemValue.item.getItem()));
			} else if (value instanceof Ingredient.TagValue tagValue) {
				builder.unlockedBy("has_" + tagValue.tag.location().getPath(), has(tagValue.tag));
			}
		}
		return this.groupAndUnlock(builder, group, itemCriterion);
	}
	
}
