package org.dp.construct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllConstruct {
	private static Map<String, ArrayList<ArrayList<String>>> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(allConstruct("purple",new String[] {"purp","p","ur","le","purpl"}));
		//[[purp, le], [p, ur, p, le]]
		memo.clear();
		System.out.println(allConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd","ef","c"}));
		//[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
		memo.clear();
		System.out.println(allConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//null
		memo.clear();
		System.out.println(allConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//[[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, ot], [enter, a, p, o, t, ent, p, o, t]]
		memo.clear();
		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//null
		memo.clear();
	}

	private static ArrayList<ArrayList<String>> allConstruct(String target, String[] wordBank) {
		
		if (memo.containsKey(target)) {
			return getNewList(memo.get(target));
		}
		
		if("".equals(target)) return new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<>()));
		
		ArrayList<ArrayList<String>> finalResult = null;
		
		for(String word : wordBank) {
			if(target.indexOf(word) == 0) {
				ArrayList<ArrayList<String>> insideList = allConstruct(target.substring(word.length()), wordBank);
				if(null != insideList) {
					insideList.stream().forEach(list -> list.add(0, word));//Adding branched suffix at the beginning
					finalResult = (finalResult == null) ? new ArrayList<ArrayList<String>>() : finalResult;
					finalResult.addAll(insideList);
				}
			}
		}

		if (!memo.containsKey(target)) {
			memo.put(target, finalResult);
		}
		
		return getNewList(finalResult);
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static ArrayList<ArrayList<String>> getNewList(ArrayList<ArrayList<String>> finalResult) {
		ArrayList<ArrayList<String>> deepCopyList = null;
		if(finalResult != null) {
			deepCopyList = new ArrayList<ArrayList<String>>();
			for(ArrayList list : finalResult) {
				deepCopyList.add((ArrayList<String>) list.clone());
			}
		}
		return deepCopyList;
	}

}
