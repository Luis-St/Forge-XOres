package net.luis.xores.common.levelgen;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.luis.xores.init.XOresRuleTestType;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;

/**
 * extension of {@link RuleTest}, used to the {@link XOresOreFeatures#END_STONE_REPLACEABLES}
 * 
 * @author Luis-st
 * 
 * @see {@link RuleTest}
 * @see {@link XOresOreFeatures}
 */

public class BlockListMatchTest extends RuleTest {
	
	/**
	 * {@link Codec} for the {@link BlockListMatchTest}
	 */
	@SuppressWarnings("deprecation")
	public static final Codec<BlockListMatchTest> CODEC = RecordCodecBuilder.create((instance) -> {
		return instance.group(Codec.list(Registry.BLOCK.byNameCodec()).fieldOf("blocks").forGetter((matchTest) -> {
			return matchTest.blocks;
		})).apply(instance, BlockListMatchTest::new);
	});
	
	/**
	 * the {@link Block}s in a {@link List}
	 */
	private final List<Block> blocks;
	
	/**
	 * constructor for the {@link BlockListMatchTest}
	 */
	public BlockListMatchTest(Block... blocks) {
		this(Lists.newArrayList(blocks));
	}
	
	
	/**
	 * constructor for the {@link BlockListMatchTest}
	 */
	public BlockListMatchTest(List<Block> blocks) {
		this.blocks = blocks;
	}
	
	
	/**
	 * tests if the given {@link BlockState} is in {@link BlockListMatchTest#blocks}
	 * @param state The {@link BlockState} to test
	 * @param rng The {@link Random}
	 * @return {@code true} if the given {@link BlockState} is in {@link BlockListMatchTest#blocks} else {@code false}
	 */
	@Override
	public boolean test(BlockState state, Random rng) {
		return this.blocks.contains(state.getBlock());
	}

	
	/**
	 * @return the {@link RuleTestType} for {@link BlockListMatchTest}
	 */
	@Override
	protected RuleTestType<BlockListMatchTest> getType() {
		return XOresRuleTestType.BLOCK_LIST_TEST;
	}

}
