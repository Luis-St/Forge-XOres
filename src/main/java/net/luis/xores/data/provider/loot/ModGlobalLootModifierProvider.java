package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.common.loot.SmeltingModifier;
import net.luis.xores.data.OnGatherDataEvent;
import net.luis.xores.init.ModGlobalLootModifiers;
import net.luis.xores.init.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * extension of {@link GlobalLootModifierProvider},<br>
 * called by {@link GatherDataEvent},<br>
 * used to generate the loot modifiers for all mod {@link LootModifier}s
 * 
 * @author Luis-st
 * 
 * @see {@link GlobalLootModifierProvider}
 * @see {@link OnGatherDataEvent}
 * @see {@link ModGlobalLootModifiers}
 */

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

	/**
	 * constructor for the {@link ModGlobalLootModifierProvider}
	 */
	public ModGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}

	/**
	 * register all {@link GlobalLootModifier}s
	 */
	@Override
	protected void start() {
		add("smelting", ModGlobalLootModifiers.SMELTING_MODIFIER.get(), new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.BLAZING)).build()
		}));
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Global Loot Modifiers";
	}

}
