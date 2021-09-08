package org.core.design.creational.builder;

public class BuilderTest {

	public static void main(String[] args) {
		StudentBuilder student = StudentBuilder.getBuilder()
				.setId("123")
				.setName("Rajan")
				.setAge(32)
				.build();
		System.out.println(student);
	}

}
