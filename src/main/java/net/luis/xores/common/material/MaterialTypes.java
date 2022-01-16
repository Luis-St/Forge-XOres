package net.luis.xores.common.material;

import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;

import com.google.common.collect.Maps;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class MaterialTypes {
	
	public static final List<MaterialType> TYPES = Lists.newArrayList();
	public static final Map<ResourceLocation, MaterialType> NAME_TO_TYPE = Maps.newHashMap();
	
	public static final MaterialType MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "material"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType MATERIAL_PART = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "material_part"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType ORE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "ore"), MaterialType.Type.ITEM, MaterialTypes::isBlockItem));
	public static final MaterialType DEEPSLATE_ORE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "deepslate_ore"), MaterialType.Type.ITEM, MaterialTypes::isBlockItem));
	public static final MaterialType BLOCK = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "block"), MaterialType.Type.ITEM, MaterialTypes::isBlockItem));
	public static final MaterialType UPGRADE_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "upgrade_material"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType WEAPON_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "weapon_material"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType SWORD = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "sword"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, SwordItem.class);
	}));
	public static final MaterialType SHIELD = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "shield"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, ShieldItem.class);
	}));
	public static final MaterialType BOW = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "bow"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, BowItem.class);
	}));
	public static final MaterialType CROSSBOW = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "crossbow"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, CrossbowItem.class);
	}));
	public static final MaterialType TOOL_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "tool_material"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType PICKAXE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "pickaxe"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, PickaxeItem.class);
	}));
	public static final MaterialType AXE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "axe"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, AxeItem.class);
	}));
	public static final MaterialType SHOVEL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "shovel"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, ShovelItem.class);
	}));
	public static final MaterialType HOE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "hoe"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, HoeItem.class);
	}));
	public static final MaterialType ARMOR_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "armor_material"), MaterialType.Type.MATERIAL, (material) -> {
		return true;
	}));
	public static final MaterialType HELMET = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "helmet"), MaterialType.Type.ITEM, (material) -> {
		return isArmorItem(material, EquipmentSlot.HEAD);
	}));
	public static final MaterialType CHESTPLATE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "chestplate"), MaterialType.Type.ITEM, (material) -> {
		return isArmorItem(material, EquipmentSlot.CHEST);
	}));
	public static final MaterialType ELYTRA_CHESTPLATE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "elytra_chestplate"), MaterialType.Type.ITEM, (material) -> {
		return isItem(material, ElytraChestplateItem.class);
	}));
	public static final MaterialType LEGGINGS = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "leggings"), MaterialType.Type.ITEM, (material) -> {
		return isArmorItem(material, EquipmentSlot.LEGS);
	}));
	public static final MaterialType BOOTS = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "boots"), MaterialType.Type.ITEM, (material) -> {
		return isArmorItem(material, EquipmentSlot.FEET);
	}));
	
	protected static boolean isBlockItem(Material material) {
		if (material.isItem()) {
			return material.itemOrThrow() instanceof BlockItem;
		}
		return false;
	}
	
	protected static boolean isItem(Material material, Class<? extends Item> clazz) {
		if (material.isItem()) {
			return clazz.isInstance(material.itemOrThrow());
		}
		return false;
	}
	
	protected static boolean isArmorItem(Material material, EquipmentSlot slot) {
		if (material.isItem()) {
			if (material.itemOrThrow() instanceof ArmorItem armorItem) {
				return armorItem.getSlot() == slot;
			}
		}
		return false;
	}
	
	protected static MaterialType register(MaterialType materialType) {
		TYPES.add(materialType);
		NAME_TO_TYPE.put(materialType.getName(), materialType);
		return materialType;
	}
	
}
