package com.finalproject.EntityTest;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseTest {

    @Test
    void testExpenseEntity() {
        // Constructor test
        Expense expense = new Expense();

        // Create instances of Group and User
        Group group = new Group();
        User payer = new User();

        // Set values using setters
        expense.setId(1);
        expense.setGroup(group);
        expense.setPayer(payer);
        expense.setAmount(500.0);
        expense.setDescription("Dinner bill");

        // Verify values using getters
        assertEquals(1, expense.getId());
        assertEquals(group, expense.getGroup());
        assertEquals(payer, expense.getPayer());
        assertEquals(500.0, expense.getAmount());
        assertEquals("Dinner bill", expense.getDescription());
    }

    @Test
    void testParameterizedConstructor() {
        // Test the parameterized constructor
        Expense expense = new Expense(2, 250.0, "Lunch expense");

        // Verify values using getters
        assertEquals(2, expense.getId());
        assertEquals(250.0, expense.getAmount());
        assertEquals("Lunch expense", expense.getDescription());

        // Ensure group and payer are null since they are not set in the constructor
        assertNull(expense.getGroup());
        assertNull(expense.getPayer());
    }
}
