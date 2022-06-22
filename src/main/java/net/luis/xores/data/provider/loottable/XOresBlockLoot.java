package net.luis.xores.data.provider.loottable;

import java.util.stream.Collectors;

import net.luis.xores.init.block.XOresBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link BlockLoot}, creates the loot tables for all mod {@link Block}s,
 * used in {@link XOresLootTableProvider}
 * 
 * @author Luis-st
 * 
 * @see {@link LootTableProvider}
 * @see {@link XOresBlocks}
 * @see {@link XOresLootTableProvider}
 */

public class XOresBlockLoot extends BlockLoot {
	
	/**
	 * constructor for the {@link XOresBlockLoot}<br>
	 * package private since a new instance should only be created in {@link XOresLootTableProvider}
	 */
	XOresBlockLoot() {
		
	}
	
	/**
	 * register all {@link LootTable}s for {@link XOresBlocks#BLOCKS}
	 */
	@Override
	protected void addTables() {
		for (Block block : XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.dropSelf(block);
		}
	}
	
	/**
	 * @return a {@link Iterable} of all known {@link Block}s
	 */
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}

}
