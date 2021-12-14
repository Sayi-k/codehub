package org.core.java8.workout.methodr;

public class MethodReference {
	
	public void testMethod(int a) {
		System.out.println("Inside Method Reference: " +a);
	}
	
	public static void testStaticMethod(int a) {
		System.out.println("Inside Static Method Reference: " +a);
	}

	public static void main(String[] args) {
		MethodReference mr = new MethodReference();
		Functional fun = mr::testMethod;
		
		fun.m1(1);
		fun.def();
		Functional.statik();
		
		Functional func = MethodReference::testStaticMethod;
		func.m1(1);
	}

}
