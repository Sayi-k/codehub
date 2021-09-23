package org.core.base.tricks;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		// List<Integer> list = null;
		// for (int i : list) {
		// System.out.println(i);
		// }

		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list.toString());
		list.remove(2);
		list.remove(Integer.valueOf(4));
		System.out.println(list.toString());
		System.out.println(list.get(1));
	}
}
