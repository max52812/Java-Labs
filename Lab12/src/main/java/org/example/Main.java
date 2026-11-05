package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Задание 1: Коллекция Map<String, FoodItem> (Еда)");
        System.out.println("2 - Задание 2: Список List<Park> и операции фильтрации/сортировки");
        System.out.println("3 - Выход");
        System.out.print("Выберите пункт меню (1, 2 или 3): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("\nЗ1: Map<String, FoodItem>");
                // коллекция с назв еды как ключи
                Map<String, FoodItem> foodMap = new LinkedHashMap<>();

                foodMap.put("Пепперони", new Pizza("Пепперони", 101, 850, "Колбаски, моцарелла, томатный соус"));
                foodMap.put("Маргарита", new Pizza("Маргарита", 102, 720, "Моцарелла, базилик, томаты"));
                foodMap.put("Четыре сыра", new Pizza("Четыре сыра", 103, 910, "Пармезан, дорблю, чеддер, моцарелла"));

                foodMap.put("Цезарь", new Salad("Цезарь", 201, 380, "Соус цезарь с анчоусами"));
                foodMap.put("Греческий", new Salad("Греческий", 202, 290, "Оливковое масло и орегано"));
                foodMap.put("Оливье", new Salad("Оливье", 203, 450, "Домашний майонез"));

                foodMap.put("Тирамису", new Dessert("Тирамису", 301, 520, 35.5));
                foodMap.put("Чизкейк", new Dessert("Чизкейк", 302, 480, 28.0));

                System.out.println("Все элементы коллекции Map (Ключ -> Значение):");
                int index = 1;
                for (Map.Entry<String, FoodItem> entry : foodMap.entrySet()) {
                    System.out.println(index++ + ". Ключ: [" + entry.getKey() + "] -> Значение: " + entry.getValue());
                }
                break;

            case "2":
                System.out.println("\nЗ2: List<Park> и операции с коллекцией");
                List<Park> parks = new ArrayList<>();

                // список парков
                parks.add(new Park(1, "Центральный парк", "Минск", 4, Arrays.asList(5, 5, 4, 5)));       // ср. 4.75 (>=4)
                parks.add(new Park(2, "Парк Победы", "Минск", 4, Arrays.asList(4, 5, 4, 4)));           // ср. 4.25 (>=4)
                parks.add(new Park(3, "Старый сквер", "Брест", 2, Arrays.asList(2, 2, 3, 2)));          // ср. 2.25 (<3, будет удален)
                parks.add(new Park(4, "Приозёрный парк", "Гродно", 3, Arrays.asList(3, 4, 3, 3)));       // ср. 3.25
                parks.add(new Park(5, "Заброшенный парк", "Гомель", 1, Arrays.asList(1, 2, 2, 1)));       // ср. 1.50 (<3, будет удален)
                parks.add(new Park(6, "Ботанический сад", "Минск", 4, Arrays.asList(5, 5, 5, 5)));      // ср. 5.00 (>=4)
                parks.add(new Park(7, "Александровский парк", "Витебск", 3, Arrays.asList(4, 4, 4, 5))); // ср. 4.25 (>=4, такое же как у Парка Победы для проверки сортировки)

                System.out.println("Исходный список парков:");
                for (Park p : parks) {
                    System.out.println("  " + p);
                }

                // удалить парки
                System.out.println("\n1. Удаляем парки со средним рейтингом < 3:");
                Iterator<Park> iterator = parks.iterator();
                while (iterator.hasNext()) {
                    Park p = iterator.next();
                    if (p.getAverageRating() < 3.0) {
                        System.out.println("   Удален: " + p.getName() + " (ср. балл: " + String.format("%.2f", p.getAverageRating()) + ")");
                        iterator.remove();
                    }
                }

                // повысить ретинг
                System.out.println("\n2. Повышаем рейтинг (на +1, максимум 5) для парков со средним рейтингом >= 4:");
                for (Park p : parks) {
                    if (p.getAverageRating() >= 4.0) {
                        int oldRating = p.getRating();
                        if (oldRating < 5) {
                            p.setRating(oldRating + 1);
                            System.out.println("   " + p.getName() + ": рейтинг повышен с " + oldRating + " до " + p.getRating());
                        } else {
                            System.out.println("   " + p.getName() + ": уже имеет максимальный рейтинг 5");
                        }
                    }
                }

                System.out.println("\n3. Демонстрация метода printParks(parks, 5):");
                Park.printParks(parks, 5);

                // по убыванию среднего балла
                System.out.println("\n4. Упорядочивание: по убыванию ср. балла, затем по алфавиту имени:");
                parks.sort(new Comparator<Park>() {
                    @Override
                    public int compare(Park p1, Park p2) {
                        int cmp = Double.compare(p2.getAverageRating(), p1.getAverageRating()); // убывание
                        if (cmp != 0) {
                            return cmp;
                        }
                        return p1.getName().compareTo(p2.getName()); // алфавит (возрастание)
                    }
                });

                System.out.println("Результат сортировки (ID, Имя, Средний балл):");
                for (Park p : parks) {
                    System.out.printf("   ID: %-2d | %-24s | Средний балл: %.2f%n",
                            p.getId(), p.getName(), p.getAverageRating());
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
