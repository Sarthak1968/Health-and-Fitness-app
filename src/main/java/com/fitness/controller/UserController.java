package com.fitness.controller;

import com.fitness.model.User;
import com.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController  // This makes it a REST API controller
@RequestMapping("/api/users")  // Base URL for all user endpoints
@CrossOrigin(origins = "*")  // Allow requests from any website
public class UserController {

    @Autowired  // Spring automatically creates and injects UserService
    private UserService userService;

    // Create a new user - POST http://localhost:8080/api/users
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get all users - GET http://localhost:8080/api/users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Get one user - GET http://localhost:8080/api/users/USER1
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // Update a user - PUT http://localhost:8080/api/users/USER1
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete a user - DELETE http://localhost:8080/api/users/USER1
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        boolean deleted = userService.deleteUser(id);
        if (deleted) {
            return "User deleted successfully!";
        }
        return "User not found!";
    }

    // Get total user count - GET http://localhost:8080/api/users/count
    @GetMapping("/count")
    public int getUserCount() {
        return userService.getTotalUsers();
    }
}
