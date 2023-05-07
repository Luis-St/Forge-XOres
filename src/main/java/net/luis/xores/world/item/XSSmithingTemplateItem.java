package net.luis.xores.world.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 *
 * @author Luis-St
 *
 */

public class XSSmithingTemplateItem extends SmithingTemplateItem {
	
	private static final String ENDERITE_TEMPLATE = "item.xores.smithing_template.enderite_upgrade.";
	private static final String NIGHT_TEMPLATE = "item.xores.smithing_template.night_upgrade.";
	private static final ResourceLocation EMPTY_SLOT = new ResourceLocation("item/empty_slot_ingot");
	private static final ResourceLocation EMPTY_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
	private static final ResourceLocation EMPTY_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
	private static final ResourceLocation EMPTY_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
	private static final ResourceLocation EMPTY_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
	private static final ResourceLocation EMPTY_HOE = new ResourceLocation("item/empty_slot_hoe");
	private static final ResourceLocation EMPTY_AXE = new ResourceLocation("item/empty_slot_axe");
	private static final ResourceLocation EMPTY_SWORD = new ResourceLocation("item/empty_slot_sword");
	private static final ResourceLocation EMPTY_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
	private static final ResourceLocation EMPTY_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
	
	public XSSmithingTemplateItem(TemplateType templateType) {
		super(templateType.appliesTo, templateType.ingredients, templateType.upgrade, templateType.baseSlot, templateType.additionsSlot, templateType.baseSlotIcons, templateType.additionalSlotIcons);
	}
	
	@Override
	public @NotNull String getDescriptionId() {
		return this.getOrCreateDescriptionId();
	}
	
	public static enum TemplateType {
		
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
		
		private TemplateType(Component appliesTo, Component ingredients, Component upgrade, Component baseSlot, Component additionsSlot, List<ResourceLocation> baseSlotIcons, List<ResourceLocation> additionalSlotIcons) {
			this.appliesTo = appliesTo;
			this.ingredients = ingredients;
			this.upgrade = upgrade;
			this.baseSlot = baseSlot;
			this.additionsSlot = additionsSlot;
			this.baseSlotIcons = baseSlotIcons;
			this.additionalSlotIcons = additionalSlotIcons;
		}
		
		private static @NotNull List<ResourceLocation> createIcons() {
			return List.of(EMPTY_HELMET, EMPTY_SWORD, EMPTY_CHESTPLATE, EMPTY_PICKAXE, EMPTY_LEGGINGS, EMPTY_AXE, EMPTY_BOOTS, EMPTY_HOE, EMPTY_SHOVEL);
		}
	}
}
