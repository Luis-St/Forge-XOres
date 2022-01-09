package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.common.loot.SmeltingModifier;
import net.luis.xores.init.ModGlobalLootModifiers;
import net.luis.xores.init.ModTags;
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

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

	public ModGlobalLootModifierProvider(DataGenerator generator) {
		super(generator, XOres.MOD_ID);
	}

	/**
	 * registration of all GlobalLootModifiers
	 */
	@Override
	protected void start() {
		add("smelting", ModGlobalLootModifiers.SMELTING_MODIFIER.get(), new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(ModTags.Items.BLAZING)).build()
		}));
	}
	
	@Override
	public String getName() {
		return "XOres Global Loot Modifiers";
	}

}
