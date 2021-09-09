package org.dp.construct;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
	private static Map<String, Integer> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(countConstruct("purple",new String[] {"purp","p","ur","le","purpl"}));
		//2
		memo.clear();
		System.out.println(countConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd"}));
		//1
		memo.clear();
		System.out.println(countConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//0
		memo.clear();
		System.out.println(countConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//4
		memo.clear();
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//0
		memo.clear();
	}

	private static int countConstruct(String target, String[] wordBank) {
		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		
		if("".equals(target)) return 1;
		
		int totalCount = 0;
		
		for(String word : wordBank) {
			if(target.indexOf(word) == 0) {
				int possiblelityCount = countConstruct(target.substring(word.length()), wordBank);
				totalCount += possiblelityCount;
			}
		}
		
		memo.put(target, totalCount);
		return totalCount;
	}

}
