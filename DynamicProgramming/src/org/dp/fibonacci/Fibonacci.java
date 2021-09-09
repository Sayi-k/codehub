package org.dp.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(7));
		System.out.println(fib(10));
		System.out.println(fib(50));//This takes too much time
	}

	private static long fib(int n) {
		if(n <=2) return 1;
		return fib(n-1)+fib(n-2);
	}

}
