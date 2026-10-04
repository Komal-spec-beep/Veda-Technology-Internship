package day04.studentmanagement;

import java.util.Scanner;

public class StudentManagementSystem {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] studentNames = new String[5];
		int[] studentIds = new int[5];
		int studentCount = 0;
		
		while(true) {
			System.out.println("\n========== Student Management System ==========");
			System.out.println("1. Add Student");
			System.out.println("2. Search Student");
			System.out.println("3. Update Student");
			System.out.println("4. Display All Students");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				studentCount = addStudent(sc, studentNames, studentIds, studentCount);
				break;
				
			case 2:
				searchStudent(sc, studentNames, studentIds, studentCount);
				break;
				
			case 3:
				updateStudent(sc, studentNames, studentIds, studentCount);
				break;
				
			case 4:
			    displayStudents(studentNames, studentIds, studentCount);
			    break;
				
			case 5: 
				System.out.println("5. Exiting...");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice!");
			}
		}
	}
	public static int addStudent(Scanner sc, String[] studentNames, int[] studentIds, int studentCount) {
		
		if (studentCount >= studentNames.length) {
		    System.out.println("Student limit reached!");
		    return studentCount;
		}
		
		System.out.print("Enter student ID: ");
		int id = sc.nextInt();
		
		System.out.print("Enter student name: ");
		String name = sc.next();
		
		studentIds[studentCount] = id;
		studentNames[studentCount] = name;
		studentCount++;
		
		System.out.println("Student added successfully!");
		
		return studentCount;
	}
	public static void searchStudent(Scanner sc, String[] studentNames, int[] studentIds, int studentCount) {
		System.out.print("Enter student ID to search: ");
		int searchId = sc.nextInt();
		
		boolean found = false;
		
		for(int i = 0; i < studentCount; i++) {
			if (studentIds[i] == searchId) {
				System.out.println("Student ID: " + studentIds[i]);
				System.out.println("Student Name: " + studentNames[i]);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Student not found!");
		}
	}
	public static void updateStudent(Scanner sc, String[] studentNames, int[] studentIds, int studentCount) {
		System.out.print("Enter student ID to update: ");
	    int updateId = sc.nextInt();

	    boolean updated = false;

	    for (int i = 0; i < studentCount; i++) {
	        if (studentIds[i] == updateId) {

	            System.out.print("Enter new student name: ");
	            studentNames[i] = sc.next();

	            updated = true;
	            System.out.println("Student updated successfully!");
	            break;
	        }
	    }

	    if (!updated) {
	        System.out.println("Student not found!");
	    }
	}
	public static void displayStudents(String[] studentNames, int[] studentIds, int studentCount) {

	    if (studentCount == 0) {
	        System.out.println("No students available!");
	    } else {
	        System.out.println("\n----- All Students -----");

	        for (int i = 0; i < studentCount; i++) {
	            System.out.println("Student ID: " + studentIds[i]);
	            System.out.println("Student Name: " + studentNames[i]);
	            System.out.println("------------------------");
	        }
	    }
	}

}
