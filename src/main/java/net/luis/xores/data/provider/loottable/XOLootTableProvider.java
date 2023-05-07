package net.luis.xores.data.provider.loottable;

import com.google.common.collect.Lists;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Luis-st
 *
 */

public class XOLootTableProvider extends LootTableProvider {
	
	public XOLootTableProvider(DataGenerator generator) {
		super(generator.getPackOutput(), Set.of(), Lists.newArrayList(new SubProviderEntry(XOBlockLootSubProvider::new, LootContextParamSets.BLOCK)));
	}
	
	@Override
	protected void validate(@NotNull Map<ResourceLocation, LootTable> lootTables, @NotNull ValidationContext validationContext) {
		
	}
}
