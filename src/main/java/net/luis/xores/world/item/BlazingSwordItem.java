package net.luis.xores.world.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

/**
 *
 * @author Luis-St
 *
 */

public class BlazingSwordItem extends SwordItem {
	
	private static final Random RNG = new Random(System.currentTimeMillis());
	
	public BlazingSwordItem(Tier tier, int additionalDamage, float attackSpeed, Properties properties) {
		super(tier, additionalDamage, attackSpeed, properties);
	}
	
	@Override
	public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
		if (!target.fireImmune()) {
			target.setSecondsOnFire(RNG.nextInt(5) + 2);
		}
		return super.hurtEnemy(stack, target, attacker);
	}
}
