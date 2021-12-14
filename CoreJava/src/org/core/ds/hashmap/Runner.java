package org.core.ds.hashmap;

public class Runner {

	public static void main(String[] args) {
		CustHashMap<Integer, String> map = new CustHashMap<Integer, String>();
        System.out.println("Going to add entries in map");
        map.put(null, "Nothing");
        map.put(1, "ABC");
        map.put(2, "XYZ");
        System.out.println("Displaying all the entry in map");
        map.display();
        System.out.println("Removing the entry with key 2");
        map.remove(2);
        map.display();
        System.out.println("Adding duplicate key 1 in map");
        map.put(1, "ABC replace");
        map.put(2, "XYZ again");
        System.out.println("Displaying all the entry in map again");
        map.display();
        System.out.println("Adding entry with key 17 in map");
        map.put(5, "PQR");
        map.display();
	}

}
