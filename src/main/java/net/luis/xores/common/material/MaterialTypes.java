package net.luis.xores.common.material;

import java.util.List;
import java.util.Map;

import org.apache.commons.compress.utils.Lists;

import com.google.common.collect.Maps;

import net.luis.xores.XOres;
import net.minecraft.resources.ResourceLocation;

/**
 * registration class for all mod {@link MaterialType}s
 * 
 * @author Luis-st
 * 
 * @see {@link MaterialSet}
 */

public class MaterialTypes {
	
	/**
	 * {@link List} of all registered {@link MaterialType}s
	 */
	public static final List<MaterialType> TYPES = Lists.newArrayList();
	
	/**
	 * {@link Map} of all registered {@link MaterialType} and thier related names in form of a {@link ResourceLocation}
	 */
	public static final Map<ResourceLocation, MaterialType> NAME_TO_TYPE = Maps.newHashMap();
	
	/**
	 * {@link MaterialType} for the main material, accepts all kinds of {@link Material}
	 */
	public static final MaterialType MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "material"), MaterialType.Type.MATERIAL));
	
	/**
	 * {@link MaterialType} for the part material, accepts all kinds of {@link Material}
	 */
	public static final MaterialType MATERIAL_PART = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "material_part"), MaterialType.Type.MATERIAL));
	
	/**
	 * {@link MaterialType} for the ore material, accepts only {@link Item} material
	 */
	public static final MaterialType ORE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "ore"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the block material, accepts only {@link Item} material
	 */
	public static final MaterialType BLOCK = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "block"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the weapon material, accepts all kinds of {@link Material}
	 */
	public static final MaterialType WEAPON_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "weapon_material"), MaterialType.Type.MATERIAL));
	
	/**
	 * {@link MaterialType} for the sword material, accepts only {@link Item} material
	 */
	public static final MaterialType SWORD = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "sword"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the shield material, accepts only {@link Item} material
	 */
	public static final MaterialType SHIELD = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "shield"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the bow material, accepts only {@link Item} material
	 */
	public static final MaterialType BOW = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "bow"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the crossbow material, accepts only {@link Item} material
	 */
	public static final MaterialType CROSSBOW = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "crossbow"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the tool material, accepts all kinds of {@link Material}
	 */
	public static final MaterialType TOOL_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "tool_material"), MaterialType.Type.MATERIAL));
	
	/**
	 * {@link MaterialType} for the pickaxe material, accepts only {@link Item} material
	 */
	public static final MaterialType PICKAXE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "pickaxe"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the axe material, accepts only {@link Item} material
	 */
	public static final MaterialType AXE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "axe"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the shovel material, accepts only {@link Item} material
	 */
	public static final MaterialType SHOVEL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "shovel"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the hoe material, accepts only {@link Item} material
	 */
	public static final MaterialType HOE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "hoe"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the armor material, accepts all kinds of {@link Material}
	 */
	public static final MaterialType ARMOR_MATERIAL = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "armor_material"), MaterialType.Type.MATERIAL));
	
	/**
	 * {@link MaterialType} for the helmet material, accepts only {@link Item} material
	 */
	public static final MaterialType HELMET = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "helmet"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the chestplate material, accepts only {@link Item} material
	 */
	public static final MaterialType CHESTPLATE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "chestplate"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the elytra chestplate material, accepts only {@link Item} material
	 */
	public static final MaterialType ELYTRA_CHESTPLATE = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "elytra_chestplate"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the leggings material, accepts only {@link Item} material
	 */
	public static final MaterialType LEGGINGS = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "leggings"), MaterialType.Type.ITEM));
	
	/**
	 * {@link MaterialType} for the boots material, accepts only {@link Item} material
	 */
	public static final MaterialType BOOTS = register(new MaterialType(new ResourceLocation(XOres.MOD_ID, "boots"), MaterialType.Type.ITEM));
	
	/**
	 * register the given {@link MaterialType} to {@link MaterialTypes#TYPES} and {@link MaterialTypes#NAME_TO_TYPE}
	 * @param materialType which is to be registered
	 * @return the given {@link MaterialType}
	 */
	protected static MaterialType register(MaterialType materialType) {
		TYPES.add(materialType);
		NAME_TO_TYPE.put(materialType.getName(), materialType);
		return materialType;
	}
	
}
