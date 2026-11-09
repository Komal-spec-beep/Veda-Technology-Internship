package day40.expensemanagement;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        int choice;

        do {
            System.out.println("\n===== PERSONAL EXPENSE MANAGEMENT =====");
            System.out.println("1. Add Expense");
            System.out.println("2. Display Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Display Categories");
            System.out.println("7. Set Monthly Budget");
            System.out.println("8. Display Monthly Budget Report");
            System.out.println("9. Category-wise Expense Report");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Expense ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Select Category:");
                    manager.displayCategories();

                    System.out.print("Enter Category ID: ");
                    int categoryId = sc.nextInt();
                    sc.nextLine();

                    Category category = manager.searchCategory(categoryId);

                    System.out.print("Enter Date (Date Month Year): ");
                    String dateInput = sc.nextLine();

                    LocalDate date = LocalDate.parse(
                            dateInput,
                            DateTimeFormatter.ofPattern(
                                    "d MMMM yyyy", Locale.ENGLISH));

                    Expense expense = new Expense(
                            id, title, amount, category, date);

                    manager.addExpense(expense);
                    break;

                case 2:
                    manager.displayExpenses();
                    break;

                case 3:
                    System.out.print("Enter Expense ID: ");
                    int searchId = sc.nextInt();

                    Expense found = manager.searchExpense(searchId);

                    if (found != null) {
                        System.out.println("Expense Found!");
                        System.out.println("Title: " + found.getTitle());
                        System.out.println("Amount: " + found.getAmount());
                        System.out.println("Category: "
                                + found.getCategory().getCategoryName());
                        System.out.println("Date: " + found.getDate());
                    } else {
                        System.out.println("Expense not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Expense ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    manager.displayCategories();

                    System.out.print("Enter New Category ID: ");
                    int newCategoryId = sc.nextInt();

                    boolean updated = manager.updateExpense(
                            updateId, newTitle, newAmount, newCategoryId);

                    System.out.println(updated
                            ? "Expense updated successfully!"
                            : "Invalid Expense ID or details!");
                    break;

                case 5:
                    System.out.print("Enter Expense ID: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = manager.deleteExpense(deleteId);

                    System.out.println(deleted
                            ? "Expense deleted successfully!"
                            : "Expense not found!");
                    break;

                case 6:
                    manager.displayCategories();
                    break;

                case 7:
                    System.out.print("Enter Budget Month (YYYY-MM): ");
                    YearMonth budgetMonth =
                            YearMonth.parse(sc.nextLine());

                    System.out.print("Enter Monthly Budget Amount: ");
                    double budgetAmount = sc.nextDouble();
                    sc.nextLine();

                    manager.setMonthlyBudget(budgetAmount, budgetMonth);
                    break;

                case 8:
                    System.out.print("Enter Month (YYYY-MM): ");
                    YearMonth reportMonth =
                            YearMonth.parse(sc.nextLine());

                    manager.displayMonthlyBudget(reportMonth);
                    break;
                    
                case 9:
                    System.out.print("Enter Month (YYYY-MM): ");
                    YearMonth categoryReportMonth = YearMonth.parse(sc.nextLine());

                    manager.displayCategoryWiseExpenses(categoryReportMonth);
                    break;

                case 10:
                    System.out.println("Thank you for using Expense Manager!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}