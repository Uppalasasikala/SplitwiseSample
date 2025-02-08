package com.finalproject.EntityTest;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.ExpenseSplit;
import com.finalproject.Entity.User;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseSplitTest {

    @Test
    void testExpenseSplitEntity() {
        // Constructor test
        ExpenseSplit expenseSplit = new ExpenseSplit();

        // Create instances of Expense and User
        Expense expense = new Expense();
        User user = new User();

        // Set values using setters
        expenseSplit.setId(1);
        expenseSplit.setExpense(expense);
        expenseSplit.setUser(user);
        expenseSplit.setShareAmount(150.0);

        // Verify values using getters
        assertEquals(1, expenseSplit.getId());
        assertEquals(expense, expenseSplit.getExpense());
        assertEquals(user, expenseSplit.getUser());
        assertEquals(150.0, expenseSplit.getShareAmount());
    }        
}
