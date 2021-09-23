package org.core.base.practice;

import java.util.HashSet;
import java.util.Set;

public class StringTest {

	public static void main(String[] args) {
		String str = "abc";
		String newStr=str.concat("xyz");
		System.out.println(str);
		System.out.println(newStr);
		str = "xyz";
		System.out.println(str);

		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(3);
		System.out.println(set);
	}

}
