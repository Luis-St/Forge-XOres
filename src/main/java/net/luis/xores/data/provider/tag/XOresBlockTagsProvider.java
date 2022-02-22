package net.luis.xores.data.provider.tag;

import static net.luis.xores.init.XOresBlocks.BLOCKS;
import static net.luis.xores.init.XOresBlocks.DEEPSLATE_JADE_ORE;
import static net.luis.xores.init.XOresBlocks.DEEPSLATE_LIMONITE_ORE;
import static net.luis.xores.init.XOresBlocks.DEEPSLATE_ROSITE_ORE;
import static net.luis.xores.init.XOresBlocks.DEEPSLATE_SAPHIRE_ORE;
import static net.luis.xores.init.XOresBlocks.ENDERITE_BLOCK;
import static net.luis.xores.init.XOresBlocks.ENDERITE_ORE;
import static net.luis.xores.init.XOresBlocks.JADE_BLOCK;
import static net.luis.xores.init.XOresBlocks.JADE_ORE;
import static net.luis.xores.init.XOresBlocks.LIMONITE_BLOCK;
import static net.luis.xores.init.XOresBlocks.LIMONITE_ORE;
import static net.luis.xores.init.XOresBlocks.ROSITE_BLOCK;
import static net.luis.xores.init.XOresBlocks.ROSITE_ORE;
import static net.luis.xores.init.XOresBlocks.SAPHIRE_BLOCK;
import static net.luis.xores.init.XOresBlocks.SAPHIRE_ORE;
import static net.luis.xores.init.XOresTags.Blocks.BASE_STONE_END;
import static net.luis.xores.init.XOresTags.Blocks.ENDERITE_ORES;
import static net.luis.xores.init.XOresTags.Blocks.JADE_ORES;
import static net.luis.xores.init.XOresTags.Blocks.LIMONITE_ORES;
import static net.luis.xores.init.XOresTags.Blocks.ORE_BLOCKS;
import static net.luis.xores.init.XOresTags.Blocks.ROSITE_ORES;
import static net.luis.xores.init.XOresTags.Blocks.SAPHIRE_ORES;
import static net.luis.xores.init.XOresTags.Blocks.STONES;
import static net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.data.OnGatherDataEvent;
import net.luis.xores.init.XOresBlocks;
import net.luis.xores.init.XOresTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link BlockTagsProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the block tags for all mod {@link Block}s
 * 
 * @author Luis-st
 * 
 * @see {@link BlockTagsProvider}
 * @see {@link OnGatherDataEvent}
 * @see {@link XOresTags}
 * @see {@link XOresBlocks}
 */

public class XOresBlockTagsProvider extends BlockTagsProvider {

	/**
	 * constructor for the {@link XOresBlockTagsProvider}
	 */
	public XOresBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}
	
	/**
	 * register all {@link Block} {@link Tag}s
	 */
	@Override
	protected void addTags() {
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_1).addTag(BlockTags.NEEDS_STONE_TOOL).add(JADE_ORE.get(), DEEPSLATE_JADE_ORE.get(), JADE_BLOCK.get());
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_2).addTag(BlockTags.NEEDS_IRON_TOOL).add(SAPHIRE_ORE.get(), DEEPSLATE_SAPHIRE_ORE.get(), SAPHIRE_BLOCK.get(), LIMONITE_BLOCK.get(), ROSITE_BLOCK.get());
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_3).addTag(BlockTags.NEEDS_DIAMOND_TOOL).add(LIMONITE_ORE.get(), DEEPSLATE_LIMONITE_ORE.get(), ROSITE_ORE.get(), DEEPSLATE_ROSITE_ORE.get(), ENDERITE_BLOCK.get());
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_4);
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_5);
		this.tag(XOresTags.Blocks.NEEDS_TOOL_LEVEL_6).add(ENDERITE_ORE.get());
		
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
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Block Tags";
	}

}
