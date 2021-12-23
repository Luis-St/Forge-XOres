package net.luis.xores.client.render.overlay;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.luis.xores.XOres;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;

public class ModArmorOverlay implements IIngameOverlay {
	
	public static final List<ArmorItem> VANILLA_ARMOR_ITEMS = Lists.newArrayList();
	
	protected final Minecraft minecraft;
	
	public ModArmorOverlay(Minecraft minecraft) {
		this.minecraft = minecraft;
	}
	
	@Override
	public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTicks, int width, int height) {
		if (!this.minecraft.options.hideGui && gui.shouldDrawSurvivalElements()) {
			gui.setupOverlayRenderState(true, false);
			this.renderArmor(gui, poseStack, partialTicks, width, height);
		}
	}
	
	@SuppressWarnings("resource")
	protected void renderArmor(ForgeIngameGui gui, PoseStack poseStack, float partialTicks, int width, int height) {
		this.minecraft.getProfiler().push("armor");
		RenderSystem.enableBlend();
		int left = width / 2 - 91;
		int top = height - gui.left_height;
		int level = Minecraft.getInstance().player.getArmorValue();
		XOres.LOGGER.info(level);
		for (int i = 21; level > 20 && i < 40; i += 2) {
			if (i < level) {
				gui.blit(poseStack, left, top, 34, 9, 9, 9); // full
			} else if (i == level) {
				gui.blit(poseStack, left, top, 25, 9, 9, 9); // half
			} else if (i > level) {
				gui.blit(poseStack, left, top, 16, 9, 9, 9); // empty
			}
			left += 8;
		}
		gui.left_height += 10;
		RenderSystem.disableBlend();
		this.minecraft.getProfiler().pop();
	}
	
}
