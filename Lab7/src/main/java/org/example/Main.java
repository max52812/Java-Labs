package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Создать 4 робота и рассчитать среднее время");
        System.out.println("2 - Добавить робота вручную с клавиатуры");
        System.out.print("Ваш выбор: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                //созд 4 робота и среднее
                System.out.println("\nСоздаем 4 объекта класса Robot...");

                Robot r1 = new Robot("Boston Spot", "Патрулирование", 4.5);
                Robot r2 = new Robot("Tesla Optimus", "Сборка на заводе", 8.0);
                Robot r3 = new Robot("Roomba i7", "Уборка помещений", 2.5);
                Robot r4 = new Robot("DJI Agras", "Опрыскивание полей", 1.0);

                //вывод
                System.out.println("\nСписок роботов");
                r1.displayInfo();
                r2.displayInfo();
                r3.displayInfo();
                r4.displayInfo();

                //вызов стат методы
                System.out.println("\n--- Общая статистика по всем роботам ---");
                System.out.println("Всего создано роботов (totalRobots): " + Robot.getTotalRobots());
                System.out.println("Суммарное время работы (totalBatteryLife): " + Robot.getTotalBatteryLife() + " ч.");
                System.out.printf("Среднее время работы (getAverageBatteryLife()): %.2f ч.%n", Robot.getAverageBatteryLife());

                Robot.test(r1);
                r1.test();

                break;

            case "2":
                //ввод с пр
                System.out.print("Введите модель робота: ");
                String model = scanner.nextLine();

                System.out.print("Введите функцию робота: ");
                String function = scanner.nextLine();

                System.out.print("Введите время работы от батареи в часах (например, 5 или 6.5): ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка: время работы должно быть числом!");
                    break;
                }
                double battery = scanner.nextDouble();

                if (battery <= 0) {
                    System.out.println("Ошибка: батарея должна работать больше 0 часов!");
                    break;
                }

                //созд объект
                Robot customRobot = new Robot(model, function, battery);

                System.out.println("\nРобот успешно создан!");
                customRobot.displayInfo();

                //вывод нов статистики
                System.out.println("\nТекущее число роботов в системе: " + Robot.getTotalRobots());
                System.out.printf("Новое среднее время работы: %.2f ч.%n", Robot.getAverageBatteryLife());
                break;

            default:
                System.out.println("Ошибка: неверный пункт меню (выберите 1 или 2)!");
                break;





        }
    }
}