package org.example;

public class Vehicle {
    private String model;
    private int year;
    private double price;

    public Vehicle(String model, int year, double price) {
        this.model = model;
        this.year = year > 1885 ? year : 2000;
        this.price = price >= 0 ? price : 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model != null && !model.trim().isEmpty()) {
            this.model = model;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year > 1885) {
            this.year = year;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    //перегруж методы
    //без параметров
    public void drive() {
        System.out.println("Еду");
    }

    // со скоростью
    public void drive(int speed) {
        System.out.println("Еду со скоростью " + speed);
    }

    //с пунктом назначения
    public void drive(String destination) {
        System.out.println("Еду в " + destination);
    }

    public String getFuelType() {
        return "Неизвестно";
    }

    public void displayInfo() {
        System.out.println("Модель: " + model + " | Год: " + year + " | Цена: " + price + "$ | Топливо: " + getFuelType());
    }
}
