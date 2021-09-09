package org.dp.tabulation.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowSum {

	public static void main(String[] args) {
		System.out.println(howSum(7,new int[] {2,4,5}));
		System.out.println(howSum(6,new int[] {5,3,4}));
		System.out.println(howSum(7,new int[] {5,3,4,7}));
		System.out.println(howSum(7,new int[] {2,4}));
		System.out.println(howSum(8,new int[] {2,3,5}));
		System.out.println(howSum(300,new int[] {7,14}));
	}

	@SuppressWarnings("unchecked")
	private static List<Integer> howSum(int targetSum, int[] nums) {
		List<Integer>[] tab = new ArrayList[targetSum+1];
		tab[0] = new ArrayList<>();
		for(int i=0; i <= targetSum; i++) {
			if(tab[i] != null) {
				for(int num : nums) {
					if(i+num <= targetSum) {
						List<Integer> list = new ArrayList<>(tab[i]);
						list.add(num);
						tab[i+num] = list;
					}
				}
			}
		}
		return tab[targetSum];
	}

}
