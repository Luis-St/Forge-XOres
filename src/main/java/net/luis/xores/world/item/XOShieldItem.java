package net.luis.xores.world.item;

import java.util.function.Consumer;

import net.luis.xores.client.renderer.item.XOShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.IItemRenderProperties;

/**
 * 
 * @author Luis-st
 *
 */

public class XOShieldItem extends ShieldItem {
	
	private final ResourceLocation shieldTexture;
	
	public XOShieldItem(Properties properties, ResourceLocation shieldTexture) {
		super(properties);
		this.shieldTexture = shieldTexture;
	}
	
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new XOShieldRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), XOShieldItem.this.shieldTexture);
			}
		});
	}

}
