package org.core.base.customannotation;

public class Sample {
	
	@MyAnnotation(val2 = "Test", val1 = 10)
	public void testAnotation() {
		System.out.println("Hello");
	}
}
