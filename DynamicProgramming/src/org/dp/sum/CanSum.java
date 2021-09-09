package org.dp.sum;

import java.util.HashMap;
import java.util.Map;

public class CanSum {
	
	private static Map<Integer, Boolean> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(canSum(7,new int[] {2,3}));
		memo.clear();
		System.out.println(canSum(6,new int[] {5,3,4}));
		memo.clear();
		System.out.println(canSum(7,new int[] {5,3,4,7}));
		memo.clear();
		System.out.println(canSum(7,new int[] {2,4}));
		memo.clear();
		System.out.println(canSum(8,new int[] {2,3,5}));
		memo.clear();
		System.out.println(canSum(300,new int[] {7,14}));
		memo.clear();
	}

	private static boolean canSum(int targetSum, int [] numbers) {
		if(memo.containsKey(targetSum)) return memo.get(targetSum);
		
		if(targetSum == 0) return true;
		if(targetSum < 0) return false;
		
		for(int n : numbers) {
			if(canSum(targetSum - n, numbers)) {
				memo.put(targetSum, true);
				return true;
			}
		}
		memo.put(targetSum, false);
		return false;
	}

}
