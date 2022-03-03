package net.luis.xores.common.event;

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
	protected final Class<?> mixinClass;
	
	/**
	 * the method which is modified
	 */
	protected final String method;
	
	/**
	 * the value of {@link CallbackInfo#isCancelled()}
	 */
	protected final boolean canceled;
	
	
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
