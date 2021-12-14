package org.core.java8.workout.thread.evenodd;

public class Java8ThreadEx {

	public static void main(String[] args) {

		Print print = new Print();

		Thread oddThread = new Thread(() -> {
			print.printOdd();
		});

		Thread evenThread = new Thread(() -> {
			print.printEven();
		});
		oddThread.setName("odd");
		evenThread.setName("even");
		oddThread.start();
		evenThread.start();
	}
}

class Print {
	boolean isEvenExecuted = false;

	public void printEven() {
		int i = 0;
		while (i <= 10) {
			synchronized (this) {
				try {
					System.out.println(Thread.currentThread().getName() + " - " + i);
					i = i + 2;
					this.isEvenExecuted = true;
					notifyAll();
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void printOdd() {
		int i = 1;
		while (i <= 9) {
			synchronized (this) {
				try {
					if (!this.isEvenExecuted) {
						System.out.println(Thread.currentThread().getName() + " waited once...");
						wait();
					}
					System.out.println(Thread.currentThread().getName() + " - " + i);
					i = i + 2;
					notifyAll();
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
