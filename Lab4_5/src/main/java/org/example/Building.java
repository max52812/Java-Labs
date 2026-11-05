package org.example;

public class Building {
    String address;
    int floors;
    double totalArea;

    // Конструктор со всеми полями
    public Building(String address, int floors, double totalArea) {
        this.address = address;
        this.floors = floors;
        this.totalArea = totalArea;
    }

    // Метод вычисления средней площади этажа
    public double averageAreaPerFloor() {
        return totalArea / floors;
    }
}