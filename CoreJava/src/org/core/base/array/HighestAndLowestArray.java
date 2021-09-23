package org.core.base.array;

import java.util.Arrays;

public class HighestAndLowestArray {

	public static void main(String[] args) {
		int[] array = { 4, 1, 2, 6, 8, 4, 9, 1, 99, 45, 32 };
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		System.out.println("Lowest is = " + array[0] + " and highest is = " + array[array.length - 1]);
	}
}
