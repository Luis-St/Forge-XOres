package net.luis.xores.init;

import net.luis.xores.XOres;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

// registration class of Block
public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XOres.MOD_ID);
	
	// Jade
	public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = BLOCKS.register("deepslate_jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> JADE_BLOCK = BLOCKS.register("jade_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK));
	});
	
	// Saphire
	public static final RegistryObject<Block> SAPHIRE_ORE = BLOCKS.register("saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_SAPHIRE_ORE = BLOCKS.register("deepslate_saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> SAPHIRE_BLOCK = BLOCKS.register("saphire_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
	});
	
	// Limonite
	public static final RegistryObject<Block> LIMONITE_ORE = BLOCKS.register("limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_LIMONITE_ORE = BLOCKS.register("deepslate_limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> LIMONITE_BLOCK = BLOCKS.register("limonite_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
	});
	
	// Rosite
	public static final RegistryObject<Block> ROSITE_ORE = BLOCKS.register("rosite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_ROSITE_ORE = BLOCKS.register("deepslate_rosite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> ROSITE_BLOCK = BLOCKS.register("rosite_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK));
	});
	
	// Enderite
	public static final RegistryObject<Block> ENDERITE_ORE = BLOCKS.register("enderite_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS));
	});
	public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK));
	});
	
}
