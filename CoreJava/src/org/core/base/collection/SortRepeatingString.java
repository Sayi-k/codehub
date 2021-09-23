package org.core.base.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortRepeatingString {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		String[] words = { "xyz", "abc", "abc", "xyz", "pqr", "abc", "stp", "abc", "abc", "stp", "pqr", "xxx", "stp" };
		System.out.println(Arrays.toString(words));
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		display(map);
		sortBasedOnValue(map);
	}

	private static void sortBasedOnValue(Map<String, Integer> map) {
		ValueComparator customComparator = new ValueComparator(map);
		TreeMap<String, Integer> treeMap = new TreeMap<>(customComparator);
		treeMap.putAll(map);
		System.out.println("After sorting");
		display(treeMap);
	}

	private static void display(Map<String, Integer> map) {
		for (String word : map.keySet()) {
			System.out.println(word + " : " + map.get(word));
		}
	}
}

class ValueComparator implements Comparator<String> {
	Map<String, Integer> base;

	public ValueComparator(Map<String, Integer> map) {
		this.base = map;
	}

	@Override
	public int compare(String key1, String key2) {
		Integer val1 = base.get(key1);
		Integer val2 = base.get(key2);
		int num = val1.compareTo(val2);
		return num == 0 ? key1.compareTo(key2) : num;
	}

}