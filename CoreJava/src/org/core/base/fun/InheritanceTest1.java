package org.core.base.fun;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Base worker = new Worker();
		worker.test();
		worker.check();
	}

}

class Base {
	public static void test() {
		System.out.println("Base");
	}
	
	public void check() {
		System.out.println("Base check");
	}
}

class Worker extends Base {
	public static void test() {
		System.out.println("Worker");
	}
	
	public void check() {
		System.out.println("Worker check");
	}
}