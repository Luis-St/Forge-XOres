package net.luis.xores.data.provider.tag;

import net.luis.xores.XOres;
import net.luis.xores.init.ModBlocks;
import net.luis.xores.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		this.tag(ModTags.Blocks.MINING_LEVEL_2);
		this.tag(ModTags.Blocks.MINING_LEVEL_3);
		this.tag(ModTags.Blocks.MINING_LEVEL_4);
		this.tag(ModTags.Blocks.MINING_LEVEL_5);
		this.tag(ModTags.Blocks.MINING_LEVEL_6);
		
		this.tag(ModTags.Blocks.JADE_ORES).add(ModBlocks.JADE_ORE.get(), ModBlocks.DEEPSLATE_JADE_ORE.get());
		this.tag(ModTags.Blocks.SAPHIRE_ORES).add(ModBlocks.SAPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPHIRE_ORE.get());
		this.tag(ModTags.Blocks.LIMONITE_ORES).add(ModBlocks.LIMONITE_ORE.get(), ModBlocks.DEEPSLATE_LIMONITE_ORE.get());
		this.tag(ModTags.Blocks.ROSITE_ORES).add(ModBlocks.ROSITE_ORE.get(), ModBlocks.DEEPSLATE_ROSITE_ORE.get());
		this.tag(ModTags.Blocks.ENDERITE_ORES).add(ModBlocks.ENDERITE_ORE.get());
		this.tag(ModTags.Blocks.ORE_BLOCKS).add(ModBlocks.JADE_BLOCK.get(), ModBlocks.SAPHIRE_BLOCK.get(), ModBlocks.LIMONITE_BLOCK.get(), ModBlocks.ROSITE_BLOCK.get(), ModBlocks.ENDERITE_BLOCK.get());
		
		this.tag(ModTags.Blocks.BASE_STONE_END).add(Blocks.END_STONE);
	}
	
	@Override
	public String getName() {
		return "XOres Block Tags";
	}

}
