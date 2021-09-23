package org.core.base.practice.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class OccurencesInArray {
	public static void main(String args[]) {
		int[] intArray = { 22, 44, 11, 22, 44, 55, 22 };
		findOccurences(intArray);
		findOccurrenceTreeMap(intArray);
	}

	private static void findOccurrenceTreeMap(int[] intArray) {
		TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < intArray.length; i++) {
			int num = intArray[i];
			if (treeMap.containsKey(num)) {
				treeMap.put(num, treeMap.get(num) + 1);
			} else {
				treeMap.put(num, 1);
			}
		}
		for (int key : treeMap.keySet()) {
			System.out.println("Tree map Number of occurences of " + key + " is: " + treeMap.get(key));
		}
	}

	private static void findOccurences(int[] intArray) {
		Map<Integer, Integer> arrayMap = new HashMap<Integer, Integer>();
		int num;
		for (int i = 0; i < intArray.length; i++) {
			num = intArray[i];
			if (arrayMap.containsKey(num)) {
				arrayMap.put(num, arrayMap.get(num) + 1);
			} else {
				arrayMap.put(num, 1);
			}
		}
		for (int key : arrayMap.keySet()) {
			System.out.println("Number of occurences of " + key + " is: " + arrayMap.get(key));
		}

	}
}
