package org.core.base.strings;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		scan.close();

		StringBuilder builder = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			builder.append(word.charAt(i));
		}
		String reverseWord = builder.toString();
		System.out.println(reverseWord);
		if (word.equals(reverseWord)) {
			System.out.println("Its is palindrome");
		} else {
			System.out.println("Its is not palindrome");
		}
	}
}
