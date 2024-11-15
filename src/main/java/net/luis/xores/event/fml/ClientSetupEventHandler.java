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

package net.luis.xores.event.fml;

import net.luis.xores.XOres;
import net.luis.xores.client.gui.overlay.XOArmorOverlay;
import net.luis.xores.client.renderer.item.XOItemProperties;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventHandler {
	
	@SubscribeEvent
	public static void clientSetup(@NotNull FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			for (Item item : XOItems.ITEMS.getEntries().stream().map(RegistryObject::get).toList()) {
				if (item instanceof BowItem bow) {
					XOItemProperties.registerBow(bow);
				} else if (item instanceof CrossbowItem crossbow) {
					XOItemProperties.registerCrossbow(crossbow);
				} else if (item instanceof ShieldItem shield) {
					XOItemProperties.registerShield(shield);
				} else if (item instanceof ElytraChestplateItem elytraChestplate) {
					XOItemProperties.registerElytraChestplate(elytraChestplate);
				}
			}
		});
		Minecraft minecraft = Minecraft.getInstance();
		LayeredDraw layeredDraw = new LayeredDraw();
		layeredDraw.add(new XOArmorOverlay());
		minecraft.gui.layers.add(layeredDraw, () -> !minecraft.options.hideGui);
	}
}
