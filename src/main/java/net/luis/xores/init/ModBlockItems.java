package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.material.MaterialSet;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all mod {@link BlockItem}s
 * 
 * @author Luis-st
 */

//TODO: add javadocs to RegistryObjects
public class ModBlockItems {
	
	/**
	 * {@link DeferredRegister} for {@link MaterialSet}, used to register all minecraft {@link MaterialSet}s
	 */
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the jade ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> JADE_ORE = ITEMS.register("jade_ore", () -> {
		return new BlockItem(ModBlocks.JADE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate jade ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_JADE_ORE = ITEMS.register("deepslate_jade_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_JADE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade block {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> JADE_BLOCK = ITEMS.register("jade_block", () -> {
		return new BlockItem(ModBlocks.JADE_BLOCK.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> SAPHIRE_ORE = ITEMS.register("saphire_ore", () -> {
		return new BlockItem(ModBlocks.SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate saphire ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_SAPHIRE_ORE = ITEMS.register("deepslate_saphire_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire block {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> SAPHIRE_BLOCK = ITEMS.register("saphire_block", () -> {
		return new BlockItem(ModBlocks.SAPHIRE_BLOCK.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> LIMONITE_ORE = ITEMS.register("limonite_ore", () -> {
		return new BlockItem(ModBlocks.LIMONITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate limonite ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_LIMONITE_ORE = ITEMS.register("deepslate_limonite_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_LIMONITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite block {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> LIMONITE_BLOCK = ITEMS.register("limonite_block", () -> {
		return new BlockItem(ModBlocks.LIMONITE_BLOCK.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> ROSITE_ORE = ITEMS.register("rosite_ore", () -> {
		return new BlockItem(ModBlocks.ROSITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate rosite ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_ROSITE_ORE = ITEMS.register("deepslate_rosite_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_ROSITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite block {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> ROSITE_BLOCK = ITEMS.register("rosite_block", () -> {
		return new BlockItem(ModBlocks.ROSITE_BLOCK.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite ore {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> ENDERITE_ORE = ITEMS.register("enderite_ore", () -> {
		return new BlockItem(ModBlocks.ENDERITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite block {@link BlockItem}
	 */
	public static final RegistryObject<BlockItem> ENDERITE_BLOCK = ITEMS.register("enderite_block", () -> {
		return new BlockItem(ModBlocks.ENDERITE_BLOCK.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
}
