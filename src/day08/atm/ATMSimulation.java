package day08.atm;

import java.util.Scanner;

public class ATMSimulation {
	
	static double balance = 5000.0;
	static final int PIN = 1234;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//PIN Authentication
		int attempts = 0;
		boolean authenticated = false;
		
		while (attempts < 3) {
			
			System.out.print("Enter your PIN: ");
			int enteredPin = sc.nextInt();
			
			if (enteredPin == PIN) {
				authenticated = true;
				System.out.println("PIN verified successfully!");
				break;
			} else {
				attempts++;
				System.out.println("Incorrect PIN!");
				
				if (attempts <3) {
					System.out.println("Attempts remaining: " + (3 - attempts));
				}
			}
		}
		
		if (!authenticated) {
			System.out.println("Too many incorrect attempts. Account locked.");
			
			sc.close();
			
			return;
		}
		
		//ATM Menu
		while (true) {
			
			System.out.println("\n============= ATM MENU =============");
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			
			case 1: 
				checkBalance();
				break;
				
			case 2: 
				System.out.print("Enter deposit amount: ");
				double depositAmount = sc.nextDouble();
				deposit(depositAmount);
				break;
				
			case 3: 
				System.out.print("Enter withdrawal amount: ");
			    double withdrawalAmount = sc.nextDouble();
			    withdraw(withdrawalAmount);
			    break;
			
			case 4:
				System.out.println("Thank you for using the ATM!");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid choice! Please select 1-4.");
			}
		}
	}
	
	public static void checkBalance() {
		System.out.println("Current Balance: ₹" + balance);
	}
	
	public static void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount!");
		} else {
			balance += amount;
			System.out.println("Deposit successful!");
			System.out.println("Update Balance: ₹" + balance);
		}
	}
	
	public static void withdraw(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid withdrawal amount!");
		} else if(amount > balance) {
			System.out.println("Insufficient balance!");
		} else {
			balance -= amount;
			System.out.println("Withdrawal successful!");
			System.out.println("Remaining Balance: ₹" + balance);
		}
	}
}
