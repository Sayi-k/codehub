package org.core.recursion;

public class StringReverse {

	public static void main(String[] args) {
		String str = "Hi how are you";
		System.out.println(str);
		String revStr = rev(str);
		System.out.println(revStr);
	}

	private static String rev(String str) {
		if(null == str || str.isEmpty()) {
			return "";
		}
		return rev(str.substring(1))+str.charAt(0);
	}

}
