package net.luis.xores.data.provider.item;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOresItems;
import net.minecraft.client.renderer.block.model.BlockModel.GuiLight;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * extension of {@link ItemModelProvider}, called by {@link GatherDataEvent},<br>
 * used to generate the models for all mod {@link Item}s
 * 
 * @author Luis-st
 */

public class XOresItemModelProvider extends ItemModelProvider {

	/**
	 * constructor for the {@link ModItemModelProvider}
	 */
	public XOresItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}

	/**
	 * register all item models for {@link XOresItems#ITEMS}
	 */
	@Override
	protected void registerModels() {
		for (Item item : XOresItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
			if (item instanceof TieredItem tieredItem) {
				this.handheldItem(tieredItem);
			} else if (item instanceof BowItem bowItem) {
				this.bowItem(bowItem);
			} else if (item instanceof CrossbowItem crossbowItem) {
				this.crossbowItem(crossbowItem);
			} else if (item instanceof ShieldItem shieldItem) {
				this.shieldItem(shieldItem);		
			} else if (item instanceof ElytraChestplateItem elytraChestplateItem) {
				this.elytraChestplateItem(elytraChestplateItem);
			} else {
				this.generatedItem(item);
			}
		}
	}
	
	/**
	 * register a generated item model for the given {@link Item}
	 */
	protected void generatedItem(Item item) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	/**
	 * register a handheld item model for the given {@link TieredItem}
	 */
	protected void handheldItem(TieredItem tool) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(tool);
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/handheld"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	/**
	 * register a elytra chestplate item model for the given {@link ElytraChestplateItem}
	 */
	protected void elytraChestplateItem(ElytraChestplateItem elytraChestplate) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(elytraChestplate);
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()))
			.override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "broken"), 1.0F).model(this.uncheckedModel("broken_" + location.getPath()))
			.end();
		this.getBuilder("broken_" + location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/broken_" + location.getPath()));
	}
	
	/**
	 * register a bow item model for the given {@link BowItem}
	 */
	protected void bowItem(BowItem bow) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(bow);
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()))
			.transforms()
				.transform(TransformType.THIRD_PERSON_RIGHT_HAND).rotation(-80.0F, 260.0F, -40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end()
				.transform(TransformType.THIRD_PERSON_LEFT_HAND).rotation(-80.0F, -280.0F, 40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end()
				.transform(TransformType.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, -90.0F, 25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
				.transform(TransformType.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 90.0F, -25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_0"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).predicate(new ResourceLocation(XOres.MOD_ID, "pull"),  0.65F).model(this.uncheckedModel(location.getPath() + "_pulling_1"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).predicate(new ResourceLocation(XOres.MOD_ID, "pull"),  0.9F).model(this.uncheckedModel(location.getPath() + "_pulling_2"))
			.end();
		for (int i = 0; i < 3; i++) {
			this.getBuilder(location.getPath() + "_pulling_" + i).parent(this.uncheckedModel(location.getPath())).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_pulling_" + i));
		}
	}
	
	/**
	 * register a crossbow item model for the given {@link CrossbowItem}
	 */
	protected void crossbowItem(CrossbowItem crossbow) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(crossbow);
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_standby"))
			.transforms()
				.transform(TransformType.THIRD_PERSON_RIGHT_HAND).rotation(-90.0F, 0.0F, -60.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end()
				.transform(TransformType.THIRD_PERSON_LEFT_HAND).rotation(-90.0F, 0.0F, 30.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end()
				.transform(TransformType.FIRST_PERSON_RIGHT_HAND).rotation(-90.0F, 0.0F, -55.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
				.transform(TransformType.FIRST_PERSON_LEFT_HAND).rotation(-90.0F, 0.0F, 35.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_0"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).predicate(new ResourceLocation(XOres.MOD_ID, "pull"), 0.58F).model(this.uncheckedModel(location.getPath() + "_pulling_1"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "pulling"), 1.0F).predicate(new ResourceLocation(XOres.MOD_ID, "pull"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_2"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "charged"), 1.0F).model(this.uncheckedModel(location.getPath() + "_arrow"))
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "charged"), 1.0F).predicate(new ResourceLocation(XOres.MOD_ID, "firework"), 1.0F).model(this.uncheckedModel(location.getPath() + "_firework"))
			.end();
		for (int i = 0; i < 3; i++) {
			this.getBuilder(location.getPath() + "_pulling_" + i).parent(this.uncheckedModel(location.getPath())).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_pulling_" + i));
		}
		this.getBuilder(location.getPath() + "_arrow").parent(this.uncheckedModel(location.getPath())).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_arrow"));
		this.getBuilder(location.getPath() + "_firework").parent(this.uncheckedModel(location.getPath())).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_firework"));
	}
	
	/**
	 * register a shield item model for the given {@link ShieldItem}
	 */
	protected void shieldItem(ShieldItem shield) {
		ResourceLocation location = ForgeRegistries.ITEMS.getKey(shield);
		ModelFile model = new UncheckedModelFile(new ResourceLocation("builtin/entity"));
		this.getBuilder(location.getPath()).parent(model).guiLight(GuiLight.FRONT).texture("particle", new ResourceLocation("block/dark_oak_planks"))
			.transforms()
				.transform(TransformType.THIRD_PERSON_RIGHT_HAND).rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, -4.0F).scale(1.0F).end()
				.transform(TransformType.THIRD_PERSON_LEFT_HAND).rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, 12.0F).scale(1.0F).end()
				.transform(TransformType.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, 180.0F, 5.0F).translation(-10.0F, 2.0F, -10.0F).scale(1.25F).end()
				.transform(TransformType.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 180.0F, 5.0F).translation(-10.0F, 0.0F, -10.0F).scale(1.25F).end()
				.transform(TransformType.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end()
				.transform(TransformType.FIXED).rotation(0.0F, 180.0F, 0.0F).translation(-2.0F, 4.0F, -5.0F).scale(0.5F).end()
				.transform(TransformType.GROUND).rotation(0.0F, 0.0F, 0.0F).translation(4.0F, 4.0F, 2.0F).scale(0.25F).end()
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "blocking"), 1.0F).model(this.uncheckedModel(location.getPath() + "_blocking"));
		this.getBuilder(location.getPath() + "_blocking").parent(model).guiLight(GuiLight.FRONT).texture("particle", new ResourceLocation("block/dark_oak_planks"))
			.transforms()
				.transform(TransformType.THIRD_PERSON_RIGHT_HAND).rotation(45.0F, 135.0F, 0.0F).translation(3.51F, 11.0F, -2.0F).scale(1.0F).end()
				.transform(TransformType.THIRD_PERSON_LEFT_HAND).rotation(45.0F, 135.0F, 0.0F).translation(13.51F, 630F, 5.0F).scale(1.0F).end()
				.transform(TransformType.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, 180.0F, -5.0F).translation(-15.0F, 5.0F, -11.0F).scale(1.25F).end()
				.transform(TransformType.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 180.0F, -5.0F).translation(5.0F, 5.0F, -11.0F).scale(1.25F).end()
				.transform(TransformType.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end()
			.end();
	}
	
	/**
	 * @return a {@link ExistingModelFile} for the given path
	 */
	protected ModelFile existingModel(String path) {
		return new ExistingModelFile(new ResourceLocation(XOres.MOD_ID, "item/" + path), this.existingFileHelper);
	}
	
	/**
	 * @return a {@link UncheckedModelFile} for the given path
	 */
	protected ModelFile uncheckedModel(String path) {
		return new UncheckedModelFile(new ResourceLocation(XOres.MOD_ID, "item/" + path));
	}
	
	/**
	 * @return the name of the {@link DataProvider}
	 */
	@Override
	public String getName() {
		return "XOres Item Models";
	}

}
