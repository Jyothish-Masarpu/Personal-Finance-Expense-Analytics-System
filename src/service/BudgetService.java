package service;

public class BudgetService {

    private double budget;

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public double getRemainingBudget(double totalExpense) {
        return budget - totalExpense;
    }
}