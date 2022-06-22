package net.luis.xores.init.block;

import net.luis.xores.XOres;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all XOres {@link BlockItem}s
 * 
 * @author Luis-st
 */

public class XOresBlockItems {
	
	/**
	 * {@link DeferredRegister} for {@link Item}s, used to register all mod {@link BlockItem}s
	 */
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the jade ore
	 */
	public static final RegistryObject<BlockItem> JADE_ORE = ITEMS.register("jade_ore", () -> {
		return new BlockItem(XOresBlocks.JADE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate jade ore
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_JADE_ORE = ITEMS.register("deepslate_jade_ore", () -> {
		return new BlockItem(XOresBlocks.DEEPSLATE_JADE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the jade block
	 */
	public static final RegistryObject<BlockItem> JADE_BLOCK = ITEMS.register("jade_block", () -> {
		return new BlockItem(XOresBlocks.JADE_BLOCK.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire ore
	 */
	public static final RegistryObject<BlockItem> SAPHIRE_ORE = ITEMS.register("saphire_ore", () -> {
		return new BlockItem(XOresBlocks.SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate saphire ore
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_SAPHIRE_ORE = ITEMS.register("deepslate_saphire_ore", () -> {
		return new BlockItem(XOresBlocks.DEEPSLATE_SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the saphire block
	 */
	public static final RegistryObject<BlockItem> SAPHIRE_BLOCK = ITEMS.register("saphire_block", () -> {
		return new BlockItem(XOresBlocks.SAPHIRE_BLOCK.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite ore
	 */
	public static final RegistryObject<BlockItem> LIMONITE_ORE = ITEMS.register("limonite_ore", () -> {
		return new BlockItem(XOresBlocks.LIMONITE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate limonite ore
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_LIMONITE_ORE = ITEMS.register("deepslate_limonite_ore", () -> {
		return new BlockItem(XOresBlocks.DEEPSLATE_LIMONITE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the limonite block
	 */
	public static final RegistryObject<BlockItem> LIMONITE_BLOCK = ITEMS.register("limonite_block", () -> {
		return new BlockItem(XOresBlocks.LIMONITE_BLOCK.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite ore
	 */
	public static final RegistryObject<BlockItem> ROSITE_ORE = ITEMS.register("rosite_ore", () -> {
		return new BlockItem(XOresBlocks.ROSITE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the deepslate rosite ore
	 */
	public static final RegistryObject<BlockItem> DEEPSLATE_ROSITE_ORE = ITEMS.register("deepslate_rosite_ore", () -> {
		return new BlockItem(XOresBlocks.DEEPSLATE_ROSITE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the rosite block
	 */
	public static final RegistryObject<BlockItem> ROSITE_BLOCK = ITEMS.register("rosite_block", () -> {
		return new BlockItem(XOresBlocks.ROSITE_BLOCK.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite ore
	 */
	public static final RegistryObject<BlockItem> ENDERITE_ORE = ITEMS.register("enderite_ore", () -> {
		return new BlockItem(XOresBlocks.ENDERITE_ORE.get(), new Item.Properties().tab(XOres.TAB));
	});
	
	/**
	 * {@link RegistryObject} for the enderite block
	 */
	public static final RegistryObject<BlockItem> ENDERITE_BLOCK = ITEMS.register("enderite_block", () -> {
		return new BlockItem(XOresBlocks.ENDERITE_BLOCK.get(), new Item.Properties().tab(XOres.TAB));
	});
	
}
