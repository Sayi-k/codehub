package org.core.base.tricks;

public class MainTest {
	{
		System.out.println("Two");
	}

	static {
		System.out.println("One");
	}

	public MainTest() {
		System.out.println("Constructor called");
	}

	public static void main(String[] args) {
		MainTest test = new MainTest();
		int n = 99;
		System.out.println(add(n));
		System.out.println(n);
	}

	static int add(int n) {
		return n++;

	}
}
