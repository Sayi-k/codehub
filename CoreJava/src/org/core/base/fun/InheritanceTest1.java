package org.core.base.fun;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Base worker = new Worker();
		worker.test();
	}

}

class Base {
	public static void test() {
		System.out.println("Base");
	}
}

class Worker extends Base {
	public static void test() {
		System.out.println("Worker");
	}
}