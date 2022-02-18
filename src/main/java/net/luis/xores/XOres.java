package net.luis.xores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.xores.common.ModCreativeModeTab;
import net.luis.xores.init.MaterialSets;
import net.luis.xores.init.ModBlockItems;
import net.luis.xores.init.ModBlocks;
import net.luis.xores.init.ModGlobalLootModifiers;
import net.luis.xores.init.ModItems;
import net.luis.xores.init.ModMaterialSets;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

/**
 * main mod class, register all {@link DeferredRegister}
 * 
 * @author Luis-st
 */

@Mod(XOres.MOD_ID)
public class XOres {
	
	/**
	 * mod id of the {@link XOres} mod
	 */
	public static final String MOD_ID = "xores";
	
	/**
	 * internal Logger
	 */
	public static final Logger LOGGER = LogManager.getLogger(XOres.class);
	
	/**
	 * {@link CreativeModeTab} for all mod {@link Item}s
	 * 
	 * @see {@link ModItems}
	 * @see {@link ModBlockItems}
	 */
	public static final ModCreativeModeTab XORES_TAB = new ModCreativeModeTab("xores", ModItems.LIMONITE_PICKAXE);
	
	/**
	 * constructor for the {@link XOres}
	 */
	public XOres() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModBlocks.BLOCKS.register(modEventBus);
		ModBlockItems.ITEMS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		MaterialSets.MATERIALS.register(modEventBus);
		ModMaterialSets.MATERIALS.register(modEventBus);	
		ModGlobalLootModifiers.LOOT_MODIFIERS.register(modEventBus);
	}
	
}
