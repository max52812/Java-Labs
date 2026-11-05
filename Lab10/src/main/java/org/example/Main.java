package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Выполнить задание: 3 футболиста и 2 пловца (массив интерфейсного типа)");
        System.out.println("2 - Добавить спортсмена вручную с клавиатуры");
        System.out.println("3 - Выход");
        System.out.print("Выберите пункт меню (1, 2 или 3): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("\nВызов статического метода интерфейса");
                Athlete.showMotivation();

                //массив интерфейс
                Athlete[] athletes = new Athlete[5];

                athletes[0] = new FootballPlayer("Лионель Месси", "Интер Майами", 25);
                athletes[1] = new FootballPlayer("Криштиану Роналду", "Аль-Наср", 35);
                athletes[2] = new FootballPlayer("Килиан Мбаппе", "Реал Мадрид", 28);
                athletes[3] = new Swimmer("Майкл Фелпс", "США", 28);
                athletes[4] = new Swimmer("Александр Попов", "Россия", 6);

                System.out.println("\nОбход массива интерфейсного типа Athlete[] и тренировка спортсменов");
                for (int i = 0; i < athletes.length; i++) {
                    System.out.println("\n[Спортсмен #" + (i + 1) + "]");

                    // методы перв интерфейса
                    athletes[i].train();
                    athletes[i].compete();
                    System.out.println("Результаты: " + athletes[i].getResults());

                    //проверка и методы втор интерфейса
                    if (athletes[i] instanceof TeamPlayer) {
                        TeamPlayer teamPlayer = (TeamPlayer) athletes[i];
                        teamPlayer.playWithTeam();
                        System.out.println("Команда игрока: " + teamPlayer.getTeam());
                    }
                }
                break;

            case "2":
                System.out.println("\nКого вы хотите создать?");
                System.out.println("1 - Футболиста (FootballPlayer)");
                System.out.println("2 - Пловца (Swimmer)");
                System.out.print("Ваш выбор: ");
                String typeChoice = scanner.nextLine();

                System.out.print("Введите имя спортсмена: ");
                String name = scanner.nextLine();

                System.out.print("Введите название команды / сборной: ");
                String team = scanner.nextLine();

                if (typeChoice.equals("1")) {
                    System.out.print("Введите количество забитых голов: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: количество голов должно быть целым числом!");
                        break;
                    }
                    int goals = scanner.nextInt();
                    if (goals < 0) {
                        System.out.println("Ошибка: голы не могут быть отрицательными!");
                        break;
                    }
                    FootballPlayer fp = new FootballPlayer(name, team, goals);
                    System.out.println("\nСпортсмен успешно создан");
                    fp.displayInfo();
                    fp.train();
                    fp.playWithTeam();

                } else if (typeChoice.equals("2")) {
                    System.out.print("Введите количество установленных рекордов: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: количество рекордов должно быть целым числом!");
                        break;
                    }
                    int records = scanner.nextInt();
                    if (records < 0) {
                        System.out.println("Ошибка: рекорды не могут быть отрицательными!");
                        break;
                    }
                    Swimmer sw = new Swimmer(name, team, records);
                    System.out.println("\nСпортсмен успешно создан");
                    sw.displayInfo();
                    sw.train();
                    sw.playWithTeam();

                } else {
                    System.out.println("Ошибка: неверный выбор типа спортсмена!");
                }
                break;

            case "3":
                System.out.println("Выход из программы.");
                break;

            default:
                System.out.println("Ошибка: выбран несуществующий пункт меню (введите 1, 2 или 3)!");
                break;
        }
    }
}
