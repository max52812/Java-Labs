package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА № 13 (ВАРИАНТ 19) ===");
        System.out.println("Тема: Обработка исключительных ситуаций (Exception Handling)");
        System.out.println("1 - Запустить демонстрацию работы магазина и обработки всех исключений");
        System.out.println("2 - Создать телефон и выполнить операции вручную");
        System.out.println("3 - Выход");
        System.out.print("Выберите пункт меню (1, 2 или 3): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("\n--- ЗАДАНИЕ 19: Магазин телефонов и обработка исключений ---");
                PhoneStore store = new PhoneStore();

                // 1. Успешное создание и добавление телефонов в магазин
                try {
                    store.addPhone(new Phone("Apple", "iPhone 15", 999.99, 128, 3349));
                    store.addPhone(new Phone("Samsung", "Galaxy S24", 899.00, 256, 4000));
                    store.addPhone(new Phone("Xiaomi", "14 Pro", 699.50, 256, 4880));
                    System.out.println("Успешно добавлены 3 телефона в каталог.");
                } catch (InvalidPhoneDataException e) {
                    System.out.println("Ошибка при начальном заполнении: " + e.getMessage());
                }

                store.displayCatalog();

                // 2. Демонстрация исключения InvalidPhoneDataException (неверные данные при создании)
                System.out.println("\n[Тест 1] Попытка создать телефон с отрицательной ценой и нулевой памятью:");
                try {
                    Phone badPhone = new Phone("Google", "Pixel 8", -500.0, 0, 4575);
                    store.addPhone(badPhone);
                } catch (InvalidPhoneDataException e) {
                    System.out.println("-> Перехвачено исключение InvalidPhoneDataException: " + e.getMessage());
                } finally {
                    System.out.println("-> Блок finally: завершена попытка создания некорректного телефона.");
                }

                // 3. Демонстрация исключения PhoneNotFoundException (поиск несуществующей модели)
                System.out.println("\n[Тест 2] Попытка найти в магазине модель \"Nokia 3310\":");
                try {
                    store.findPhone("Nokia 3310");
                } catch (PhoneNotFoundException e) {
                    System.out.println("-> Перехвачено исключение PhoneNotFoundException: " + e.getMessage());
                    System.out.println("   Запрошенная модель: " + e.getRequestedModel());
                }

                // 4. Демонстрация исключения PriceUpdateException (ошибка обновления цены)
                System.out.println("\n[Тест 3] Попытка установить отрицательную цену для iPhone 15:");
                try {
                    store.updatePhonePrice("iPhone 15", -100.0);
                } catch (PhoneNotFoundException | PriceUpdateException e) {
                    System.out.println("-> Перехвачено исключение (multi-catch): " + e.getMessage());
                }

                // 5. Демонстрация исключения при попытке уменьшить память вместо увеличения
                System.out.println("\n[Тест 4] Попытка уменьшить память у Galaxy S24 (с 256 ГБ до 64 ГБ):");
                try {
                    store.upgradePhoneMemory("Galaxy S24", 64);
                } catch (PhoneNotFoundException | InvalidPhoneDataException e) {
                    System.out.println("-> Перехвачено исключение (multi-catch): " + e.getMessage());
                }

                // 6. Успешные операции обновления цены и увеличения памяти
                System.out.println("\n[Тест 5] Успешное обновление цены (скидка до 899.99) и апгрейд памяти до 256 ГБ для iPhone 15:");
                try {
                    store.updatePhonePrice("iPhone 15", 899.99);
                    store.upgradePhoneMemory("iPhone 15", 256);
                    System.out.println("Операции успешно выполнены!");
                } catch (PhoneNotFoundException | PriceUpdateException | InvalidPhoneDataException e) {
                    System.out.println("Непредвиденная ошибка: " + e.getMessage());
                }

                System.out.println("\nИтоговое состояние каталога магазина:");
                store.displayCatalog();
                break;

            case "2":
                System.out.println("\n--- Ручное создание телефона с проверкой исключений ---");
                try {
                    System.out.print("Введите бренд (например, Apple): ");
                    String brand = scanner.nextLine();

                    System.out.print("Введите модель (например, iPhone 16): ");
                    String model = scanner.nextLine();

                    System.out.print("Введите цену ($): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Ошибка ввода: цена должна быть числом!");
                        break;
                    }
                    double price = scanner.nextDouble();

                    System.out.print("Введите объем памяти (ГБ): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка ввода: память должна быть целым числом!");
                        break;
                    }
                    int memory = scanner.nextInt();

                    System.out.print("Введите емкость аккумулятора (мАч): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка ввода: батарея должна быть целым числом!");
                        break;
                    }
                    int battery = scanner.nextInt();

                    Phone userPhone = new Phone(brand, model, price, memory, battery);
                    System.out.println("\nТелефон успешно создан без ошибок:");
                    System.out.println(userPhone);

                } catch (InvalidPhoneDataException e) {
                    System.out.println("ОШИБКА создания объекта: " + e.getMessage());
                }
                break;

            case "3":
                System.out.println("Выход из программы.");
                break;

            default:
                System.out.println("Ошибка: выбран несуществующий пункт меню (введите 1, 2 или 3)!");
                break;
        }

        scanner.close();
    }
}
