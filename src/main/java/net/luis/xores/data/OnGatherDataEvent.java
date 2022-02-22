package net.luis.xores.data;

import net.luis.xores.XOres;
import net.luis.xores.data.provider.block.XOresBlockStateProvider;
import net.luis.xores.data.provider.item.XOresItemModelProvider;
import net.luis.xores.data.provider.language.XOresLanguageProvider;
import net.luis.xores.data.provider.loot.XOresGlobalLootModifierProvider;
import net.luis.xores.data.provider.loottable.XOresLootTableProvider;
import net.luis.xores.data.provider.recipe.XOresRecipeProvider;
import net.luis.xores.data.provider.tag.XOresItemTagsProvider;
import net.minecraft.data.DataProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

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
	 * 	<li>{@link XOresItemTagsProvider}</li>
	 * 	<li>{@link XOresGlobalLootModifierProvider}</li>
	 * </ul>
	 */
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
//		DataGenerator generator = event.getGenerator();
//		if (event.includeDev()) {
//			if (event.includeClient()) {
//				generator.addProvider(new ModBlockStateProvider(generator, event.getExistingFileHelper()));
//				generator.addProvider(new ModItemModelProvider(generator, event.getExistingFileHelper()));
//				generator.addProvider(new ModLanguageProvider(generator));
//			}
//			if (event.includeServer()) {
//				generator.addProvider(new ModLootTableProvider(generator));
//				generator.addProvider(new ModRecipeProvider(generator));
//				ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, event.getExistingFileHelper());
//				generator.addProvider(blockTagsProvider);
//				generator.addProvider(new ModItemTagsProvider(generator, blockTagsProvider, event.getExistingFileHelper()));
//				generator.addProvider(new ModGlobalLootModifierProvider(generator));
//			}
//		}
	}
	
}
