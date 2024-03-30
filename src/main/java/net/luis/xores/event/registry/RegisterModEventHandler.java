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

package net.luis.xores.event.registry;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOItems;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

/**
 *
 * @author Luis-St
 *
 */

@Mod.EventBusSubscriber(modid = XOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterModEventHandler {
	
	@SubscribeEvent
	public static void buildContents(@NotNull BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.COMBAT) {
			event.accept(XOItems.GOLDEN_SHIELD.get());
			event.accept(XOItems.COPPER_SHIELD.get());
			event.accept(XOItems.IRON_SHIELD.get());
			event.accept(XOItems.DIAMOND_SHIELD.get());
			event.accept(XOItems.NETHERITE_SHIELD.get());
			event.accept(XOItems.DIAMOND_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_BOW.get());
			event.accept(XOItems.NETHERITE_CROSSBOW.get());
		} else if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			event.accept(XOItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get());
			event.accept(XOItems.NIGHT_UPGRADE_SMITHING_TEMPLATE.get());
		}
	}
	
	@SubscribeEvent
	public static void addPackFinders(@NotNull AddPackFindersEvent event) {
		if (event.getPackType() == PackType.SERVER_DATA) {
			addServerPack(event, "xores_rarer_ores", "XOres Rarer Ores");
			addServerPack(event, "xores_very_rare_ores", "XOres Very Rare Ores");
		}
	}
	
	private static void addServerPack(@NotNull AddPackFindersEvent event, @NotNull String packName, @NotNull String displayName) {
		Path resourcePath = ModList.get().getModFileById(XOres.MOD_ID).getFile().findResource(packName);
		PathPackResources.PathResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(resourcePath, false);
		Pack pack = Pack.readMetaAndCreate("builtin/" + packName, Component.literal(displayName), false, resourcesSupplier, PackType.SERVER_DATA, Pack.Position.TOP, PackSource.FEATURE);
		event.addRepositorySource(packConsumer -> packConsumer.accept(pack));
	}
}
