package com.finalproject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import com.finalproject.Repo.ExpenseRepository;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.dto.ExpenseRequest;



@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    public Expense addExpense(ExpenseRequest request) {
        Group group = groupRepository.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        User payer = userRepository.findById(request.getPayerId())
                .orElseThrow(() -> new RuntimeException("Payer not found"));

        Expense expense = new Expense();
        expense.setGroup(group);
        expense.setPayer(payer);
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());

        return expenseRepository.save(expense);
    }
        public List<Expense> getAllExpenses() {
            return expenseRepository.findAll();
        }

        public void deleteExpense(Integer id) {
            expenseRepository.deleteById(id);
        }

}