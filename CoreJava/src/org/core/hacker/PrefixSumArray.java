package org.core.hacker;

import java.util.Arrays;

public class PrefixSumArray {

	public static void main(String[] args) {
		int n = 5;
		int arr[] = {1,0,1,1,1};
		int q = 4;
		/* 1: Right shift 2: Prefix sum count of 1's */
		int quer[] = {2,1,1,2};
		
		int res[] = calculate(n,arr,q,quer);
		System.out.println(Arrays.toString(res));

	}

	private static int[] calculate(int n, int[] arr, int q, int[] quer) {
		int res[] = new int[q];
		int resIndex = 0;
		int index = 0;
		for(int query: quer) {
			if(query == 2) {
				int ind = index;
				int sum = 0;
				for(int i =0; i<n; i++) {
					if(arr[ind % n] == 1) {
						sum += 1;
						ind++;
					}else {
						res[resIndex++] = sum;
						break;
					}
				}
			}else if(query == 1) {
				index = (index + n-1)%n;
			}
		}
		return res;
	}

}
