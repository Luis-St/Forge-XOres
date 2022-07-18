package net.luis.xores.world.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

/**
 * 
 * @author Luis-st
 *
 */

public class EnderiteHelmetItem extends ArmorItem {
	
	public EnderiteHelmetItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.HEAD, properties);
	}
	
	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
		return true;
	}
	
}
