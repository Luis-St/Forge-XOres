package net.luis.xores.common.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * 
 * @author Luis-st
 * 
 */

public class EnderiteHelmetItem extends ArmorItem {

	public EnderiteHelmetItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.HEAD, properties);
	}

	/**
	 * The {@link EnderiteHelmetItem}, works as an EnderMask similar to the {@link Items#CARVED_PUMPKIN}
	 */
	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
		return true;
	}
	
}
