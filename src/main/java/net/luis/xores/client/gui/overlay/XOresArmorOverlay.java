package net.luis.xores.client.gui.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.xores.event.fml.OnClientSetupEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

/**
 * implementation of {@link IGuiOverlay}, used to render the armor bar extension
 * 
 * @author Luis-st
 * 
 * @see {@link OnClientSetupEvent}
 */

public class XOresArmorOverlay implements IGuiOverlay {
	
	/**
	 * the {@link Minecraft} client instance
	 */
	protected final Minecraft minecraft;
	
	/**
	 * constructor for the {@link XOresArmorOverlay}
	 */
	public XOresArmorOverlay(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	/**
	 * setup the render state and check if the extended armor bar should be rendered
	 */
	@Override
	public void render(ForgeGui gui, PoseStack poseStack, float partialTicks, int width, int height) {
		if (!this.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
			gui.setupOverlayRenderState(true, false);
			this.renderArmor(gui, poseStack, partialTicks, width, height);
		}
	}
	
	/**
	 * render the armor bar from 21 to 40
	 */
	private void renderArmor(ForgeGui gui, PoseStack poseStack, float partialTicks, int width, int height) { 
		RenderSystem.enableBlend();
		int left = width / 2 - 91;
		int top = height - gui.leftHeight;
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
		gui.leftHeight += 10;
		RenderSystem.disableBlend();
	}
	
}
