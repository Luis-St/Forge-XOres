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

package net.luis.xores.world.level.storage.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class SmeltingModifier extends LootModifier {
	
	public static final Codec<SmeltingModifier> CODEC = RecordCodecBuilder.create((instance) -> {
		return LootModifier.codecStart(instance).apply(instance, SmeltingModifier::new);
	});
	
	public SmeltingModifier(LootItemCondition[] lootConditions) {
		super(lootConditions);
	}
	
	@Override
	public Codec<SmeltingModifier> codec() {
		return XOGlobalLootModifiers.SMELTING_MODIFIER.get();
	}
	
	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ObjectArrayList<ItemStack> loot = new ObjectArrayList<>();
		generatedLoot.forEach(stack -> loot.add(this.smelt(stack, context)));
		return loot;
	}
	
	private @NotNull ItemStack smelt(ItemStack stack, @NotNull LootContext context) {
		return context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel()).map(recipe -> recipe.value().getResultItem(context.getLevel().registryAccess()))
			.filter(itemStack -> !itemStack.isEmpty()).map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount())).orElse(stack);
	}
}
