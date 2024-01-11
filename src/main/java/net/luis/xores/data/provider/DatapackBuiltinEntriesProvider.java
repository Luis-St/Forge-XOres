package net.luis.xores.data.provider;

import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.*;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DataPackRegistriesHooks;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Luis-St
 *
 */

public class DatapackBuiltinEntriesProvider extends RegistriesDatapackGenerator {
	
	private final CompletableFuture<HolderLookup.Provider> fullRegistries;
	
	public DatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<RegistrySetBuilder.PatchedRegistries> registries, Set<String> modIds) {
		super(output, registries.thenApply(RegistrySetBuilder.PatchedRegistries::patches), modIds);
		this.fullRegistries = registries.thenApply(RegistrySetBuilder.PatchedRegistries::full);
	}
	
	public DatapackBuiltinEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder build, Set<String> modIds) {
		this(output, createLookup(registries, build), modIds);
	}
	
	public @NotNull CompletableFuture<HolderLookup.Provider> getRegistryProvider() {
		return this.fullRegistries;
	}
	
	// Copy code from
	// https://github.com/neoforged/NeoForge/blob/6f06b001accdbbe2df1618d09b2df87df4b8e41f/patches/net/minecraft/core/RegistrySetBuilder.java.patch#L18-L42
	// to RegistrySetBuilder#createLazyFullPatchedRegistries
	
	private static CompletableFuture<RegistrySetBuilder.PatchedRegistries> createLookup(CompletableFuture<HolderLookup.Provider> p_310881_, RegistrySetBuilder p_310262_) {
		return p_310881_.thenApply((p_309945_) -> {
			RegistryAccess.Frozen registryaccess$frozen = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
			Cloner.Factory cloner$factory = new Cloner.Factory();
			/*RegistryDataLoader.WORLDGEN_REGISTRIES.forEach((p_313050_) -> {
				p_313050_.runWithArguments(cloner$factory::addCodec);
			});*/
			DataPackRegistriesHooks.getDataPackRegistriesWithDimensions().forEach((p_313048_) -> {
				p_313048_.runWithArguments(cloner$factory::addCodec);
			});
			RegistrySetBuilder.PatchedRegistries registrysetbuilder$patchedregistries = p_310262_.buildPatch(registryaccess$frozen, p_309945_, cloner$factory);
			HolderLookup.Provider holderlookup$provider = registrysetbuilder$patchedregistries.full();
			Optional<HolderLookup.RegistryLookup<Biome>> optional = holderlookup$provider.lookup(Registries.BIOME);
			Optional<HolderLookup.RegistryLookup<PlacedFeature>> optional1 = holderlookup$provider.lookup(Registries.PLACED_FEATURE);
			if (optional.isPresent() || optional1.isPresent()) {
				VanillaRegistries.validateThatAllBiomeFeaturesHaveBiomeFilter(optional1.orElseGet(() -> {
					return p_309945_.lookupOrThrow(Registries.PLACED_FEATURE);
				}), optional.orElseGet(() -> {
					return p_309945_.lookupOrThrow(Registries.BIOME);
				}));
			}
			
			return registrysetbuilder$patchedregistries;
		});
	}
}