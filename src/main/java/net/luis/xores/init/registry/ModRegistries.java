package net.luis.xores.init.registry;

import net.luis.xores.common.material.MaterialSet;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

public class ModRegistries {
	
	public static final IForgeRegistry<MaterialSet> MATERIALS = RegistryManager.ACTIVE.getRegistry(MaterialSet.class);;
	
}
