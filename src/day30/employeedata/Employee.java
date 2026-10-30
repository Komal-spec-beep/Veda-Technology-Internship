package day30.employeedata;

public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Display employee details
    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Department: " + department +
                ", Salary: " + salary;
    }
}