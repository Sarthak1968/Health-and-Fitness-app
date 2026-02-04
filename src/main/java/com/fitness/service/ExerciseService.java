package com.fitness.service;

import com.fitness.model.Exercise;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExerciseService {

    // ArrayList to store all exercises (order matters for history)
    private List<Exercise> exerciseDatabase = new ArrayList<>();

    private int nextId = 1;

    // Add a new exercise
    public Exercise addExercise(Exercise exercise) {
        String id = "EX" + nextId;
        nextId++;

        exercise.setId(id);
        exerciseDatabase.add(exercise);  // Add to ArrayList

        System.out.println("✅ Logged exercise: " + exercise.getExerciseName());
        return exercise;
    }

    // Get all exercises
    public List<Exercise> getAllExercises() {
        return new ArrayList<>(exerciseDatabase);
    }

    // Get exercises for a specific user
    public List<Exercise> getExercisesByUser(String userId) {
        List<Exercise> userExercises = new ArrayList<>();

        // Loop through all exercises
        for (Exercise exercise : exerciseDatabase) {
            // Check if this exercise belongs to the user
            if (exercise.getUserId().equals(userId)) {
                userExercises.add(exercise);
            }
        }

        return userExercises;
    }

    // Calculate total calories burned by a user
    public int getTotalCalories(String userId) {
        int totalCalories = 0;

        for (Exercise exercise : exerciseDatabase) {
            if (exercise.getUserId().equals(userId)) {
                totalCalories += exercise.getCaloriesBurned();
            }
        }

        return totalCalories;
    }

    // Calculate total workout time for a user
    public int getTotalWorkoutTime(String userId) {
        int totalTime = 0;

        for (Exercise exercise : exerciseDatabase) {
            if (exercise.getUserId().equals(userId)) {
                totalTime += exercise.getDurationMinutes();
            }
        }

        return totalTime;
    }

    // Count total exercises for a user
    public int getTotalExercises(String userId) {
        int count = 0;

        for (Exercise exercise : exerciseDatabase) {
            if (exercise.getUserId().equals(userId)) {
                count++;
            }
        }

        return count;
    }
}
