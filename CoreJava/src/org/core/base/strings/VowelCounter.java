package org.core.base.strings;

import java.util.Scanner;

public class VowelCounter {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String word = scan.next();
		scan.close();

		char[] array = word.toCharArray();
		int count = 0;
		for (char c : array) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				count++;
				break;
			default:
			}
		}
		System.out.println("Vowel count = " + count);
	}
}
