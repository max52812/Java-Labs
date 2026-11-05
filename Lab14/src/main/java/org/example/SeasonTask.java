package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Вариант 19, Задание 1:
 * Создать файл с информацией о своём любимом времени года.
 * Вывести данные об этом файле. Вывести информацию из файла.
 */
public class SeasonTask {

    public static void run(String filePath) {
        System.out.println("\n--- Задание 1: Информация о любимом времени года ---");
        File file = new File(filePath);

        // 1. Создаем файл и записываем информацию
        String seasonText = "Любимое время года: Осень (Золотая осень).\n" +
                "Осень — прекрасная пора года с чистым прохладным воздухом, багряными и золотыми листьями.\n" +
                "В это время года приятно гулять по паркам, наблюдать за природой и пить горячий чай в уютной обстановке.\n" +
                "Осень вдохновляет на творчество, размышления и новые начинания.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(seasonText);
            System.out.println("Файл успешно создан и заполнен: " + file.getName());
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        // 2. Выводим данные (метаданные) об этом файле
        System.out.println("\n[Метаданные файла]:");
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Существует: " + (file.exists() ? "Да" : "Нет"));
        System.out.println("Доступен для чтения: " + (file.canRead() ? "Да" : "Нет"));
        System.out.println("Доступен для записи: " + (file.canWrite() ? "Да" : "Нет"));
        System.out.println("Это обычный файл: " + (file.isFile() ? "Да" : "Нет"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Дата последней модификации: " + sdf.format(new Date(file.lastModified())));

        // 3. Выводим содержимое файла
        System.out.println("\n[Содержимое файла]:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
