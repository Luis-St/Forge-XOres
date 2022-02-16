package net.luis.xores.client.render.layer;

import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * extension of {@link ElytraLayer},<br>
 * used to render the mod {@link ElytraChestplateItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link ElytraChestplateItem}
 * @see {@link ModItems}
 */

public class ModElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

	/**
	 * the related {@link ElytraItem} or {@link ElytraChestplateItem}
	 */
	protected final Item elytraItem;
	
	/**
	 * the texture of the elytra as a {@link ResourceLocation}
	 */
	protected final ResourceLocation elytraTexture;
	
	/**
	 * constructor for the {@link ModElytraLayer}
	 */
	public ModElytraLayer(RenderLayerParent<T, M> renderParent, EntityModelSet modelSet, Item elytraItem, ResourceLocation elytraTexture) {
		super(renderParent, modelSet);
		this.elytraItem = elytraItem;
		this.elytraTexture = elytraTexture;
	}
	
	/**
	 * render the elytra layer,<br>
	 * only if the player wears it in {@link EquipmentSlot#CHEST}
	 */
	@Override
	public boolean shouldRender(ItemStack stack, T entity) {
		return this.elytraItem == stack.getItem();
	}
	
	/**
	 * getter for the {@link ModElytraLayer#elytraTexture}
	 */
	@Override
	public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		return this.elytraTexture;
	}
	
}
