package net.luis.xores.data.provider;

import net.luis.xores.data.provider.level.*;
import net.luis.xores.data.provider.level.rarer.XORarerConfiguredFeatureProvider;
import net.luis.xores.data.provider.level.rarer.XORarerPlacedFeatureProvider;
import net.luis.xores.data.provider.level.very.XOVeryRareConfiguredFeatureProvider;
import net.luis.xores.data.provider.level.very.XOVeryRarePlacedFeatureProvider;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOBuiltinProvider {
	
	public static @NotNull RegistrySetBuilder createProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XOPlacedFeatureProvider::create);
		builder.add(ForgeRegistries.Keys.BIOME_MODIFIERS, XOBiomeModifierProvider::create);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createRarerPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XORarerConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XORarerPlacedFeatureProvider::create);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createVeryRarePackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOVeryRareConfiguredFeatureProvider::create);
		builder.add(Registries.PLACED_FEATURE, XOVeryRarePlacedFeatureProvider::create);
		return builder;
	}
}
