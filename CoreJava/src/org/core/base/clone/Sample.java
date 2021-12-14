package org.core.base.clone;

public class Sample implements Cloneable{

	Test test = new Test("A");
	int num;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Sample sample = (Sample) super.clone();
		sample.test = new Test("B");
		return sample;
	}
}

class Test{
	String name;
	public Test(String name) {
		this.name = name;
	}
}