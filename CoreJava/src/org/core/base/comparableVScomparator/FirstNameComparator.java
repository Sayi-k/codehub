package org.core.base.comparableVScomparator;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.fName.compareTo(emp2.fName);
	}
}
