package org.core.java8.workout.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamGeekIntStream {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(23,4,6,28,100,87,1,66);
		
		System.out.println(intList);
		System.out.println("Sum = " +intList.stream().mapToInt(Integer::valueOf).sum());
		System.out.println();
		
		System.out.println("Generate and sorted");
		IntStream intStream = IntStream.generate(() -> (int)(Math.random()*100)).limit(5);
		intStream.peek(i -> System.out.print(i+" ")).sorted().forEach(i -> System.out.print("-"+i));
		System.out.println();System.out.println();
		
		System.out.println("Concat");
		IntStream is1 = IntStream.of(1,2,3);
		IntStream is2 = IntStream.of(3,4,5,6,7,8);
		IntStream.concat(is1, is2).forEach(i -> System.out.print(i+" "));
		System.out.println();System.out.println();
		
		List<String> doubleList = Arrays.asList("1.5", "2.7", "3", "4", "5.6"); 
		System.out.println(doubleList);
		doubleList.stream().flatMapToDouble(str->DoubleStream.of(Double.valueOf(str))).forEach(i -> System.out.print(i+" "));
		System.out.println();System.out.println();
		
		System.out.println(intList);
		System.out.println("Max: "+intList.stream().flatMapToInt(IntStream::of).max().getAsInt());
		System.out.println("Min: "+intList.stream().flatMapToInt(i->IntStream.of(i)).min().getAsInt());
		System.out.println("Average: "+intList.stream().flatMapToInt(i->IntStream.of(i)).average().getAsDouble());
		System.out.println();
		
		System.out.println("Distinct");
		IntStream is = IntStream.of(1,2,2,3,3,1,4,7,8,8);
		is.distinct().forEach(i->System.out.print(i+" "));
		System.out.println();System.out.println();
		
		System.out.println("As double stream");
		IntStream stream = IntStream.of(3, 5, 9, 12, 14); 
		stream.asDoubleStream().forEach(i->System.out.print(i+" "));
		System.out.println();System.out.println();
		
		System.out.println("Reduce");
		IntStream str = IntStream.of(1,2,3,4,5);
		System.out.println("Sum: "+str.reduce((a,b)->a+b).getAsInt());
		System.out.println();
		
		System.out.println("Reduce with initial value");
		IntStream str1 = IntStream.of(1,2,3,4,5);
		System.out.println("Sum: "+str1.reduce(1,(a,b)->a+b));
		System.out.println();
	}

}
