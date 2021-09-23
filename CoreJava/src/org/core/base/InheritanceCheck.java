package org.core.base;

public class InheritanceCheck {

	public static void main(String[] args) {
		X x = new Y();
		System.out.println(x.n);
		x.test();
	}
}

class X {
	public int n = 10;

	public void test() {
		System.out.println("X");
	}
}

class Y extends X {
	public int n = 20;

	public void test() {
		System.out.println("Y"+n+" "+super.n);
	}
}