package org.core.base.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitTest {

	public static void main(String[] args) {
		String regEx = "(-|\\+)?\\d*(\\.\\d*)?";
		Pattern pattern = Pattern.compile(regEx);
		Scanner in;
		while (true) {
			System.out.println("Enter a digit");
			in = new Scanner(System.in);
			String word = in.nextLine();
			Matcher matcher = pattern.matcher(word);
			System.out.println("Is '" + word + "' a digit? " + matcher.matches());
			if (word.equals("0")) {
				in.close();
			}
		}
	}
}
