package org.core.base.practice.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("one");
		set.add("one");
		set.addAll(Arrays.asList("three", "four"));
		for (String value : set) {
			System.out.println(value);
		}
	}
}
