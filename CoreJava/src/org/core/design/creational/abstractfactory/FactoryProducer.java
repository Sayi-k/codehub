package org.core.design.creational.abstractfactory;

public class FactoryProducer {
	public AbstractFactory getfacroty(String catagory) {
		if("V".equalsIgnoreCase(catagory)) {
			return new VegFactory();
		}else if("F".equalsIgnoreCase(catagory)) {
			return new FruitFactory();
		}
		return null;
	}
}
