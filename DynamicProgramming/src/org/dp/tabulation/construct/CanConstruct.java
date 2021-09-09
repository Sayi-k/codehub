package org.dp.tabulation.construct;

public class CanConstruct {

	public static void main(String[] args) {
		System.out.println(canConstruct("abcdef",new String[] {"ab","abc","cd","def","abcd"}));
		//true
		System.out.println(canConstruct("skateboard",new String[] {"bo","rd","ate","t","ska","sk","boar"}));
		//false
		System.out.println(canConstruct("enterapotentpot",new String[] {"a","p","ent","enter","ot","o","t"}));
		//true
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeef",new String[] {
				"e","ee","eeeee","eeeeeeeeeee","ed"
		}));
		//false
	}

	private static boolean canConstruct(String targetString, String[] wordBank) {
		boolean[] tab = new boolean[targetString.length()+1];
		tab[0] = true;
		for(int i=0; i<=targetString.length(); i++) {
			if(tab[i] == true) {
				for(String word : wordBank) {
					if((i+word.length() < tab.length) && targetString.startsWith(word, i)) {
						tab[i+word.length()] = true;
					}
				}
			}
		}
		return tab[targetString.length()];
	}

}
