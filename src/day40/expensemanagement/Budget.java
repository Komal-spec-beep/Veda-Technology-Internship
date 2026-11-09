package day40.expensemanagement;

import java.time.YearMonth;

public class Budget {

    private double budgetAmount;
    private YearMonth month;

    public Budget(double budgetAmount, YearMonth month) {
        this.budgetAmount = budgetAmount;
        this.month = month;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public YearMonth getMonth() {
        return month;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public void setMonth(YearMonth month) {
        this.month = month;
    }
}