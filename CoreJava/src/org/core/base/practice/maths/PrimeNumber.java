package org.core.base.practice.maths;

public class PrimeNumber {

	public static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= num - 1; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int num = 599999999;
		if (isPrime(num)) {
			System.out.println(num + " is Prime");
		} else {
			System.out.println(num + " is not Prime");
		}
	}

}
