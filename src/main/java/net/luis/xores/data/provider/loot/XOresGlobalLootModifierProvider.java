package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.common.loot.SmeltingModifier;
import net.luis.xores.data.OnGatherDataEvent;
import net.luis.xores.init.XOresGlobalLootModifiers;
import net.luis.xores.init.XOresTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

/**
 * extension of {@link GlobalLootModifierProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the loot modifiers for all mod {@link LootXOresifier}s
 * 
 * @author Luis-st
 * 
 * @see {@link GlobalLootModifierProvider}
 * @see {@link OnGatherDataEvent}
 * @see {@link XOresGlobalLootXOresifiers}
 */

public class XOresGlobalLootModifierProvider extends GlobalLootModifierProvider {

	/**
	 * constructor for the {@link XOresGlobalLootModifierProvider}
	 */
	public XOresGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}

	/**
	 * register all {@link LootModifier}s for {@link XOresGlobalLootModifiers#LOOT_MODIFIERS}
	 */
	@Override
	protected void start() {
		this.add("smelting", XOresGlobalLootModifiers.SMELTING_MODIFIER.get(), new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOresTags.Items.BLAZING)).build()
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
