package org.core.java8.workout.thread.executiontime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Stream;

public class FileRead {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		FileRead fileRead = new FileRead();
		int count = 0;
		count = fileRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file1.txt", count, "to");
		count = fileRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file2.txt", count, "to");
		count = fileRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file3.txt", count, "to");
		long end = System.currentTimeMillis();
		System.out.println("Count is = " + count);
		System.out.println("Execution time = " + (end - start));
	}

	int readFile(String path, int count, String textToBeSearched) {
		long start = System.currentTimeMillis();
		for (int k = 0; k < 1000; k++) {
			File file = new File(path);
			try {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String st;
				int tempCount;
				while ((st = br.readLine()) != null) {
					tempCount = (int) Stream.of(st.split("\\s+")).filter(word -> word.equals(textToBeSearched)).count();
					count = count + tempCount;
				}
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time of method = " + (end - start));
		return count;
	}
}
