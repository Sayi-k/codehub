package org.core.base.fun;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Object> set = new HashSet<>();
		set.add(new Long(10));
		set.add(new Integer(10)); 
		for (Object obj : set) {
			System.out.println(obj);
		}
	}
}
