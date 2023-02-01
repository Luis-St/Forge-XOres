package net.luis.xores.client.renderer.entity.layers;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * 
 * @author Luis-st
 * 
 */

public class XOElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends ElytraLayer<T, M> {
	
	private final Item elytraItem;
	private final ResourceLocation elytraTexture;
	
	public XOElytraLayer(RenderLayerParent<T, M> renderParent, EntityModelSet modelSet, Item elytraItem, ResourceLocation elytraTexture) {
		super(renderParent, modelSet);
		this.elytraItem = elytraItem;
		this.elytraTexture = elytraTexture;
	}
	
	@Override
	public boolean shouldRender(ItemStack stack, @NotNull T entity) {
		return this.elytraItem == stack.getItem();
	}
	
	@Override
	public @NotNull ResourceLocation getElytraTexture(@NotNull ItemStack stack, @NotNull T entity) {
		return this.elytraTexture;
	}
	
}
