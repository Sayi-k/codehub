package org.core.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,)");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		
		quickSort(intValues,0,intValues.length-1);
		Arrays.stream(intValues).forEach(val -> System.out.print(val+" "));
	}

	private static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot = partition(arr, start, end);
			quickSort(arr,start,pivot-1);
			quickSort(arr,pivot+1,end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pi = arr[end];
		int i = start;
		for(int j=start; j<end; j++) {
			if(arr[j]<pi) {
				swap(arr,j,i);
				i++;
			}
		}
		swap(arr,i,end);
		return i;
	}

	private static void swap(int[] arr, int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
