package net.luis.xores.data.provider.recipe;

import static net.luis.xores.world.item.XOItems.BLAZING_AXE;
import static net.luis.xores.world.item.XOItems.BLAZING_BOOTS;
import static net.luis.xores.world.item.XOItems.BLAZING_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.BLAZING_HELMET;
import static net.luis.xores.world.item.XOItems.BLAZING_HOE;
import static net.luis.xores.world.item.XOItems.BLAZING_INGOT;
import static net.luis.xores.world.item.XOItems.BLAZING_LEGGINGS;
import static net.luis.xores.world.item.XOItems.BLAZING_PICKAXE;
import static net.luis.xores.world.item.XOItems.BLAZING_SHOVEL;
import static net.luis.xores.world.item.XOItems.BLAZING_SWORD;
import static net.luis.xores.world.item.XOItems.COPPER_SHIELD;
import static net.luis.xores.world.item.XOItems.DIAMOND_ELYTRA_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.DIAMOND_SHIELD;
import static net.luis.xores.world.item.XOItems.ENDERITE_AXE;
import static net.luis.xores.world.item.XOItems.ENDERITE_BOOTS;
import static net.luis.xores.world.item.XOItems.ENDERITE_BOW;
import static net.luis.xores.world.item.XOItems.ENDERITE_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.ENDERITE_CROSSBOW;
import static net.luis.xores.world.item.XOItems.ENDERITE_ELYTRA_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.ENDERITE_HELMET;
import static net.luis.xores.world.item.XOItems.ENDERITE_HOE;
import static net.luis.xores.world.item.XOItems.ENDERITE_INGOT;
import static net.luis.xores.world.item.XOItems.ENDERITE_LEGGINGS;
import static net.luis.xores.world.item.XOItems.ENDERITE_PICKAXE;
import static net.luis.xores.world.item.XOItems.ENDERITE_SCRAP;
import static net.luis.xores.world.item.XOItems.ENDERITE_SHIELD;
import static net.luis.xores.world.item.XOItems.ENDERITE_SHOVEL;
import static net.luis.xores.world.item.XOItems.ENDERITE_SWORD;
import static net.luis.xores.world.item.XOItems.GOLDEN_SHIELD;
import static net.luis.xores.world.item.XOItems.IRON_SHIELD;
import static net.luis.xores.world.item.XOItems.JADE_AXE;
import static net.luis.xores.world.item.XOItems.JADE_BOOTS;
import static net.luis.xores.world.item.XOItems.JADE_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.JADE_HELMET;
import static net.luis.xores.world.item.XOItems.JADE_HOE;
import static net.luis.xores.world.item.XOItems.JADE_INGOT;
import static net.luis.xores.world.item.XOItems.JADE_LEGGINGS;
import static net.luis.xores.world.item.XOItems.JADE_PICKAXE;
import static net.luis.xores.world.item.XOItems.JADE_SHOVEL;
import static net.luis.xores.world.item.XOItems.JADE_SWORD;
import static net.luis.xores.world.item.XOItems.LIMONITE_AXE;
import static net.luis.xores.world.item.XOItems.LIMONITE_BOOTS;
import static net.luis.xores.world.item.XOItems.LIMONITE_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.LIMONITE_HELMET;
import static net.luis.xores.world.item.XOItems.LIMONITE_HOE;
import static net.luis.xores.world.item.XOItems.LIMONITE_INGOT;
import static net.luis.xores.world.item.XOItems.LIMONITE_LEGGINGS;
import static net.luis.xores.world.item.XOItems.LIMONITE_PICKAXE;
import static net.luis.xores.world.item.XOItems.LIMONITE_SHOVEL;
import static net.luis.xores.world.item.XOItems.LIMONITE_SWORD;
import static net.luis.xores.world.item.XOItems.NETHERITE_BOW;
import static net.luis.xores.world.item.XOItems.NETHERITE_CROSSBOW;
import static net.luis.xores.world.item.XOItems.NETHERITE_ELYTRA_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.NETHERITE_SHIELD;
import static net.luis.xores.world.item.XOItems.NIGHT_AXE;
import static net.luis.xores.world.item.XOItems.NIGHT_BOOTS;
import static net.luis.xores.world.item.XOItems.NIGHT_BOW;
import static net.luis.xores.world.item.XOItems.NIGHT_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.NIGHT_CROSSBOW;
import static net.luis.xores.world.item.XOItems.NIGHT_ELYTRA_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.NIGHT_HELMET;
import static net.luis.xores.world.item.XOItems.NIGHT_HOE;
import static net.luis.xores.world.item.XOItems.NIGHT_INGOT;
import static net.luis.xores.world.item.XOItems.NIGHT_LEGGINGS;
import static net.luis.xores.world.item.XOItems.NIGHT_PICKAXE;
import static net.luis.xores.world.item.XOItems.NIGHT_SCRAP;
import static net.luis.xores.world.item.XOItems.NIGHT_SHIELD;
import static net.luis.xores.world.item.XOItems.NIGHT_SHOVEL;
import static net.luis.xores.world.item.XOItems.NIGHT_SWORD;
import static net.luis.xores.world.item.XOItems.POLISHED_ROSE_QUARTZ;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ_AXE;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ_HOE;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ_PICKAXE;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ_SHOVEL;
import static net.luis.xores.world.item.XOItems.ROSE_QUARTZ_SWORD;
import static net.luis.xores.world.item.XOItems.SAPHIRE_AXE;
import static net.luis.xores.world.item.XOItems.SAPHIRE_BOOTS;
import static net.luis.xores.world.item.XOItems.SAPHIRE_CHESTPLATE;
import static net.luis.xores.world.item.XOItems.SAPHIRE_HELMET;
import static net.luis.xores.world.item.XOItems.SAPHIRE_HOE;
import static net.luis.xores.world.item.XOItems.SAPHIRE_INGOT;
import static net.luis.xores.world.item.XOItems.SAPHIRE_LEGGINGS;
import static net.luis.xores.world.item.XOItems.SAPHIRE_PICKAXE;
import static net.luis.xores.world.item.XOItems.SAPHIRE_SHIELD;
import static net.luis.xores.world.item.XOItems.SAPHIRE_SHOVEL;
import static net.luis.xores.world.item.XOItems.SAPHIRE_SWORD;
import static net.luis.xores.world.item.XOItems.STEEL_AXE;
import static net.luis.xores.world.item.XOItems.STEEL_HOE;
import static net.luis.xores.world.item.XOItems.STEEL_INGOT;
import static net.luis.xores.world.item.XOItems.STEEL_PICKAXE;
import static net.luis.xores.world.item.XOItems.STEEL_SHOVEL;
import static net.luis.xores.world.item.XOItems.STEEL_SWORD;
import static net.luis.xores.world.level.block.XOBlocks.DEEPSLATE_JADE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.DEEPSLATE_LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.DEEPSLATE_SAPHIRE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.ENDERITE_BLOCK;
import static net.luis.xores.world.level.block.XOBlocks.ENDERITE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.JADE_BLOCK;
import static net.luis.xores.world.level.block.XOBlocks.JADE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.LIMONITE_BLOCK;
import static net.luis.xores.world.level.block.XOBlocks.LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOBlocks.SAPHIRE_BLOCK;
import static net.luis.xores.world.level.block.XOBlocks.SAPHIRE_ORE;

