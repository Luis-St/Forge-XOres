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

import java.util.function.Function;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<SmithingTemplateItem> ENDERITE_UPGRADE_SMITHING_TEMPLATE = register("enderite_upgrade_smithing_template", (properties) -> {
		return new XSSmithingTemplateItem(properties, XSSmithingTemplateItem.TemplateType.ENDERITE);
	});
	public static final RegistryObject<SmithingTemplateItem> NIGHT_UPGRADE_SMITHING_TEMPLATE = register("night_upgrade_smithing_template", (properties) -> {
		return new XSSmithingTemplateItem(properties, XSSmithingTemplateItem.TemplateType.NIGHT);
	});
	
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = register("golden_shield", (properties) -> {
		return new XOShieldItem(properties.durability(180), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = register("copper_shield", (properties) -> {
		return new XOShieldItem(properties.durability(648), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	public static final RegistryObject<ShieldItem> IRON_SHIELD = register("iron_shield", (properties) -> {
		return new XOShieldItem(properties.durability(1298), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = register("diamond_shield", (properties) -> {
		return new XOShieldItem(properties.durability(2531), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = register("netherite_shield", (properties) -> {
		return new XOShieldItem(properties.durability(11465), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = register("diamond_elytra_chestplate", (properties) -> {
		return new ElytraChestplateItem(XOArmorMaterials.DIAMOND_WINGS, properties);
	});
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = register("netherite_elytra_chestplate", (properties) -> {
		return new ElytraChestplateItem(XOArmorMaterials.NETHERITE_WINGS, properties);
	});
	public static final RegistryObject<BowItem> NETHERITE_BOW = register("netherite_bow", (properties) -> {
		return new BowItem(properties.durability(765));
	});
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = register("netherite_crossbow", (properties) -> {
		return new CrossbowItem(properties.durability(714));
	});
	
	public static final RegistryObject<Item> JADE_INGOT = register("jade_ingot", Item::new);
	public static final RegistryObject<SwordItem> JADE_SWORD = register("jade_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.JADE, 3.0F, -2.4F, properties);
	});
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = register("jade_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.JADE, -3, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> JADE_AXE = register("jade_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.JADE, 3.0F, -3.1F, properties);
	});
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = register("jade_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.JADE, -2.0F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> JADE_HOE = register("jade_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.JADE, -5, -0.2F, properties);
	});
	public static final RegistryObject<ArmorItem> JADE_HELMET = register("jade_helmet", (properties) -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.HELMET, properties);
	});
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = register("jade_chestplate", (properties) -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = register("jade_leggings", (properties) -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<ArmorItem> JADE_BOOTS = register("jade_boots", (properties) -> {
		return new ArmorItem(XOArmorMaterials.JADE, ArmorType.BOOTS, properties);
	});
	
	public static final RegistryObject<Item> BLAZING_INGOT = register("blazing_ingot", Item::new);
	public static final RegistryObject<SwordItem> BLAZING_SWORD = register("blazing_sword", (properties) -> {
		return new BlazingSwordItem(XOToolMaterials.BLAZING, 3.0F, -2.4F, properties);
	});
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = register("blazing_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.BLAZING, -3, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> BLAZING_AXE = register("blazing_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.BLAZING, 2.0F, -3.0F, properties);
	});
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = register("blazing_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.BLAZING, -2.0F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> BLAZING_HOE = register("blazing_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.BLAZING, -6, 0.0F, properties);
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_HELMET = register("blazing_helmet", (properties) -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.HELMET, properties);
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_CHESTPLATE = register("blazing_chestplate", (properties) -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_LEGGINGS = register("blazing_leggings", (properties) -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_BOOTS = register("blazing_boots", (properties) -> {
		return new BlazingArmorItem(XOArmorMaterials.BLAZING, ArmorType.BOOTS, properties);
	});
	
	public static final RegistryObject<Item> SAPHIRE_INGOT = register("saphire_ingot", Item::new);
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = register("saphire_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.SAPHIRE, -2, -2.4F, properties);
	});
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = register("saphire_shield", (properties) -> {
		return new XOShieldItem(properties.durability(5086), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = register("saphire_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.SAPHIRE, -4, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = register("saphire_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.SAPHIRE, 0.0F, -3.0F, properties);
	});
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = register("saphire_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.SAPHIRE, -3.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = register("saphire_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.SAPHIRE, -8, 0.0F, properties);
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_HELMET = register("saphire_helmet", (properties) -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.HELMET, properties);
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_CHESTPLATE = register("saphire_chestplate", (properties) -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_LEGGINGS = register("saphire_leggings", (properties) -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_BOOTS = register("saphire_boots", (properties) -> {
		return new SaphireArmorItem(XOArmorMaterials.SAPHIRE, ArmorType.BOOTS, properties);
	});
	
	public static final RegistryObject<Item> LIMONITE_INGOT = register("limonite_ingot", Item::new);
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = register("limonite_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.LIMONITE, -2, -2.4F, properties);
	});
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = register("limonite_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.LIMONITE, -4, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> LIMONITE_AXE = register("limonite_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.LIMONITE, 0.0F, -2.8F, properties);
	});
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = register("limonite_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.LIMONITE, -3.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> LIMONITE_HOE = register("limonite_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.LIMONITE, -10, 0.0F, properties);
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_HELMET = register("limonite_helmet", (properties) -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.HELMET, properties);
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_CHESTPLATE = register("limonite_chestplate", (properties) -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_LEGGINGS = register("limonite_leggings", (properties) -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_BOOTS = register("limonite_boots", (properties) -> {
		return new LimoniteArmorItem(XOArmorMaterials.LIMONITE, ArmorType.BOOTS, properties);
	});
	
	public static final RegistryObject<Item> ROSE_QUARTZ = register("rose_quartz", Item::new);
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = register("polished_rose_quartz", Item::new);
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = register("rose_quartz_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.ROSE_QUARTZ, -2, -2.4F, properties);
	});
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = register("rose_quartz_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.ROSE_QUARTZ, -4, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = register("rose_quartz_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.ROSE_QUARTZ, 0.0F, -2.8F, properties);
	});
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = register("rose_quartz_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.ROSE_QUARTZ, -3.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = register("rose_quartz_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.ROSE_QUARTZ, -12, 0.0F, properties);
	});
	
	public static final RegistryObject<Item> ENDERITE_SCRAP = register("enderite_scrap", Item::new);
	public static final RegistryObject<Item> ENDERITE_INGOT = register("enderite_ingot", Item::new);
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = register("enderite_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.ENDERITE, -2, -2.2F, properties);
	});
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = register("enderite_shield", (properties) -> {
		return new XOShieldItem(properties.durability(22812), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	public static final RegistryObject<BowItem> ENDERITE_BOW = register("enderite_bow", (properties) -> {
		return new BowItem(properties.durability(1538));
	});
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = register("enderite_crossbow", (properties) -> {
		return new CrossbowItem(properties.durability(1493));
	});
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = register("enderite_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.ENDERITE, -4, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> ENDERITE_AXE = register("enderite_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.ENDERITE, 0.0F, -2.6F, properties);
	});
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = register("enderite_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.ENDERITE, -3.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> ENDERITE_HOE = register("enderite_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.ENDERITE, -16, 0.0F, properties);
	});
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = register("enderite_helmet", (properties) -> {
		return new EnderiteHelmetItem(XOArmorMaterials.ENDERITE, properties);
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_CHESTPLATE = register("enderite_chestplate", (properties) -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<EnderiteElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = register("enderite_elytra_chestplate", (properties) -> {
		return new EnderiteElytraChestplateItem(XOArmorMaterials.ENDERITE_WINGS, properties);
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_LEGGINGS = register("enderite_leggings", (properties) -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_BOOTS = register("enderite_boots", (properties) -> {
		return new EnderiteArmorItem(XOArmorMaterials.ENDERITE, ArmorType.BOOTS, properties);
	});
	
	public static final RegistryObject<Item> STEEL_INGOT = register("steel_ingot", Item::new);
	public static final RegistryObject<SwordItem> STEEL_SWORD = register("steel_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.STEEL, 1, -2.4F, properties);
	});
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = register("steel_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.STEEL, -1, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> STEEL_AXE = register("steel_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.STEEL, 3.0F, -2.8F, properties);
	});
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = register("steel_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.STEEL, 0.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> STEEL_HOE = register("steel_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.STEEL, -5, 0.0F, properties);
	});
	
	public static final RegistryObject<Item> NIGHT_SCRAP = register("night_scrap", Item::new);
	public static final RegistryObject<Item> NIGHT_INGOT = register("night_ingot", Item::new);
	public static final RegistryObject<SwordItem> NIGHT_SWORD = register("night_sword", (properties) -> {
		return new SwordItem(XOToolMaterials.NIGHT, -2, -2.0F, properties);
	});
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = register("night_shield", (properties) -> {
		return new XOShieldItem(properties.durability(38978), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	public static final RegistryObject<BowItem> NIGHT_BOW = register("night_bow", (properties) -> {
		return new BowItem(properties.durability(3245));
	});
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = register("night_crossbow", (properties) -> {
		return new CrossbowItem(properties.durability(3185));
	});
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = register("night_pickaxe", (properties) -> {
		return new PickaxeItem(XOToolMaterials.NIGHT, -4, -2.8F, properties);
	});
	public static final RegistryObject<AxeItem> NIGHT_AXE = register("night_axe", (properties) -> {
		return new AxeItem(XOToolMaterials.NIGHT, 0.0F, -2.4F, properties);
	});
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = register("night_shovel", (properties) -> {
		return new ShovelItem(XOToolMaterials.NIGHT, -3.5F, -3.0F, properties);
	});
	public static final RegistryObject<HoeItem> NIGHT_HOE = register("night_hoe", (properties) -> {
		return new HoeItem(XOToolMaterials.NIGHT, -19, 0.0F, properties);
	});
	public static final RegistryObject<NightArmorItem> NIGHT_HELMET = register("night_helmet", (properties) -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.HELMET, properties);
	});
	public static final RegistryObject<NightArmorItem> NIGHT_CHESTPLATE = register("night_chestplate", (properties) -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.CHESTPLATE, properties);
	});
	public static final RegistryObject<NightElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = register("night_elytra_chestplate", (properties) -> {
		return new NightElytraChestplateItem(XOArmorMaterials.NIGHT_WINGS, properties);
	});
	public static final RegistryObject<NightArmorItem> NIGHT_LEGGINGS = register("night_leggings", (properties) -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.LEGGINGS, properties);
	});
	public static final RegistryObject<NightArmorItem> NIGHT_BOOTS = register("night_boots", (properties) -> {
		return new NightArmorItem(XOArmorMaterials.NIGHT, ArmorType.BOOTS, properties);
	});
	
	private static <T extends Item> @NotNull RegistryObject<T> register(@NotNull String name, @NotNull Function<Item.Properties, T> item) {
		return register(name, new Item.Properties(), item);
	}
	
	private static <T extends Item> @NotNull RegistryObject<T> register(@NotNull String name, Item.@NotNull Properties properties, @NotNull Function<Item.Properties, T> item) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, name));
		return ITEMS.register(name, () -> item.apply(properties.setId(key)));
	}
}
