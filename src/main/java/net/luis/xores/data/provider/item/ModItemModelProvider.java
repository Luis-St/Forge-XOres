package net.luis.xores.data.provider.item;

import net.luis.xores.XOres;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		
	}
	
	@Override
	public String getName() {
		return "XOres Item Models";
	}

}
