package net.luis.xores.data.provider.loottable;

import java.util.stream.Collectors;

import net.luis.xores.init.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link BlockLoot},<br>
 * creates the loot tables for all mod {@link Block}s,
 * used in {@link ModLootTableProvider}
 * 
 * @author Luis-st
 * 
 * @see {@link LootTableProvider}
 * @see {@link ModBlocks}
 * @see {@link ModLootTableProvider}
 */

public class ModBlockLoot extends BlockLoot {
	
	/**
	 * constructor for the {@link ModBlockLoot}<br>
	 * constructor is package private,<br>
	 * because a new instance should only be created in {@link ModLootTableProvider}
	 */
	ModBlockLoot() {
		
	}
	
	/**
	 * register all {@link LootTable}s for all {@link ModBlocks#BLOCKS}
	 */
	@Override
	protected void addTables() {
		for (Block block : ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.dropSelf(block);
		}
	}
	
	/**
	 * @return a {@link Iterable} of all known {@link Block}s
	 */
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}

}
