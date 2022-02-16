package net.luis.xores.common.item.modded;

import java.util.function.Consumer;

import net.luis.xores.client.render.item.ModShieldRenderer;
import net.luis.xores.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.client.IItemRenderProperties;

/**
 * extension of {@link ShieldItem},<br>
 * use for all mod {@link ShieldItem}s and<br>
 * the vanilla additional {@link ShieldItem}s
 * 
 * @author Luis-st
 * 
 * @see {@link ShieldItem}
 * @see {@link ModItems}
 */

public class ModShieldItem extends ShieldItem {

	/**
	 * texture of the shield as a {@link ResourceLocation}
	 */
	protected final ResourceLocation shieldTexture;
	
	/**
	 * constructor for the {@link ModShieldItem}
	 */
	public ModShieldItem(Properties properties, ResourceLocation shieldTexture) {
		super(properties);
		this.shieldTexture = shieldTexture;
	}
	
	/**
	 * initialize the client stuff of the shield<br>
	 * in this case we replce the {@link BlockEntityWithoutLevelRenderer}<br>
	 * with a new instance of {@link ModShieldRenderer}
	 */
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new ModShieldRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), ModShieldItem.this.shieldTexture);
			}
		});
	}

}
