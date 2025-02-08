package com.finalproject.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import com.finalproject.Repo.ExpenseRepository;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.ExpenseService;
import com.finalproject.dto.ExpenseRequest;

class ExpenseServiceTest {

    @Mock
    private ExpenseRepository expenseRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private ExpenseService expenseService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddExpense_Success() {
        ExpenseRequest request = new ExpenseRequest();
        request.setGroupId(1);
        request.setPayerId(2);
        request.setAmount(100.0);
        request.setDescription("Dinner expense");

        Group group = new Group();
        group.setId(1);
        group.setName("Friends Group");

        User payer = new User();
        payer.setId(2);
        payer.setName("John Doe");

        Expense expense = new Expense();
        expense.setGroup(group);
        expense.setPayer(payer);
        expense.setAmount(100.0);
        expense.setDescription("Dinner expense");

        when(groupRepository.findById(1)).thenReturn(Optional.of(group));
        when(userRepository.findById(2)).thenReturn(Optional.of(payer));
        when(expenseRepository.save(any(Expense.class))).thenReturn(expense);

        Expense result = expenseService.addExpense(request);

        assertNotNull(result);
        assertEquals(100.0, result.getAmount());
        assertEquals("Dinner expense", result.getDescription());
        assertEquals(group, result.getGroup());
        assertEquals(payer, result.getPayer());

        verify(groupRepository, times(1)).findById(1);
        verify(userRepository, times(1)).findById(2);
        verify(expenseRepository, times(1)).save(any(Expense.class));
    }

    @Test
    void testAddExpense_GroupNotFound() {
        ExpenseRequest request = new ExpenseRequest();
        request.setGroupId(1);

        when(groupRepository.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> expenseService.addExpense(request));

        assertEquals("Group not found", exception.getMessage());
        verify(groupRepository, times(1)).findById(1);
    }

    @Test
    void testAddExpense_PayerNotFound() {
        ExpenseRequest request = new ExpenseRequest();
        request.setGroupId(1);
        request.setPayerId(2);

        Group group = new Group();
        group.setId(1);
        group.setName("Friends Group");

        when(groupRepository.findById(1)).thenReturn(Optional.of(group));
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> expenseService.addExpense(request));

        assertEquals("Payer not found", exception.getMessage());
        verify(groupRepository, times(1)).findById(1);
        verify(userRepository, times(1)).findById(2);
    }

    @Test
    void testGetAllExpenses() {
        Expense expense1 = new Expense();
        expense1.setId(1);
        expense1.setAmount(50.0);
        expense1.setDescription("Lunch");

        Expense expense2 = new Expense();
        expense2.setId(2);
        expense2.setAmount(75.0);
        expense2.setDescription("Dinner");

        when(expenseRepository.findAll()).thenReturn(Arrays.asList(expense1, expense2));

        List<Expense> result = expenseService.getAllExpenses();

        assertEquals(2, result.size());
        assertEquals(50.0, result.get(0).getAmount());
        assertEquals("Lunch", result.get(0).getDescription());
        assertEquals(75.0, result.get(1).getAmount());
        assertEquals("Dinner", result.get(1).getDescription());

        verify(expenseRepository, times(1)).findAll();
    }

    @Test
    void testDeleteExpense() {
        doNothing().when(expenseRepository).deleteById(1);

        expenseService.deleteExpense(1);

        verify(expenseRepository, times(1)).deleteById(1);
    }
}