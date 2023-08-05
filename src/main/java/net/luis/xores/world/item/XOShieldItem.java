package net.luis.xores.world.item;

import net.luis.xores.client.renderer.item.XOShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 *
 * @author Luis-St
 *
 */

public class XOShieldItem extends ShieldItem {
	
	private final ResourceLocation shieldTexture;
	
	public XOShieldItem(Properties properties, ResourceLocation shieldTexture) {
		super(properties);
		this.shieldTexture = shieldTexture;
	}
	
	@Override
	public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new XOShieldRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), XOShieldItem.this.shieldTexture);
			}
		});
	}
}
