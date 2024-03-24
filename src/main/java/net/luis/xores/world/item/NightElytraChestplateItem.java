package net.luis.xores.world.item;

import net.luis.xores.world.item.ability.NightAbilityArmor;
import net.minecraft.world.item.ArmorMaterial;
import org.jetbrains.annotations.NotNull;

/**
 *
 * @author Luis-St
 *
 */

public class NightElytraChestplateItem extends ElytraChestplateItem implements NightAbilityArmor {
	
	public NightElytraChestplateItem(ArmorMaterial material, Properties properties) {
		super(material, properties);
	}
	
	@Override
	public @NotNull ArmorMaterial getAbilityMaterial() {
		return XOArmorMaterials.NIGHT;
	}
}
