package net.luis.xores.client.render.item;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShieldItem;

/**
 * helper class for {@link ItemProperties},<br>
 * contains all methods which are used to register<br>
 * the {@link ItemProperties} for the mod {@link Item}s
 * 
 * @author Luis-st
 */

public class ModItemProperties {
	
	/**
	 * register the {@link ItemProperties} for a {@link BowItem}
	 */
	public static void registerBow(BowItem bow) {
		ItemProperties.register(bow, new ResourceLocation(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getUseItem() != stack ? 0.0F : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		ItemProperties.register(bow, new ResourceLocation(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	/**
	 * register the {@link ItemProperties} for a {@link CrossbowItem}
	 */
	public static void registerCrossbow(CrossbowItem crossbow) {
		ItemProperties.register(crossbow, new ResourceLocation(XOres.MOD_ID, "pull"), (stack, level, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return CrossbowItem.isCharged(stack) ? 0.0F : (float) (stack.getUseDuration() - livingEntity.getUseItemRemainingTicks()) / (float) CrossbowItem.getChargeDuration(stack);
			}
		});
		ItemProperties.register(crossbow, new ResourceLocation(XOres.MOD_ID, "pulling"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbow, new ResourceLocation(XOres.MOD_ID, "charged"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F;
		});
		ItemProperties.register(crossbow, new ResourceLocation(XOres.MOD_ID, "firework"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && CrossbowItem.isCharged(stack) && CrossbowItem.containsChargedProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
		});
	}
	
	/**
	 * register the {@link ItemProperties} for a {@link ShieldItem}
	 */
	public static void registerShield(ShieldItem shield) {
		ItemProperties.register(shield, new ResourceLocation(XOres.MOD_ID, "blocking"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	/**
	 * register the {@link ItemProperties} for a {@link ElytraChestplateItem}
	 */
	public static void registerElytraChestplate(ElytraChestplateItem elytraChestplate) {
		ItemProperties.register(elytraChestplate, new ResourceLocation(XOres.MOD_ID, "broken"), (stack, level, livingEntity, seed) -> {
			return ElytraItem.isFlyEnabled(stack) ? 0.0F : 1.0F;
		});
	}
	
}
