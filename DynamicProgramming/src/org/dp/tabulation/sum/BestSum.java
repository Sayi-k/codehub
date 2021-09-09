package org.dp.tabulation.sum;

import java.util.ArrayList;
import java.util.List;

public class BestSum {

	public static void main(String[] args) {
		System.out.println(bestSum(8, new int[]{2,3,5}));//[3,5]
		System.out.println(bestSum(7, new int[]{4,3,5,7}));//[7]
		System.out.println(bestSum(8, new int[]{1,4,5}));//[4,4]
		System.out.println(bestSum(100, new int[]{1,2,5,25}));//[25,25,25,25]
	}

	@SuppressWarnings("unchecked")
	private static List<Integer> bestSum(int targetSum, int[] nums) {
		List<Integer>[] tab = new ArrayList[targetSum+1];
		tab[0] = new ArrayList<>();
		for(int i=0; i<=targetSum; i++) {
			if(tab[i] != null) {
				for(int num : nums) {
					if((i+num) <= targetSum) {
						List<Integer> list = new ArrayList<>(tab[i]);
						list.add(num);
						if(tab[i+num] == null || list.size() < tab[i+num].size()) {
							tab[i+num] = list;
						}
					}
				}
			}
		}
		return tab[targetSum];
	}

}
