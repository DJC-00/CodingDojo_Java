package com.mydojo.savetravels.services;

import java.util.List;
import java.util.Optional;
import com.mydojo.savetravels.repositories.ExpenseRepo;
import com.mydojo.savetravels.models.Expense;

import org.springframework.stereotype.Service;


@Service
public class ExpenseService {
    private final ExpenseRepo expRepo;

    public ExpenseService(ExpenseRepo expRepo){
        this.expRepo = expRepo;
    }
    public List<Expense> allExpenses() {
        return expRepo.findAll();
    }
    public Expense createExpense(Expense b) {
        return expRepo.save(b);
    }
    // retrieves a Expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expRepo.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
}
