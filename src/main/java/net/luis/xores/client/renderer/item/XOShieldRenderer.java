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
 * @author Luis-st
 *
 */

public class XOShieldRenderer extends BlockEntityWithoutLevelRenderer {
	
	private final ResourceLocation shieldTexture;
	private final ShieldModel shieldModel;
	
	public XOShieldRenderer(BlockEntityRenderDispatcher renderDispatcher, EntityModelSet modelSet, ResourceLocation shieldTexture) {
		super(renderDispatcher, modelSet);
		this.shieldTexture = shieldTexture;
		this.shieldModel = new ShieldModel(modelSet.bakeLayer(ModelLayers.SHIELD));
	}
	
	@Override
	public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext context, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int light, int overlay) {
		poseStack.pushPose();
		poseStack.scale(1.0F, -1.0F, -1.0F);
		VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(bufferSource, this.shieldModel.renderType(this.shieldTexture), true, stack.hasFoil());
		this.shieldModel.handle().render(poseStack, vertexconsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
		this.shieldModel.plate().render(poseStack, vertexconsumer, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}
}
