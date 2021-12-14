package org.core.java8.workout.thread.executiontime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileReadThread {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		FileReadThread fRead = new FileReadThread();
		List<Integer> count = Arrays.asList(0, 0, 0);
		Thread t1 = new Thread(
				() -> fRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file1.txt", "to", count, 0));
		Thread t2 = new Thread(
				() -> fRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file2.txt", "to", count, 1));
		Thread t3 = new Thread(
				() -> fRead.readFile("C:\\Users\\612463408\\Documents\\_Office\\tmp\\file3.txt", "to", count, 2));
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		long end = System.currentTimeMillis();
		int finalCount = count.get(0) + count.get(1) + count.get(2);
		System.out.println("Count is = " + finalCount);
		System.out.println("Execution time = " + (end - start));
	}

	void readFile(String path, String textToBeSearched, List<Integer> count, int i) {
		long start = System.currentTimeMillis();
		System.out.println("Thread" + i + " start");
		for (int k = 0; k < 1000; k++) {
			File file = new File(path);
			Integer countInt = count.get(i);
			try {

				BufferedReader br = new BufferedReader(new FileReader(file));
				String st;
				int tempCount;

				while ((st = br.readLine()) != null) {
					tempCount = (int) Stream.of(st.split("\\s+")).filter(word -> word.equals(textToBeSearched)).count();
					countInt = countInt + tempCount;
				}
				count.set(i, countInt);
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Thread" + i + " stop = " + (end - start));
	}
}
