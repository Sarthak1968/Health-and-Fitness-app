package com.fitness.model;

public class Exercise {
    private String id;
    private String userId;         // Which user did this exercise
    private String exerciseName;   // e.g., "Running", "Push-ups"
    private int durationMinutes;   // How long they exercised
    private int caloriesBurned;    // Calories burned
    private String date;           // When they did it

    // Empty constructor
    public Exercise() {
    }

    // Constructor with all fields
    public Exercise(String id, String userId, String exerciseName,
                    int durationMinutes, int caloriesBurned, String date) {
        this.id = id;
        this.userId = userId;
        this.exerciseName = exerciseName;
        this.durationMinutes = durationMinutes;
        this.caloriesBurned = caloriesBurned;
        this.date = date;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getExerciseName() { return exerciseName; }
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public int getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(int caloriesBurned) { this.caloriesBurned = caloriesBurned; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
