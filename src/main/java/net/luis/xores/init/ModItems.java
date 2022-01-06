package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.enums.ModArmorMaterials;
import net.luis.xores.common.enums.ModTiers;
import net.luis.xores.common.item.BlazingSwordItem;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.item.EnderiteHelmetItem;
import net.luis.xores.common.item.modded.ModAxeItem;
import net.luis.xores.common.item.modded.ModHoeItem;
import net.luis.xores.common.item.modded.ModPickaxeItem;
import net.luis.xores.common.item.modded.ModShieldItem;
import net.luis.xores.common.item.modded.ModShovelItem;
import net.luis.xores.common.item.modded.ModSwordItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(180), new ResourceLocation(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(648), new ResourceLocation(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	public static final RegistryObject<ShieldItem> IRON_SHIELD = ITEMS.register("iron_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1298), new ResourceLocation(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(2531), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(11465), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.DIAMOND, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.NETHERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(765));
	});
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(714));
	});
	
	public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> {
		return new ModSwordItem(ModTiers.JADE, -1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.JADE, -3, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> {
		return new ModAxeItem(ModTiers.JADE, 3.0F, -3.1F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> {
		return new ModShovelItem(ModTiers.JADE, -2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> {
		return new ModHoeItem(ModTiers.JADE, -5, -0.2F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> {
		return new ArmorItem(ModArmorMaterials.JADE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.JADE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.JADE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> {
		return new ArmorItem(ModArmorMaterials.JADE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> BLAZING_INGOT = ITEMS.register("blazing_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", () -> {
		return new BlazingSwordItem(ModTiers.BLAZING, -1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.BLAZING, -3, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", () -> {
		return new ModAxeItem(ModTiers.BLAZING, 2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", () -> {
		return new ModShovelItem(ModTiers.BLAZING, -2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> BLAZING_HOE = ITEMS.register("blazing_hoe", () -> {
		return new ModHoeItem(ModTiers.BLAZING, -6, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", () -> {
		return new ArmorItem(ModArmorMaterials.BLAZING, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.BLAZING, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> BLAZING_LEGGINGS = ITEMS.register("blazing_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.BLAZING, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", () -> {
		return new ArmorItem(ModArmorMaterials.BLAZING, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> SAPHIRE_INGOT = ITEMS.register("saphire_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", () -> {
		return new ModSwordItem(ModTiers.SAPHIRE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.SAPHIRE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", () -> {
		return new ModAxeItem(ModTiers.SAPHIRE, 0.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", () -> {
		return new ModShovelItem(ModTiers.SAPHIRE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", () -> {
		return new ModHoeItem(ModTiers.SAPHIRE, -8, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = ITEMS.register("saphire_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(5086), new ResourceLocation(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	public static final RegistryObject<ArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", () -> {
		return new ArmorItem(ModArmorMaterials.SAPHIRE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.SAPHIRE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> SAPHIRE_LEGGINGS = ITEMS.register("saphire_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.SAPHIRE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", () -> {
		return new ArmorItem(ModArmorMaterials.SAPHIRE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> LIMONITE_INGOT = ITEMS.register("limonite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", () -> {
		return new ModSwordItem(ModTiers.LIMONITE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.LIMONITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", () -> {
		return new ModAxeItem(ModTiers.LIMONITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", () -> {
		return new ModShovelItem(ModTiers.LIMONITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", () -> {
		return new ModHoeItem(ModTiers.LIMONITE, -10, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", () -> {
		return new ArmorItem(ModArmorMaterials.LIMONITE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.LIMONITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> LIMONITE_LEGGINGS = ITEMS.register("limonite_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.LIMONITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", () -> {
		return new ArmorItem(ModArmorMaterials.LIMONITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> ROSITE_INGOT = ITEMS.register("rosite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> ROSITE_SWORD = ITEMS.register("rosite_sword", () -> {
		return new ModSwordItem(ModTiers.ROSITE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> ROSITE_PICKAXE = ITEMS.register("rosite_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.ROSITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> ROSITE_AXE = ITEMS.register("rosite_axe", () -> {
		return new ModAxeItem(ModTiers.ROSITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> ROSITE_SHOVEL = ITEMS.register("rosite_shovel", () -> {
		return new ModShovelItem(ModTiers.ROSITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> ROSITE_HOE = ITEMS.register("rosite_hoe", () -> {
		return new ModHoeItem(ModTiers.ROSITE, -11, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = ITEMS.register("polished_rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", () -> {
		return new ModSwordItem(ModTiers.ROSE_QUARTZ, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.ROSE_QUARTZ, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", () -> {
		return new ModAxeItem(ModTiers.ROSE_QUARTZ, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", () -> {
		return new ModShovelItem(ModTiers.ROSE_QUARTZ, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", () -> {
		return new ModHoeItem(ModTiers.ROSE_QUARTZ, -12, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> {
		return new ModSwordItem(ModTiers.ENDERITE, -2, -2.2F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.ENDERITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> {
		return new ModAxeItem(ModTiers.ENDERITE, 0.0F, -2.6F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> {
		return new ModShovelItem(ModTiers.ENDERITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> {
		return new ModHoeItem(ModTiers.ENDERITE, -16, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BowItem> ENDERITE_BOW = ITEMS.register("enderite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1538));
	});
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1493));
	});
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = ITEMS.register("enderite_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(22812), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> {
		return new EnderiteHelmetItem(ModArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ModArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> {
		return new ArmorItem(ModArmorMaterials.ENDERITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});

	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> {
		return new ModSwordItem(ModTiers.STEEL, 1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.STEEL, -1, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> {
		return new ModAxeItem(ModTiers.STEEL, 3.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> {
		return new ModShovelItem(ModTiers.STEEL, 0.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> {
		return new ModHoeItem(ModTiers.STEEL, -5, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	public static final RegistryObject<Item> NIGHT_SCRAP = ITEMS.register("night_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<Item> NIGHT_INGOT = ITEMS.register("night_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", () -> {
		return new ModSwordItem(ModTiers.NIGHT, -2, -2.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", () -> {
		return new ModPickaxeItem(ModTiers.NIGHT, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", () -> {
		return new ModAxeItem(ModTiers.NIGHT, 0.0F, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = ITEMS.register("night_shovel", () -> {
		return new ModShovelItem(ModTiers.NIGHT, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", () -> {
		return new ModHoeItem(ModTiers.NIGHT, -19, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BowItem> NIGHT_BOW = ITEMS.register("night_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(3245));
	});
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(3185));
	});
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = ITEMS.register("night_shield", () -> {
		return new ModShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(38978), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	public static final RegistryObject<ArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", () -> {
		return new ArmorItem(ModArmorMaterials.NIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", () -> {
		return new ArmorItem(ModArmorMaterials.NIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = ITEMS.register("night_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ModArmorMaterials.NIGHT, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> NIGHT_LEGGINGS = ITEMS.register("night_leggings", () -> {
		return new ArmorItem(ModArmorMaterials.NIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<ArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", () -> {
		return new ArmorItem(ModArmorMaterials.NIGHT, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
}
