package com.finalproject.EntityTest;

import org.junit.jupiter.api.Test;

import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

class GroupTest {

    @Test
    void testGroupEntity() {
        // Constructor test
        Group group = new Group();
        
        // Create sample data
        Set<User> members = new HashSet<>();
        User user1 = new User();
        User user2 = new User();
        members.add(user1);
        members.add(user2);

        // Set values using setters
        group.setId(1);
        group.setName("Test Group");
        group.setMembers(members);

        // Verify values using getters
        assertEquals(1, group.getId());
        assertEquals("Test Group", group.getName());
        assertEquals(members, group.getMembers());
    }

    @Test
    void testParameterizedConstructor() {
        // Test the parameterized constructor
        Group group = new Group(2, "Another Group");

        // Since the constructor is empty, values will be null or default
        assertNull(group.getId());
        assertNull(group.getName());
    }
}