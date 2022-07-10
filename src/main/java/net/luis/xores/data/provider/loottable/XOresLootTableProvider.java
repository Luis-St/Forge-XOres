package net.luis.xores.data.provider.loottable;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * extension of {@link LootTableProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the loot tables for all mod {@link Block}s
 * 
 * @author Luis-st
 */

public class XOresLootTableProvider extends LootTableProvider {

	/**
	 * constructor for the {@link XOresLootTableProvider}
	 */
	public XOresLootTableProvider(DataGenerator generator) {
		super(generator);
	}
	
	/**
	 * register the {@link XOresBlockLoot} with the {@link LootContextParamSets#BLOCK} as {@link LootContextParamSet}
	 */
	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return Lists.newArrayList(Pair.of(XOresBlockLoot::new, LootContextParamSets.BLOCK));
	}
	
	/**
	 * validation check of the {@link LootTable}s,<br>
	 * but we don't check any validation at the moment
	 */
	@Override
	protected void validate(Map<ResourceLocation, LootTable> lootTables, ValidationContext validationContext) {
		
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres LootTables";
	}

}
