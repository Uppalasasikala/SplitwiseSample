package com.finalproject.EntityTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import org.junit.jupiter.api.Test;

public class GroupTest {

	@Test
	public void testNoArgsConstructor() {
		Group group = new Group();
		assertNotNull(group);
		assertNull(group.getId());
		assertNull(group.getName());
		assertNotNull(group.getMembers());
		assertTrue(group.getMembers().isEmpty());
	}

	@Test
	public void testAllArgsConstructor() {
		User user1 = new User(1, "Alice", "alice@example.com");
		User user2 = new User(2, "Bob", "bob@example.com");
		List<User> members = Arrays.asList(user1, user2);

		Group group = new Group(10, "Friends", members);

		assertNotNull(group);
		assertEquals(10, group.getId());
		assertEquals("Friends", group.getName());
		assertEquals(2, group.getMembers().size());
		assertTrue(group.getMembers().contains(user1));
		assertTrue(group.getMembers().contains(user2));
	}

	@Test
	public void testSettersAndGetters() {
		Group group = new Group();

		group.setId(5);
		assertEquals(5, group.getId());

		group.setName("Work Buddies");
		assertEquals("Work Buddies", group.getName());

		User user1 = new User(1, "Charlie", "charlie@example.com");
		User user2 = new User(2, "David", "david@example.com");
		List<User> newMembers = Arrays.asList(user1, user2);

		group.setMembers(newMembers);
		assertEquals(2, group.getMembers().size());
		assertTrue(group.getMembers().contains(user1));
		assertTrue(group.getMembers().contains(user2));
	}
}