package org.core.design.structural.adapter;

public class Socket {
	
	class Volt{
		int val;
		public Volt(int v) {
			val = v;
		}
	}
	
	public Volt getVolt() {
		return new Volt(120);
	}
}
