package org.core.base.practice;

public class SingletonTest {

	public static void main(String[] args) {
		Singleton.getInstace().show();
		SingletonEnum.INSTANCE.show();
		SingletonEnum.INSTANCE1.show();
	}

}

enum SingletonEnum {
	INSTANCE, INSTANCE1;
	public void show() {
		System.out.println("Inside enum SingletonEnum");
	}
}

class Singleton {
	private final static Singleton INSTANCE = new Singleton();

	private Singleton() {

	}

	static Singleton getInstace() {
		return INSTANCE;
	}

	public void show() {
		System.out.println("Inside enum Singleton");
	}
}
