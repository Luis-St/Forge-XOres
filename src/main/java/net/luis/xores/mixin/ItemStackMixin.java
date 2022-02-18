package net.luis.xores.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.luis.xores.common.fixer.ToolFixer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

/**
 * {@link Mixin} class for {@link ItemStack}
 * 
 * @author Luis-st
 */

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	
	/**
	 * {@link Shadow} field for {@link ItemStack#getItem()}
	 */
	@Shadow
	public abstract Item getItem();
	
	/**
	 * mixin for {@link ItemStack#isCorrectToolForDrops(BlockState)},<br>
	 * changes the tool correct tool check, the custom logic of {@link ToolFixer#isCorrectToolForDrops(Item, ItemStack, BlockState)}<br>
	 * is only called if {@link ToolFixer#isToolRegistered(Item)} and {@link ToolFixer#isBlockRegistered(net.minecraft.world.level.block.Block))}<br>
	 * returns {@code true} else the vanilla logic is called
	 */
	@Inject(method = "isCorrectToolForDrops", at = @At("HEAD"), cancellable = true)
	public void isCorrectToolForDrops(BlockState state, CallbackInfoReturnable<Boolean> info) {
		ToolFixer toolFixer = ToolFixer.INSTANCE;
		if (toolFixer.isToolRegistered(this.getItem()) && toolFixer.isBlockRegistered(state.getBlock())) {
			info.setReturnValue(toolFixer.isCorrectToolForDrops(this.getItem(), (ItemStack) (Object) this, state));
			info.cancel();
		}
	}
	
}
