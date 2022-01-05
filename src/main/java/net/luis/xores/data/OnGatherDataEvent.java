package net.luis.xores.data;

import net.luis.xores.XOres;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
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
