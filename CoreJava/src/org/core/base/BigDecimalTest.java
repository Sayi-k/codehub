package org.core.base;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		BigDecimal bd1 = new BigDecimal("2.15");
		BigDecimal bd2 = new BigDecimal("1.10");
		System.out.println("Big decimal: " + bd1.subtract(bd2));

		double d1 = 2.15;
		double d2 = 1.10;
		System.out.println("Double: " + (d1 - d2));
	}

}
