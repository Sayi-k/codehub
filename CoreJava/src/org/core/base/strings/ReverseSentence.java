package org.core.base.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseSentence {

	public static void main(String[] args) {
		String sentence = "hi how are you";
		System.out.println(sentence);
		List<String> list = Arrays.asList(sentence.split("\\s"));
		Collections.reverse(list);
		System.out.println(list);
	}
}
