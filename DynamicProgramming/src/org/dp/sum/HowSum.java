package org.dp.sum;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

	private static Map<Integer, List<Integer>> memo = new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(howSum(7,new int[] {2,4,5}));
		memo.clear();
		System.out.println(howSum(6,new int[] {5,3,4}));
		memo.clear();
		System.out.println(howSum(7,new int[] {5,3,4,7}));
		memo.clear();
		System.out.println(howSum(7,new int[] {2,4}));
		memo.clear();
		System.out.println(howSum(8,new int[] {2,3,5}));
		memo.clear();
		System.out.println(howSum(300,new int[] {7,14}));
		memo.clear();
	}

	private static List<Integer> howSum(int targetSum, int[] numbers) {
		if (memo.containsKey(targetSum)) {
			List<Integer> valueList = memo.get(targetSum);
			return (valueList!=null ? new ArrayList<>(valueList):null);
		}
		if (targetSum == 0) return new ArrayList<>();
		if (targetSum < 0) return null;
		
		for(int num : numbers) {
			List<Integer> list = howSum(targetSum-num, numbers);
			if(list != null) {
				list.add(num);
				memo.put(targetSum, list);
				return new ArrayList<>(list);
			}
		}
		memo.put(targetSum, null);
		return null;
	}

}
