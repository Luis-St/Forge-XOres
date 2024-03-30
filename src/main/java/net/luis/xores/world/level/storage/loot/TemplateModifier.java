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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class TemplateModifier extends LootModifier {
	
	public static final Codec<TemplateModifier> CODEC = RecordCodecBuilder.create((instance) -> {
		return LootModifier.codecStart(instance).and(instance.group(ForgeRegistries.ITEMS.getCodec().fieldOf("template").forGetter(modifier -> {
			return modifier.template;
		}), Codec.DOUBLE.fieldOf("chance").forGetter(modifier -> {
			return modifier.chance;
		}))).apply(instance, TemplateModifier::new);
	});
	
	private final Item template;
	private final double chance;
	
	public TemplateModifier(LootItemCondition[] lootConditions, Item template, double chance) {
		super(lootConditions);
		this.template = template;
		this.chance = chance;
	}
	
	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return XOGlobalLootModifiers.TEMPLATE_MODIFIER.get();
	}
	
	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
		if (this.chance > context.getRandom().nextDouble()) {
			generatedLoot.add(new ItemStack(this.template));
		}
		return generatedLoot;
	}
}
