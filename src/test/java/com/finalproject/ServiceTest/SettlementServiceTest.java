package com.finalproject.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.finalproject.Entity.Settlement;
import com.finalproject.Entity.User;
import com.finalproject.Repo.SettlementRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.SettlementService;
import com.finalproject.dto.SettlementRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SettlementServiceTest {

    @Mock
    private SettlementRepository settlementRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private SettlementService settlementService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSettleExpense_Success() {
        // Mock data
        User payer = new User(1, "Alice", "alice@example.com");
        User payee = new User(2, "Bob", "bob@example.com");
        SettlementRequest request = new SettlementRequest(1, 2, 50.0);

        Settlement settlement = new Settlement(10, payer, payee, 50.0);

        // Mock behavior
        when(userRepository.findById(1)).thenReturn(Optional.of(payer));
        when(userRepository.findById(2)).thenReturn(Optional.of(payee));
        when(settlementRepository.save(any(Settlement.class))).thenReturn(settlement);

        // Call method
        Settlement result = settlementService.settleExpense(request);

        // Verify & Assertions
        assertNotNull(result);
        assertEquals(50.0, result.getAmount());
        assertEquals("Alice", result.getPayer().getName());
        assertEquals("Bob", result.getPayee().getName());

        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).findById(2);
        verify(settlementRepository, times(1)).save(any(Settlement.class));
    }

    @Test
    public void testSettleExpense_PayerNotFound() {
        // Mock behavior: Payer not found
        SettlementRequest request = new SettlementRequest(1, 2, 50.0);
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        // Call method & assert exception
        Exception exception = assertThrows(RuntimeException.class, () -> {
            settlementService.settleExpense(request);
        });

        assertEquals("Payer not found", exception.getMessage());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testSettleExpense_PayeeNotFound() {
        // Mock data
        User payer = new User(1, "Alice", "alice@example.com");
        SettlementRequest request = new SettlementRequest(1, 2, 50.0);

        // Mock behavior: Payee not found
        when(userRepository.findById(1)).thenReturn(Optional.of(payer));
        when(userRepository.findById(2)).thenReturn(Optional.empty());

        // Call method & assert exception
        Exception exception = assertThrows(RuntimeException.class, () -> {
            settlementService.settleExpense(request);
        });

        assertEquals("Payee not found", exception.getMessage());
        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).findById(2);
    }

    @Test
    public void testGetAllSettlements() {
        // Mock data
        Settlement settlement1 = new Settlement(1, new User(1, "Alice", "alice@example.com"), new User(2, "Bob", "bob@example.com"), 30.0);
        Settlement settlement2 = new Settlement(2, new User(3, "Charlie", "charlie@example.com"), new User(4, "David", "david@example.com"), 40.0);

        when(settlementRepository.findAll()).thenReturn(Arrays.asList(settlement1, settlement2));

        // Call method
        List<Settlement> settlements = settlementService.getAllSettlements();

        // Verify & Assertions
        assertEquals(2, settlements.size());
        assertEquals(30.0, settlements.get(0).getAmount());
        assertEquals(40.0, settlements.get(1).getAmount());

        verify(settlementRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteSettlement() {
        // Call method
        settlementService.deleteSettlement(1);

        // Verify
        verify(settlementRepository, times(1)).deleteById(1);
    }
}