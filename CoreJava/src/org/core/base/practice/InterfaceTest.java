package org.core.base.practice;

public class InterfaceTest implements A, B {

	public static void main(String[] args) {
		InterfaceTest test = new InterfaceTest();
		test.show();
	}

	@Override
	public void show() {
		System.out.println("Showing....");
	}

	@Override
	public void go() {
		// TODO Auto-generated method stub
		A.super.go();
	}
}

interface A {
	public void show();
	
	default void go() {
		System.out.println("A");
	}
}

interface B {
	public void show();
	
	default void go() {
		System.out.println("B");
	}
}