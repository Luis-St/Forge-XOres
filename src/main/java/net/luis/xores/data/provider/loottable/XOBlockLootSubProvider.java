package net.luis.xores.data.provider.loottable;

import java.util.Set;
import java.util.function.BiConsumer;

import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

/**
 * 
 * @author Luis-st
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
