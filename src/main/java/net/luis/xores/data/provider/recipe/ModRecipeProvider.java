package net.luis.xores.data.provider.recipe;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.set.ArmorSet;
import net.luis.xores.common.material.set.ToolSet;
import net.luis.xores.common.material.set.WeaponSet;
import net.luis.xores.init.MaterialSets;
import net.luis.xores.init.ModItems;
import net.luis.xores.init.ModMaterialSets;
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

@SuppressWarnings("deprecation") // since WeaponSet, ToolSet and ArmorSet are marked as deprecated
public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}
	
	/**
	 * registration of all Recipes
	 */
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		for (MaterialSet set : ModMaterialSets.MATERIALS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.materialSetRecipes(consumer, set);
		}
		for (MaterialSet set : MaterialSets.MATERIALS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			if (set != MaterialSets.WOODEN.get() && set != MaterialSets.LEATHER.get() && set != MaterialSets.STONE.get() && set != MaterialSets.CHAINMAIL.get()) {
				this.vanillaMaterialSetRecipes(consumer, set);
			}
		}
		Item blazingIngot = ModItems.BLAZING_INGOT.get();
		Item goldBlock = Items.GOLD_BLOCK;
		ShapedRecipeBuilder.shaped(blazingIngot).group(getGroup(blazingIngot)).define('#', Items.BLAZE_ROD).define('I', goldBlock).pattern("###").pattern("#I#").pattern("###")
				.unlockedBy("has_" + getId(goldBlock), has(goldBlock)).save(consumer);
		Item roseQuartz = ModItems.ROSE_QUARTZ.get();
		Item rositeIngot = ModItems.ROSITE_INGOT.get();
		ShapelessRecipeBuilder.shapeless(roseQuartz).group(getGroup(roseQuartz)).requires(Items.QUARTZ, 2).requires(rositeIngot, 2).unlockedBy("has_" + getId(rositeIngot), has(rositeIngot)).save(consumer);
		Item polishedRoseQuartz = ModItems.POLISHED_ROSE_QUARTZ.get();
		ShapelessRecipeBuilder.shapeless(polishedRoseQuartz).group(getGroup(polishedRoseQuartz)).requires(roseQuartz, 4).unlockedBy("has_" + getId(roseQuartz), has(roseQuartz)).save(consumer);
		Item netheriteIngot = Items.NETHERITE_INGOT;
		Item enderiteIngot = ModItems.ENDERITE_INGOT.get();
		Item nightIngot = ModItems.NIGHT_INGOT.get();
		this.smithingRecipe(consumer, Items.BOW, netheriteIngot, ModItems.NETHERITE_BOW.get());
		this.smithingRecipe(consumer, Items.CROSSBOW, netheriteIngot, ModItems.NETHERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, ModItems.NETHERITE_BOW.get(), enderiteIngot, ModItems.ENDERITE_BOW.get());
		this.smithingRecipe(consumer, ModItems.NETHERITE_CROSSBOW.get(), enderiteIngot, ModItems.ENDERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, ModItems.ENDERITE_BOW.get(), nightIngot, ModItems.NIGHT_BOW.get());
		this.smithingRecipe(consumer, ModItems.ENDERITE_CROSSBOW.get(), nightIngot, ModItems.NIGHT_CROSSBOW.get());
		ShapelessRecipeBuilder.shapeless(ModItems.STEEL_INGOT.get()).group(getGroup(ModItems.STEEL_INGOT.get())).unlockedBy("has_" + getId(Items.IRON_BLOCK), has(Items.IRON_BLOCK)).requires(Items.IRON_BLOCK, 9).save(consumer);
		Item enderiteScrap = ModItems.ENDERITE_SCRAP.get();
		ResourceLocation location = new ResourceLocation(XOres.MOD_ID, getId(enderiteIngot) + "_from_scrap");
		ShapelessRecipeBuilder.shapeless(enderiteIngot).group(getGroup(enderiteIngot)).unlockedBy("has_" + getId(enderiteScrap), has(enderiteScrap)).requires(enderiteScrap, 9).save(consumer, location);
		ShapelessRecipeBuilder.shapeless(nightIngot).group(getGroup(nightIngot)).unlockedBy("has_" + getId(ModItems.NIGHT_SCRAP.get()), has(ModItems.NIGHT_SCRAP.get())).requires(ModItems.NIGHT_SCRAP.get(), 4).save(consumer);
		ShapelessRecipeBuilder.shapeless(ModItems.NIGHT_SCRAP.get()).group(getGroup(nightIngot)).requires(ModItems.STEEL_INGOT.get(), 2).requires(netheriteIngot, 2).unlockedBy("has_" + getId(netheriteIngot), has(netheriteIngot)).save(consumer);
	}
	
	/**
	 * register the Recipes for a vanilla {@link MaterialSet}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void vanillaMaterialSetRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		this.shieldRecipe(consumer, set);
		this.elytraChestplateRecipe(consumer, set);
	}
	
	/**
	 * register the Recipes for a {@link MaterialSet}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void materialSetRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		this.oreMaterialRecipes(consumer, set);
		this.materialBlockRecipes(consumer, set);
		this.swordRecipe(consumer, set);
		this.shieldRecipe(consumer, set);
		this.pickaxeRecipe(consumer, set);
		this.axeRecipe(consumer, set);
		this.shovelRecipe(consumer, set);
		this.hoeRecipe(consumer, set);
		this.helmetRecipe(consumer, set);
		this.chestplateRecipe(consumer, set);
		this.elytraChestplateRecipe(consumer, set);
		this.leggingsRecipe(consumer, set);
		this.bootsRecipe(consumer, set);
	}
	
	/**
	 * register recipes for Item & ItemPart such as Ore and DeepslateOre
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void oreMaterialRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialSet.ORE, Material::itemOrThrow, (ore) -> {
			if (set.has(MaterialSet.MATERIAL_PART)) {
				Item materialPart = set.get(MaterialSet.MATERIAL_PART).itemOrThrow();
				this.smeltingRecipe(consumer, materialPart, ore, 1.0F, getGroup(materialPart), "_from_smelting_" + getId(ore));
				this.blastingRecipe(consumer, materialPart, ore, 0.75F, getGroup(materialPart), "_from_blasting_" + getId(ore));
			} else if (set.has(MaterialSet.MATERIAL)) {
				Item material = set.get(MaterialSet.MATERIAL).itemOrThrow();
				this.smeltingRecipe(consumer, material, ore, 1.0F, getGroup(material), "_from_smelting_" + getId(ore));
				this.blastingRecipe(consumer, material, ore, 0.75F, getGroup(material), "_from_blasting_" + getId(ore));
			}
		});
		set.ifPresent(MaterialSet.DEEPSLATE_ORE, Material::itemOrThrow, deepslateOre -> {
			if (set.has(MaterialSet.MATERIAL_PART)) {
				Item materialPart = set.get(MaterialSet.MATERIAL_PART).itemOrThrow();
				this.smeltingRecipe(consumer, materialPart, deepslateOre, 1.5F, getGroup(materialPart), "_from_smelting_" + getId(deepslateOre));
				this.blastingRecipe(consumer, materialPart, deepslateOre, 1.125F, getGroup(materialPart), "_from_blasting_" + getId(deepslateOre));
			} else if (set.has(MaterialSet.MATERIAL)) {
				Item material = set.get(MaterialSet.MATERIAL).itemOrThrow();
				this.smeltingRecipe(consumer, material, deepslateOre, 1.5F, getGroup(material), "_from_smelting_" + getId(deepslateOre));
				this.blastingRecipe(consumer, material, deepslateOre, 1.125F, getGroup(material), "_from_blasting_" + getId(deepslateOre));
			}
		});
	}
	
	/**
	 * register recipes for Item & Block
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void materialBlockRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialSet.MATERIAL, MaterialSet.BLOCK, Material::itemOrThrow, (item, block) -> {
			ShapelessRecipeBuilder.shapeless(block).group(getGroup(item)).unlockedBy("has_" + getId(item), has(item)).requires(item, 9).save(consumer);
			ShapelessRecipeBuilder.shapeless(item, 9).group(getGroup(item)).unlockedBy("has_" + getId(block), has(block)).requires(block).save(consumer);
		});
	}
	
	/**
	 * register recipe for {@link SwordItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void swordRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getWeaponSet().ifPresent(WeaponSet.SWORD, (sword) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getWeaponSet().has(WeaponSet.SWORD) && set.getUpgradeMaterialSet().getWeaponSet().has(WeaponSet.SWORD)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getWeaponSet().get(WeaponSet.SWORD);
				this.smithingRecipe(consumer, baseItem, upgradeItem, sword);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(sword).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern(" # ").pattern(" # ").pattern(" I ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(sword).group(getGroup(material)).define('I', Items.IRON_INGOT).define('#', material.asIngredient()).pattern("#I#").pattern("###").pattern(" # ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ShieldItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void shieldRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getWeaponSet().ifPresent(WeaponSet.SHIELD, (shield) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getWeaponSet().has(WeaponSet.SHIELD) && set.getUpgradeMaterialSet().getWeaponSet().has(WeaponSet.SHIELD)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getWeaponSet().get(WeaponSet.SHIELD);
				this.smithingRecipe(consumer, baseItem, upgradeItem, shield);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(shield).group(getGroup(material)).define('I', Items.IRON_INGOT).define('#', material.asIngredient()).pattern("#I#").pattern("###").pattern(" # ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(shield).group(getGroup(material)).define('I', Items.IRON_INGOT).define('#', material.asIngredient()).pattern("#I#").pattern("###").pattern(" # ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link PickaxeItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void pickaxeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getToolSet().ifPresent(ToolSet.PICKAXE, (pickaxe) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getToolSet().has(ToolSet.PICKAXE) && set.getUpgradeMaterialSet().getToolSet().has(ToolSet.PICKAXE)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getToolSet().get(ToolSet.PICKAXE);
				this.smithingRecipe(consumer, baseItem, upgradeItem, pickaxe);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(pickaxe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("###").pattern(" I ").pattern(" I ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(pickaxe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("###").pattern(" I ").pattern(" I ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link AxeItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void axeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getToolSet().ifPresent(ToolSet.AXE, (axe) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getToolSet().has(ToolSet.AXE) && set.getUpgradeMaterialSet().getToolSet().has(ToolSet.AXE)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getToolSet().get(ToolSet.AXE);
				this.smithingRecipe(consumer, baseItem, upgradeItem, axe);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(axe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern("#I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(axe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern("#I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ShovelItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void shovelRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getToolSet().ifPresent(ToolSet.SHOVEL, (shovel) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getToolSet().has(ToolSet.SHOVEL) && set.getUpgradeMaterialSet().getToolSet().has(ToolSet.SHOVEL)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getToolSet().get(ToolSet.SHOVEL);
				this.smithingRecipe(consumer, baseItem, upgradeItem, shovel);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(shovel).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(shovel).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link HoeItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void hoeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getToolSet().ifPresent(ToolSet.HOE, (hoe) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getToolSet().has(ToolSet.HOE) && set.getUpgradeMaterialSet().getToolSet().has(ToolSet.HOE)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getToolSet().get(ToolSet.HOE);
				this.smithingRecipe(consumer, baseItem, upgradeItem, hoe);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(hoe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(hoe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ArmorItem} with {@link EquipmentSlot#HEAD}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void helmetRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getArmorSet().ifPresent(ArmorSet.HELMET, (helmet) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getArmorSet().has(ArmorSet.HELMET) && set.getUpgradeMaterialSet().getArmorSet().has(ArmorSet.HELMET)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getArmorSet().get(ArmorSet.HELMET);
				this.smithingRecipe(consumer, baseItem, upgradeItem, helmet);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(helmet).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("   ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(helmet).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("   ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ArmorItem} with {@link EquipmentSlot#CHEST}
	 * @param consumer
	 * @param set 
	 */
	protected void chestplateRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getArmorSet().ifPresent(ArmorSet.CHESTPLATE, (chestplate) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getArmorSet().has(ArmorSet.CHESTPLATE) && set.getUpgradeMaterialSet().getArmorSet().has(ArmorSet.CHESTPLATE)) { // TODO: check conditions
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getArmorSet().get(ArmorSet.CHESTPLATE);
				this.smithingRecipe(consumer, baseItem, upgradeItem, chestplate);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(chestplate).group(getGroup(material)).define('#', material.asIngredient()).pattern("# #").pattern("###").pattern("###").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(chestplate).group(getGroup(material)).define('#', material.asIngredient()).pattern("# #").pattern("###").pattern("###").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ElytraChestplateItem}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getArmorSet().ifPresent(ArmorSet.CHESTPLATE, ArmorSet.ELYTRA_CHESTPLATE, (chestplate, elytraChestplate) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getArmorSet().has(ArmorSet.ELYTRA_CHESTPLATE) && set.getUpgradeMaterialSet().getArmorSet().has(ArmorSet.ELYTRA_CHESTPLATE)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getArmorSet().get(ArmorSet.ELYTRA_CHESTPLATE);
				this.smithingRecipe(consumer, baseItem, upgradeItem, elytraChestplate);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getGroup(material)).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
			} else if (set.getArmorSet().hasArmorMaterial()) {
				Material material = set.getArmorSet().getArmorMaterial();
				ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getGroup(material)).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ArmorItem} with {@link EquipmentSlot#LEGS}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void leggingsRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getArmorSet().ifPresent(ArmorSet.LEGGINGS, (leggings) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getArmorSet().has(ArmorSet.LEGGINGS) && set.getUpgradeMaterialSet().getArmorSet().has(ArmorSet.LEGGINGS)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getArmorSet().get(ArmorSet.LEGGINGS);
				this.smithingRecipe(consumer, baseItem, upgradeItem, leggings);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(leggings).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(leggings).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register recipe for {@link ArmorItem} with {@link EquipmentSlot#FEET}
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void bootsRecipe(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.getArmorSet().ifPresent(ArmorSet.BOOTS, (boots) -> {
			if (set.has(MaterialSet.UPGRADE_MATERIAL) && set.getArmorSet().has(ArmorSet.BOOTS) && set.getUpgradeMaterialSet().getArmorSet().has(ArmorSet.BOOTS)) {
				Item upgradeItem = set.get(MaterialSet.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgradeMaterialSet().getArmorSet().get(ArmorSet.BOOTS);
				this.smithingRecipe(consumer, baseItem, upgradeItem, boots);
			} else if (set.has(MaterialSet.MATERIAL)) {
				Material material = set.get(MaterialSet.MATERIAL);
				ShapedRecipeBuilder.shaped(boots).group(getGroup(material)).define('#', material.asIngredient()).pattern("   ").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.getWeaponSet().hasWeaponMaterial()) {
				Material material = set.getWeaponSet().getWeaponMaterial();
				ShapedRecipeBuilder.shaped(boots).group(getGroup(material)).define('#', material.asIngredient()).pattern("   ").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			}
		});
	}
	
	/**
	 * register a smithing Recipe
	 * @param consumer
	 * @param baseItem which should be upgrade
	 * @param additionItem which will be add to the baseItem
	 * @param resultItem the result Item of the Recipe
	 */
	protected void smithingRecipe(Consumer<FinishedRecipe> consumer, Item baseItem, Item additionItem, Item resultItem) {
		UpgradeRecipeBuilder.smithing(Ingredient.of(baseItem), Ingredient.of(additionItem), resultItem).unlocks("has_" + getId(baseItem), has(baseItem)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(resultItem) + "_smithing"));
	}
	
	/**
	 * register a smelting Recipe
	 * @param consumer
	 * @param result the result Item of the Recipe
	 * @param ingredient the Item which is being smelted
	 * @param experience which are grant after smelting
	 * @param group of the Recipe
	 * @param nameAddional
	 */
	protected void smeltingRecipe(Consumer<FinishedRecipe> consumer, Item result, Item ingredient, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), result, experience, 200).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
	}
	
	/**
	 * register a blasting Recipe
	 * @param consumer
	 * @param result the result Item of the Recipe
	 * @param ingredient the Item which is being smelted
	 * @param experience which are grant after blasting
	 * @param group of the Recipe
	 * @param nameAddional
	 */
	protected void blastingRecipe(Consumer<FinishedRecipe> consumer, Item result, Item ingredient, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(ingredient), result, experience, 100).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
	}
	
	protected static String getId(Item item) {
		return item.getRegistryName().getPath();
	}
	
	protected static String getId(Material material) {
		if (material.isItem()) {
			return getId(material.itemOrThrow());
		}
		Named<Item> tag = material.tagOrThrow();
		if (!tag.getName().getPath().contains("/")) {
			return tag.getName().getPath();
		}
		String[] pathParts = tag.getName().getPath().split("/");
		return pathParts[pathParts.length - 1];
	}
	
	protected static String getGroup(Item item) {
		String path = item.getRegistryName().getPath();
		if (!path.contains("_")) {
			return path;
		}
		String[] pathParts = path.split("_");
		if (pathParts[0].equals("polished") || pathParts[0].equals("rose")) {
			return "rose_quartz";
		}
		return pathParts[0];
	}
	
	protected static String getGroup(Material material) {
		if (material.isItem()) {
			return getGroup(material.itemOrThrow());
		}
		return getId(material);
	}
	
	protected static TriggerInstance has(Material material) {
		if (material.isItem()) {
			return has(material.itemOrThrow());
		} else if (material.isTag()) {
			return has(material.tagOrThrow());
		}
		throw new IllegalStateException("Fail to get TriggerInstance for Material since it's not Item and Tag");
	}
	
	@Override
	public String getName() {
		return "XOres Recipes";
	}
	
}
