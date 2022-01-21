package net.luis.xores.data.provider.tag;

import static net.luis.xores.init.ModBlocks.BLOCKS;
import static net.luis.xores.init.ModBlocks.DEEPSLATE_JADE_ORE;
import static net.luis.xores.init.ModBlocks.DEEPSLATE_LIMONITE_ORE;
import static net.luis.xores.init.ModBlocks.DEEPSLATE_ROSITE_ORE;
import static net.luis.xores.init.ModBlocks.DEEPSLATE_SAPHIRE_ORE;
import static net.luis.xores.init.ModBlocks.ENDERITE_BLOCK;
import static net.luis.xores.init.ModBlocks.ENDERITE_ORE;
import static net.luis.xores.init.ModBlocks.JADE_BLOCK;
import static net.luis.xores.init.ModBlocks.JADE_ORE;
import static net.luis.xores.init.ModBlocks.LIMONITE_BLOCK;
import static net.luis.xores.init.ModBlocks.LIMONITE_ORE;
import static net.luis.xores.init.ModBlocks.ROSITE_BLOCK;
import static net.luis.xores.init.ModBlocks.ROSITE_ORE;
import static net.luis.xores.init.ModBlocks.SAPHIRE_BLOCK;
import static net.luis.xores.init.ModBlocks.SAPHIRE_ORE;
import static net.luis.xores.init.ModTags.Blocks.BASE_STONE_END;
import static net.luis.xores.init.ModTags.Blocks.ENDERITE_ORES;
import static net.luis.xores.init.ModTags.Blocks.JADE_ORES;
import static net.luis.xores.init.ModTags.Blocks.LIMONITE_ORES;
import static net.luis.xores.init.ModTags.Blocks.ORE_BLOCKS;
import static net.luis.xores.init.ModTags.Blocks.ROSITE_ORES;
import static net.luis.xores.init.ModTags.Blocks.SAPHIRE_ORES;
import static net.luis.xores.init.ModTags.Blocks.STONES;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_1).addTag(BlockTags.NEEDS_STONE_TOOL).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get(), JADE_BLOCK.get());
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_2).addTag(BlockTags.NEEDS_IRON_TOOL).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ROSITE_BLOCK.get());
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_3).addTag(BlockTags.NEEDS_DIAMOND_TOOL).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), ROSITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get(), ENDERITE_BLOCK.get());
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_4);
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_5);
		this.tag(ModTags.Blocks.NEEDS_TOOL_LEVEL_6).add(ENDERITE_ORE.get());
		
		TagAppender<Block> pickaxeMinable = this.tag(MINEABLE_WITH_PICKAXE);
		
		for (Block block : BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			pickaxeMinable.add(block);
		}
		
		this.tag(JADE_ORES).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get());
		this.tag(SAPHIRE_ORES).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get());
		this.tag(LIMONITE_ORES).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get());
		this.tag(ROSITE_ORES).add(ROSITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get());
		this.tag(ENDERITE_ORES).add(ENDERITE_ORE.get());
		this.tag(ORE_BLOCKS).add(JADE_BLOCK.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ROSITE_BLOCK.get(), ENDERITE_BLOCK.get());
		
		this.tag(BASE_STONE_END).add(Blocks.END_STONE);
		this.tag(STONES).add(Blocks.STONE, Blocks.BLACKSTONE, Blocks.DEEPSLATE);
	}
	
	@Override
	public String getName() {
		return "XOres Block Tags";
	}

}
