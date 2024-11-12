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

package net.luis.xores.world.level.block;

import net.luis.xores.XOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 *
 * @author Luis-St
 *
 */

@SuppressWarnings("CodeBlock2Expr")
public class XOBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XOres.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XOres.MOD_ID);
	
	public static final RegistryObject<Block> JADE_ORE = register("jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().setId(Keys.JADE_ORE));
	});
	public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = register("deepslate_jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().setId(Keys.DEEPSLATE_JADE_ORE));
	});
	public static final RegistryObject<Block> JADE_BLOCK = register("jade_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().setId(Keys.JADE_BLOCK));
	});
	public static final RegistryObject<Block> SAPHIRE_ORE = register("saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().setId(Keys.SAPHIRE_ORE));
	});
	public static final RegistryObject<Block> DEEPSLATE_SAPHIRE_ORE = register("deepslate_saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().setId(Keys.DEEPSLATE_SAPHIRE_ORE));
	});
	public static final RegistryObject<Block> SAPHIRE_BLOCK = register("saphire_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops().setId(Keys.SAPHIRE_BLOCK));
	});
	public static final RegistryObject<Block> LIMONITE_ORE = register("limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).requiresCorrectToolForDrops().setId(Keys.LIMONITE_ORE));
	});
	public static final RegistryObject<Block> DEEPSLATE_LIMONITE_ORE = register("deepslate_limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).requiresCorrectToolForDrops().setId(Keys.DEEPSLATE_LIMONITE_ORE));
	});
	public static final RegistryObject<Block> LIMONITE_BLOCK = register("limonite_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops().setId(Keys.LIMONITE_BLOCK));
	});
	public static final RegistryObject<Block> ENDERITE_ORE = register("enderite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).requiresCorrectToolForDrops().setId(Keys.ENDERITE_ORE));
	});
	public static final RegistryObject<Block> ENDERITE_BLOCK = register("enderite_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops().setId(Keys.ENDERITE_BLOCK));
	});
	
	private static <T extends Block> @NotNull RegistryObject<T> register(@NotNull String name, @NotNull Supplier<T> blockSupplier) {
		RegistryObject<T> blockObject = BLOCKS.register(name, blockSupplier);
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, name));
		ITEMS.register(name, () -> new BlockItem(blockObject.get(), new Item.Properties().setId(key)));
		return blockObject;
	}
	
	public static class Keys {
		
		public static final ResourceKey<Block> JADE_ORE = createKey("jade_ore");
		public static final ResourceKey<Block> DEEPSLATE_JADE_ORE = createKey("deepslate_jade_ore");
		public static final ResourceKey<Block> JADE_BLOCK = createKey("jade_block");
		public static final ResourceKey<Block> SAPHIRE_ORE = createKey("saphire_ore");
		public static final ResourceKey<Block> DEEPSLATE_SAPHIRE_ORE = createKey("deepslate_saphire_ore");
		public static final ResourceKey<Block> SAPHIRE_BLOCK = createKey("saphire_block");
		public static final ResourceKey<Block> LIMONITE_ORE = createKey("limonite_ore");
		public static final ResourceKey<Block> DEEPSLATE_LIMONITE_ORE = createKey("deepslate_limonite_ore");
		public static final ResourceKey<Block> LIMONITE_BLOCK = createKey("limonite_block");
		public static final ResourceKey<Block> ENDERITE_ORE = createKey("enderite_ore");
		public static final ResourceKey<Block> ENDERITE_BLOCK = createKey("enderite_block");
		
		public static void register() {}
		
		private static @NotNull ResourceKey<Block> createKey(@NotNull String name) {
			return ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(XOres.MOD_ID, name));
		}
	}
}
