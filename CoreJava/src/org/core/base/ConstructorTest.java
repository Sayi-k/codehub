package org.core.base;

public class ConstructorTest {

	public static void main(String[] args) {
		// Child child = new Child();
		System.out.println("Inside main");
		Child child1 = new Child("HI");
	}

}

class Base {
	String name;

	public Base() {
		System.out.println("Inside no-arg Base constructor");
	}

	public Base(String name) {
		// this();
		this.name = name;
		System.out.println("Inside arg Base constructor");
	}
}

class Child extends Base {
	String name;

	public Child() {
		System.out.println("Inside no-arg Child constructor");
	}

	public Child(String name) {
		// super("");
		System.out.println("Inside arg Child constructor");
	}
}
