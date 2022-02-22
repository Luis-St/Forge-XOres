package net.luis.xores.data.provider.language;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.XOresCreativeModeTab;
import net.luis.xores.data.OnGatherDataEvent;
import net.luis.xores.init.XOresBlocks;
import net.luis.xores.init.XOresItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link LanguageProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the translations for:
 * <ul>
 * 	<li>all mod {@link Block}s</li>
 *  <li>all mod {@link Item}s</li>
 *  <li>the mod {@link CreativeXOreseTab}</li>
 * </ul>
 * 
 * @author Luis-st
 * 
 * @see {@link LanguageProvider}
 * @see {@link OnGatherDataEvent}
 * @see {@link XOresBlocks}
 * @see {@link XOresItems}
 * @see {@link XOresCreativeModeTab}
 */

public class XOresLanguageProvider extends LanguageProvider {

	/**
	 * constructor for the {@link XOresLanguageProvider}
	 */
	public XOresLanguageProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID, "en_us");
	}

	/**
	 * register all translations for<br>
	 * <ul>
	 * 	<li>all {@link XOresBlocks#BLOCKS}</li>
	 * 	<li>all {@link XOresBlocks#ITEMS}</li>
	 * 	<li>{@link XOres#XORES_TAB}</li>
	 * </ul>
	 */
	@Override
	protected void addTranslations() {
		for (Block block : XOresBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(block, getName(block.getRegistryName()));
		}
		for (Item item : XOresItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			this.add(item, getName(item.getRegistryName()));
		}
		this.add(XOres.XORES_TAB.getDisplayName().getString(), "XOres");
	}
	
	/**
	 * @return the english name for the given {@link ResourceLocation}
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
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Languages";
	}

}
