package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOresItemTags;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
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
 * used to generate the loot modifiers for all mod {@link LootModifier}s
 * 
 * @author Luis-st
 */

public class XOresGlobalLootModifierProvider extends GlobalLootModifierProvider {

	/**
	 * constructor for the {@link XOresGlobalLootModifierProvider}
	 */
	public XOresGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}

	/**
	 * register all mod {@link LootModifier}s
	 */
	@Override
	protected void start() {
		this.add("smelting", new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOresItemTags.BLAZING)).build()
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
