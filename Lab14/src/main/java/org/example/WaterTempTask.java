package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Вариант 19, Задание 4:
 * Ввести с клавиатуры в файл 12 вещественных значений температуры воды.
 * Считать данные и вывести среднюю температуру.
 */
public class WaterTempTask {

    public static void runInteractive(String fileName, Scanner scanner) {
        System.out.println("\n--- Задание 4: Ввод 12 значений температуры воды ---");
        double[] temps = new double[12];
        System.out.println("Введите 12 вещественных значений температуры (например: 18.5 или 19,2):");
        for (int i = 0; i < 12; i++) {
            System.out.print("Температура [" + (i + 1) + "]: ");
            while (true) {
                String input = scanner.next().replace(',', '.');
                try {
                    temps[i] = Double.parseDouble(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное число! Повторите ввод для [" + (i + 1) + "]:");
                }
            }
        }
        scanner.nextLine(); // очистить перевод строки

        execute(fileName, temps);
    }

    public static void runDemo(String fileName) {
        System.out.println("\n--- Задание 4 (Демо): 12 значений температуры воды ---");
        double[] demoTemps = {18.2, 18.5, 19.0, 19.8, 20.4, 21.0, 21.5, 20.8, 19.9, 19.1, 18.7, 18.1};
        execute(fileName, demoTemps);
    }

    public static void execute(String fileName, double[] temps) {
        // 1. Запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (double t : temps) {
                writer.write(String.format(Locale.US, "%.2f", t));
                writer.newLine();
            }
            System.out.println("12 значений температуры воды успешно записаны в '" + fileName + "'.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл '" + fileName + "': " + e.getMessage());
            return;
        }

        // 2. Считывание и расчет средней температуры
        List<Double> readTemps = new ArrayList<>();
        double sum = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    double val = Double.parseDouble(line.replace(',', '.'));
                    readTemps.add(val);
                    sum += val;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла '" + fileName + "': " + e.getMessage());
            return;
        }

        System.out.println("Считанные значения температур: " + readTemps);
        if (!readTemps.isEmpty()) {
            double average = sum / readTemps.size();
            System.out.printf(Locale.US, "Средняя температура воды: %.2f °C\n", average);
        } else {
            System.out.println("Файл пуст, невозможно рассчитать среднюю температуру.");
        }
    }
}
