package com.finalproject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import com.finalproject.Repo.ExpenseRepository;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.ExpenseService;
import com.finalproject.dto.ExpenseRequest;

@SpringBootTest
public class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @Test
    public void testAddExpense() {
        // Arrange
        Expense expense = new Expense(1, 100.0, "Lunch");
        User user = new User(1, "John Doe","johnDoe12@gmail.com");
        Group group = new Group(1, "Friends");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        when(groupRepository.findById(1)).thenReturn(Optional.of(group));
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);
        Expense savedExpense = expenseService.addExpense(new ExpenseRequest(1, 1, 100.0, "Lunch"));
        assertNotNull(savedExpense, "The saved expense should not be null");
        assertEquals(100.0, savedExpense.getAmount(), "The amount should be 100.0");
        assertEquals("Lunch", savedExpense.getDescription(), "The description should be 'Lunch'");
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