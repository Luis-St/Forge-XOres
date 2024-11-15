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

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class XOArmorOverlay implements LayeredDraw.Layer {
	
	private static final ResourceLocation ARMOR_EMPTY_SPRITE = ResourceLocation.withDefaultNamespace("hud/armor_empty");
	private static final ResourceLocation ARMOR_HALF_SPRITE = ResourceLocation.withDefaultNamespace("hud/armor_half");
	private static final ResourceLocation ARMOR_FULL_SPRITE = ResourceLocation.withDefaultNamespace("hud/armor_full");
	
	private final Minecraft minecraft;
	
	public XOArmorOverlay() {
		this.minecraft = Minecraft.getInstance();
	}
	
	@Override
	public void render(@NotNull GuiGraphics graphics, @NotNull DeltaTracker deltaTracker) {
		int left = graphics.guiWidth() / 2 - 91;
		int top = graphics.guiHeight() - 59;
		int level = this.minecraft.player != null ? this.minecraft.player.getArmorValue() : 0;
		for (int i = 21; level > 20 && i < 40; i += 2) {
			if (i < level) {
				graphics.blitSprite(RenderType::guiTextured, ARMOR_FULL_SPRITE, left, top, 9, 9); // full armor icon
			} else if (i == level) {
				graphics.blitSprite(RenderType::guiTextured, ARMOR_HALF_SPRITE, left, top, 9, 9); // half armor icon
			} else {
				graphics.blitSprite(RenderType::guiTextured, ARMOR_EMPTY_SPRITE, left, top, 9, 9); // empty (no) armor icon
			}
			left += 8;
		}
	}
}
