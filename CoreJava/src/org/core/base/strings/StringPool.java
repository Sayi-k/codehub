package org.core.base.strings;

public class StringPool {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "abc";
		String s3 = new String("ABC");
		if (s1 == s2) {
			System.out.println(s1 + " - " + s2 + " are equal");
			System.out.println(System.identityHashCode(s1));
			System.out.println(System.identityHashCode(s2));
		} else {
			System.out.println(s1 + " - " + s2 + " are not equal");
			System.out.println(System.identityHashCode(s1));
			System.out.println(System.identityHashCode(s2));
		}
		if (s2 == s3) {
			System.out.println("s2 and s3 are equal");
		} else {
			System.out.println("s2 and s3 are not equal");
			System.out.println(System.identityHashCode(s3));
		}
	}
}
