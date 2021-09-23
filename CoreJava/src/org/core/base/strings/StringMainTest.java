package org.core.base.strings;

public class StringMainTest {

	public static void main(String[] args) {
		String s1 = new String("abc");
		String s2 = s1;
		System.out.println(s1 + " - " + s2);
		System.out.println(s1 == s2);
		s1 = new String("aaa");
		System.out.println(s1 + " - " + s2);

		String s3 = "xyz";
		String s4 = s3;
		System.out.println(s3 + " - " + s4);
		System.out.println(s3 == s4);
		s3 = "xxx";
		System.out.println(s3 + " - " + s4);
		
		String s5 = "sss";
		String s6 = new String("sss");
		System.out.println(s5 + " - " + s6);
		System.out.println(s5 == s6);
	}

}
