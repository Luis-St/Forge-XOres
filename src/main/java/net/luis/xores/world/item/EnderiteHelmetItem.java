package net.luis.xores.world.item;

import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/**
 *
 * @author Luis-st
 *
 */

public class EnderiteHelmetItem extends EnderiteArmorItem {
	
	public EnderiteHelmetItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, Type.HELMET, properties);
	}
	
	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
		return true;
	}
	
}
