package org.example;

public class Smartphone {
    //инкапсуляция
    private String brand;
    private double screenSize;
    private int batteryLife;
    private int count;

    public int count()
    {
        return count;
    }

    public void setCount(int count)
    {
        if(count<0)
        {
            System.out.println("ошибка, количество не может быть меньше 0");
        }
        else
        {
            this.count = count;
        }
    }
    public Smartphone(String brand, double screenSize, int batteryLife, int count)
    {
        this(brand, screenSize, batteryLife);
        this.count=count;
    }
















    //конструктор
    public Smartphone(String brand, double screenSize, int batteryLife) {
        this.brand = brand;
        setScreenSize(screenSize); //сет проверка размера
        setBatteryLife(batteryLife); //сет проверка батарейка
    }

    //гет
    public String getBrand() {
        return brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    //сет
    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        } else {
            System.out.println("Ошибка: название бренда не может быть пустым!");
        }
    }

    public void setScreenSize(double screenSize) {
        if (screenSize > 0) {
            this.screenSize = screenSize;
        } else {
            System.out.println("Ошибка: размер экрана должен быть больше 0! Установлено значение по умолчанию 6.1");
            this.screenSize = 6.1;
        }
    }

    public void setBatteryLife(int batteryLife) {
        if (batteryLife >= 0) {
            this.batteryLife = batteryLife;
        } else {
            System.out.println("Ошибка: время работы не может быть отрицательным! Установлено значение 0");
            this.batteryLife = 0;
        }
    }

    //метод, который добра если часов работы >10
    public boolean isGoodBattery() {
        return this.batteryLife > 10;
    }

    //метод вывода характ
    public void displayInfo() {
        System.out.println("Смартфон: " + brand);
        System.out.println("Диагональ экрана: " + screenSize + "\"");
        System.out.println("Время работы от батареи: " + batteryLife + " ч.");
        System.out.println("Хорошая батарея (>10ч): " + (isGoodBattery() ? "Да" : "Нет"));
    }
}