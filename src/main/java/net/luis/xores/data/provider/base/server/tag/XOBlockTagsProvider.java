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

package net.luis.xores.data.provider.base.server.tag;

import net.luis.xores.XOres;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.luis.xores.world.level.block.XOBlocks.*;
import static net.luis.xores.world.level.block.XOBlocks.Tags.*;
import static net.minecraft.tags.BlockTags.*;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockTagsProvider extends BlockTagsProvider {
	
	public XOBlockTagsProvider(@NotNull DataGenerator generator, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider, @NotNull ExistingFileHelper existingFileHelper) {
		super(generator.getPackOutput(), lookupProvider, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void addTags(@NotNull HolderLookup.Provider provider) {
		this.tag(NEEDS_STONE_TOOL).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get(), JADE_BLOCK.get());
		this.tag(NEEDS_IRON_TOOL).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get());
		this.tag(NEEDS_DIAMOND_TOOL).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), ENDERITE_BLOCK.get());
		this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
		this.tag(NEEDS_ENDERITE_TOOL);
		this.tag(NEEDS_STEEL_TOOL).add(ENDERITE_ORE.get());
		
		this.tag(INCORRECT_FOR_STEEL_TOOL);
		this.tag(INCORRECT_FOR_ENDERITE_TOOL).addTag(NEEDS_STEEL_TOOL);
		this.tag(INCORRECT_FOR_NETHERITE_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL);
		this.tag(INCORRECT_FOR_DIAMOND_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL).addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL);
		this.tag(INCORRECT_FOR_IRON_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL).addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addTag(NEEDS_DIAMOND_TOOL);
		this.tag(INCORRECT_FOR_STONE_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL).addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addTag(NEEDS_DIAMOND_TOOL).addTag(NEEDS_IRON_TOOL);
		this.tag(INCORRECT_FOR_GOLD_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL).addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addTag(NEEDS_DIAMOND_TOOL).addTag(NEEDS_IRON_TOOL).addTag(NEEDS_STONE_TOOL);
		this.tag(INCORRECT_FOR_WOODEN_TOOL).addTag(NEEDS_STEEL_TOOL).addTag(NEEDS_ENDERITE_TOOL).addTag(Tags.Blocks.NEEDS_NETHERITE_TOOL).addTag(NEEDS_DIAMOND_TOOL).addTag(NEEDS_IRON_TOOL).addTag(NEEDS_STONE_TOOL);
		
		IntrinsicTagAppender<Block> pickaxeMinable = this.tag(MINEABLE_WITH_PICKAXE);
		for (Block block : BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			pickaxeMinable.add(block);
		}
		
		this.tag(JADE_ORES).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get());
		this.tag(SAPHIRE_ORES).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get());
		this.tag(LIMONITE_ORES).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
		this.tag(ENDERITE_ORES).add(ENDERITE_ORE.get());
		this.tag(ORE_BLOCKS).add(JADE_BLOCK.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ENDERITE_BLOCK.get());
		this.tag(Tags.Blocks.ORES).addTags(JADE_ORES, SAPHIRE_ORES, LIMONITE_ORES, ENDERITE_ORES);
		this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(JADE_ORE.get(), SAPHIRE_ORE.get(), LIMONITE_ORE.get());
		this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(DEEPSLATE_JADE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Block Tags";
	}
}
