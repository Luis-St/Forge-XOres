package net.luis.xores.common.util;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

/**
 * 
 * @author Luis-st
 *
 */

public class ConditionChainExecutor<T> {
	
	protected final Pair<Predicate<T>, Consumer<T>> ifCondition;
	protected final List<Pair<Predicate<T>, Consumer<T>>> elseIFConditions;
	protected final List<Consumer<T>> elseActions;
	protected boolean ignoreTrue = false;
	protected boolean callElseAlways = false;
	
	protected ConditionChainExecutor(Pair<Predicate<T>, Consumer<T>> ifCondition, List<Pair<Predicate<T>, Consumer<T>>> elseIFConditions, List<Consumer<T>> elseActions) {
		this.ifCondition = ifCondition;
		this.elseIFConditions = elseIFConditions;
		this.elseActions = elseActions;
	}
	
	public static <T> ConditionChainExecutor<T> of(Pair<Predicate<T>, Consumer<T>> ifCondition) {
		return new ConditionChainExecutor<>(ifCondition, Lists.newArrayList(), Lists.newArrayList());
	}
	
	public static <T> ConditionChainExecutor<T> of(Predicate<T> condition, Consumer<T> action) {
		return of(Pair.of(condition, action));
	}
	
	public ConditionChainExecutor<T> appendElseIf(Pair<Predicate<T>, Consumer<T>> elseIFCondition) {
		this.elseIFConditions.add(elseIFCondition);
		return this;
	}
	
	public ConditionChainExecutor<T> appendElseIf(Predicate<T> condition, Consumer<T> action) {
		return this.appendElseIf(Pair.of(condition, action));
	}
	
	public ConditionChainExecutor<T> appendElse(Consumer<T> elseAction) {
		this.elseActions.add(elseAction);
		return this;
	}
	
	public ConditionChainExecutor<T> ignoreTrue() {
		this.ignoreTrue = true;
		return this;
	}
	
	public ConditionChainExecutor<T> callElseAlways() {
		this.callElseAlways = true;
		return this;
	}
	
	public void execute(T value) {
		boolean wasTrue = false;
		if (this.ifCondition.getFirst().test(value)) {
			this.ifCondition.getSecond().accept(value);
			wasTrue = true;
		}
		if (!wasTrue || this.ignoreTrue) {
			wasTrue = false;
			for (Pair<Predicate<T>, Consumer<T>> elseIFCondition : this.elseIFConditions) {
				if (elseIFCondition.getFirst().test(value)) {
					elseIFCondition.getSecond().accept(value);
					wasTrue = true;
					if (!this.ignoreTrue) {
						break;
					}
				}
			}
		}
		if (!wasTrue || this.callElseAlways) {
			for (Consumer<T> elseAction : this.elseActions) {
				elseAction.accept(value);
			}
		}
	}
	
}
