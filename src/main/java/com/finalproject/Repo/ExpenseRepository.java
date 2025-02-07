package com.finalproject.Repo;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.Entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

}