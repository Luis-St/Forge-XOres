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

package net.luis.xores.event.client;

import net.luis.xores.XOres;
import net.luis.xores.client.renderer.entity.layers.XOElytraLayer;
import net.luis.xores.world.item.XOItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class RegisterClientEventHandler {
	
	/*@SubscribeEvent
	public static void registerGuiOverlays(@NotNull RegisterGuiOverlaysEvent event) {
		event.registerAbove(VanillaGuiOverlay.ARMOR_LEVEL.id(), "armor_bar", new XOArmorOverlay(Minecraft.getInstance()));
	}*/
	
	@SubscribeEvent
	public static void addLayers(EntityRenderersEvent.@NotNull AddLayers event) {
		for (PlayerSkin.Model skin : event.getSkins()) {
			if (event.getPlayerSkin(skin) instanceof PlayerRenderer renderer) {
				addLayers(renderer, event.getEntityModels());
			}
			
		}
		if (event.getEntityRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
			addLayers(renderer, event.getEntityModels());
		}
	}
	
	private static <T extends LivingEntity, M extends EntityModel<T>> void addLayers(@NotNull LivingEntityRenderer<T, M> renderer, EntityModelSet modelSet) {
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.DIAMOND_ELYTRA_CHESTPLATE.get(), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/diamond_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.NETHERITE_ELYTRA_CHESTPLATE.get(), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/netherite_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.ENDERITE_ELYTRA_CHESTPLATE.get(), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/enderite_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.NIGHT_ELYTRA_CHESTPLATE.get(), ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "textures/entity/night_elytra.png")));
	}
}
