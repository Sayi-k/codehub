package org.core.base;

public class InheritanceTest {

	public static void main(String[] args) {
		A a = new B();
		A b = new C();
		System.out.println(a.name + "-" + a.get());
		System.out.println(b.name + "-" + b.get());
		B b11 = (B) a;
		System.out.println(b11.name);
		B b1 = new B();
		C c = (C) b1;
		System.out.println(c.name);
	}

}

class A {
	String name = "A";

	String get() {
		return name;
	}
}

class B extends A {
	String name = "B";

	String get() {
		return name;
	}
}

class C extends B {
	String name = "C";

	String get() {
		return name;
	}
}
