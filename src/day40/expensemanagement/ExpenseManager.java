package day40.expensemanagement;

import java.util.ArrayList;
import java.time.YearMonth;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExpenseManager {

    private ArrayList<Expense> expenses;
    private ArrayList<Category> categories;
    private ArrayList<Budget> budgets;

    private static final String EXPENSE_FILE = "expenses.txt";
    private static final String BUDGET_FILE = "budgets.txt";

    public ExpenseManager() {

        expenses = new ArrayList<>();
        categories = new ArrayList<>();
        budgets = new ArrayList<>();

        categories.add(new Category(1, "Food"));
        categories.add(new Category(2, "Travel"));
        categories.add(new Category(3, "Shopping"));
        categories.add(new Category(4, "Education"));
        categories.add(new Category(5, "Bills"));
        categories.add(new Category(6, "Healthcare"));
        categories.add(new Category(7, "Other"));

        System.out.println("File Location: " + System.getProperty("user.dir"));
        loadExpenses();
        loadBudgets();
    }

    public void displayCategories() {
        for (Category category : categories) {
            System.out.println(category.getCategoryId() + ". "
                    + category.getCategoryName());
        }
    }

    public Category searchCategory(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    // Add Expense
    public void addExpense(Expense expense) {

        for (Expense existing : expenses) {
            if (existing.getExpenseId() == expense.getExpenseId()) {
                System.out.println("Expense ID already exists!");
                return;
            }
        }

        if (expense.getAmount() <= 0) {
            System.out.println("Amount must be greater than zero!");
            return;
        }

        if (expense.getCategory() == null ||
                searchCategory(expense.getCategory().getCategoryId()) == null) {
            System.out.println("Invalid Category!");
            return;
        }

        expenses.add(expense);
        saveExpenses();

        System.out.println("Expense added successfully!");
    }

    // Display Expenses
    public void displayExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found!");
            return;
        }

        for (Expense expense : expenses) {
            System.out.println("Expense ID: " + expense.getExpenseId());
            System.out.println("Title: " + expense.getTitle());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Category: "
                    + expense.getCategory().getCategoryName());
            System.out.println("Date: " + expense.getDate());
            System.out.println("---------------------------");
        }
    }

    // Search Expense
    public Expense searchExpense(int expenseId) {
        for (Expense expense : expenses) {
            if (expense.getExpenseId() == expenseId) {
                return expense;
            }
        }
        return null;
    }

    // Delete Expense
    public boolean deleteExpense(int expenseId) {

        Expense expense = searchExpense(expenseId);

        if (expense != null) {
            expenses.remove(expense);
            saveExpenses();
            return true;
        }

        return false;
    }

    // Update Expense
    public boolean updateExpense(int expenseId, String title,
            double amount, int categoryId) {

        Expense expense = searchExpense(expenseId);
        Category category = searchCategory(categoryId);

        if (expense == null || amount <= 0 || category == null
                || title == null || title.trim().isEmpty()) {
            return false;
        }

        expense.setTitle(title);
        expense.setAmount(amount);
        expense.setCategory(category);

        saveExpenses();
        return true;
    }

    // Set Monthly Budget
    public void setMonthlyBudget(double amount, YearMonth month) {

        if (amount <= 0) {
            System.out.println("Budget must be greater than zero!");
            return;
        }

        for (Budget budget : budgets) {
            if (budget.getMonth().equals(month)) {
                budget.setBudgetAmount(amount);
                saveBudgets();
                System.out.println("Budget updated successfully!");
                return;
            }
        }

        budgets.add(new Budget(amount, month));
        saveBudgets();

        System.out.println("Monthly budget set successfully!");
    }

    // Calculate Monthly Expenses
    public double calculateMonthlyExpenses(YearMonth month) {

        double total = 0;

        for (Expense expense : expenses) {
            if (YearMonth.from(expense.getDate()).equals(month)) {
                total += expense.getAmount();
            }
        }

        return total;
    }

    // Category-wise Expense Report
    public void displayCategoryWiseExpenses(YearMonth month) {

        System.out.println("\n===== CATEGORY-WISE EXPENSE REPORT =====");

        double grandTotal = 0;

        for (Category category : categories) {

            double total = 0;

            for (Expense expense : expenses) {
                if (expense.getCategory().getCategoryId()
                        == category.getCategoryId()
                        && YearMonth.from(expense.getDate()).equals(month)) {
                    total += expense.getAmount();
                }
            }

            System.out.println(category.getCategoryName() + ": " + total);
            grandTotal += total;
        }

        System.out.println("--------------------------------");
        System.out.println("Grand Total Expenses: " + grandTotal);
    }

    // Display Monthly Budget Report
    public void displayMonthlyBudget(YearMonth month) {

        Budget selectedBudget = null;

        for (Budget budget : budgets) {
            if (budget.getMonth().equals(month)) {
                selectedBudget = budget;
                break;
            }
        }

        if (selectedBudget == null) {
            System.out.println("No budget set for " + month);
            return;
        }

        double total = calculateMonthlyExpenses(month);
        double remaining = selectedBudget.getBudgetAmount() - total;

        System.out.println("\n===== MONTHLY BUDGET REPORT =====");
        System.out.println("Month: " + month);
        System.out.println("Budget: " + selectedBudget.getBudgetAmount());
        System.out.println("Total Expenses: " + total);
        System.out.println("Remaining Budget: " + remaining);

        if (remaining < 0) {
            System.out.println("Warning: Monthly budget exceeded!");
        } else {
            System.out.println("You are within your budget.");
        }
    }

    // Save Expenses to File
    private void saveExpenses() {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(EXPENSE_FILE))) {

            for (Expense expense : expenses) {

                writer.write(
                        expense.getExpenseId() + "|"
                        + expense.getTitle().replace("|", "/") + "|"
                        + expense.getAmount() + "|"
                        + expense.getCategory().getCategoryId() + "|"
                        + expense.getDate()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving expenses: " + e.getMessage());
        }
    }

    // Load Expenses from File
    private void loadExpenses() {

        try (BufferedReader reader =
                new BufferedReader(new FileReader(EXPENSE_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] data = line.split("\\|", -1);

                    int id = Integer.parseInt(data[0]);
                    String title = data[1];
                    double amount = Double.parseDouble(data[2]);
                    int categoryId = Integer.parseInt(data[3]);
                    LocalDate date = LocalDate.parse(data[4]);

                    Category category = searchCategory(categoryId);

                    if (category != null && amount > 0
                            && searchExpense(id) == null) {

                        expenses.add(new Expense(
                                id, title, amount, category, date));
                    }

                } catch (RuntimeException e) {
                    System.out.println("Skipping invalid expense record.");
                }
            }

            System.out.println("Expenses loaded successfully!");

        } catch (IOException e) {
            System.out.println("No previous expense file found. Starting fresh.");
        }
    }

    // Save Budgets to File
    private void saveBudgets() {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(BUDGET_FILE))) {

            for (Budget budget : budgets) {

                writer.write(
                        budget.getMonth() + "|"
                        + budget.getBudgetAmount()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving budgets: " + e.getMessage());
        }
    }

    // Load Budgets from File
    private void loadBudgets() {

        try (BufferedReader reader =
                new BufferedReader(new FileReader(BUDGET_FILE))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] data = line.split("\\|", -1);

                    YearMonth month = YearMonth.parse(data[0]);
                    double amount = Double.parseDouble(data[1]);

                    if (amount > 0) {
                        setBudgetFromFile(amount, month);
                    }

                } catch (RuntimeException e) {
                    System.out.println("Skipping invalid budget record.");
                }
            }

            System.out.println("Budgets loaded successfully!");

        } catch (IOException e) {
            System.out.println("No previous budget file found. Starting fresh.");
        }
    }

    // Add loaded budget without saving again
    private void setBudgetFromFile(double amount, YearMonth month) {

        for (Budget budget : budgets) {
            if (budget.getMonth().equals(month)) {
                budget.setBudgetAmount(amount);
                return;
            }
        }

        budgets.add(new Budget(amount, month));
    }
}