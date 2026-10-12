package day12.employeehierarchy;

public class Main {
	
	public static void main(String[] args) {
		//Developer's detail
		Developer employeeId = new Developer(101, "Komal", 25000);
		
		employeeId.work();
		
		System.out.println(employeeId.getEmployeeId());
		System.out.println(employeeId.getEmployeeName());
		System.out.println(employeeId.getSalary());
		
		//Manager's Detail
		Manager manager = new Manager(102, "Priya", 30000);
		manager.work();
		System.out.println(manager.getEmployeeId());
		System.out.println(manager.getEmployeeName());
		System.out.println(manager.getSalary());
		
		//Intern's Detail
		Intern intern = new Intern(103, "Nandini", 35000);
		intern.work();
		
		System.out.println(intern.getEmployeeId());
		System.out.println(intern.getEmployeeName());
		System.out.println(intern.getSalary());
			
		
	}
}
