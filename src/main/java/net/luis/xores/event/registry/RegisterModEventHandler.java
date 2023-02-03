package net.luis.xores.event.registry;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 *
 * @author Luis-st
 *
 */

@Mod.EventBusSubscriber(modid = XOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterModEventHandler {
	
	@SubscribeEvent
	public static void register(CreativeModeTabEvent.Register event) {
		event.registerCreativeModeTab(new ResourceLocation(XOres.MOD_ID, XOres.MOD_ID), builder -> {
			builder.title(Component.translatable("item_tab.xores"));
			builder.icon(() -> new ItemStack(XOItems.LIMONITE_PICKAXE.get()));
			builder.displayItems((enabledFlags, populator, hasPermissions) -> {
				populator.accept(XOBlocks.JADE_ORE.get());
				populator.accept(XOBlocks.DEEPSLATE_JADE_ORE.get());
				populator.accept(XOBlocks.JADE_BLOCK.get());
				populator.accept(XOItems.JADE_INGOT.get());
				populator.accept(XOItems.JADE_SWORD.get());
				populator.accept(XOItems.JADE_PICKAXE.get());
				populator.accept(XOItems.JADE_AXE.get());
				populator.accept(XOItems.JADE_SHOVEL.get());
				populator.accept(XOItems.JADE_HOE.get());
				populator.accept(XOItems.JADE_HELMET.get());
				populator.accept(XOItems.JADE_CHESTPLATE.get());
				populator.accept(XOItems.JADE_LEGGINGS.get());
				populator.accept(XOItems.JADE_BOOTS.get());
				
				populator.accept(XOItems.BLAZING_INGOT.get());
				populator.accept(XOItems.BLAZING_SWORD.get());
				populator.accept(XOItems.JADE_INGOT.get());
				populator.accept(XOItems.BLAZING_PICKAXE.get());
				populator.accept(XOItems.BLAZING_AXE.get());
				populator.accept(XOItems.BLAZING_SHOVEL.get());
				populator.accept(XOItems.BLAZING_HOE.get());
				populator.accept(XOItems.BLAZING_HELMET.get());
				populator.accept(XOItems.BLAZING_CHESTPLATE.get());
				populator.accept(XOItems.BLAZING_LEGGINGS.get());
				populator.accept(XOItems.BLAZING_BOOTS.get());
				
				populator.accept(XOBlocks.SAPHIRE_ORE.get());
				populator.accept(XOBlocks.DEEPSLATE_SAPHIRE_ORE.get());
				populator.accept(XOBlocks.SAPHIRE_BLOCK.get());
				populator.accept(XOItems.SAPHIRE_INGOT.get());
				populator.accept(XOItems.SAPHIRE_SWORD.get());
				populator.accept(XOItems.SAPHIRE_SHIELD.get());
				populator.accept(XOItems.SAPHIRE_PICKAXE.get());
				populator.accept(XOItems.SAPHIRE_AXE.get());
				populator.accept(XOItems.SAPHIRE_SHOVEL.get());
				populator.accept(XOItems.SAPHIRE_HELMET.get());
				populator.accept(XOItems.SAPHIRE_CHESTPLATE.get());
				populator.accept(XOItems.SAPHIRE_LEGGINGS.get());
				populator.accept(XOItems.SAPHIRE_BOOTS.get());
				
				populator.accept(XOBlocks.LIMONITE_ORE.get());
				populator.accept(XOBlocks.DEEPSLATE_LIMONITE_ORE.get());
				populator.accept(XOBlocks.LIMONITE_BLOCK.get());
				populator.accept(XOItems.LIMONITE_INGOT.get());
				populator.accept(XOItems.LIMONITE_SWORD.get());
				populator.accept(XOItems.LIMONITE_PICKAXE.get());
				populator.accept(XOItems.LIMONITE_AXE.get());
				populator.accept(XOItems.LIMONITE_SHOVEL.get());
				populator.accept(XOItems.LIMONITE_HOE.get());
				populator.accept(XOItems.LIMONITE_HELMET.get());
				populator.accept(XOItems.LIMONITE_CHESTPLATE.get());
				populator.accept(XOItems.LIMONITE_LEGGINGS.get());
				populator.accept(XOItems.LIMONITE_BOOTS.get());
				
				populator.accept(XOItems.ROSE_QUARTZ.get());
				populator.accept(XOItems.POLISHED_ROSE_QUARTZ.get());
				populator.accept(XOItems.ROSE_QUARTZ_SWORD.get());
				populator.accept(XOItems.ROSE_QUARTZ_PICKAXE.get());
				populator.accept(XOItems.ROSE_QUARTZ_AXE.get());
				populator.accept(XOItems.ROSE_QUARTZ_SHOVEL.get());
				populator.accept(XOItems.ROSE_QUARTZ_HOE.get());
				
				populator.accept(XOBlocks.ENDERITE_ORE.get());
				populator.accept(XOBlocks.ENDERITE_BLOCK.get());
				populator.accept(XOItems.ENDERITE_SCRAP.get());
				populator.accept(XOItems.ENDERITE_INGOT.get());
				populator.accept(XOItems.ENDERITE_SWORD.get());
				populator.accept(XOItems.ENDERITE_SHIELD.get());
				populator.accept(XOItems.ENDERITE_BOW.get());
				populator.accept(XOItems.ENDERITE_CROSSBOW.get());
				populator.accept(XOItems.ENDERITE_PICKAXE.get());
				populator.accept(XOItems.ENDERITE_AXE.get());
				populator.accept(XOItems.ENDERITE_SHOVEL.get());
				populator.accept(XOItems.ENDERITE_HOE.get());
				populator.accept(XOItems.ENDERITE_HELMET.get());
				populator.accept(XOItems.ENDERITE_CHESTPLATE.get());
				populator.accept(XOItems.ENDERITE_ELYTRA_CHESTPLATE.get());
				populator.accept(XOItems.ENDERITE_LEGGINGS.get());
				populator.accept(XOItems.ENDERITE_BOOTS.get());
				
				populator.accept(XOItems.STEEL_INGOT.get());
				populator.accept(XOItems.STEEL_SWORD.get());
				populator.accept(XOItems.STEEL_PICKAXE.get());
				populator.accept(XOItems.STEEL_AXE.get());
				populator.accept(XOItems.STEEL_SHOVEL.get());
				populator.accept(XOItems.STEEL_HOE.get());
				
				populator.accept(XOItems.NIGHT_SCRAP.get());
				populator.accept(XOItems.NIGHT_INGOT.get());
				populator.accept(XOItems.NIGHT_SWORD.get());
				populator.accept(XOItems.NIGHT_SHIELD.get());
				populator.accept(XOItems.NIGHT_BOW.get());
				populator.accept(XOItems.NIGHT_CROSSBOW.get());
				populator.accept(XOItems.NIGHT_PICKAXE.get());
				populator.accept(XOItems.NIGHT_AXE.get());
				populator.accept(XOItems.NIGHT_SHOVEL.get());
				populator.accept(XOItems.NIGHT_HOE.get());
				populator.accept(XOItems.NIGHT_HELMET.get());
				populator.accept(XOItems.NIGHT_CHESTPLATE.get());
				populator.accept(XOItems.NIGHT_ELYTRA_CHESTPLATE.get());
				populator.accept(XOItems.NIGHT_LEGGINGS.get());
				populator.accept(XOItems.NIGHT_BOOTS.get());
			});
		});
	}
	
	@SubscribeEvent
	public void buildContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.COMBAT) {
			event.accept(XOItems.GOLDEN_SHIELD.get());
			event.accept(XOItems.COPPER_SHIELD.get());
			event.accept(XOItems.IRON_SHIELD.get());
			event.accept(XOItems.DIAMOND_SHIELD.get());
			event.accept(XOItems.NETHERITE_SHIELD.get());
			event.accept(XOItems.DIAMOND_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_ELYTRA_CHESTPLATE.get());
			event.accept(XOItems.NETHERITE_BOW.get());
			event.accept(XOItems.NETHERITE_CROSSBOW.get());
		}
	}
	
}
