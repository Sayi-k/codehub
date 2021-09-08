package org.core.ds.sort;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println("Enter int value seperated by comma(,)");
		Scanner scan = new Scanner(System.in);
		String values = scan.next();
		int[] intValues = Arrays.stream(values.split(",")).mapToInt(Integer::parseInt).toArray();
		scan.close();
		
		mergeSort(intValues, new int[intValues.length], 0, intValues.length-1);
		Arrays.stream(intValues).forEach(val -> System.out.print(val+" "));
	}

	private static void mergeSort(int[] arr, int[] tmp, int startIndex, int endIndex) {
		if(startIndex == endIndex) {
			return;
		}
		int mid = (startIndex+endIndex)/2;
		mergeSort(arr, tmp, startIndex, mid);	//Recursively diving left portion of array
		mergeSort(arr, tmp, mid+1, endIndex);	//Recursively diving right portion of array
		mergeHalves(arr, tmp, startIndex, endIndex);	//Merge 2 portions of array
	}

	private static void mergeHalves(int[] arr, int[] tmp, int start, int end) {
		int mid = (start+end)/2;
		
		int leftStart = start;
		int leftEnd = mid;
		int rightStart = mid+1;
		int rightEnd = end;
		
		int index = start;
		int size = end-start+1;
		
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if(arr[leftStart] <= arr[rightStart]) {
				tmp[index] = arr[leftStart];
				leftStart++;
			}else {
				tmp[index] = arr[rightStart];
				rightStart++;
			}
			index++;
		}
		System.arraycopy(arr, leftStart, tmp, index, leftEnd-leftStart+1);
		System.arraycopy(arr, rightStart, tmp, index, rightEnd-rightStart+1);
		System.arraycopy(tmp, start, arr, start, size);
	}

}
