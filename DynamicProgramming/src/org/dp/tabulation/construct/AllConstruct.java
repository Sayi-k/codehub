package org.dp.tabulation.construct;

import java.util.ArrayList;
import java.util.Arrays;

public class AllConstruct {

	public static void main(String[] args) {
		System.out.println(allConstruct("purple",new String[] {"purp","p","ur","le","purpl"}));
		//[[purp, le], [p, ur, p, le]]
		System.out.println(allConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd","ef","c"}));
		//[[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
		System.out.println(allConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//null
		System.out.println(allConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//[[enter, a, p, ot, ent, p, ot], [enter, a, p, ot, ent, p, o, t], [enter, a, p, o, t, ent, p, ot], [enter, a, p, o, t, ent, p, o, t]]
		System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//null
	}

	@SuppressWarnings("unchecked")
	private static ArrayList<ArrayList<String>> allConstruct(String targetString, String[] wordBank) {
		ArrayList<ArrayList<String>>[] tab = new ArrayList[targetString.length()+1];
		tab[0] = new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<>()));
		
		for(int i=0; i <= targetString.length(); i++) {
			if(tab[i] != null) {
				for(String word : wordBank) {
					if((i+word.length() < tab.length) && targetString.startsWith(word, i)) {
						ArrayList<ArrayList<String>> dest = tab[i+word.length()];
						if(dest == null) {
							ArrayList<ArrayList<String>> newList = getNewList(tab[i]);
							newList.forEach(list -> list.add(word));
							tab[i+word.length()] = newList;
						}else {
							ArrayList<ArrayList<String>> newList = getNewList(tab[i]);
							newList.forEach(list -> list.add(word));
							tab[i+word.length()].addAll(newList);
						}
					}
				}
			}
		}
		return tab[targetString.length()];
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
