package com.finalproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.Entity.Settlement;
import com.finalproject.Entity.User;
import com.finalproject.Repo.SettlementRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.dto.SettlementRequest;

@Service
public class SettlementService {
    @Autowired
    public SettlementRepository settlementRepository;

    @Autowired
    public UserRepository userRepository;

    public Settlement settleExpense(SettlementRequest request) {
        User payer = userRepository.findById(request.getPayerId())
                .orElseThrow(() -> new RuntimeException("Payer not found"));

        User payee = userRepository.findById(request.getPayeeId())
                .orElseThrow(() -> new RuntimeException("Payee not found"));

        Settlement settlement = new Settlement();
        settlement.setPayer(payer);
        settlement.setPayee(payee);
        settlement.setAmount(request.getAmount());

        return settlementRepository.save(settlement);
    }

    public List<Settlement> getAllSettlements() {
        return settlementRepository.findAll();
    }

    public void deleteSettlement(Integer id) {
        settlementRepository.deleteById(id);
    }
}
