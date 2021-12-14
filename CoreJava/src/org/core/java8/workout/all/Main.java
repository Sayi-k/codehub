package org.core.java8.workout.all;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Sagar", 30, 50000), new Employee("Ajay", 29, 60000),
				new Employee("Bharat", 32, 90000), new Employee("Zeel", 26, 100000), new Employee("Jaggu", 27, 150000));
		
		double avgSalary = list.stream().filter(emp -> emp.getAge() > 29).peek(emp -> System.out.println("Filter: "+emp))
				.mapToDouble(Employee::getSalary).peek(emp -> System.out.println("Double: "+emp))
				.average().getAsDouble();
		System.out.println(avgSalary);
	}

}
