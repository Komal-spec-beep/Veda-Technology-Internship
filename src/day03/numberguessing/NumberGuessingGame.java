package day03.numberguessing;

import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int targetNumber = random.nextInt(100) + 1;
		int attempts = 1;
		
		System.out.print("Guess the number (1-100): ");
		int guess = sc.nextInt();
		
		while (guess < 1 || guess > 100) {
			System.out.println("Invalid guess! Please enter a number between 1 and 100.");
			System.out.print("Enter your guess: ");
			guess = sc.nextInt();
		}
		
		while (guess != targetNumber) {
			if (guess < targetNumber) {
				System.out.println("Too low! Try again.");
			} else {
				System.out.println("Too high! Try again.");
			}
			
			System.out.print("Enter your guess again: ");
			guess = sc.nextInt();
			while (guess < 1 || guess > 100) {
				System.out.println("Invalid guess! Please enter a number between 1 and 100.");
				System.out.print("Enter your guess: ");
				guess = sc.nextInt();
			}
			attempts++;
		}
		
		System.out.println("============================== ");
		System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
		
		sc.close();
	}
}
