package net.luis.xores.data.provider.block;

import net.luis.xores.XOres;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockStateProvider extends BlockStateProvider {
	
	private final ExistingFileHelper existingFileHelper;
	
	public XOBlockStateProvider(@NotNull DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator.getPackOutput(), XOres.MOD_ID, existingFileHelper);
		this.existingFileHelper = existingFileHelper;
	}
	
	@Override
	protected void registerStatesAndModels() {
		for (Block block : XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			if (block == XOBlocks.ENDERITE_ORE.get()) {
				this.columnBlock(block);
			} else {
				this.simpleBlock(block);
			}
			this.simpleBlockItem(block, this.getModel(block));
		}
	}
	
	//region Block state helpers
	private void columnBlock(Block block) {
		String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
		ModelFile modelFile = this.models().cubeColumn(name, new ResourceLocation(this.blockTexture(block).toString() + "_side"), new ResourceLocation(this.blockTexture(block).toString() + "_top"));
		this.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(modelFile));
	}
	//endregion
	
	private @NotNull ModelFile getModel(Block block) {
		return new ExistingModelFile(this.blockTexture(block), this.existingFileHelper);
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Block States";
	}
}
