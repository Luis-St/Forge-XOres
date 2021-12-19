package net.luis.xores.data.provider.loottable;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class ModLootTableProvider extends LootTableProvider {

	public ModLootTableProvider(DataGenerator generator) {
		super(generator);
	}
	
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return Lists.newArrayList(Pair.of(ModBlockLoot::new, LootContextParamSets.BLOCK));
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> lootTables, ValidationContext validationContext) {
		
	}
	
	@Override
	public String getName() {
		return "XOres LootTables";
	}

}
