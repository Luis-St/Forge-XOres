package net.luis.xores.world.item;

import java.util.function.Consumer;

import net.luis.xores.client.renderer.item.XOresShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.IItemRenderProperties;

/**
 * extension of {@link ShieldItem}, use for all mod {@link ShieldItem}s and<br>
 * the vanilla additional {@link ShieldItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link ShieldItem}
 * @see {@link XOresItems}
 */

public class XOresShieldItem extends ShieldItem {

	/**
	 * texture of the shield as a {@link ResourceLocation}
	 */
	protected final ResourceLocation shieldTexture;
	
	/**
	 * constructor for the {@link XOresShieldItem}
	 */
	public XOresShieldItem(Properties properties, ResourceLocation shieldTexture) {
		super(properties);
		this.shieldTexture = shieldTexture;
	}
	
	/**
	 * initialize the client stuff of the shield<br>
	 * in this case we replce the {@link BlockEntityWithoutLevelRenderer}<br>
	 * with a new instance of {@link XOresShieldRenderer}
	 */
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new XOresShieldRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), XOresShieldItem.this.shieldTexture);
			}
		});
	}

}
