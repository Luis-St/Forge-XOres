package net.luis.xores.world.item;

import java.util.function.Consumer;

import net.luis.xores.client.renderer.item.XOresShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresShieldItem extends ShieldItem {
	
	private final ResourceLocation shieldTexture;
	
	public XOresShieldItem(Properties properties, ResourceLocation shieldTexture) {
		super(properties);
		this.shieldTexture = shieldTexture;
	}
	
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new XOresShieldRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), XOresShieldItem.this.shieldTexture);
			}
		});
	}

}
