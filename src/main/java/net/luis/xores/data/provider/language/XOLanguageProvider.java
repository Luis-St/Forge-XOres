package net.luis.xores.data.provider.language;

import java.util.Objects;
import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.block.XOBlocks;
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

public class XOLanguageProvider extends LanguageProvider {
	
	public XOLanguageProvider(DataGenerator generator) {
		super(generator.getPackOutput(), XOres.MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		for (Block block : XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.add(block, getName(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
		}
		for (Item item : XOItems.ITEMS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.add(item, getName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))));
		}
		this.add("item_tab.xores", "XOres");
	}
	
	private String getName(ResourceLocation location) { 
		String[] nameParts = location.getPath().split("_");
		StringBuilder name = new StringBuilder();
		for (String namePart : nameParts) {
			String startChar = namePart.substring(0, 1).toUpperCase();
			name.append(startChar).append(namePart.substring(1)).append(" ");
		}
		return name.toString().trim();
	}
	
	@Override
	public String getName() {
		return "XOres Languages";
	}

}
