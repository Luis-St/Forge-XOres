package net.luis.xores.common.fixer;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.eventbus.api.Event;

/**
 * {@link VanillaFixer} defines a class that is used to<br>
 * manipulate vanilla logic via {@link ForgeHooks},<br>
 * {@link Event}s or {@link Mixin}<br>
 * <br>
 * if you want to use this for your own case,<br>
 * implements this interface into your class and do there<br>
 * waht ever you want. Create inside the class a {@code static final}<br>
 * field. This instance should then overwrite the {@link #init()} method.
 * <pre> {@code
 * 	public static final SomeFixer INSTANCE = new SomeFixer() {
 * 		@Override
 * 		public void init() {
 * 			// do your init stuff of the VanillaFixer here
 * 		}
 * 	}
 * } </pre>
 * 
 * @author Luis-st
 */

public interface VanillaFixer {
	
	/**
	 * use to register the stuff of the {@link VanillaFixer}
	 */
	default void init() {
		
	}
	
}
