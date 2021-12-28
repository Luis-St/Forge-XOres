package net.luis.xores.init;

import net.luis.xores.XOres;
import net.luis.xores.data.newmaterial.MaterialSet;
import net.luis.xores.data.newmaterial.stuff.ArmorSet;
import net.luis.xores.data.newmaterial.stuff.ToolSet;
import net.luis.xores.data.newmaterial.stuff.WeaponSet;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMaterialSets {
	
	public static final DeferredRegister<MaterialSet> MATERIALS = DeferredRegister.create(MaterialSet.class, XOres.MOD_ID);
	
	
	public static final RegistryObject<MaterialSet> JADE = MATERIALS.register("jade", () -> {
		return MaterialSet.ofItem(ModItems.JADE_INGOT.get()).ore(ModBlockItems.JADE_ORE.get()).deepslateOre(ModBlockItems.DEEPSLATE_JADE_ORE.get()).block(ModBlockItems.JADE_BLOCK.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.JADE_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.JADE_PICKAXE.get()).axe(ModItems.JADE_AXE.get()).shovel(ModItems.JADE_SHOVEL.get()).hoe(ModItems.JADE_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.JADE_HELMET.get()).chestplate(ModItems.JADE_CHESTPLATE.get()).leggings(ModItems.JADE_LEGGINGS.get()).boots(ModItems.JADE_BOOTS.get()))
				.build();
	});

	public static final RegistryObject<MaterialSet> BLAZING = MATERIALS.register("blazing", () -> {
		return MaterialSet.ofItem(ModItems.BLAZING_INGOT.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.BLAZING_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.BLAZING_PICKAXE.get()).axe(ModItems.BLAZING_AXE.get()).shovel(ModItems.BLAZING_SHOVEL.get()).hoe(ModItems.BLAZING_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.BLAZING_HELMET.get()).chestplate(ModItems.BLAZING_CHESTPLATE.get()).leggings(ModItems.BLAZING_LEGGINGS.get()).boots(ModItems.BLAZING_BOOTS.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> LIMONITE = MATERIALS.register("limonite", () -> {
		return MaterialSet.ofItem(ModItems.LIMONITE_INGOT.get()).ore(ModBlockItems.LIMONITE_ORE.get()).deepslateOre(ModBlockItems.DEEPSLATE_LIMONITE_ORE.get()).block(ModBlockItems.LIMONITE_BLOCK.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.LIMONITE_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.LIMONITE_PICKAXE.get()).axe(ModItems.LIMONITE_AXE.get()).shovel(ModItems.LIMONITE_SHOVEL.get()).hoe(ModItems.LIMONITE_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.LIMONITE_HELMET.get()).chestplate(ModItems.LIMONITE_CHESTPLATE.get()).leggings(ModItems.LIMONITE_LEGGINGS.get()).boots(ModItems.LIMONITE_BOOTS.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> SAPHIRE = MATERIALS.register("saphire", () -> {
		return MaterialSet.ofItem(ModItems.SAPHIRE_INGOT.get()).ore(ModBlockItems.SAPHIRE_ORE.get()).deepslateOre(ModBlockItems.DEEPSLATE_SAPHIRE_ORE.get()).block(ModBlockItems.SAPHIRE_BLOCK.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.SAPHIRE_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.SAPHIRE_PICKAXE.get()).axe(ModItems.SAPHIRE_AXE.get()).shovel(ModItems.SAPHIRE_SHOVEL.get()).hoe(ModItems.SAPHIRE_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.SAPHIRE_HELMET.get()).chestplate(ModItems.SAPHIRE_CHESTPLATE.get()).leggings(ModItems.SAPHIRE_LEGGINGS.get()).boots(ModItems.SAPHIRE_BOOTS.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> ROSITE = MATERIALS.register("rosite", () -> {
		return MaterialSet.ofItem(ModItems.ROSITE_INGOT.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.ROSITE_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.ROSITE_PICKAXE.get()).axe(ModItems.ROSITE_AXE.get()).shovel(ModItems.ROSITE_SHOVEL.get()).hoe(ModItems.ROSITE_HOE.get())).block(ModBlockItems.ROSITE_BLOCK.get())
				.build();
	});
	
	public static final RegistryObject<MaterialSet> ROSE_QUARTZ = MATERIALS.register("rose_quartz", () -> {
		return MaterialSet.ofItem(ModItems.POLISHED_ROSE_QUARTZ.get()).materialPart(ModItems.ROSE_QUARTZ.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.ROSE_QUARTZ_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.ROSE_QUARTZ_PICKAXE.get()).axe(ModItems.ROSE_QUARTZ_AXE.get()).shovel(ModItems.ROSE_QUARTZ_SHOVEL.get()).hoe(ModItems.ROSE_QUARTZ_HOE.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> ENDERITE = MATERIALS.register("enderite", () -> {
		return MaterialSet.ofItem(ModItems.ENDERITE_INGOT.get()).materialPart(ModItems.ENDERITE_SCRAP.get()).ore(ModBlockItems.ENDERITE_ORE.get()).block(ModBlockItems.ENDERITE_BLOCK.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.ENDERITE_SWORD.get()).shield(ModItems.ENDERITE_SHIELD.get()).bow(ModItems.ENDERITE_BOW.get()).crossbow(ModItems.ENDERITE_CROSSBOW.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.ENDERITE_PICKAXE.get()).axe(ModItems.ENDERITE_AXE.get()).shovel(ModItems.ENDERITE_SHOVEL.get()).hoe(ModItems.ENDERITE_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.ENDERITE_HELMET.get()).chestplate(ModItems.ENDERITE_CHESTPLATE.get()).leggings(ModItems.ENDERITE_LEGGINGS.get()).boots(ModItems.ENDERITE_BOOTS.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> STEEL = MATERIALS.register("steel", () -> {
		return MaterialSet.ofItem(ModItems.STEEL_INGOT.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.STEEL_SWORD.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.STEEL_PICKAXE.get()).axe(ModItems.STEEL_AXE.get()).shovel(ModItems.STEEL_SHOVEL.get()).hoe(ModItems.STEEL_HOE.get()))
				.build();
	});
	
	public static final RegistryObject<MaterialSet> NIGHT = MATERIALS.register("night", () -> {
		return MaterialSet.ofItem(ModItems.NIGHT_INGOT.get()).materialPart(ModItems.NIGHT_SHARD.get())
				.weaponSet(new WeaponSet.Builder().sword(ModItems.NIGHT_SWORD.get()).shield(ModItems.NIGHT_SHIELD.get()).bow(ModItems.NIGHT_BOW.get()).crossbow(ModItems.NIGHT_CROSSBOW.get()))
				.toolSet(new ToolSet.Builder().pickaxe(ModItems.NIGHT_PICKAXE.get()).axe(ModItems.NIGHT_AXE.get()).shovel(ModItems.NIGHT_SHOVEL.get()).hoe(ModItems.NIGHT_HOE.get()))
				.armorSet(new ArmorSet.Builder().helmet(ModItems.NIGHT_HELMET.get()).chestplate(ModItems.NIGHT_CHESTPLATE.get()).leggings(ModItems.NIGHT_LEGGINGS.get()).boots(ModItems.NIGHT_BOOTS.get()))
				.build();
	});
	
}
