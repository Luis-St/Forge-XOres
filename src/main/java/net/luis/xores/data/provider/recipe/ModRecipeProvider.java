package net.luis.xores.data.provider.recipe;

import java.util.function.Consumer;

import net.luis.xores.XOres;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
//		this.materialSetRecipe(consumer, MaterialSets.JADE);
//		this.materialSetRecipe(consumer, MaterialSets.BLAZING);
//		this.materialSetRecipe(consumer, MaterialSets.LIMONITE);
//		this.materialSetRecipe(consumer, MaterialSets.SAPHIRE);
//		this.materialSetRecipe(consumer, MaterialSets.ROSITE);
//		this.materialSetRecipe(consumer, MaterialSets.ROSE_QUARTZ);
//		this.materialSetRecipe(consumer, MaterialSets.STEEL);
	}
	
	/*	protected void materialSetRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		this.weaponSetRecipe(consumer, set.getWeaponSet(), set.getMaterial());
		this.toolSetRecipe(consumer, set.getToolSet(), set.getMaterial());
		this.armorSetRecipe(consumer, set.getArmorSet(), set.getMaterial());
		if (set.hasOre()) {
			this.oreMaterialRecipe(consumer, set.getMaterial(), set.getOre());
		}
		if (set.hasDeepslateOre()) {
			this.oreMaterialRecipe(consumer, set.getMaterial(), set.getDeepslateOre());
		}
		if (set.hasBlock()) {
			this.materialBlockRecipe(consumer, set.getMaterial(), set.getBlock());
		}
	}
	
	protected void weaponSetRecipe(Consumer<FinishedRecipe> consumer, WeaponSet set, Material material) {
		if (set.hasSword()) {
			this.swordRecipe(consumer, set.getSword(), material);
		}
		if (set.hasShield()) {
			this.shieldRecipe(consumer, set.getShield(), material);
		}
	}
	
	protected void toolSetRecipe(Consumer<FinishedRecipe> consumer, ToolSet set, Material material) {
		if (set.hasPickaxe()) {
			this.pickaxeRecipe(consumer, set.getPickaxe(), material);
		}
		if (set.hasAxe()) {
			this.axeRecipe(consumer, set.getAxe(), material);
		}
		if (set.hasShovel()) {
			this.shovelRecipe(consumer, set.getShovel(), material);
		}
		if (set.hasHoe()) {
			this.hoeRecipe(consumer, set.getHoe(), material);
		}
	}
	
	protected void armorSetRecipe(Consumer<FinishedRecipe> consumer, ArmorSet set, Material material) {
		if (set.hasHelmet()) {
			this.helmetRecipe(consumer, set.getHelmet(), material);
		}
		if (set.hasChestplate()) {
			this.chestplateRecipe(consumer, set.getChestplate(), material);
		}
		if (set.hasElytraChestplate()) {
			this.elytraChestplateRecipe(consumer, set.getElytraChestplate(), set.getChestplate(), material);
		}
		if (set.hasLeggings()) {
			this.leggingsRecipe(consumer, set.getLeggings(), material);
		}
		if (set.hasBoots()) {
			this.bootsRecipe(consumer, set.getBoots(), material);
		}
	}*/
	
	protected void swordRecipe(Consumer<FinishedRecipe> consumer, Item sword, Item material) {
		ShapedRecipeBuilder.shaped(sword).group(getId(material)).define('I', Items.STICK).define('#', material).pattern(" # ").pattern(" # ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void pickaxeRecipe(Consumer<FinishedRecipe> consumer, Item pickaxe, Item material) {
		ShapedRecipeBuilder.shaped(pickaxe).group(getId(material)).define('I', Items.STICK).define('#', material).pattern("###").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void axeRecipe(Consumer<FinishedRecipe> consumer, Item axe, Item material) {
		ShapedRecipeBuilder.shaped(axe).group(getId(material)).define('I', Items.STICK).define('#', material).pattern("## ").pattern("#I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void shovelRecipe(Consumer<FinishedRecipe> consumer, Item shovel, Item material) {
		ShapedRecipeBuilder.shaped(shovel).group(getId(material)).define('I', Items.STICK).define('#', material).pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void hoeRecipe(Consumer<FinishedRecipe> consumer, Item hoe, Item material) {
		ShapedRecipeBuilder.shaped(hoe).group(getId(material)).define('I', Items.STICK).define('#', material).pattern("## ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void shieldRecipe(Consumer<FinishedRecipe> consumer, Item shield, Item material) {
		ShapedRecipeBuilder.shaped(shield).group(getId(material)).define('I', Items.IRON_INGOT).define('#', material).pattern("#I#").pattern("###").pattern(" # ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void helmetRecipe(Consumer<FinishedRecipe> consumer, Item helmet, Item material) {
		ShapedRecipeBuilder.shaped(helmet).group(getId(material)).define('#', material).pattern("###").pattern("# #").pattern("   ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void chestplateRecipe(Consumer<FinishedRecipe> consumer, Item chestplate, Item material) {
		ShapedRecipeBuilder.shaped(chestplate).group(getId(material)).define('#', material).pattern("# #").pattern("###").pattern("###").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, Item elytraChestplate, Item chestplate, Item material) {
		ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getId(material)).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
	}
	
	protected void leggingsRecipe(Consumer<FinishedRecipe> consumer, Item leggings, Item material) {
		ShapedRecipeBuilder.shaped(leggings).group(getId(material)).define('#', material).pattern("###").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void bootsRecipe(Consumer<FinishedRecipe> consumer, Item boots, Item material) {
		ShapedRecipeBuilder.shaped(boots).group(getId(material)).define('#', material).pattern("   ").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
	}
	
	protected void oreMaterialRecipe(Consumer<FinishedRecipe> consumer, Item material, Item ore) {
		smeltingRecipe(consumer, material, ore, 0.0F, getId(material), "_from_smelting_" + getId(ore));
		blastingRecipe(consumer, material, ore, 0.0F, getId(material), "_from_blasting_" + getId(ore));
	}
	
	protected void materialBlockRecipe(Consumer<FinishedRecipe> consumer, Item material, Item block) {
		ShapelessRecipeBuilder.shapeless(block).group(getId(material)).unlockedBy("has_" + getId(material), has(material)).requires(material, 9).save(consumer);
		ShapelessRecipeBuilder.shapeless(material, 9).group(getId(material)).unlockedBy("has_" + getId(block), has(block)).requires(block).save(consumer);
	}
	
	protected void smeltingRecipe(Consumer<FinishedRecipe> consumer, Item result, Item ingredient, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 20).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
	}
	
	protected void blastingRecipe(Consumer<FinishedRecipe> consumer, Item result, Item ingredient, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 10).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
	}
	
	protected static String getId(Item item) {
		return item.getRegistryName().getPath();
	}
	
	@Override
	public String getName() {
		return "XOres Recipes";
	}
	
}
