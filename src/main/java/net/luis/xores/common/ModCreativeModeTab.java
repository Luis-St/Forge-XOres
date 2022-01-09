package net.luis.xores.common;

import java.util.function.Supplier;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * 
 * @author Luis-st
 *
 */

public class ModCreativeModeTab extends CreativeModeTab {

	protected final Supplier<? extends Item> icon;
	
	public ModCreativeModeTab(String name, Supplier<? extends Item> icon) {
		super(name);
		this.icon = icon;
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(this.icon.get());
	}
	
}
