package day09.bankingaccount;

public class BankAccount {
	
	private int accountNumber;
	private String holderName;
	private double balance;
	
	
	public BankAccount(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit successful!");
		} else {
			System.out.println("Invalid deposit amount!");
		}
	}
	
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal successful!");
		} else {
			System.out.println("Invalid amount or insufficient balance!");
		}
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public static void main(String[] args) {
		
		BankAccount account1 = new BankAccount(12345, "Komal", 5000.0);
		
		System.out.println("Account Number: " + account1.getAccountNumber());
		System.out.println("Holder Name: " + account1.getHolderName());
		
		System.out.println("Balance = " + account1.getBalance());
		
		account1.deposit(500);
		account1.deposit(-500);
		System.out.println("Updated Balance = " + account1.getBalance());
		
		account1.withdraw(1000);
		account1.withdraw(6000);
		System.out.println("Balance after withdrawal = " + account1.getBalance());
	}
}
