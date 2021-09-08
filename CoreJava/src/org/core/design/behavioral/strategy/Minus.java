package org.core.design.behavioral.strategy;

public class Minus implements Strategy {

	@Override
	public int doOperation(int a, int b) {
		return a-b;
	}

}
