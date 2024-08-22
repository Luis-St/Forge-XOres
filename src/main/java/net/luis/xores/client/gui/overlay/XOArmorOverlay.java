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

package net.luis.xores.client.gui.overlay;

/**
 *
 * @author Luis-St
 *
 */

public class XOArmorOverlay /*implements IGuiOverlay*/ {
	
	/*private static final ResourceLocation ARMOR_EMPTY = ResourceLocation.withDefaultNamespace("hud/armor_empty");
	private static final ResourceLocation ARMOR_HALF = ResourceLocation.withDefaultNamespace("hud/armor_half");
	private static final ResourceLocation ARMOR_FULL = ResourceLocation.withDefaultNamespace("hud/armor_full");
	
	private final Minecraft minecraft;
	
	public XOArmorOverlay(@NotNull Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	@Override
	public void render(@NotNull ForgeGui gui, @NotNull GuiGraphics graphics, float partialTicks, int width, int height) {
		if (!this.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
			gui.setupOverlayRenderState(true, false);
			this.renderArmor(gui, graphics, partialTicks, width, height);
		}
	}
	
	private void renderArmor(@NotNull ForgeGui gui, @NotNull GuiGraphics graphics, float partialTicks, int width, int height) {
		RenderSystem.enableBlend();
		int left = width / 2 - 91;
		int top = height - gui.leftHeight;
		int level = this.minecraft.player != null ? this.minecraft.player.getArmorValue() : 0;
		for (int i = 21; level > 20 && i < 40; i += 2) {
			if (i < level) {
				graphics.blitSprite(ARMOR_FULL, left, top, 9, 9); // full armor icon
			} else if (i == level) {
				graphics.blitSprite(ARMOR_HALF, left, top, 9, 9); // half armor icon
			} else {
				graphics.blitSprite(ARMOR_EMPTY, left, top, 9, 9); // empty (no) armor icon
			}
			left += 8;
		}
		gui.leftHeight += 10;
		RenderSystem.disableBlend();
	}*/
}
