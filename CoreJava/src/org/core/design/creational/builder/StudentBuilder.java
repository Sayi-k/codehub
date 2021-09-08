package org.core.design.creational.builder;

public class StudentBuilder {
	private String id;
	private String name;
	private int age;
	
	private StudentBuilder(Builder build) {
		this.id = build.id;
		this.name = build.name;
		this.age = build.age;
	}
	
	private StudentBuilder() {}
	
	public static Builder getBuilder() {
		return new Builder();
	}
	
	public static class Builder{
		private String id;
		private String name;
		private int age;
		
		private Builder() {}
		
		public Builder setId(String id) {
			this.id = id;
			return this;
		}
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public StudentBuilder build() {
			return new StudentBuilder(this);
		}
		
	}
	
	//@Override
	public String toString() {
		return "ID:"+this.id+" Name:"+this.name+" Age:"+this.age;
	}
}
