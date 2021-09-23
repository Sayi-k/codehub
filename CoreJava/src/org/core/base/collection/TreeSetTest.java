package org.core.base.collection;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<Key> set = new TreeSet<>();
		set.add(new Key("xyz", "val1"));
		set.add(new Key("pqr", "val2"));
		set.add(new Key("abc", "val3"));
		set.add(new Key("stu", "val4"));
		set.add(new Key("lop", "val5"));
		set.add(new Key("lop", "val6"));
		for (Key k : set) {
			System.out.println(k.key + " - " + k.value);
		}
	}
}

class Key implements Comparable<Key> {
	String key;
	String value;

	public Key(String k, String v) {
		key = k;
		value = v;
	}

	@Override
	public int compareTo(Key k) {
		return this.key.compareTo(k.key);
	}
}
