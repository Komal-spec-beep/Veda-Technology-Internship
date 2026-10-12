package day12.employeehierarchy;

public class Manager extends Employee{
	
	public Manager(int employeeId, String employeeName, double salary) {
		super(employeeId, employeeName, salary);
	}
	
	public void work() {
		System.out.println("Manager is managing the team.");
	}
}
