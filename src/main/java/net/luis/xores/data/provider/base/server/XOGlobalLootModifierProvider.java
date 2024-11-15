/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.data.provider.base.server;

import net.luis.xores.XOres;
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.storage.loot.SmeltingModifier;
import net.luis.xores.world.level.storage.loot.TemplateModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

/**
 *
 * @author Luis-St
 *
 */

public class XOGlobalLootModifierProvider extends GlobalLootModifierProvider {
	
	public XOGlobalLootModifierProvider(@NotNull DataGenerator generator, @NotNull CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(generator.getPackOutput(), XOres.MOD_ID, lookupProvider);
	}
	
	@Override
	protected void start(HolderLookup.@NotNull Provider lookup) {
		HolderGetter<Item> items = lookup.lookupOrThrow(Registries.ITEM);
		this.add("smelting_modifier", new SmeltingModifier(new LootItemCondition[] {
			MatchTool.toolMatches(ItemPredicate.Builder.item().of(items, XOItems.BLAZING_SWORD.get(), XOItems.BLAZING_PICKAXE.get(), XOItems.BLAZING_AXE.get(), XOItems.BLAZING_SHOVEL.get(), XOItems.BLAZING_HOE.get())).build()
		}));
		this.add("template_modifier", new TemplateModifier(new LootItemCondition[] {
			LootTableIdCondition.builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build()
		}, XOItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), 0.1));
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Global Loot Modifiers";
	}
}
