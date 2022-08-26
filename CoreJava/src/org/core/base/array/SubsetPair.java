package org.core.base.array;

import java.util.Arrays;

public class SubsetPair {

	/*
	 * Find subset pairs from an array whose difference is some number 
	 * */
	public static void main(String[] args) {
		int[] arr = new int[] {5, 3, 1, 8, 2, 7, 9, 4, 6};
		int diff = 5;
		System.out.println("Original array :"+Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println("Sorted array :"+Arrays.toString(arr));
		System.out.println("Difference value is: "+diff);

		int i =0; int j = 1;
		int size = arr.length;
		while(i < size && j < size) {
			if(arr[j] - arr[i] == diff) {
				System.out.println("("+arr[i]+","+arr[j]+")");
				i++;
			}else if((arr[j] - arr[i]) < diff) {
				j++;
			}else {
				i++;
			}
		}
	}

}
