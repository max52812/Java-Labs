package org.example;

public class ElectricCar extends Vehicle {
    private double batteryCapacity;

    public ElectricCar(String model, int year, double price, double batteryCapacity) {
        super(model, year, price);
        this.batteryCapacity = batteryCapacity > 0 ? batteryCapacity : 50.0;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        if (batteryCapacity > 0) {
            this.batteryCapacity = batteryCapacity;
        }
    }

    @Override
    public String getFuelType() {
        return "Электричество";
    }

    //перегруж методы
    //обычн зарядка
    public void charge() {
        System.out.println("Заряжаю электромобиль " + getModel() + " от станции зарядки...");
    }

    //зарядка до конкрет процента
    public void charge(int percent) {
        System.out.println("Заряжаю электромобиль " + getModel() + " до " + percent + "%...");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  -> Батарея: " + batteryCapacity + " кВт*ч");
    }
}
