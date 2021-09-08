package org.core.design.creational.abstractfactory;

public class FruitFactory extends AbstractFactory{

	@Override
	public Eatable getEatable(String type) {
		if("A".equalsIgnoreCase(type)) {
			return new Apple();
		}else if("O".equalsIgnoreCase(type)) {
			return new Orange();
		}
		return null;
	}

}
