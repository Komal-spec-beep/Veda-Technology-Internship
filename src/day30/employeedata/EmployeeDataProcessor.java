package day30.employeedata;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDataProcessor {

    public static void main(String[] args) {

        // Creating employee data
        List<Employee> employees = Arrays.asList(

                new Employee(101, "Amit", "IT", 45000),
                new Employee(102, "Priya", "HR", 35000),
                new Employee(103, "Rahul", "IT", 55000),
                new Employee(104, "Neha", "Finance", 40000),
                new Employee(105, "Rohit", "HR", 30000),
                new Employee(106, "Anjali", "Finance", 60000),
                new Employee(107, "Karan", "IT", 50000)
        );

        // 1. Display all employees
        System.out.println("===== All Employees =====");

        employees.forEach(System.out::println);


        // 2. Filter employees with salary above 40000
        System.out.println("\n===== Employees with Salary Above 40000 =====");

        employees.stream()
                .filter(e -> e.getSalary() > 40000)
                .forEach(System.out::println);


        // 3. Sort employees by salary (highest first)
        System.out.println("\n===== Employees Sorted by Salary =====");

        employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);


        // 4. Convert employee names to uppercase using map()
        System.out.println("\n===== Employee Names in Uppercase =====");

        employees.stream()
                .map(e -> e.getName().toUpperCase())
                .forEach(System.out::println);


        // 5. Group employees by department
        System.out.println("\n===== Employees Grouped by Department =====");

        Map<String, List<Employee>> departmentGroups =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));

        departmentGroups.forEach((department, employeeList) -> {
            System.out.println("\nDepartment: " + department);

            employeeList.forEach(System.out::println);
        });


        // 6. Count employees in each department
        System.out.println("\n===== Department-wise Employee Count =====");

        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ))
                .forEach((department, count) ->
                        System.out.println(department + ": " + count));


        // 7. Calculate average salary
        System.out.println("\n===== Average Salary =====");

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        System.out.println("Average Salary: " + averageSalary);


        // 8. Calculate total salary
        System.out.println("\n===== Total Salary =====");

        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        System.out.println("Total Salary: " + totalSalary);


        // 9. Find highest paid employee
        System.out.println("\n===== Highest Paid Employee =====");

        employees.stream()
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);


        // 10. Generate employee report
        System.out.println("\n===== Employee Data Report =====");

        long totalEmployees = employees.stream().count();

        long highSalaryEmployees = employees.stream()
                .filter(e -> e.getSalary() > 40000)
                .count();

        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Employees with Salary Above 40000: "
                + highSalaryEmployees);
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Total Salary: " + totalSalary);
    }
}