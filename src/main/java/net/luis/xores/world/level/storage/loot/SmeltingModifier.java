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

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;

/**
 *
 * @author Luis-St
 *
 */

public class SmeltingModifier extends LootModifier {
	
	private static final Method RECIPE_RESULT;
	public static final MapCodec<SmeltingModifier> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
		return LootModifier.codecStart(instance).apply(instance, SmeltingModifier::new);
	});
	
	public SmeltingModifier(LootItemCondition @NotNull [] lootConditions) {
		super(lootConditions);
	}
	
	private static @NotNull ItemStack getRecipeResult(@NotNull SingleItemRecipe recipe) {
		try {
			return (ItemStack) RECIPE_RESULT.invoke(recipe);
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public @NotNull MapCodec<SmeltingModifier> codec() {
		return XOGlobalLootModifiers.SMELTING_MODIFIER.get();
	}
	
	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(@NotNull LootTable table, @NotNull ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
		ObjectArrayList<ItemStack> loot = new ObjectArrayList<>();
		generatedLoot.forEach(stack -> loot.add(this.smelt(stack, context)));
		return loot;
	}
	
	private @NotNull ItemStack smelt(@NotNull ItemStack stack, @NotNull LootContext context) {
		return context.getLevel().recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(stack), context.getLevel())
			.map(recipe -> getRecipeResult(recipe.value()))
			.filter(itemStack -> !itemStack.isEmpty())
			.map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
			.orElse(stack);
	}
	
	static  {
		RECIPE_RESULT = ObfuscationReflectionHelper.findMethod(SingleItemRecipe.class, "result");
	}
}
