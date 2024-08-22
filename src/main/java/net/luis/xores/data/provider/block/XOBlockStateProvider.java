/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

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
	
	public XOBlockStateProvider(@NotNull DataGenerator generator, @NotNull ExistingFileHelper existingFileHelper) {
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
	private void columnBlock(@NotNull Block block) {
		String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
		ModelFile modelFile = this.models().cubeColumn(name, ResourceLocation.parse(this.blockTexture(block).toString() + "_side"), ResourceLocation.parse(this.blockTexture(block).toString() + "_top"));
		this.getVariantBuilder(block).partialState().setModels(new ConfiguredModel(modelFile));
	}
	//endregion
	
	private @NotNull ModelFile getModel(@NotNull Block block) {
		return new ExistingModelFile(this.blockTexture(block), this.existingFileHelper);
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Block States";
	}
}
