package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Запустить задание с массивом (3 настолки + 2 видеоигры)");
        System.out.println("2 - Выход");
        System.out.print("Выберите действие (1 или 2): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                //массив
                Game[] games = new Game[5];

                //распределяем 3 типа BoardGame 2 типа VideoGame
                games[0] = new BoardGame("Монополия", "Экономика", 8.5, 4);
                games[1] = new BoardGame("Шахматы", "Стратегия", 9.9, 2);
                games[2] = new BoardGame("Мафия", "Детектив", 8.0, 8);
                games[3] = new VideoGame("Ведьмак 3", "RPG", 9.8, "PC");
                games[4] = new VideoGame("Need for Speed", "Гонки", 8.2, "PlayStation");

                System.out.println("\nВывод объектов из массива");
                for (int i = 0; i < games.length; i++) {
                    System.out.println("\nОбъект #" + (i + 1) + ":");

                    //общ методы
                    games[i].displayInfo();
                    games[i].play();

                    if (games[i] instanceof BoardGame) {
                        BoardGame bg = (BoardGame) games[i];
                        bg.rollDice();
                    }
                    else if (games[i] instanceof VideoGame) {
                        VideoGame vg = (VideoGame) games[i];
                        vg.saveGame();
                    }
                }
                break;

            case "2":
                System.out.println("Выход из программы.");
                break;

            default:
                System.out.println("Ошибка: введите 1 или 2!");
                break;
        }
    }
}