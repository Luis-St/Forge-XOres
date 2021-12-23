package net.luis.xores.data.provider.tag;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.common.item.ModShieldItem;
import net.luis.xores.init.ModItems;
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
		
		this.tag(Tags.Items.INGOTS).add(ModItems.JADE_INGOT.get(), ModItems.BLAZING_INGOT.get(), ModItems.SAPHIRE_INGOT.get(), ModItems.LIMONITE_INGOT.get(), ModItems.ENDERITE_INGOT.get(), ModItems.STEEL_INGOT.get(), ModItems.NIGHT_INGOT.get());
		this.tag(ModTags.Items.SCRAPS).add(Items.NETHERITE_SCRAP).add(ModItems.ENDERITE_SCRAP.get());
		this.tag(ModTags.Items.SHARDS).add(Items.AMETHYST_SHARD).add(ModItems.NIGHT_SHARD.get());
		
		this.tag(ModTags.Items.JADE).add(ModItems.JADE_INGOT.get(), ModItems.JADE_SWORD.get(), ModItems.JADE_PICKAXE.get(), ModItems.JADE_AXE.get(), ModItems.JADE_SHOVEL.get(), ModItems.JADE_HOE.get())
				.add(ModItems.JADE_HELMET.get(), ModItems.JADE_CHESTPLATE.get(), ModItems.JADE_LEGGINGS.get(), ModItems.JADE_BOOTS.get());
		this.tag(ModTags.Items.BLAZING).add(ModItems.BLAZING_INGOT.get(), ModItems.BLAZING_SWORD.get(), ModItems.BLAZING_PICKAXE.get(), ModItems.BLAZING_AXE.get(), ModItems.BLAZING_SHOVEL.get(), ModItems.BLAZING_HOE.get())
				.add(ModItems.BLAZING_HELMET.get(), ModItems.BLAZING_CHESTPLATE.get(), ModItems.BLAZING_LEGGINGS.get(), ModItems.BLAZING_BOOTS.get());
		this.tag(ModTags.Items.SAPHIRE).add(ModItems.SAPHIRE_INGOT.get(), ModItems.SAPHIRE_SWORD.get(), ModItems.SAPHIRE_PICKAXE.get(), ModItems.SAPHIRE_AXE.get(), ModItems.SAPHIRE_SHOVEL.get(), ModItems.SAPHIRE_HOE.get())
				.add(ModItems.SAPHIRE_SHIELD.get()).add(ModItems.SAPHIRE_HELMET.get(), ModItems.SAPHIRE_CHESTPLATE.get(), ModItems.SAPHIRE_LEGGINGS.get(), ModItems.SAPHIRE_BOOTS.get());
		this.tag(ModTags.Items.LIMONITE).add(ModItems.LIMONITE_INGOT.get(), ModItems.LIMONITE_SWORD.get(), ModItems.LIMONITE_PICKAXE.get(), ModItems.LIMONITE_AXE.get(), ModItems.LIMONITE_SHOVEL.get(), ModItems.LIMONITE_HOE.get())
				.add(ModItems.LIMONITE_HELMET.get(), ModItems.LIMONITE_CHESTPLATE.get(), ModItems.LIMONITE_LEGGINGS.get(), ModItems.LIMONITE_BOOTS.get());
		this.tag(ModTags.Items.ROSITE).add(ModItems.ROSITE_INGOT.get(), ModItems.ROSITE_SWORD.get(), ModItems.ROSITE_PICKAXE.get(), ModItems.ROSITE_AXE.get(), ModItems.ROSITE_SHOVEL.get(), ModItems.ROSITE_HOE.get());
		this.tag(ModTags.Items.ROSE_QUARTZ).add(ModItems.ROSE_QUARTZ.get(), ModItems.POLISHED_ROSE_QUARTZ.get(), ModItems.ROSE_QUARTZ_SWORD.get(), ModItems.ROSE_QUARTZ_PICKAXE.get(), ModItems.ROSE_QUARTZ_AXE.get(), 
				ModItems.ROSE_QUARTZ_SHOVEL.get(), ModItems.ROSE_QUARTZ_HOE.get());
		this.tag(ModTags.Items.ENDERITE).add(ModItems.ENDERITE_SCRAP.get(), ModItems.ENDERITE_INGOT.get(), ModItems.ENDERITE_SWORD.get(), ModItems.ENDERITE_PICKAXE.get(), ModItems.ENDERITE_AXE.get(), ModItems.ENDERITE_SHOVEL.get(), ModItems.ENDERITE_HOE.get())
				.add(ModItems.ENDERITE_SHIELD.get(), ModItems.ENDERITE_BOW.get(), ModItems.ENDERITE_CROSSBOW.get())
				.add(ModItems.ENDERITE_HELMET.get(), ModItems.ENDERITE_CHESTPLATE.get(), ModItems.ENDERITE_ELYTRA_CHESTPLATE.get(), ModItems.ENDERITE_LEGGINGS.get(), ModItems.ENDERITE_BOOTS.get());
		this.tag(ModTags.Items.STEEL).add(ModItems.STEEL_INGOT.get(), ModItems.STEEL_SWORD.get(), ModItems.STEEL_PICKAXE.get(), ModItems.STEEL_AXE.get(), ModItems.STEEL_SHOVEL.get(), ModItems.STEEL_HOE.get());
		this.tag(ModTags.Items.NIGHT).add(ModItems.NIGHT_SHARD.get(), ModItems.NIGHT_INGOT.get(), ModItems.NIGHT_SWORD.get(), ModItems.NIGHT_PICKAXE.get(), ModItems.NIGHT_AXE.get(), ModItems.NIGHT_SHOVEL.get(), ModItems.NIGHT_HOE.get())
				.add(ModItems.NIGHT_SHIELD.get(), ModItems.NIGHT_BOW.get(), ModItems.NIGHT_CROSSBOW.get())
				.add(ModItems.NIGHT_HELMET.get(), ModItems.NIGHT_CHESTPLATE.get(), ModItems.NIGHT_ELYTRA_CHESTPLATE.get(), ModItems.NIGHT_LEGGINGS.get(), ModItems.NIGHT_BOOTS.get());
		
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
		
		for (Item item : ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
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
