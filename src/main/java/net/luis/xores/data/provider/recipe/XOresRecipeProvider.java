package net.luis.xores.data.provider.recipe;

import static net.luis.xores.world.item.XOresItems.*;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_JADE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_ROSITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_SAPHIRE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.ENDERITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.ENDERITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.JADE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.JADE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.LIMONITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.ROSITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.ROSITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.SAPHIRE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.SAPHIRE_ORE;

import java.util.function.Consumer;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOresItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * extension of {@link RecipeProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the recipes for all mod {@link Item}s
 * 
 * @author Luis-st
 */

public class XOresRecipeProvider extends RecipeProvider {
	
	/**
	 * constructor for the {@link XOresRecipeProvider}
	 */
	public XOresRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	/**
	 * register all recipes for {@link XOresItems#ITEMS}
	 */
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		// vanilla additional recipes
		this.shieldRecipe(consumer, Items.GOLD_INGOT, GOLDEN_SHIELD.get());
		this.shieldRecipe(consumer, Items.COPPER_INGOT, COPPER_SHIELD.get());
		this.shieldRecipe(consumer, Items.IRON_INGOT, IRON_SHIELD.get());
		this.shieldRecipe(consumer, Items.DIAMOND, DIAMOND_SHIELD.get());
		this.smithingRecipe(consumer, DIAMOND_SHIELD.get(), Items.NETHERITE_INGOT, NETHERITE_SHIELD.get());
		this.elytraChestplateRecipe(consumer, Items.DIAMOND_CHESTPLATE, Items.ELYTRA, DIAMOND_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, DIAMOND_ELYTRA_CHESTPLATE.get(), Items.NETHERITE_INGOT, NETHERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, Items.BOW, Items.NETHERITE_INGOT, NETHERITE_BOW.get());
		this.smithingRecipe(consumer, Items.CROSSBOW, Items.NETHERITE_INGOT, NETHERITE_CROSSBOW.get());
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
		ShapedRecipeBuilder.shaped(BLAZING_INGOT.get()).group(getGroup(BLAZING_INGOT.get())).define('#', Items.BLAZE_ROD).define('I', Items.GOLD_BLOCK).pattern("###").pattern("#I#").pattern("###").unlockedBy("has_" + getId(Items.BLAZE_ROD), has(Items.BLAZE_ROD)).unlockedBy("has_" + getId(Items.GOLD_BLOCK), has(Items.GOLD_BLOCK)).save(consumer);
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
		// rosite recipes
		this.oreRecipes(consumer, ROSITE_ORE.get().asItem(), ROSITE_INGOT.get());
		this.oreRecipes(consumer, DEEPSLATE_ROSITE_ORE.get().asItem(), ROSITE_INGOT.get());
		this.blockRecipes(consumer, ROSITE_INGOT.get(), ROSITE_BLOCK.get().asItem());
		this.swordRecipe(consumer, ROSITE_INGOT.get(), ROSITE_SWORD.get());
		this.pickaxeRecipe(consumer, ROSITE_INGOT.get(), ROSITE_PICKAXE.get());
		this.axeRecipe(consumer, ROSITE_INGOT.get(), ROSITE_AXE.get());
		this.shovelRecipe(consumer, ROSITE_INGOT.get(), ROSITE_SHOVEL.get());
		this.hoeRecipe(consumer, ROSITE_INGOT.get(), ROSITE_HOE.get());
		// rose quartz recipes
		ShapelessRecipeBuilder.shapeless(ROSE_QUARTZ.get()).group(getGroup(ROSE_QUARTZ.get())).requires(Items.QUARTZ, 2).requires(ROSITE_INGOT.get(), 2).unlockedBy("has_" + getId(Items.QUARTZ), has(Items.QUARTZ)).unlockedBy("has_" + getId(ROSITE_INGOT.get()), has(ROSITE_INGOT.get())).save(consumer);
		ShapelessRecipeBuilder.shapeless(POLISHED_ROSE_QUARTZ.get()).group(getGroup(POLISHED_ROSE_QUARTZ.get())).requires(ROSE_QUARTZ.get(), 4).unlockedBy("has_" + getId(ROSE_QUARTZ.get()), has(ROSE_QUARTZ.get())).save(consumer);
		this.swordRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get());
		this.pickaxeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_PICKAXE.get());
		this.axeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_AXE.get());
		this.shovelRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SHOVEL.get());
		this.hoeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_HOE.get());
		// enderite recipes
		this.oreRecipes(consumer, ENDERITE_ORE.get().asItem(), ENDERITE_SCRAP.get(), 400);
		ShapelessRecipeBuilder.shapeless(ENDERITE_INGOT.get()).group(getGroup(ENDERITE_INGOT.get())).requires(ENDERITE_SCRAP.get(), 9).unlockedBy("has_" + getId(ENDERITE_SCRAP.get()), has(ENDERITE_SCRAP.get())).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(ENDERITE_INGOT.get()) + "_from_scrap"));
		this.blockRecipes(consumer, ENDERITE_INGOT.get(), ENDERITE_BLOCK.get().asItem());
		this.smithingRecipe(consumer, Items.NETHERITE_SWORD, ENDERITE_INGOT.get(), ENDERITE_SWORD.get());
		this.smithingRecipe(consumer, NETHERITE_SHIELD.get(), ENDERITE_INGOT.get(), ENDERITE_SHIELD.get());
		this.smithingRecipe(consumer, NETHERITE_BOW.get(), ENDERITE_INGOT.get(), ENDERITE_BOW.get());
		this.smithingRecipe(consumer, NETHERITE_CROSSBOW.get(), ENDERITE_INGOT.get(), ENDERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, Items.NETHERITE_PICKAXE, ENDERITE_INGOT.get(), ENDERITE_PICKAXE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_AXE, ENDERITE_INGOT.get(), ENDERITE_AXE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_SHOVEL, ENDERITE_INGOT.get(), ENDERITE_SHOVEL.get());
		this.smithingRecipe(consumer, Items.NETHERITE_HOE, ENDERITE_INGOT.get(), ENDERITE_HOE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_HELMET, ENDERITE_INGOT.get(), ENDERITE_HELMET.get());
		this.smithingRecipe(consumer, Items.NETHERITE_CHESTPLATE, ENDERITE_INGOT.get(), ENDERITE_CHESTPLATE.get());
		this.smithingRecipe(consumer, ENDERITE_CHESTPLATE.get(), Items.ELYTRA, ENDERITE_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, Items.NETHERITE_LEGGINGS, ENDERITE_INGOT.get(), ENDERITE_LEGGINGS.get());
		this.smithingRecipe(consumer, Items.NETHERITE_BOOTS, ENDERITE_INGOT.get(), ENDERITE_BOOTS.get());
		// steel recipes
		ShapelessRecipeBuilder.shapeless(STEEL_INGOT.get()).group(getGroup(STEEL_INGOT.get())).requires(Items.IRON_BLOCK, 9).unlockedBy("has_" + getId(Items.IRON_BLOCK), has(Items.IRON_BLOCK)).save(consumer);
		this.swordRecipe(consumer, STEEL_INGOT.get(), STEEL_SWORD.get());
		this.pickaxeRecipe(consumer, STEEL_INGOT.get(), STEEL_PICKAXE.get());
		this.axeRecipe(consumer, STEEL_INGOT.get(), STEEL_AXE.get());
		this.shovelRecipe(consumer, STEEL_INGOT.get(), STEEL_SHOVEL.get());
		this.hoeRecipe(consumer, STEEL_INGOT.get(), STEEL_HOE.get());
		// night recipes
		ShapelessRecipeBuilder.shapeless(NIGHT_SCRAP.get()).group(getGroup(NIGHT_INGOT.get())).requires(STEEL_INGOT.get(), 2).requires(Items.NETHERITE_INGOT, 2).unlockedBy("has_" + getId(STEEL_INGOT.get()), has(STEEL_INGOT.get())).unlockedBy("has_" + getId(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT)).save(consumer);
		ShapelessRecipeBuilder.shapeless(NIGHT_INGOT.get()).group(getGroup(NIGHT_INGOT.get())).requires(NIGHT_SCRAP.get(), 4).unlockedBy("has_" + getId(NIGHT_SCRAP.get()), has(NIGHT_SCRAP.get())).save(consumer);
		this.smithingRecipe(consumer, ENDERITE_SWORD.get(), NIGHT_INGOT.get(), NIGHT_SWORD.get());
		this.smithingRecipe(consumer, ENDERITE_SHIELD.get(), NIGHT_INGOT.get(), NIGHT_SHIELD.get());
		this.smithingRecipe(consumer, ENDERITE_BOW.get(), NIGHT_INGOT.get(), NIGHT_BOW.get());
		this.smithingRecipe(consumer, ENDERITE_CROSSBOW.get(), NIGHT_INGOT.get(), NIGHT_CROSSBOW.get());
		this.smithingRecipe(consumer, ENDERITE_PICKAXE.get(), NIGHT_INGOT.get(), NIGHT_PICKAXE.get());
		this.smithingRecipe(consumer, ENDERITE_AXE.get(), NIGHT_INGOT.get(), NIGHT_AXE.get());
		this.smithingRecipe(consumer, ENDERITE_SHOVEL.get(), NIGHT_INGOT.get(), NIGHT_SHOVEL.get());
		this.smithingRecipe(consumer, ENDERITE_HOE.get(), NIGHT_INGOT.get(), NIGHT_HOE.get());
		this.smithingRecipe(consumer, ENDERITE_HELMET.get(), NIGHT_INGOT.get(), NIGHT_HELMET.get());
		this.smithingRecipe(consumer, ENDERITE_CHESTPLATE.get(), NIGHT_INGOT.get(), NIGHT_CHESTPLATE.get());
		this.smithingRecipe(consumer, NIGHT_CHESTPLATE.get(), Items.ELYTRA, NIGHT_ELYTRA_CHESTPLATE.get());
		this.smithingRecipe(consumer, ENDERITE_LEGGINGS.get(), NIGHT_INGOT.get(), NIGHT_LEGGINGS.get());
		this.smithingRecipe(consumer, ENDERITE_BOOTS.get(), NIGHT_INGOT.get(), NIGHT_BOOTS.get());
	}
	
	/**
	 * generates the smelting and blasting recipe for a ore
	 */
	protected void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot) {
		oreRecipes(consumer, ore, ingot, 200);
	}
	
	/**
	 * generates the smelting and blasting recipe for a ore
	 */
	protected void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot, int time) {
		this.smeltingRecipe(consumer, Ingredient.of(ore), ingot, 1.0F, time, getGroup(ingot), "_from_smelting_" + getId(ore));
		this.blastingRecipe(consumer, Ingredient.of(ore), ingot, 0.75F, time / 2, getGroup(ingot), "_from_blasting_" + getId(ore));
	}
	
	/**
	 * generates the block recipes
	 */
	protected void blockRecipes(Consumer<FinishedRecipe> consumer, Item ingot, Item block) {
		ShapelessRecipeBuilder.shapeless(block).group(getGroup(ingot)).unlockedBy("has_" + getId(ingot), has(ingot)).requires(ingot, 9).save(consumer);
		ShapelessRecipeBuilder.shapeless(ingot, 9).group(getGroup(ingot)).unlockedBy("has_" + getId(block), has(block)).requires(block).save(consumer);
	}

	/**
	 * generates the sword recipes
	 */
	protected void swordRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item sword) {
		ShapedRecipeBuilder.shaped(sword).group(getGroup(ingot)).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" # ").pattern(" I ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the shield recipes
	 */
	protected void shieldRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shield) {
		ShapedRecipeBuilder.shaped(shield).group(getGroup(ingot)).define('I', Items.IRON_INGOT).define('#', ingot).pattern("#I#").pattern("###").pattern(" # ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the pickaxe recipes
	 */
	protected void pickaxeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item pickaxe) {
		ShapedRecipeBuilder.shaped(pickaxe).group(getGroup(ingot)).define('I', Items.STICK).define('#', ingot).pattern("###").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the axe recipes
	 */
	protected void axeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item axe) {
		ShapedRecipeBuilder.shaped(axe).group(getGroup(ingot)).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("#I ").pattern(" I ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the shovel recipes
	 */
	protected void shovelRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shovel) {
		ShapedRecipeBuilder.shaped(shovel).group(getGroup(ingot)).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the hoe recipes
	 */
	protected void hoeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item hoe) {
		ShapedRecipeBuilder.shaped(hoe).group(getGroup(ingot)).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("I  ").pattern("I  ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the helmet recipes
	 */
	protected void helmetRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item helmet) {
		ShapedRecipeBuilder.shaped(helmet).group(getGroup(ingot)).define('#', ingot).pattern("###").pattern("# #").pattern("   ").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the chestplate recipes
	 */
	protected void chestplateRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item chestplate) {
		ShapedRecipeBuilder.shaped(chestplate).group(getGroup(ingot)).define('#', ingot).pattern("# #").pattern("###").pattern("###").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the elytra chestplate recipes
	 */
	protected void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, Item chestplate, Item elytra, Item elytraChestplate) {
		ShapelessRecipeBuilder.shapeless(elytraChestplate).requires(chestplate).requires(elytra).unlockedBy("has_" + getId(chestplate), has(chestplate)).unlockedBy("has_" + getId(elytra), has(elytra)).save(consumer);
	}
	
	/**
	 * generates the leggings recipes
	 */
	protected void leggingsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item leggings) {
		ShapedRecipeBuilder.shaped(leggings).group(getGroup(ingot)).define('#', ingot).pattern("###").pattern("# #").pattern("# #").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates the boots recipes
	 */
	protected void bootsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item boots) {
		ShapedRecipeBuilder.shaped(boots).group(getGroup(ingot)).define('#', ingot).pattern("   ").pattern("# #").pattern("# #").unlockedBy("has_" + getId(ingot), has(ingot)).save(consumer);
	}
	
	/**
	 * generates a {@link UpgradeRecipe}
	 * @param base The base as an {@link Item} for the {@link UpgradeRecipe}
	 * @param addition The addition as an {@link Item} for the {@link UpgradeRecipe}
	 * @param result The result as an {@link Item} for the {@link UpgradeRecipe}
	 */
	protected void smithingRecipe(Consumer<FinishedRecipe> consumer, Item base, Item addition, Item result) {
		UpgradeRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(addition), result).unlocks("has_" + getId(base), has(base)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + "_smithing"));
	}
	
	/**
	 * generates a {@link SmeltingRecipe}
	 * @param input The input as an {@link Ingredient} for the {@link SmeltingRecipe}
	 * @param result The result as an {@link Item} for the {@link SmeltingRecipe}
	 * @param experience The experience of the {@link SmeltingRecipe}
	 * @param group The group of the {@link SmeltingRecipe}
	 * @param prefix The prefix for the recipe json file name
	 */
	protected void smeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		SimpleCookingRecipeBuilder.smelting(input, result, experience, time).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	/**
	 * generates a {@link BlastingRecipe}
	 * @param input The input as an {@link Ingredient} for the {@link BlastingRecipe}
	 * @param result The result as an {@link Item} for the {@link BlastingRecipe}
	 * @param experience The experience of the {@link BlastingRecipe} for the {@link BlastingRecipe}
	 * @param group The group of the {@link BlastingRecipe}
	 * @param prefix The prefix for the recipe json file name
	 */
	protected void blastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		SimpleCookingRecipeBuilder.blasting(input, result, experience, time).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	/**
	 * @param item The {@link Item} for which a id should be get
	 * @return the id for the given {@link Item} as a {@link String}
	 */
	protected static String getId(Item item) {
		return ForgeRegistries.ITEMS.getKey(item).getPath();
	}
	
	/**
	 * @param item The {@link Item} for which a group should be get
	 * @return the group name for the given {@link Item} as a {@link String}
	 */
	protected static String getGroup(Item item) {
		String path = ForgeRegistries.ITEMS.getKey(item).getPath();
		if (!path.contains("_")) {
			return path;
		}
		String[] pathParts = path.split("_");
		if (pathParts[0].equals("polished") || pathParts[0].equals("rose")) {
			return "rose_quartz";
		}
		return pathParts[0];
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Recipes";
	}
	
}
