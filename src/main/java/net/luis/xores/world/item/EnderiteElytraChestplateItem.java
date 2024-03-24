package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.EnderiteAbilityArmor;
import net.minecraft.world.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class EnderiteElytraChestplateItem extends ElytraChestplateItem implements EnderiteAbilityArmor {
	
	public EnderiteElytraChestplateItem(ArmorMaterial material, Properties properties) {
		super(material, properties);
	}
	
	@Override
	public @NotNull ArmorMaterial getAbilityMaterial() {
		return XOArmorMaterials.ENDERITE;
	}
}
