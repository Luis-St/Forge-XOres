package net.luis.xores.client.gui.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

/**
 * 
 * @author Luis-st
 *
 */

public class XOArmorOverlay implements IIngameOverlay {
	
	private final Minecraft minecraft;
	
	public XOArmorOverlay(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	@Override
	public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTicks, int width, int height) {
		if (!this.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
			gui.setupOverlayRenderState(true, false);
			this.renderArmor(gui, poseStack, partialTicks, width, height);
		}
	}
	
	private void renderArmor(ForgeIngameGui gui, PoseStack poseStack, float partialTicks, int width, int height) { 
		RenderSystem.enableBlend();
		int left = width / 2 - 91;
		int top = height - gui.left_height;
		int level = this.minecraft.player.getArmorValue();
		for (int i = 21; level > 20 && i < 40; i += 2) {
			if (i < level) {
				gui.blit(poseStack, left, top, 34, 9, 9, 9); // full armor icon
			} else if (i == level) {
				gui.blit(poseStack, left, top, 25, 9, 9, 9); // half armor icon
			} else if (i > level) {
				gui.blit(poseStack, left, top, 16, 9, 9, 9); // empty (no) armor icon
			}
			left += 8;
		}
		gui.left_height += 10;
		RenderSystem.disableBlend();
	}
	
}
