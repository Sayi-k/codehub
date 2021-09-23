package org.core.base.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicatesInArray {

	public static void main(String[] args) {
		String[] array = { "a", "b", "c", "d", "e", "b", "c", "c", "a", "c", "b" };
		System.out.println(Arrays.toString(array));
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : array) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}
		for (Entry entry : map.entrySet()) {
			System.out.println("Word: " + entry.getKey() + " - Repeated: " + entry.getValue());
		}
	}
}
