package org.core.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,)");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		
		bubbleSort(intValues);
		Arrays.stream(intValues).forEach(val -> System.out.print(val+" "));
	}

	private static void bubbleSort(int[] arr) {
		int length = arr.length;
		for(int i=1; i<length; i++) {
			for(int j=0; j<length-i; j++) {
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
