package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.EnderiteAbilityArmor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class EnderiteArmorItem extends ArmorItem implements EnderiteAbilityArmor {
	
	public EnderiteArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public @NotNull ArmorMaterial getAbilityMaterial() {
		return XOArmorMaterials.ENDERITE;
	}
}
