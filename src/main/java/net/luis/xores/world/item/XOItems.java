/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.world.item;

import net.luis.xores.XOres;
import net.luis.xores.world.item.equipment.XOArmorMaterials;
import net.luis.xores.world.item.equipment.XOToolMaterials;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template", () -> {
		return new XSSmithingTemplateItem(new Item.Properties().setId(Keys.ENDERITE_UPGRADE_SMITHING_TEMPLATE), XSSmithingTemplateItem.TemplateType.ENDERITE);
	});
	public static final RegistryObject<SmithingTemplateItem> NIGHT_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("night_upgrade_smithing_template", () -> {
		return new XSSmithingTemplateItem(new Item.Properties().setId(Keys.NIGHT_UPGRADE_SMITHING_TEMPLATE), XSSmithingTemplateItem.TemplateType.NIGHT);
	});
	
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(180).setId(Keys.GOLDEN_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(648).setId(Keys.COPPER_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	public static final RegistryObject<ShieldItem> IRON_SHIELD = ITEMS.register("iron_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(1298).setId(Keys.IRON_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(2531).setId(Keys.DIAMOND_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(11465).setId(Keys.NETHERITE_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate", () -> {
		return new ElytraChestplateItem(XOArmorMaterials.DIAMOND_WINGS, new Item.Properties().setId(Keys.DIAMOND_ELYTRA_CHESTPLATE));
	});
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(XOArmorMaterials.NETHERITE_WINGS, new Item.Properties().setId(Keys.NETHERITE_ELYTRA_CHESTPLATE));
	});
	public static final RegistryObject<BowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> {
		return new BowItem(new Item.Properties().durability(765).setId(Keys.NETHERITE_BOW));
	});
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(714).setId(Keys.NETHERITE_CROSSBOW));
	});
	
	public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.JADE_INGOT));
	});
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> {
		return new SwordItem(XOToolMaterials.JADE, 3.0F, -2.4F, new Item.Properties().setId(Keys.JADE_SWORD));
	});
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.JADE, -3, -2.8F, new Item.Properties().setId(Keys.JADE_PICKAXE));
	});
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> {
		return new AxeItem(XOToolMaterials.JADE, 3.0F, -3.1F, new Item.Properties().setId(Keys.JADE_AXE));
	});
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> {
		return new ShovelItem(XOToolMaterials.JADE, -2.0F, -3.0F, new Item.Properties().setId(Keys.JADE_SHOVEL));
	});
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> {
		return new HoeItem(XOToolMaterials.JADE, -5, -0.2F, new Item.Properties().setId(Keys.JADE_HOE));
	});
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.HELMET, new Item.Properties().setId(Keys.JADE_HELMET));
	});
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.JADE_CHESTPLATE));
	});
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.JADE_LEGGINGS));
	});
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.BOOTS, new Item.Properties().setId(Keys.JADE_BOOTS));
	});
	
	public static final RegistryObject<Item> BLAZING_INGOT = ITEMS.register("blazing_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.BLAZING_INGOT));
	});
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", () -> {
		return new BlazingSwordItem(XOToolMaterials.BLAZING, 3.0F, -2.4F, new Item.Properties().setId(Keys.BLAZING_SWORD));
	});
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.BLAZING, -3, -2.8F, new Item.Properties().setId(Keys.BLAZING_PICKAXE));
	});
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", () -> {
		return new AxeItem(XOToolMaterials.BLAZING, 2.0F, -3.0F, new Item.Properties().setId(Keys.BLAZING_AXE));
	});
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", () -> {
		return new ShovelItem(XOToolMaterials.BLAZING, -2.0F, -3.0F, new Item.Properties().setId(Keys.BLAZING_SHOVEL));
	});
	public static final RegistryObject<HoeItem> BLAZING_HOE = ITEMS.register("blazing_hoe", () -> {
		return new HoeItem(XOToolMaterials.BLAZING, -6, 0.0F, new Item.Properties().setId(Keys.BLAZING_HOE));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.HELMET, new Item.Properties().setId(Keys.BLAZING_HELMET));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.BLAZING_CHESTPLATE));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_LEGGINGS = ITEMS.register("blazing_leggings", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.BLAZING_LEGGINGS));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.BOOTS, new Item.Properties().setId(Keys.BLAZING_BOOTS));
	});
	
	public static final RegistryObject<Item> SAPHIRE_INGOT = ITEMS.register("saphire_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.SAPHIRE_INGOT));
	});
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", () -> {
		return new SwordItem(XOToolMaterials.SAPHIRE, -2, -2.4F, new Item.Properties().setId(Keys.SAPHIRE_SWORD));
	});
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = ITEMS.register("saphire_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(5086).setId(Keys.SAPHIRE_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.SAPHIRE, -4, -2.8F, new Item.Properties().setId(Keys.SAPHIRE_PICKAXE));
	});
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", () -> {
		return new AxeItem(XOToolMaterials.SAPHIRE, 0.0F, -3.0F, new Item.Properties().setId(Keys.SAPHIRE_AXE));
	});
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", () -> {
		return new ShovelItem(XOToolMaterials.SAPHIRE, -3.5F, -3.0F, new Item.Properties().setId(Keys.SAPHIRE_SHOVEL));
	});
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", () -> {
		return new HoeItem(XOToolMaterials.SAPHIRE, -8, 0.0F, new Item.Properties().setId(Keys.SAPHIRE_HOE));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.HELMET, new Item.Properties().setId(Keys.SAPHIRE_HELMET));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.SAPHIRE_CHESTPLATE));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_LEGGINGS = ITEMS.register("saphire_leggings", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.SAPHIRE_LEGGINGS));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.BOOTS, new Item.Properties().setId(Keys.SAPHIRE_BOOTS));
	});
	
	public static final RegistryObject<Item> LIMONITE_INGOT = ITEMS.register("limonite_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.LIMONITE_INGOT));
	});
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", () -> {
		return new SwordItem(XOToolMaterials.LIMONITE, -2, -2.4F, new Item.Properties().setId(Keys.LIMONITE_SWORD));
	});
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.LIMONITE, -4, -2.8F, new Item.Properties().setId(Keys.LIMONITE_PICKAXE));
	});
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", () -> {
		return new AxeItem(XOToolMaterials.LIMONITE, 0.0F, -2.8F, new Item.Properties().setId(Keys.LIMONITE_AXE));
	});
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", () -> {
		return new ShovelItem(XOToolMaterials.LIMONITE, -3.5F, -3.0F, new Item.Properties().setId(Keys.LIMONITE_SHOVEL));
	});
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", () -> {
		return new HoeItem(XOToolMaterials.LIMONITE, -10, 0.0F, new Item.Properties().setId(Keys.LIMONITE_HOE));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.HELMET, new Item.Properties().setId(Keys.LIMONITE_HELMET));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.LIMONITE_CHESTPLATE));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_LEGGINGS = ITEMS.register("limonite_leggings", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.LIMONITE_LEGGINGS));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.BOOTS, new Item.Properties().setId(Keys.LIMONITE_BOOTS));
	});
	
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> {
		return new Item(new Item.Properties().setId(Keys.ROSE_QUARTZ));
	});
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = ITEMS.register("polished_rose_quartz", () -> {
		return new Item(new Item.Properties().setId(Keys.POLISHED_ROSE_QUARTZ));
	});
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", () -> {
		return new SwordItem(XOToolMaterials.ROSE_QUARTZ, -2, -2.4F, new Item.Properties().setId(Keys.ROSE_QUARTZ_SWORD));
	});
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.ROSE_QUARTZ, -4, -2.8F, new Item.Properties().setId(Keys.ROSE_QUARTZ_PICKAXE));
	});
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", () -> {
		return new AxeItem(XOToolMaterials.ROSE_QUARTZ, 0.0F, -2.8F, new Item.Properties().setId(Keys.ROSE_QUARTZ_AXE));
	});
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", () -> {
		return new ShovelItem(XOToolMaterials.ROSE_QUARTZ, -3.5F, -3.0F, new Item.Properties().setId(Keys.ROSE_QUARTZ_SHOVEL));
	});
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", () -> {
		return new HoeItem(XOToolMaterials.ROSE_QUARTZ, -12, 0.0F, new Item.Properties().setId(Keys.ROSE_QUARTZ_HOE));
	});
	
	public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> {
		return new Item(new Item.Properties().setId(Keys.ENDERITE_SCRAP));
	});
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.ENDERITE_INGOT));
	});
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> {
		return new SwordItem(XOToolMaterials.ENDERITE, -2, -2.2F, new Item.Properties().setId(Keys.ENDERITE_SWORD));
	});
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = ITEMS.register("enderite_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(22812).setId(Keys.ENDERITE_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	public static final RegistryObject<BowItem> ENDERITE_BOW = ITEMS.register("enderite_bow", () -> {
		return new BowItem(new Item.Properties().durability(1538).setId(Keys.ENDERITE_BOW));
	});
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(1493).setId(Keys.ENDERITE_CROSSBOW));
	});
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.ENDERITE, -4, -2.8F, new Item.Properties().setId(Keys.ENDERITE_PICKAXE));
	});
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> {
		return new AxeItem(XOToolMaterials.ENDERITE, 0.0F, -2.6F, new Item.Properties().setId(Keys.ENDERITE_AXE));
	});
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> {
		return new ShovelItem(XOToolMaterials.ENDERITE, -3.5F, -3.0F, new Item.Properties().setId(Keys.ENDERITE_SHOVEL));
	});
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> {
		return new HoeItem(XOToolMaterials.ENDERITE, -16, 0.0F, new Item.Properties().setId(Keys.ENDERITE_HOE));
	});
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> {
		return new EnderiteHelmetItem(XOArmorMaterials.ENDERITE, new Item.Properties().setId(Keys.ENDERITE_HELMET));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.ENDERITE_CHESTPLATE));
	});
	public static final RegistryObject<EnderiteElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate", () -> {
		return new EnderiteElytraChestplateItem(XOArmorMaterials.ENDERITE_WINGS, new Item.Properties().setId(Keys.ENDERITE_ELYTRA_CHESTPLATE));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.ENDERITE_LEGGINGS));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.BOOTS, new Item.Properties().setId(Keys.ENDERITE_BOOTS));
	});
	
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.STEEL_INGOT));
	});
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> {
		return new SwordItem(XOToolMaterials.STEEL, 1, -2.4F, new Item.Properties().setId(Keys.STEEL_SWORD));
	});
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.STEEL, -1, -2.8F, new Item.Properties().setId(Keys.STEEL_PICKAXE));
	});
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> {
		return new AxeItem(XOToolMaterials.STEEL, 3.0F, -2.8F, new Item.Properties().setId(Keys.STEEL_AXE));
	});
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> {
		return new ShovelItem(XOToolMaterials.STEEL, 0.5F, -3.0F, new Item.Properties().setId(Keys.STEEL_SHOVEL));
	});
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> {
		return new HoeItem(XOToolMaterials.STEEL, -5, 0.0F, new Item.Properties().setId(Keys.STEEL_HOE));
	});
	
	public static final RegistryObject<Item> NIGHT_SCRAP = ITEMS.register("night_scrap", () -> {
		return new Item(new Item.Properties().setId(Keys.NIGHT_SCRAP));
	});
	public static final RegistryObject<Item> NIGHT_INGOT = ITEMS.register("night_ingot", () -> {
		return new Item(new Item.Properties().setId(Keys.NIGHT_INGOT));
	});
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", () -> {
		return new SwordItem(XOToolMaterials.NIGHT, -2, -2.0F, new Item.Properties().setId(Keys.NIGHT_SWORD));
	});
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = ITEMS.register("night_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(38978).setId(Keys.NIGHT_SHIELD), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	public static final RegistryObject<BowItem> NIGHT_BOW = ITEMS.register("night_bow", () -> {
		return new BowItem(new Item.Properties().durability(3245).setId(Keys.NIGHT_BOW));
	});
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(3185).setId(Keys.NIGHT_CROSSBOW));
	});
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", () -> {
		return new PickaxeItem(XOToolMaterials.NIGHT, -4, -2.8F, new Item.Properties().setId(Keys.NIGHT_PICKAXE));
	});
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", () -> {
		return new AxeItem(XOToolMaterials.NIGHT, 0.0F, -2.4F, new Item.Properties().setId(Keys.NIGHT_AXE));
	});
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = ITEMS.register("night_shovel", () -> {
		return new ShovelItem(XOToolMaterials.NIGHT, -3.5F, -3.0F, new Item.Properties().setId(Keys.NIGHT_SHOVEL));
	});
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", () -> {
		return new HoeItem(XOToolMaterials.NIGHT, -19, 0.0F, new Item.Properties().setId(Keys.NIGHT_HOE));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.HELMET, new Item.Properties().setId(Keys.NIGHT_HELMET));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.CHESTPLATE, new Item.Properties().setId(Keys.NIGHT_CHESTPLATE));
	});
	public static final RegistryObject<NightElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = ITEMS.register("night_elytra_chestplate", () -> {
		return new NightElytraChestplateItem(XOArmorMaterials.NIGHT_WINGS, new Item.Properties().setId(Keys.NIGHT_ELYTRA_CHESTPLATE));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_LEGGINGS = ITEMS.register("night_leggings", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.LEGGINGS, new Item.Properties().setId(Keys.NIGHT_LEGGINGS));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.BOOTS, new Item.Properties().setId(Keys.NIGHT_BOOTS));
	});
	
	public static class Keys {
		
		public static final ResourceKey<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = createKey("enderite_upgrade_smithing_template");
		public static final ResourceKey<Item> NIGHT_UPGRADE_SMITHING_TEMPLATE = createKey("night_upgrade_smithing_template");
		
		public static final ResourceKey<Item> GOLDEN_SHIELD = createKey("golden_shield");
		public static final ResourceKey<Item> COPPER_SHIELD = createKey("copper_shield");
		public static final ResourceKey<Item> IRON_SHIELD = createKey("iron_shield");
		public static final ResourceKey<Item> DIAMOND_SHIELD = createKey("diamond_shield");
		public static final ResourceKey<Item> NETHERITE_SHIELD = createKey("netherite_shield");
		public static final ResourceKey<Item> DIAMOND_ELYTRA_CHESTPLATE = createKey("diamond_elytra_chestplate");
		public static final ResourceKey<Item> NETHERITE_ELYTRA_CHESTPLATE = createKey("netherite_elytra_chestplate");
		public static final ResourceKey<Item> NETHERITE_BOW = createKey("netherite_bow");
		public static final ResourceKey<Item> NETHERITE_CROSSBOW = createKey("netherite_crossbow");
		
		public static final ResourceKey<Item> JADE_INGOT = createKey("jade_ingot");
		public static final ResourceKey<Item> JADE_SWORD = createKey("jade_sword");
		public static final ResourceKey<Item> JADE_PICKAXE = createKey("jade_pickaxe");
		public static final ResourceKey<Item> JADE_AXE = createKey("jade_axe");
		public static final ResourceKey<Item> JADE_SHOVEL = createKey("jade_shovel");
		public static final ResourceKey<Item> JADE_HOE = createKey("jade_hoe");
		public static final ResourceKey<Item> JADE_HELMET = createKey("jade_helmet");
		public static final ResourceKey<Item> JADE_CHESTPLATE = createKey("jade_chestplate");
		public static final ResourceKey<Item> JADE_LEGGINGS = createKey("jade_leggings");
		public static final ResourceKey<Item> JADE_BOOTS = createKey("jade_boots");
		
		public static final ResourceKey<Item> BLAZING_INGOT = createKey("blazing_ingot");
		public static final ResourceKey<Item> BLAZING_SWORD = createKey("blazing_sword");
		public static final ResourceKey<Item> BLAZING_PICKAXE = createKey("blazing_pickaxe");
		public static final ResourceKey<Item> BLAZING_AXE = createKey("blazing_axe");
		public static final ResourceKey<Item> BLAZING_SHOVEL = createKey("blazing_shovel");
		public static final ResourceKey<Item> BLAZING_HOE = createKey("blazing_hoe");
		public static final ResourceKey<Item> BLAZING_HELMET = createKey("blazing_helmet");
		public static final ResourceKey<Item> BLAZING_CHESTPLATE = createKey("blazing_chestplate");
		public static final ResourceKey<Item> BLAZING_LEGGINGS = createKey("blazing_leggings");
		public static final ResourceKey<Item> BLAZING_BOOTS = createKey("blazing_boots");
		
		public static final ResourceKey<Item> SAPHIRE_INGOT = createKey("saphire_ingot");
		public static final ResourceKey<Item> SAPHIRE_SWORD = createKey("saphire_sword");
		public static final ResourceKey<Item> SAPHIRE_SHIELD = createKey("saphire_shield");
		public static final ResourceKey<Item> SAPHIRE_PICKAXE = createKey("saphire_pickaxe");
		public static final ResourceKey<Item> SAPHIRE_AXE = createKey("saphire_axe");
		public static final ResourceKey<Item> SAPHIRE_SHOVEL = createKey("saphire_shovel");
		public static final ResourceKey<Item> SAPHIRE_HOE = createKey("saphire_hoe");
		public static final ResourceKey<Item> SAPHIRE_HELMET = createKey("saphire_helmet");
		public static final ResourceKey<Item> SAPHIRE_CHESTPLATE = createKey("saphire_chestplate");
		public static final ResourceKey<Item> SAPHIRE_LEGGINGS = createKey("saphire_leggings");
		public static final ResourceKey<Item> SAPHIRE_BOOTS = createKey("saphire_boots");
		
		public static final ResourceKey<Item> LIMONITE_INGOT = createKey("limonite_ingot");
		public static final ResourceKey<Item> LIMONITE_SWORD = createKey("limonite_sword");
		public static final ResourceKey<Item> LIMONITE_PICKAXE = createKey("limonite_pickaxe");
		public static final ResourceKey<Item> LIMONITE_AXE = createKey("limonite_axe");
		public static final ResourceKey<Item> LIMONITE_SHOVEL = createKey("limonite_shovel");
		public static final ResourceKey<Item> LIMONITE_HOE = createKey("limonite_hoe");
		public static final ResourceKey<Item> LIMONITE_HELMET = createKey("limonite_helmet");
		public static final ResourceKey<Item> LIMONITE_CHESTPLATE = createKey("limonite_chestplate");
		public static final ResourceKey<Item> LIMONITE_LEGGINGS = createKey("limonite_leggings");
		public static final ResourceKey<Item> LIMONITE_BOOTS = createKey("limonite_boots");
		
		public static final ResourceKey<Item> ROSE_QUARTZ = createKey("rose_quartz");
		public static final ResourceKey<Item> POLISHED_ROSE_QUARTZ = createKey("polished_rose_quartz");
		public static final ResourceKey<Item> ROSE_QUARTZ_SWORD = createKey("rose_quartz_sword");
		public static final ResourceKey<Item> ROSE_QUARTZ_PICKAXE = createKey("rose_quartz_pickaxe");
		public static final ResourceKey<Item> ROSE_QUARTZ_AXE = createKey("rose_quartz_axe");
		public static final ResourceKey<Item> ROSE_QUARTZ_SHOVEL = createKey("rose_quartz_shovel");
		public static final ResourceKey<Item> ROSE_QUARTZ_HOE = createKey("rose_quartz_hoe");
		
		public static final ResourceKey<Item> ENDERITE_SCRAP = createKey("enderite_scrap");
		public static final ResourceKey<Item> ENDERITE_INGOT = createKey("enderite_ingot");
		public static final ResourceKey<Item> ENDERITE_SWORD = createKey("enderite_sword");
		public static final ResourceKey<Item> ENDERITE_SHIELD = createKey("enderite_shield");
		public static final ResourceKey<Item> ENDERITE_BOW = createKey("enderite_bow");
		public static final ResourceKey<Item> ENDERITE_CROSSBOW = createKey("enderite_crossbow");
		public static final ResourceKey<Item> ENDERITE_PICKAXE = createKey("enderite_pickaxe");
		public static final ResourceKey<Item> ENDERITE_AXE = createKey("enderite_axe");
		public static final ResourceKey<Item> ENDERITE_SHOVEL = createKey("enderite_shovel");
		public static final ResourceKey<Item> ENDERITE_HOE = createKey("enderite_hoe");
		public static final ResourceKey<Item> ENDERITE_HELMET = createKey("enderite_helmet");
		public static final ResourceKey<Item> ENDERITE_CHESTPLATE = createKey("enderite_chestplate");
		public static final ResourceKey<Item> ENDERITE_ELYTRA_CHESTPLATE = createKey("enderite_elytra_chestplate");
		public static final ResourceKey<Item> ENDERITE_LEGGINGS = createKey("enderite_leggings");
		public static final ResourceKey<Item> ENDERITE_BOOTS = createKey("enderite_boots");
		
		public static final ResourceKey<Item> STEEL_INGOT = createKey("steel_ingot");
		public static final ResourceKey<Item> STEEL_SWORD = createKey("steel_sword");
		public static final ResourceKey<Item> STEEL_PICKAXE = createKey("steel_pickaxe");
		public static final ResourceKey<Item> STEEL_AXE = createKey("steel_axe");
		public static final ResourceKey<Item> STEEL_SHOVEL = createKey("steel_shovel");
		public static final ResourceKey<Item> STEEL_HOE = createKey("steel_hoe");
		
		public static final ResourceKey<Item> NIGHT_SCRAP = createKey("night_scrap");
		public static final ResourceKey<Item> NIGHT_INGOT = createKey("night_ingot");
		public static final ResourceKey<Item> NIGHT_SWORD = createKey("night_sword");
		public static final ResourceKey<Item> NIGHT_SHIELD = createKey("night_shield");
		public static final ResourceKey<Item> NIGHT_BOW = createKey("night_bow");
		public static final ResourceKey<Item> NIGHT_CROSSBOW = createKey("night_crossbow");
		public static final ResourceKey<Item> NIGHT_PICKAXE = createKey("night_pickaxe");
		public static final ResourceKey<Item> NIGHT_AXE = createKey("night_axe");
		public static final ResourceKey<Item> NIGHT_SHOVEL = createKey("night_shovel");
		public static final ResourceKey<Item> NIGHT_HOE = createKey("night_hoe");
		public static final ResourceKey<Item> NIGHT_HELMET = createKey("night_helmet");
		public static final ResourceKey<Item> NIGHT_CHESTPLATE = createKey("night_chestplate");
		public static final ResourceKey<Item> NIGHT_ELYTRA_CHESTPLATE = createKey("night_elytra_chestplate");
		public static final ResourceKey<Item> NIGHT_LEGGINGS = createKey("night_leggings");
		public static final ResourceKey<Item> NIGHT_BOOTS = createKey("night_boots");
		
		public static void register() {}
		
		private static @NotNull ResourceKey<Item> createKey(@NotNull String name) {
			return ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, name));
		}
	}
}
