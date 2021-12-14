package org.core.java8.workout.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

	public static void main(String[] args) {
		StreamTest.mapReduce();
	}

	public static void mapReduce() {
		List<Integer> list = Arrays.asList(23,34,56,123,431,234);
		double price, total = 0;
		for(int cost: list) {
			price = cost+.12*cost;
			total += price;
		}
		System.out.println("Java7 Total = "+total);
		
		double total8 = list.stream().map(cost-> cost+.12*cost).reduce((sum,cost)->sum+cost).get();
		System.out.println("Java8 Total = "+total8);
		System.out.println(list.stream().mapToDouble(cost-> cost+.12*cost).sum());
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		List<Integer> listOne = Arrays.asList(12,34,15,23,56);
		System.out.println(listOne.stream().map(val -> val*10).collect(Collectors.toList()));
		
		//Count the value of i in string
		String data = "India is the best to live";
		System.out.println(data.chars().filter(val -> val=='i' || val == 'I').count());
	}
	
}
