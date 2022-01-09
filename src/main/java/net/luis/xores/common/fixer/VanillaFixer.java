package net.luis.xores.common.fixer;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.eventbus.api.Event;

/**
 * {@link VanillaFixer} are used to fix things from vanilla,<br>
 * via {@link ForgeHooks}, {@link Event} or {@link Mixin}
 * 
 * @author Luis-st
 */

public interface VanillaFixer {
	
	default void init() {
		
	}
	
}
