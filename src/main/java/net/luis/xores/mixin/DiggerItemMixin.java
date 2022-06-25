package net.luis.xores.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.luis.xores.event.xores.MixinEventInfo;
import net.luis.xores.event.xores.XOresEventFactory;
import net.luis.xores.event.xores.MixinEvent.DiggerItemMixinEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

/**
 * {@link Mixin} class for {@link DiggerItem}
 * 
 * @author Luis-st
 */

@Mixin(DiggerItem.class)
public abstract class DiggerItemMixin extends TieredItem {
	
	/**
	 * @deprecated since this constructor should never be called
	 */
	@Deprecated
	DiggerItemMixin(Tier tier, Properties properties) {
		super(tier, properties);
		throw new UnsupportedOperationException();
	}
	
	/**
	 * mixin for {@link DiggerItem#hurtEnemy(ItemStack, LivingEntity, LivingEntity)},<br>
	 * changes the {@link AxeItem} damage behaviour when hitting an {@link LivingEntity}<br>
	 * in this case the damage value of the {@link AxeItem} will be increased by 1 instead of 2,<br>
	 * the vanilla logic is in this case never called
	 * 
	 * fires the {@link DiggerItemMixinEvent}
	 */
	@Inject(method = "hurtEnemy", at = @At("HEAD"), cancellable = true)
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker, CallbackInfoReturnable<Boolean> info) {
		if (this.asItem() instanceof AxeItem) {
			stack.hurtAndBreak(1, attacker, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
			info.setReturnValue(true);
			info.cancel();
		}
		XOresEventFactory.onDiggerItemMixin(new MixinEventInfo(DiggerItem.class, "hurtEnemy", info.isCancelled()), stack, target, attacker);
	}
	
}
