package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Вариант 19, Задание 2:
 * Ввести с клавиатуры в файл 'f' 10 целых чисел.
 * Вывести их на экран и найти количество чисел, содержащих цифру 7.
 */
public class DigitSevenTask {

    public static void runInteractive(String fileName, Scanner scanner) {
        System.out.println("\n--- Задание 2: Ввод 10 целых чисел и поиск цифры 7 ---");
        int[] numbers = new int[10];
        System.out.println("Введите 10 целых чисел через Enter или пробел:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Число [" + (i + 1) + "]: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка! Введите корректное целое число:");
                scanner.next();
            }
            numbers[i] = scanner.nextInt();
        }
        scanner.nextLine(); // очистка буфера перевода строки

        execute(fileName, numbers);
    }

    public static void runDemo(String fileName) {
        System.out.println("\n--- Задание 2 (Демо): 10 целых чисел и поиск цифры 7 ---");
        int[] demoNumbers = {14, 27, 70, -7, 105, 372, 8, 77, 91, 7};
        execute(fileName, demoNumbers);
    }

    public static void execute(String fileName, int[] numbers) {
        // 1. Запись в файл 'f'
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : numbers) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }
            System.out.println("10 чисел успешно записаны в файл '" + fileName + "'.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл '" + fileName + "': " + e.getMessage());
            return;
        }

        // 2. Считывание из файла, вывод на экран и подсчет содержащих цифру 7
        List<Integer> readNumbers = new ArrayList<>();
        int countWithSeven = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int num = Integer.parseInt(line);
                    readNumbers.add(num);
                    if (containsDigitSeven(num)) {
                        countWithSeven++;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка чтения файла '" + fileName + "': " + e.getMessage());
            return;
        }

        System.out.println("Числа, считанные из файла:");
        System.out.println(readNumbers);
        System.out.println("Количество чисел, содержащих цифру 7: " + countWithSeven);
    }

    public static boolean containsDigitSeven(int num) {
        return String.valueOf(Math.abs(num)).contains("7");
    }
}
