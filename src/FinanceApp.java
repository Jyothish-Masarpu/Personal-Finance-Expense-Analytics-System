import util.FileUtil;
import enums.Category;
import enums.PaymentMode;
import model.Expense;
import model.Income;
import service.BudgetService;
import service.ExpenseService;
import service.IncomeService;

import java.time.LocalDate;
import java.util.Scanner;

public class FinanceApp {

    public static void main(String[] args) {

        ExpenseService service = new ExpenseService();
        BudgetService budgetService = new BudgetService();
        IncomeService incomeService = new IncomeService();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Finance System =====");

            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Search By Category");
            System.out.println("5. Total Expense");
            System.out.println("6. Highest Expense");
            System.out.println("7. Search By Amount Range");
            System.out.println("8. Category Analytics");
            System.out.println("9. Stream Analytics");
            System.out.println("10. Set Budget");
            System.out.println("11. View Budget Status");
            System.out.println("12. Add Income");
            System.out.println("13. View Income");
            System.out.println("14. Total Income");
            System.out.println("15. Savings Report");
            System.out.println("16. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    double amount = 0;

                    while (true) {

                        try {

                            System.out.print("Enter Amount: ");

                            amount = sc.nextDouble();

                            if (amount <= 0) {
                                throw new Exception(
                                        "Amount must be greater than 0"
                                );
                            }

                            break;

                        } catch (Exception e) {

                            System.out.println(
                                    e.getMessage()
                            );

                            sc.nextLine();
                        }
                    }

                    sc.nextLine();

                    System.out.print("Enter Description: ");
                    String description = sc.nextLine();

                    System.out.println("Categories:");

                    for (Category c : Category.values()) {
                        System.out.println(c);
                    }

                    Category category = null;

                    while (category == null) {

                        try {

                            System.out.print("Enter Category: ");

                            category =
                                    Category.valueOf(
                                            sc.next().toUpperCase()
                                    );

                        } catch (IllegalArgumentException e) {

                            System.out.println(
                                    "Invalid Category! Try Again."
                            );
                        }
                    }

                    System.out.println("Payment Modes:");

                    for (PaymentMode p : PaymentMode.values()) {
                        System.out.println(p);
                    }

                    PaymentMode paymentMode = null;

                    while (paymentMode == null) {

                        try {

                            System.out.print(
                                    "Enter Payment Mode: ");

                            paymentMode =
                                    PaymentMode.valueOf(
                                            sc.next().toUpperCase()
                                    );

                        } catch (IllegalArgumentException e) {

                            System.out.println(
                                    "Invalid Payment Mode! Try Again."
                            );
                        }
                    }

                    Expense expense =
                            new Expense(
                                    id,
                                    amount,
                                    category,
                                    description,
                                    LocalDate.now(),
                                    paymentMode
                            );

                    service.addExpense(expense);

                    FileUtil.saveExpense(
                            expense.toString()
                    );

                    System.out.println("Expense Added!");

                    break;

                case 2:

                    System.out.println("\nAll Expenses:");

                    for (Expense e :
                            service.getAllExpenses()) {

                        System.out.println(e);
                    }

                    break;

                case 3:

                    System.out.print("Enter ID to Delete: ");

                    int deleteId = sc.nextInt();

                    boolean deleted =
                            service.deleteExpense(deleteId);

                    if (deleted)
                        System.out.println("Deleted Successfully");
                    else
                        System.out.println("Expense Not Found");

                    break;

                case 4:

                    System.out.print("Enter Category: ");

                    String categoryName = sc.next();

                    service.searchByCategory(categoryName);

                    break;

                case 5:

                    System.out.println(
                            "Total Expense = ₹"
                                    + service.getTotalExpense());

                    break;

                case 6:

                    Expense highest =
                            service.getHighestExpense();

                    if (highest != null)
                        System.out.println(highest);
                    else
                        System.out.println("No Expenses Found");

                    break;

                case 7:

                    System.out.print("Enter Min Amount: ");

                    double min = sc.nextDouble();

                    System.out.print("Enter Max Amount: ");

                    double max = sc.nextDouble();

                    service.searchByAmountRange(min, max);

                    break;

                case 8:

                    service.categoryWiseSpending();

                    break;

                case 9:

                    service.categoryAnalyticsStream();

                    break;

                case 10:

                    System.out.print(
                            "Enter Monthly Budget: ");

                    double budget =
                            sc.nextDouble();

                    budgetService.setBudget(budget);

                    System.out.println(
                            "Budget Set Successfully");

                    break;

                case 11:

                    double totalExpense =
                            service.getTotalExpense();

                    double remaining =
                            budgetService.getRemainingBudget(
                                    totalExpense
                            );

                    System.out.println(
                            "\nBudget : ₹"
                                    + budgetService.getBudget());

                    System.out.println(
                            "Spent : ₹"
                                    + totalExpense);

                    System.out.println(
                            "Remaining : ₹"
                                    + remaining);

                    break;

                case 12:

                    System.out.print(
                            "Enter Income ID: ");

                    int incomeId =
                            sc.nextInt();

                    System.out.print(
                            "Enter Amount: ");

                    double incomeAmount =
                            sc.nextDouble();

                    sc.nextLine();

                    System.out.print(
                            "Enter Source: ");

                    String source =
                            sc.nextLine();

                    Income income =
                            new Income(
                                    incomeId,
                                    incomeAmount,
                                    source,
                                    LocalDate.now()
                            );

                    incomeService.addIncome(income);

                    System.out.println(
                            "Income Added!");

                    break;

                case 13:

                    System.out.println(
                            "\nAll Income:");

                    for (Income i :
                            incomeService.getAllIncome()) {

                        System.out.println(i);
                    }

                    break;

                case 14:

                    System.out.println(
                            "Total Income = ₹"
                                    + incomeService.getTotalIncome());

                    break;

                case 15:

                    double totalIncome =
                            incomeService.getTotalIncome();

                    double expenses =
                            service.getTotalExpense();

                    System.out.println(
                            "\nIncome : ₹"
                                    + totalIncome);

                    System.out.println(
                            "Expense : ₹"
                                    + expenses);

                    System.out.println(
                            "Savings : ₹"
                                    + (totalIncome - expenses));

                    break;

                case 16:

                    System.out.println(
                            "Thank You");

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}