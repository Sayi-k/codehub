package org.core.base.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArray {

	public static void main(String[] args) {
		String[] array = { "z", "a", "b", "c", "d", "e", "b", "c", "c", "a", "c", "b" };
		System.out.println(Arrays.toString(array));

		System.out.println("Reverse Array");
		List arrayList = Arrays.asList(array);
		Collections.reverse(arrayList);
		System.out.println(arrayList);

		
		Collections.sort(Arrays.asList(array));
		System.out.println(Arrays.binarySearch(array, "c"));
		System.out.println(Arrays.toString(array));
	}
}
