package org.core.base;

public class OperatorTest {

	public static void main(String[] args) {
		byte a = 12;
		byte b = 127;

		byte c = 12;
		byte d = 127;

		System.out.println(b += a);
		System.out.println(d = (byte) (c + d));
		System.out.println(a + b);
	}

}
