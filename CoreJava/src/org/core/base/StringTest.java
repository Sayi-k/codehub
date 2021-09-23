package org.core.base;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = "Java";
		s1 = "C++";
		System.out.println(s1.hashCode());

		System.out.println(s2.hashCode());

		int num = 99;
		String[] str = { "even", "odd" };
		System.out.println(num + " is " + str[num % 2]);
	}
}
