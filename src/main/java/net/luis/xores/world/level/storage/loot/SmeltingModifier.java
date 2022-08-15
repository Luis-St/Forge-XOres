package net.luis.xores.world.level.storage.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * 
 * @author Luis-st
 *
 */

public class SmeltingModifier extends LootModifier {
	
	public static final Codec<SmeltingModifier> CODEC = RecordCodecBuilder.create((instance) -> {
		return LootModifier.codecStart(instance).apply(instance, SmeltingModifier::new);
	});
	
	public SmeltingModifier(LootItemCondition[] lootCondition) {
		super(lootCondition);
	}
	
	@Override
	public Codec<SmeltingModifier> codec() {
		return XOGlobalLootModifiers.SMELTING_MODIFIER.get();
	}
	
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ObjectArrayList<ItemStack> loot = new ObjectArrayList<>();
		generatedLoot.forEach(stack -> {
			loot.add(SmeltingModifier.this.smelt(stack, context));
		});
		return loot;
	}
	
	private ItemStack smelt(ItemStack stack, LootContext context) {
		return context.getLevel().getRecipeManager()
				.getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
				.map(SmeltingRecipe::getResultItem).filter(itemStack -> !itemStack.isEmpty())
				.map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
				.orElse(stack);
	}
	
}
