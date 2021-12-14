package org.core.java8.workout.methodr1;

public class Main {

	public static void main(String[] args) {

		//Using Lambda
		TriFunction<Sum, String, String, Integer> lambda = (s, arg1, arg2) -> s.doSum(arg1, arg2);
		System.out.println(lambda.apply(new Sum(), "2", "3"));
		
		//Using method refernce
		TriFunction<Sum, String, String, Integer> mr = Sum::doSum;
		System.out.println(mr.apply(new Sum(), "1", "4"));
	}

}

class Sum {
	Integer doSum(String s1, String s2) {
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}
}