package org.core.base.practice.maths;

public class Fibonacci {
	public static int a = 0, b = 1, c;
	public static int x = 0, y = 1, z;

	public static void main(String[] args) {
		int fib = 14;
		if (fib == 0) {
			System.out.print(a);
		}
		if (fib == 1) {
			System.out.print(a + " " + b);
		}
		fib(fib);
		System.out.println();
		System.out.print(x + " " + y + " ");
		fibRecursive(fib);
	}

	private static void fibRecursive(int fib) {
		if (fib > 1) {
			z = x + y;
			x = y;
			y = z;
			System.out.print(z + " ");
			fibRecursive(fib - 1);
		}
	}

	private static void fib(int fib) {
		System.out.print(a + " " + b + " ");
		for (int i = 1; i < fib; i++) {
			c = a + b;
			a = b;
			b = c;
			System.out.print(c + " ");
		}
	}
}
