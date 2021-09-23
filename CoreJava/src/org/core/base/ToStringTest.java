package org.core.base;

public class ToStringTest {

	public static void main(String[] args) {
		Test test = new Test("Ram", 1.1, 100);
		System.out.println(test.get("Ram"));
	}
}

class Test {
	String name;
	double val;
	int intVal;

	public Test(String name, double val, int intVal) {
		this.name = name;
		this.val = val;
		this.intVal = intVal;
	}

	public Test get(String name) {
		if (this.name.equalsIgnoreCase(name)) {
			return this;
		}
		return null;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test: Name = ").append(this.name).append(" Double value = ").append(this.val)
				.append(" Int value = ").append(this.intVal);
		return builder.toString();
	}
}
