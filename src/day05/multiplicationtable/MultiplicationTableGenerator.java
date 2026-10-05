package day05.multiplicationtable;

import java.util.Scanner;

public class MultiplicationTableGenerator {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Single Table");
		System.out.println("2. Table Range");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		
		if (choice == 1) {
			
			System.out.print("Enter a number: ");
			int number = sc.nextInt();
			generateTable(number);
		} else if(choice == 2) {
			
			System.out.print("Enter starting number: ");
			int start = sc.nextInt();

			System.out.print("Enter ending number: ");
			int end = sc.nextInt();
			
			rangeTable(start, end);
		} else {
			System.out.println("Invalid choice!");
		}
		
		sc.close();
	
	}
	
	public static void rangeTable(int start, int end) {
		
		for (int number = start; number <= end; number++) {
			
			System.out.println("----- Table of " + number + " -----");
			
		    generateTable(number);
		    
		    System.out.println();
		    
		}
	}
	
	public static void generateTable(int number) {
		
		for (int i = 1; i <= 10; i++) {
			
			System.out.println(number + " x " + i + " = " + (number*i));
			
		}
	}
}
