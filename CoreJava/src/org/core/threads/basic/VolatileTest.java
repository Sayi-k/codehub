package org.core.threads.basic;

import java.util.Scanner;

class Thread1 extends Thread {
	volatile static boolean isCounting = true;
	int count = 0;

	@Override
	public void run() {
		while (isCounting) {
			System.out.println(count);
			count++;
		}
	}

	public void stopCount() {
		isCounting = false;
	}
}

public class VolatileTest {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();

		Thread1 t2 = new Thread1();
		t2.start();
		
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println("Enter pressed");
		t1.stopCount();
	}

}
