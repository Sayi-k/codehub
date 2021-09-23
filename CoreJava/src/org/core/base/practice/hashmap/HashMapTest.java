package org.core.base.practice.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args) {
		Person p1 = new Person("Ram");
		Person p2 = new Person("Ram");
		Person p3 = new Person("Sam");
		Person p4 = new Person("Jam");
		Map<Person, String> map = new HashMap<>();
		map.put(p1, "p1");
		map.put(p2, "p2");
		map.put(p3, "p3");
		map.put(p4, "p4");
		for (Person p : map.keySet()) {
			System.out.println(p.name + " " + map.get(p));
		}
		System.out.println("****************");
		System.out.println(map.get(p2));
	}

}

class Person {
	String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}