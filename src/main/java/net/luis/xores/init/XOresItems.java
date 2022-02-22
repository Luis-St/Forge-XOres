package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.enums.XOresArmorMaterials;
import net.luis.xores.common.enums.XOresTiers;
import net.luis.xores.common.item.BlazingSwordItem;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.item.EnderiteHelmetItem;
import net.luis.xores.common.item.modded.XOresShieldItem;
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
 * registration class for all XOres {@link Item}s
 * 
 * @author Luis-st
 */

public class XOresItems {
	
	/**
	 * {@link DeferredRegister} for {@link Item}s, used to register all mod {@link Item}s
	 */
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the golden shield
	 */
	public static final RegistryObject<ShieldItem> GOLDEN_SHIELD = ITEMS.register("golden_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(180), new ResourceLocation(XOres.MOD_ID, "textures/entity/golden_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the copper shield
	 */
	public static final RegistryObject<ShieldItem> COPPER_SHIELD = ITEMS.register("copper_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(648), new ResourceLocation(XOres.MOD_ID, "textures/entity/copper_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the iron shield
	 */
	public static final RegistryObject<ShieldItem> IRON_SHIELD = ITEMS.register("iron_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1298), new ResourceLocation(XOres.MOD_ID, "textures/entity/iron_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the diamond shield
	 */
	public static final RegistryObject<ShieldItem> DIAMOND_SHIELD = ITEMS.register("diamond_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(2531), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the netherite shield
	 */
	public static final RegistryObject<ShieldItem> NETHERITE_SHIELD = ITEMS.register("netherite_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(11465), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the diamond elytra chestplate
	 */
	public static final RegistryObject<ElytraChestplateItem> DIAMOND_ELYTRA_CHESTPLATE = ITEMS.register("diamond_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.DIAMOND, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the netherite elytra chestplate
	 */
	public static final RegistryObject<ElytraChestplateItem> NETHERITE_ELYTRA_CHESTPLATE = ITEMS.register("netherite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(ArmorMaterials.NETHERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the netherite bow
	 */
	public static final RegistryObject<BowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(765));
	});
	
	/**
	 * {@link RegistryObject} for the netherite crossbow
	 */
	public static final RegistryObject<CrossbowItem> NETHERITE_CROSSBOW = ITEMS.register("netherite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(714));
	});
	
	/**
	 * {@link RegistryObject} for the jade ingot
	 */
	public static final RegistryObject<Item> JADE_INGOT = ITEMS.register("jade_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade sword
	 */
	public static final RegistryObject<SwordItem> JADE_SWORD = ITEMS.register("jade_sword", () -> {
		return new SwordItem(XOresTiers.JADE, -1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade pickaxe
	 */
	public static final RegistryObject<PickaxeItem> JADE_PICKAXE = ITEMS.register("jade_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.JADE, -3, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade axe
	 */
	public static final RegistryObject<AxeItem> JADE_AXE = ITEMS.register("jade_axe", () -> {
		return new AxeItem(XOresTiers.JADE, 3.0F, -3.1F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade shovel
	 */
	public static final RegistryObject<ShovelItem> JADE_SHOVEL = ITEMS.register("jade_shovel", () -> {
		return new ShovelItem(XOresTiers.JADE, -2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade hoe
	 */
	public static final RegistryObject<HoeItem> JADE_HOE = ITEMS.register("jade_hoe", () -> {
		return new HoeItem(XOresTiers.JADE, -5, -0.2F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade helmet
	 */
	public static final RegistryObject<ArmorItem> JADE_HELMET = ITEMS.register("jade_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade chestplate
	 */
	public static final RegistryObject<ArmorItem> JADE_CHESTPLATE = ITEMS.register("jade_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade leggings
	 */
	public static final RegistryObject<ArmorItem> JADE_LEGGINGS = ITEMS.register("jade_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade boots
	 */
	public static final RegistryObject<ArmorItem> JADE_BOOTS = ITEMS.register("jade_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.JADE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing ingot
	 */
	public static final RegistryObject<Item> BLAZING_INGOT = ITEMS.register("blazing_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing sword
	 */
	public static final RegistryObject<SwordItem> BLAZING_SWORD = ITEMS.register("blazing_sword", () -> {
		return new BlazingSwordItem(XOresTiers.BLAZING, -1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing pickaxe
	 */
	public static final RegistryObject<PickaxeItem> BLAZING_PICKAXE = ITEMS.register("blazing_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.BLAZING, -3, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing axe
	 */
	public static final RegistryObject<AxeItem> BLAZING_AXE = ITEMS.register("blazing_axe", () -> {
		return new AxeItem(XOresTiers.BLAZING, 2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing shovel
	 */
	public static final RegistryObject<ShovelItem> BLAZING_SHOVEL = ITEMS.register("blazing_shovel", () -> {
		return new ShovelItem(XOresTiers.BLAZING, -2.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing hoe
	 */
	public static final RegistryObject<HoeItem> BLAZING_HOE = ITEMS.register("blazing_hoe", () -> {
		return new HoeItem(XOresTiers.BLAZING, -6, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing helmet
	 */
	public static final RegistryObject<ArmorItem> BLAZING_HELMET = ITEMS.register("blazing_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing chestplate
	 */
	public static final RegistryObject<ArmorItem> BLAZING_CHESTPLATE = ITEMS.register("blazing_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing leggings
	 */
	public static final RegistryObject<ArmorItem> BLAZING_LEGGINGS = ITEMS.register("blazing_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the blazing boots
	 */
	public static final RegistryObject<ArmorItem> BLAZING_BOOTS = ITEMS.register("blazing_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.BLAZING, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire ingot
	 */
	public static final RegistryObject<Item> SAPHIRE_INGOT = ITEMS.register("saphire_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire sword
	 */
	public static final RegistryObject<SwordItem> SAPHIRE_SWORD = ITEMS.register("saphire_sword", () -> {
		return new SwordItem(XOresTiers.SAPHIRE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire pickaxe
	 */
	public static final RegistryObject<PickaxeItem> SAPHIRE_PICKAXE = ITEMS.register("saphire_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.SAPHIRE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire axe
	 */
	public static final RegistryObject<AxeItem> SAPHIRE_AXE = ITEMS.register("saphire_axe", () -> {
		return new AxeItem(XOresTiers.SAPHIRE, 0.0F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire shovel
	 */
	public static final RegistryObject<ShovelItem> SAPHIRE_SHOVEL = ITEMS.register("saphire_shovel", () -> {
		return new ShovelItem(XOresTiers.SAPHIRE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire hoe
	 */
	public static final RegistryObject<HoeItem> SAPHIRE_HOE = ITEMS.register("saphire_hoe", () -> {
		return new HoeItem(XOresTiers.SAPHIRE, -8, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire shield
	 */
	public static final RegistryObject<ShieldItem> SAPHIRE_SHIELD = ITEMS.register("saphire_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(5086), new ResourceLocation(XOres.MOD_ID, "textures/entity/saphire_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the saphire helmet
	 */
	public static final RegistryObject<ArmorItem> SAPHIRE_HELMET = ITEMS.register("saphire_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire chestplate
	 */
	public static final RegistryObject<ArmorItem> SAPHIRE_CHESTPLATE = ITEMS.register("saphire_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire leggings
	 */
	public static final RegistryObject<ArmorItem> SAPHIRE_LEGGINGS = ITEMS.register("saphire_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire boots
	 */
	public static final RegistryObject<ArmorItem> SAPHIRE_BOOTS = ITEMS.register("saphire_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.SAPHIRE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite ingot
	 */
	public static final RegistryObject<Item> LIMONITE_INGOT = ITEMS.register("limonite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite sword
	 */
	public static final RegistryObject<SwordItem> LIMONITE_SWORD = ITEMS.register("limonite_sword", () -> {
		return new SwordItem(XOresTiers.LIMONITE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite pickaxe
	 */
	public static final RegistryObject<PickaxeItem> LIMONITE_PICKAXE = ITEMS.register("limonite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.LIMONITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite axe
	 */
	public static final RegistryObject<AxeItem> LIMONITE_AXE = ITEMS.register("limonite_axe", () -> {
		return new AxeItem(XOresTiers.LIMONITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite shovel
	 */
	public static final RegistryObject<ShovelItem> LIMONITE_SHOVEL = ITEMS.register("limonite_shovel", () -> {
		return new ShovelItem(XOresTiers.LIMONITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite hoe
	 */
	public static final RegistryObject<HoeItem> LIMONITE_HOE = ITEMS.register("limonite_hoe", () -> {
		return new HoeItem(XOresTiers.LIMONITE, -10, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite helmet
	 */
	public static final RegistryObject<ArmorItem> LIMONITE_HELMET = ITEMS.register("limonite_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite chestplate
	 */
	public static final RegistryObject<ArmorItem> LIMONITE_CHESTPLATE = ITEMS.register("limonite_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite leggings
	 */
	public static final RegistryObject<ArmorItem> LIMONITE_LEGGINGS = ITEMS.register("limonite_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite boots
	 */
	public static final RegistryObject<ArmorItem> LIMONITE_BOOTS = ITEMS.register("limonite_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.LIMONITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite ingot
	 */
	public static final RegistryObject<Item> ROSITE_INGOT = ITEMS.register("rosite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite sword
	 */
	public static final RegistryObject<SwordItem> ROSITE_SWORD = ITEMS.register("rosite_sword", () -> {
		return new SwordItem(XOresTiers.ROSITE, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite pickaxe
	 */
	public static final RegistryObject<PickaxeItem> ROSITE_PICKAXE = ITEMS.register("rosite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ROSITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite axe
	 */
	public static final RegistryObject<AxeItem> ROSITE_AXE = ITEMS.register("rosite_axe", () -> {
		return new AxeItem(XOresTiers.ROSITE, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite shovel
	 */
	public static final RegistryObject<ShovelItem> ROSITE_SHOVEL = ITEMS.register("rosite_shovel", () -> {
		return new ShovelItem(XOresTiers.ROSITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite hoe
	 */
	public static final RegistryObject<HoeItem> ROSITE_HOE = ITEMS.register("rosite_hoe", () -> {
		return new HoeItem(XOresTiers.ROSITE, -11, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz
	 */
	public static final RegistryObject<Item> ROSE_QUARTZ = ITEMS.register("rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the polished rose quartz
	 */
	public static final RegistryObject<Item> POLISHED_ROSE_QUARTZ = ITEMS.register("polished_rose_quartz", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz sword
	 */
	public static final RegistryObject<SwordItem> ROSE_QUARTZ_SWORD = ITEMS.register("rose_quartz_sword", () -> {
		return new SwordItem(XOresTiers.ROSE_QUARTZ, -2, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz pickaxe
	 */
	public static final RegistryObject<PickaxeItem> ROSE_QUARTZ_PICKAXE = ITEMS.register("rose_quartz_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ROSE_QUARTZ, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz axe
	 */
	public static final RegistryObject<AxeItem> ROSE_QUARTZ_AXE = ITEMS.register("rose_quartz_axe", () -> {
		return new AxeItem(XOresTiers.ROSE_QUARTZ, 0.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz shovel
	 */
	public static final RegistryObject<ShovelItem> ROSE_QUARTZ_SHOVEL = ITEMS.register("rose_quartz_shovel", () -> {
		return new ShovelItem(XOresTiers.ROSE_QUARTZ, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz hoe
	 */
	public static final RegistryObject<HoeItem> ROSE_QUARTZ_HOE = ITEMS.register("rose_quartz_hoe", () -> {
		return new HoeItem(XOresTiers.ROSE_QUARTZ, -12, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite scrap
	 */
	public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite ingot
	 */
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite sword
	 */
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> {
		return new SwordItem(XOresTiers.ENDERITE, -2, -2.2F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite pickaxe
	 */
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.ENDERITE, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite axe
	 */
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> {
		return new AxeItem(XOresTiers.ENDERITE, 0.0F, -2.6F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite shovel
	 */
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> {
		return new ShovelItem(XOresTiers.ENDERITE, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite hoe
	 */
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> {
		return new HoeItem(XOresTiers.ENDERITE, -16, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite bow
	 */
	public static final RegistryObject<BowItem> ENDERITE_BOW = ITEMS.register("enderite_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1538));
	});
	
	/**
	 * {@link RegistryObject} for the enderite crossbow
	 */
	public static final RegistryObject<CrossbowItem> ENDERITE_CROSSBOW = ITEMS.register("enderite_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(1493));
	});
	
	/**
	 * {@link RegistryObject} for the enderite shield
	 */
	public static final RegistryObject<ShieldItem> ENDERITE_SHIELD = ITEMS.register("enderite_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(22812), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the enderite helmet
	 */
	public static final RegistryObject<EnderiteHelmetItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> {
		return new EnderiteHelmetItem(XOresArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite chestplate
	 */
	public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite elytra chestplate
	 */
	public static final RegistryObject<ElytraChestplateItem> ENDERITE_ELYTRA_CHESTPLATE = ITEMS.register("enderite_elytra_chestplate", () -> {
		return new ElytraChestplateItem(XOresArmorMaterials.ENDERITE, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite leggings
	 */
	public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite boots
	 */
	public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.ENDERITE, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});

	/**
	 * {@link RegistryObject} for the steel ingot
	 */
	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the steel sword
	 */
	public static final RegistryObject<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> {
		return new SwordItem(XOresTiers.STEEL, 1, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the steel pickaxe
	 */
	public static final RegistryObject<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.STEEL, -1, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the steel axe
	 */
	public static final RegistryObject<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> {
		return new AxeItem(XOresTiers.STEEL, 3.0F, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the steel shovel
	 */
	public static final RegistryObject<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> {
		return new ShovelItem(XOresTiers.STEEL, 0.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the steel hoe
	 */
	public static final RegistryObject<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> {
		return new HoeItem(XOresTiers.STEEL, -5, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night scrap
	 */
	public static final RegistryObject<Item> NIGHT_SCRAP = ITEMS.register("night_scrap", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night ingot
	 */
	public static final RegistryObject<Item> NIGHT_INGOT = ITEMS.register("night_ingot", () -> {
		return new Item(new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night sword
	 */
	public static final RegistryObject<SwordItem> NIGHT_SWORD = ITEMS.register("night_sword", () -> {
		return new SwordItem(XOresTiers.NIGHT, -2, -2.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night pickaxe
	 */
	public static final RegistryObject<PickaxeItem> NIGHT_PICKAXE = ITEMS.register("night_pickaxe", () -> {
		return new PickaxeItem(XOresTiers.NIGHT, -4, -2.8F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night axe
	 */
	public static final RegistryObject<AxeItem> NIGHT_AXE = ITEMS.register("night_axe", () -> {
		return new AxeItem(XOresTiers.NIGHT, 0.0F, -2.4F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night shovel
	 */
	public static final RegistryObject<ShovelItem> NIGHT_SHOVEL = ITEMS.register("night_shovel", () -> {
		return new ShovelItem(XOresTiers.NIGHT, -3.5F, -3.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night hoe
	 */
	public static final RegistryObject<HoeItem> NIGHT_HOE = ITEMS.register("night_hoe", () -> {
		return new HoeItem(XOresTiers.NIGHT, -19, 0.0F, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night bow
	 */
	public static final RegistryObject<BowItem> NIGHT_BOW = ITEMS.register("night_bow", () -> {
		return new BowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(3245));
	});
	
	/**
	 * {@link RegistryObject} for the night crossbow
	 */
	public static final RegistryObject<CrossbowItem> NIGHT_CROSSBOW = ITEMS.register("night_crossbow", () -> {
		return new CrossbowItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(3185));
	});
	
	/**
	 * {@link RegistryObject} for the night shield
	 */
	public static final RegistryObject<ShieldItem> NIGHT_SHIELD = ITEMS.register("night_shield", () -> {
		return new XOresShieldItem(new Item.Properties().tab(XOres.XORES_TAB).defaultDurability(38978), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_shield.png"));
	});
	
	/**
	 * {@link RegistryObject} for the night helmet
	 */
	public static final RegistryObject<ArmorItem> NIGHT_HELMET = ITEMS.register("night_helmet", () -> {
		return new ArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.HEAD, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night chestplate
	 */
	public static final RegistryObject<ArmorItem> NIGHT_CHESTPLATE = ITEMS.register("night_chestplate", () -> {
		return new ArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.CHEST, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night elytra chestplate
	 */
	public static final RegistryObject<ElytraChestplateItem> NIGHT_ELYTRA_CHESTPLATE = ITEMS.register("night_elytra_chestplate", () -> {
		return new ElytraChestplateItem(XOresArmorMaterials.NIGHT, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night leggings
	 */
	public static final RegistryObject<ArmorItem> NIGHT_LEGGINGS = ITEMS.register("night_leggings", () -> {
		return new ArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.LEGS, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the night boots
	 */
	public static final RegistryObject<ArmorItem> NIGHT_BOOTS = ITEMS.register("night_boots", () -> {
		return new ArmorItem(XOresArmorMaterials.NIGHT, EquipmentSlot.FEET, new Item.Properties().tab(XOres.XORES_TAB));
	});
	
}
