package net.luis.xores.common.event;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.Event;

/**
 * extension of {@link Event}, fired after the logic of the related {@link Mixin}
 * 
 * @author Luis-st
 * 
 * @see {@link Event}
 * @see {@link DiggerItemMixinEvent}
 * @see {@link ItemStackMixinEvent}
 * @see {@link SwordItemMixinEvent}
 */

public abstract class MixinEvent extends Event {
	
	/**
	 * the {@link MixinEventInfo} for the event
	 */
	private final MixinEventInfo mixinInfo;
	
	/**
	 * constructor for the {@link MixinEvent}
	 */
	protected MixinEvent(MixinEventInfo mixinInfo) {
		this.mixinInfo = mixinInfo;
	}
	
	
	/**
	 * getter for the mixin event info
	 * @return {@link MixinEvent#mixinInfo}
	 */
	public MixinEventInfo getMixinInfo() {
		return this.mixinInfo;
	}
	
	/**
	 * fired after the mixin logic of {@link DiggerItem#hurtEnemy(ItemStack, LivingEntity, LivingEntity)}
	 * 
	 * @author Luis-st
	 * 
	 * @see {@link XOresEventFactory#onDiggerItemMixin(MixinEventInfo, ItemStack, LivingEntity, LivingEntity)}
	 */
	public static class DiggerItemMixinEvent extends MixinEvent {
		
		/**
		 * the {@link ItemStack} which is used to hurt the enemy
		 */
		private final ItemStack stack;
		
		/**
		 * the target as a {@link LivingEntity}
		 */
		private final LivingEntity target;
		
		/**
		 * the attacker as a {@link LivingEntity}
		 */
		private final LivingEntity attacker;
		
		/**
		 * constructor for the {@link DiggerItemMixinEvent}
		 */
		public DiggerItemMixinEvent(MixinEventInfo mixinInfo, ItemStack stack, LivingEntity target, LivingEntity attacker) {
			super(mixinInfo);
			this.stack = stack;
			this.target = target;
			this.attacker = attacker;
		}
		
		/**
		 * getter for the stack
		 * @return {@link DiggerItemMixinEvent#stack}
		 */
		public ItemStack getStack() {
			return this.stack;
		}
		
		/**
		 * getter for the target
		 * @return {@link DiggerItemMixinEvent#target}
		 */
		public LivingEntity getTarget() {
			return this.target;
		}
		
		/**
		 * getter for the attacker
		 * @return {@link DiggerItemMixinEvent#attacker}
		 */
		public LivingEntity getAttacker() {
			return this.attacker;
		}
		
	}
	
	
	/**
	 * fired after the mixin logic of {@link ItemStack#isCorrectToolForDrops(BlockState)}
	 * 
	 * @author Luis-st
	 * 
	 * @see {@link XOresEventFactory#onItemStackMixin(MixinEventInfo, Item, ItemStack, BlockState)}
	 */
	public static class ItemStackMixinEvent extends MixinEvent {
		
		/**
		 * the {@link Item} of the given {@link ItemStack}
		 */
		private final Item item;
		
		/**
		 * the {@link ItemStack} which is used to mine the given {@link BlockState}
		 */
		private final ItemStack stack;
		
		/**
		 * the {@link BlockState} which is mined
		 */
		private final BlockState state;
		
		/**
		 * constructor for the {@link ItemStackMixinEvent}
		 */
		public ItemStackMixinEvent(MixinEventInfo mixinInfo, Item item, ItemStack stack, BlockState state) {
			super(mixinInfo);
			this.item = item;
			this.stack = stack;
			this.state = state;
		}
		
		/**
		 * getter for the item
		 * @return {@link ItemStackMixinEvent#item}
		 */
		public Item getItem() {
			return this.item;
		}
		
		/**
		 * getter for the stack
		 * @return {@link ItemStackMixinEvent#stack}
		 */
		public ItemStack getStack() {
			return this.stack;
		}
		
		/**
		 * getter for the state
		 * @return {@link ItemStackMixinEvent#state}
		 */
		public BlockState getState() {
			return this.state;
		}
		
	}
	
	/**
	 * fired after the mixin logic of {@link SwordItem#mineBlock(ItemStack, Level, BlockState, BlockPos, LivingEntity)}
	 * 
	 * @author Luis-st
	 * 
	 * @see {@link XOresEventFactory#onSwordItemMixin(MixinEventInfo, ItemStack, Level, BlockState, BlockPos, LivingEntity)}
	 */
	public static class SwordItemMixinEvent extends MixinEvent {
		
		/**
		 * the {@link ItemStack} which is used to mine the given {@link BlockState}
		 */
		private final ItemStack stack;
		
		/**
		 * the {@link Level} where the given {@link BlockState} is mined in
		 */
		private final Level level;
		
		/**
		 * the {@link BlockState} which is mined
		 */
		private final BlockState state;
		
		/**
		 * the {@link BlockPos} where the given {@link BlockState} is mined in the given {@link Level}
		 */
		private final BlockPos pos;
		
		/**
		 * the {@link LivingEntity} which is mine the given {@link BlockState}
		 */
		private final LivingEntity entity;
		
		/**
		 * constructor for the {@link SwordItemMixinEvent}
		 */
		public SwordItemMixinEvent(MixinEventInfo mixinInfo, ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
			super(mixinInfo);
			this.stack = stack;
			this.level = level;
			this.state = state;
			this.pos = pos;
			this.entity = entity;
		}
		
		/**
		 * getter for the stack
		 * @return {@link SwordItemMixinEvent#stack}
		 */
		public ItemStack getStack() {
			return this.stack;
		}
		
		/**
		 * getter for the level
		 * @return {@link SwordItemMixinEvent#level}
		 */
		public Level getLevel() {
			return this.level;
		}
		
		/**
		 * getter for the state
		 * @return {@link SwordItemMixinEvent#state}
		 */
		public BlockState getState() {
			return this.state;
		}
		
		/**
		 * getter for the pos
		 * @return {@link SwordItemMixinEvent#pos}
		 */
		public BlockPos getPos() {
			return this.pos;
		}
		
		/**
		 * getter for the entity
		 * @return {@link SwordItemMixinEvent#entity}
		 */
		public LivingEntity getEntity() {
			return this.entity;
		}
		
	}
	
}
