package net.luis.xores.common.item.modded;

import java.util.function.Consumer;

import net.luis.xores.client.render.item.ModShieldRender;
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

public class ModShieldItem extends ShieldItem {

	protected final ResourceLocation location;
	
	public ModShieldItem(Properties properties, ResourceLocation location) {
		super(properties);
		this.location = location;
	}
	
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
			public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
				Minecraft minecraft = Minecraft.getInstance();
				return new ModShieldRender(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels(), ModShieldItem.this.location);
			}
		});
	}

}
