package com.mydojo.savetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.mydojo.savetravels.models.Expense;
import com.mydojo.savetravels.services.ExpenseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpenseCtrl {
    
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense/{expenseID}")
    public String OneExpense (Model pagaData, @PathVariable("expenseID") Long expenseID) {
        if (expenseService.findExpense(expenseID) == null){
            return "redirect:/expense";
        }
        Expense myExpense = expenseService.findExpense(expenseID);
        pagaData.addAttribute("expenseID", expenseID);
        pagaData.addAttribute("expenseName", myExpense.getItem());
        pagaData.addAttribute("expenseVendor", myExpense.getVendor());
        pagaData.addAttribute("expenseCost", myExpense.getCost());
        pagaData.addAttribute("createdAt", myExpense.getCreatedAt());
        pagaData.addAttribute("updatedAt", myExpense.getUpdatedAt());
        System.out.println(expenseID);
        return "expenseView.jsp";
    }

    @GetMapping("/expenses")
    public String allExpenses(Model pagaData) {
        ArrayList<Expense> expenseArray = (ArrayList<Expense>) expenseService.allExpenses();
        pagaData.addAttribute("allExpenses", expenseArray);
        System.out.println(expenseArray);
        return "allExpenses.jsp";
    }

    @GetMapping("/expenses/new")
    public String createNewExpense(@ModelAttribute("newExpense") Expense newExpense) {
        return "newExpense.jsp";
    }

    @PostMapping("/expenses")
    public String CreateNewExpenseConfirm(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult result)
    {
        if (result.hasErrors()) {
            return "newExpense.jsp";
        } else {
            expenseService.createExpense(newExpense);
            return "redirect:/expenses";
        }
        // expenseService.newExpense(newExpense);
        // return "redirect:/expense";
    }
    @GetMapping("/expense/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "editExpense.jsp";
    }
    
    @PutMapping(value="/expense/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
        if (result.hasErrors()) {
            return "editExpense.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expense/{id}";
        }
    }

    // @RequestMapping(value="/expense/{id}", method=RequestMethod.DELETE)
    // public String destroy(@PathVariable("id") Long id) {
    //     expenseService.deleteExpense(id);
    //     return "redirect:/expenses";
    // }

    @DeleteMapping(value="/expense/{id}")
    public String destroy(@PathVariable("id") Long id){
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
    
}
