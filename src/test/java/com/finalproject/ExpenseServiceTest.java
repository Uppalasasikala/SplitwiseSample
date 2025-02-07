package com.finalproject;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.finalproject.Entity.Expense;
import com.finalproject.Repo.ExpenseRepository;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.ExpenseService;
import com.finalproject.dto.ExpenseRequest;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    public ExpenseRepository expenseRepository;

    @Mock
    public GroupRepository groupRepository;

    @Mock
    public UserRepository userRepository;

    @InjectMocks
    public ExpenseService expenseService;

    @Test
    public void testAddExpense() {
        Expense expense = new Expense(1, 100.0, "Lunch");

        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        Expense savedExpense = expenseService.addExpense(new ExpenseRequest(1, 1, 100.0, "Lunch"));

        assertNotNull(savedExpense);
        assertEquals(100.0, savedExpense.getAmount());
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    public void testGetAllExpenses_Empty() {
        when(expenseRepository.findAll()).thenReturn(Collections.emptyList());

        List<Expense> expenses = expenseService.getAllExpenses();

        assertTrue(expenses.isEmpty());
        verify(expenseRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteExpense_NotFound() {
        doThrow(new RuntimeException("Expense not found")).when(expenseRepository).deleteById(99);

        Exception exception = assertThrows(RuntimeException.class, () -> expenseService.deleteExpense(99));

        assertEquals("Expense not found", exception.getMessage());
    }
}