package org.core.base.practice.hashmap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapAndTable {

	public static void main(String[] args) {
		// ----------hashtable -------------------------
		Hashtable<Integer, String> ht = new Hashtable<Integer, String>();
		ht.put(101, "ajay");
		ht.put(101, "Vijay");
		ht.put(104, "Ravi");
		ht.put(103, "Rahul");
		ht.put(106, "Ravi");
		ht.put(108, "Raju");
		System.out.println("-------------Hash table--------------");
		for (Map.Entry m : ht.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		// ----------------hashmap--------------------------------
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(100, "Amit");
		hm.put(null, "Amit"); // hash map allows duplicate values
		hm.put(102, "Vijay");
		hm.put(102, null);
		System.out.println("-----------Hash map-----------");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

}
