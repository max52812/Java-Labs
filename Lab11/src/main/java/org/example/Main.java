package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Запустить задание: демонстрация статического и динамического полиморфизма");
        System.out.println("2 - Создать автомобиль вручную с клавиатуры");
        System.out.println("3 - Выход");
        System.out.print("Выберите пункт меню (1, 2 или 3): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Вызываем разные версии перегруженного метода drive():");

                Vehicle basicVehicle = new Vehicle("Универсальное ТС", 2020, 15000);
                System.out.print("1) drive(): ");
                basicVehicle.drive();

                System.out.print("2) drive(90): ");
                basicVehicle.drive(90);

                System.out.print("3) drive(\"Минск\"): ");
                basicVehicle.drive("Минск");

                System.out.println("Создаем массив базового типа Vehicle[] с объектами разных классов:");

                Vehicle[] vehicles = new Vehicle[4];
                vehicles[0] = new ElectricCar("Tesla Model S", 2023, 75000, 100);
                vehicles[1] = new ElectricCar("Porsche Taycan", 2022, 95000, 93.4);
                vehicles[2] = new GasolineCar("BMW M5", 2021, 85000, 68);
                vehicles[3] = new GasolineCar("Mercedes-AMG E63", 2022, 90000, 66);

                for (int i = 0; i < vehicles.length; i++) {
                    System.out.println("\n[Автомобиль #" + (i + 1) + "]");
                    //вызов переопр getFuelType() через displayInfo()
                    vehicles[i].displayInfo();

                    //вызов drive()
                    vehicles[i].drive(120);

                    //преобразование через instanceof
                    if (vehicles[i] instanceof ElectricCar) {
                        ElectricCar ec = (ElectricCar) vehicles[i];
                        ec.charge();
                        ec.charge(80);
                    } else if (vehicles[i] instanceof GasolineCar) {
                        GasolineCar gc = (GasolineCar) vehicles[i];
                        gc.refuel();
                        gc.refuel(30.0);
                    }
                }

                System.out.println("Статический (перегрузка drive): решение принимается компилятором по сигнатуре аргументов.");
                System.out.println("Динамический (переопределение getFuelType): решение принимается во время выполнения JVM по типу объекта в куче (heap).");
                break;

            case "2":
                System.out.println("\nКакой тип автомобиля вы хотите создать?");
                System.out.println("1 - Электромобиль (ElectricCar)");
                System.out.println("2 - Бензиновый автомобиль (GasolineCar)");
                System.out.print("Ваш выбор: ");
                String typeChoice = scanner.nextLine();

                System.out.print("Введите модель автомобиля: ");
                String model = scanner.nextLine();

                System.out.print("Введите год выпуска: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: год выпуска должен быть целым числом!");
                    break;
                }
                int year = scanner.nextInt();

                System.out.print("Введите цену ($): ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Ошибка: цена должна быть числом!");
                    break;
                }
                double price = scanner.nextDouble();

                if (typeChoice.equals("1")) {
                    System.out.print("Введите емкость батареи (кВт*ч): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Ошибка: емкость батареи должна быть числом!");
                        break;
                    }
                    double battery = scanner.nextDouble();

                    ElectricCar customEc = new ElectricCar(model, year, price, battery);
                    System.out.println("\nАвтомобиль успешно создан");
                    customEc.displayInfo();
                    customEc.drive();
                    customEc.drive(80);
                    customEc.charge(100);

                } else if (typeChoice.equals("2")) {
                    System.out.print("Введите объем топливного бака (л): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Ошибка: объем бака должен быть числом!");
                        break;
                    }
                    double tank = scanner.nextDouble();

                    GasolineCar customGc = new GasolineCar(model, year, price, tank);
                    System.out.println("\nАвтомобиль успешно создан");
                    customGc.displayInfo();
                    customGc.drive();
                    customGc.drive(110);
                    customGc.refuel(20.0);

                } else {
                    System.out.println("Ошибка: неверный выбор типа автомобиля!");
                }
                break;

            case "3":
                System.out.println("Выход из программы.");
                break;

            default:
                System.out.println("Ошибка: неверный пункт меню (введите 1, 2 или 3)!");
                break;
        }
    }
}
