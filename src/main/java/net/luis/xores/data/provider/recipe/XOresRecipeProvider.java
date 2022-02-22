package net.luis.xores.data.provider.recipe;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.material.Material;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
import net.luis.xores.common.util.ConditionChainExecutor;
import net.luis.xores.data.provider.recipe.builder.XOresShapedRecipeBuilder;
import net.luis.xores.init.MaterialSets;
import net.luis.xores.init.XOresItems;
import net.luis.xores.init.XOresMaterialSets;
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.UpgradeRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag.Named;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link RecipeProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the recipes for all mod {@link Item}s
 * 
 * @author Luis-st
 * 
 * @see {@link RecipeProvider}
 * @see {@link XOresItems}
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
		for (MaterialSet set : XOresMaterialSets.MATERIALS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.materialSetRecipes(consumer, set);
		}
		for (MaterialSet set : MaterialSets.MATERIALS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			if (set != MaterialSets.WOODEN.get() && set != MaterialSets.LEATHER.get() && set != MaterialSets.STONE.get() && set != MaterialSets.CHAINMAIL.get()) {
				this.vanillaMaterialSetRecipes(consumer, set);
			}
		}
		Item blazingIngot = XOresItems.BLAZING_INGOT.get();
		Item goldBlock = Items.GOLD_BLOCK;
		XOresShapedRecipeBuilder.shaped(blazingIngot).group(getGroup(blazingIngot)).define('#', Items.BLAZE_ROD).define('I', goldBlock).pattern("###", "#I#", "###").unlockedBy("has_" + getId(goldBlock), has(goldBlock)).save(consumer);
		Item roseQuartz = XOresItems.ROSE_QUARTZ.get();
		Item rositeIngot = XOresItems.ROSITE_INGOT.get();
		ShapelessRecipeBuilder.shapeless(roseQuartz).group(getGroup(roseQuartz)).requires(Items.QUARTZ, 2).requires(rositeIngot, 2).unlockedBy("has_" + getId(rositeIngot), has(rositeIngot)).save(consumer);
		Item polishedRoseQuartz = XOresItems.POLISHED_ROSE_QUARTZ.get();
		ShapelessRecipeBuilder.shapeless(polishedRoseQuartz).group(getGroup(polishedRoseQuartz)).requires(roseQuartz, 4).unlockedBy("has_" + getId(roseQuartz), has(roseQuartz)).save(consumer);
		Item netheriteIngot = Items.NETHERITE_INGOT;
		Item enderiteIngot = XOresItems.ENDERITE_INGOT.get();
		Item nightIngot = XOresItems.NIGHT_INGOT.get();
		this.smithingRecipe(consumer, Items.BOW, netheriteIngot, XOresItems.NETHERITE_BOW.get());
		this.smithingRecipe(consumer, Items.CROSSBOW, netheriteIngot, XOresItems.NETHERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, XOresItems.NETHERITE_BOW.get(), enderiteIngot, XOresItems.ENDERITE_BOW.get());
		this.smithingRecipe(consumer, XOresItems.NETHERITE_CROSSBOW.get(), enderiteIngot, XOresItems.ENDERITE_CROSSBOW.get());
		this.smithingRecipe(consumer, XOresItems.ENDERITE_BOW.get(), nightIngot, XOresItems.NIGHT_BOW.get());
		this.smithingRecipe(consumer, XOresItems.ENDERITE_CROSSBOW.get(), nightIngot, XOresItems.NIGHT_CROSSBOW.get());
		ShapelessRecipeBuilder.shapeless(XOresItems.STEEL_INGOT.get()).group(getGroup(XOresItems.STEEL_INGOT.get())).unlockedBy("has_" + getId(Items.IRON_BLOCK), has(Items.IRON_BLOCK)).requires(Items.IRON_BLOCK, 9).save(consumer);
		Item enderiteScrap = XOresItems.ENDERITE_SCRAP.get();
		ResourceLocation location = new ResourceLocation(XOres.MOD_ID, getId(enderiteIngot) + "_from_scrap");
		ShapelessRecipeBuilder.shapeless(enderiteIngot).group(getGroup(enderiteIngot)).unlockedBy("has_" + getId(enderiteScrap), has(enderiteScrap)).requires(enderiteScrap, 9).save(consumer, location);
		ShapelessRecipeBuilder.shapeless(nightIngot).group(getGroup(nightIngot)).unlockedBy("has_" + getId(XOresItems.NIGHT_SCRAP.get()), has(XOresItems.NIGHT_SCRAP.get())).requires(XOresItems.NIGHT_SCRAP.get(), 4).save(consumer);
		ShapelessRecipeBuilder.shapeless(XOresItems.NIGHT_SCRAP.get()).group(getGroup(nightIngot)).requires(XOresItems.STEEL_INGOT.get(), 2).requires(netheriteIngot, 2).unlockedBy("has_" + getId(netheriteIngot), has(netheriteIngot)).save(consumer);
	}
	
	/**
	 * generates the recipes for a vanilla {@link MaterialSet}
	 * 
	 * @see {@link XOresRecipeProvider#shieldRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#elytraChestplateRecipe(Consumer, MaterialSet)}
	 */
	protected void vanillaMaterialSetRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		this.shieldRecipe(consumer, set);
		this.elytraChestplateRecipe(consumer, set);
	}
	
	/**
	 * generates the recipes for a mod {@link MaterialSet}
	 * 
	 * @see {@link XOresRecipeProvider#oreMaterialRecipes(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#materialBlockRecipes(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#swordRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#shieldRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#pickaxeRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#axeRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#shovelRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#hoeRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#helmetRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#chestplateRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#elytraChestplateRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#leggingsRecipe(Consumer, MaterialSet)}
	 * @see {@link XOresRecipeProvider#bootsRecipe(Consumer, MaterialSet)}
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
	 * generates the ore recipes, if there is a ore present in the given {@link MaterialSet}
	 * 
	 * @see {@link XOresRecipeProvider#oreRecipes(Consumer, Material, Item)}
	 */
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
	
	/**
	 * generates the smelting and blasting recipe, for the given {@link Material} as ore<br>
	 * and the given {@link Item} as result of the recipes
	 * 
	 * @see {@link XOresRecipeProvider#smeltingRecipe(Consumer, Ingredient, Item, float, String, String)}
	 * @see {@link XOresRecipeProvider#blastingRecipe(Consumer, Ingredient, Item, float, String, String)}
	 */
	protected void oreRecipes(Consumer<FinishedRecipe> consumer, Material oreMaterial, Item result) {
		this.smeltingRecipe(consumer, oreMaterial.asIngredient(), result, 1.0F, getGroup(result), "_from_smelting_" + getId(oreMaterial));
		this.blastingRecipe(consumer, oreMaterial.asIngredient(), result, 0.75F, getGroup(result), "_from_blasting_" + getId(oreMaterial));
	}
	
	/**
	 * generates the block recipes, if there is a block present in the given {@link MaterialSet}
	 */
	protected void materialBlockRecipes(Consumer<FinishedRecipe> consumer, MaterialSet set) {
		set.ifPresent(MaterialTypes.MATERIAL, MaterialTypes.BLOCK, Material::itemOrThrow, (item, block) -> {
			ShapelessRecipeBuilder.shapeless(block).group(getGroup(item)).unlockedBy("has_" + getId(item), has(item)).requires(item, 9).save(consumer);
			ShapelessRecipeBuilder.shapeless(item, 9).group(getGroup(item)).unlockedBy("has_" + getId(block), has(block)).requires(block).save(consumer);
		});
	}

	/**
	 * generates the sword recipes, if there is a sword present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(sword).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " # ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.WEAPON_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.WEAPON_MATERIAL);
				XOresShapedRecipeBuilder.shaped(sword).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " # ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the shield recipes, if there is a shield present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(shield).group(material).define('I', Items.IRON_INGOT).define('#', material).pattern("#I#", "###", " # ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.WEAPON_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.WEAPON_MATERIAL);
				XOresShapedRecipeBuilder.shaped(shield).group(material).define('I', Items.IRON_INGOT).define('#', material).pattern("#I#", "###", " # ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the pickaxe recipes, if there is a pickaxe present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(pickaxe).group(material).define('I', Items.STICK).define('#', material).pattern("###", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				XOresShapedRecipeBuilder.shaped(pickaxe).group(material).define('I', Items.STICK).define('#', material).pattern("###", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the axe recipes, if there is a axe present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(axe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", "#I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				XOresShapedRecipeBuilder.shaped(axe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", "#I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the shovel recipes, if there is a shovel present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(shovel).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				XOresShapedRecipeBuilder.shaped(shovel).group(material).define('I', Items.STICK).define('#', material).pattern(" # ", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the hoe recipes, if there is a hoe present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(hoe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", " I ", " I ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.TOOL_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.TOOL_MATERIAL);
				XOresShapedRecipeBuilder.shaped(hoe).group(material).define('I', Items.STICK).define('#', material).pattern("## ", " I ", " I ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the helmet recipes, if there is a helmet present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(helmet).group(material).define('#', material).pattern("###", "# #", "   ").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				XOresShapedRecipeBuilder.shaped(helmet).group(material).define('#', material).pattern("###", "# #", "   ").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the chestplate recipes, if there is a chestplate present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(chestplate).group(material).define('#', material).pattern("# #", "###", "###").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				XOresShapedRecipeBuilder.shaped(chestplate).group(material).define('#', material).pattern("# #", "###", "###").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the elytra chestplate recipes, if there is a elytra chestplate present in the given {@link MaterialSet}
	 */
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
	
	/**
	 * generates the leggings recipes, if there is a leggings present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(leggings).group(material).define('#', material).pattern("###", "# #", "# #").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				XOresShapedRecipeBuilder.shaped(leggings).group(material).define('#', material).pattern("###", "# #", "# #").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
	}
	
	/**
	 * generates the boots recipes, if there is a boots present in the given {@link MaterialSet}
	 */
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
				XOresShapedRecipeBuilder.shaped(boots).group(material).define('#', material).pattern("   ", "# #", "# #").unlockedBy(material).save(consumer);
			}).appendElseIf((set) -> {
				return set.has(MaterialTypes.ARMOR_MATERIAL);
			}, (set) -> {
				Material material = materialSet.get(MaterialTypes.ARMOR_MATERIAL);
				XOresShapedRecipeBuilder.shaped(boots).group(material).define('#', material).pattern("   ", "# #", "# #").unlockedBy(material).save(consumer);
			}).execute(materialSet);
		});
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
	protected void smeltingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, String group, String prefix) {
		SimpleCookingRecipeBuilder.smelting(input, result, experience, 200).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	/**
	 * generates a {@link BlastingRecipe}
	 * @param input The input as an {@link Ingredient} for the {@link BlastingRecipe}
	 * @param result The result as an {@link Item} for the {@link BlastingRecipe}
	 * @param experience The experience of the {@link BlastingRecipe} for the {@link BlastingRecipe}
	 * @param group The group of the {@link BlastingRecipe}
	 * @param prefix The prefix for the recipe json file name
	 */
	protected void blastingRecipe(Consumer<FinishedRecipe> consumer, Ingredient input, Item result, float experience, String group, String prefix) {
		SimpleCookingRecipeBuilder.blasting(input, result, experience, 100).group(group).unlockedBy("has_" + getId(result), has(result)).save(consumer, new ResourceLocation(XOres.MOD_ID, getId(result) + prefix));
	}
	
	/**
	 * @param item The {@link Item} for which a id should be get
	 * @return the id for the given {@link Item} as a {@link String}
	 */
	protected static String getId(Item item) {
		return item.getRegistryName().getPath();
	}
	
	/**
	 * @param material The {@link Material} for which a id should be get
	 * @return the id for the given {@link Material} as a {@link String}
	 * @throws IllegalStateException if the given {@link Material} is empty
	 */
	protected static String getId(Material material) {
		if (material.isItem()) {
			return getId(material.itemOrThrow());
		} else if (material.isTag()) {
			Named<Item> tag = material.tagOrThrow();
			if (!tag.getName().getPath().contains("/")) {
				return tag.getName().getPath();
			}
			String[] pathParts = tag.getName().getPath().split("/");
			return pathParts[pathParts.length - 1];
		}
		throw new IllegalStateException("Fail to get ID for a empty Material");
	}
	
	/**
	 * @param item The {@link Item} for which a group should be get
	 * @return the group name for the given {@link Item} as a {@link String}
	 */
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
	
	/**
	 * @param material The {@link Material} for which a group should be get
	 * @return the group name for the given {@link Material} as a {@link String}
	 */
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
	
	/**
	 * @param material The {@link Material} for which a {@link TriggerInstance} should be get
	 * @return a {@link TriggerInstance} for the given {@link Material}
	 * @throws IllegalStateException if the given {@link Material} is empty
	 */
	protected static TriggerInstance has(Material material) {
		if (material.isItem()) {
			return has(material.itemOrThrow());
		} else if (material.isTag()) {
			return has(material.tagOrThrow());
		}
		throw new IllegalStateException("Fail to get TriggerInstance for a empty Material");
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Recipes";
	}
	
}
