/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

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
