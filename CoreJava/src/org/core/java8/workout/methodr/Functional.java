package org.core.java8.workout.methodr;

public interface Functional {
	void m1(int a);
	
	default void def() {
		System.out.println("Inside fun interface default method");
	}
	
	public static void statik() {
		System.out.println("Inside fun interface static method");
	}
}
