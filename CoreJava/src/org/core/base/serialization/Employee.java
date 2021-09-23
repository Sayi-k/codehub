package org.core.base.serialization;


import java.io.Serializable;

class Employee implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	transient int a;
    static int b;
    String name;
    int age;
  
    // Default constructor
public Employee(String name, int age, int a, int b)
    {
        this.name = name;
        this.age = age;
        this.a = a;
        Employee.b = b;
    }
  
}
