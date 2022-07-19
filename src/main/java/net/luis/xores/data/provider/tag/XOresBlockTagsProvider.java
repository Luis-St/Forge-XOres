package net.luis.xores.data.provider.tag;

import static net.luis.xores.world.level.block.XOresBlocks.BLOCKS;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_JADE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_ROSITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.DEEPSLATE_SAPHIRE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.ENDERITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.ENDERITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.JADE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.JADE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.LIMONITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.LIMONITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.ROSITE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.ROSITE_ORE;
import static net.luis.xores.world.level.block.XOresBlocks.SAPHIRE_BLOCK;
import static net.luis.xores.world.level.block.XOresBlocks.SAPHIRE_ORE;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOresBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresBlockTagsProvider extends BlockTagsProvider {
	
	public XOresBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void addTags() {
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_1).addTag(BlockTags.NEEDS_STONE_TOOL).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get(), JADE_BLOCK.get());
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_2).addTag(BlockTags.NEEDS_IRON_TOOL).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ROSITE_BLOCK.get());
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_3).addTag(BlockTags.NEEDS_DIAMOND_TOOL).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), ROSITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get(), ENDERITE_BLOCK.get());
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_4);
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_5);
		this.tag(XOresBlockTags.NEEDS_TOOL_LEVEL_6).add(ENDERITE_ORE.get());
		
		TagAppender<Block> pickaxeMinable = this.tag(MINEABLE_WITH_PICKAXE);
		for (Block block : BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			pickaxeMinable.add(block);
		}
		
		this.tag(XOresBlockTags.JADE_ORES).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get());
		this.tag(XOresBlockTags.SAPHIRE_ORES).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get());
		this.tag(XOresBlockTags.LIMONITE_ORES).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
		this.tag(XOresBlockTags.ROSITE_ORES).add(ROSITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get());
		this.tag(XOresBlockTags.ENDERITE_ORES).add(ENDERITE_ORE.get());
		this.tag(XOresBlockTags.ORE_BLOCKS).add(JADE_BLOCK.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ROSITE_BLOCK.get(), ENDERITE_BLOCK.get());
		
		this.tag(Tags.Blocks.ORES).addTags(XOresBlockTags.JADE_ORES, XOresBlockTags.SAPHIRE_ORES, XOresBlockTags.LIMONITE_ORES, XOresBlockTags.ROSITE_ORES, XOresBlockTags.ENDERITE_ORES);
		this.tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(JADE_ORE.get(), SAPHIRE_ORE.get(), LIMONITE_ORE.get(), ROSITE_ORE.get());
		this.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(DEEPSLATE_JADE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get());
	}
	
	@Override
	public String getName() {
		return "XOres Block Tags";
	}

}
