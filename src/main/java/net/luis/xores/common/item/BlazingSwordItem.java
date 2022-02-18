package net.luis.xores.common.item;

import java.util.Random;

import net.luis.xores.init.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/**
 * extension of {@link SwordItem}, used for {@link ModItems#BLAZING_SWORD}
 * 
 * @author Luis-st
 * 
 * @see {@link SwordItem}
 * @see {@link ModItems}
 */

public class BlazingSwordItem extends SwordItem {

	/**
	 * system time based random
	 */
	protected static final Random RNG = new Random(System.currentTimeMillis());
	
	/**
	 * constructor for the {@link BlazingSwordItem}
	 */
	public BlazingSwordItem(Tier tier, int additionalDamage, float attackSpeed, Properties properties) {
		super(tier, additionalDamage, attackSpeed, properties);
	}
	
	/**
	 * sets the target for 2-7 seconds into fire, if {@link LivingEntity#fireImmune()} retruns {@code false}
	 */
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!target.fireImmune()) {
			target.setSecondsOnFire(RNG.nextInt(5) + 2);
		}
		return super.hurtEnemy(stack, target, attacker);
	}
	
}
