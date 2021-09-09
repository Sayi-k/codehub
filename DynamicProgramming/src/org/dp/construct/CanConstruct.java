package org.dp.construct;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
	
	private static Map<String, Boolean> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(canConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd"}));
		//true
		memo.clear();
		System.out.println(canConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//false
		memo.clear();
		System.out.println(canConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//true
		memo.clear();
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//false
		memo.clear();
	}

	private static boolean canConstruct(String target, String[] wordBank) {
		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		
		if("".equals(target)) return true;
		
		for(String word : wordBank) {
			if(target.indexOf(word) == 0) {
				String suffix = target.substring(word.length());
				if (canConstruct(suffix, wordBank)) {
					memo.put(target, true);
					return true;
				}
			}
			
		}
		memo.put(target, false);
		return false;
	}

}
