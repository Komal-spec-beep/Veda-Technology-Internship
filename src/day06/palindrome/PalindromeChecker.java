package day06.palindrome;

import java.util.Scanner;

public class PalindromeChecker {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String text = sc.nextLine();
		
		text = text.toLowerCase();
		StringBuilder reversed = new StringBuilder(text);
		reversed.reverse();
		
		if (text.equals(reversed.toString())) {
			System.out.println("The string is a palindrome.");
		} else {
			System.out.println("The string is not a palindrome.");
		}
		
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		
		int originalNumber = number;
		int reversedNumber = 0;
		
		while (number != 0) {
			int digit = number % 10;
			reversedNumber = reversedNumber * 10 + digit;
			number = number / 10;
		}
		
		if (originalNumber == reversedNumber) {
			System.out.println("The number is a palindrome.");
		} else {
			System.out.println("The number is not a palindrome.");
		}
		sc.close();
	}
}
