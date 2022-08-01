package net.luis.xores.world.item;

import net.luis.xores.XOres;
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

/**
 * 
 * @author Luis-st
 *
 */

public class XOresItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(180), new ResourceLocation(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(648), new ResourceLocation(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	public static final RegistryObject<ShieldItem> IRON_SHIELD = ITEMS.register("iron_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(1298), new ResourceLocation(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(2531), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(11465), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.DIAMOND, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.NETHERITE, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<BowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(765));
	});
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(714));
	});
	public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> {
		return new SwordItem(XOresTiers.JADE, -1, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.JADE, -3, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> {
		return new AxeItem(XOresTiers.JADE, 3.0F, -3.1F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> {
		return new ShovelItem(XOresTiers.JADE, -2.0F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> {
		return new HoeItem(XOresTiers.JADE, -5, -0.2F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> BLAZING_INGOT = ITEMS.register("blazing_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", () -> {
		return new BlazingSwordItem(XOresTiers.BLAZING, -1, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.BLAZING, -3, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", () -> {
		return new AxeItem(XOresTiers.BLAZING, 2.0F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", () -> {
		return new ShovelItem(XOresTiers.BLAZING, -2.0F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> BLAZING_HOE = ITEMS.register("blazing_hoe", () -> {
		return new HoeItem(XOresTiers.BLAZING, -6, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", () -> {
		return new BlazingArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", () -> {
		return new BlazingArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_LEGGINGS = ITEMS.register("blazing_leggings", () -> {
		return new BlazingArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<BlazingArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", () -> {
		return new BlazingArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> SAPHIRE_INGOT = ITEMS.register("saphire_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", () -> {
		return new SwordItem(XOresTiers.SAPHIRE, -2, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = ITEMS.register("saphire_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(5086), new ResourceLocation(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.SAPHIRE, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", () -> {
		return new AxeItem(XOresTiers.SAPHIRE, 0.0F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", () -> {
		return new ShovelItem(XOresTiers.SAPHIRE, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", () -> {
		return new HoeItem(XOresTiers.SAPHIRE, -8, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", () -> {
		return new SaphireArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", () -> {
		return new SaphireArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_LEGGINGS = ITEMS.register("saphire_leggings", () -> {
		return new SaphireArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SaphireArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", () -> {
		return new SaphireArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> LIMONITE_INGOT = ITEMS.register("limonite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", () -> {
		return new SwordItem(XOresTiers.LIMONITE, -2, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.LIMONITE, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", () -> {
		return new AxeItem(XOresTiers.LIMONITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", () -> {
		return new ShovelItem(XOresTiers.LIMONITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", () -> {
		return new HoeItem(XOresTiers.LIMONITE, -10, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", () -> {
		return new LimoniteArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", () -> {
		return new LimoniteArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_LEGGINGS = ITEMS.register("limonite_leggings", () -> {
		return new LimoniteArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<LimoniteArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", () -> {
		return new LimoniteArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> ROSITE_INGOT = ITEMS.register("rosite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> ROSITE_SWORD = ITEMS.register("rosite_sword", () -> {
		return new SwordItem(XOresTiers.ROSITE, -2, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> ROSITE_PICKAXE = ITEMS.register("rosite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ROSITE, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> ROSITE_AXE = ITEMS.register("rosite_axe", () -> {
		return new AxeItem(XOresTiers.ROSITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> ROSITE_SHOVEL = ITEMS.register("rosite_shovel", () -> {
		return new ShovelItem(XOresTiers.ROSITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> ROSITE_HOE = ITEMS.register("rosite_hoe", () -> {
		return new HoeItem(XOresTiers.ROSITE, -11, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = ITEMS.register("polished_rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", () -> {
		return new SwordItem(XOresTiers.ROSE_QUARTZ, -2, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ROSE_QUARTZ, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", () -> {
		return new AxeItem(XOresTiers.ROSE_QUARTZ, 0.0F, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", () -> {
		return new ShovelItem(XOresTiers.ROSE_QUARTZ, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", () -> {
		return new HoeItem(XOresTiers.ROSE_QUARTZ, -12, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> {
		return new SwordItem(XOresTiers.ENDERITE, -2, -2.2F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = ITEMS.register("enderite_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(22812), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	public static final RegistryObject<BowItem> ENDERITE_BOW = ITEMS.register("enderite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(1538));
	});
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(1493));
	});
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ENDERITE, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> {
		return new AxeItem(XOresTiers.ENDERITE, 0.0F, -2.6F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> {
		return new ShovelItem(XOresTiers.ENDERITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> {
		return new HoeItem(XOresTiers.ENDERITE, -16, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> {
		return new EnderiteHelmetItem(XOresArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> {
		return new EnderiteArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<EnderiteElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate", () -> {
		return new EnderiteElytraChestplateItem(XOresArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> {
		return new EnderiteArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<EnderiteArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> {
		return new EnderiteArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> {
		return new SwordItem(XOresTiers.STEEL, 1, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.STEEL, -1, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> {
		return new AxeItem(XOresTiers.STEEL, 3.0F, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> {
		return new ShovelItem(XOresTiers.STEEL, 0.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> {
		return new HoeItem(XOresTiers.STEEL, -5, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> NIGHT_SCRAP = ITEMS.register("night_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<Item> NIGHT_INGOT = ITEMS.register("night_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", () -> {
		return new SwordItem(XOresTiers.NIGHT, -2, -2.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = ITEMS.register("night_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.TAB).defaultDurability(38978), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	public static final RegistryObject<BowItem> NIGHT_BOW = ITEMS.register("night_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(3245));
	});
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.TAB).defaultDurability(3185));
	});
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.NIGHT, -4, -2.8F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", () -> {
		return new AxeItem(XOresTiers.NIGHT, 0.0F, -2.4F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = ITEMS.register("night_shovel", () -> {
		return new ShovelItem(XOresTiers.NIGHT, -3.5F, -3.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", () -> {
		return new HoeItem(XOresTiers.NIGHT, -19, 0.0F, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", () -> {
		return new NightArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", () -> {
		return new NightArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<NightElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = ITEMS.register("night_elytra_chestplate", () -> {
		return new NightElytraChestplateItem(XOresArmorMaterials.NIGHT, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_LEGGINGS = ITEMS.register("night_leggings", () -> {
		return new NightArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.TAB));
	});
	public static final RegistryObject<NightArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", () -> {
		return new NightArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.FEET, new Item.Properties().tab(XOres.TAB));
	});
	
}
