package org.core.base.comparableVScomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Raga", "Tripati");
		Employee emp2 = new Employee(2, "John", "Sena");
		Employee emp3 = new Employee(3, "Anant", "Naik");
		Employee emp4 = new Employee(4, "Thomas", "Deisoza");
		Employee emp5 = new Employee(5, "Pritvi", "Reddy");

		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp5);
		empList.add(emp2);
		empList.add(emp1);
		empList.add(emp4);
		empList.add(emp3);

		System.out.println("Without sorting");
		System.out.println(empList);

		System.out.println("\nAfter sorting using Comparable");
		Collections.sort(empList);
		System.out.println(empList);

		System.out.println("\nAfter sorting first name using Comparator");
		Collections.sort(empList, new FirstNameComparator());
		System.out.println(empList);

		System.out.println("\nAfter sorting last name using Comparator");
		Collections.sort(empList, new LastNameComparator());
		System.out.println(empList);
	}

}
