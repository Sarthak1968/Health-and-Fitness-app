package com.fitness.model;

public class User {
    private String id;
    private String name;
    private String email;
    private int age;
    private double weight;  // in kilograms
    private double height;  // in meters

    // Empty constructor (required by Spring)
    public User() {
    }

    // Constructor with all fields
    public User(String id, String name, String email, int age, double weight, double height) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Calculate BMI (Body Mass Index)
    public double calculateBMI() {
        return weight / (height * height);
    }

    // Get BMI category
    public String getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return "Underweight";
        if (bmi < 25) return "Normal";
        if (bmi < 30) return "Overweight";
        return "Obese";
    }

    // Getters and Setters (needed to access private fields)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }
}
