package org.core.base.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class WordCount {

	public static void main(String[] args) {
		String word = "Test match is a test match and not a simple test";
		Pattern pattern = Pattern.compile("\\s+");
		String[] wordArray = pattern.split(word.toLowerCase());
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String words : wordArray) {
			if (map.containsKey(words)) {
				map.put(words, map.get(words) + 1);
			} else {
				map.put(words, 1);
			}
		}
		System.out.println(word);
		for (String str : map.keySet()) {
			System.out.println(str + " - " + map.get(str));
		}
	}
}
