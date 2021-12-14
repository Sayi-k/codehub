package org.core.ds.arraylist;

public class Runner {

	public static void main(String[] args) {
		CustArrayList list = new CustArrayList();
		list.add("0");
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		
		list.display();
		System.out.println("Removing index 5");
		list.remove(5);
		list.display();
		System.out.println("Get index 7 = "+list.get(7));
		
		list.add("10");
		list.add("11");
		list.add("12");
		list.display();
		
		System.out.println("Removing index 0");
		list.remove(0);
		list.display();
		
		//list.remove(-1);
		list.remove(54);
	}

}
