package net.luis.xores.common;

import java.util.function.Supplier;

import net.luis.xores.XOres;
import net.luis.xores.init.ModBlockItems;
import net.luis.xores.init.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.ItemStack;

/**
 * extension of {@link CreativeModeTab}, used for all mod {@link Item}s<br>
 * for the  {@link Properties#tab()}
 * 
 * @author Luis-st
 * 
 * @see {@link CreativeModeTab}
 * @see {@link ModItems}
 * @see {@link ModBlockItems}
 * @see {@link XOres}
 */

public class ModCreativeModeTab extends CreativeModeTab {

	/**
	 * the icon of the {@link CreativeModeTab} as an {@link Supplier},<br>
	 * since the icon needs to be lazy load
	 */
	protected final Supplier<? extends Item> icon;
	
	/**
	 * constructor for the {@link ModCreativeModeTab}
	 */
	public ModCreativeModeTab(String name, Supplier<? extends Item> icon) {
		super(name);
		this.icon = icon;
	}

	/**
	 * getter for the icon of the tab
	 * @return the {@link ModCreativeModeTab#icon} as an {@link ItemStack}
	 */
	@Override
	public ItemStack makeIcon() {
		return new ItemStack(this.icon.get());
	}
	
}
