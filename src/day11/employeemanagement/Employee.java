package day11.employeemanagement;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private double salary;
	
	public Employee(int employeeId, String employeeName, double salary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public double getSalary() {
	    return salary;
	}
	
	public void setSalary(double salary) {
	    
	    if ( salary > 0 ) {
	    	this.salary = salary;
	    } else {
	    	System.out.println("Invalid Salary!");
	    }
	}
}
