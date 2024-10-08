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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.*;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template", () -> {
		return new XSSmithingTemplateItem(XSSmithingTemplateItem.TemplateType.ENDERITE);
	});
	public static final RegistryObject<SmithingTemplateItem> NIGHT_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("night_upgrade_smithing_template", () -> {
		return new XSSmithingTemplateItem(XSSmithingTemplateItem.TemplateType.NIGHT);
	});
	
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(180), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(648), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	public static final RegistryObject<ShieldItem> IRON_SHIELD = ITEMS.register("iron_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(1298), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(2531), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(11465), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.DIAMOND, new Item.Properties());
	});
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.NETHERITE, new Item.Properties());
	});
	public static final RegistryObject<BowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> {
		return new BowItem(new Item.Properties().durability(765));
	});
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(714));
	});
	
	public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> {
		return new SwordItem(XOresTiers.JADE, new Item.Properties());
	});
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.JADE, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.JADE, -3, -2.8F)));
	});
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> {
		return new AxeItem(XOresTiers.JADE, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.JADE, 3.0F, -3.1F)));
	});
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> {
		return new ShovelItem(XOresTiers.JADE, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.JADE, -2.0F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> {
		return new HoeItem(XOresTiers.JADE, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.JADE, -5, -0.2F)));
	});
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> {
		return new ArmorItem(XOArmorMaterials.JADE.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties());
	});
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> {
		return new ArmorItem(XOArmorMaterials.JADE.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> {
		return new ArmorItem(XOArmorMaterials.JADE.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> {
		return new ArmorItem(XOArmorMaterials.JADE.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
	
	public static final RegistryObject<Item> BLAZING_INGOT = ITEMS.register("blazing_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", () -> {
		return new BlazingSwordItem(XOresTiers.BLAZING, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.BLAZING, -1, -2.4F)));
	});
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.BLAZING, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.BLAZING, -3, -2.8F)));
	});
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", () -> {
		return new AxeItem(XOresTiers.BLAZING, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.BLAZING, 2.0F, -3.0F)));
	});
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", () -> {
		return new ShovelItem(XOresTiers.BLAZING, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.BLAZING, -2.0F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> BLAZING_HOE = ITEMS.register("blazing_hoe", () -> {
		return new HoeItem(XOresTiers.BLAZING, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.BLAZING, -6, 0.0F)));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties());
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_LEGGINGS = ITEMS.register("blazing_leggings", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", () -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
	
	public static final RegistryObject<Item> SAPHIRE_INGOT = ITEMS.register("saphire_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", () -> {
		return new SwordItem(XOresTiers.SAPHIRE, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.SAPHIRE, -2, -2.4F)));
	});
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = ITEMS.register("saphire_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(5086), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.SAPHIRE, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.SAPHIRE, -4, -2.8F)));
	});
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", () -> {
		return new AxeItem(XOresTiers.SAPHIRE, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.SAPHIRE, 0.0F, -3.0F)));
	});
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", () -> {
		return new ShovelItem(XOresTiers.SAPHIRE, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.SAPHIRE, -3.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", () -> {
		return new HoeItem(XOresTiers.SAPHIRE, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.SAPHIRE, -8, 0.0F)));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties());
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_LEGGINGS = ITEMS.register("saphire_leggings", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", () -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
	
	public static final RegistryObject<Item> LIMONITE_INGOT = ITEMS.register("limonite_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", () -> {
		return new SwordItem(XOresTiers.LIMONITE, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.LIMONITE, -2, -2.4F)));
	});
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.LIMONITE, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.LIMONITE, -4, -2.8F)));
	});
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", () -> {
		return new AxeItem(XOresTiers.LIMONITE, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.LIMONITE, 0.0F, -2.8F)));
	});
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", () -> {
		return new ShovelItem(XOresTiers.LIMONITE, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.LIMONITE, -3.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", () -> {
		return new HoeItem(XOresTiers.LIMONITE, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.LIMONITE, -10, 0.0F)));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties());
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_LEGGINGS = ITEMS.register("limonite_leggings", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", () -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
	
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = ITEMS.register("polished_rose_quartz", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", () -> {
		return new SwordItem(XOresTiers.ROSE_QUARTZ, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.ROSE_QUARTZ, -2, -2.4F)));
	});
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ROSE_QUARTZ, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.ROSE_QUARTZ, -4, -2.8F)));
	});
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", () -> {
		return new AxeItem(XOresTiers.ROSE_QUARTZ, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.ROSE_QUARTZ, 0.0F, -2.8F)));
	});
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", () -> {
		return new ShovelItem(XOresTiers.ROSE_QUARTZ, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.ROSE_QUARTZ, -3.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", () -> {
		return new HoeItem(XOresTiers.ROSE_QUARTZ, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.ROSE_QUARTZ, -12, 0.0F)));
	});
	
	public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> {
		return new SwordItem(XOresTiers.ENDERITE, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.ENDERITE, -2, -2.2F)));
	});
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = ITEMS.register("enderite_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(22812), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	public static final RegistryObject<BowItem> ENDERITE_BOW = ITEMS.register("enderite_bow", () -> {
		return new BowItem(new Item.Properties().durability(1538));
	});
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(1493));
	});
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ENDERITE, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.ENDERITE, -4, -2.8F)));
	});
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> {
		return new AxeItem(XOresTiers.ENDERITE, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.ENDERITE, 0.0F, -2.6F)));
	});
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> {
		return new ShovelItem(XOresTiers.ENDERITE, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.ENDERITE, -3.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> {
		return new HoeItem(XOresTiers.ENDERITE, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.ENDERITE, -16, 0.0F)));
	});
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> {
		return new EnderiteHelmetItem(XOArmorMaterials.ENDERITE.getHolder().orElseThrow(), new Item.Properties());
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<EnderiteElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate", () -> {
		return new EnderiteElytraChestplateItem(XOArmorMaterials.ENDERITE.getHolder().orElseThrow(), new Item.Properties());
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
	
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> {
		return new SwordItem(XOresTiers.STEEL, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.STEEL, 1, -2.4F)));
	});
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.STEEL, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.STEEL, -1, -2.8F)));
	});
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> {
		return new AxeItem(XOresTiers.STEEL, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.STEEL, 3.0F, -2.8F)));
	});
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> {
		return new ShovelItem(XOresTiers.STEEL, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.STEEL, 0.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> {
		return new HoeItem(XOresTiers.STEEL, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.STEEL, -5, 0.0F)));
	});
	
	public static final RegistryObject<Item> NIGHT_SCRAP = ITEMS.register("night_scrap", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<Item> NIGHT_INGOT = ITEMS.register("night_ingot", () -> {
		return new Item(new Item.Properties());
	});
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", () -> {
		return new SwordItem(XOresTiers.NIGHT, new Item.Properties().attributes(SwordItem.createAttributes(XOresTiers.NIGHT, -2, -2.0F)));
	});
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = ITEMS.register("night_shield", () -> {
		return new XOShieldItem(new Item.Properties().durability(38978), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	public static final RegistryObject<BowItem> NIGHT_BOW = ITEMS.register("night_bow", () -> {
		return new BowItem(new Item.Properties().durability(3245));
	});
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().durability(3185));
	});
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.NIGHT, new Item.Properties().attributes(PickaxeItem.createAttributes(XOresTiers.NIGHT, -4, -2.8F)));
	});
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", () -> {
		return new AxeItem(XOresTiers.NIGHT, new Item.Properties().attributes(AxeItem.createAttributes(XOresTiers.NIGHT, 0.0F, -2.4F)));
	});
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = ITEMS.register("night_shovel", () -> {
		return new ShovelItem(XOresTiers.NIGHT, new Item.Properties().attributes(ShovelItem.createAttributes(XOresTiers.NIGHT, -3.5F, -3.0F)));
	});
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", () -> {
		return new HoeItem(XOresTiers.NIGHT, new Item.Properties().attributes(HoeItem.createAttributes(XOresTiers.NIGHT, -19, 0.0F)));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT.getHolder().orElseThrow(), ArmorItem.Type.HELMET, new Item.Properties());
	});
	public static final RegistryObject<NightArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT.getHolder().orElseThrow(), ArmorItem.Type.CHESTPLATE, new Item.Properties());
	});
	public static final RegistryObject<NightElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = ITEMS.register("night_elytra_chestplate", () -> {
		return new NightElytraChestplateItem(XOArmorMaterials.NIGHT.getHolder().orElseThrow(), new Item.Properties());
	});
	public static final RegistryObject<NightArmorItem> NIGHT_LEGGINGS = ITEMS.register("night_leggings", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT.getHolder().orElseThrow(), ArmorItem.Type.LEGGINGS, new Item.Properties());
	});
	public static final RegistryObject<NightArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", () -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT.getHolder().orElseThrow(), ArmorItem.Type.BOOTS, new Item.Properties());
	});
}
