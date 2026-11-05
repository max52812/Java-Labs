package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Ввести смартфон вручную и проверить батарею");
        System.out.println("2 - Демонстрация работы геттеров, сеттеров и проверок");
        System.out.print("Выберите пункт меню (1 или 2): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                //ввод
                System.out.print("Введите бренд смартфона: ");
                String brand = scanner.nextLine();

                System.out.print("Введите диагональ экрана (например, 6,5 или 6.5): ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка: размер экрана должен быть числом!");
                    break;
                }
                double screenSize = scanner.nextDouble();

                System.out.print("Введите время работы батареи (в часах): ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: время работы должно быть целым числом!");
                    break;
                }
                int batteryLife = scanner.nextInt();

                //объект
                Smartphone userPhone = new Smartphone(brand, screenSize, batteryLife);
                System.out.println("\n--- Результат проверки объекта ---");
                userPhone.displayInfo();
                break;

            case "2":
                System.out.println("\n--- Демонстрация работы инкапсуляции ---");
                // 1. объект с хорошей батареей
                Smartphone phone1 = new Smartphone("Apple iPhone 15", 6.1, 20);
                System.out.println("Создан объект: " + phone1.getBrand());
                System.out.println("Время работы: " + phone1.getBatteryLife() + " ч.");
                System.out.println("Проверка isGoodBattery(): " + phone1.isGoodBattery());

                System.out.println("\n--- Проверка сеттеров и защиты данных ---");
                // 2. меняем через сеттер
                System.out.println("Уменьшаем батарею до 8 часов через setBatteryLife(8)...");
                phone1.setBatteryLife(8);
                System.out.println("Новое время работы через геттер: " + phone1.getBatteryLife() + " ч.");
                System.out.println("Проверка isGoodBattery(): " + phone1.isGoodBattery());

                // 3.попытка плохие данные
                System.out.println("\nПопытка установить некорректный размер экрана (-5.0):");
                phone1.setScreenSize(-5.0); // сеттер перехват
                break;

            default:
                System.out.println("Ошибка: выбран несуществующий пункт меню!");
                break;
        }
    }
}