package com.fitness.controller;

import com.fitness.model.Exercise;
import com.fitness.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/exercises")
@CrossOrigin(origins = "*")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    // Add a new exercise - POST http://localhost:8080/api/exercises
    @PostMapping
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseService.addExercise(exercise);
    }

    // Get all exercises - GET http://localhost:8080/api/exercises
    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    // Get exercises for a user - GET http://localhost:8080/api/exercises/user/USER1
    @GetMapping("/user/{userId}")
    public List<Exercise> getUserExercises(@PathVariable String userId) {
        return exerciseService.getExercisesByUser(userId);
    }

    // Get user statistics - GET http://localhost:8080/api/exercises/stats/USER1
    @GetMapping("/stats/{userId}")
    public Map<String, Object> getUserStats(@PathVariable String userId) {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalExercises", exerciseService.getTotalExercises(userId));
        stats.put("totalCalories", exerciseService.getTotalCalories(userId));
        stats.put("totalMinutes", exerciseService.getTotalWorkoutTime(userId));

        return stats;
    }
}
