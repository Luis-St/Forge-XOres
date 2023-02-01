package net.luis.xores.world.level.levelgen.feature;

import java.util.List;
import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOOreFeatures {
	
	public static void register() {
	
	}
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_ORE_UPPER = createKey("jade_ore_upper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> JADE_ORE_MIDDLE = createKey("jade_ore_middle");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAPHIRE_ORE_RARE_UPPER = createKey("saphire_ore_rare_upper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAPHIRE_ORE = createKey("saphire_ore");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SAPHIRE_ORE_BURIED = createKey("saphire_ore_buried");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIMONITE_ORE_BURIED = createKey("limonite_ore_buried");
	public static final ResourceKey<ConfiguredFeature<?, ?>> LIMONITE_ORE_DEEP_BURIED = createKey("limonite_ore_deep_buried");
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERITE_ORE_RARE = createKey("enderite_ore_rare");
	public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERITE_ORE_BURIED = createKey("enderite_ore_buried");
	
	private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(XOres.MOD_ID, name));
	}
	
}
