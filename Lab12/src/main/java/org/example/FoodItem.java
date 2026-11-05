package org.example;

public class FoodItem {
    private String name;
    private int id;
    private double calories;

    public FoodItem(String name, int id, double calories) {
        this.name = name;
        this.id = id;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " (" + calories + " ккал)";
    }
}
