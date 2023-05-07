package net.luis.xores.data.provider.level;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-st
 *
 */

public class XOLevelProvider {
	
	public static @NotNull RegistrySetBuilder createProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XOPlacedFeatureProvider::create);
		builder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, XOBiomeModifierProvider::create);
		return builder;
	}
}
