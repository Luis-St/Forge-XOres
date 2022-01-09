package net.luis.xores.data.provider.language;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.init.ModBlocks;
import net.luis.xores.init.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModLanguageProvider extends LanguageProvider {

	public ModLanguageProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID, "en_us");
	}

	/**
	 * registration of all Blocks and Items to get the Translations
	 */
	@Override
	protected void addTranslations() {
		for (Block block : ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(block, getName(block.getRegistryName()));
		}
		for (Item item : ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(item, getName(item.getRegistryName()));
		}
		this.add(XOres.XORES_TAB.getDisplayName().getString(), "XOres");
	}
	
	/**
	 * 
	 * @param location
	 * @return the name of the {@link ResourceLocation},
	 * @example for the {@link ResourceLocation} "minecraft:iron_ingot" -> "Iron Ingot"
	 */
	protected String getName(ResourceLocation location) { 
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
