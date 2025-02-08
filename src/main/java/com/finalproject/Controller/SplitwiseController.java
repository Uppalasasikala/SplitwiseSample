package com.finalproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.Settlement;
import com.finalproject.Entity.User;
import com.finalproject.Service.ExpenseService;
import com.finalproject.Service.GroupService;
import com.finalproject.Service.SettlementService;
import com.finalproject.Service.UserService;
import com.finalproject.dto.ExpenseRequest;
import com.finalproject.dto.GroupRequest;
import com.finalproject.dto.SettlementRequest;
import com.finalproject.dto.UserRequest;

@RestController
@RequestMapping("/splitwise")
public class SplitwiseController {
    @Autowired
    public UserService userService;

    @Autowired
    public GroupService groupService;

    @Autowired
    public ExpenseService expenseService;

    @Autowired
    public SettlementService settlementService;

    // ========== USER ENDPOINTS ==========

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // ========== GROUP ENDPOINTS ==========

    @PostMapping("/groups")
    public ResponseEntity<Group> createGroup(@RequestBody GroupRequest request) {
        return new ResponseEntity<>(groupService.createGroup(request.getName(), request.getMemberIds()), HttpStatus.CREATED);
    }

    @GetMapping("/groups")
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    // ========== EXPENSE ENDPOINTS ==========

    @PostMapping("/expenses")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequest request) {
        return new ResponseEntity<>(expenseService.addExpense(request), HttpStatus.CREATED);
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    // ========== SETTLEMENT ENDPOINTS ==========

    @PostMapping("/settlements")
    public ResponseEntity<Settlement> settleExpense(@RequestBody SettlementRequest request) {
        return ResponseEntity.ok(settlementService.settleExpense(request));
    }

    @GetMapping("/settlements")
    public ResponseEntity<List<Settlement>> getAllSettlements() {
        return ResponseEntity.ok(settlementService.getAllSettlements());
    }
}