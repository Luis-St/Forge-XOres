package net.luis.xores.common.item;

import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * extension of {@link ArmorItem} with {@link EquipmentSlot#CHEST} and logic of {@link ElytraItem},<br>
 * used for all mod {@link ElytraChestplateItem}s and the<br> 
 * vanilla additional {@link ElytraChestplateItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link ArmorItem}
 * @see {@link ElytraItem}
 */

public class ElytraChestplateItem extends ArmorItem {

	/**
	 * {@link Map} of all {@link ElytraChestplateItem}s and thier time damage values,<br> 
	 * which are registered in {@link FMLCommonSetupEvent}<br>
	 * <br>
	 * if you want to register your own {@link ElytraChestplateItem} and<br>
	 * it's time damage value, use something like this in {@link FMLCommonSetupEvent}:
	 * <pre> {@code
	 * 	public static void commonSetup(FMLCommonSetupEvent event) {
	 * 		Util.make(ElytraChestplateItem.ELYTRA_TIME_DAMAGE_VALUES, map -> {
	 * 			// register ElytraChestplateItem with thier damage value here
	 * 		});
	 * 	}
	 * } </pre>
	 */
	public static final Map<ElytraChestplateItem, Integer> ELYTRA_TIME_DAMAGE_VALUES = Maps.newHashMap();
	
	/**
	 * system time based random
	 */
	protected static final Random RNG = new Random(System.currentTimeMillis());
	
	/**
	 * constructor for the {@link ElytraChestplateItem}
	 */
	public ElytraChestplateItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.CHEST, properties);
	}
	
	/**
	 * @return the vanilla logic of {@link ElytraItem#isFlyEnabled(ItemStack)}
	 */
	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return ElytraItem.isFlyEnabled(stack);
	}
	
	/**
	 * handle the damage of the {@link ElytraChestplateItem},<br>
	 * based on the flight ticks and<br>
	 * the value which is registered in {@link ElytraChestplateItem#ELYTRA_TIME_DAMAGE_VALUES}
	 */
	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level.isClientSide && (flightTicks + 1) % ELYTRA_TIME_DAMAGE_VALUES.getOrDefault(stack.getItem(), 20) == 0) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
		}
		return true;
	}
	
	/**
	 * @return on of the following {@link SoundEvent}s
	 * <ol>
	 * 	<li>{@link SoundEvents#ARMOR_EQUIP_ELYTRA}</li>
	 * 	<li>the sound of the {@link ElytraChestplateItem#getMaterial()} </li>
	 * </ol>
	 */
	@Override
	public SoundEvent getEquipSound() {
		return RNG.nextInt(2) == 0 ? SoundEvents.ARMOR_EQUIP_ELYTRA : super.getEquipSound();
	}
	
}
