package org.core.base.regex;

import java.util.regex.Pattern;

public class RegexTest {

	public static void main(String[] args) {

		Pattern hasAnyDigit = Pattern.compile(".*\\d.*");
		Pattern hasNoDigit = Pattern.compile(".*\\D.*");

		String[] strings = { "123abc", "123", "-f13e", "-123", "ascfv" };

		for (String string : strings) {
			System.out.println(string + " - has one or many non digit - " + hasNoDigit.matcher(string).matches());
			System.out.println(string + " - has one or many digit - " + hasAnyDigit.matcher(string).matches());
		}
	}
}
