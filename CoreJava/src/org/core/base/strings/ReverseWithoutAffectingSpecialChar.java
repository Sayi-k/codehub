package org.core.base.strings;

import java.util.Arrays;

public class ReverseWithoutAffectingSpecialChar {

	public static void main(String[] args) {
		String str = "abc@xyz*123!";
		System.out.println("Normal: " + str);
		String reverse = reverseOrder(str.toCharArray());
		System.out.println("Reverse: " + reverse);
	}

	private static String reverseOrder(char[] charArray) {
		char[] temp = charArray;
		int l = 0;
		int r = charArray.length - 1;
		while (l < r) {
			if (!Character.isLetterOrDigit(temp[l])) {
				l++;
			} else if (!Character.isLetterOrDigit(temp[r])) {
				r--;
			} else {
				char chTemp = temp[l];
				temp[l] = temp[r];
				temp[r] = chTemp;
				l++;
				r--;
			}
		}
		return Arrays.toString(temp);
	}
}
