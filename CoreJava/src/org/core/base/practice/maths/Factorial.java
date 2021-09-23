package org.core.base.practice.maths;

public class Factorial {

	public static void main(String[] args) {
		int fact = 4;
		System.out.println("Factorial of number " + fact + " is: " + fact(fact));
		System.out.println("Factorial recursive of number " + fact + " is: " + factRec(fact));
	}

	private static int factRec(int fact) {
		if (fact == 1) {
			return fact;
		}
		return fact * factRec(fact - 1);
	}

	private static int fact(int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return fact;
	}
}
