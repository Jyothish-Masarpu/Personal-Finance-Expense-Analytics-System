package model;

import java.time.LocalDate;

public class Income {

    private int id;
    private double amount;
    private String source;
    private LocalDate date;

    public Income(int id, double amount, String source, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.source = source;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getSource() {
        return source;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", amount=" + amount +
                ", source='" + source + '\'' +
                ", date=" + date +
                '}';
    }
}