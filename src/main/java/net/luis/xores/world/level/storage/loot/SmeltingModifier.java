package net.luis.xores.world.level.storage.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.luis.xores.tags.XOresItemTags;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * extension of {@link SmeltingModifier}, used to replace the {@link Block} drop<br>
 * if the Block is mined with a {@link XOresItemTags#BLAZING} Tool
 * 
 * @author Luis-st
 * 
 * @see {@link SmeltingModifier}
 * @see {@link XOresItemTags}
 */

public class SmeltingModifier extends LootModifier {
	
	/**
	 * {@link Codec} for the {@link SmeltingModifier}
	 */
	public static final Codec<SmeltingModifier> CODEC = RecordCodecBuilder.create((instance) -> {
		return LootModifier.codecStart(instance).apply(instance, SmeltingModifier::new);
	});
	
	/**
	 * constructor for the {@link SmeltingModifier}
	 */
	public SmeltingModifier(LootItemCondition[] lootCondition) {
		super(lootCondition);
	}
	
	@Override
	public Codec<SmeltingModifier> codec() {
		return XOresGlobalLootModifiers.SMELTING_MODIFIER.get();
	}
	
	/**
	 * apply the loot modifier to loot table
	 */
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		ObjectArrayList<ItemStack> loot = new ObjectArrayList<>();
		generatedLoot.forEach(stack -> {
			loot.add(SmeltingModifier.this.smelt(stack, context));
		});
		return loot;
	}
	
	/**
	 * @return the smelting recipe result or as fallback the given {@link ItemStack}
	 */
	protected ItemStack smelt(ItemStack stack, LootContext context) {
		return context.getLevel().getRecipeManager()
				.getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
				.map(SmeltingRecipe::getResultItem).filter(itemStack -> !itemStack.isEmpty())
				.map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
				.orElse(stack);
	}
	
}
