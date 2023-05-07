package net.luis.xores.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 *
 * @author Luis-st
 *
 */

@Mixin(DiggerItem.class)
public abstract class DiggerItemMixin extends TieredItem {
	
	private DiggerItemMixin(Tier tier, Properties properties) {
		super(tier, properties);
		throw new UnsupportedOperationException();
	}
	
	@Inject(method = "hurtEnemy", at = @At("HEAD"), cancellable = true)
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> info) {
		if (this.asItem() instanceof AxeItem) {
			stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
			info.setReturnValue(true);
			info.cancel();
		}
	}
}
