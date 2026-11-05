package org.example;

// Пользовательское проверяемое исключение: телефон не найден в каталоге магазина
public class PhoneNotFoundException extends Exception {
    private String requestedModel;

    public PhoneNotFoundException(String message, String requestedModel) {
        super(message);
        this.requestedModel = requestedModel;
    }

    public String getRequestedModel() {
        return requestedModel;
    }
}
