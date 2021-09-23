package org.core.base.array;

import java.util.Arrays;

public class FindElementInArray {

	public static void main(String[] args) {
		String[] array = { "abc", "xyz", "pqr", "stu" };
		String find = "xyz";
		boolean isPresent = Arrays.asList(array).contains(find);
		System.out.println("Is " + find + " present in " + Arrays.toString(array) + " ? = " + isPresent);
	}
}
