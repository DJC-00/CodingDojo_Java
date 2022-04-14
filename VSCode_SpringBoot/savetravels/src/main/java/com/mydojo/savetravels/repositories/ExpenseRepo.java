package com.mydojo.savetravels.repositories;

import java.util.List;
import com.mydojo.savetravels.models.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{
    List<Expense> findAll();
    
}
