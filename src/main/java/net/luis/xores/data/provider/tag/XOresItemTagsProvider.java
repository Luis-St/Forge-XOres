package net.luis.xores.data.provider.tag;

import static net.luis.xores.world.item.XOresItems.*;
import static net.minecraft.world.item.Items.CHAINMAIL_BOOTS;
import static net.minecraft.world.item.Items.CHAINMAIL_CHESTPLATE;
import static net.minecraft.world.item.Items.CHAINMAIL_HELMET;
import static net.minecraft.world.item.Items.CHAINMAIL_LEGGINGS;
import static net.minecraft.world.item.Items.COPPER_INGOT;
import static net.minecraft.world.item.Items.DIAMOND;
import static net.minecraft.world.item.Items.DIAMOND_AXE;
import static net.minecraft.world.item.Items.DIAMOND_BOOTS;
import static net.minecraft.world.item.Items.DIAMOND_CHESTPLATE;
import static net.minecraft.world.item.Items.DIAMOND_HELMET;
import static net.minecraft.world.item.Items.DIAMOND_HOE;
import static net.minecraft.world.item.Items.DIAMOND_HORSE_ARMOR;
import static net.minecraft.world.item.Items.DIAMOND_LEGGINGS;
import static net.minecraft.world.item.Items.DIAMOND_PICKAXE;
import static net.minecraft.world.item.Items.DIAMOND_SHOVEL;
import static net.minecraft.world.item.Items.DIAMOND_SWORD;
import static net.minecraft.world.item.Items.GOLDEN_AXE;
import static net.minecraft.world.item.Items.GOLDEN_BOOTS;
import static net.minecraft.world.item.Items.GOLDEN_CHESTPLATE;
import static net.minecraft.world.item.Items.GOLDEN_HELMET;
import static net.minecraft.world.item.Items.GOLDEN_HOE;
import static net.minecraft.world.item.Items.GOLDEN_HORSE_ARMOR;
import static net.minecraft.world.item.Items.GOLDEN_LEGGINGS;
import static net.minecraft.world.item.Items.GOLDEN_PICKAXE;
import static net.minecraft.world.item.Items.GOLDEN_SHOVEL;
import static net.minecraft.world.item.Items.GOLDEN_SWORD;
import static net.minecraft.world.item.Items.GOLD_INGOT;
import static net.minecraft.world.item.Items.GOLD_NUGGET;
import static net.minecraft.world.item.Items.IRON_AXE;
import static net.minecraft.world.item.Items.IRON_BOOTS;
import static net.minecraft.world.item.Items.IRON_CHESTPLATE;
import static net.minecraft.world.item.Items.IRON_HELMET;
import static net.minecraft.world.item.Items.IRON_HOE;
import static net.minecraft.world.item.Items.IRON_HORSE_ARMOR;
import static net.minecraft.world.item.Items.IRON_INGOT;
import static net.minecraft.world.item.Items.IRON_LEGGINGS;
import static net.minecraft.world.item.Items.IRON_NUGGET;
import static net.minecraft.world.item.Items.IRON_PICKAXE;
import static net.minecraft.world.item.Items.IRON_SHOVEL;
import static net.minecraft.world.item.Items.IRON_SWORD;
import static net.minecraft.world.item.Items.LEATHER;
import static net.minecraft.world.item.Items.LEATHER_BOOTS;
import static net.minecraft.world.item.Items.LEATHER_CHESTPLATE;
import static net.minecraft.world.item.Items.LEATHER_HELMET;
import static net.minecraft.world.item.Items.LEATHER_HORSE_ARMOR;
import static net.minecraft.world.item.Items.LEATHER_LEGGINGS;
import static net.minecraft.world.item.Items.NETHERITE_AXE;
import static net.minecraft.world.item.Items.NETHERITE_BOOTS;
import static net.minecraft.world.item.Items.NETHERITE_CHESTPLATE;
import static net.minecraft.world.item.Items.NETHERITE_HELMET;
import static net.minecraft.world.item.Items.NETHERITE_HOE;
import static net.minecraft.world.item.Items.NETHERITE_INGOT;
import static net.minecraft.world.item.Items.NETHERITE_LEGGINGS;
import static net.minecraft.world.item.Items.NETHERITE_PICKAXE;
import static net.minecraft.world.item.Items.NETHERITE_SCRAP;
import static net.minecraft.world.item.Items.NETHERITE_SHOVEL;
import static net.minecraft.world.item.Items.NETHERITE_SWORD;
import static net.minecraft.world.item.Items.RAW_COPPER;
import static net.minecraft.world.item.Items.RAW_GOLD;
import static net.minecraft.world.item.Items.RAW_IRON;
import static net.minecraft.world.item.Items.SHIELD;
import static net.minecraft.world.item.Items.STONE_AXE;
import static net.minecraft.world.item.Items.STONE_HOE;
import static net.minecraft.world.item.Items.STONE_PICKAXE;
import static net.minecraft.world.item.Items.STONE_SHOVEL;
import static net.minecraft.world.item.Items.STONE_SWORD;
import static net.minecraft.world.item.Items.WOODEN_AXE;
import static net.minecraft.world.item.Items.WOODEN_HOE;
import static net.minecraft.world.item.Items.WOODEN_PICKAXE;
import static net.minecraft.world.item.Items.WOODEN_SHOVEL;
import static net.minecraft.world.item.Items.WOODEN_SWORD;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.tags.XOresBlockTags;
import net.luis.xores.tags.XOresItemTags;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOresShieldItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * 
 * @author Luis-st
 *
 */

