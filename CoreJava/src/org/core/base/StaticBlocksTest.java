package org.core.base;

public class StaticBlocksTest {

	public static void main(String[] args) {
		Check check = new Check();
	}

}

class Check {
	public Check() {
		System.out.println("Inside constructor");
	}

	{
		System.out.println("Inside anonymus block");
	}
	static {
		System.out.println("Inside static block");
	}
}