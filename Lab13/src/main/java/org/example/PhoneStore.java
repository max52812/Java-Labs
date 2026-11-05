package org.example;

import java.util.ArrayList;
import java.util.List;

// Класс "Магазин телефонов"
public class PhoneStore {
    private List<Phone> catalog = new ArrayList<>();

    public void addPhone(Phone phone) {
        if (phone != null) {
            catalog.add(phone);
        }
    }

    // Поиск телефона по модели (выбрасывает PhoneNotFoundException)
    public Phone findPhone(String model) throws PhoneNotFoundException {
        for (Phone p : catalog) {
            if (p.getModel().equalsIgnoreCase(model.trim())) {
                return p;
            }
        }
        throw new PhoneNotFoundException("Телефон с моделью \"" + model + "\" не найден в магазине!", model);
    }

    // Операция обновления цены в магазине
    public void updatePhonePrice(String model, double newPrice) throws PhoneNotFoundException, PriceUpdateException {
        Phone phone = findPhone(model);
        phone.updatePrice(newPrice);
    }

    // Операция увеличения памяти телефона в магазине
    public void upgradePhoneMemory(String model, int newMemory) throws PhoneNotFoundException, InvalidPhoneDataException {
        Phone phone = findPhone(model);
        phone.upgradeMemory(newMemory);
    }

    public void displayCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("Каталог магазина пуст.");
            return;
        }
        System.out.println("Каталог магазина телефонов:");
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + catalog.get(i));
        }
    }
}
