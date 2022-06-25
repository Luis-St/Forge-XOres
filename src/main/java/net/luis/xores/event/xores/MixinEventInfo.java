package net.luis.xores.event.xores;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * contains informations for a {@link MixinEvent}
 * 
 * @author Luis-st
 * 
 * @see {@link MixinEvent}
 */

public class MixinEventInfo {
	
	/**
	 * the {@link Mixin} {@link Class} which is modified by mixin
	 */
	private final Class<?> mixinClass;
	
	/**
	 * the method which is modified
	 */
	private final String method;
	
	/**
	 * the value of {@link CallbackInfo#isCancelled()}
	 */
	private final boolean canceled;
	
	
	/**
	 * constructor for the {@link MixinEventInfo}
	 */
	public MixinEventInfo(Class<?> mixinClass, String method, boolean canceled) {
		this.mixinClass = mixinClass;
		this.method = method;
		this.canceled = canceled;
	}
	
	/**
	 * getter for the mixin class
	 * @return {@link MixinEventInfo#mixinClass}
	 */
	public Class<?> getMixinClass() {
		return this.mixinClass;
	}
	
	
	/**
	 * getter for the method
	 * @return {@link MixinEventInfo#method}
	 */
	public String getMethod() {
		return this.method;
	}
	
	
	/**
	 * getter for the {@link Boolean} canceled
	 * @return {@link MixinEventInfo#canceled}
	 */
	public boolean isCanceled() {
		return this.canceled;
	}
	
}
