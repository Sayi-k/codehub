package org.core.design.creational.abstractfactory;

public class VegFactory extends AbstractFactory{

	@Override
	public Eatable getEatable(String type) {
		if("C".equalsIgnoreCase(type)) {
			return new Carrot();
		}else if("B".equalsIgnoreCase(type)) {
			return new Beans();
		}
		return null;
	}

}
