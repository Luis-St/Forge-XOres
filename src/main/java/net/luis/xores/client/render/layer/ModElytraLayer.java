package net.luis.xores.client.render.layer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {

	protected final Item elytraItem;
	protected final ResourceLocation elytraTexture;
	
	public ModElytraLayer(RenderLayerParent<T, M> renderParent, EntityModelSet modelSet, Item elytraItem, ResourceLocation elytraTexture) {
		super(renderParent, modelSet);
		this.elytraItem = elytraItem;
		this.elytraTexture = elytraTexture;
	}
	
	@Override
	public boolean shouldRender(ItemStack stack, T entity) {
		return this.elytraItem == stack.getItem();
	}
	
	@Override
	public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		return this.elytraTexture;
	}
	
}
