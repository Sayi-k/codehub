package org.core.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,)");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		
		selectionSort(intValues);
		Arrays.stream(intValues).forEach(val -> System.out.print(val+" "));
	}
	
	private static void selectionSort(int[] arr) {
		int min;
		for(int i = 0; i<arr.length; i++) {
			min = i;
			for(int j=i+1; j<arr.length;j++) {
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr,i,min);
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
