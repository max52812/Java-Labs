import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static class Employee {
        String fullname;
        double salary;

        Employee(String fullname, double salary) {
            this.fullname = fullname;
            this.salary = salary;
        }
    }

    static class Report {
        public static void generateReport(Employee[] employees) {
            System.out.printf("%-15s %10s%n", "ФИО", "Оклад");
            for (Employee emp : employees) {
                // %-15s 15 символов по левому краю
                // %10.2f по правому краю, 2 знака после ,
                System.out.printf("%-15s %10.2f%n", emp.fullname, emp.salary);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Задание 1");
        System.out.println("2 - Задание 2");
        System.out.println("3 - Задание 3");
        System.out.println("4 - Задание 4");
        System.out.print("Выберите номер задания (1-4): ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                // З1 извл подстроку с 0 по 4 символ
                System.out.print("Введите строку (минимум 4 символа): ");
                String str = scanner.nextLine();

                if (str.length() < 4) {
                    System.out.println("Ошибка: длина строки должна быть не менее 4 символов!");
                } else {
                    String sub = str.substring(0, 4);
                    System.out.println("Результат (первые 4 символа): " + sub);
                }
                break;

            case "2":
                // З2 подсчитать кол во слов в предложении
                System.out.print("Введите предложение: ");
                String sentence = scanner.nextLine().trim();

                if (sentence.isEmpty()) {
                    System.out.println("Количество слов: 0");
                } else {
                    // разделение по пробелам
                    String[] words = sentence.split("\\s+");
                    System.out.println("Количество слов: " + words.length);
                }
                break;

            case "3":
                // З3 Класс Employee, массив и метод Report.generateReport
                Employee[] staff = {
                        new Employee("Иванов И.И.", 1450.50),
                        new Employee("Петров П.П.", 920.00),
                        new Employee("Сидоров С.С.", 2300.75)
                };

                System.out.println("Сформированный отчет:");
                Report.generateReport(staff);
                break;

            case "4":
                // З4 по краям а, между ними только цифры, но не больше 3
                String text = "a1a a12a a173a a1234a a12345a";
                System.out.println("Исходная строка: " + text);

                // [aа] англ и русск а
                // \\d{1,3} от 1 до 3
                Pattern pattern = Pattern.compile("[aа][13579]+[aа]");
                Matcher matcher = pattern.matcher(text);

                System.out.println("Найденные совпадения:");
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
                break;

            default:
                System.out.println("Ошибка: неверный пункт меню (введите число от 1 до 4).");
                break;
        }
    }
}