package org.core.base.customannotation;

import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Sample sample = new Sample();
		Method  method = sample.getClass().getMethod("testAnotation");
		System.out.println(method.getName()+" - "+method.getParameterCount());
		MyAnnotation annotation =method.getAnnotation(MyAnnotation.class);
		System.out.println(annotation);
		System.out.println(annotation.val1()+" - "+annotation.val2());
	}

}
