package day31.employeeanalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

public class Main{
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Rahul", "IT", 50000);
		Employee e2 = new Employee("Priya", "HR", 40000);
		Employee e3 = new Employee("Amit", "IT", 60000);
		Employee e4 = new Employee("Neha", "HR", 45000);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println("======== Employee Records ========");
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
		
		double averageSalary = employees.stream()
				.mapToDouble(Employee::getSalary)
				.average()
				.orElse(0.0);
		
		System.out.println("\nAverage Salary: " + averageSalary);
		
		Employee highestPaid = employees.stream()
		        .max(Comparator.comparingDouble(Employee::getSalary))
		        .orElse(null);

		System.out.println("\nHighest Paid Employee: " + highestPaid);
		
		Map<String, List<Employee>> departmentWise =
		        employees.stream()
		        .collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println("\n===== Department Wise Employees =====");

		departmentWise.forEach((department, employeeList) -> {
		    System.out.println(department + " : " + employeeList);
		});
		
		Map<String, Long> departmentCount =
		        employees.stream()
		        .collect(Collectors.groupingBy(
		                Employee::getDepartment,
		                Collectors.counting()
		        ));

		System.out.println("\n===== Department Wise Count =====");

		departmentCount.forEach((department, count) -> {
		    System.out.println(department + " : " + count);
		});
		
		Map<String, Double> departmentAverage =
		        employees.stream()
		        .collect(Collectors.groupingBy(
		                Employee::getDepartment,
		                Collectors.averagingDouble(Employee::getSalary)
		        ));

		System.out.println("\n===== Department Wise Average Salary =====");

		departmentAverage.forEach((department, average) -> {
		    System.out.println(department + " : " + average);
		});
		
		List<Employee> salaryRanking = employees.stream()
		        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
		        .collect(Collectors.toList());

		System.out.println("\n===== Employee Salary Ranking =====");

		int rank = 1;

		for (Employee emp : salaryRanking) {
		    System.out.println(rank + ". " + emp);
		    rank++;
		}
		
		System.out.println("\n===== Employee Analytics Summary =====");

		System.out.println("Total Employees: " + employees.size());
		System.out.println("Overall Average Salary: " + averageSalary);
		System.out.println("Highest Paid Employee: " + highestPaid.getName());
		System.out.println("Highest Salary: " + highestPaid.getSalary());
	}
}
