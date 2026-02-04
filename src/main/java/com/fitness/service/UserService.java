package com.fitness.service;

import com.fitness.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    // HashMap to store users - Key: userId, Value: User object
    // HashMap is fast for finding users by ID
    private Map<String, User> userDatabase = new HashMap<>();

    private int nextId = 1;  // Counter for generating unique IDs

    // Create a new user
    public User createUser(User user) {
        String id = "USER" + nextId;
        nextId++;

        user.setId(id);
        userDatabase.put(id, user);  // Store in HashMap

        System.out.println("✅ Created user: " + user.getName());
        return user;
    }

    // Get all users
    public List<User> getAllUsers() {
        // Convert HashMap values to ArrayList
        return new ArrayList<>(userDatabase.values());
    }

    // Find a user by ID
    public User getUserById(String id) {
        return userDatabase.get(id);  // Fast lookup using HashMap
    }

    // Update a user
    public User updateUser(String id, User updatedUser) {
        if (userDatabase.containsKey(id)) {
            updatedUser.setId(id);
            userDatabase.put(id, updatedUser);
            System.out.println("✅ Updated user: " + id);
            return updatedUser;
        }
        return null;  // User not found
    }

    // Delete a user
    public boolean deleteUser(String id) {
        if (userDatabase.remove(id) != null) {
            System.out.println("✅ Deleted user: " + id);
            return true;
        }
        return false;  // User not found
    }

    // Count total users
    public int getTotalUsers() {
        return userDatabase.size();
    }
}
