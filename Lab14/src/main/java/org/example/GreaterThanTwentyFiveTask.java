package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Вариант 19, Задание 5:
 * Создать текстовый файл 'f' с 10 целыми числами.
 * Вывести количество чисел, больших 25.
 */
public class GreaterThanTwentyFiveTask {

    public static void run(String fileName) {
        System.out.println("\n--- Задание 5: 10 целых чисел в файле и поиск чисел > 25 ---");
        int[] initialNumbers = {10, 42, 25, 7, 88, 19, 31, 26, 3, 50};

        // 1. Запись 10 чисел в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int num : initialNumbers) {
                writer.write(String.valueOf(num));
                writer.newLine();
            }
            System.out.println("Создан файл '" + fileName + "' с 10 целыми числами.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл '" + fileName + "': " + e.getMessage());
            return;
        }

        // 2. Считывание и подсчет чисел > 25
        List<Integer> readNumbers = new ArrayList<>();
        int countGreater = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int num = Integer.parseInt(line);
                    readNumbers.add(num);
                    if (num > 25) {
                        countGreater++;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла '" + fileName + "': " + e.getMessage());
            return;
        }

        System.out.println("Числа, считанные из файла:");
        System.out.println(readNumbers);
        System.out.println("Количество чисел строго больше 25: " + countGreater);
    }
}
