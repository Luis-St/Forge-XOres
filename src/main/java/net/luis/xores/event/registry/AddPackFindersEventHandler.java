package net.luis.xores.event.registry;

import net.luis.xores.XOres;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.*;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

/**
 *
 * @author Luis-St
 *
 */

@Mod.EventBusSubscriber(modid = XOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AddPackFindersEventHandler {
	
	@SubscribeEvent
	public static void addPackFinders(@NotNull AddPackFindersEvent event) {
		if (event.getPackType() == PackType.SERVER_DATA) {
			addServerPack(event, "xores_rarer_ores", "XOres Rarer Ores");
			addServerPack(event, "xores_very_rare_ores", "XOres Very Rare Ores");
		}
	}
	
	private static void addServerPack(@NotNull AddPackFindersEvent event, @NotNull String packName, String displayName) {
		Path resourcePath = ModList.get().getModFileById(XOres.MOD_ID).getFile().findResource(packName);
		PathPackResources.PathResourcesSupplier resourcesSupplier = new PathPackResources.PathResourcesSupplier(resourcePath, false);
		Pack pack = Pack.readMetaAndCreate("builtin/" + packName, Component.literal(displayName), false, resourcesSupplier, PackType.SERVER_DATA, Pack.Position.TOP, PackSource.FEATURE);
		event.addRepositorySource(packConsumer -> packConsumer.accept(pack));
	}
}
