package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModMaterialSets {
	
	public static final DeferredRegister<MaterialSet> MATERIALS = DeferredRegister.create(MaterialSet.class, XOres.MOD_ID);
	
	
	public static final RegistryObject<MaterialSet> JADE = MATERIALS.register("jade", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.JADE_INGOT.get()).add(MaterialTypes.ORE, ModTags.Items.JADE_ORES).add(MaterialTypes.BLOCK, ModBlockItems.JADE_BLOCK.get())
				.add(ModItems.JADE_SWORD.get()).add(ModItems.JADE_PICKAXE.get()).add(ModItems.JADE_AXE.get()).add(ModItems.JADE_SHOVEL.get()).add(ModItems.JADE_HOE.get()).add(ModItems.JADE_HELMET.get())
				.add(ModItems.JADE_CHESTPLATE.get()).add(ModItems.JADE_LEGGINGS.get()).add(ModItems.JADE_BOOTS.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> BLAZING = MATERIALS.register("blazing", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.BLAZING_INGOT.get())
				.add(ModItems.BLAZING_SWORD.get()).add(ModItems.BLAZING_PICKAXE.get()).add(ModItems.BLAZING_AXE.get()).add(ModItems.BLAZING_SHOVEL.get()).add(ModItems.BLAZING_HOE.get())
				.add(ModItems.BLAZING_HELMET.get()).add(ModItems.BLAZING_CHESTPLATE.get()).add(ModItems.BLAZING_LEGGINGS.get()).add(ModItems.BLAZING_BOOTS.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> LIMONITE = MATERIALS.register("limonite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.LIMONITE_INGOT.get()).add(MaterialTypes.ORE, ModTags.Items.LIMONITE_ORES).add(MaterialTypes.BLOCK, ModBlockItems.LIMONITE_BLOCK.get())
				.add(ModItems.LIMONITE_SWORD.get()).add(ModItems.LIMONITE_PICKAXE.get()).add(ModItems.LIMONITE_AXE.get()).add(ModItems.LIMONITE_SHOVEL.get()).add(ModItems.LIMONITE_HOE.get())
				.add(ModItems.LIMONITE_HELMET.get()).add(ModItems.LIMONITE_CHESTPLATE.get()).add(ModItems.LIMONITE_LEGGINGS.get()).add(ModItems.LIMONITE_BOOTS.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> SAPHIRE = MATERIALS.register("saphire", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.SAPHIRE_INGOT.get()).add(MaterialTypes.ORE, ModTags.Items.SAPHIRE_ORES).add(MaterialTypes.BLOCK, ModBlockItems.SAPHIRE_BLOCK.get())
				.add(ModItems.SAPHIRE_SWORD.get()).add(ModItems.SAPHIRE_SHIELD.get()).add(ModItems.SAPHIRE_PICKAXE.get()).add(ModItems.SAPHIRE_AXE.get()).add(ModItems.SAPHIRE_SHOVEL.get())
				.add(ModItems.SAPHIRE_HOE.get()).add(ModItems.SAPHIRE_HELMET.get()).add(ModItems.SAPHIRE_CHESTPLATE.get()).add(ModItems.SAPHIRE_LEGGINGS.get()).add(ModItems.SAPHIRE_BOOTS.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> ROSITE = MATERIALS.register("rosite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.ROSITE_INGOT.get()).add(MaterialTypes.ORE, ModTags.Items.ROSITE_ORES).add(MaterialTypes.BLOCK, ModBlockItems.ROSITE_BLOCK.get())
				.add(ModItems.ROSITE_SWORD.get()).add(ModItems.ROSITE_PICKAXE.get()).add(ModItems.ROSITE_AXE.get()).add(ModItems.ROSITE_SHOVEL.get()).add(ModItems.ROSITE_HOE.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> ROSE_QUARTZ = MATERIALS.register("rose_quartz", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.POLISHED_ROSE_QUARTZ.get()).add(MaterialTypes.MATERIAL_PART, ModItems.ROSE_QUARTZ.get()).add(ModItems.ROSE_QUARTZ_SWORD.get())
				.add(ModItems.ROSE_QUARTZ_PICKAXE.get()).add(ModItems.ROSE_QUARTZ_AXE.get()).add(ModItems.ROSE_QUARTZ_SHOVEL.get()).add(ModItems.ROSE_QUARTZ_HOE.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> ENDERITE = MATERIALS.register("enderite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.ENDERITE_INGOT.get()).add(MaterialTypes.MATERIAL_PART, ModItems.ENDERITE_SCRAP.get()).add(MaterialTypes.ORE, ModTags.Items.ENDERITE_ORES)
				.add(MaterialTypes.BLOCK, ModBlockItems.ENDERITE_BLOCK.get()).add(ModItems.ENDERITE_SWORD.get()).add(ModItems.ENDERITE_SHIELD.get()).add(MaterialTypes.BOW, ModItems.ENDERITE_BOW.get())
				.add(MaterialTypes.CROSSBOW, ModItems.ENDERITE_CROSSBOW.get()).add(ModItems.ENDERITE_PICKAXE.get()).add(ModItems.ENDERITE_AXE.get()).add(ModItems.ENDERITE_SHOVEL.get())
				.add(ModItems.ENDERITE_HOE.get()).add(ModItems.ENDERITE_HELMET.get()).add(ModItems.ENDERITE_CHESTPLATE.get()).add(MaterialTypes.ELYTRA_CHESTPLATE, ModItems.ENDERITE_ELYTRA_CHESTPLATE.get())
				.add(ModItems.ENDERITE_LEGGINGS.get()).add(ModItems.ENDERITE_BOOTS.get()).upgradeSet(MaterialSets.NETHERITE).build();
	});
	
	public static final RegistryObject<MaterialSet> STEEL = MATERIALS.register("steel", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.STEEL_INGOT.get()).add(ModItems.STEEL_SWORD.get()).add(ModItems.STEEL_PICKAXE.get()).add(ModItems.STEEL_AXE.get())
				.add(ModItems.STEEL_SHOVEL.get()).add(ModItems.STEEL_HOE.get()).build();
	});
	
	public static final RegistryObject<MaterialSet> NIGHT = MATERIALS.register("night", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ModItems.NIGHT_INGOT.get()).add(MaterialTypes.MATERIAL_PART, ModItems.NIGHT_SCRAP.get()).add(MaterialTypes.ORE, ModTags.Items.ENDERITE_ORES)
				.add(ModItems.NIGHT_SWORD.get()).add(ModItems.NIGHT_SHIELD.get()).add(MaterialTypes.BOW, ModItems.NIGHT_BOW.get()).add(MaterialTypes.CROSSBOW, ModItems.NIGHT_CROSSBOW.get())
				.add(ModItems.NIGHT_PICKAXE.get()).add(ModItems.NIGHT_AXE.get()).add(ModItems.NIGHT_SHOVEL.get()).add(ModItems.NIGHT_HOE.get()).add(ModItems.NIGHT_HELMET.get())
				.add(ModItems.NIGHT_CHESTPLATE.get()).add(MaterialTypes.ELYTRA_CHESTPLATE, ModItems.NIGHT_ELYTRA_CHESTPLATE.get()).add(ModItems.NIGHT_LEGGINGS.get()).add(ModItems.NIGHT_BOOTS.get())
				.upgradeSet(ENDERITE).build();
	});
	
}
