package org.core.ds.stack.prog;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {

	public static void main(String[] args) {
		String brackets = "{[]}()";
		if (isBalancedBrackets(brackets)) {
			System.out.println(brackets + " : Balanced");
		} else {
			System.out.println(brackets + " : Unbalanced");
		}
	}

	/**
	 * Checks if given brackets are balanced or not
	 * 
	 * @param brackets
	 * @return
	 */
	private static boolean isBalancedBrackets(String brackets) {
		// Using ArrayDeque is faster than using Stack class
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < brackets.length(); i++) {
			char ch = brackets.charAt(i);
			if (isLeftBracket(ch)) {
				stack.push(ch);
				continue;
			}
			char rev = getReverseBracket(ch);
			if (stack.isEmpty() || stack.pop() != rev) {
				return false;
			}
		}
		return stack.isEmpty(); // At the end stack should be empty if brackets are balanced
	}

	/**
	 * Returns the reverse of given bracket 
	 * 
	 * @param ch
	 * @return
	 */
	private static char getReverseBracket(char ch) {
		switch (ch) {
		case ')':
			return '(';
		case '}':
			return '{';
		case ']':
			return '[';
		default:
			return '/';
		}
	}

	/**
	 * Checks if it is a left bracket or not
	 * 
	 * @param ch
	 * @return
	 */
	private static boolean isLeftBracket(char ch) {
		return ch == '{' || ch == '[' || ch == '(';
	}

}
