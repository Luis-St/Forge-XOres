package net.luis.xores.client.renderer.item;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

/**
 *
 * @author Luis-St
 *
 */

public class XOItemProperties {
	
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
	
	public static void registerShield(ShieldItem shield) {
		ItemProperties.register(shield, new ResourceLocation(XOres.MOD_ID, "blocking"), (stack, level, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == stack ? 1.0F : 0.0F;
		});
	}
	
	public static void registerElytraChestplate(ElytraChestplateItem elytraChestplate) {
		ItemProperties.register(elytraChestplate, new ResourceLocation(XOres.MOD_ID, "broken"), (stack, level, livingEntity, seed) -> {
			return ElytraItem.isFlyEnabled(stack) ? 0.0F : 1.0F;
		});
	}
}
