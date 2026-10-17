package day16.librarymanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> bookList = new ArrayList<>();
        ArrayList<Member> memberList = new ArrayList<>();

        bookList.add(new Book(101, "Java Basics", "Ram", true));
        bookList.add(new Book(102, "C Programming", "Shyam", true));

        memberList.add(new Member(1, "Komal", "0987654321"));

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book");
            System.out.println("3. Add Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Calculate Overdue");
            System.out.println("7. Display Members");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    for (Book b : bookList) {
                        System.out.println("\nBook ID: " + b.bookID);
                        System.out.println("Book Name: " + b.bookName);
                        System.out.println("Author: " + b.authorName);
                        System.out.println("Available: " + b.isBookAvailable);
                    }
                    break;

                case 2:
                    System.out.print("Enter Book ID to search: ");
                    int searchID = sc.nextInt();

                    boolean found = false;

                    for (Book b : bookList) {
                        if (b.bookID == searchID) {
                            System.out.println("Book Found!");
                            System.out.println("Book Name: " + b.bookName);
                            System.out.println("Author: " + b.authorName);
                            System.out.println("Available: " + b.isBookAvailable);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int newID = sc.nextInt();
                    sc.nextLine();

                    boolean duplicate = false;

                    for (Book b : bookList) {
                        if (b.bookID == newID) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (duplicate) {
                        System.out.println("Book ID already exists!");
                        break;
                    }

                    System.out.print("Enter Book Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String newAuthor = sc.nextLine();

                    bookList.add(new Book(newID, newName, newAuthor, true));

                    System.out.println("Book added successfully!");
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    int issueID = sc.nextInt();

                    boolean issued = false;

                    for (Book b : bookList) {
                        if (b.bookID == issueID && b.isBookAvailable) {
                            b.isBookAvailable = false;
                            System.out.println("Book issued: " + b.bookName);
                            issued = true;
                            break;
                        }
                    }

                    if (!issued) {
                        System.out.println("Book not available or invalid ID!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnID = sc.nextInt();

                    boolean returned = false;

                    for (Book b : bookList) {
                        if (b.bookID == returnID && !b.isBookAvailable) {
                            b.isBookAvailable = true;
                            System.out.println("Book returned: " + b.bookName);
                            returned = true;
                            break;
                        }
                    }

                    if (!returned) {
                        System.out.println("Book is not issued or invalid ID!");
                    }
                    break;

                case 6:
                    System.out.print("Enter days since book was issued: ");
                    int days = sc.nextInt();

                    int overdueDays = days - 14;

                    if (overdueDays > 0) {
                        System.out.println("Overdue by " + overdueDays + " days.");
                    } else if (days >= 0) {
                        System.out.println("Book is not overdue.");
                    } else {
                        System.out.println("Invalid number of days!");
                    }
                    break;

                case 7:
                    for (Member m : memberList) {
                        System.out.println("\nMember ID: " + m.memberID);
                        System.out.println("Member Name: " + m.memberName);
                        System.out.println("Contact: " + m.contactNumber);
                    }
                    break;

                case 8:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-8.");
            }

        } while (choice != 8);

        sc.close();
    }
}
