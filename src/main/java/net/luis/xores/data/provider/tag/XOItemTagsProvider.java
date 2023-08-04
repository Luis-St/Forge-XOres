package net.luis.xores.data.provider.tag;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOBlockTags;
import net.luis.xores.tags.XOItemTags;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOShieldItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static net.luis.xores.world.item.XOItems.*;
import static net.minecraft.world.item.Items.*;

/**
 *
 * @author Luis-st
 *
 */

public class XOItemTagsProvider extends ItemTagsProvider {
	
	public XOItemTagsProvider(@NotNull DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator.getPackOutput(), lookupProvider, blockTagsProvider, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	protected void addTags(@NotNull HolderLookup.Provider provider) {
		this.copy(XOBlockTags.JADE_ORES, XOItemTags.JADE_ORES);
		this.copy(XOBlockTags.SAPHIRE_ORES, XOItemTags.SAPHIRE_ORES);
		this.copy(XOBlockTags.LIMONITE_ORES, XOItemTags.LIMONITE_ORES);
		this.copy(XOBlockTags.ENDERITE_ORES, XOItemTags.ENDERITE_ORES);
		this.copy(XOBlockTags.ORE_BLOCKS, XOItemTags.ORE_BLOCKS);
		this.copy(Tags.Blocks.ORES, Tags.Items.ORES);
		this.copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
		this.copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
		
		this.tag(Tags.Items.INGOTS).add(JADE_INGOT.get(), BLAZING_INGOT.get(), SAPHIRE_INGOT.get(), LIMONITE_INGOT.get(), ENDERITE_INGOT.get(), STEEL_INGOT.get(), NIGHT_INGOT.get());
		
		this.tag(XOItemTags.WOOD).addTag(ItemTags.PLANKS).add(WOODEN_SWORD, WOODEN_PICKAXE, WOODEN_AXE, WOODEN_SHOVEL, WOODEN_HOE).add(SHIELD);
		this.tag(XOItemTags.LEATHER).add(LEATHER, LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS, LEATHER_HORSE_ARMOR);
		this.tag(XOItemTags.STONE).addTag(ItemTags.STONE_CRAFTING_MATERIALS).add(STONE_SWORD, STONE_PICKAXE, STONE_AXE, STONE_SHOVEL, STONE_HOE);
		this.tag(XOItemTags.CHAINMAIL).add(CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS);
		this.tag(XOItemTags.COPPER).add(RAW_COPPER, COPPER_INGOT).add(COPPER_SHIELD.get());
		this.tag(XOItemTags.GOLDEN).add(GOLD_NUGGET, RAW_GOLD, GOLD_INGOT, GOLDEN_SWORD, GOLDEN_PICKAXE, GOLDEN_AXE, GOLDEN_SHOVEL, GOLDEN_HOE).add(GOLDEN_SHIELD.get())
			.add(GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS, GOLDEN_HORSE_ARMOR);
		this.tag(XOItemTags.IRON).add(IRON_NUGGET, RAW_IRON, IRON_INGOT, IRON_SWORD, IRON_PICKAXE, IRON_AXE, IRON_SHOVEL, IRON_HOE).add(IRON_SHIELD.get()).add(IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS, IRON_HORSE_ARMOR);
		this.tag(XOItemTags.DIAMOND).add(DIAMOND, DIAMOND_SWORD, DIAMOND_PICKAXE, DIAMOND_AXE, DIAMOND_SHOVEL, DIAMOND_HOE).add(DIAMOND_SHIELD.get())
			.add(DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_ELYTRA_CHESTPLATE.get(), DIAMOND_LEGGINGS, DIAMOND_BOOTS, DIAMOND_HORSE_ARMOR);
		this.tag(XOItemTags.NETHERITE).add(NETHERITE_SCRAP, NETHERITE_INGOT, NETHERITE_SWORD, NETHERITE_PICKAXE, NETHERITE_AXE, NETHERITE_SHOVEL, NETHERITE_HOE).add(NETHERITE_BOW.get(), NETHERITE_CROSSBOW.get(), NETHERITE_SHIELD.get())
			.add(NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_ELYTRA_CHESTPLATE.get(), NETHERITE_LEGGINGS, NETHERITE_BOOTS);
		this.tag(XOItemTags.JADE).add(JADE_INGOT.get(), JADE_SWORD.get(), JADE_PICKAXE.get(), JADE_AXE.get(), JADE_SHOVEL.get(), JADE_HOE.get()).add(JADE_HELMET.get(), JADE_CHESTPLATE.get(), JADE_LEGGINGS.get(), JADE_BOOTS.get());
		this.tag(XOItemTags.BLAZING).add(BLAZING_INGOT.get(), BLAZING_SWORD.get(), BLAZING_PICKAXE.get(), BLAZING_AXE.get(), BLAZING_SHOVEL.get(), BLAZING_HOE.get())
			.add(BLAZING_HELMET.get(), BLAZING_CHESTPLATE.get(), BLAZING_LEGGINGS.get(), BLAZING_BOOTS.get());
		this.tag(XOItemTags.SAPHIRE).add(SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get(), SAPHIRE_SHIELD.get(), SAPHIRE_PICKAXE.get(), SAPHIRE_AXE.get(), SAPHIRE_SHOVEL.get(), SAPHIRE_HOE.get())
			.add(SAPHIRE_HELMET.get(), SAPHIRE_CHESTPLATE.get(), SAPHIRE_LEGGINGS.get(), SAPHIRE_BOOTS.get());
		this.tag(XOItemTags.LIMONITE).add(LIMONITE_INGOT.get(), LIMONITE_SWORD.get(), LIMONITE_PICKAXE.get(), LIMONITE_AXE.get(), LIMONITE_SHOVEL.get(), LIMONITE_HOE.get())
			.add(LIMONITE_HELMET.get(), LIMONITE_CHESTPLATE.get(), LIMONITE_LEGGINGS.get(), LIMONITE_BOOTS.get());
		this.tag(XOItemTags.ROSE_QUARTZ).add(ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get(), ROSE_QUARTZ_PICKAXE.get(), ROSE_QUARTZ_AXE.get(), ROSE_QUARTZ_SHOVEL.get(), ROSE_QUARTZ_HOE.get());
		this.tag(XOItemTags.ENDERITE).add(ENDERITE_SCRAP.get(), ENDERITE_INGOT.get(), ENDERITE_SWORD.get(), ENDERITE_PICKAXE.get(), ENDERITE_AXE.get(), ENDERITE_SHOVEL.get(), ENDERITE_HOE.get())
			.add(ENDERITE_SHIELD.get(), ENDERITE_BOW.get(), ENDERITE_CROSSBOW.get()).add(ENDERITE_HELMET.get(), ENDERITE_CHESTPLATE.get(), ENDERITE_ELYTRA_CHESTPLATE.get(), ENDERITE_LEGGINGS.get(), ENDERITE_BOOTS.get());
		this.tag(XOItemTags.STEEL).add(STEEL_INGOT.get(), STEEL_SWORD.get(), STEEL_PICKAXE.get(), STEEL_AXE.get(), STEEL_SHOVEL.get(), STEEL_HOE.get());
		this.tag(XOItemTags.NIGHT).add(NIGHT_SCRAP.get(), NIGHT_INGOT.get(), NIGHT_SWORD.get(), NIGHT_PICKAXE.get(), NIGHT_AXE.get(), NIGHT_SHOVEL.get(), NIGHT_HOE.get()).add(NIGHT_SHIELD.get(), NIGHT_BOW.get(), NIGHT_CROSSBOW.get())
			.add(NIGHT_HELMET.get(), NIGHT_CHESTPLATE.get(), NIGHT_ELYTRA_CHESTPLATE.get(), NIGHT_LEGGINGS.get(), NIGHT_BOOTS.get());
		
		IntrinsicTagAppender<Item> pickaxes = this.tag(XOItemTags.PICKAXES);
		IntrinsicTagAppender<Item> axes = this.tag(XOItemTags.AXES);
		IntrinsicTagAppender<Item> shovels = this.tag(XOItemTags.SHOVELS);
		IntrinsicTagAppender<Item> hoes = this.tag(XOItemTags.HOES);
		
		IntrinsicTagAppender<Item> swords = this.tag(XOItemTags.SWORDS);
		IntrinsicTagAppender<Item> shields = this.tag(XOItemTags.SHIELDS);
		IntrinsicTagAppender<Item> bows = this.tag(XOItemTags.BOWS);
		IntrinsicTagAppender<Item> crossbows = this.tag(XOItemTags.CROSSBOWS);
		
		IntrinsicTagAppender<Item> armor = this.tag(XOItemTags.ARMOR);
		IntrinsicTagAppender<Item> helmets = this.tag(XOItemTags.HELMETS);
		IntrinsicTagAppender<Item> chestplates = this.tag(XOItemTags.CHESTPLATES);
		IntrinsicTagAppender<Item> elytraChestplates = this.tag(XOItemTags.ELYTRA_CHESTPLATES);
		IntrinsicTagAppender<Item> leggings = this.tag(XOItemTags.LEGGINGS);
		IntrinsicTagAppender<Item> boots = this.tag(XOItemTags.BOOTS);
		
		for (Item item : ForgeRegistries.ITEMS) {
			if (item instanceof PickaxeItem) {
				pickaxes.add(item);
			} else if (item instanceof AxeItem) {
				axes.add(item);
			} else if (item instanceof ShovelItem) {
				shovels.add(item);
			} else if (item instanceof HoeItem) {
				hoes.add(item);
			} else if (item instanceof SwordItem) {
				swords.add(item);
			} else if (item instanceof XOShieldItem) {
				shields.add(item);
			} else if (item instanceof BowItem) {
				bows.add(item);
			} else if (item instanceof CrossbowItem) {
				crossbows.add(item);
			} else if (item instanceof ArmorItem armorItem) {
				armor.add(armorItem);
				switch (armorItem.getType()) {
					case HELMET -> helmets.add(armorItem);
					case CHESTPLATE -> {
						chestplates.add(armorItem);
						if (armorItem instanceof ElytraChestplateItem) {
							elytraChestplates.add(armorItem);
						}
					}
					case LEGGINGS -> leggings.add(armorItem);
					case BOOTS -> boots.add(armorItem);
					default -> throw new IllegalArgumentException(armorItem.getType() + " is not a valid EquipmentSlot for a ArmorItem");
				}
			}
		}
		
		this.tag(XOItemTags.SCRAPS).add(Items.NETHERITE_SCRAP).add(ENDERITE_SCRAP.get()).add(NIGHT_SCRAP.get());
		
		IntrinsicTagAppender<Item> toolLevel0 = this.tag(XOItemTags.TOOL_LEVEL_0);
		IntrinsicTagAppender<Item> toolLevel1 = this.tag(XOItemTags.TOOL_LEVEL_1);
		IntrinsicTagAppender<Item> toolLevel2 = this.tag(XOItemTags.TOOL_LEVEL_2);
		IntrinsicTagAppender<Item> toolLevel3 = this.tag(XOItemTags.TOOL_LEVEL_3);
		IntrinsicTagAppender<Item> toolLevel4 = this.tag(XOItemTags.TOOL_LEVEL_4);
		IntrinsicTagAppender<Item> toolLevel5 = this.tag(XOItemTags.TOOL_LEVEL_5);
		IntrinsicTagAppender<Item> toolLevel6 = this.tag(XOItemTags.TOOL_LEVEL_6);
		
		ForgeRegistries.ITEMS.getValues().stream().filter(item -> item instanceof TieredItem).map(item -> (TieredItem) item).forEach(item -> {
			switch (item.getTier().getLevel()) {
				case 0 -> toolLevel0.add(item);
				case 1 -> toolLevel1.add(item);
				case 2 -> toolLevel2.add(item);
				case 3 -> toolLevel3.add(item);
				case 4 -> toolLevel4.add(item);
				case 5 -> toolLevel5.add(item);
				case 6 -> toolLevel6.add(item);
				default -> {
				}
			}
		});
		
		IntrinsicTagAppender<Item> trimmable = this.tag(ItemTags.TRIMMABLE_ARMOR);
		ITEMS.getEntries().stream().map(RegistryObject::get).filter(item -> item instanceof ArmorItem && !(item instanceof ElytraChestplateItem)).forEach(trimmable::add);
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Item Tags";
	}
}
