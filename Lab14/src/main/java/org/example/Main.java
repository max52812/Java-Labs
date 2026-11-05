package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=========================================================");
        System.out.println("   ЛАБОРАТОРНАЯ РАБОТА № 14. ФАЙЛОВЫЙ ВВОД/ВЫВОД");
        System.out.println("   Вариант 19");
        System.out.println("=========================================================");

        while (true) {
            System.out.println("\nВыберите пункт меню:");
            System.out.println("1 - Задание 1: Создание файла о любимом времени года, свойства и чтение");
            System.out.println("2 - Задание 2: Ввод 10 целых чисел в файл 'f', подсчет содержащих цифру 7");
            System.out.println("3 - Задание 3: Случайные числа в 'f', чётные кратные 3 в 'g', остальные в 'h'");
            System.out.println("4 - Задание 4: Ввод 12 температур воды в файл, расчет средней температуры");
            System.out.println("5 - Задание 5: 10 целых чисел в файле 'f', подсчет чисел > 25");
            System.out.println("6 - Запустить ВСЕ задания последовательно (демо-режим)");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    SeasonTask.run("season_variant19.txt");
                    break;
                case "2":
                    DigitSevenTask.runInteractive("numbers_f2.txt", scanner);
                    break;
                case "3":
                    EvenDivisibleByThreeTask.run("f_task3.txt", "g_task3.txt", "h_task3.txt", 15);
                    break;
                case "4":
                    WaterTempTask.runInteractive("water_temp_task4.txt", scanner);
                    break;
                case "5":
                    GreaterThanTwentyFiveTask.run("numbers_task5.txt");
                    break;
                case "6":
                    runAllDemo();
                    break;
                case "0":
                    System.out.println("Завершение работы программы.");
                    return;
                default:
                    System.out.println("Неверный пункт меню! Пожалуйста, повторите ввод (0-6).");
            }
        }
    }

    public static void runAllDemo() {
        System.out.println("\n>>> ЗАПУСК ВСЕХ ЗАДАНИЙ В ДЕМОНСТРАЦИОННОМ РЕЖИМЕ <<<");
        SeasonTask.run("season_variant19.txt");
        DigitSevenTask.runDemo("numbers_f2.txt");
        EvenDivisibleByThreeTask.run("f_task3.txt", "g_task3.txt", "h_task3.txt", 15);
        WaterTempTask.runDemo("water_temp_task4.txt");
        GreaterThanTwentyFiveTask.run("numbers_task5.txt");
        System.out.println("\n>>> ВСЕ ЗАДАНИЯ УСПЕШНО ВЫПОЛНЕНЫ <<<");
    }
}
