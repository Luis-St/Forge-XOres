package net.luis.xores.data.provider.loottable;

import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockLootSubProvider extends BlockLootSubProvider {
	
	XOBlockLootSubProvider() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}
	
	@Override
	protected void generate() {
		for (Block block : XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.dropSelf(block);
		}
	}
	
	@Override
	protected @NotNull Iterable<Block> getKnownBlocks() {
		return XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
