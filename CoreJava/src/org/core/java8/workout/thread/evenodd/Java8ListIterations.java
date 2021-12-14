package org.core.java8.workout.thread.evenodd;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Java8ListIterations {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("abc","def","ghg","ijk","lmn","opq","rst","uvw","xyz");
		list.forEach(System.out::println);
		
		System.out.println("List value starting with x");
		custFilter(list, (str)->((String) str).startsWith("x"));
		
		System.out.println("List values starting with a or u");
		Predicate<String> pred1 = (str)->((String) str).startsWith("a");
		Predicate<String> pred2 = (str)->((String) str).startsWith("u");
		list.stream().filter(pred1.or(pred2)).forEach(System.out::println);
	}

	private static void custFilter(List<String> list, Predicate<String> pred) {
		list.stream().filter((str)->(pred.test(str))).forEach(System.out::println);
	}

}
