package service;

import model.Income;
import repository.Repository;

import java.util.List;

public class IncomeService {

    private Repository<Income> repository =
            new Repository<>();

    public void addIncome(Income income) {
        repository.add(income);
    }

    public List<Income> getAllIncome() {
        return repository.findAll();
    }

    public double getTotalIncome() {

        double total = 0;

        for (Income income : repository.findAll()) {
            total += income.getAmount();
        }

        return total;
    }
}