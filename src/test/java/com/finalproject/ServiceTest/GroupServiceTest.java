package com.finalproject.ServiceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import com.finalproject.Entity.Group;
import com.finalproject.Entity.User;
import com.finalproject.Repo.GroupRepository;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.GroupService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GroupServiceTest {

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private GroupService groupService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateGroup() {
        // Mock data
        List<Integer> memberIds = Arrays.asList(1, 2);
        User user1 = new User(1, "Alice", "alice@example.com");
        User user2 = new User(2, "Bob", "bob@example.com");
        List<User> users = Arrays.asList(user1, user2);

        Group group = new Group();
        group.setId(100);
        group.setName("Trip Group");
        group.setMembers(users);

        // Mock behavior
        when(userRepository.findAllById(memberIds)).thenReturn(users);
        when(groupRepository.save(any(Group.class))).thenReturn(group);

        // Call method
        Group createdGroup = groupService.createGroup("Trip Group", memberIds);

        // Verify & Assertions
        assertNotNull(createdGroup);
        assertEquals("Trip Group", createdGroup.getName());
        assertEquals(2, createdGroup.getMembers().size());

        verify(userRepository, times(1)).findAllById(memberIds);
        verify(groupRepository, times(1)).save(any(Group.class));
    }

    @Test
    public void testGetAllGroups() {
        // Mock data
        Group group1 = new Group(1, "Friends", Arrays.asList());
        Group group2 = new Group(2, "Family", Arrays.asList());

        when(groupRepository.findAll()).thenReturn(Arrays.asList(group1, group2));

        // Call method
        List<Group> groups = groupService.getAllGroups();

        // Verify & Assertions
        assertEquals(2, groups.size());
        assertEquals("Friends", groups.get(0).getName());
        assertEquals("Family", groups.get(1).getName());

        verify(groupRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteGroup() {
        // Call method
        groupService.deleteGroup(1);

        // Verify
        verify(groupRepository, times(1)).deleteById(1);
    }
}

