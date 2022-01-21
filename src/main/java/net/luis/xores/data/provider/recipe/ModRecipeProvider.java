package net.luis.xores.data.provider.recipe;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
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
	
	protected void oreMaterialRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialTypes.ORE, Material::self, (oreMaterial) -> {
			if (set.has(MaterialTypes.MATERIAL_PART)) {
				Item resultItem = set.get(MaterialTypes.MATERIAL_PART).itemOrThrow();
				if (oreMaterial.isItem()) {
					Item oreItem = oreMaterial.itemOrThrow();
					this.smeltingRecipe(consumer, resultItem, oreItem, 1.0F, getGroup(resultItem), "_from_smelting_" + getId(oreItem));
					this.blastingRecipe(consumer, resultItem, oreItem, 0.75F, getGroup(resultItem), "_from_blasting_" + getId(oreItem));
				} else if (oreMaterial.isTag()) {
					Named<Item> oreTag = oreMaterial.tagOrThrow();
					for (Item oreItem : oreTag.getValues()) {
						this.smeltingRecipe(consumer, resultItem, oreItem, 1.0F, getGroup(resultItem), "_from_smelting_" + getId(oreItem));
						this.blastingRecipe(consumer, resultItem, oreItem, 0.75F, getGroup(resultItem), "_from_blasting_" + getId(oreItem));
					}
				}
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Item resultItem = set.get(MaterialTypes.MATERIAL).itemOrThrow();
				if (oreMaterial.isItem()) {
					Item oreItem = oreMaterial.itemOrThrow();
					this.smeltingRecipe(consumer, resultItem, oreItem, 1.0F, getGroup(resultItem), "_from_smelting_" + getId(oreItem));
					this.blastingRecipe(consumer, resultItem, oreItem, 0.75F, getGroup(resultItem), "_from_blasting_" + getId(oreItem));
				} else if (oreMaterial.isTag()) {
					Named<Item> oreTag = oreMaterial.tagOrThrow();
					for (Item oreItem : oreTag.getValues()) {
						this.smeltingRecipe(consumer, resultItem, oreItem, 1.0F, getGroup(resultItem), "_from_smelting_" + getId(oreItem));
						this.blastingRecipe(consumer, resultItem, oreItem, 0.75F, getGroup(resultItem), "_from_blasting_" + getId(oreItem));
					}
				}
			}
		});
	}
	
	/**
	 * register recipes for Item & Block
	 * @param consumer
	 * @param set for which the recipes should to be created
	 */
	protected void materialBlockRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialTypes.MATERIAL, MaterialTypes.BLOCK, Material::itemOrThrow, (item, block) -> {
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
		set.ifPresent(MaterialTypes.SWORD, Material::itemOrThrow, (sword) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.SWORD) && set.hasUpgrade(MaterialTypes.SWORD)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.SWORD).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, sword);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(sword).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern(" # ").pattern(" # ").pattern(" I ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.WEAPON_MATERIAL)) {
				Material material = set.get(MaterialTypes.WEAPON_MATERIAL);
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
		set.ifPresent(MaterialTypes.SHIELD, Material::itemOrThrow, (shield) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.SHIELD) && set.hasUpgrade(MaterialTypes.SHIELD)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.SHIELD).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, shield);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(shield).group(getGroup(material)).define('I', Items.IRON_INGOT).define('#', material.asIngredient()).pattern("#I#").pattern("###").pattern(" # ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.WEAPON_MATERIAL)) {
				Material material = set.get(MaterialTypes.WEAPON_MATERIAL);
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
		set.ifPresent(MaterialTypes.PICKAXE, Material::itemOrThrow, (pickaxe) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.PICKAXE) && set.hasUpgrade(MaterialTypes.PICKAXE)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.PICKAXE).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, pickaxe);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(pickaxe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("###").pattern(" I ").pattern(" I ")
						.unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.TOOL_MATERIAL)) {
				Material material = set.get(MaterialTypes.TOOL_MATERIAL);
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
		set.ifPresent(MaterialTypes.AXE, Material::itemOrThrow, (axe) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.AXE) && set.hasUpgrade(MaterialTypes.AXE)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.AXE).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, axe);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(axe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern("#I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.TOOL_MATERIAL)) {
				Material material = set.get(MaterialTypes.TOOL_MATERIAL);
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
		set.ifPresent(MaterialTypes.SHOVEL, Material::itemOrThrow, (shovel) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.SHOVEL) && set.hasUpgrade(MaterialTypes.SHOVEL)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.SHOVEL).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, shovel);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(shovel).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern(" # ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.TOOL_MATERIAL)) {
				Material material = set.get(MaterialTypes.TOOL_MATERIAL);
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
		set.ifPresent(MaterialTypes.HOE, Material::itemOrThrow, (hoe) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.HOE) && set.hasUpgrade(MaterialTypes.HOE)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.HOE).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, hoe);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(hoe).group(getGroup(material)).define('I', Items.STICK).define('#', material.asIngredient()).pattern("## ").pattern(" I ").pattern(" I ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.TOOL_MATERIAL)) {
				Material material = set.get(MaterialTypes.TOOL_MATERIAL);
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
		set.ifPresent(MaterialTypes.HELMET, Material::itemOrThrow, (helmet) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.HELMET) && set.hasUpgrade(MaterialTypes.HELMET)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.HELMET).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, helmet);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(helmet).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("   ").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.ARMOR_MATERIAL)) {
				Material material = set.get(MaterialTypes.ARMOR_MATERIAL);
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
		set.ifPresent(MaterialTypes.CHESTPLATE, Material::itemOrThrow, (chestplate) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.CHESTPLATE) && set.hasUpgrade(MaterialTypes.CHESTPLATE)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.CHESTPLATE).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, chestplate);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(chestplate).group(getGroup(material)).define('#', material.asIngredient()).pattern("# #").pattern("###").pattern("###").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.ARMOR_MATERIAL)) {
				Material material = set.get(MaterialTypes.ARMOR_MATERIAL);
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
		set.ifPresent(MaterialTypes.CHESTPLATE, MaterialTypes.ELYTRA_CHESTPLATE, Material::itemOrThrow, (chestplate, elytraChestplate) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.ELYTRA_CHESTPLATE) && set.hasUpgrade(MaterialTypes.ELYTRA_CHESTPLATE)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.ELYTRA_CHESTPLATE).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, elytraChestplate);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getGroup(material)).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
			} else if (set.has(MaterialTypes.ARMOR_MATERIAL)) {
				Material material = set.get(MaterialTypes.ARMOR_MATERIAL);
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
		set.ifPresent(MaterialTypes.LEGGINGS, Material::itemOrThrow, (leggings) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.LEGGINGS) && set.hasUpgrade(MaterialTypes.LEGGINGS)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.LEGGINGS).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, leggings);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(leggings).group(getGroup(material)).define('#', material.asIngredient()).pattern("###").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.ARMOR_MATERIAL)) {
				Material material = set.get(MaterialTypes.ARMOR_MATERIAL);
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
		set.ifPresent(MaterialTypes.BOOTS, Material::itemOrThrow, (boots) -> {
			if (set.has(MaterialTypes.UPGRADE_MATERIAL) && set.has(MaterialTypes.BOOTS) && set.hasUpgrade(MaterialTypes.BOOTS)) {
				Item upgradeItem = set.get(MaterialTypes.UPGRADE_MATERIAL).itemOrThrow();
				Item baseItem = set.getUpgrade(MaterialTypes.BOOTS).itemOrThrow();
				this.smithingRecipe(consumer, baseItem, upgradeItem, boots);
			} else if (set.has(MaterialTypes.MATERIAL)) {
				Material material = set.get(MaterialTypes.MATERIAL);
				ShapedRecipeBuilder.shaped(boots).group(getGroup(material)).define('#', material.asIngredient()).pattern("   ").pattern("# #").pattern("# #").unlockedBy("has_" + getId(material), has(material)).save(consumer);
			} else if (set.has(MaterialTypes.ARMOR_MATERIAL)) {
				Material material = set.get(MaterialTypes.ARMOR_MATERIAL);
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
