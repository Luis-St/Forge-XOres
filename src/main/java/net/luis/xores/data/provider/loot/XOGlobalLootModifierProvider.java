package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOItemTags;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-st
 *
 */

public class XOGlobalLootModifierProvider extends GlobalLootModifierProvider {
	
	public XOGlobalLootModifierProvider(DataGenerator generator) {
		super(generator.getPackOutput(), XOres.MOD_ID);
	}
	
	@Override
	protected void start() {
		this.add("smelting_modifier", new SmeltingModifier(new LootItemCondition[] {
				MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOItemTags.BLAZING)).build()
		}));
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Global Loot Modifiers";
	}
	
}
