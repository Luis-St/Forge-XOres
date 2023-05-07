package net.luis.xores.world.level.levelgen.placement;

import net.luis.xores.XOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-st
 *
 */

public class XOOrePlacements {
	
	public static final ResourceKey<PlacedFeature> JADE_ORE_UPPER = createKey("jade_ore_upper");
	public static final ResourceKey<PlacedFeature> JADE_ORE_MIDDLE = createKey("jade_ore_middle");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_RARE_UPPER = createKey("saphire_ore_rare_upper");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE = createKey("saphire_ore");
	public static final ResourceKey<PlacedFeature> SAPHIRE_ORE_BURIED = createKey("saphire_ore_buried");
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_BURIED = createKey("limonite_ore_buried");
	public static final ResourceKey<PlacedFeature> LIMONITE_ORE_DEEP_BURIED = createKey("limonite_ore_deep_buried");
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_RARE = createKey("enderite_ore_rare");
	public static final ResourceKey<PlacedFeature> ENDERITE_ORE_BURIED = createKey("enderite_ore_buried");
	
	public static void register() {
	
	}
	
	private static @NotNull ResourceKey<PlacedFeature> createKey(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(XOres.MOD_ID, name));
	}
}
