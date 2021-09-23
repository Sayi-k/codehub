package org.core.base.comparableVScomparator;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.lName.compareTo(emp2.lName);
	}

}
