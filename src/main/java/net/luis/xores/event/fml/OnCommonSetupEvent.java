package net.luis.xores.event.fml;

import java.util.List;

import net.luis.xores.XOres;
import net.luis.xores.common.enums.ModTiers;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = XOres.MOD_ID, bus = Bus.MOD)
public class OnCommonSetupEvent {
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		Util.make(ElytraChestplateItem.ELYTRA_DAMAGE_VALUES, map -> {
			map.put(ModItems.DIAMOND_ELYTRA_CHESTPLATE.get(), 40);
			map.put(ModItems.NETHERITE_ELYTRA_CHESTPLATE.get(), 60);
			map.put(ModItems.ENDERITE_ELYTRA_CHESTPLATE.get(), 80);
			map.put(ModItems.NIGHT_ELYTRA_CHESTPLATE.get(), 100);
		});
		replaceAttributeValue((RangedAttribute) Attributes.ARMOR, 512.0);
		replaceAttributeValue((RangedAttribute) Attributes.KNOCKBACK_RESISTANCE, 64.0);
		registerModTiers();
	}
	
	protected static void replaceAttributeValue(RangedAttribute attribute, double maxValue) {
		attribute.maxValue = maxValue;
	}
	
	protected static void registerModTiers() {
		var stone = new ResourceLocation("stone");
		var jade = ModTiers.JADE.getName();
		var iron = new ResourceLocation("iron");
		var blazing = ModTiers.BLAZING.getName();
		var diamond = new ResourceLocation("diamond");
		var saphire = ModTiers.SAPHIRE.getName();
		var netherite = new ResourceLocation("netherite");
		var limonite = ModTiers.LIMONITE.getName();
		var rosite = ModTiers.ROSITE.getName();
		var roseQuartz = ModTiers.ROSE_QUARTZ.getName();
		var enderite = ModTiers.ENDERITE.getName();
		var steel = ModTiers.STEEL.getName();
		var night = ModTiers.NIGHT.getName();
		TierSortingRegistry.registerTier(ModTiers.JADE, jade, List.of(stone), List.of(iron));
		TierSortingRegistry.registerTier(ModTiers.BLAZING, blazing, List.of(iron), List.of(diamond));
		TierSortingRegistry.registerTier(ModTiers.SAPHIRE, saphire, List.of(diamond), List.of(netherite));
		TierSortingRegistry.registerTier(ModTiers.ROSITE, rosite, List.of(netherite), List.of(roseQuartz));
		TierSortingRegistry.registerTier(ModTiers.ROSE_QUARTZ, roseQuartz, List.of(rosite), List.of(limonite));
		TierSortingRegistry.registerTier(ModTiers.LIMONITE, limonite, List.of(roseQuartz), List.of(enderite));
		TierSortingRegistry.registerTier(ModTiers.ENDERITE, enderite, List.of(limonite), List.of(night));
		TierSortingRegistry.registerTier(ModTiers.NIGHT, night, List.of(enderite), List.of(steel));
		TierSortingRegistry.registerTier(ModTiers.STEEL, steel, List.of(night), List.of());
	}
	
}
