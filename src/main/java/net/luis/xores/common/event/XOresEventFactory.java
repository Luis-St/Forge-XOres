package net.luis.xores.common.event;

import net.luis.xores.common.event.MixinEvent.DiggerItemMixinEvent;
import net.luis.xores.common.event.MixinEvent.ItemStackMixinEvent;
import net.luis.xores.common.event.MixinEvent.SwordItemMixinEvent;
import net.luis.xores.mixin.DiggerItemMixin;
import net.luis.xores.mixin.ItemStackMixin;
import net.luis.xores.mixin.SwordItemMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;

/**
 * factory for all xores {@link Event}s
 * 
 * @author Luis-st
 * 
 * @see {@link Event}
 * @see {@link MixinEvent}
 */

public class XOresEventFactory {
	
	/**
	 * fires the {@link DiggerItemMixinEvent}
	 * @param mixinInfo The {@link MixinEventInfo} for the event
	 * @param stack The {@link ItemStack} which is used to hurt the enemy
	 * @param target The target as a {@link LivingEntity}
	 * @param attacker the attacker as a {@link LivingEntity}
	 * 
	 * @see {@link DiggerItemMixinEvent}
	 * @see {@link DiggerItemMixin#hurtEnemy(ItemStack, LivingEntity, LivingEntity, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable)}
	 */
	public static void onDiggerItemMixin(MixinEventInfo mixinInfo, ItemStack stack, LivingEntity target, LivingEntity attacker) {
		MinecraftForge.EVENT_BUS.post(new MixinEvent.DiggerItemMixinEvent(mixinInfo, stack, target, attacker));
	}
	
	/**
	 * fires the {@link ItemStackMixinEvent}
	 * @param mixinInfo The {@link MixinEventInfo} for the event
	 * @param item The {@link Item} of the given {@link ItemStack}
	 * @param stack The {@link ItemStack} which is used to mine the given {@link BlockState}
	 * @param state The {@link BlockState} which is mined
	 * 
	 * @see {@link ItemStackMixinEvent}
	 * @see {@link ItemStackMixin#isCorrectToolForDrops(BlockState, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable)}
	 */
	public static void onItemStackMixin(MixinEventInfo mixinInfo, Item item, ItemStack stack, BlockState state) {
		MinecraftForge.EVENT_BUS.post(new MixinEvent.ItemStackMixinEvent(mixinInfo, item, stack, state));
	}
	
	/**
	 * fires the {@link SwordItemMixinEvent}
	 * @param mixinInfo The {@link MixinEventInfo} for the event
	 * @param stack The {@link ItemStack} which is used to mine the given {@link BlockState}
	 * @param level The {@link Level} where the given {@link BlockState} is mined in
	 * @param state The {@link BlockState} which is mined
	 * @param pos The {@link BlockPos} where the given {@link BlockState} is mined in the given {@link Level}
	 * @param entity The {@link LivingEntity} which is mine the given {@link BlockState}
	 * 
	 * @see {@link SwordItemMixinEvent}
	 * @see {@link SwordItemMixin#mineBlock(ItemStack, Level, BlockState, BlockPos, LivingEntity, org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable)}
	 */
	public static void onSwordItemMixin(MixinEventInfo mixinInfo, ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
		MinecraftForge.EVENT_BUS.post(new MixinEvent.SwordItemMixinEvent(mixinInfo, stack, level, state, pos, entity));
	}
	
}
