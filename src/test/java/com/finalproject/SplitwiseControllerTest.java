package com.finalproject;



import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.finalproject.Controller.SplitwiseController;
import com.finalproject.Entity.User;
import com.finalproject.Service.ExpenseService;
import com.finalproject.Service.GroupService;
import com.finalproject.Service.SettlementService;
import com.finalproject.Service.UserService;

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

    @Test
    public void testCreateUser() throws Exception {
        User user = new User(1, "Alice", "alice@example.com");

        when(userService.createUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/splitwise/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\":\"Alice\",\"email\":\"alice@example.com\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        User updatedUser = new User(1, "Alice Updated", "alice.new@example.com");

        when(userService.updateUser(eq(1), any(User.class))).thenReturn(updatedUser);

        mockMvc.perform(put("/splitwise/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\":\"Alice Updated\",\"email\":\"alice.new@example.com\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Alice Updated"));
    }

    @Test
    public void testDeleteGroup_NotFound() throws Exception {
        doThrow(new RuntimeException("Group not found")).when(groupService).deleteGroup(99);

        mockMvc.perform(delete("/splitwise/groups/99"))
                .andExpect(status().isNotFound());
    }
}