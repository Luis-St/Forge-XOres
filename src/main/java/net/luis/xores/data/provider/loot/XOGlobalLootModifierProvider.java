package net.luis.xores.data.provider.loot;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOItemTags;
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
import net.luis.xores.world.level.storage.loot.TemplateModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOGlobalLootModifierProvider extends GlobalLootModifierProvider {
	
	public XOGlobalLootModifierProvider(@NotNull DataGenerator generator) {
		super(generator.getPackOutput(), XOres.MOD_ID);
	}
	
	@Override
	protected void start() {
		this.add("smelting_modifier", new SmeltingModifier(new LootItemCondition[] {
			MatchTool.toolMatches(ItemPredicate.Builder.item().of(XOItemTags.BLAZING)).build()
		}));
		this.add("template_modifier", new TemplateModifier(new LootItemCondition[] {
			LootTableIdCondition.builder(new ResourceLocation("chests/end_city_treasure")).build()
		}, XOItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), 0.1));
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Global Loot Modifiers";
	}
}
