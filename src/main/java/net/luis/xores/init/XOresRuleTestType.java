package net.luis.xores.init;

import net.luis.xores.common.levelgen.BlockListMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTestType;

/**
 * registration class for all mod {@link RuleTestType}s
 * 
 * @author Luis-st
 */

public class XOresRuleTestType {
	
	/**
	 * {@link RuleTestType} for {@link BlockListMatchTest}
	 */
	public static final RuleTestType<BlockListMatchTest> BLOCK_LIST_TEST = RuleTestType.register("block_list_match", BlockListMatchTest.CODEC);
	
}
