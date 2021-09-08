package org.core.design.creational.abstractfactory;

public class MainClass {

	public static void main(String[] args) {
		FactoryProducer producer = new FactoryProducer();
		producer.getfacroty("F").getEatable("A").get();
		producer.getfacroty("V").getEatable("B").get();
	}

}
