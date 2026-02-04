package com.fitness.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    // Welcome message - GET http://localhost:8080/
    @GetMapping("/")
    public String home() {
        return "🏋️ Welcome to Fitness Tracker API! " +
                "Go to /api/users to manage users and /api/exercises to track workouts.";
    }

    // Health check - GET http://localhost:8080/health
    @GetMapping("/health")
    public String healthCheck() {
        return "✅ App is running perfectly!";
    }
}
