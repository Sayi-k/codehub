package org.core.java8.workout.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Sagar", 30, 50000), new Employee("Ajay", 29, 60000),
				new Employee("Bharat", 32, 90000), new Employee("Zeel", 26, 100000), new Employee("Jaggu", 27, 150000));
		
		double avgSalary = list.stream().filter(emp -> emp.getAge() > 29).peek(emp -> System.out.println("Filter: "+emp))
				.mapToDouble(Employee::getSalary).peek(emp -> System.out.println("Double: "+emp))
				.average().getAsDouble();
		System.out.println(avgSalary);
		
		System.out.println("========================");
		
		System.out.println("Sort by Key Name");
		Map<Employee, Integer> mapKey = new HashMap<>();
		mapKey.put(new Employee("Sagar", 32, 50000), 234);
		mapKey.put(new Employee("Ajay", 29, 60000), 111);
		mapKey.put(new Employee("Bharat", 32, 90000), 34);
		mapKey.put(new Employee("Zeel", 26, 100000), 345);
		
		mapKey.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName))).forEach(System.out::println);
		System.out.println("========================");
		
		System.out.println("Sort by Value Name");
		Map<Integer, Employee> mapVal = new HashMap<>();
		mapVal.put(234, new Employee("Sagar", 30, 50000));
		mapVal.put(111, new Employee("Ajay", 29, 60000));
		mapVal.put(34, new Employee("Bharat", 32, 90000));
		mapVal.put(345, new Employee("Zeel", 26, 100000));
		
		mapVal.entrySet().stream().sorted(Entry.comparingByValue(Comparator.comparing(Employee::getName))).forEach(System.out::println);
		System.out.println("========================");
		
		System.out.println("Partition by Key Name");
		Map<Boolean, List<Entry<Employee, Integer>>> partitionMap = mapKey.entrySet().stream().collect(Collectors.partitioningBy(entry -> entry.getKey().getAge() >= 32));
		System.out.println(partitionMap);
		System.out.println("========================");
		
		System.out.println("Gouping by");
		List<Employee> empList = Arrays.asList(new Employee("Sagar", 32, 50000), new Employee("Ajay", 29, 60000), new Employee("Bharat", 32, 90000), new Employee("Zeel", 26, 100000));
		Map<Integer, List<Employee>> empMap = empList.stream().collect(Collectors.groupingBy(emp->emp.getAge()));
		System.out.println(empMap);
	}

}
