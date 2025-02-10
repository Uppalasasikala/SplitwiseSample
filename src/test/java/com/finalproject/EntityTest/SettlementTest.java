package com.finalproject.EntityTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Settlement;
import com.finalproject.Entity.User;

public class SettlementTest {

    @Test
    public void testNoArgsConstructor() {
        Settlement settlement = new Settlement();
        assertNotNull(settlement);
        assertNull(settlement.getId());
        assertNull(settlement.getPayer());
        assertNull(settlement.getPayee());
        assertNull(settlement.getAmount());
    }

    @Test
    public void testAllArgsConstructor() {
        User payer = new User(1, "Alice", "alice@example.com");
        User payee = new User(2, "Bob", "bob@example.com");

        Settlement settlement = new Settlement(100, payer, payee, 50.0);

        assertNotNull(settlement);
        assertEquals(100, settlement.getId());
        assertEquals(payer, settlement.getPayer());
        assertEquals(payee, settlement.getPayee());
        assertEquals(50.0, settlement.getAmount());
    }

    @Test
    public void testSettersAndGetters() {
        User payer = new User(1, "Alice", "alice@example.com");
        User payee = new User(2, "Bob", "bob@example.com");

        Settlement settlement = new Settlement();
        
        settlement.setId(200);
        assertEquals(200, settlement.getId());

        settlement.setPayer(payer);
        assertEquals(payer, settlement.getPayer());

        settlement.setPayee(payee);
        assertEquals(payee, settlement.getPayee());

        settlement.setAmount(75.0);
        assertEquals(75.0, settlement.getAmount());
    }
}