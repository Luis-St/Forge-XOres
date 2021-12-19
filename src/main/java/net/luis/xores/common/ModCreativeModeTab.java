package net.luis.xores.common;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab extends CreativeModeTab {

	protected final ItemStack icon;
	
	public ModCreativeModeTab(String name, ItemStack icon) {
		super(name);
		this.icon = icon;
	}

	@Override
	public ItemStack makeIcon() {
		return this.icon;
	}

}
