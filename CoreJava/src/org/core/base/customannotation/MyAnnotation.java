package org.core.base.customannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
@interface MyAnnotation {

	int val1() default 1;
	String val2() default "";
}
