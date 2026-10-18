package day18.employeelookup;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeLookupSystem {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, String> employees = new HashMap<>();
		
		employees.put(101, "Rahul");
		employees.put(102, "Priya");
		employees.put(103, "Amit");
		
		System.out.println("Employee Records: " + employees);
		
		int choice;

		do {
		    System.out.println("\n===== Employee Lookup System =====");
		    System.out.println("1. Add Employee");
		    System.out.println("2. Search Employee");
		    System.out.println("3. Update Employee");
		    System.out.println("4. Delete Employee");
		    System.out.println("5. Display All Employees");
		    System.out.println("6. Exit");

		    System.out.print("Enter your choice: ");
		    choice = sc.nextInt();

		    switch (choice) {
		        case 1:{
		        	System.out.print("Enter Employee ID: ");
		    		int id = sc.nextInt();

		    		sc.nextLine();

		    		System.out.print("Enter Employee Name: ");
		    		String name = sc.nextLine();

		    		if (employees.containsKey(id)) {
		    		    System.out.println("Employee ID already exists!");
		    		} else {
		    		    employees.put(id, name);
		    		    System.out.println("Employee added successfully!");
		    		}
		            break;
		        }

		        case 2:{
		        	System.out.print("Enter employee ID to search: ");
		    		int searchID = sc.nextInt();
		    		
		    		if (employees.containsKey(searchID)) {
		    			System.out.println("Employee Name: " + employees.get(searchID));
		    		} else {
		    			System.out.println("Employee not found!");
		    		}
		            break;
		        }

		        case 3:{
		        	System.out.print("Enter Employee ID to update: ");
		    		int updateID = sc.nextInt();
		    		
		    		sc.nextLine();
		    		
		    		if (employees.containsKey(updateID)) {
		    			System.out.print("Enter new employee name: ");
		    			String newName = sc.nextLine();
		    			
		    			employees.put(updateID, newName);
		    			
		    			System.out.println("Employee updated successfully!");
		    		} else {
		    			System.out.println("Employee not found!");
		    		}
		            break;
		        }

		        case 4:{
		        	System.out.print("Enter Employee to delete: ");
		    		int deleteID = sc.nextInt();
		    		
		    		if (employees.containsKey(deleteID)) {
		    			employees.remove(deleteID);
		    			System.out.println("Employee deleted successfully!");
		    		} else {
		    			System.out.println("Employee not found!");
		    		}
		            break;
		        }

		        case 5:
		            System.out.println("Employee Records: " + employees);
		            break;

		        case 6:
		            System.out.println("Exiting Employee Lookup System...");
		            break;

		        default:
		            System.out.println("Invalid choice! Please enter 1 to 6.");
		    }

		} while (choice != 6);

		sc.close();
		
	}

}
