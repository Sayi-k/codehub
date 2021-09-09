package org.dp.tabulation.sum;

public class CanSum {

	public static void main(String[] args) {
		System.out.println(canSum(6,new int[] {5,3,4}));
	}

	private static boolean canSum(int targetSum, int[] nums) {
		boolean[] tab = new boolean[targetSum+1];
		tab[0] = true;
		for(int i=0; i<=targetSum; i++) {
			if(tab[i] == true) {
				for(int num : nums) {
					if(i+num <= targetSum) tab[i+num] = true;
				}
			}
		}
		return tab[targetSum];
	}

}
