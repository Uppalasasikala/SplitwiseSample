package com.finalproject.DtoTest;
import com.finalproject.dto.ExpenseRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseRequestTest {

    @Test
    public void testNoArgsConstructor() {
        ExpenseRequest expenseRequest = new ExpenseRequest();
        assertNotNull(expenseRequest);
    }

    @Test
    public void testAllArgsConstructor() {
        ExpenseRequest expenseRequest = new ExpenseRequest(1, 2, 100.0, "Dinner");
        assertEquals(1, expenseRequest.getGroupId());
        assertEquals(2, expenseRequest.getPayerId());
        assertEquals(100.0, expenseRequest.getAmount());
        assertEquals("Dinner", expenseRequest.getDescription());
    }

    @Test
    public void testSettersAndGetters() {
        ExpenseRequest expenseRequest = new ExpenseRequest();
        expenseRequest.setGroupId(1);
        expenseRequest.setPayerId(2);
        expenseRequest.setAmount(100.0);
        expenseRequest.setDescription("Dinner");

        assertEquals(1, expenseRequest.getGroupId());
        assertEquals(2, expenseRequest.getPayerId());
        assertEquals(100.0, expenseRequest.getAmount());
        assertEquals("Dinner", expenseRequest.getDescription());
    }
}