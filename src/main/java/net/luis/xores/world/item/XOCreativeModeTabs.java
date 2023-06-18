package net.luis.xores.world.item;

import net.luis.xores.XOres;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 *
 * @author Luis-St
 *
 */

public class XOCreativeModeTabs {
	
	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XOres.MOD_ID);
	
	public static final RegistryObject<CreativeModeTab> TAB = TABS.register("tab", () -> {
		return CreativeModeTab.builder().title(Component.translatable("item_tab.xores")).icon(() -> {
			return new ItemStack(XOItems.LIMONITE_PICKAXE.get());
		}).displayItems((parameters, populator) -> {
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
		}).build();
	});
}
