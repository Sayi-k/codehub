package org.core.java8.workout.all;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 https://javaconceptoftheday.com/solving-real-time-queries-using-java-8-features-employee-management-system/
 * */
public class EmpCalculation {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700));
		
		/* Query 1 : How many male and female employees are there in the organization? 
		 * For queries such as above where you need to group the input elements, use the Collectors.groupingBy() method. 
		 * In this query, we use Collectors.groupingBy() method which takes two arguments. 
		 * We pass Employee::getGender as first argument which groups the input elements based on gender and 
		 * Collectors.counting() as second argument which counts the number of entries in each group.
		 * */
		Map<String, Long> mapGenderCount = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(mapGenderCount);
		System.out.println("=======================================================");
		
		
		/* Query 2 : Print the name of all departments in the organization? 
		 * Use distinct() method after calling map(Employee::getDepartment) on the stream. 
		 * It will return unique departments.
		 * */
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		System.out.println("=======================================================");
		
		
		/* Query 3 : What is the average age of male and female employees? 
		 * Use same method as query 1 but pass Collectors.averagingInt(Employee::getAge) 
		 * as the second argument to Collectors.groupingBy().
		 * */
		Map<String, Double> mapMaleFemale = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(mapMaleFemale);
		System.out.println("=======================================================");
		
		
		/* Query 4 : Get the details of highest paid employee in the organization? */
		Optional<Employee> empMaxSalary = employeeList.stream().max(Comparator.comparingInt(Employee::getSalary));
		System.out.println(empMaxSalary.get());
		System.out.println("=======================================================");
		
		
		/* Query 5 : Get the names of all employees who have joined after 2015? 
		 * For such queries which require filtering of input elements, use Stream.filter() method 
		 * which filters input elements according to supplied Predicate.
		 * */
		employeeList.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
		System.out.println("=======================================================");
		
		
		/* Query 6 : Count the number of employees in each department? 
		 * This query is same as query 1 but here we are grouping the elements by department.
		 * */
		Map<String, Long> mapDeptEmp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println(mapDeptEmp);
		System.out.println("=======================================================");
		
		
		/* Query 7 : What is the average salary of each department? */
		Map<String, Double> mapEmpAvgSal = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
		System.out.println(mapEmpAvgSal);
		System.out.println("=======================================================");
		
		
		/*
		 * Query 8 : Get the details of youngest male employee in the product
		 * development department?
		 */
		Optional<Employee> empMinAge = employeeList.stream()
		.filter(e  -> e.getGender().equalsIgnoreCase("MALE") && e.getDepartment().equalsIgnoreCase("Product Development"))
		.min(Comparator.comparingInt(Employee::getAge));
		System.out.println(empMinAge.get());
		System.out.println("=======================================================");
		
		/* Query 9 : Who has the most working experience in the organization? 
		 * For this query, sort employeeList by yearOfJoining in natural order 
		 * and first employee will have most working experience in the organization. 
		 * To solve this query, we will be using sorted() and findFirst() methods of Stream.
		 * */
		Optional<Employee> empExp = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
		System.out.println(empExp.get());
		System.out.println("=======================================================");
		
		
		/*
		 * Query 10 : How many male and female employees are there in the sales and
		 * marketing team?
		 */
		Map<String, Long> countMaleFemaleEmployeesInSalesMarketing = employeeList.stream()
				.filter(e -> e.getDepartment()=="Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countMaleFemaleEmployeesInSalesMarketing);
		System.out.println("=======================================================");
		
		
		/* Query 11 : What is the average salary of male and female employees? */
		Map<String, Double> avgSalaryOfMaleAndFemaleEmployees = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println(avgSalaryOfMaleAndFemaleEmployees);
		System.out.println("=======================================================");
		
		
		/* Query 12 : List down the names of all employees in each department? */
		Map<String, List<Employee>> mapEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println(mapEmp);
		System.out.println("=======================================================");
		
		
		/*
		 * Query 13 : What is the average salary and total salary of the whole organization?
		 * For this query, we use Collectors.summarizingDouble() on Employee::getSalary 
		 * which will return statistics of the employee salary like max, min, average and total.
		 */
		DoubleSummaryStatistics employeeSalaryStatistics = employeeList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		System.out.println("Average Salary = "+employeeSalaryStatistics.getAverage());
		System.out.println("Total Salary = "+employeeSalaryStatistics.getSum());
		System.out.println("=======================================================");
		
		
		/*
		 * Query 14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years?
		 * For this query, we will be using Collectors.partitioningBy() method 
		 * which separates input elements based on supplied Predicate.
		 */
		Map<Boolean, List<Employee>> mapEmpPartition =employeeList.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println(mapEmpPartition);
		System.out.println("=======================================================");
		
		
		/*
		 * Query 15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
		 */
		Optional<Employee> oldestEmployeeWrapper = employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
		System.out.println(oldestEmployeeWrapper.get());
	}

}
