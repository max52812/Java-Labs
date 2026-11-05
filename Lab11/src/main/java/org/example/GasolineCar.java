package org.example;

public class GasolineCar extends Vehicle {
    private double tankCapacity;

    public GasolineCar(String model, int year, double price, double tankCapacity) {
        super(model, year, price);
        this.tankCapacity = tankCapacity > 0 ? tankCapacity : 60.0;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        if (tankCapacity > 0) {
            this.tankCapacity = tankCapacity;
        }
    }

    @Override
    public String getFuelType() {
        return "Бензин";
    }

    //перегруж методы
    //полн заправка
    public void refuel() {
        System.out.println("Заправляю автомобиль " + getModel() + " полным баком бензина (" + tankCapacity + " л)...");
    }

    //заправка на крнкретн кол во литров
    public void refuel(double liters) {
        System.out.println("Заправляю автомобиль " + getModel() + ": залито " + liters + " л бензина...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  -> Объем бака: " + tankCapacity + " л");
    }
}
