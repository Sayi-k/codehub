package org.core.base.strings;

public class StringReverse {

	public static void main(String[] args) {
		String str = "something";
		System.out.println("Reverse of " + str + " is: " + new StringReverse().reverse(str));
	}

	public String reverse(String string) {
		String reverse = "";
		if (null == string || string.isEmpty()) {
			return reverse;
		}
		for (int i = string.length() - 1; i <= 0; i--) {
			reverse = reverse + string.charAt(i);
		}
		return reverse;
	}
}
