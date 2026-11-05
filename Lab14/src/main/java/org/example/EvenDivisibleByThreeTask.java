package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Вариант 19, Задание 3:
 * Создать текстовый файл 'f' со случайными целыми числами.
 * Записать в файл 'g' все числа, являющиеся чётными и кратными 3,
 * а в файл 'h' – все остальные.
 */
public class EvenDivisibleByThreeTask {

    public static void run(String fName, String gName, String hName, int count) {
        System.out.println("\n--- Задание 3: Разделение чисел из 'f' в 'g' и 'h' ---");
        System.out.println("Критерий для файла 'g': чётное И кратное 3 (т.е. делится на 6).");

        // 1. Генерация случайных чисел и запись в файл 'f'
        Random random = new Random();
        try (BufferedWriter writerF = new BufferedWriter(new FileWriter(fName))) {
            for (int i = 0; i < count; i++) {
                int val = random.nextInt(100) + 1; // 1 .. 100
                writerF.write(String.valueOf(val));
                writerF.newLine();
            }
            System.out.println("Сгенерировано и записано " + count + " случайных чисел в '" + fName + "'.");
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл '" + fName + "': " + e.getMessage());
            return;
        }

        // 2. Считывание из 'f' и распределение по 'g' и 'h'
        List<Integer> allF = new ArrayList<>();
        List<Integer> listG = new ArrayList<>();
        List<Integer> listH = new ArrayList<>();

        try (BufferedReader readerF = new BufferedReader(new FileReader(fName));
             BufferedWriter writerG = new BufferedWriter(new FileWriter(gName));
             BufferedWriter writerH = new BufferedWriter(new FileWriter(hName))) {

            String line;
            while ((line = readerF.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int num = Integer.parseInt(line);
                    allF.add(num);
                    if (num % 2 == 0 && num % 3 == 0) {
                        writerG.write(String.valueOf(num));
                        writerG.newLine();
                        listG.add(num);
                    } else {
                        writerH.write(String.valueOf(num));
                        writerH.newLine();
                        listH.add(num);
                    }
                }
            }
            System.out.println("Файлы '" + gName + "' и '" + hName + "' успешно сформированы.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка обработки файлов: " + e.getMessage());
            return;
        }

        // 3. Вывод результатов для наглядности
        System.out.println("Исходные числа в файле 'f' (" + allF.size() + " шт.): " + allF);
        System.out.println("Чётные и кратные 3 в файле 'g' (" + listG.size() + " шт.): " + listG);
        System.out.println("Все остальные числа в файле 'h' (" + listH.size() + " шт.): " + listH);
    }
}
