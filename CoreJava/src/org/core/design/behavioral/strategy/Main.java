package org.core.design.behavioral.strategy;

public class Main {

	public static void main(String[] args) {
		Context add = new Context(new Add());
		Context minus = new Context(new Minus());
		System.out.println(add.execute(3, 2));
		System.out.println(minus.execute(3, 2));
	}

}
