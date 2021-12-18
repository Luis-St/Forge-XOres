package net.luis.xores.init;

import net.luis.xores.XOres;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XOres.MOD_ID);
	
	
	public static final RegistryObject<Block> JADE_ORE = BLOCKS.register("jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = BLOCKS.register("deepslate_jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE));
	});
	
}
