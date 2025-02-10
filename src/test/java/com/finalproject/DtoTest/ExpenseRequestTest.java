package com.finalproject.DtoTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.finalproject.dto.ExpenseRequest;

public class ExpenseRequestTest {

    @Test
    public void testExpenseRequestConstructorAndGetters() {
        Integer groupId = 1;
        Integer payerId = 2;
        Double amount = 100.50;
        String description = "Dinner";
        List<Integer> participantIds = Arrays.asList(1, 2, 3);

        // Creating an instance using the constructor
        ExpenseRequest expenseRequest = new ExpenseRequest(groupId, payerId, amount, description, participantIds);

        // Verify values using getters
        assertEquals(groupId, expenseRequest.getGroupId());
        assertEquals(payerId, expenseRequest.getPayerId());
        assertEquals(amount, expenseRequest.getAmount());
        assertEquals(description, expenseRequest.getDescription());
        assertEquals(participantIds, expenseRequest.getParticipantIds());
    }

    @Test
    public void testExpenseRequestSetters() {
        ExpenseRequest expenseRequest = new ExpenseRequest();

        Integer groupId = 1;
        Integer payerId = 2;
        Double amount = 200.75;
        String description = "Lunch";
        List<Integer> participantIds = Arrays.asList(4, 5, 6);

        // Setting values using setters
        expenseRequest.setGroupId(groupId);
        expenseRequest.setPayerId(payerId);
        expenseRequest.setAmount(amount);
        expenseRequest.setDescription(description);
        expenseRequest.setParticipantIds(participantIds);

        // Verify values using getters
        assertEquals(groupId, expenseRequest.getGroupId());
        assertEquals(payerId, expenseRequest.getPayerId());
        assertEquals(amount, expenseRequest.getAmount());
        assertEquals(description, expenseRequest.getDescription());
        assertEquals(participantIds, expenseRequest.getParticipantIds());
    }
}