import java.util.function.Consumer;

import net.luis.xores.XOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * 
 * @author Luis-st
 *
 */

public class XORecipeProvider extends RecipeProvider {
	
	public XORecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		// vanilla additional recipes
		this.shieldRecipe(consumer, Items.GOLD_INGOT, GOLDEN_SHIELD.get());
		this.shieldRecipe(consumer, Items.COPPER_INGOT, COPPER_SHIELD.get());
		this.shieldRecipe(consumer, Items.IRON_INGOT, IRON_SHIELD.get());
		this.shieldRecipe(consumer, Items.DIAMOND, DIAMOND_SHIELD.get());
		this.smithingRecipe(consumer, DIAMOND_SHIELD.get(), Items.NETHERITE_INGOT, NETHERITE_SHIELD.get());
		this.elytraChestplateRecipe(consumer, Items.DIAMOND, Items.DIAMOND_CHESTPLATE, Items.ELYTRA, DIAMOND_ELYTRA_CHESTPLATE.get());
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
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(BLAZING_INGOT.get()).define('#', Items.BLAZE_ROD).define('I', Items.GOLD_BLOCK).pattern("###").pattern("#I#").pattern("###"), getGroup(BLAZING_INGOT.get()), Items.BLAZE_ROD, Items.GOLD_BLOCK,
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
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(ROSE_QUARTZ.get()).requires(Items.QUARTZ, 4).requires(Items.REDSTONE, 4), getGroup(POLISHED_ROSE_QUARTZ.get()), Items.QUARTZ, Items.REDSTONE, ROSE_QUARTZ.get()).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(POLISHED_ROSE_QUARTZ.get()).requires(ROSE_QUARTZ.get(), 9), getGroup(POLISHED_ROSE_QUARTZ.get()), ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get()).save(consumer);
		this.swordRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get());
		this.pickaxeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_PICKAXE.get());
		this.axeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_AXE.get());
		this.shovelRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SHOVEL.get());
		this.hoeRecipe(consumer, POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_HOE.get());
		// enderite recipes
		this.oreRecipes(consumer, ENDERITE_ORE.get().asItem(), ENDERITE_SCRAP.get(), 400);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(ENDERITE_INGOT.get()).requires(ENDERITE_SCRAP.get(), 9), getGroup(ENDERITE_INGOT.get()), ENDERITE_SCRAP.get(), ENDERITE_INGOT.get())
			.save(consumer, new ResourceLocation(XOres.MOD_ID, getId(ENDERITE_INGOT.get()) + "_from_scrap"));
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
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(STEEL_INGOT.get()).requires(Items.IRON_BLOCK, 9), getGroup(STEEL_INGOT.get()), Items.IRON_BLOCK, STEEL_INGOT.get()).save(consumer);
		this.swordRecipe(consumer, STEEL_INGOT.get(), STEEL_SWORD.get());
		this.pickaxeRecipe(consumer, STEEL_INGOT.get(), STEEL_PICKAXE.get());
		this.axeRecipe(consumer, STEEL_INGOT.get(), STEEL_AXE.get());
		this.shovelRecipe(consumer, STEEL_INGOT.get(), STEEL_SHOVEL.get());
		this.hoeRecipe(consumer, STEEL_INGOT.get(), STEEL_HOE.get());
		// night recipes
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(NIGHT_SCRAP.get()).requires(STEEL_INGOT.get(), 4).requires(Items.NETHERITE_INGOT, 4), getGroup(NIGHT_INGOT.get()), STEEL_INGOT.get(), Items.NETHERITE_INGOT, NIGHT_INGOT.get()).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(NIGHT_INGOT.get()).requires(NIGHT_SCRAP.get(), 4), getGroup(NIGHT_INGOT.get()), NIGHT_SCRAP.get(), NIGHT_INGOT.get()).save(consumer);
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
	
	private void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot) {
		oreRecipes(consumer, ore, ingot, 200);
	}
	
	private void oreRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item ingot, int time) {
		this.smeltingRecipe(consumer, Ingredient.of(ore), ingot, 1.0F, time, getGroup(ingot), "_from_smelting_" + getId(ore));
		this.blastingRecipe(consumer, Ingredient.of(ore), ingot, 0.75F, time / 2, getGroup(ingot), "_from_blasting_" + getId(ore));
	}
	
	private void blockRecipes(Consumer<FinishedRecipe> consumer, Item ingot, Item block) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(block).requires(ingot, 9), getGroup(ingot), ingot, block).save(consumer);
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(ingot, 9).requires(block), getGroup(ingot), ingot, block).save(consumer);
	}
	
	private void swordRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item sword) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(sword).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" # ").pattern(" I "), getGroup(ingot), ingot, sword).save(consumer);
	}
	
	private void shieldRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shield) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(shield).define('I', Items.IRON_INGOT).define('#', ingot).pattern("#I#").pattern("###").pattern(" # "), getGroup(ingot), ingot, shield).save(consumer);
	}
	
	private void pickaxeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item pickaxe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(pickaxe).define('I', Items.STICK).define('#', ingot).pattern("###").pattern(" I ").pattern(" I "), getGroup(ingot), ingot, pickaxe).save(consumer);
	}
	
	private void axeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item axe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(axe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("#I ").pattern(" I "), getGroup(ingot), ingot, axe).save(consumer);
	}
	
	private void shovelRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item shovel) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(shovel).define('I', Items.STICK).define('#', ingot).pattern(" # ").pattern(" I ").pattern(" I "), getGroup(ingot), ingot, shovel).save(consumer);
	}
	
	private void hoeRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item hoe) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(hoe).define('I', Items.STICK).define('#', ingot).pattern("## ").pattern("I  ").pattern("I  "), getGroup(ingot), ingot, hoe).save(consumer);
	}
	
	private void helmetRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item helmet) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(helmet).define('#', ingot).pattern("###").pattern("# #").pattern("   "), getGroup(ingot), ingot, helmet).save(consumer);
	}
	
	private void chestplateRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item chestplate) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(chestplate).define('#', ingot).pattern("# #").pattern("###").pattern("###"), getGroup(ingot), ingot, chestplate).save(consumer);
	}
	
	private void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item chestplate, Item elytra, Item elytraChestplate) {
		this.groupAndUnlock(ShapelessRecipeBuilder.shapeless(elytraChestplate).requires(chestplate).requires(elytra), getGroup(ingot), chestplate, elytra, elytraChestplate).save(consumer);
	}
	
	private void leggingsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item leggings) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(leggings).define('#', ingot).pattern("###").pattern("# #").pattern("# #"), getGroup(ingot), ingot, leggings).save(consumer);
	}
	
	private void bootsRecipe(Consumer<FinishedRecipe> consumer, Item ingot, Item boots) {
		this.groupAndUnlock(ShapedRecipeBuilder.shaped(boots).define('#', ingot).pattern("   ").pattern("# #").pattern("# #"), getGroup(ingot), ingot, boots).save(consumer);
	}
	
	private void smithingRecipe(Consumer<FinishedRecipe> consumer, Item base, Item addition, Item result) {
		this.unlock(UpgradeRecipeBuilder.smithing(Ingredient.of(base), Ingredient.of(addition), result), base, addition, result).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + "_smithing"));
	}
	
	private void smeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.smelting(input, result, experience, time), group, input, result).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	private void blastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, int time, String group, String prefix) {
		this.groupAndUnlock(SimpleCookingRecipeBuilder.blasting(input, result, experience, time), group, input, result).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	private RecipeBuilder groupAndUnlock(RecipeBuilder builder, String group, ItemLike... unlockCriterions) {
		for (ItemLike unlockCriterion : unlockCriterions) {
			builder.unlockedBy("has_" + getId(unlockCriterion), has(unlockCriterion));
		}
		return builder.group(group);
	}
	
	private UpgradeRecipeBuilder unlock(UpgradeRecipeBuilder builder, ItemLike... unlockCriterions) {
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
	
	private static String getId(ItemLike item) {
		return ForgeRegistries.ITEMS.getKey(item.asItem()).getPath();
	}
	
	private static String getGroup(Item item) {
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
	
	@Override
	public String getName() {
		return "XOres Recipes";
	}
	
}
