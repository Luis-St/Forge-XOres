package net.luis.xores.init.registry;

import net.luis.xores.common.material.MaterialSet;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

/**
 * registration class for all mod {@link IForgeRegistry}s
 * 
 * @author Luis-st
 */

public class ModRegistries {
	
	/**
	 * {@link IForgeRegistry} for {@link MaterialSet}
	 */
	public static final IForgeRegistry<MaterialSet> MATERIALS = RegistryManager.ACTIVE.getRegistry(MaterialSet.class);
	
}
