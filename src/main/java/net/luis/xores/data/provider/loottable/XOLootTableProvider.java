package net.luis.xores.data.provider.loottable;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

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
