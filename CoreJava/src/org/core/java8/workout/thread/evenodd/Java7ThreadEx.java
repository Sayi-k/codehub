package org.core.java8.workout.thread.evenodd;

public class Java7ThreadEx {

	public static void main(String[] args) {
		IsOdd odd = new IsOdd();
		Thread oddT = new Thread(new OddThread(odd));
		Thread evenT = new Thread(new EvenThread(odd));
		oddT.start();
		evenT.start();
	}
}

class IsOdd {
	boolean isOdd = false;
}

class OddThread implements Runnable {

	IsOdd odd;

	public OddThread(IsOdd odd) {
		this.odd = odd;
	}

	@Override
	public void run() {
		int i = 1;
		try {
			synchronized (odd) {
				while (i <= 5) {
					System.out.println("Odd " + odd.isOdd);
					if (odd.isOdd) {
						odd.isOdd = false;
						System.out.println("Odd thread = " + i);
						i = i + 2;
					}
					odd.notifyAll();
					odd.wait();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}

class EvenThread implements Runnable {

	IsOdd odd;

	public EvenThread(IsOdd odd) {
		this.odd = odd;
	}

	@Override
	public void run() {
		int i = 0;
		try {
			synchronized (odd) {
				while (i < 5) {
					System.out.println("Even " + odd.isOdd);
					if (!odd.isOdd) {
						odd.isOdd = true;
						System.out.println("Even thread = " + i);
						i = i + 2;
					}
					odd.notifyAll();
					odd.wait();
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
