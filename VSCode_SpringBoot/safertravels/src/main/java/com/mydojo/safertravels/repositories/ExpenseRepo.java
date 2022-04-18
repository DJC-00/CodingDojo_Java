package com.mydojo.safertravels.repositories;

import java.util.List;
import com.mydojo.safertravels.models.Expense;
import com.mydojo.safertravels.models.VendorProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends CrudRepository<Expense, Long>{
    List<Expense> findAll();
    
}
