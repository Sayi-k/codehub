package org.dp.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {
	
	private static Map<Integer, Long> memo = new HashMap<>();
	private static long res;

	public static void main(String[] args) {
		System.out.println(fib(7));
		memo.clear();
		System.out.println(fib(10));
		memo.clear();
		System.out.println(fib(50));
		memo.clear();
	}

	private static long fib(int n) {
		if(memo.containsKey(n)) return memo.get(n);
		if(n == 0 || n == 1) return n;
		res = fib(n-1)+fib(n-2);
		memo.put(n, res);
		return res;
	}
}
