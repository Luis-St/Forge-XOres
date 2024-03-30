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
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.*;

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
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_JADE_ORE = register("deepslate_jade_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> JADE_BLOCK = register("jade_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK));
	});
	public static final RegistryObject<Block> SAPHIRE_ORE = register("saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_SAPHIRE_ORE = register("deepslate_saphire_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> SAPHIRE_BLOCK = register("saphire_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
	});
	public static final RegistryObject<Block> LIMONITE_ORE = register("limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
	});
	public static final RegistryObject<Block> DEEPSLATE_LIMONITE_ORE = register("deepslate_limonite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE));
	});
	public static final RegistryObject<Block> LIMONITE_BLOCK = register("limonite_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK));
	});
	public static final RegistryObject<Block> ENDERITE_ORE = register("enderite_ore", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS));
	});
	public static final RegistryObject<Block> ENDERITE_BLOCK = register("enderite_block", () -> {
		return new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK));
	});
	
	private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier) {
		RegistryObject<T> blockObject = BLOCKS.register(name, blockSupplier);
		ITEMS.register(name, () -> new BlockItem(blockObject.get(), new Item.Properties()));
		return blockObject;
	}
}
