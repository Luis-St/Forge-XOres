package net.luis.xores.data.provider.tag;

import static net.luis.xores.init.ModItems.BLAZING_AXE;
import static net.luis.xores.init.ModItems.BLAZING_BOOTS;
import static net.luis.xores.init.ModItems.BLAZING_CHESTPLATE;
import static net.luis.xores.init.ModItems.BLAZING_HELMET;
import static net.luis.xores.init.ModItems.BLAZING_HOE;
import static net.luis.xores.init.ModItems.BLAZING_INGOT;
import static net.luis.xores.init.ModItems.BLAZING_LEGGINGS;
import static net.luis.xores.init.ModItems.BLAZING_PICKAXE;
import static net.luis.xores.init.ModItems.BLAZING_SHOVEL;
import static net.luis.xores.init.ModItems.BLAZING_SWORD;
import static net.luis.xores.init.ModItems.ENDERITE_AXE;
import static net.luis.xores.init.ModItems.ENDERITE_BOOTS;
import static net.luis.xores.init.ModItems.ENDERITE_BOW;
import static net.luis.xores.init.ModItems.ENDERITE_CHESTPLATE;
import static net.luis.xores.init.ModItems.ENDERITE_CROSSBOW;
import static net.luis.xores.init.ModItems.ENDERITE_ELYTRA_CHESTPLATE;
import static net.luis.xores.init.ModItems.ENDERITE_HELMET;
import static net.luis.xores.init.ModItems.ENDERITE_HOE;
import static net.luis.xores.init.ModItems.ENDERITE_INGOT;
import static net.luis.xores.init.ModItems.ENDERITE_LEGGINGS;
import static net.luis.xores.init.ModItems.ENDERITE_PICKAXE;
import static net.luis.xores.init.ModItems.ENDERITE_SCRAP;
import static net.luis.xores.init.ModItems.ENDERITE_SHIELD;
import static net.luis.xores.init.ModItems.ENDERITE_SHOVEL;
import static net.luis.xores.init.ModItems.ENDERITE_SWORD;
import static net.luis.xores.init.ModItems.ITEMS;
import static net.luis.xores.init.ModItems.JADE_AXE;
import static net.luis.xores.init.ModItems.JADE_BOOTS;
import static net.luis.xores.init.ModItems.JADE_CHESTPLATE;
import static net.luis.xores.init.ModItems.JADE_HELMET;
import static net.luis.xores.init.ModItems.JADE_HOE;
import static net.luis.xores.init.ModItems.JADE_INGOT;
import static net.luis.xores.init.ModItems.JADE_LEGGINGS;
import static net.luis.xores.init.ModItems.JADE_PICKAXE;
import static net.luis.xores.init.ModItems.JADE_SHOVEL;
import static net.luis.xores.init.ModItems.JADE_SWORD;
import static net.luis.xores.init.ModItems.LIMONITE_AXE;
import static net.luis.xores.init.ModItems.LIMONITE_BOOTS;
import static net.luis.xores.init.ModItems.LIMONITE_CHESTPLATE;
import static net.luis.xores.init.ModItems.LIMONITE_HELMET;
import static net.luis.xores.init.ModItems.LIMONITE_HOE;
import static net.luis.xores.init.ModItems.LIMONITE_INGOT;
import static net.luis.xores.init.ModItems.LIMONITE_LEGGINGS;
import static net.luis.xores.init.ModItems.LIMONITE_PICKAXE;
import static net.luis.xores.init.ModItems.LIMONITE_SHOVEL;
import static net.luis.xores.init.ModItems.LIMONITE_SWORD;
import static net.luis.xores.init.ModItems.NIGHT_AXE;
import static net.luis.xores.init.ModItems.NIGHT_BOOTS;
import static net.luis.xores.init.ModItems.NIGHT_BOW;
import static net.luis.xores.init.ModItems.NIGHT_CHESTPLATE;
import static net.luis.xores.init.ModItems.NIGHT_CROSSBOW;
import static net.luis.xores.init.ModItems.NIGHT_ELYTRA_CHESTPLATE;
import static net.luis.xores.init.ModItems.NIGHT_HELMET;
import static net.luis.xores.init.ModItems.NIGHT_HOE;
import static net.luis.xores.init.ModItems.NIGHT_INGOT;
import static net.luis.xores.init.ModItems.NIGHT_LEGGINGS;
import static net.luis.xores.init.ModItems.NIGHT_PICKAXE;
import static net.luis.xores.init.ModItems.NIGHT_SHARD;
import static net.luis.xores.init.ModItems.NIGHT_SHIELD;
import static net.luis.xores.init.ModItems.NIGHT_SHOVEL;
import static net.luis.xores.init.ModItems.NIGHT_SWORD;
import static net.luis.xores.init.ModItems.POLISHED_ROSE_QUARTZ;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ_AXE;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ_HOE;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ_PICKAXE;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ_SHOVEL;
import static net.luis.xores.init.ModItems.ROSE_QUARTZ_SWORD;
import static net.luis.xores.init.ModItems.ROSITE_AXE;
import static net.luis.xores.init.ModItems.ROSITE_HOE;
import static net.luis.xores.init.ModItems.ROSITE_INGOT;
import static net.luis.xores.init.ModItems.ROSITE_PICKAXE;
import static net.luis.xores.init.ModItems.ROSITE_SHOVEL;
import static net.luis.xores.init.ModItems.ROSITE_SWORD;
import static net.luis.xores.init.ModItems.SAPHIRE_AXE;
import static net.luis.xores.init.ModItems.SAPHIRE_BOOTS;
import static net.luis.xores.init.ModItems.SAPHIRE_CHESTPLATE;
import static net.luis.xores.init.ModItems.SAPHIRE_HELMET;
import static net.luis.xores.init.ModItems.SAPHIRE_HOE;
import static net.luis.xores.init.ModItems.SAPHIRE_INGOT;
import static net.luis.xores.init.ModItems.SAPHIRE_LEGGINGS;
import static net.luis.xores.init.ModItems.SAPHIRE_PICKAXE;
import static net.luis.xores.init.ModItems.SAPHIRE_SHIELD;
import static net.luis.xores.init.ModItems.SAPHIRE_SHOVEL;
import static net.luis.xores.init.ModItems.SAPHIRE_SWORD;
import static net.luis.xores.init.ModItems.STEEL_AXE;
import static net.luis.xores.init.ModItems.STEEL_HOE;
import static net.luis.xores.init.ModItems.STEEL_INGOT;
import static net.luis.xores.init.ModItems.STEEL_PICKAXE;
import static net.luis.xores.init.ModItems.STEEL_SHOVEL;
import static net.luis.xores.init.ModItems.STEEL_SWORD;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.item.ModShieldItem;
import net.luis.xores.init.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
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
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(generator, blockTagsProvider, XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		this.copy(ModTags.Blocks.JADE_ORES, ModTags.Items.JADE_ORES);
		this.copy(ModTags.Blocks.SAPHIRE_ORES, ModTags.Items.SAPHIRE_ORES);
		this.copy(ModTags.Blocks.LIMONITE_ORES, ModTags.Items.LIMONITE_ORES);
		this.copy(ModTags.Blocks.ROSITE_ORES, ModTags.Items.ROSITE_ORES);
		this.copy(ModTags.Blocks.ENDERITE_ORES, ModTags.Items.ENDERITE_ORES);
		this.copy(ModTags.Blocks.ORE_BLOCKS, ModTags.Items.ORE_BLOCKS);
		
		this.tag(Tags.Items.INGOTS).add(JADE_INGOT.get(), BLAZING_INGOT.get(), SAPHIRE_INGOT.get(), LIMONITE_INGOT.get(), ENDERITE_INGOT.get(), STEEL_INGOT.get(), NIGHT_INGOT.get());
		this.tag(ModTags.Items.SCRAPS).add(Items.NETHERITE_SCRAP).add(ENDERITE_SCRAP.get());
		this.tag(ModTags.Items.SHARDS).add(Items.AMETHYST_SHARD).add(NIGHT_SHARD.get());
		
		this.tag(ModTags.Items.JADE).add(JADE_INGOT.get(), JADE_SWORD.get(), JADE_PICKAXE.get(), JADE_AXE.get(), JADE_SHOVEL.get(), JADE_HOE.get())
				.add(JADE_HELMET.get(), JADE_CHESTPLATE.get(), JADE_LEGGINGS.get(), JADE_BOOTS.get());
		this.tag(ModTags.Items.BLAZING).add(BLAZING_INGOT.get(), BLAZING_SWORD.get(), BLAZING_PICKAXE.get(), BLAZING_AXE.get(), BLAZING_SHOVEL.get(), BLAZING_HOE.get())
				.add(BLAZING_HELMET.get(), BLAZING_CHESTPLATE.get(), BLAZING_LEGGINGS.get(), BLAZING_BOOTS.get());
		this.tag(ModTags.Items.SAPHIRE).add(SAPHIRE_INGOT.get(), SAPHIRE_SWORD.get(), SAPHIRE_PICKAXE.get(), SAPHIRE_AXE.get(), SAPHIRE_SHOVEL.get(), SAPHIRE_HOE.get())
				.add(SAPHIRE_SHIELD.get()).add(SAPHIRE_HELMET.get(), SAPHIRE_CHESTPLATE.get(), SAPHIRE_LEGGINGS.get(), SAPHIRE_BOOTS.get());
		this.tag(ModTags.Items.LIMONITE).add(LIMONITE_INGOT.get(), LIMONITE_SWORD.get(), LIMONITE_PICKAXE.get(), LIMONITE_AXE.get(), LIMONITE_SHOVEL.get(), LIMONITE_HOE.get())
				.add(LIMONITE_HELMET.get(), LIMONITE_CHESTPLATE.get(), LIMONITE_LEGGINGS.get(), LIMONITE_BOOTS.get());
		this.tag(ModTags.Items.ROSITE).add(ROSITE_INGOT.get(), ROSITE_SWORD.get(), ROSITE_PICKAXE.get(), ROSITE_AXE.get(), ROSITE_SHOVEL.get(), ROSITE_HOE.get());
		this.tag(ModTags.Items.ROSE_QUARTZ).add(ROSE_QUARTZ.get(), POLISHED_ROSE_QUARTZ.get(), ROSE_QUARTZ_SWORD.get(), ROSE_QUARTZ_PICKAXE.get(), ROSE_QUARTZ_AXE.get(), 
				ROSE_QUARTZ_SHOVEL.get(), ROSE_QUARTZ_HOE.get());
		this.tag(ModTags.Items.ENDERITE).add(ENDERITE_SCRAP.get(), ENDERITE_INGOT.get(), ENDERITE_SWORD.get(), ENDERITE_PICKAXE.get(), ENDERITE_AXE.get(), ENDERITE_SHOVEL.get(), ENDERITE_HOE.get())
				.add(ENDERITE_SHIELD.get(), ENDERITE_BOW.get(), ENDERITE_CROSSBOW.get())
				.add(ENDERITE_HELMET.get(), ENDERITE_CHESTPLATE.get(), ENDERITE_ELYTRA_CHESTPLATE.get(), ENDERITE_LEGGINGS.get(), ENDERITE_BOOTS.get());
		this.tag(ModTags.Items.STEEL).add(STEEL_INGOT.get(), STEEL_SWORD.get(), STEEL_PICKAXE.get(), STEEL_AXE.get(), STEEL_SHOVEL.get(), STEEL_HOE.get());
		this.tag(ModTags.Items.NIGHT).add(NIGHT_SHARD.get(), NIGHT_INGOT.get(), NIGHT_SWORD.get(), NIGHT_PICKAXE.get(), NIGHT_AXE.get(), NIGHT_SHOVEL.get(), NIGHT_HOE.get())
				.add(NIGHT_SHIELD.get(), NIGHT_BOW.get(), NIGHT_CROSSBOW.get())
				.add(NIGHT_HELMET.get(), NIGHT_CHESTPLATE.get(), NIGHT_ELYTRA_CHESTPLATE.get(), NIGHT_LEGGINGS.get(), NIGHT_BOOTS.get());
		
		TagAppender<Item> pickaxes = this.tag(ModTags.Items.PICKAXES);
		TagAppender<Item> axes = this.tag(ModTags.Items.AXES);
		TagAppender<Item> shovels = this.tag(ModTags.Items.SHOVELS);
		TagAppender<Item> hoes = this.tag(ModTags.Items.HOES);

		TagAppender<Item> swords = this.tag(ModTags.Items.SWORDS);
		TagAppender<Item> shields = this.tag(ModTags.Items.SHIELDS);
		TagAppender<Item> bows = this.tag(ModTags.Items.BOWS);
		TagAppender<Item> crossbows = this.tag(ModTags.Items.CROSSBOWS);
		
		TagAppender<Item> armor = this.tag(ModTags.Items.ARMOR);
		TagAppender<Item> helmets = this.tag(ModTags.Items.HELMETS);
		TagAppender<Item> chestplates = this.tag(ModTags.Items.CHESTPLATES);
		TagAppender<Item> elytraChestplates = this.tag(ModTags.Items.ELYTRA_CHESTPLATES);
		TagAppender<Item> leggings = this.tag(ModTags.Items.LEGGINGS);
		TagAppender<Item> boots = this.tag(ModTags.Items.BOOTS);
		
		for (Item item : ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
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
			} else if (item instanceof ModShieldItem) {
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
	}

	@Override
	public String getName() {
		return "XOres Item Tags";
	}
	
}
