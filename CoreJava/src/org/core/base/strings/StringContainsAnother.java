package org.core.base.strings;

public class StringContainsAnother {

	public static void main(String[] args) {
		String word = "Hi how are you Sir";
		System.out.println(word);
		String find = "you";
		System.out.println("Find " + find);
		boolean present = word.contains(find);
		boolean pres = word.indexOf(find) != -1 ? true : false;
		System.out.println(present + " " + pres);
	}
}
