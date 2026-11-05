package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Задание 1: Здание");
        System.out.println("2 - Задание 2: Флот");
        System.out.println("3 - Задание 3: Билеты бизнес-класса");
        System.out.print("Выберите номер задания (1, 2 или 3): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // З1 - объект Здание и средняя площадь этажа
                System.out.print("Введите адрес здания: ");
                String address = scanner.nextLine();

                System.out.print("Введите количество этажей: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: количество этажей должно быть целым числом!");
                    break;
                }
                int floors = scanner.nextInt();

                System.out.print("Введите общую площадь здания: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка: площадь должна быть числом!");
                    break;
                }
                double totalArea = scanner.nextDouble();

                // корректность
                if (floors <= 0 || totalArea <= 0) {
                    System.out.println("Ошибка: количество этажей и площадь должны быть больше нуля!");
                    break;
                }

                Building building = new Building(address, floors, totalArea);

                System.out.println("\n Данные о здании ");
                System.out.println("Адрес: " + building.address);
                System.out.println("Этажей: " + building.floors);
                System.out.println("Общая площадь: " + building.totalArea + " кв.м");
                System.out.println("Средняя площадь одного этажа: " + building.averageAreaPerFloor() + " кв.м");
                break;

            case "2":
                // З2 - Массив из кораблей, поиск длинного и тяжелого
                Ship[] ships = {
                        new Ship("Титан", 269.1, 52310.0),
                        new Ship("Аврора", 126.5, 6730.0),
                        new Ship("Одиссей", 362.0, 225280.0),
                        new Ship("Шторм", 180.4, 24000.0),
                        new Ship("Витязь", 315.8, 110000.0)
                };

                Ship longestShip = ships[0];
                Ship heaviestShip = ships[0];

                System.out.println("Список кораблей в массиве:");
                for (int i = 0; i < ships.length; i++) {
                    System.out.println((i + 1) + ". " + ships[i].name +
                            ", его длина: " + ships[i].length + "м" +
                            " и его водоизмещение: " + ships[i].tonnage + "т");

                    if (ships[i].length > longestShip.length) {
                        longestShip = ships[i];
                    }
                    if (ships[i].tonnage > heaviestShip.tonnage) {
                        heaviestShip = ships[i];
                    }
                }

                System.out.println("\nРезультаты анализа флота");
                System.out.println("Самый длинный корабль: " + longestShip.name + " (" + longestShip.length + " м)");
                System.out.println("Корабль с максимальным водоизмещением: " + heaviestShip.name + " (" + heaviestShip.tonnage + " т)");
                break;

            case "3":
                // З3 - Массив билетов, вывести только со статусом BUSINESS
                Ticket[] tickets = {
                        new Ticket("SU-100", TicketType.ECONOMY),
                        new Ticket("BA-240", TicketType.BUSINESS),
                        new Ticket("LH-451", TicketType.FIRST_CLASS),
                        new Ticket("AF-112", TicketType.BUSINESS),
                        new Ticket("TK-890", TicketType.ECONOMY),
                        new Ticket("EK-015", TicketType.BUSINESS)
                };

                System.out.println("Список всех билетов бизнес-класса (BUSINESS):");
                for (Ticket t : tickets) {
                    if (t.type == TicketType.BUSINESS) {
                        System.out.println("Рейс: " + t.flightNumber + " и его класс: " + t.type);
                    }
                }
                break;

            default:
                System.out.println("Ошибка: неверный пункт меню (введите 1, 2 или 3).");
                break;
        }
    }
}