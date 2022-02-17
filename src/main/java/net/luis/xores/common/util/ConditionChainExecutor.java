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
	
	/**
	 * the main if condition as a {@link Pair} with a {@link Predicate} as the condition<br>
	 * and the {@link Consumer} as the {@code true} action
	 */
	protected final Pair<Predicate<T>, Consumer<T>> ifCondition;
	
	/**
	 * a {@link List} of all else conditions as a {@link Pair} with a<br> 
	 * {@link Predicate} as the condition and the {@link Consumer} as the {@code true} action
	 */
	protected final List<Pair<Predicate<T>, Consumer<T>>> elseIFConditions;
	
	/**
	 * a {@link List} of all else actions as a {@link Consumer}
	 */
	protected final List<Consumer<T>> elseActions;
	
	/**
	 * the ignore true value,<br>
	 * if this is {@code true} a {@code true} in the condition,
	 * would be ignored. This means all other conditions<br>
	 * are also called
	 */
	protected boolean ignoreTrue = false;
	
	/**
	 * the call else always value,<br>
	 * if this is {@code true} the else actions are always called.
	 */
	protected boolean callElseAlways = false;
	
	/**
	 * constructor for the {@link ConditionChainExecutor},<br>
	 * private since you should use the factory methods
	 * 
	 * @see {@link ConditionChainExecutor#of(Pair)}
	 * @see {@link ConditionChainExecutor#of(Predicate, Consumer)}
	 */
	private ConditionChainExecutor(Pair<Predicate<T>, Consumer<T>> ifCondition, List<Pair<Predicate<T>, Consumer<T>>> elseIFConditions, List<Consumer<T>> elseActions) {
		this.ifCondition = ifCondition;
		this.elseIFConditions = elseIFConditions;
		this.elseActions = elseActions;
	}
	
	/**
	 * @return a {@link ConditionChainExecutor} for the given {@link Pair}
	 */
	public static <T> ConditionChainExecutor<T> of(Pair<Predicate<T>, Consumer<T>> ifCondition) {
		return new ConditionChainExecutor<>(ifCondition, Lists.newArrayList(), Lists.newArrayList());
	}
	
	/**
	 * @return a {@link ConditionChainExecutor} for the given {@link Predicate} and the {@link Consumer}
	 */
	public static <T> ConditionChainExecutor<T> of(Predicate<T> condition, Consumer<T> action) {
		return of(Pair.of(condition, action));
	}
	
	/**
	 * append a else if condition
	 * @param elseIFCondition the condition as a {@link Pair}
	 * @return the {@link ConditionChainExecutor} itself
	 */
	public ConditionChainExecutor<T> appendElseIf(Pair<Predicate<T>, Consumer<T>> elseIFCondition) {
		this.elseIFConditions.add(elseIFCondition);
		return this;
	}
	
	/**
	 * append a else if condition
	 * @param condition as a {@link Predicate}
	 * @param action as a {@link Consumer}
	 * @return the {@link ConditionChainExecutor} itself
	 */
	public ConditionChainExecutor<T> appendElseIf(Predicate<T> condition, Consumer<T> action) {
		return this.appendElseIf(Pair.of(condition, action));
	}
	
	/**
	 * append a else action
	 * @param elseAction as a {@link Consumer}
	 * @return the {@link ConditionChainExecutor} itself
	 */
	public ConditionChainExecutor<T> appendElse(Consumer<T> elseAction) {
		this.elseActions.add(elseAction);
		return this;
	}
	
	/**
	 * set the {@link ConditionChainExecutor#ignoreTrue} to a {@code true}
	 * @return the {@link ConditionChainExecutor} itself
	 */
	public ConditionChainExecutor<T> ignoreTrue() {
		this.ignoreTrue = true;
		return this;
	}
	
	/**
	 * set the {@link ConditionChainExecutor#callElseAlways} to a {@code true}
	 * @return the {@link ConditionChainExecutor} itself
	 */
	public ConditionChainExecutor<T> callElseAlways() {
		this.callElseAlways = true;
		return this;
	}
	
	/**
	 * executes the all conditions and actions in the following order:
	 * <ol>
	 * 	<li>the main if condition, contins if the {@link Predicate#test(Object)} returns {@code false} or<br>
	 *  {@link ConditionChainExecutor#ignoreTrue} is {@code true} </li>
	 *  <li>the first else if condition, contins if the {@link Predicate#test(Object)} returns {@code false} or<br>
	 *  {@link ConditionChainExecutor#ignoreTrue} is {@code true}  </li>
	 *  <li>calls now all else if conditions in the same pattern</li>
	 *  <li>all else actions if all previous conditions were {@code false} or<br>
	 *  {@link ConditionChainExecutor#callElseAlways} is {@code true} </li>
	 * </ol>
	 * @param value which is used for execution
	 */
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
