package org.core.design.behavioral.strategy;

public class Context {
	Strategy strategy;
	public Context( Strategy obj) {
		this.strategy = obj;
	}
	
	public int execute(int a, int b) {
		return strategy.doOperation(a, b);
	}
}
