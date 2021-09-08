package org.core.design.behavioral.iterator;

public class Main {

	public static void main(String[] args) {
		NamesDB db = new NamesDB();
		MyIterator itr = db.getIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
