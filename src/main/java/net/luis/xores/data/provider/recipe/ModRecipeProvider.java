package net.luis.xores.data.provider.recipe;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
import net.luis.xores.common.util.ConditionChainExecutor;
import net.luis.xores.data.provider.recipe.builder.ModShapedRecipeBuilder;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
		ShapedRecipeBuilder.shaped(blazingIngot).group(getGroup(blazingIngot)).define('#', Items.BLAZE_ROD).define('I', goldBlock).pattern("###").pattern("#I#").pattern("###").unlockedBy("has_" + getId(goldBlock), has(goldBlock)).save(consumer);
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
	
	protected void vanillaMaterialSetRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		this.shieldRecipe(consumer, set);
		this.elytraChestplateRecipe(consumer, set);
	}
	
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
	
	protected void oreMaterialRecipes(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.ORE, (ore) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL_PART);
			}, (set) -> {
				Item resultItem = set.get(MaterialTypes.MATERIAL_PART).itemOrThrow();
				set.ifPresent(MaterialTypes.ORE, Material::self, (oreMaterial) -> {
					this.oreRecipes(consumer, oreMaterial, resultItem);
				});
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Item resultItem = set.get(MaterialTypes.MATERIAL).itemOrThrow();
				set.ifPresent(MaterialTypes.ORE, Material::self, (oreMaterial) -> {
					this.oreRecipes(consumer, oreMaterial, resultItem);
				});
			}).execute(materialSet);
		});
	}
	
	protected void oreRecipes(Consumer<FinishedRecipe> consumer, Material oreMaterial, Item result) {
		this.smeltingRecipe(consumer, oreMaterial.asIngredient(), result, 1.0F, getGroup(result), "_from_smelting_" + getId(oreMaterial));
		this.blastingRecipe(consumer, oreMaterial.asIngredient(), result, 0.75F, getGroup(result), "_from_blasting_" + getId(oreMaterial));
	}
	
	protected void materialBlockRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialTypes.MATERIAL, MaterialTypes.BLOCK, Material::itemOrThrow, (item, block) -> {
			ShapelessRecipeBuilder.shapeless(block).group(getGroup(item)).unlockedBy("has_" + getId(item), has(item)).requires(item, 9).save(consumer);
			ShapelessRecipeBuilder.shapeless(item, 9).group(getGroup(item)).unlockedBy("has_" + getId(block), has(block)).requires(block).save(consumer);
		});
	}

	protected void swordRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.SWORD, Material::itemOrThrow, (sword) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.SWORD);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.SWORD).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), sword);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(sword).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " # ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.WEAPON_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.WEAPON_MATERIAL);
				ModShapedRecipeBuilder.shaped(sword).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " # ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void shieldRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.SHIELD, Material::itemOrThrow, (shield) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.SHIELD);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.SHIELD).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), shield);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(shield).group(material).define('I', Items.IRON_INGOT).define('#', material).pattern("#I#", "###", " # ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.WEAPON_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.WEAPON_MATERIAL);
				ModShapedRecipeBuilder.shaped(shield).group(material).define('I', Items.IRON_INGOT).define('#', material).pattern("#I#", "###", " # ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void pickaxeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.PICKAXE, Material::itemOrThrow, (pickaxe) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.PICKAXE);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.PICKAXE).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), pickaxe);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(pickaxe).group(material).define('I', Items.STICK).define('#', material).pattern("###", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				ModShapedRecipeBuilder.shaped(pickaxe).group(material).define('I', Items.STICK).define('#', material).pattern("###", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void axeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.AXE, Material::itemOrThrow, (axe) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.AXE);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.AXE).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), axe);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(axe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", "#I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				ModShapedRecipeBuilder.shaped(axe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", "#I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void shovelRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.SHOVEL, Material::itemOrThrow, (shovel) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.SHOVEL);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.SHOVEL).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), shovel);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(shovel).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				ModShapedRecipeBuilder.shaped(shovel).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void hoeRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.HOE, Material::itemOrThrow, (hoe) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.HOE);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.HOE).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), hoe);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(hoe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				ModShapedRecipeBuilder.shaped(hoe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void helmetRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.HELMET, Material::itemOrThrow, (helmet) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.HELMET);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.HELMET).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), helmet);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(helmet).group(material).define('#', material).pattern("###", "# #", "   ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				ModShapedRecipeBuilder.shaped(helmet).group(material).define('#', material).pattern("###", "# #", "   ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void chestplateRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.CHESTPLATE, Material::itemOrThrow, (chestplate) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.CHESTPLATE);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.CHESTPLATE).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), chestplate);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(chestplate).group(material).define('#', material).pattern("# #", "###", "###").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				ModShapedRecipeBuilder.shaped(chestplate).group(material).define('#', material).pattern("# #", "###", "###").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void elytraChestplateRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.CHESTPLATE, MaterialTypes.ELYTRA_CHESTPLATE, Material::itemOrThrow, (chestplate, elytraChestplate) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.ELYTRA_CHESTPLATE);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.ELYTRA_CHESTPLATE).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), elytraChestplate);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getGroup(set.get(MaterialTypes.MATERIAL))).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				ShapelessRecipeBuilder.shapeless(elytraChestplate).group(getGroup(set.get(MaterialTypes.ARMOR_MATERIAL))).requires(chestplate).requires(Items.ELYTRA).unlockedBy("has_" + getId(chestplate), has(chestplate)).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void leggingsRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.LEGGINGS, Material::itemOrThrow, (leggings) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.LEGGINGS);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.LEGGINGS).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), leggings);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(leggings).group(material).define('#', material).pattern("###", "# #", "# #").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				ModShapedRecipeBuilder.shaped(leggings).group(material).define('#', material).pattern("###", "# #", "# #").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void bootsRecipe(Consumer<FinishedRecipe> consumer, MaterialSet materialSet) {
		materialSet.ifPresent(MaterialTypes.BOOTS, Material::itemOrThrow, (boots) -> {
			ConditionChainExecutor.<MaterialSet>of((set) -> {
				return set.has(MaterialTypes.MATERIAL) && set.hasUpgrade(MaterialTypes.BOOTS);
			}, (set) -> {
				this.smithingRecipe(consumer, set.getUpgrade(MaterialTypes.BOOTS).itemOrThrow(), set.get(MaterialTypes.MATERIAL).itemOrThrow(), boots);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.MATERIAL);
			}, (set) -> {
				Material material = set.get(MaterialTypes.MATERIAL);
				ModShapedRecipeBuilder.shaped(boots).group(material).define('#', material).pattern("   ", "# #", "# #").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				ModShapedRecipeBuilder.shaped(boots).group(material).define('#', material).pattern("   ", "# #", "# #").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	protected void smithingRecipe(Consumer<FinishedRecipe> consumer, Item baseItem, Item additionItem, Item resultItem) {
		UpgradeRecipeBuilder.smithing(Ingredient.of(baseItem), Ingredient.of(additionItem), resultItem).unlocks("has_" + getId(baseItem), has(baseItem)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(resultItem) + "_smithing"));
	}
	
	protected void smeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient ingredient, Item result, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.smelting(ingredient, result, experience, 200).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
	}
	
	protected void blastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient ingredient, Item result, float experience, String group, String nameAddional) {
		SimpleCookingRecipeBuilder.blasting(ingredient, result, experience, 100).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + nameAddional));
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
