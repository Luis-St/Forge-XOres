package net.luis.xores;

import net.luis.xores.world.item.XOCreativeModeTabs;
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.biome.XOBiomeModifiers;
import net.luis.xores.world.level.block.XOBlocks;
import net.luis.xores.world.level.levelgen.feature.XOOreFeatures;
import net.luis.xores.world.level.levelgen.placement.XOOrePlacements;
import net.luis.xores.world.level.storage.loot.XOGlobalLootModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Luis-St
 *
 */

@Mod(XOres.MOD_ID)
public class XOres {
	
	public static final String MOD_ID = "xores";
	public static final String MOD_NAME = "XOres";
	public static final Logger LOGGER = LogManager.getLogger(XOres.class);
	
	public XOres() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		XOBlocks.BLOCKS.register(modEventBus);
		XOBlocks.ITEMS.register(modEventBus);
		XOItems.ITEMS.register(modEventBus);
		XOCreativeModeTabs.TABS.register(modEventBus);
		XOGlobalLootModifiers.LOOT_MODIFIERS.register(modEventBus);
		XOOreFeatures.register();
		XOOrePlacements.register();
		XOBiomeModifiers.BIOME_MODIFIERS.register(modEventBus);
	}
}
