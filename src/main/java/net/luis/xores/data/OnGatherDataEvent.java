package net.luis.xores.data;

import net.luis.xores.XOres;
import net.luis.xores.data.provider.DatapackBuiltinEntriesProvider;
import net.luis.xores.data.provider.XOBuiltinProvider;
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
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings({"resource", "ResultOfMethodCallIgnored"})
@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnGatherDataEvent {
	
	private static final Path ROOT = new File(Paths.get(".").toAbsolutePath().toString()).getParentFile().getParentFile().toPath();
	
	@SubscribeEvent
	public static void gatherData(@NotNull GatherDataEvent event) throws IOException {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		String type = System.getProperty("xores.data.include");
		if (event.includeDev()) {
			if ("mod".equalsIgnoreCase(type)) {
				generator.addProvider(event.includeClient(), new XOBlockStateProvider(generator, fileHelper));
				generator.addProvider(event.includeClient(), new XOItemModelProvider(generator, fileHelper));
				generator.addProvider(event.includeClient(), new XOLanguageProvider(generator));
				generator.addProvider(event.includeServer(), new XOLootTableProvider(generator));
				generator.addProvider(event.includeServer(), new XORecipeProvider(generator));
				XOBlockTagsProvider blockTagsProvider = new XOBlockTagsProvider(generator, event.getLookupProvider(), fileHelper);
				generator.addProvider(event.includeServer(), blockTagsProvider);
				generator.addProvider(event.includeServer(), new XOItemTagsProvider(generator, event.getLookupProvider(), blockTagsProvider.contentsGetter(), fileHelper));
				generator.addProvider(event.includeServer(), new XOGlobalLootModifierProvider(generator));
				generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(generator.getPackOutput(), event.getLookupProvider(), XOBuiltinProvider.createProvider(), Set.of(XOres.MOD_ID)));
			}
			if ("rarer".equalsIgnoreCase(type)) {
				setupDatapackGeneration("xores_rarer_ores");
				generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(generator.getPackOutput(), event.getLookupProvider(), XOBuiltinProvider.createRarerPackProvider(), Set.of(XOres.MOD_ID, "minecraft")));
			}
			if ("very_rare".equalsIgnoreCase(type)) {
				setupDatapackGeneration("xores_very_rare_ores");
				generator.addProvider(event.includeServer(), new DatapackBuiltinEntriesProvider(generator.getPackOutput(), event.getLookupProvider(), XOBuiltinProvider.createVeryRarePackProvider(), Set.of(XOres.MOD_ID, "minecraft")));
			}
		}
	}
	
	private static void setupDatapackGeneration(@NotNull String packName) throws IOException {
		Path temp = Files.createTempDirectory(XOres.MOD_ID);
		move(ROOT.resolve("src/generated/resources"), temp);
		addCopyHook(packName, temp);
	}
	
	private static void move(@NotNull Path from, @NotNull Path to) throws IOException {
		Files.walk(from).filter(path -> path.toFile().isFile()).forEach(path -> {
			try {
				Files.createDirectories(to.resolve(from.relativize(path).getParent()));
				Files.move(path, to.resolve(from.relativize(path)), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});
	}
	
	private static void addCopyHook(@NotNull String packName, @NotNull Path temp) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			Path output = ROOT.resolve("src/generated/resources");
			Path pack = ROOT.resolve("src/main/resources/" + packName);
			try {
				Files.walk(output.resolve(".cache")).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
				Files.walk(pack).filter(path -> !"pack.mcmeta".equals(path.toFile().getName())).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
				List<Path> generated = Files.walk(output).filter(path -> path.toFile().isFile()).map(output::relativize).toList();
				for (Path path : generated) {
					Files.createDirectories(pack.resolve(path).getParent());
					Files.copy(output.resolve(path), pack.resolve(path), StandardCopyOption.REPLACE_EXISTING);
				}
				Files.walk(output).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
				move(temp, output);
				Files.walk(temp).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
				Files.deleteIfExists(temp);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}));
	}
}
