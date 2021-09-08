package org.core.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,)");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		
		insertionSort(intValues);
		Arrays.stream(intValues).forEach(val -> System.out.print(val+" "));
	}

	private static void insertionSort(int[] arr) {
		int j;
		for(int i=1; i<arr.length; i++) {
			j=i;
			while(j>0 && arr[j]<arr[j-1]) {
				swap(arr,j,j-1);
				j--;
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
