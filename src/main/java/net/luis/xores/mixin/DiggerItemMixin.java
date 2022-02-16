package net.luis.xores.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

/**
 * 
 * @author Luis-st
 *
 */

@Mixin(DiggerItem.class)
public abstract class DiggerItemMixin extends TieredItem {
	
	@Deprecated // since this constructor should never be called
	DiggerItemMixin(Tier tier, Properties properties) {
		super(tier, properties);
		throw new UnsupportedOperationException();
	}
	
	@Inject(method = "hurtEnemy", at = @At("HEAD"), cancellable = true)
	public void hurtEnemy(ItemStack stack, LivingEntity targetEntity, LivingEntity attackerEntity, CallbackInfoReturnable<Boolean> info) {
		if (this.asItem() instanceof AxeItem) {
			stack.hurtAndBreak(1, attackerEntity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
			info.setReturnValue(true);
			info.cancel();
		}
	}
	
}