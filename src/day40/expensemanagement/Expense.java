package day40.expensemanagement;

import java.time.LocalDate;

public class Expense {

    private int expenseId;
    private String title;
    private double amount;
    private Category category;
    private LocalDate date;

    // Constructor
    public Expense(int expenseId, String title, double amount,
    		Category  category, LocalDate date) {

        this.expenseId = expenseId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // Getters
    public int getExpenseId() {
        return expenseId;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public Category  getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(Category  category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}