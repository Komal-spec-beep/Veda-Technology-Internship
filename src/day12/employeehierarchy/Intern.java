package day12.employeehierarchy;

public class Intern extends Employee{
	
	public Intern(int employeeId, String employeeName, double salary) {
		super(employeeId, employeeName, salary);
	}
	
	public void work() {
		System.out.println("Intern is learning.");
	}
}
