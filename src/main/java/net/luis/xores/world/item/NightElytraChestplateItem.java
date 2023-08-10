package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.NightAbilityArmor;
import net.minecraft.world.item.ArmorMaterial;

/**
 *
 * @author Luis-St
 *
 */

public class NightElytraChestplateItem extends ElytraChestplateItem implements NightAbilityArmor {
	
	public NightElytraChestplateItem(ArmorMaterial armorMaterial, Properties properties) {
		super(armorMaterial, properties);
	}
}
