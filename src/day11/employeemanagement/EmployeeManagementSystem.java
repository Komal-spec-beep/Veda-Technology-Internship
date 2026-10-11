
package day11.employeemanagement;

import java.util.Scanner;

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee[] employees = new Employee[5];

        employees[0] = new Employee(101, "Komal", 25000);
        employees[1] = new Employee(102, "Rahul", 30000);
        employees[2] = new Employee(103, "Priya", 28000);
        employees[3] = new Employee(104, "Aman", 32000);

        int choice;

        do {
            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Display All Employees");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee Salary");
            System.out.println("4. Add Employee");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    boolean hasEmployees = false;

                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] != null) {
                            System.out.println("ID: "
                                    + employees[i].getEmployeeId());
                            System.out.println("Name: "
                                    + employees[i].getEmployeeName());
                            System.out.println("Salary: "
                                    + employees[i].getSalary());
                            System.out.println("----------------");

                            hasEmployees = true;
                        }
                    }

                    if (!hasEmployees) {
                        System.out.println("No employees available.");
                    }
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] != null
                                && employees[i].getEmployeeId() == searchId) {

                            System.out.println("Employee Found!");
                            System.out.println("ID: "
                                    + employees[i].getEmployeeId());
                            System.out.println("Name: "
                                    + employees[i].getEmployeeName());
                            System.out.println("Salary: "
                                    + employees[i].getSalary());

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();

                    boolean employeeFound = false;

                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] != null
                                && employees[i].getEmployeeId() == updateId) {

                            employeeFound = true;

                            System.out.print("Enter New Salary: ");
                            double newSalary = sc.nextDouble();

                            if (newSalary > 0) {
                                employees[i].setSalary(newSalary);

                                System.out.println("Salary Updated Successfully!");
                                System.out.println("New Salary: "
                                        + employees[i].getSalary());
                            } else {
                                System.out.println("Invalid Salary!");
                            }

                            break;
                        }
                    }

                    if (!employeeFound) {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 4:
                    int id;
                    String name;
                    double salary;

                    System.out.print("Enter Employee ID: ");
                    id = sc.nextInt();

                    boolean duplicateId = false;

                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] != null
                                && employees[i].getEmployeeId() == id) {
                            duplicateId = true;
                            break;
                        }
                    }

                    if (duplicateId) {
                        System.out.println("Employee ID already exists!");
                        break;
                    }

                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    salary = sc.nextDouble();

                    if (salary <= 0) {
                        System.out.println("Invalid Salary!");
                        break;
                    }

                    boolean added = false;

                    for (int i = 0; i < employees.length; i++) {
                        if (employees[i] == null) {
                            employees[i] = new Employee(id, name, salary);
                            System.out.println("Employee Added Successfully!");
                            added = true;
                            break;
                        }
                    }

                    if (!added) {
                        System.out.println("No space available for another employee!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Employee Management System...");
                    break;

                default:
                    System.out.println("Invalid Choice! Please select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
