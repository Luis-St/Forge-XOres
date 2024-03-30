/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

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
 * @author Luis-St
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
