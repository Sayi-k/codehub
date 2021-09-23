package org.core.base.comparableVScomparator;

public class Employee implements Comparable<Employee> {

	int id;
	String fName;
	String lName;

	public Employee(int id, String fname, String lname) {
		this.id = id;
		this.fName = fname;
		this.lName = lname;
	}

	@Override
	public int compareTo(Employee employee) {
		if (this.id < employee.id)
			return -1;
		else if (this.id > employee.id)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		return "\nID: " + this.id + "|First Name: " + this.fName + "|Last Name: " + this.lName;
	}
}
