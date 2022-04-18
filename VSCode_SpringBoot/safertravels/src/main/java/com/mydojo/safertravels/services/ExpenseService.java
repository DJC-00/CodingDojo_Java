package com.mydojo.safertravels.services;

import java.util.List;
import java.util.Optional;

import com.mydojo.safertravels.models.Expense;
import com.mydojo.safertravels.repositories.ExpenseRepo;

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
    public Expense createExpense(Expense newExpense) {
        return expRepo.save(newExpense);
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
    public Expense updateExpense(Expense updatedExpense){
        Expense ExpenseFromDB = findExpense(updatedExpense.getId());
        if (ExpenseFromDB == null){
            return null;
        }

        ExpenseFromDB.setItem(updatedExpense.getItem());
        ExpenseFromDB.setVendor(updatedExpense.getVendor());
        ExpenseFromDB.setCost(updatedExpense.getCost());
        
        return expRepo.save(ExpenseFromDB);
    }

    public void deleteExpense(Long id){
        expRepo.deleteById(id);
    }
}
