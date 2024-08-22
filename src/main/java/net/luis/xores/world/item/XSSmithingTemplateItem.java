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

package net.luis.xores.world.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

public class XSSmithingTemplateItem extends SmithingTemplateItem {
	
	private static final String ENDERITE_TEMPLATE = "item.xores.smithing_template.enderite_upgrade.";
	private static final String NIGHT_TEMPLATE = "item.xores.smithing_template.night_upgrade.";
	private static final ResourceLocation EMPTY_SLOT = ResourceLocation.withDefaultNamespace("item/empty_slot_ingot");
	private static final ResourceLocation EMPTY_HELMET = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet");
	private static final ResourceLocation EMPTY_CHESTPLATE = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate");
	private static final ResourceLocation EMPTY_LEGGINGS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings");
	private static final ResourceLocation EMPTY_BOOTS = ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots");
	private static final ResourceLocation EMPTY_HOE = ResourceLocation.withDefaultNamespace("item/empty_slot_hoe");
	private static final ResourceLocation EMPTY_AXE = ResourceLocation.withDefaultNamespace("item/empty_slot_axe");
	private static final ResourceLocation EMPTY_SWORD = ResourceLocation.withDefaultNamespace("item/empty_slot_sword");
	private static final ResourceLocation EMPTY_SHOVEL = ResourceLocation.withDefaultNamespace("item/empty_slot_shovel");
	private static final ResourceLocation EMPTY_PICKAXE = ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe");
	
	public XSSmithingTemplateItem(@NotNull TemplateType templateType) {
		super(templateType.appliesTo, templateType.ingredients, templateType.upgrade, templateType.baseSlot, templateType.additionsSlot, templateType.baseSlotIcons, templateType.additionalSlotIcons);
	}
	
	@Override
	public @NotNull String getDescriptionId() {
		return this.getOrCreateDescriptionId();
	}
	
	public enum TemplateType {
		
		ENDERITE(Component.translatable(ENDERITE_TEMPLATE + "applies_to").withStyle(ChatFormatting.BLUE), Component.translatable(ENDERITE_TEMPLATE + "ingredients").withStyle(ChatFormatting.BLUE),
			Component.translatable("upgrade.xores.enderite_upgrade").withStyle(ChatFormatting.GRAY), Component.translatable(ENDERITE_TEMPLATE + "base_slot_description"),
			Component.translatable(ENDERITE_TEMPLATE + "additions_slot_description"), TemplateType.createIcons(), List.of(EMPTY_SLOT)),
		NIGHT(Component.translatable(NIGHT_TEMPLATE + "applies_to").withStyle(ChatFormatting.BLUE), Component.translatable(NIGHT_TEMPLATE + "ingredients").withStyle(ChatFormatting.BLUE),
			Component.translatable("upgrade.xores.night_upgrade").withStyle(ChatFormatting.GRAY), Component.translatable(NIGHT_TEMPLATE + "base_slot_description"), Component.translatable(NIGHT_TEMPLATE + "additions_slot_description"),
			TemplateType.createIcons(), List.of(EMPTY_SLOT));
		
		private final Component appliesTo;
		private final Component ingredients;
		private final Component upgrade;
		private final Component baseSlot;
		private final Component additionsSlot;
		private final List<ResourceLocation> baseSlotIcons;
		private final List<ResourceLocation> additionalSlotIcons;
		
		TemplateType(@NotNull Component appliesTo, @NotNull Component ingredients, @NotNull Component upgrade, @NotNull Component baseSlot, @NotNull Component additionsSlot, @NotNull List<ResourceLocation> baseSlotIcons, @NotNull List<ResourceLocation> additionalSlotIcons) {
			this.appliesTo = appliesTo;
			this.ingredients = ingredients;
			this.upgrade = upgrade;
			this.baseSlot = baseSlot;
			this.additionsSlot = additionsSlot;
			this.baseSlotIcons = baseSlotIcons;
			this.additionalSlotIcons = additionalSlotIcons;
		}
		
		private static @Unmodifiable @NotNull List<ResourceLocation> createIcons() {
			return List.of(EMPTY_HELMET, EMPTY_SWORD, EMPTY_CHESTPLATE, EMPTY_PICKAXE, EMPTY_LEGGINGS, EMPTY_AXE, EMPTY_BOOTS, EMPTY_HOE, EMPTY_SHOVEL);
		}
	}
}
