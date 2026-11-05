package org.example;

// Пользовательское проверяемое исключение: ошибка обновления цены
public class PriceUpdateException extends Exception {
    private double oldPrice;
    private double attemptedPrice;

    public PriceUpdateException(String message, double oldPrice, double attemptedPrice) {
        super(message);
        this.oldPrice = oldPrice;
        this.attemptedPrice = attemptedPrice;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getAttemptedPrice() {
        return attemptedPrice;
    }
}
