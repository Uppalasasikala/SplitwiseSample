package com.finalproject.DtoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.finalproject.dto.UserRequest;

public class UserRequestTest {

    @Test
    public void testNoArgsConstructor() {
        UserRequest userRequest = new UserRequest();
        assertNotNull(userRequest);
        assertNull(userRequest.getName());
        assertNull(userRequest.getEmail());
    }

    @Test
    public void testAllArgsConstructor() {
        UserRequest userRequest = new UserRequest("Alice", "alice@example.com");

        assertNotNull(userRequest);
        assertEquals("Alice", userRequest.getName());
        assertEquals("alice@example.com", userRequest.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        UserRequest userRequest = new UserRequest();
        
        userRequest.setName("Bob");
        assertEquals("Bob", userRequest.getName());

        userRequest.setEmail("bob@example.com");
        assertEquals("bob@example.com", userRequest.getEmail());
    }
}