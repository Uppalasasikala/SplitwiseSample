package com.finalproject.DtoTest;

import com.finalproject.dto.SettlementRequest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SettlementRequestTest {

    @Test
    public void testNoArgsConstructor() {
        SettlementRequest settlementRequest = new SettlementRequest();
        assertNotNull(settlementRequest);
    }

    @Test
    public void testAllArgsConstructor() {
        SettlementRequest settlementRequest = new SettlementRequest(1, 2, 50.0);
        assertEquals(1, settlementRequest.getPayerId());
        assertEquals(2, settlementRequest.getPayeeId());
        assertEquals(50.0, settlementRequest.getAmount());
    }

    @Test
    public void testSettersAndGetters() {
        SettlementRequest settlementRequest = new SettlementRequest();
        settlementRequest.setPayerId(1);
        settlementRequest.setPayeeId(2);
        settlementRequest.setAmount(50.0);

        assertEquals(1, settlementRequest.getPayerId());
        assertEquals(2, settlementRequest.getPayeeId());
        assertEquals(50.0, settlementRequest.getAmount());
    }
}
