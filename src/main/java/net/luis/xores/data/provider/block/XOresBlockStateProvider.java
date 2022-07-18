package net.luis.xores.data.provider.block;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.world.level.block.XOresBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresBlockStateProvider extends BlockStateProvider {
	
	private final ExistingFileHelper existingFileHelper;
	
	public XOresBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
		this.existingFileHelper = existingFileHelper;
	}
	
	@Override
	protected void registerStatesAndModels() {
		for (Block block : XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			if (block == XOresBlocks.ENDERITE_ORE.get()) {
				this.columnBlock(block);
			} else {
				this.simpleBlock(block);
			}
			this.simpleBlockItem(block, this.getModel(block));
		}
	}
	
	private void columnBlock(Block block) {
		ModelFile modelFile = this.models().cubeColumn(ForgeRegistries.BLOCKS.getKey(block).getPath(), new ResourceLocation(this.blockTexture(block).toString() + "_side"), new ResourceLocation(this.blockTexture(block).toString() + "_top"));
		this.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(modelFile));
	}
	
	private ModelFile getModel(Block block) {
		return new ExistingModelFile(this.blockTexture(block), this.existingFileHelper);
	}
	
	@Override
	public String getName() {
		return "XOres Block States";
	}
	
}
