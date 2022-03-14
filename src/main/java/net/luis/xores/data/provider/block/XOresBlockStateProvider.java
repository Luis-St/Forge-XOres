package net.luis.xores.data.provider.block;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.data.OnGatherDataEvent;
import net.luis.xores.init.XOresBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link BlockStateProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the models and states for all mod {@link Block}s
 * 
 * @author Luis-st
 * 
 * @see {@link BlockStateProvider}
 * @see {@link OnGatherDataEvent}
 * @see {@link XOresBlocks}
 */

public class XOresBlockStateProvider extends BlockStateProvider {

	/**
	 * the existing file helper of the data run
	 */
	protected final ExistingFileHelper existingFileHelper;
	
	/**
	 * constructor for the {@link XOresBlockStateProvider}
	 */
	public XOresBlockStateProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
		this.existingFileHelper = existingFileHelper;
	}
	
	/**
	 * register all {@link BlockXOresel}s, block states and item models for {@link XOresBlocks#BLOCKS}
	 */
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
	
	/**
	 * register a column block model for the given {@link Block}
	 */
	protected void columnBlock(Block block) {
		ModelFile modelFile = this.models().cubeColumn(block.getRegistryName().getPath(), new ResourceLocation(this.blockTexture(block).toString() + "_side"), new ResourceLocation(this.blockTexture(block).toString() + "_top"));
		this.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(modelFile));
	}
	
	/**
	 * @return a {@link ExistingModelFile} for the given {@link Block}
	 */
	protected ModelFile getModel(Block block) {
		return new ExistingModelFile(this.blockTexture(block), this.existingFileHelper);
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Block States";
	}
	
}
