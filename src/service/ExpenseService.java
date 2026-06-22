package service;

import enums.Category;
import model.Expense;
import repository.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseService {

    private Repository<Expense> repository =
            new Repository<>();

    public void addExpense(Expense expense) {
        repository.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public boolean deleteExpense(int id) {

        List<Expense> expenses = repository.findAll();

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                repository.remove(expense);

                return true;
            }
        }

        return false;
    }

    public void searchByCategory(String categoryName) {

        List<Expense> expenses = repository.findAll();

        boolean found = false;

        for (Expense expense : expenses) {

            if (expense.getCategory().name()
                    .equalsIgnoreCase(categoryName)) {

                System.out.println(expense);

                found = true;
            }
        }

        if (!found) {
            System.out.println("No Expenses Found");
        }
    }

    public double getTotalExpense() {

        double total = 0;

        for (Expense expense : repository.findAll()) {

            total += expense.getAmount();
        }

        return total;
    }

    public Expense getHighestExpense() {

        List<Expense> expenses = repository.findAll();

        if (expenses.isEmpty()) {
            return null;
        }

        Expense highest = expenses.get(0);

        for (Expense expense : expenses) {

            if (expense.getAmount() >
                    highest.getAmount()) {

                highest = expense;
            }
        }

        return highest;
    }

    public void searchByAmountRange(
            double min,
            double max) {

        boolean found = false;

        for (Expense expense :
                repository.findAll()) {

            if (expense.getAmount() >= min &&
                    expense.getAmount() <= max) {

                System.out.println(expense);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No Expenses Found");
        }
    }

    public void categoryWiseSpending() {

        Map<String, Double> map =
                new HashMap<>();

        for (Expense expense :
                repository.findAll()) {

            String category =
                    expense.getCategory().name();

            map.put(
                    category,
                    map.getOrDefault(
                            category,
                            0.0
                    ) + expense.getAmount()
            );
        }

        System.out.println(
                "\nCategory Wise Spending");

        for (Map.Entry<String, Double>
                entry : map.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + " -> ₹"
                            + entry.getValue()
            );
        }
    }

    public void categoryAnalyticsStream() {

        Map<Category, Double> result =

                repository.findAll()
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Expense::getCategory,
                                        Collectors.summingDouble(
                                                Expense::getAmount
                                        )
                                )
                        );

        System.out.println(
                "\nStream Analytics");

        result.forEach(
                (category, amount)
                        -> System.out.println(
                        category
                                + " -> ₹"
                                + amount
                )
        );
    }
}