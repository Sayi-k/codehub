package org.core.base;

import java.util.ArrayList;
import java.util.List;

public class OverloadingAndOverridingTest extends SuperClass {

	public static void main(String[] args) {
		OverloadingAndOverridingTest test = new OverloadingAndOverridingTest();
		test.printSomething();
		Integer num = 1;
		test.doThis(num);
		List<Object> list = new ArrayList<Object>();
		test.doThis(list);
	}

	@Override
	public String printSomething() {
		System.out.println("In subclass");
		return null;
	}

	public final void doThis(int num) {
		System.out.println("do this Integer" + num);
	}

	public final void doThis(Object num) {
		System.out.println("do this Object" + num);
	}

	public final void doThis(List<Object> list) {
		System.out.println("do this List" + list.toString());
	}

	public final void doThis(ArrayList<?> list) {
		System.out.println("do this ArrayList" + list.toString());
	}
}

class SuperClass {
	public Object printSomething() {
		System.out.println("In SuperClass");
		return null;
	}
}
