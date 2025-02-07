package com.finalproject;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.finalproject.Entity.User;
import com.finalproject.Repo.UserRepository;
import com.finalproject.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    public UserRepository userRepository;

    @InjectMocks
    public UserService userService;

    @Test
    public void testCreateUser() {
        User user = new User(1, "Alice", "alice@example.com");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser);
        assertEquals("Alice", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testGetUserById() {
        User user = new User(1, "Alice", "alice@example.com");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        User foundUser = userService.getUserById(1);

        assertNotNull(foundUser);
        assertEquals("Alice", foundUser.getName());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = Arrays.asList(new User(1, "Alice", "alice@example.com"), new User(2, "Bob", "bob@example.com"));

        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(2, result.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteUser_NotFound() {
        doThrow(new RuntimeException("User not found")).when(userRepository).deleteById(99);

        Exception exception = assertThrows(RuntimeException.class, () -> userService.deleteUser(99));

        assertEquals("User not found", exception.getMessage());
    }
}
