/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.client.renderer.item;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOShieldRenderer extends BlockEntityWithoutLevelRenderer {
	
	private final ResourceLocation shieldTexture;
	private final ShieldModel shieldModel;
	
	public XOShieldRenderer(@NotNull BlockEntityRenderDispatcher renderDispatcher, @NotNull EntityModelSet modelSet, @NotNull ResourceLocation shieldTexture) {
		super(renderDispatcher, modelSet);
		this.shieldTexture = shieldTexture;
		this.shieldModel = new ShieldModel(modelSet.bakeLayer(ModelLayers.SHIELD));
	}
	
	@Override
	public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext context, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int light, int overlay) {
		poseStack.pushPose();
		poseStack.scale(1.0F, -1.0F, -1.0F);
		VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(bufferSource, this.shieldModel.renderType(this.shieldTexture), false, stack.hasFoil());
		this.shieldModel.handle().render(poseStack, vertexConsumer, light, overlay);
		this.shieldModel.plate().render(poseStack, vertexConsumer, light, overlay);
		poseStack.popPose();
	}
}
