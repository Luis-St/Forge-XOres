package net.luis.xores.data.provider.loottable;

import java.util.stream.Collectors;

import net.luis.xores.world.level.block.XOresBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresBlockLoot extends BlockLoot {
	
	XOresBlockLoot() {
		
	}
	
	@Override
	protected void addTables() {
		for (Block block : XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.dropSelf(block);
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}

}
