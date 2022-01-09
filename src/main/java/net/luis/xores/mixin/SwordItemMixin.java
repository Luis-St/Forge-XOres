package net.luis.xores.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

/**
 * 
 * @author Luis-st
 *
 */

@Mixin(SwordItem.class)
public abstract class SwordItemMixin {
	
	/**
	 * changes the behavior of {@link SwordItem} when the Item is used as a tool,
	 * the damage value in this case is only increased by 1 instead of 2
	 */
	@Inject(method = "mineBlock", at = @At("HEAD"), cancellable = true)
	public void mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity, CallbackInfoReturnable<Boolean> info) {
		if (state.getDestroySpeed(level, pos) != 0.0F) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		}
		info.setReturnValue(true);
		info.cancel();
	}

}
