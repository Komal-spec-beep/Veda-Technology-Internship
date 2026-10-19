package day19.emailregistry;

import java.util.Scanner;
import java.util.HashSet;

public class EmailRegistry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<String> emails = new HashSet<>();
		
		int choice;

		do {
		    System.out.println("\n===== Unique Email Registry =====");
		    System.out.println("1. Add Email");
		    System.out.println("2. Remove Email");
		    System.out.println("3. Display All Emails");
		    System.out.println("4. Exit");

		    System.out.print("Enter your choice: ");
		    choice = sc.nextInt();
		    sc.nextLine();

		    switch (choice) {
		    case 1: {
		        System.out.print("Enter email address: ");
		        String email = sc.nextLine()
		                         .trim()
		                         .replace(" ", "")
		                         .toLowerCase();

		        if (emails.add(email)) {
		            System.out.println("Email registered successfully!");
		        } else {
		            System.out.println("Email already registered!");
		        }

		        break;
		    }

		    case 2: {
		        System.out.print("Enter email to remove: ");
		        String removeEmail = sc.nextLine()
		                               .trim()
		                               .replace(" ", "")
		                               .toLowerCase();

		        if (emails.remove(removeEmail)) {
		            System.out.println("Email removed successfully!");
		        } else {
		            System.out.println("Email not found!");
		        }

		        break;
		    }

		    case 3: {
		        if (emails.isEmpty()) {
		            System.out.println("No emails registered.");
		        } else {
		            System.out.println("Registered Email List:");

		            for (String registeredEmail : emails) {
		                System.out.println(registeredEmail);
		            }
		        }

		        break;
		    }

		        case 4:
		            System.out.println("Exiting Email Registry...");
		            break;

		        default:
		            System.out.println("Invalid choice! Enter 1 to 4.");
		    }

		} while (choice != 4);

		sc.close();
	}
}
