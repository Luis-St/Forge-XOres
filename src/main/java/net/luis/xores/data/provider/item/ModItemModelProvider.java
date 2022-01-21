package net.luis.xores.data.provider.item;

import java.util.stream.Collectors;

import net.luis.xores.XOres;
import net.luis.xores.common.item.ElytraChestplateItem;
import net.luis.xores.init.ModItems;
import net.minecraft.client.renderer.block.model.BlockModel.GuiLight;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder.Perspective;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * 
 * @author Luis-st
 *
 */

public class ModItemModelProvider extends ItemModelProvider {

	public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, XOres.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		for (Item item : ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList())) {
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
	
	public void generatedItem(Item item) {
		ResourceLocation location = item.getRegistryName();
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	public void handheldItem(TieredItem tool) {
		ResourceLocation location = tool.getRegistryName();
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/handheld"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	public void elytraChestplateItem(ElytraChestplateItem elytraChestplate) {
		ResourceLocation location = elytraChestplate.getRegistryName();
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()))
			.override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "broken"), 1.0F).model(this.uncheckedModel("broken_" + location.getPath()))
			.end();
		this.getBuilder("broken_" + location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/broken_" + location.getPath()));
	}
	
	public void bowItem(BowItem bow) {
		ResourceLocation location = bow.getRegistryName();
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath()))
			.transforms()
				.transform(Perspective.THIRDPERSON_RIGHT).rotation(-80.0F, 260.0F, -40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end()
				.transform(Perspective.THIRDPERSON_LEFT).rotation(-80.0F, -280.0F, 40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end()
				.transform(Perspective.FIRSTPERSON_RIGHT).rotation(0.0F, -90.0F, 25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
				.transform(Perspective.FIRSTPERSON_LEFT).rotation(0.0F, 90.0F, -25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
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
	
	public void crossbowItem(CrossbowItem crossbow) {
		ResourceLocation location = crossbow.getRegistryName();
		ModelFile model = new ExistingModelFile(new ResourceLocation("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", new ResourceLocation(XOres.MOD_ID, "item/" + location.getPath() + "_standby"))
			.transforms()
				.transform(Perspective.THIRDPERSON_RIGHT).rotation(-90.0F, 0.0F, -60.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end()
				.transform(Perspective.THIRDPERSON_LEFT).rotation(-90.0F, 0.0F, 30.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end()
				.transform(Perspective.FIRSTPERSON_RIGHT).rotation(-90.0F, 0.0F, -55.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
				.transform(Perspective.FIRSTPERSON_LEFT).rotation(-90.0F, 0.0F, 35.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
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
	
	public void shieldItem(ShieldItem shield) {
		ResourceLocation location = shield.getRegistryName();
		ModelFile model = new UncheckedModelFile(new ResourceLocation("builtin/entity"));
		this.getBuilder(location.getPath()).parent(model).guiLight(GuiLight.FRONT).texture("particle", new ResourceLocation("block/dark_oak_planks"))
			.transforms()
				.transform(Perspective.THIRDPERSON_RIGHT).rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, -4.0F).scale(1.0F).end()
				.transform(Perspective.THIRDPERSON_LEFT).rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, 12.0F).scale(1.0F).end()
				.transform(Perspective.FIRSTPERSON_RIGHT).rotation(0.0F, 180.0F, 5.0F).translation(-10.0F, 2.0F, -10.0F).scale(1.25F).end()
				.transform(Perspective.FIRSTPERSON_LEFT).rotation(0.0F, 180.0F, 5.0F).translation(-10.0F, 0.0F, -10.0F).scale(1.25F).end()
				.transform(Perspective.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end()
				.transform(Perspective.FIXED).rotation(0.0F, 180.0F, 0.0F).translation(-2.0F, 4.0F, -5.0F).scale(0.5F).end()
				.transform(Perspective.GROUND).rotation(0.0F, 0.0F, 0.0F).translation(4.0F, 4.0F, 2.0F).scale(0.25F).end()
			.end().override()
				.predicate(new ResourceLocation(XOres.MOD_ID, "blocking"), 1.0F).model(this.uncheckedModel(location.getPath() + "_blocking"));
		this.getBuilder(location.getPath() + "_blocking").parent(model).guiLight(GuiLight.FRONT).texture("particle", new ResourceLocation("block/dark_oak_planks"))
			.transforms()
				.transform(Perspective.THIRDPERSON_RIGHT).rotation(45.0F, 135.0F, 0.0F).translation(3.51F, 11.0F, -2.0F).scale(1.0F).end()
				.transform(Perspective.THIRDPERSON_LEFT).rotation(45.0F, 135.0F, 0.0F).translation(13.51F, 630F, 5.0F).scale(1.0F).end()
				.transform(Perspective.FIRSTPERSON_RIGHT).rotation(0.0F, 180.0F, -5.0F).translation(-15.0F, 5.0F, -11.0F).scale(1.25F).end()
				.transform(Perspective.FIRSTPERSON_LEFT).rotation(0.0F, 180.0F, -5.0F).translation(5.0F, 5.0F, -11.0F).scale(1.25F).end()
				.transform(Perspective.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end()
			.end();
	}
	
	public ModelFile existingModel(String path) {
		return new ExistingModelFile(new ResourceLocation(XOres.MOD_ID, "item/" + path), this.existingFileHelper);
	}
	
	public ModelFile uncheckedModel(String path) {
		return new UncheckedModelFile(new ResourceLocation(XOres.MOD_ID, "item/" + path));
	}
	
	@Override
	public String getName() {
		return "XOres Item Models";
	}

}
