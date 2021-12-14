package org.core.base.clone;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		Sample sample = new Sample();
		sample.num = 10;
		System.out.println(sample+" - "+sample.hashCode()+": "+sample.test.name);
		Sample sampleClone = (Sample) sample.clone();
		sampleClone.num = 20;
		System.out.println(sampleClone+" - "+sampleClone.hashCode()+": "+sampleClone.test.name);
		System.out.println(sample.num+" - "+sampleClone.num);
	}

}
