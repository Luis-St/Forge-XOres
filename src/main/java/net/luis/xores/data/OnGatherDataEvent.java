package net.luis.xores.data;

import net.luis.xores.XOres;
import net.luis.xores.data.provider.block.XOBlockStateProvider;
import net.luis.xores.data.provider.item.XOItemModelProvider;
import net.luis.xores.data.provider.language.XOLanguageProvider;
import net.luis.xores.data.provider.level.XOLevelProvider;
import net.luis.xores.data.provider.loot.XOGlobalLootModifierProvider;
import net.luis.xores.data.provider.loottable.XOLootTableProvider;
import net.luis.xores.data.provider.recipe.XORecipeProvider;
import net.luis.xores.data.provider.tag.XOBlockTagsProvider;
import net.luis.xores.data.provider.tag.XOItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 *
 * @author Luis-st
 *
 */

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
	@SubscribeEvent
	public static void gatherData(@NotNull GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeDev()) {
			generator.addProvider(event.includeClient(), new XOBlockStateProvider(generator, fileHelper));
			generator.addProvider(event.includeClient(), new XOItemModelProvider(generator, fileHelper));
			generator.addProvider(event.includeClient(), new XOLanguageProvider(generator));
			generator.addProvider(event.includeServer(), new XOLootTableProvider(generator));
			generator.addProvider(event.includeServer(), new XORecipeProvider(generator));
			XOBlockTagsProvider blockTagsProvider = new XOBlockTagsProvider(generator, event.getLookupProvider(), fileHelper);
			generator.addProvider(event.includeServer(), blockTagsProvider);
			generator.addProvider(event.includeServer(), new XOItemTagsProvider(generator, event.getLookupProvider(), blockTagsProvider.contentsGetter(), fileHelper));
			generator.addProvider(event.includeServer(), new XOGlobalLootModifierProvider(generator));
			
			generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(generator.getPackOutput(), event.getLookupProvider(), XOLevelProvider.createProvider(), Set.of(XOres.MOD_ID)));
		}
	}
}
