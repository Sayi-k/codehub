package org.core.base.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class CountNumberOfWords {

	public static void main(String[] args) {
		String message = "Count the number of words here. Count should be the best here";
		Pattern pattern = Pattern.compile("\\s+");
		String[] wordArray = pattern.split(message);
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
		for (String word : wordArray) {
			if (wordCountMap.containsKey(word)) {
				wordCountMap.put(word, wordCountMap.get(word) + 1);
			} else {
				wordCountMap.put(word, 1);
			}
		}
		Set<String> StringSet = wordCountMap.keySet();
		for (String key : StringSet) {
			System.out.println(key + " : " + wordCountMap.get(key));
		}
	}

}
