package net.luis.xores.world.item;

import com.google.common.collect.Maps;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Random;

/**
 *
 * @author Luis-St
 *
 */

public class ElytraChestplateItem extends ArmorItem {
	
	private static final Map<ElytraChestplateItem, Integer> ELYTRA_TIME_DAMAGE_VALUES = Maps.newHashMap();
	private static final Random RNG = new Random(System.currentTimeMillis());
	
	public ElytraChestplateItem(ArmorMaterial material, Properties properties) {
		super(material, Type.CHESTPLATE, properties);
	}
	
	public static void register(ElytraChestplateItem elytraChestplate, int damageValue) {
		ELYTRA_TIME_DAMAGE_VALUES.put(elytraChestplate, damageValue);
	}
	
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return ElytraItem.isFlyEnabled(stack);
	}
	
	@Override
	public boolean elytraFlightTick(ItemStack stack, @NotNull LivingEntity entity, int flightTicks) {
		if (!entity.level().isClientSide && (flightTicks + 1) % ELYTRA_TIME_DAMAGE_VALUES.getOrDefault(this, 20) == 0) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
		}
		return true;
	}
	
	@Override
	public @NotNull SoundEvent getEquipSound() {
		return RNG.nextInt(2) == 0 ? SoundEvents.ARMOR_EQUIP_ELYTRA : super.getEquipSound();
	}
}
