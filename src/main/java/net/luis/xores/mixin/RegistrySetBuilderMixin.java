package net.luis.xores.mixin;

import com.mojang.serialization.Lifecycle;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Luis-St
 *
 */

@Mixin(RegistrySetBuilder.class)
public class RegistrySetBuilderMixin {
	
	private static final Constructor<RegistrySetBuilder.CompositeOwner> COMPOSITE_OWNER = ObfuscationReflectionHelper.findConstructor(RegistrySetBuilder.CompositeOwner.class);
	private static final Constructor<RegistrySetBuilder.LazyHolder> LAZY_HOLDER = ObfuscationReflectionHelper.findConstructor(RegistrySetBuilder.LazyHolder.class, HolderOwner.class, ResourceKey.class);
	
	//region Mixin
	@Shadow
	private static <T> HolderLookup.RegistryLookup<T> lookupFromMap(@NotNull ResourceKey<? extends Registry<? extends T>> key, Lifecycle lifecycle, Map<ResourceKey<T>, Holder.Reference<T>> registry) {
		return null;
	}
	
	@Shadow
	private static HolderLookup.Provider buildProviderWithContext(@NotNull RegistryAccess registry, @NotNull Stream<HolderLookup.RegistryLookup<?>> lookupStream) {
		return null;
	}
	//endregion
	
	private static <T> RegistrySetBuilder.@NotNull CompositeOwner createCompositeOwner() {
		try {
			return COMPOSITE_OWNER.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static <T> RegistrySetBuilder.@NotNull LazyHolder<T> createLazyHolder(@NotNull HolderOwner<T> owner, @NotNull ResourceKey<T> key) {
		try {
			return (RegistrySetBuilder.LazyHolder<T>) LAZY_HOLDER.newInstance(owner, key);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Inject(at = @At("HEAD"), method = "createLazyFullPatchedRegistries", cancellable = true)
	private void createLazyFullPatchedRegistries(@NotNull RegistryAccess registry, @NotNull HolderLookup.Provider original, @NotNull Cloner.Factory factory, @NotNull Map<ResourceKey<? extends Registry<?>>, RegistrySetBuilder.RegistryContents<?>> registryContents, @NotNull HolderLookup.Provider provider, @NotNull CallbackInfoReturnable<HolderLookup.Provider> callback) {
		RegistrySetBuilder.CompositeOwner owner = createCompositeOwner();
		MutableObject<HolderLookup.Provider> mutable = new MutableObject<>();
		List<HolderLookup.RegistryLookup<?>> patchedContents = registryContents.keySet().stream().map((lookup) -> {
			return this.createLazyFullPatchedModdedRegistries(owner, factory, lookup, provider, original, mutable);
		}).peek(owner::add).collect(Collectors.toUnmodifiableList());
		HolderLookup.Provider finalProvider = buildProviderWithContext(registry, patchedContents.stream());
		mutable.setValue(finalProvider);
		callback.setReturnValue(finalProvider);
	}
	
	private <T> HolderLookup.RegistryLookup<T> createLazyFullPatchedModdedRegistries(@NotNull HolderOwner<T> owner, @NotNull Cloner.Factory factory, @NotNull ResourceKey<? extends Registry<? extends T>> key, @NotNull HolderLookup.Provider provider, @NotNull HolderLookup.Provider original, @NotNull MutableObject<HolderLookup.Provider> mutable) {
		Cloner<T> cloner = factory.cloner(key);
		if (cloner == null) {
			throw new NullPointerException("No cloner for " + key.location());
		} else {
			Map<ResourceKey<T>, Holder.Reference<T>> map = new HashMap<>();
			HolderLookup.RegistryLookup<T> providerLookup = provider.lookupOrThrow(key);
			providerLookup.listElements().forEach((registryItem) -> {
				ResourceKey<T> resourceKey = registryItem.key();
				RegistrySetBuilder.LazyHolder<T> lazyHolder = createLazyHolder(owner, resourceKey);
				lazyHolder.supplier = () -> {
					return cloner.clone((T) registryItem.value(), provider, mutable.getValue());
				};
				map.put(resourceKey, lazyHolder);
			});
			Optional<HolderLookup.RegistryLookup<T>> optional = original.lookup(key);
			Lifecycle lifecycle;
			if (optional.isPresent()) {
				HolderLookup.RegistryLookup<T> originalLookup = optional.get();
				originalLookup.listElements().forEach((registryItem) -> {
					ResourceKey<T> resourceKey = registryItem.key();
					map.computeIfAbsent(resourceKey, (value) -> {
						RegistrySetBuilder.LazyHolder<T> holder = createLazyHolder(owner, resourceKey);
						holder.supplier = () -> cloner.clone((T) registryItem.value(), original, mutable.getValue());
						return holder;
					});
				});
				lifecycle = providerLookup.registryLifecycle().add(originalLookup.registryLifecycle());
			} else {
				lifecycle = providerLookup.registryLifecycle();
			}
			return lookupFromMap(key, lifecycle, map);
		}
	}
}
