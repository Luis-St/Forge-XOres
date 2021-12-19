package net.luis.xores.data.provider.language;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.init.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		for (Block block : ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(block, this.getName(block.getRegistryName()));
		}
	}
	
	public String getName(ResourceLocation location) {
		String[] nameParts = location.getPath().split("_");
		String name = "";
		for (String namePart : nameParts) {
			String startChar = namePart.substring(0, 1).toUpperCase();
			name += startChar + namePart.substring(1, namePart.length()) + " ";
		}
		return name.trim();
	}
	
	@Override
	public String getName() {
		return "XOres Languages";
	}

}
