package org.core.base.strings;

import java.util.Scanner;

public class Permutation {
	static boolean flag = false;

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		permutation(input);
	}

	public static void permutation(String input) {
		permutation("", input);
	}

	private static void permutation(String perm, String input) {
		if (input.isEmpty()) {
			System.out.println(perm);
		}
		for (int i = 0; i < input.length(); i++) {
			// System.out.println("Inside loop = " + i + " Perm is = " + perm);
			if (!flag) {
				permutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i + 1, input.length()));

			}
			if (i != input.length() - 1) {
				if (input.charAt(i) == input.charAt(i + 1)) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
	}
}
