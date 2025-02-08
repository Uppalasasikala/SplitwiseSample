package com.finalproject.EntityTest;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Settlement;
import com.finalproject.Entity.User;

import static org.junit.jupiter.api.Assertions.*;

class SettlementTest {

    @Test
    void testSettlementEntity() {
        // Constructor test
        Settlement settlement = new Settlement();

        // Create instances of User for payer and payee
        User payer = new User();
        User payee = new User();

        // Set values using setters
        settlement.setId(1);
        settlement.setPayer(payer);
        settlement.setPayee(payee);
        settlement.setAmount(250.0);

        // Verify values using getters
        assertEquals(1, settlement.getId());
        assertEquals(payer, settlement.getPayer());
        assertEquals(payee, settlement.getPayee());
        assertEquals(250.0, settlement.getAmount());
    }
}