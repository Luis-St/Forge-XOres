package net.luis.xores.event.fml;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.client.render.overlay.ModArmorOverlay;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class OnClientSetupEvent {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		OverlayRegistry.registerOverlayAbove(ForgeIngameGui.ARMOR_LEVEL_ELEMENT, "Armor Bar", new ModArmorOverlay(Minecraft.getInstance())); // register the ArmorBar extension
		event.enqueueWork(() -> { // registration of Item Properties
			for (Item item : ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
				if (item instanceof BowItem bowItem) {
					registerBow(bowItem);
				} else if (item instanceof CrossbowItem crossbowItem) {
					registerCrossbow(crossbowItem);
				} else if (item instanceof ShieldItem shieldItem) {
					registerShield(shieldItem);	
				} else if (item instanceof ElytraChestplateItem elytraChestplateItem) {
					registerElytraChestplate(elytraChestplateItem);
				}
			}
		});
	}
	
	protected static void registerBow(BowItem bowItem) {
		ItemProperties.register(bowItem, new ResourceLocation(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		ItemProperties.register(bowItem, new ResourceLocation(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	protected static void registerCrossbow(CrossbowItem crossbowItem) {
		ItemProperties.register(crossbowItem, new ResourceLocation(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(stack);
			}
		});
		ItemProperties.register(crossbowItem, new ResourceLocation(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbowItem, new ResourceLocation(XOres.MOD_ID, "charged"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbowItem, new ResourceLocation(XOres.MOD_ID, "firework"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
		});
	}
	
	protected static void registerShield(ShieldItem shieldItem) {
		ItemProperties.register(shieldItem, new ResourceLocation(XOres.MOD_ID, "blocking"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	protected static void registerElytraChestplate(ElytraChestplateItem elytraChestplateItem) {
		ItemProperties.register(elytraChestplateItem, new ResourceLocation(XOres.MOD_ID, "broken"), (stack, level, livingEntity, seed) -> {
			return ElytraItem.isFlyEnabled(stack) ? 0.0F : 1.0F;
		});
	}
	
}
