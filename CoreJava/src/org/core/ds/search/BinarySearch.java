package org.core.ds.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,) in ascending order");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println("Enter search value");
		int num = scan.nextInt();
		scan.close();
		
		int position = search(intValues, 0, intValues.length-1, num);
		if(position != -1) {
			System.out.println("Element found in location = "+position);
		}else {
			System.out.println("Element not found");
		}
	}

	private static int search(int[] arr, int low, int high, int num) {
		if(low <= high) {
			int mid = (low+high)/2;
			if(arr[mid] == num) {
				return mid;
			}
			if(num > arr[mid]) {
				return search(arr, mid+1, high, num);
			}
			return search(arr,low,mid-1,num);
		}
		return -1;
	}

}
