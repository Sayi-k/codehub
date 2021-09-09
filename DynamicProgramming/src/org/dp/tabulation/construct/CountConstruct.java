package org.dp.tabulation.construct;

public class CountConstruct {

	public static void main(String[] args) {
		System.out.println(countConstruct("purple",new String[] {"purp","p","ur","le","purpl"}));
		//2
		System.out.println(countConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd"}));
		//1
		System.out.println(countConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//0
		System.out.println(countConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//4
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//0
	}

	private static int countConstruct(String targetString, String[] wordBank) {
		int[] tab = new int[targetString.length()+1];
		tab[0] = 1;
		for(int i=0; i<=targetString.length(); i++) {
			if(tab[i] > 0) {
				for(String word : wordBank) {
					if((i+word.length() <= tab.length) && targetString.startsWith(word, i)) {
						tab[i+word.length()] += tab[i];
					}
				}
			}
		}
		return tab[targetString.length()];
	}

}
