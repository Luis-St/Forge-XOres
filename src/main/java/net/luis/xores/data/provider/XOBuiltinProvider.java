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
	
	public static @NotNull RegistrySetBuilder createRarerVanillaPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XORarerConfiguredFeatureProvider::createVanilla);
		builder.add(Registries.PLACED_FEATURE, XORarerPlacedFeatureProvider::createVanilla);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createRarerXOresPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XORarerConfiguredFeatureProvider::createXOres);
		builder.add(Registries.PLACED_FEATURE, XORarerPlacedFeatureProvider::createXOres);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createVeryRareVanillaPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOVeryRareConfiguredFeatureProvider::createVanilla);
		builder.add(Registries.PLACED_FEATURE, XOVeryRarePlacedFeatureProvider::createVanilla);
		return builder;
	}
	
	public static @NotNull RegistrySetBuilder createVeryRareXOresPackProvider() {
		RegistrySetBuilder builder = new RegistrySetBuilder();
		builder.add(Registries.CONFIGURED_FEATURE, XOVeryRareConfiguredFeatureProvider::createXOres);
		builder.add(Registries.PLACED_FEATURE, XOVeryRarePlacedFeatureProvider::createXOres);
		return builder;
	}
}
