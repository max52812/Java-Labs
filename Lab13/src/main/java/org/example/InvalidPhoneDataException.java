package org.example;

// Пользовательское проверяемое исключение: неверные данные телефона (цена <= 0, память <= 0 и др.)
public class InvalidPhoneDataException extends Exception {
    public InvalidPhoneDataException(String message) {
        super(message);
    }
}
