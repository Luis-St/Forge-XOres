package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.EnderiteAbilityArmor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

/**
 *
 * @author Luis-St
 *
 */

public class EnderiteArmorItem extends ArmorItem implements EnderiteAbilityArmor {
	
	public EnderiteArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
}
