package day12.employeehierarchy;

public class Developer extends Employee{
	
	public Developer (int employeeId, String employeeName, double salary) {
		super(employeeId, employeeName, salary);
	}
	
	public void work() {
		System.out.println("Developer is writing code.");
	}
}
