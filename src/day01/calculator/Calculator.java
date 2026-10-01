package day01.calculator;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter first number: ");
		if (!sc.hasNextDouble()) {
			System.out.println("Invalid input! Please enter a number.");
			return;
		}
		double num1 = sc.nextDouble();
		
		System.out.print("Enter second number: ");
		if (!sc.hasNextDouble()) {
			System.out.println("Invalid input! Please enter a number.");
			return;
		}
		double num2 = sc.nextDouble();
		
		System.out.print("Enter operation (+, -, *, /, %): ");
		char operator = sc.next().charAt(0);
		
		switch (operator) {
		case '+':
			System.out.print("Result: " + add(num1, num2));
			break;
			
		case '-':
			System.out.print("Result: " + subtract(num1, num2));
			break;
			
		case '*':
			System.out.print("Result: " + multiply(num1, num2));
			break;
			
		case '/':
			if(num2 == 0) {
				System.out.print("Error: Cannot divided by zero!");
			} else {
				System.out.print("Result: " + divide(num1, num2));
			}
			break;
			
		case '%':
			if (num2 == 0) {
				System.out.print("Error: Cannot find modulus with zero!");
			} else {
				System.out.print("Result: " + modulus(num1, num2));
			}
			break;	
			
		default:
			System.out.print("Invalid operator!");
		}
		sc.close();
	}
	
	public static double add(double a, double b) {
		return a + b;
	}
	public static double subtract(double a, double b) {
		return a - b;
	}
	public static double multiply(double a, double b) {
		return a * b;
	}
	public static double divide(double a, double b) {
		return a / b;
	}
	public static double modulus(double a, double b) {
		return a % b;
	}
}
