package net.luis.xores.common.item.modded;

import net.luis.xores.common.fixer.ToolFixer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;

public class ModShovelItem extends ShovelItem {

	public ModShovelItem(Tier tier, float additionalDamage, float attackSpeed, Properties properties) {
		super(tier, additionalDamage, attackSpeed, properties);
	}
	
	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		return ToolFixer.INSTANCE.isCorrectToolForDrops(this, null, state);
	}
	
	@Override
	public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
		return ToolFixer.INSTANCE.isCorrectToolForDrops(this, stack, state);
	}

}
