package model;

import enums.Category;
import enums.PaymentMode;

import java.time.LocalDate;

public class Expense {

    private int id;
    private double amount;
    private Category category;
    private String description;
    private LocalDate date;
    private PaymentMode paymentMode;

    public Expense(int id,
                   double amount,
                   Category category,
                   String description,
                   LocalDate date,
                   PaymentMode paymentMode) {

        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
        this.paymentMode = paymentMode;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", amount=" + amount +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", paymentMode=" + paymentMode +
                '}';
    }
}