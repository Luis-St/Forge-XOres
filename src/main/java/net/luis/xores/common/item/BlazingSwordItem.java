package net.luis.xores.common.item;

import java.util.Random;

import net.luis.xores.init.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/**
 * 
 * @author Luis-st
 *
 */

public class BlazingSwordItem extends SwordItem {

	protected static final Random RNG = new Random(System.currentTimeMillis());
	
	public BlazingSwordItem(Tier tier, int additionalDamage, float attackSpeed, Properties properties) {
		super(tier, additionalDamage, attackSpeed, properties);
	}
	
	/**
	 * set the target for 2 until 7 seconds into fire,
	 * when hurting a Entity with the {@link ModItems#BLAZING_SWORD}
	 */
	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!target.fireImmune()) {
			target.setSecondsOnFire(RNG.nextInt(5) + 2);
		}
		return super.hurtEnemy(stack, target, attacker);
	}

}
