package net.luis.xores.data;

import net.luis.xores.XOres;
import net.luis.xores.data.provider.block.XOBlockStateProvider;
import net.luis.xores.data.provider.item.XOItemModelProvider;
import net.luis.xores.data.provider.language.XOLanguageProvider;
import net.luis.xores.data.provider.loot.XOGlobalLootModifierProvider;
import net.luis.xores.data.provider.loottable.XOLootTableProvider;
import net.luis.xores.data.provider.recipe.XORecipeProvider;
import net.luis.xores.data.provider.tag.XOBlockTagsProvider;
import net.luis.xores.data.provider.tag.XOItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

/**
 * 
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
	@SubscribeEvent
	public static void gatherData(net.minecraftforge.forge.event.lifecycle.GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeDev()) {
			if (event.includeClient()) {
				generator.addProvider(new XOBlockStateProvider(generator, fileHelper));
				generator.addProvider(new XOItemModelProvider(generator, fileHelper));
				generator.addProvider(new XOLanguageProvider(generator));
				generator.addProvider(new XOLootTableProvider(generator));
				generator.addProvider(new XORecipeProvider(generator));
			}
			if (event.includeServer()) {
				XOBlockTagsProvider blockTagsProvider = new XOBlockTagsProvider(generator, fileHelper);
				generator.addProvider(blockTagsProvider);
				generator.addProvider(new XOItemTagsProvider(generator, blockTagsProvider, fileHelper));
				generator.addProvider(new XOGlobalLootModifierProvider(generator));
			}
		}
	}
	
}
