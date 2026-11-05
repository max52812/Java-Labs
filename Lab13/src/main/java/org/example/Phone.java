package org.example;

public class Phone {
    private String brand;
    private String model;
    private double price;
    private int memory;
    private int battery;

    public Phone() {
    }

    // Конструктор без прямых проверок: делегирует установку значений сеттерам
    public Phone(String brand, String model, double price, int memory, int battery) throws InvalidPhoneDataException {
        setBrand(brand);
        setModel(model);
        setPrice(price);
        setMemory(memory);
        setBattery(battery);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) throws InvalidPhoneDataException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new InvalidPhoneDataException("Бренд телефона не может быть пустым!");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws InvalidPhoneDataException {
        if (model == null || model.trim().isEmpty()) {
            throw new InvalidPhoneDataException("Модель телефона не может быть пустой!");
        }
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws InvalidPhoneDataException {
        if (price <= 0) {
            throw new InvalidPhoneDataException("Цена телефона должна быть строго больше нуля! Передано: " + price);
        }
        this.price = price;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) throws InvalidPhoneDataException {
        if (memory <= 0) {
            throw new InvalidPhoneDataException("Объем памяти должен быть строго больше нуля! Передано: " + memory);
        }
        this.memory = memory;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) throws InvalidPhoneDataException {
        if (battery <= 0) {
            throw new InvalidPhoneDataException("Емкость батареи должна быть больше нуля! Передано: " + battery);
        }
        this.battery = battery;
    }

    // Методы бизнес-логики с исключениями
    public void updatePrice(double newPrice) throws PriceUpdateException {
        if (newPrice <= 0) {
            throw new PriceUpdateException("Новая цена не может быть нулевой или отрицательной!", this.price, newPrice);
        }
        if (newPrice > this.price * 3) {
            throw new PriceUpdateException("Ошибка: подозрительный скачок цены более чем в 3 раза!", this.price, newPrice);
        }
        this.price = newPrice;
    }

    public void upgradeMemory(int newMemory) throws InvalidPhoneDataException {
        if (newMemory <= this.memory) {
            throw new InvalidPhoneDataException("Новый объем памяти (" + newMemory +
                    " ГБ) должен быть строго больше текущего (" + this.memory + " ГБ)!");
        }
        this.memory = newMemory;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Память: %d ГБ | АКБ: %d мАч | Цена: %.2f$",
                brand, model, memory, battery, price);
    }
}
