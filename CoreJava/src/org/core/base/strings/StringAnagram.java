package org.core.base.strings;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagram {

	public static void main(String[] args) {
		System.out.println("Enter first string");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();

		System.out.println("Enter second string");
		String anagram = scanner.nextLine();
		scanner.close();

		boolean isAnagram = areStringsAnagram(word, anagram);
		System.out.println("Both words \"" + word + "\" and \"" + anagram + "\" are anagram? = " + isAnagram);

		boolean isItAnagram = areStringsAnagramUsingArray(word, anagram);
		System.out.println("Both words \"" + word + "\" and \"" + anagram + "\" are anagram? = " + isItAnagram);
	}

	private static boolean areStringsAnagramUsingArray(String word, String anagram) {
		char[] wordArray = word.toCharArray();
		char[] anagramArray = anagram.toCharArray();

		Arrays.sort(wordArray);
		Arrays.sort(anagramArray);

		return Arrays.equals(wordArray, anagramArray);
	}

	private static boolean areStringsAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		for (int i = 0; i < word.length(); i++) {
			int index = anagram.indexOf(word.charAt(i));
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1);
			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}
}
