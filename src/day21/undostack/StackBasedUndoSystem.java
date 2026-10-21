package day21.undostack;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class StackBasedUndoSystem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Deque<String> undoStack = new ArrayDeque<>();
		String currentText = "";
		
		System.out.println("======= Stack-Based Undo System =======");
		System.out.println("Text editor started!");
		
		while (true) {
		    System.out.println("\n1. Edit Text");
		    System.out.println("2. Undo");
		    System.out.println("3. Exit");
		    System.out.print("Choose an option: ");

		    int choice = sc.nextInt();
		    sc.nextLine();

		    switch (choice) {
		    case 1:
		        undoStack.push(currentText);

		        System.out.print("Enter new text: ");
		        currentText = sc.nextLine();

		        System.out.println("Current Text: " + currentText);
		        break;

		    case 2:
		        if (!undoStack.isEmpty()) {
		            currentText = undoStack.pop();
		            System.out.println("After Undo: " + currentText);
		        } else {
		            System.out.println("Nothing to undo!");
		        }
		        break;

		        case 3:
		            System.out.println("Exiting program...");
		            sc.close();
		            return;

		        default:
		            System.out.println("Invalid choice!");
		    }
		}
	}
}
