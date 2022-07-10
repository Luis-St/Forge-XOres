package net.luis.xores.world.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * extension of {@link ArmorItem} with {@link EquipmentSlot#HEAD}, works similar to<br> 
 * the {@link Items#CARVED_PUMPKIN} used for {@link XOresItems#ENDERITE_HELMET}
 * 
 * @author Luis-st
 */

public class EnderiteHelmetItem extends ArmorItem {

	/**
	 * constructor for the {@link EnderiteHelmetItem}
	 */
	public EnderiteHelmetItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, EquipmentSlot.HEAD, properties);
	}

	/**
	 * if the {@link Player} wears the {@link ElytraChestplateItem}, he is hidden from {@link EnderMan}s<br>
	 * the {@link ElytraChestplateItem} works similar to the {@link Items#CARVED_PUMPKIN}
	 * @return {@code true}
	 */
	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
		return true;
	}
	
}
