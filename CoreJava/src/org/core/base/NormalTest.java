package org.core.base;

import java.util.HashMap;
import java.util.Map;

public class NormalTest {

	public static void main(String[] args) {
		Person p1 = new Person("Nani", 1);
		Person p2 = new Person("Nani", 2);
		Person p3 = new Person("Ram", 3);
		Person p4 = new Person("Rama", 4);
		Map<Person, Person> map = new HashMap<>();
		map.put(p1, p1);
		map.put(p2, p2);
		map.put(p3, p3);
		map.put(p4, p4);
		for (Person p : map.keySet()) {
			System.out.println(map.get(p).name + " " + map.get(p).num);
		}
	}

}

class Person {

	public String name;
	int num;

	public Person(String n, int i) {
		name = n;
		num = i;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
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
		if (num != other.num)
			return false;
		return true;
	}

}
