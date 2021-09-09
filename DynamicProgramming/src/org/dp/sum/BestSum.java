package org.dp.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {
	
	private static Map<Integer, List<Integer>> memo = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(bestSum(7,new int[] {5,3,4,7}));
		memo.clear();
		System.out.println(bestSum(8,new int[] {2,3,5}));
		memo.clear();
		System.out.println(bestSum(8,new int[] {1,4,5}));
		memo.clear();
		System.out.println(bestSum(100,new int[] {1,2,5,25}));
		memo.clear();
	}
	
	private static List<Integer> bestSum(int targetSum, int[] numbers) {
		if (memo.containsKey(targetSum)) {
			List<Integer> valueList = memo.get(targetSum);
			return (valueList!=null ? new ArrayList<>(valueList):null);
		}
		
		if (targetSum == 0) 
			return new ArrayList<>();
		if (targetSum < 0) 
			return null;
		List<Integer> shortestCombo = null;
		
		for(int num : numbers) {
			List<Integer> list = bestSum(targetSum-num, numbers);
			if(list != null) {
				list.add(num);
				if(shortestCombo == null || list.size() < shortestCombo.size()) {
					shortestCombo = list;
				}
			}
		}
		//Clone the list and adding to map. Otherwise the same value is getting updated
		if(!memo.containsKey(targetSum)) {
			//memo.put(targetSum, shortestCombo!=null ? new ArrayList<>(shortestCombo):null);
			memo.put(targetSum, shortestCombo);
		}
		return shortestCombo!=null ? new ArrayList<>(shortestCombo):null;
	}

}
