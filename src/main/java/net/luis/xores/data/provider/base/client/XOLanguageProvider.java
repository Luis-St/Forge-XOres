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
import net.luis.xores.world.item.XOItems;
import net.luis.xores.world.level.block.XOBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 *
 * @author Luis-St
 *
 */

public class XOLanguageProvider extends LanguageProvider {
	
	public XOLanguageProvider(@NotNull DataGenerator generator) {
		super(generator.getPackOutput(), XOres.MOD_ID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		for (Block block : XOBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.add(block, this.getName(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block))));
		}
		for (Item item : XOItems.ITEMS.getEntries().stream().map(RegistryObject::get).toList()) {
			this.add(item, this.getName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item))));
		}
		this.add("item_tab.xores", "XOres");
		String enderite = "item.xores.smithing_template.enderite_upgrade.";
		this.add(enderite + "applies_to", "Netherite Equipment");
		this.add(enderite + "ingredients", "Enderite Ingot");
		this.add(enderite + "base_slot_description", "Put a piece of Netherite armor, weapon or tool here");
		this.add(enderite + "additions_slot_description", "Put a Enderite Ingot here");
		String night = "item.xores.smithing_template.night_upgrade.";
		this.add(night + "applies_to", "Enderite Equipment");
		this.add(night + "ingredients", "Night Ingot");
		this.add(night + "base_slot_description", "Put a piece of Enderite armor, weapon or tool here");
		this.add(night + "additions_slot_description", "Put a Night Ingot here");
	}
	
	private @NotNull String getName(@NotNull ResourceLocation location) {
		String[] nameParts = location.getPath().split("_");
		StringBuilder name = new StringBuilder();
		for (String namePart : nameParts) {
			String startChar = namePart.substring(0, 1).toUpperCase();
			if (!namePart.contains("upgrade")) {
				name.append(startChar).append(namePart.substring(1)).append(" ");
			}
		}
		
		return name.toString().trim();
	}
	
	@Override
	public @NotNull String getName() {
		return "XOres Languages";
	}
}
