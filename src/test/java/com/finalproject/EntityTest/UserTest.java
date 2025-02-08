package com.finalproject.EntityTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;

class UserTest {

    @Test
    void testUserEntity() {
        // Constructor test
        User user = new User();

        // Create sample data
        Set<Group> groups = new HashSet<>();
        Group group1 = new Group();
        Group group2 = new Group();
        groups.add(group1);
        groups.add(group2);

        // Set values using setters
        user.setId(1);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setGroups(groups);

        // Verify values using getters
        assertEquals(1, user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals(groups, user.getGroups());
    }

    @Test
    void testParameterizedConstructor() {
        // Test the parameterized constructor
        User user = new User(2, "Jane Doe", "jane.doe@example.com");

        // Verify values using getters
        assertEquals(2, user.getId());
        assertEquals("Jane Doe", user.getName());
        assertEquals("jane.doe@example.com", user.getEmail());

        // Ensure groups are empty as not initialized in the constructor
        assertTrue(user.getGroups().isEmpty());
    }
}
