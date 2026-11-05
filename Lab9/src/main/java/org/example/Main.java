package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Запустить задание: 3 певца и 2 танцора (вывести награды и выступления)");
        System.out.println("2 - Проверить, почему нельзя создать new Artist()");
        System.out.print("Выберите пункт (1 или 2): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // массив абстракт
                Artist[] artists = new Artist[5];

                //создаем 3 Singer и 2 Dancer
                artists[0] = new Singer("Фредди Меркьюри", 45, "Рок", "Тенор");
                artists[1] = new Singer("Адель", 35, "Поп / Соул", "Меццо-сопрано");
                artists[2] = new Singer("Лучано Паваротти", 71, "Опера", "Драматический тенор");
                artists[3] = new Dancer("Майкл Джексон", 50, "Поп-дэнс", "Moonwalk / Брейк");
                artists[4] = new Dancer("Михаил Барышников", 76, "Классика", "Балет");

                System.out.println("\nПолиморфный обход массива Artist[]");
                for (int i = 0; i < artists.length; i++) {
                    System.out.println("\n[Артист #" + (i + 1) + "]");
                    //вывода информации
                    artists[i].displayInfo();

                    // полиморф вызов абстракт метода perform()
                    artists[i].perform();

                    // вывод наград
                    System.out.println("Награды артиста: " + artists[i].getAwards());
                }
                break;

            case "2":
                System.out.println("Попытка выполнить: Artist a = new Artist(\"Безымянный\", 20, \"Жанр\");");
                System.out.println("Результат: ОШИБКА КОМПИЛЯЦИИ: 'Artist is abstract; cannot be instantiated'.");
                System.out.println("Пояснение: Абстрактный класс — это незаконченная заготовка, его объект создать в памяти невозможно!");

                // Раскомментирование строки ниже не даст коду скомпилироваться:
                // Artist test = new Artist("Максим", 18, "Шоу");
                break;

            default:
                System.out.println("Ошибка: неверный пункт меню!");
                break;
        }

        scanner.close();
    }
}