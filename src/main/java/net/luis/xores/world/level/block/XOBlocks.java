package net.luis.xores.world.level.block;

import net.luis.xores.XOres;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 *
 * @author Luis-st
 *
 */

public class XOBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XOres.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<Block> JADE_ORE = register("jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = register("deepslate_jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> JADE_BLOCK = register("jade_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
	});
	public static final RegistryObject<Block> SAPHIRE_ORE = register("saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_SAPHIRE_ORE = register("deepslate_saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> SAPHIRE_BLOCK = register("saphire_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
	});
	public static final RegistryObject<Block> LIMONITE_ORE = register("limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_LIMONITE_ORE = register("deepslate_limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> LIMONITE_BLOCK = register("limonite_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
	});
	public static final RegistryObject<Block> ENDERITE_ORE = register("enderite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS));
	});
	public static final RegistryObject<Block> ENDERITE_BLOCK = register("enderite_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK));
	});
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
		RegistryObject<T> blockObject = BLOCKS.register(name, blockSupplier);
		ITEMS.register(name, () -> new BlockItem(blockObject.get(), new Item.Properties()));
		return blockObject;
	}
	
}
