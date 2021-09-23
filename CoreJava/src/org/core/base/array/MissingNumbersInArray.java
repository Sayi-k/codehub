package org.core.base.array;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumbersInArray {

	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3, 4, 5, 6, 8, 10, 13 };
		System.out.println(Arrays.toString(intArray));
		printMissingNumbersUsingBitSet(intArray, 13);
	}

	private static void printMissingNumbersUsingBitSet(int[] intArray, int count) {
		int missingCount = count - intArray.length;
		BitSet bitSet = new BitSet(count);
		for (int i : intArray) {
			bitSet.set(i - 1);
		}

		int clearIndex = 0;
		for (int i = 0; i < missingCount; i++) {
			clearIndex = bitSet.nextClearBit(clearIndex);
			System.out.println("Missing number = " + (++clearIndex));
		}
	}
}
