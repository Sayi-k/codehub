package org.core.threads.basic;

public class VolatileTests {

	public static void main(String[] args) throws InterruptedException {
		VolatileVariables volVar = new VolatileVariables();
		Thread t1 = new Thread(new Runners1(volVar));
		Thread t2 = new Thread(new Runners2(volVar));

		t1.start();
		t2.start();

		Thread.sleep(1000);
		System.out.println("Set the volatile variable to true");
		volVar.setTerminated(true);
	}

}

class Runners1 implements Runnable {
	VolatileVariables volVar;

	public Runners1(VolatileVariables vol) {
		volVar = vol;
	}

	@Override
	public void run() {
		while (!volVar.isTerminated) {
			System.out.println("Inside Runners1 " + volVar.isTerminated);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Runners2 implements Runnable {
	VolatileVariables volVar;

	public Runners2(VolatileVariables vol) {
		volVar = vol;
	}

	@Override
	public void run() {
		while (!volVar.isTerminated) {
			System.out.println("Inside Runners2 " + volVar.isTerminated);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class VolatileVariables {
	boolean isTerminated = false;

	public boolean isTerminated() {
		return isTerminated;
	}

	public void setTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}

}
