package com.finalproject.ControllerTest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.finalproject.Controller.SplitwiseController;
import com.finalproject.Entity.Expense;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import com.finalproject.Service.ExpenseService;
import com.finalproject.Service.GroupService;
import com.finalproject.Service.SettlementService;
import com.finalproject.Service.UserService;
import com.finalproject.dto.ExpenseRequest;
import com.finalproject.dto.GroupRequest;

@WebMvcTest(SplitwiseController.class)
public class SplitwiseControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockitoBean
    public UserService userService;

    @MockitoBean
    public ExpenseService expenseService;

    @MockitoBean
    public GroupService groupService;

    @MockitoBean
    public SettlementService settlementService;
    ObjectMapper objectmapper = new ObjectMapper();
    
 // ========== USER TESTS ==========
    @Test
    public void testCreateUser() throws Exception {
        User user = new User(1, "Alice", "alice@example.com");

        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/splitwise/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectmapper.writeValueAsString(user)))
                .andExpect(status().isCreated());
    }
    @Test
    public void testGetUser() throws Exception {
        User user = new User(1, "Alice", "alice@example.com");

        when(userService.getUserById(1)).thenReturn(user);

        mockMvc.perform(get("/splitwise/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice"));
    }
    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = Arrays.asList(new User(1, "Alice", "alice@example.com"));

        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/splitwise/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1));
    }

    @Test
    public void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(1);

        mockMvc.perform(delete("/splitwise/users/1"))
                .andExpect(status().isNoContent());
    }


        @Test
    public void testUpdateUser() throws Exception {
        User updatedUser = new User(1, "Alice Updated", "alice.new@example.com");

        when(userService.updateUser(eq(1), any(User.class))).thenReturn(updatedUser);

        mockMvc.perform(put("/splitwise/users/1")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(objectmapper.writeValueAsString(updatedUser)));
        
}
   // ========== EXPENSE TESTS ==========

        @Test
        public void testAddExpense() throws Exception {
            ExpenseRequest request = new ExpenseRequest(1,2,100.0, "Dinner", Arrays.asList(1, 2));
            Expense expense = new Expense(1, 100.0, "Dinner");

            when(expenseService.addExpense(any(ExpenseRequest.class))).thenReturn(expense);

            mockMvc.perform(post("/splitwise/expenses")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectmapper.writeValueAsString(request)))
                    .andExpect(status().isCreated());
        }

        @Test
        public void testGetAllExpenses() throws Exception {
            List<Expense> expenses = Arrays.asList(new Expense(1, 100.0, "Dinner"));

            when(expenseService.getAllExpenses()).thenReturn(expenses);

            mockMvc.perform(get("/splitwise/expenses"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()").value(1));
        }
        
        // ========== GROUP TESTS ==========

        @Test
        public void testCreateGroup() throws Exception {
            GroupRequest request = new GroupRequest("Friends", Arrays.asList(1, 2));
            Group group = new Group(1, "Friends", Arrays.asList(new User(1, "Alice", "alice@example.com")));

            when(groupService.createGroup(anyString(), anyList())).thenReturn(group);

            mockMvc.perform(post("/splitwise/groups")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectmapper.writeValueAsString(request)))
                    .andExpect(status().isCreated());
        }

        @Test
        public void testGetAllGroups() throws Exception {
            List<Group> groups = Arrays.asList(new Group(1, "Friends", null));

            when(groupService.getAllGroups()).thenReturn(groups);

            mockMvc.perform(get("/splitwise/groups"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()").value(1));
        }
        
    @Test
    public void testDeleteGroup_NotFound() throws Exception {
        doThrow(new RuntimeException("Group not found")).when(groupService).deleteGroup(99);

        mockMvc.perform(delete("/splitwise/groups/99"))
                .andExpect(status().isNotFound());
    }
}