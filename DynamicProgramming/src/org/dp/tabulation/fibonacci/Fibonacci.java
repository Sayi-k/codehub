package org.dp.tabulation.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(6));//8
		System.out.println(fib(7));//13
		System.out.println(fib(8));//21
		System.out.println(fib(50));//12586269025
	}

	private static long fib(int n) {
		long[] tab = new long[n+1];
		tab[1] = 1;
		for (int i=0; i <= n; i++) {
			if(i+2 <= n) {
				tab[i+2] = tab[i] + tab[i+1];
			}
		}
		return tab[n];
	}

}
