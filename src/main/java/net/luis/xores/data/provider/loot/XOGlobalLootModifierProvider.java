package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOItemTags;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
import net.luis.xores.world.level.storage.loot.XOGlobalLootModifiers;
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

public class XOGlobalLootModifierProvider extends GlobalLootModifierProvider {
	
	public XOGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}
	
	@Override
	protected void start() {
		this.add("smelting_modifier", XOGlobalLootModifiers.SMELTING_MODIFIER.get(), new SmeltingModifier(new LootItemCondition[] {
			MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOItemTags.BLAZING)).build()
		}));
	}
	
	@Override
	public String getName() {
		return "XOres Global Loot Modifiers";
	}

}
