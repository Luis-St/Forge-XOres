package net.luis.xores.data.provider.language;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOresItems;
import net.luis.xores.world.level.block.XOresBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresLanguageProvider extends LanguageProvider {
	
	public XOresLanguageProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		for (Block block : XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(block, getName(ForgeRegistries.BLOCKS.getKey(block)));
		}
		for (Item item : XOresItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(item, getName(ForgeRegistries.ITEMS.getKey(item)));
		}
		this.add(XOres.TAB.getDisplayName().getString(), "XOres");
	}
	
	private String getName(ResourceLocation location) { 
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
