package org.core.design.structural.adapter;

public class Main {

	public static void main(String[] args) {
		AdapterInterface intr = new SocketAdapter();
		System.out.println(intr.getVolt120().val);
		System.out.println(intr.getVolt40().val);
	}

}
