package net.luis.xores.event.registry;

import net.luis.xores.XOres;
import net.luis.xores.client.renderer.entity.layers.XOElytraLayer;
import net.luis.xores.world.item.XOItems;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnEntityRenderersEvent {
	
	@SubscribeEvent
	public static void addLayers(EntityRenderersEvent.AddLayers event) {
		for (String skin : event.getSkins()) {
			PlayerRenderer playerRenderer = event.getSkin(skin);
			playerRenderer.addLayer(new XOElytraLayer<>(playerRenderer, event.getEntityModels(), XOItems.DIAMOND_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_elytra.png")));
			playerRenderer.addLayer(new XOElytraLayer<>(playerRenderer, event.getEntityModels(), XOItems.NETHERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_elytra.png")));
			playerRenderer.addLayer(new XOElytraLayer<>(playerRenderer, event.getEntityModels(), XOItems.ENDERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_elytra.png")));
			playerRenderer.addLayer(new XOElytraLayer<>(playerRenderer, event.getEntityModels(), XOItems.NIGHT_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_elytra.png")));
		}
		ArmorStandRenderer armorStandRenderer = event.getRenderer(EntityType.ARMOR_STAND);
		armorStandRenderer.addLayer(new XOElytraLayer<>(armorStandRenderer, event.getEntityModels(), XOItems.DIAMOND_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/diamond_elytra.png")));
		armorStandRenderer.addLayer(new XOElytraLayer<>(armorStandRenderer, event.getEntityModels(), XOItems.NETHERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/netherite_elytra.png")));
		armorStandRenderer.addLayer(new XOElytraLayer<>(armorStandRenderer, event.getEntityModels(), XOItems.ENDERITE_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/enderite_elytra.png")));
		armorStandRenderer.addLayer(new XOElytraLayer<>(armorStandRenderer, event.getEntityModels(), XOItems.NIGHT_ELYTRA_CHESTPLATE.get(), new ResourceLocation(XOres.MOD_ID, "textures/entity/night_elytra.png")));
	}
	
}
