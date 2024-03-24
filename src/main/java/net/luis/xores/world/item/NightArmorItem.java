package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.NightAbilityArmor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class NightArmorItem extends ArmorItem implements NightAbilityArmor {
	
	public NightArmorItem(ArmorMaterial material, Type type, Properties properties) {
		super(material, type, properties);
	}
	
	@Override
	public @NotNull ArmorMaterial getAbilityMaterial() {
		return XOArmorMaterials.NIGHT;
	}
}
