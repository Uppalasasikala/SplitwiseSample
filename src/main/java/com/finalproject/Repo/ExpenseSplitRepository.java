package com.finalproject.Repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finalproject.Entity.ExpenseSplit;

@Repository
public interface ExpenseSplitRepository extends JpaRepository<ExpenseSplit, Integer> {
    List<ExpenseSplit> findByExpenseId(Integer expenseId);
}
