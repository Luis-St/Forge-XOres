package net.luis.xores.data.provider.loottable;

import java.util.stream.Collectors;

import net.luis.xores.init.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModBlockLoot extends BlockLoot {
	
	@Override
	protected void addTables() { // registration of all Blocks to get the LootTables
		for (Block block : ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.dropSelf(block); // all Blocks drops itself
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}

}