public class XOresItemTagsProvider extends ItemTagsProvider {
	
	public XOresItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(generator, blockTagsProvider, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	protected void addTags() {
		this.copy(XOresBlockTags.JADE_ORES, XOresItemTags.JADE_ORES);
		this.copy(XOresBlockTags.SAPHIRE_ORES, XOresItemTags.SAPHIRE_ORES);
		this.copy(XOresBlockTags.LIMONITE_ORES, XOresItemTags.LIMONITE_ORES);
		this.copy(XOresBlockTags.ROSITE_ORES, XOresItemTags.ROSITE_ORES);
		this.copy(XOresBlockTags.ENDERITE_ORES, XOresItemTags.ENDERITE_ORES);
		this.copy(XOresBlockTags.ORE_BLOCKS, XOresItemTags.ORE_BLOCKS);
		this.copy(Tags.Blocks.ORES, Tags.Items.ORES);
		this.copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
		this.copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
		
		this.tag(Tags.Items.INGOTS).add(JADE_INGOT.get(), BLAZING_INGOT.get(), SAPHIRE_INGOT.get(), LIMONITE_INGOT.get(), ENDERITE_INGOT.get(), STEEL_INGOT.get(), NIGHT_INGOT.get());
		
		this.tag(XOresItemTags.WOOD).addTag(ItemTags.PLANKS).add(WOODEN_SWORD, WOODEN_PICKAXE, WOODEN_AXE, WOODEN_SHOVEL, WOODEN_HOE).add(SHIELD);
		this.tag(XOresItemTags.LEATHER).add(LEATHER, LEATHER_HELMET, LEATHER_CHESTPLATE, LEATHER_LEGGINGS, LEATHER_BOOTS, LEATHER_HORSE_ARMOR);
		this.tag(XOresItemTags.STONE).addTag(ItemTags.STONE_CRAFTING_MATERIALS).add(STONE_SWORD, STONE_PICKAXE, STONE_AXE, STONE_SHOVEL, STONE_HOE);
		this.tag(XOresItemTags.CHAINMAIL).add(CHAINMAIL_HELMET, CHAINMAIL_CHESTPLATE, CHAINMAIL_LEGGINGS, CHAINMAIL_BOOTS);
		this.tag(XOresItemTags.COPPER).add(RAW_COPPER, COPPER_INGOT).add(COPPER_SHIELD.get());
		this.tag(XOresItemTags.GOLDEN).add(GOLD_NUGGET, RAW_GOLD, GOLD_INGOT, GOLDEN_SWORD, GOLDEN_PICKAXE, GOLDEN_AXE, GOLDEN_SHOVEL, GOLDEN_HOE)
				.add(GOLDEN_SHIELD.get()).add(GOLDEN_HELMET, GOLDEN_CHESTPLATE, GOLDEN_LEGGINGS, GOLDEN_BOOTS, GOLDEN_HORSE_ARMOR);
		this.tag(XOresItemTags.IRON).add(IRON_NUGGET, RAW_IRON, IRON_INGOT, IRON_SWORD, IRON_PICKAXE, IRON_AXE, IRON_SHOVEL, IRON_HOE)
				.add(IRON_SHIELD.get()).add(IRON_HELMET, IRON_CHESTPLATE, IRON_LEGGINGS, IRON_BOOTS, IRON_HORSE_ARMOR);
		this.tag(XOresItemTags.DIAMOND).add(DIAMOND, DIAMOND_SWORD, DIAMOND_PICKAXE, DIAMOND_AXE, DIAMOND_SHOVEL, DIAMOND_HOE)
				.add(DIAMOND_SHIELD.get()).add(DIAMOND_HELMET, DIAMOND_CHESTPLATE, DIAMOND_ELYTRA_CHESTPLATE.get(), DIAMOND_LEGGINGS, DIAMOND_BOOTS, DIAMOND_HORSE_ARMOR);
		this.tag(XOresItemTags.NETHERITE).add(NETHERITE_SCRAP, NETHERITE_INGOT, NETHERITE_SWORD, NETHERITE_PICKAXE, NETHERITE_AXE, NETHERITE_SHOVEL, NETHERITE_HOE)
				.add(NETHERITE_BOW.get(), NETHERITE_CROSSBOW.get(), NETHERITE_SHIELD.get()).add(NETHERITE_HELMET, NETHERITE_CHESTPLATE, NETHERITE_ELYTRA_CHESTPLATE.get(), NETHERITE_LEGGINGS, NETHERITE_BOOTS);
		this.tag(XOresItemTags.JADE).add(JADE_INGOT.get(), JADE_SWORD.get(), JADE_PICKAXE.get(), JADE_AXE.get(), JADE_SHOVEL.get(), JADE_HOE.get())
					.add(JADE_HELMET.get(), JADE_CHESTPLATE.get(), JADE_LEGGINGS.get(), JADE_BOOTS.get());
		this.tag(XOresItemTags.BLAZING).add(BLAZING_INGOT.get(), BLAZING_SWORD.get(), BLAZING_PICKAXE.get(), BLAZING_AXE.get(), BLAZING_SHOVEL.get(), BLAZING_HOE.get())
				.add(BLAZING_HELMET.get(), BLAZING_CHESTPLATE.get(), BLAZING_LEGGINGS.get(), BLAZING_BOOTS.get());
		this.tag(XOresItemTags.SAPHIRE).add(SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get(), SAPHIRE_SHIELD.get(), SAPHIRE_PICKAXE.get(), SAPHIRE_AXE.get(), SAPHIRE_SHOVEL.get(), SAPHIRE_HOE.get())
				.add(SAPHIRE_HELMET.get(), SAPHIRE_CHESTPLATE.get(), SAPHIRE_LEGGINGS.get(), SAPHIRE_BOOTS.get());
		this.tag(XOresItemTags.LIMONITE).add(LIMONITE_INGOT.get(), LIMONITE_SWORD.get(), LIMONITE_PICKAXE.get(), LIMONITE_AXE.get(), LIMONITE_SHOVEL.get(), LIMONITE_HOE.get())
				.add(LIMONITE_HELMET.get(), LIMONITE_CHESTPLATE.get(), LIMONITE_LEGGINGS.get(), LIMONITE_BOOTS.get());
		this.tag(XOresItemTags.ROSITE).add(ROSITE_INGOT.get(), ROSITE_SWORD.get(), ROSITE_PICKAXE.get(), ROSITE_AXE.get(), ROSITE_SHOVEL.get(), ROSITE_HOE.get());
		this.tag(XOresItemTags.ROSE_QUARTZ).add(ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get(), ROSE_QUARTZ_PICKAXE.get(), ROSE_QUARTZ_AXE.get(), 
				ROSE_QUARTZ_SHOVEL.get(), ROSE_QUARTZ_HOE.get());
		this.tag(XOresItemTags.ENDERITE).add(ENDERITE_SCRAP.get(), ENDERITE_INGOT.get(), ENDERITE_SWORD.get(), ENDERITE_PICKAXE.get(), ENDERITE_AXE.get(), ENDERITE_SHOVEL.get(), ENDERITE_HOE.get())
				.add(ENDERITE_SHIELD.get(), ENDERITE_BOW.get(), ENDERITE_CROSSBOW.get())
				.add(ENDERITE_HELMET.get(), ENDERITE_CHESTPLATE.get(), ENDERITE_ELYTRA_CHESTPLATE.get(), ENDERITE_LEGGINGS.get(), ENDERITE_BOOTS.get());
		this.tag(XOresItemTags.STEEL).add(STEEL_INGOT.get(), STEEL_SWORD.get(), STEEL_PICKAXE.get(), STEEL_AXE.get(), STEEL_SHOVEL.get(), STEEL_HOE.get());
		this.tag(XOresItemTags.NIGHT).add(NIGHT_SCRAP.get(), NIGHT_INGOT.get(), NIGHT_SWORD.get(), NIGHT_PICKAXE.get(), NIGHT_AXE.get(), NIGHT_SHOVEL.get(), NIGHT_HOE.get())
				.add(NIGHT_SHIELD.get(), NIGHT_BOW.get(), NIGHT_CROSSBOW.get())
				.add(NIGHT_HELMET.get(), NIGHT_CHESTPLATE.get(), NIGHT_ELYTRA_CHESTPLATE.get(), NIGHT_LEGGINGS.get(), NIGHT_BOOTS.get());
		
		TagAppender<Item> pickaxes = this.tag(XOresItemTags.PICKAXES);
		TagAppender<Item> axes = this.tag(XOresItemTags.AXES);
		TagAppender<Item> shovels = this.tag(XOresItemTags.SHOVELS);
		TagAppender<Item> hoes = this.tag(XOresItemTags.HOES);

		TagAppender<Item> swords = this.tag(XOresItemTags.SWORDS);
		TagAppender<Item> shields = this.tag(XOresItemTags.SHIELDS);
		TagAppender<Item> bows = this.tag(XOresItemTags.BOWS);
		TagAppender<Item> crossbows = this.tag(XOresItemTags.CROSSBOWS);
		
		TagAppender<Item> armor = this.tag(XOresItemTags.ARMOR);
		TagAppender<Item> helmets = this.tag(XOresItemTags.HELMETS);
		TagAppender<Item> chestplates = this.tag(XOresItemTags.CHESTPLATES);
		TagAppender<Item> elytraChestplates = this.tag(XOresItemTags.ELYTRA_CHESTPLATES);
		TagAppender<Item> leggings = this.tag(XOresItemTags.LEGGINGS);
		TagAppender<Item> boots = this.tag(XOresItemTags.BOOTS);
		
		for (Item item : this.registry) {
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
			} else if (item instanceof XOresShieldItem) {
				shields.add(item);
			} else if (item instanceof BowItem) {
				bows.add(item);
			} else if (item instanceof CrossbowItem) {
				crossbows.add(item);
			} else if (item instanceof ArmorItem armorItem) {
				armor.add(armorItem);
				switch (armorItem.getSlot()) {
				case HEAD: helmets.add(armorItem); break;
				case CHEST: {
					chestplates.add(armorItem);
					if (armorItem instanceof ElytraChestplateItem) {
						elytraChestplates.add(armorItem);
					}
				} break;
				case LEGS: leggings.add(armorItem); break;
				case FEET: boots.add(armorItem); break;
				default:
					throw new IllegalArgumentException(armorItem.getSlot() + " is not a valid EquipmentSlot for a ArmorItem");
				}
			}
		}
		
		this.tag(XOresItemTags.SCRAPS).add(Items.NETHERITE_SCRAP).add(ENDERITE_SCRAP.get()).add(NIGHT_SCRAP.get());
		
		TagAppender<Item> toolLevel0 = this.tag(XOresItemTags.TOOL_LEVEL_0);
		TagAppender<Item> toolLevel1 = this.tag(XOresItemTags.TOOL_LEVEL_1);
		TagAppender<Item> toolLevel2 = this.tag(XOresItemTags.TOOL_LEVEL_2);
		TagAppender<Item> toolLevel3 = this.tag(XOresItemTags.TOOL_LEVEL_3);
		TagAppender<Item> toolLevel4 = this.tag(XOresItemTags.TOOL_LEVEL_4);
		TagAppender<Item> toolLevel5 = this.tag(XOresItemTags.TOOL_LEVEL_5);
		TagAppender<Item> toolLevel6 = this.tag(XOresItemTags.TOOL_LEVEL_6);
		
		for (TieredItem item : this.registry.stream().filter(item -> item instanceof TieredItem).map(item -> (TieredItem) item).collect(Collectors.toList())) {
			switch (item.getTier().getLevel()) {
			case 0: toolLevel0.add(item); break;
			case 1: toolLevel1.add(item); break;
			case 2: toolLevel2.add(item); break;
			case 3: toolLevel3.add(item); break;
			case 4: toolLevel4.add(item); break;
			case 5: toolLevel5.add(item); break;
			case 6: toolLevel6.add(item); break;
			default: break;
			}
		}
	}
	
	@Override
	public String getName() {
		return "XOres Item Tags";
	}
	
}
