package net.luis.xores.init;

import net.luis.xores.XOres;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	
	public static final RegistryObject<BlockItem> JADE_ORE = ITEMS.register("jade_ore", () -> {
		return new BlockItem(ModBlocks.JADE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> DEEPSLATE_JADE_ORE = ITEMS.register("deepslate_jade_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_JADE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> LEMONITE_ORE = ITEMS.register("limonite_ore", () -> {
		return new BlockItem(ModBlocks.LEMONITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> DEEPSLATE_LEMONITE_ORE = ITEMS.register("deepslate_limonite_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_LEMONITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> ROSITE_ORE = ITEMS.register("rosite_ore", () -> {
		return new BlockItem(ModBlocks.ROSITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> DEEPSLATE_ROSITE_ORE = ITEMS.register("deepslate_rosite_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_ROSITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> SAPHIRE_ORE = ITEMS.register("saphire_ore", () -> {
		return new BlockItem(ModBlocks.SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> DEEPSLATE_SAPHIRE_ORE = ITEMS.register("deepslate_saphire_ore", () -> {
		return new BlockItem(ModBlocks.DEEPSLATE_SAPHIRE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	public static final RegistryObject<BlockItem> ENDERITE_ORE = ITEMS.register("enderite_ore", () -> {
		return new BlockItem(ModBlocks.ENDERITE_ORE.get(), new Item.Properties().tab(XOres.XORES_TAB));
	});
	
}
