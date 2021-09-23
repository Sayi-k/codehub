package org.core.base.fun;

public class InheritanceTest2 {

	public static void main(String[] args) {
		Two two = new Two();
		One one = two;
		two.test();
		one.test();
		System.out.println(Parent.num);
	}

}

interface Parent {
	public int num = 100;

	void test();
}

class One {
	public void test() {
		System.out.println("One");
	}
}

class Two extends One implements Parent {
	@Override
	public void test() {
		System.out.println("Two");
	}
}
