package net.luis.xores.data;

import net.luis.xores.XOres;
import net.luis.xores.data.provider.block.XOresBlockStateProvider;
import net.luis.xores.data.provider.item.XOresItemModelProvider;
import net.luis.xores.data.provider.language.XOresLanguageProvider;
import net.luis.xores.data.provider.loot.XOresGlobalLootModifierProvider;
import net.luis.xores.data.provider.loottable.XOresLootTableProvider;
import net.luis.xores.data.provider.recipe.XOresRecipeProvider;
import net.luis.xores.data.provider.tag.XOresBlockTagsProvider;
import net.luis.xores.data.provider.tag.XOresItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * {@link GatherDataEvent} event handler
 * 
 * @author Luis-st
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
	/**
	 * register all {@link XOres} {@link DataProvider}:
	 * <ul>
	 * 	<li>{@link XOresBlockStateProvider}</li>
	 * 	<li>{@link XOresItemModelProvider}</li>
	 * 	<li>{@link XOresLanguageProvider}</li>
	 * 	<li>{@link XOresLootTableProvider}</li>
	 * 	<li>{@link XOresRecipeProvider}</li>
	 * 	<li>{@link XOresBlockTagsProvider}</li>
	 * 	<li>{@link XOresItemTagsProvider}</li>
	 * 	<li>{@link XOresGlobalLootModifierProvider}</li>
	 * </ul>
	 */
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeDev()) {
			generator.addProvider(event.includeClient(), new XOresBlockStateProvider(generator, fileHelper));
			generator.addProvider(event.includeClient(), new XOresItemModelProvider(generator, fileHelper));
			generator.addProvider(event.includeClient(), new XOresLanguageProvider(generator));
			generator.addProvider(event.includeServer(), new XOresLootTableProvider(generator));
			generator.addProvider(event.includeServer(), new XOresRecipeProvider(generator));
			XOresBlockTagsProvider blockTagsProvider = new XOresBlockTagsProvider(generator, fileHelper);
			generator.addProvider(event.includeServer(), blockTagsProvider);
			generator.addProvider(event.includeServer(), new XOresItemTagsProvider(generator, blockTagsProvider, fileHelper));
			generator.addProvider(event.includeServer(), new XOresGlobalLootModifierProvider(generator));
		}
	}
	
}
