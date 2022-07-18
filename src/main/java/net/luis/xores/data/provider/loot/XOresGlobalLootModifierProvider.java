package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOresItemTags;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresGlobalLootModifierProvider extends GlobalLootModifierProvider {
	
	public XOresGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}
	
	@Override
	protected void start() {
		this.add("smelting_modifier", new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOresItemTags.BLAZING)).build()
		}));
	}
	
	@Override
	public String getName() {
		return "XOres Global Loot Modifiers";
	}

}
