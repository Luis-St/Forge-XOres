/*
 * XOres
 * Copyright (C) 2024 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xores.data.provider.base.client;

import net.luis.xores.XOres;
import net.luis.xores.world.item.ElytraChestplateItem;
import net.luis.xores.world.item.XOItems;
import net.minecraft.client.renderer.block.model.BlockModel.GuiLight;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 * @author Luis-St
 *
 */

public class XOItemModelProvider extends ItemModelProvider {
	
	private static final String[] TRIMS = { "amethyst", "copper", "diamond", "emerald", "gold", "iron", "lapis", "netherite", "quartz", "redstone" };
	
	public XOItemModelProvider(@NotNull DataGenerator generator, @NotNull ExistingFileHelper existingFileHelper) {
		super(generator.getPackOutput(), XOres.MOD_ID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		for (String trim : TRIMS) {
			for (ArmorType type : ArmorType.values()) {
				if (type == ArmorType.BODY) {
					continue;
				}
				this.existingFileHelper.trackGenerated(ResourceLocation.withDefaultNamespace("trims/items/" + this.getArmorType(type.getSlot()) + "_trim_" + trim), PackType.CLIENT_RESOURCES, ".png", "textures");
			}
		}
		for (Item item : XOItems.ITEMS.getEntries().stream().map(RegistryObject::get).toList()) {
			switch (item) {
				case SwordItem swordItem -> this.handheldItem(swordItem);
				case DiggerItem diggerItem -> this.handheldItem(diggerItem);
				case BowItem bowItem -> this.bowItem(bowItem);
				case CrossbowItem crossbowItem -> this.crossbowItem(crossbowItem);
				case ShieldItem shieldItem -> this.shieldItem(shieldItem);
				case ElytraChestplateItem elytraChestplateItem -> this.elytraChestplateItem(elytraChestplateItem);
				case ArmorItem armorItem -> this.armorItem(armorItem);
				case null -> throw new NullPointerException("Item is null");
				default -> this.generatedItem(item);
			}
		}
	}
	
	//region Item model helpers
	private void generatedItem(@NotNull Item item) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	private void handheldItem(@NotNull Item tool) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(tool));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/handheld"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath()));
	}
	
	private void elytraChestplateItem(@NotNull ElytraChestplateItem elytraChestplate) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(elytraChestplate));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath())).override().predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "broken"), 1.0F)
			.model(this.uncheckedModel("broken_" + location.getPath())).end();
		this.getBuilder("broken_" + location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/broken_" + location.getPath()));
	}
	
	private void bowItem(@NotNull BowItem bow) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(bow));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath())).transforms().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
			.rotation(-80.0F, 260.0F, -40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(-80.0F, -280.0F, 40.0F).translation(-1.0F, -2.0F, 2.5F).scale(0.9F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, -90.0F, 25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 90.0F, -25.0F)
			.translation(1.13F, 3.2F, 1.13F).scale(0.68F).end().end().override().predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_0")).end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), 0.65F).model(this.uncheckedModel(location.getPath() + "_pulling_1")).end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), 0.9F).model(this.uncheckedModel(location.getPath() + "_pulling_2")).end();
		for (int i = 0; i < 3; i++) {
			this.getBuilder(location.getPath() + "_pulling_" + i).parent(this.uncheckedModel(location.getPath())).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath() + "_pulling_" + i));
		}
	}
	
	private void crossbowItem(@NotNull CrossbowItem crossbow) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(crossbow));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/generated"), this.existingFileHelper);
		this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath() + "_standby")).transforms().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
			.rotation(-90.0F, 0.0F, -60.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(-90.0F, 0.0F, 30.0F).translation(2.0F, 0.1F, -3.0F).scale(0.9F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-90.0F, 0.0F, -55.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-90.0F, 0.0F, 35.0F)
			.translation(1.13F, 3.2F, 1.13F).scale(0.68F).end().end().override().predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_0")).end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), 0.58F).model(this.uncheckedModel(location.getPath() + "_pulling_1")).end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pulling"), 1.0F).predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "pull"), 1.0F).model(this.uncheckedModel(location.getPath() + "_pulling_2")).end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "charged"), 1.0F).model(this.uncheckedModel(location.getPath() + "_arrow")).end().override().predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "charged"), 1.0F)
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "firework"), 1.0F).model(this.uncheckedModel(location.getPath() + "_firework")).end();
		for (int i = 0; i < 3; i++) {
			this.getBuilder(location.getPath() + "_pulling_" + i).parent(this.uncheckedModel(location.getPath())).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath() + "_pulling_" + i));
		}
		this.getBuilder(location.getPath() + "_arrow").parent(this.uncheckedModel(location.getPath())).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath() + "_arrow"));
		this.getBuilder(location.getPath() + "_firework").parent(this.uncheckedModel(location.getPath())).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath() + "_firework"));
	}
	
	private void shieldItem(@NotNull ShieldItem shield) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(shield));
		ModelFile model = new UncheckedModelFile(ResourceLocation.withDefaultNamespace("builtin/entity"));
		this.getBuilder(location.getPath()).parent(model).guiLight(GuiLight.FRONT).texture("particle", ResourceLocation.withDefaultNamespace("block/dark_oak_planks")).transforms().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
			.rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, -4.0F).scale(1.0F).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0F, 90.0F, 0.0F).translation(10.0F, 6.0F, 12.0F).scale(1.0F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, 180.0F, 5.0F).translation(-10.0F, 2.0F, -10.0F).scale(1.25F).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 180.0F, 5.0F)
			.translation(10.0F, 0.0F, -10.0F).scale(1.25F).end().transform(ItemDisplayContext.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end().transform(ItemDisplayContext.FIXED)
			.rotation(0.0F, 180.0F, 0.0F).translation(-4.5F, 4.5F, -5.0F).scale(0.55F).end().transform(ItemDisplayContext.GROUND).rotation(0.0F, 0.0F, 0.0F).translation(2.0F, 4.0F, 2.0F).scale(0.25F).end().end().override()
			.predicate(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "blocking"), 1.0F).model(this.uncheckedModel(location.getPath() + "_blocking"));
		this.getBuilder(location.getPath() + "_blocking").parent(model).guiLight(GuiLight.FRONT).texture("particle", ResourceLocation.withDefaultNamespace("block/dark_oak_planks")).transforms().transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
			.rotation(45.0F, 135.0F, 0.0F).translation(3.51F, 11.0F, -2.0F).scale(1.0F).end().transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(45.0F, 135.0F, 0.0F).translation(13.51F, 3.0F, 5.0F).scale(1.0F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, 180.0F, -5.0F).translation(-15.0F, 5.0F, -11.0F).scale(1.25F).end().transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 180.0F, -5.0F)
			.translation(5.0F, 5.0F, -11.0F).scale(1.25F).end().transform(ItemDisplayContext.GUI).rotation(15.0F, -25.0F, -5.0F).translation(2.0F, 3.0F, 0.0F).scale(0.65F).end().end();
	}
	
	private void armorItem(@NotNull ArmorItem item) {
		ResourceLocation location = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
		ModelFile model = new ExistingModelFile(ResourceLocation.withDefaultNamespace("item/generated"), this.existingFileHelper);
		ItemModelBuilder builder = this.getBuilder(location.getPath()).parent(model).texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath()));
		for (int i = 0; i < TRIMS.length; i++) {
			builder.override().predicate(this.mcLoc("trim_type"), (i + 1.0F) / 10.0F).model(this.uncheckedModel(location.getPath() + "_" + TRIMS[i] + "_trim")).end();
			this.getBuilder(location.getPath() + "_" + TRIMS[i] + "_trim").parent(model)
				.texture("layer0", ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + location.getPath()))
				.texture("layer1", ResourceLocation.withDefaultNamespace("trims/items/" + this.getArmorType(item) + "_trim_" + TRIMS[i]));
		}
	}
	
	private @NotNull String getArmorType(@NotNull ArmorItem item) {
		Equippable equippable = item.components().get(DataComponents.EQUIPPABLE);
		if (equippable == null) {
			throw new NullPointerException("Equippable is null");
		}
		return this.getArmorType(equippable.slot());
	}
	
	private @NotNull String getArmorType(@NotNull EquipmentSlot slot) {
		return switch (slot) {
			case HEAD -> "helmet";
			case CHEST -> "chestplate";
			case LEGS -> "leggings";
			case FEET -> "boots";
			default -> throw new UnsupportedOperationException(slot + " is not supported");
		};
	}
	//endregion
	
	private @NotNull ModelFile uncheckedModel(@NotNull String path) {
		return new UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, "item/" + path));
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Item Models";
	}
}
