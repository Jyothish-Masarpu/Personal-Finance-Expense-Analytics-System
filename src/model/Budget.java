package model;

public class Budget {

    private double monthlyBudget;

    public Budget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "monthlyBudget=" + monthlyBudget +
                '}';
    }
}