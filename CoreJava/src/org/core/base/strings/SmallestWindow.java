package org.core.base.strings;

public class SmallestWindow {

	public static void main(String[] args) {
		String main = "timetopractice";
		String sub = "toc";

		String output = findSmallestWindow(main, sub);
		System.out.println(output);

	}

	/*
	 * It does the basic trim of main string by keeping main string starting from
	 * first char of sub string till last char of sub string.
	 * 
	 * Ex: main string = "abcdefg". sub string = "cef" It trims the main string as
	 * cdef And then passes main = "cdef", sub = "cef" to next method
	 */
	private static String findSmallestWindow(String main, String sub) {
		int startIndex = main.indexOf(sub.charAt(0));
		int endIndex = main.lastIndexOf(sub.charAt(sub.length() - 1));
		if (endIndex < startIndex || startIndex == -1 || endIndex == -1)
			return "-1";
		String mainSub = main.substring(startIndex, endIndex + 1);
		return smallestWindow(mainSub, sub);
	}

	/*
	 * It recursively checks for smallest substring from first string which contains
	 * second string characters.
	 * 
	 * It basically makes substring of first string by considering first character
	 * of second string as begin index and last character of second index as end
	 * index
	 */
	private static String smallestWindow(String first, String second) {
		if (first.length() < second.length())
			return "-1";

		/*
		 * It basically checks for any repetitive characters present in first string
		 * for the first & last character of second string
		 */
		int mainNextIndexFromSubFirstChar = first.substring(1).indexOf(second.charAt(0));
		int mainPrevindexFromSubLastChar = first.substring(0, first.length() - 1)
				.lastIndexOf(second.charAt(second.length() - 1));
		if ((mainNextIndexFromSubFirstChar == -1 && mainPrevindexFromSubLastChar == -1)
				|| mainPrevindexFromSubLastChar < mainNextIndexFromSubFirstChar) {
			return mainContainsSub(first, second);
		}

		int startIndex = 0;
		int endIndex = first.length();
		if (mainNextIndexFromSubFirstChar != -1)
			startIndex = mainNextIndexFromSubFirstChar + 1; // Add +1 since index calculated after doing substring from
															// 1 at line 25
		if (mainPrevindexFromSubLastChar != -1)
			endIndex = mainPrevindexFromSubLastChar;
		if (endIndex < startIndex)
			return "-1";

		String value = smallestWindow(first.substring(startIndex, endIndex + 1), second);

		if (!value.equals("-1"))
			return value;

		return mainContainsSub(first, second);
	}

	private static String mainContainsSub(String main, String sub) {
		for (char c : sub.toCharArray()) {
			if (main.indexOf(c) != -1) {
				main.substring(main.indexOf(c));
			} else {
				return "-1";
			}
		}
		return main;
	}

}
