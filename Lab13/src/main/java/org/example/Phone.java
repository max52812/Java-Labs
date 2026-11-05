package org.example;

// Класс "Телефон" (Вариант 19)
public class Phone {
    private String brand;
    private String model;
    private double price;
    private int memory;  // в ГБ
    private int battery; // в мАч

    // Конструктор с проверкой входных данных по заданию методички
    public Phone(String brand, String model, double price, int memory, int battery) throws InvalidPhoneDataException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new InvalidPhoneDataException("Бренд телефона не может быть пустым!");
        }
        if (model == null || model.trim().isEmpty()) {
            throw new InvalidPhoneDataException("Модель телефона не может быть пустой!");
        }
        if (price <= 0) {
            throw new InvalidPhoneDataException("Цена телефона должна быть строго больше нуля! Передано: " + price);
        }
        if (memory <= 0) {
            throw new InvalidPhoneDataException("Объем памяти должен быть строго больше нуля! Передано: " + memory);
        }
        if (battery <= 0) {
            throw new InvalidPhoneDataException("Емкость батареи должна быть больше нуля! Передано: " + battery);
        }

        this.brand = brand;
        this.model = model;
        this.price = price;
        this.memory = memory;
        this.battery = battery;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getMemory() {
        return memory;
    }

    public int getBattery() {
        return battery;
    }

    // Метод обновления цены (выбрасывает PriceUpdateException)
    public void updatePrice(double newPrice) throws PriceUpdateException {
        if (newPrice <= 0) {
            throw new PriceUpdateException("Новая цена не может быть нулевой или отрицательной!", this.price, newPrice);
        }
        if (newPrice > this.price * 3) {
            throw new PriceUpdateException("Ошибка: подозрительно резкое повышение цены более чем в 3 раза!", this.price, newPrice);
        }
        this.price = newPrice;
    }

    // Метод увеличения памяти (выбрасывает InvalidPhoneDataException)
    public void upgradeMemory(int newMemory) throws InvalidPhoneDataException {
        if (newMemory <= this.memory) {
            throw new InvalidPhoneDataException("Новый объем памяти (" + newMemory +
                    " ГБ) должен быть строго больше текущего (" + this.memory + " ГБ)!");
        }
        this.memory = newMemory;
    }

    @Override
    public String toString() {
        return String.format("%s %s | Память: %d ГБ | Батарея: %d мАч | Цена: %.2f$",
                brand, model, memory, battery, price);
    }
}
