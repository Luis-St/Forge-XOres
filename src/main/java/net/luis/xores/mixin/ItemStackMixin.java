package net.luis.xores.mixin;

import net.luis.xores.world.fixer.ToolFixer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 *
 * @author Luis-st
 *
 */

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	
	@Shadow
	public abstract Item getItem();
	
	@Inject(method = "isCorrectToolForDrops", at = @At("HEAD"), cancellable = true)
	public void isCorrectToolForDrops(BlockState state, CallbackInfoReturnable<Boolean> info) {
		ToolFixer toolFixer = ToolFixer.INSTANCE;
		ItemStack stack = (ItemStack) (Object) this;
		if (toolFixer.isToolRegistered(this.getItem()) && toolFixer.isBlockRegistered(state.getBlock())) {
			info.setReturnValue(toolFixer.isCorrectToolForDrops(this.getItem(), stack, state));
			info.cancel();
		}
	}
}
