package net.luis.xores.event.client;

import net.luis.xores.XOres;
import net.luis.xores.client.gui.overlay.XOArmorOverlay;
import net.luis.xores.client.renderer.entity.layers.XOElytraLayer;
import net.luis.xores.world.item.XOItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.gui.overlay.VanillaGuiOverlay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class RegisterClientEventHandler {
	
	@SubscribeEvent
	public static void registerGuiOverlays(@NotNull RegisterGuiOverlaysEvent event) {
		event.registerAbove(VanillaGuiOverlay.ARMOR_LEVEL.id(), "armor_bar", new XOArmorOverlay(Minecraft.getInstance()));
	}
	
	@SubscribeEvent
	public static void addLayers(EntityRenderersEvent.@NotNull AddLayers event) {
		for (String skin : event.getSkins()) {
			if (event.getSkin(skin) instanceof PlayerRenderer renderer) {
				addLayers(renderer, event.getEntityModels());
			}
			
		}
		if (event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer renderer) {
			addLayers(renderer, event.getEntityModels());
		}
	}
	
	private static <T extends LivingEntity, M extends EntityModel<T>> void addLayers(@NotNull LivingEntityRenderer<T, M> renderer, EntityModelSet modelSet) {
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.DIAMOND_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.NETHERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.ENDERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_elytra.png")));
		renderer.addLayer(new XOElytraLayer<>(renderer, modelSet, XOItems.NIGHT_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_elytra.png")));
	}
}
