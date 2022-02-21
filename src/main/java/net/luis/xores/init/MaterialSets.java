package net.luis.xores.init;

import net.luis.xores.common.material.MaterialSet;
import net.luis.xores.common.material.MaterialTypes;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

/**
 * registration class for all vanilla {@link MaterialSet}s
 * 
 * @author Luis-st
 */

// TODO: add Tag for Copper Blocks
public class MaterialSets {
	
	/**
	 * {@link DeferredRegister} for {@link MaterialSet}s, used to register all minecraft {@link MaterialSet}s
	 */
	public static final DeferredRegister<MaterialSet> MATERIALS = DeferredRegister.create(MaterialSet.class, "minecraft");
	
	/**
	 * {@link RegistryObject} for the wooden {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> WOODEN = MATERIALS.register("wooden", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ItemTags.PLANKS).add(MaterialTypes.MATERIAL_PART, Items.STICK).add(MaterialTypes.ORE, ItemTags.LOGS).add(Items.WOODEN_SWORD).add(Items.SHIELD)
				.add(Items.BOW).add(Items.CROSSBOW).add(Items.WOODEN_PICKAXE).add(Items.WOODEN_AXE).add(Items.WOODEN_SHOVEL).add(Items.WOODEN_HOE).build();
	});
	
	/**
	 * {@link RegistryObject} for the leather {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> LEATHER = MATERIALS.register("leather", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.LEATHER).add(MaterialTypes.MATERIAL_PART, Items.RABBIT_HIDE).add(Items.LEATHER_HELMET).add(Items.LEATHER_CHESTPLATE)
				.add(Items.LEATHER_LEGGINGS).add(Items.LEATHER_BOOTS).build();
	});
	
	/**
	 * {@link RegistryObject} for the stone {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> STONE = MATERIALS.register("stone", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, ItemTags.STONE_TOOL_MATERIALS).add(MaterialTypes.ORE, ModTags.Items.STONES).add(Items.STONE_SWORD).add(Items.STONE_PICKAXE).add(Items.STONE_AXE)
				.add(Items.STONE_SHOVEL).add(Items.STONE_HOE).build();
	});
	
	/**
	 * {@link RegistryObject} for the chainmail {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> CHAINMAIL = MATERIALS.register("chainmail", () -> {
		return MaterialSet.of().add(Items.CHAINMAIL_HELMET).add(Items.CHAINMAIL_CHESTPLATE).add(Items.CHAINMAIL_LEGGINGS).add(Items.CHAINMAIL_BOOTS).build();
	});
	
	/**
	 * {@link RegistryObject} for the copper {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> COPPER = MATERIALS.register("copper", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.COPPER_INGOT).add(MaterialTypes.MATERIAL_PART, Items.RAW_COPPER).add(MaterialTypes.ORE, ItemTags.COPPER_ORES).add(MaterialTypes.BLOCK, Items.COPPER_BLOCK)
				.add(ModItems.COPPER_SHIELD.get()).build();
	});
	
	/**
	 * {@link RegistryObject} for the golden {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> GOLDEN = MATERIALS.register("golden", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.GOLD_INGOT).add(MaterialTypes.MATERIAL_PART, Items.GOLD_NUGGET).add(MaterialTypes.ORE, ItemTags.GOLD_ORES).add(MaterialTypes.BLOCK, Items.GOLD_BLOCK)
				.add(Items.GOLDEN_SWORD).add(ModItems.GOLDEN_SHIELD.get()).add(Items.GOLDEN_PICKAXE).add(Items.GOLDEN_AXE).add(Items.GOLDEN_SHOVEL).add(Items.GOLDEN_HOE).add(Items.GOLDEN_HELMET)
				.add(Items.GOLDEN_CHESTPLATE).add(Items.GOLDEN_LEGGINGS).add(Items.GOLDEN_BOOTS).build();
	});
	
	/**
	 * {@link RegistryObject} for the iron {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> IRON = MATERIALS.register("iron", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.IRON_INGOT).add(MaterialTypes.MATERIAL_PART, Items.IRON_NUGGET).add(MaterialTypes.ORE, ItemTags.IRON_ORES).add(MaterialTypes.BLOCK, Items.IRON_BLOCK)
				.add(Items.IRON_SWORD).add(ModItems.IRON_SHIELD.get()).add(Items.IRON_PICKAXE).add(Items.IRON_AXE).add(Items.IRON_SHOVEL).add(Items.IRON_HOE).add(Items.IRON_HELMET).add(Items.IRON_CHESTPLATE)
				.add(Items.IRON_LEGGINGS).add(Items.IRON_BOOTS).build();
	});
	
	/**
	 * {@link RegistryObject} for the diamond {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> DIAMOND = MATERIALS.register("diamond", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.DIAMOND).add(MaterialTypes.ORE, ItemTags.DIAMOND_ORES).add(MaterialTypes.BLOCK, Items.DIAMOND_BLOCK).add(Items.DIAMOND_SWORD)
				.add(ModItems.DIAMOND_SHIELD.get()).add(Items.DIAMOND_PICKAXE).add(Items.DIAMOND_AXE).add(Items.DIAMOND_SHOVEL).add(Items.DIAMOND_HOE).add(Items.DIAMOND_HELMET).add(Items.DIAMOND_CHESTPLATE)
				.add(ModItems.DIAMOND_ELYTRA_CHESTPLATE.get()).add(Items.DIAMOND_LEGGINGS).add(Items.DIAMOND_BOOTS).build();
	});
	
	/**
	 * {@link RegistryObject} for the netherite {@link MaterialSet}
	 */
	public static final RegistryObject<MaterialSet> NETHERITE = MATERIALS.register("netherite", () -> {
		return MaterialSet.of().add(MaterialTypes.MATERIAL, Items.NETHERITE_INGOT).add(MaterialTypes.MATERIAL_PART, Items.NETHERITE_SCRAP).add(MaterialTypes.ORE, Items.ANCIENT_DEBRIS)
				.add(MaterialTypes.BLOCK, Items.NETHERITE_BLOCK).add(Items.NETHERITE_SWORD).add(ModItems.NETHERITE_SHIELD.get())
				.add(Items.NETHERITE_PICKAXE).add(Items.NETHERITE_AXE).add(Items.NETHERITE_SHOVEL).add(Items.NETHERITE_HOE).add(ModItems.NETHERITE_BOW.get()).add(ModItems.NETHERITE_CROSSBOW.get())
				.add(Items.NETHERITE_HELMET).add(Items.NETHERITE_CHESTPLATE).add(ModItems.NETHERITE_ELYTRA_CHESTPLATE.get()).add(Items.NETHERITE_LEGGINGS).add(Items.NETHERITE_BOOTS).upgradeSet(DIAMOND).build();
	});
	
	static {
		MATERIALS.makeRegistry("material_set",  RegistryBuilder<MaterialSet>::new);
	}
	
}
