package net.luis.xores;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.luis.xores.world.item.XOresCreativeModeTab;
import net.luis.xores.world.item.XOresItems;
import net.luis.xores.world.level.biome.XOresBiomeModifiers;
import net.luis.xores.world.level.block.XOresBlocks;
import net.luis.xores.world.level.levelgen.feature.XOresOreFeatures;
import net.luis.xores.world.level.levelgen.placement.XOresOrePlacements;
import net.luis.xores.world.level.storage.loot.XOresGlobalLootModifiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * 
 * @author Luis-st
 *
 */
@Mod(XOres.MOD_ID)
public class XOres {
	
	public static final String MOD_ID = "xores";
	public static final String MOD_NAME = "XOres";
	public static final Logger LOGGER = LogManager.getLogger(XOres.class);
	public static final CreativeModeTab TAB = new XOresCreativeModeTab(XOres.MOD_ID, XOresItems.LIMONITE_PICKAXE);
	
	public XOres() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		XOresBlocks.BLOCKS.register(modEventBus);
		XOresBlocks.ITEMS.register(modEventBus);
		XOresItems.ITEMS.register(modEventBus);	
		XOresGlobalLootModifiers.LOOT_MODIFIERS.register(modEventBus);
		XOresOreFeatures.CONFIGURED_FEATURES.register(modEventBus);
		XOresOrePlacements.PLACED_FEATURES.register(modEventBus);
		XOresBiomeModifiers.BIOME_MODIFIERS.register(modEventBus);
	}
	
}
