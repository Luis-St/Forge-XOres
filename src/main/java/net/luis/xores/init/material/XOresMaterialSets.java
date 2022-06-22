package net.luis.xores.init.material;

import net.luis.xores.XOres;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
import net.luis.xores.init.XOresItems;
import net.luis.xores.init.XOresTags;
import net.luis.xores.init.block.XOresBlockItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all XOres {@link MaterialSet}s
 * 
 * @author Luis-st
 */

public class XOresMaterialSets {
	
	/**
	 * {@link DeferredRegister} for {@link MaterialSet}s, used to register all mod {@link MaterialSet}s
	 */
	public static final DeferredRegister<MaterialSet> MATERIALS = DeferredRegister.create(new ResourceLocation(XOres.MOD_ID, "material_set"), XOres.MOD_ID);
	
	/**
	 * {@link RegistryObject} for the jade {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> JADE = MATERIALS.register("jade", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.JADE_INGOT.get()).add(MaterialTypes.ORE, XOresTags.Items.JADE_ORES).add(MaterialTypes.BLOCK, XOresBlockItems.JADE_BLOCK.get())
				.add(XOresItems.JADE_SWORD.get()).add(XOresItems.JADE_PICKAXE.get()).add(XOresItems.JADE_AXE.get()).add(XOresItems.JADE_SHOVEL.get()).add(XOresItems.JADE_HOE.get()).add(XOresItems.JADE_HELMET.get())
				.add(XOresItems.JADE_CHESTPLATE.get()).add(XOresItems.JADE_LEGGINGS.get()).add(XOresItems.JADE_BOOTS.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the blazing {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> BLAZING = MATERIALS.register("blazing", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.BLAZING_INGOT.get())
				.add(XOresItems.BLAZING_SWORD.get()).add(XOresItems.BLAZING_PICKAXE.get()).add(XOresItems.BLAZING_AXE.get()).add(XOresItems.BLAZING_SHOVEL.get()).add(XOresItems.BLAZING_HOE.get())
				.add(XOresItems.BLAZING_HELMET.get()).add(XOresItems.BLAZING_CHESTPLATE.get()).add(XOresItems.BLAZING_LEGGINGS.get()).add(XOresItems.BLAZING_BOOTS.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the limonite {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> LIMONITE = MATERIALS.register("limonite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.LIMONITE_INGOT.get()).add(MaterialTypes.ORE, XOresTags.Items.LIMONITE_ORES).add(MaterialTypes.BLOCK, XOresBlockItems.LIMONITE_BLOCK.get())
				.add(XOresItems.LIMONITE_SWORD.get()).add(XOresItems.LIMONITE_PICKAXE.get()).add(XOresItems.LIMONITE_AXE.get()).add(XOresItems.LIMONITE_SHOVEL.get()).add(XOresItems.LIMONITE_HOE.get())
				.add(XOresItems.LIMONITE_HELMET.get()).add(XOresItems.LIMONITE_CHESTPLATE.get()).add(XOresItems.LIMONITE_LEGGINGS.get()).add(XOresItems.LIMONITE_BOOTS.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the saphire {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> SAPHIRE = MATERIALS.register("saphire", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.SAPHIRE_INGOT.get()).add(MaterialTypes.ORE, XOresTags.Items.SAPHIRE_ORES).add(MaterialTypes.BLOCK, XOresBlockItems.SAPHIRE_BLOCK.get())
				.add(XOresItems.SAPHIRE_SWORD.get()).add(XOresItems.SAPHIRE_SHIELD.get()).add(XOresItems.SAPHIRE_PICKAXE.get()).add(XOresItems.SAPHIRE_AXE.get()).add(XOresItems.SAPHIRE_SHOVEL.get())
				.add(XOresItems.SAPHIRE_HOE.get()).add(XOresItems.SAPHIRE_HELMET.get()).add(XOresItems.SAPHIRE_CHESTPLATE.get()).add(XOresItems.SAPHIRE_LEGGINGS.get()).add(XOresItems.SAPHIRE_BOOTS.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the rosite {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> ROSITE = MATERIALS.register("rosite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.ROSITE_INGOT.get()).add(MaterialTypes.ORE, XOresTags.Items.ROSITE_ORES).add(MaterialTypes.BLOCK, XOresBlockItems.ROSITE_BLOCK.get())
				.add(XOresItems.ROSITE_SWORD.get()).add(XOresItems.ROSITE_PICKAXE.get()).add(XOresItems.ROSITE_AXE.get()).add(XOresItems.ROSITE_SHOVEL.get()).add(XOresItems.ROSITE_HOE.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the rose quartz {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> ROSE_QUARTZ = MATERIALS.register("rose_quartz", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.POLISHED_ROSE_QUARTZ.get()).add(MaterialTypes.MATERIAL_PART, XOresItems.ROSE_QUARTZ.get()).add(XOresItems.ROSE_QUARTZ_SWORD.get())
				.add(XOresItems.ROSE_QUARTZ_PICKAXE.get()).add(XOresItems.ROSE_QUARTZ_AXE.get()).add(XOresItems.ROSE_QUARTZ_SHOVEL.get()).add(XOresItems.ROSE_QUARTZ_HOE.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the enderite {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> ENDERITE = MATERIALS.register("enderite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.ENDERITE_INGOT.get()).add(MaterialTypes.MATERIAL_PART, XOresItems.ENDERITE_SCRAP.get()).add(MaterialTypes.ORE, XOresTags.Items.ENDERITE_ORES)
				.add(MaterialTypes.BLOCK, XOresBlockItems.ENDERITE_BLOCK.get()).add(XOresItems.ENDERITE_SWORD.get()).add(XOresItems.ENDERITE_SHIELD.get()).add(MaterialTypes.BOW, XOresItems.ENDERITE_BOW.get())
				.add(MaterialTypes.CROSSBOW, XOresItems.ENDERITE_CROSSBOW.get()).add(XOresItems.ENDERITE_PICKAXE.get()).add(XOresItems.ENDERITE_AXE.get()).add(XOresItems.ENDERITE_SHOVEL.get())
				.add(XOresItems.ENDERITE_HOE.get()).add(XOresItems.ENDERITE_HELMET.get()).add(XOresItems.ENDERITE_CHESTPLATE.get()).add(MaterialTypes.ELYTRA_CHESTPLATE, XOresItems.ENDERITE_ELYTRA_CHESTPLATE.get())
				.add(XOresItems.ENDERITE_LEGGINGS.get()).add(XOresItems.ENDERITE_BOOTS.get()).upgradeSet(MaterialSets.NETHERITE).build();
	});
	
	/**
	 * {@link RegistryObject} for the steel {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> STEEL = MATERIALS.register("steel", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.STEEL_INGOT.get()).add(XOresItems.STEEL_SWORD.get()).add(XOresItems.STEEL_PICKAXE.get()).add(XOresItems.STEEL_AXE.get())
				.add(XOresItems.STEEL_SHOVEL.get()).add(XOresItems.STEEL_HOE.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the night {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> NIGHT = MATERIALS.register("night", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, XOresItems.NIGHT_INGOT.get()).add(MaterialTypes.MATERIAL_PART, XOresItems.NIGHT_SCRAP.get()).add(MaterialTypes.ORE, XOresTags.Items.ENDERITE_ORES)
				.add(XOresItems.NIGHT_SWORD.get()).add(XOresItems.NIGHT_SHIELD.get()).add(MaterialTypes.BOW, XOresItems.NIGHT_BOW.get()).add(MaterialTypes.CROSSBOW, XOresItems.NIGHT_CROSSBOW.get())
				.add(XOresItems.NIGHT_PICKAXE.get()).add(XOresItems.NIGHT_AXE.get()).add(XOresItems.NIGHT_SHOVEL.get()).add(XOresItems.NIGHT_HOE.get()).add(XOresItems.NIGHT_HELMET.get())
				.add(XOresItems.NIGHT_CHESTPLATE.get()).add(MaterialTypes.ELYTRA_CHESTPLATE, XOresItems.NIGHT_ELYTRA_CHESTPLATE.get()).add(XOresItems.NIGHT_LEGGINGS.get()).add(XOresItems.NIGHT_BOOTS.get())
				.upgradeSet(ENDERITE).build();
	});
	
}
