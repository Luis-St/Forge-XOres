package net.luis.xores.init;

import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.set.ArmorSet;
import net.luis.xores.common.material.set.ToolSet;
import net.luis.xores.common.material.set.WeaponSet;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

// registration class of MaterialSets for the vanilla Sets
@SuppressWarnings("deprecation") // since WeaponSet, ToolSet and ArmorSet are marked as deprecated
public class MaterialSets {
	
	public static final DeferredRegister<MaterialSet> MATERIALS = DeferredRegister.create(MaterialSet.class, "minecraft");
	
	
	public static final RegistryObject<MaterialSet> WOODEN = MATERIALS.register("wooden", () -> {
		return MaterialSet.ofTag(ItemTags.PLANKS).materialPart(Items.STICK).ore(ItemTags.LOGS)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.WOODEN_SWORD)).shield(shield(Items.SHIELD)).bow(bow(Items.BOW)).crossbow(crossbow(Items.CROSSBOW)))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.WOODEN_PICKAXE)).axe(axe(Items.WOODEN_AXE)).shovel(shovel(Items.WOODEN_SHOVEL)).hoe(hoe(Items.WOODEN_HOE)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> LEATHER = MATERIALS.register("leather", () -> {
		return MaterialSet.ofItem(Items.LEATHER).materialPart(Items.RABBIT_HIDE)
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.LEATHER_HELMET)).chestplate(armor(Items.LEATHER_CHESTPLATE)).leggings(armor(Items.LEATHER_LEGGINGS)).boots(armor(Items.LEATHER_BOOTS)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> STONE = MATERIALS.register("stone", () -> {
		return MaterialSet.ofTag(ItemTags.STONE_TOOL_MATERIALS).ore(ModTags.Items.STONES)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.STONE_SWORD)))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.STONE_PICKAXE)).axe(axe(Items.STONE_AXE)).shovel(shovel(Items.STONE_SHOVEL)).hoe(hoe(Items.STONE_HOE)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> CHAINMAIL = MATERIALS.register("chainmail", () -> {
		return MaterialSet.ofItem(Items.AIR)
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.CHAINMAIL_HELMET)).chestplate(armor(Items.CHAINMAIL_CHESTPLATE)).leggings(armor(Items.CHAINMAIL_LEGGINGS)).boots(armor(Items.CHAINMAIL_BOOTS)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> COPPER = MATERIALS.register("copper", () -> {
		return MaterialSet.ofItem(Items.COPPER_INGOT).ore(Items.COPPER_ORE).deepslateOre(Items.DEEPSLATE_COPPER_ORE)
				.weaponSet(new WeaponSet.Builder().shield(ModItems.COPPER_SHIELD.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> GOLDEN = MATERIALS.register("golden", () -> {
		return MaterialSet.ofItem(Items.GOLD_INGOT).materialPart(Items.GOLD_NUGGET).ore(Items.GOLD_ORE).deepslateOre(Items.DEEPSLATE_GOLD_ORE).block(Items.GOLD_BLOCK)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.GOLDEN_SWORD)).shield(ModItems.GOLDEN_SHIELD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.GOLDEN_PICKAXE)).axe(axe(Items.GOLDEN_AXE)).shovel(shovel(Items.GOLDEN_SHOVEL)).hoe(hoe(Items.GOLDEN_HOE)))
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.GOLDEN_HELMET)).chestplate(armor(Items.GOLDEN_CHESTPLATE)).leggings(armor(Items.GOLDEN_LEGGINGS)).boots(armor(Items.GOLDEN_BOOTS)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> IRON = MATERIALS.register("iron", () -> {
		return MaterialSet.ofItem(Items.IRON_INGOT).materialPart(Items.IRON_NUGGET).ore(Items.IRON_ORE).deepslateOre(Items.DEEPSLATE_IRON_ORE).block(Items.IRON_BLOCK)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.IRON_SWORD)).shield(ModItems.IRON_SHIELD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.IRON_PICKAXE)).axe(axe(Items.IRON_AXE)).shovel(shovel(Items.IRON_SHOVEL)).hoe(hoe(Items.IRON_HOE)))
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.IRON_HELMET)).chestplate(armor(Items.IRON_CHESTPLATE)).leggings(armor(Items.IRON_LEGGINGS)).boots(armor(Items.IRON_BOOTS)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> DIAMOND = MATERIALS.register("diamond", () -> {
		return MaterialSet.ofItem(Items.DIAMOND).block(Items.DIAMOND_BLOCK).ore(Items.DIAMOND_ORE).deepslateOre(Items.DEEPSLATE_DIAMOND_ORE)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.DIAMOND_SWORD)).shield(ModItems.DIAMOND_SHIELD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.DIAMOND_PICKAXE)).axe(axe(Items.DIAMOND_AXE)).shovel(shovel(Items.DIAMOND_SHOVEL)).hoe(hoe(Items.DIAMOND_HOE)))
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.DIAMOND_HELMET)).chestplate(armor(Items.DIAMOND_CHESTPLATE)).elytraChestplate(ModItems.DIAMOND_ELYTRA_CHESTPLATE.get()).leggings(armor(Items.DIAMOND_LEGGINGS))
						.boots(armor(Items.DIAMOND_BOOTS)))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> NETHERITE = MATERIALS.register("netherite", () -> {
		return MaterialSet.ofItem(Items.NETHERITE_INGOT).materialPart(Items.NETHERITE_SCRAP).block(Items.NETHERITE_BLOCK).ore(Items.ANCIENT_DEBRIS)
				.upgradeMaterial(Items.NETHERITE_INGOT).upgradeMaterialSet(DIAMOND)
				.weaponSet(new WeaponSet.Builder().sword(sword(Items.NETHERITE_SWORD)).shield(ModItems.NETHERITE_SHIELD.get()).bow(ModItems.NETHERITE_BOW.get()).crossbow(ModItems.NETHERITE_CROSSBOW.get()))
				.toolSet(new ToolSet.Builder().pickaxe(pickaxe(Items.NETHERITE_PICKAXE)).axe(axe(Items.NETHERITE_AXE)).shovel(shovel(Items.NETHERITE_SHOVEL)).hoe(hoe(Items.NETHERITE_HOE)))
				.armorSet(new ArmorSet.Builder().helmet(armor(Items.NETHERITE_HELMET)).chestplate(armor(Items.NETHERITE_CHESTPLATE)).elytraChestplate(ModItems.NETHERITE_ELYTRA_CHESTPLATE.get()).leggings(armor(Items.NETHERITE_LEGGINGS))
						.boots(armor(Items.NETHERITE_BOOTS)))
				.build();
	});
	
	protected static SwordItem sword(Item item) {
		return (SwordItem) item;
	}
	
	protected static ShieldItem shield(Item item) {
		return (ShieldItem) item;
	}
	
	protected static BowItem bow(Item item) {
		return (BowItem) item;
	}
	
	protected static CrossbowItem crossbow(Item item) {
		return (CrossbowItem) item;
	}
	
	protected static PickaxeItem pickaxe(Item item) {
		return (PickaxeItem) item;
	}
	
	protected static AxeItem axe(Item item) {
		return (AxeItem) item;
	}
	
	protected static ShovelItem shovel(Item item) {
		return (ShovelItem) item;
	}
	
	protected static HoeItem hoe(Item item) {
		return (HoeItem) item;
	}
	
	protected static ArmorItem armor(Item item) {
		return (ArmorItem) item;
	}
	
	static {
		MATERIALS.makeRegistry("material_set",  () -> {
			return new RegistryBuilder<MaterialSet>().onAdd((owner, stage, id, set, oldSet) -> {
				set.valid();
			});
		});
	}
	
}
