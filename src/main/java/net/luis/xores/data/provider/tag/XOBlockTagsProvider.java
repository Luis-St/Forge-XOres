package net.luis.xores.data.provider.tag;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static net.luis.xores.world.level.block.XOBlocks.*;
import static net.minecraft.tags.BlockTags.*;

/**
 *
 * @author Luis-St
 *
 */

public class XOBlockTagsProvider extends BlockTagsProvider {
	
	public XOBlockTagsProvider(@NotNull DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(generator.getPackOutput(), lookupProvider, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void addTags(@NotNull HolderLookup.Provider provider) {
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_1).addTag(BlockTags.NEEDS_STONE_TOOL).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get(), JADE_BLOCK.get());
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_2).addTag(BlockTags.NEEDS_IRON_TOOL).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get());
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_3).addTag(BlockTags.NEEDS_DIAMOND_TOOL).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), ENDERITE_BLOCK.get());
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_4);
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_5);
		this.tag(XOBlockTags.NEEDS_TOOL_LEVEL_6).add(ENDERITE_ORE.get());
		
		IntrinsicTagAppender<Block> pickaxeMinable = this.tag(MINEABLE_WITH_PICKAXE);
		for (Block block : BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			pickaxeMinable.add(block);
		}
		
		this.tag(XOBlockTags.JADE_ORES).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get());
		this.tag(XOBlockTags.SAPHIRE_ORES).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get());
		this.tag(XOBlockTags.LIMONITE_ORES).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
		this.tag(XOBlockTags.ENDERITE_ORES).add(ENDERITE_ORE.get());
		this.tag(XOBlockTags.ORE_BLOCKS).add(JADE_BLOCK.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ENDERITE_BLOCK.get());
		this.tag(Tags.Blocks.ORES).addTags(XOBlockTags.JADE_ORES, XOBlockTags.SAPHIRE_ORES, XOBlockTags.LIMONITE_ORES, XOBlockTags.ENDERITE_ORES);
		this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(JADE_ORE.get(), SAPHIRE_ORE.get(), LIMONITE_ORE.get());
		this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(DEEPSLATE_JADE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Block Tags";
	}
}
