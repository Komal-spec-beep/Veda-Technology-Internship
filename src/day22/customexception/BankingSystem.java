package day22.customexception;

import java.util.Scanner;

public class BankingSystem {

	static double balance = 1000.0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		
		while (true) {
			System.out.println("======= Banking System =======");
			System.out.println("Current Balance: ₹" + balance);
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			if (!sc.hasNextInt()) {
			    System.out.println("Please enter a valid number!");
			    sc.next();
			    continue;
			}

			int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.print("Enter deposit amount: ");

			if (!sc.hasNextDouble()) {
			    System.out.println("Please enter a valid amount!");
			    sc.next();
			    break;
			}


			double depositAmount = sc.nextDouble();

			if (depositAmount <= 0) {
				deposit(depositAmount);
				break;
			}

			deposit(depositAmount);
			System.out.println("Amount deposited successfully!");
			System.out.println("Current Balance: ₹" + balance);
			break;


		case 2:
			System.out.print("Enter withdrawal amount: ");

			if (!sc.hasNextDouble()) {
			    System.out.println("Please enter a valid amount!");
			    sc.next();
			    break;
			}

			double withdrawAmount = sc.nextDouble();
			if (withdrawAmount <= 0) {
				System.out.println("Invalid withdraw amount!");
			    break;
			}

		    try {
		        withdraw(withdrawAmount);
		        System.out.println("Amount withdrawn successfully!");
		        System.out.println("Current Balance: ₹" + balance);
		    } catch (InsufficientBalanceException e) {
		        System.out.println("Error: " + e.getMessage());
		    }
		    break;

		case 3:
		    System.out.println("Current Balance: ₹" + balance);
		    break;

		case 4:
		    System.out.println("Exiting Banking System...");
		    sc.close();
		    return;

	    default:
	        System.out.println("Invalid choice!");
		}
	  }
	}
	
	static void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount!");
			return;
		}
		balance = balance + amount;
	}
	
	static void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			System.out.println("Invalid withdraw amount!");
			return;
		}
		if (amount > balance) {
			throw new InsufficientBalanceException("Insufficient balance!");
		}
		balance = balance - amount;
	}
}
