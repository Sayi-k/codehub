package org.core.java8.workout.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamGeekMethods {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("ABC", "Xyz", "pqt");
		List<String> intStrList = Arrays.asList("22", "43", "76", "99");
		List<Integer> intList = Arrays.asList(3, 6, 9, 12, 15); 
		IntStream intStream = IntStream.range(2, 12);
		
		System.out.println(list);
		System.out.println("Is ABC present? " + list.stream().anyMatch(str -> str.equals("ABC")));
		System.out.println();
		
		System.out.println("For each ordered: "); list.stream().forEachOrdered(System.out::print);
		System.out.println();System.out.println();
		
		
		System.out.println(intStrList);
		intStrList.stream().mapToInt(str -> Integer.parseInt(str)).filter(num -> num % 2 == 0).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Reverse sort");
		intStrList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("All match >2 : "+list.stream().allMatch(str->str.length()>2));
		System.out.println();
		
		System.out.println("Find first: "+ list.stream().findFirst().get());
		System.out.println();
		
		System.out.println("Flat map to int: ");
		intStrList.stream().flatMapToInt(str->IntStream.of(Integer.valueOf(str))).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Map to int: ");
		intStrList.stream().mapToInt(str->Integer.valueOf(str)).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Map: "+intList);
		intList.stream().map(val->val*2).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Peek for debug: ");
		System.out.println(intList.stream().peek(System.out::print).count());
		System.out.println();
		
		System.out.println("Skip first few elements: ");
		intStream.skip(4).forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Summary statistics");
		System.out.println(intStrList);
		System.out.println(intStrList.stream().flatMapToInt(str->IntStream.of(Integer.valueOf(str))).summaryStatistics());
		System.out.println();
		
		System.out.println("Stream builder");
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> stream = builder.add("Geeks") 
                .add("for") 
                .add("Geeks") 
                .add("GeeksQuiz") 
                .build(); 
		stream.forEach(System.out::print);
		System.out.println();System.out.println();
		
		System.out.println("Stream Array");
		Object[] arr = Stream.of(5, 6, 7, 8, 9, 10).toArray();
		System.out.println(Arrays.toString(arr)); 
		System.out.println();
	}

}
