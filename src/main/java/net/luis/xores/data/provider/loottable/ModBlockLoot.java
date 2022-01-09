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
	
	/**
	 * registration of all Block LootTables<br>
	 * -> all Blocks drops itself
	 */
	@Override
	protected void addTables() {
		for (Block block : ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.dropSelf(block);
		}
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
	}

}
