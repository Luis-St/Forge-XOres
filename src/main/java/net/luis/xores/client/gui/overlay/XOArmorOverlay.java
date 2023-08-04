package net.luis.xores.client.gui.overlay;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-st
 *
 */

public class XOArmorOverlay implements IGuiOverlay {
	
	private static final ResourceLocation GUI_ICONS = new ResourceLocation("textures/gui/icons.png");
	
	private final Minecraft minecraft;
	
	public XOArmorOverlay(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	@Override
	public void render(ForgeGui gui, GuiGraphics graphics, float partialTicks, int width, int height) {
		if (!this.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
			gui.setupOverlayRenderState(true, false);
			this.renderArmor(gui, graphics, partialTicks, width, height);
		}
	}
	
	private void renderArmor(@NotNull ForgeGui gui, GuiGraphics graphics, float partialTicks, int width, int height) {
		RenderSystem.enableBlend();
		int left = width / 2 - 91;
		int top = height - gui.leftHeight;
		int level = this.minecraft.player != null ? this.minecraft.player.getArmorValue() : 0;
		for (int i = 21; level > 20 && i < 40; i += 2) {
			if (i < level) {
				graphics.blit(GUI_ICONS, left, top, 34, 9, 9, 9); // full armor icon
			} else if (i == level) {
				graphics.blit(GUI_ICONS, left, top, 25, 9, 9, 9); // half armor icon
			} else {
				graphics.blit(GUI_ICONS, left, top, 16, 9, 9, 9); // empty (no) armor icon
			}
			left += 8;
		}
		gui.leftHeight += 10;
		RenderSystem.disableBlend();
	}
}
