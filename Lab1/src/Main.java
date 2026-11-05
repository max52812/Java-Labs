import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер задания (1, 2 или 3):");
        String task = scanner.next();

        switch (task) {
            case "1":
                System.out.print("Введите длину ребра куба a: ");
                double a = scanner.nextDouble();

                if (a <= 0) {
                    System.out.println("Ошибка: длина ребра должна быть больше 0!");
                } else {
                    double s = 6 * a * a;
                    System.out.println("Площадь поверхности куба: " + s);
                }


            case "2":
                System.out.print("Введите первое число: ");
                double num1 = scanner.nextDouble();

                System.out.print("Введите второе число: ");
                double num2 = scanner.nextDouble();

                System.out.print("Введите операцию (+, -, *, /, %): ");
                char op = scanner.next().charAt(0);

                if (op == '+') {
                    System.out.println("Результат: " + (num1 + num2));
                } else if (op == '-') {
                    System.out.println("Результат: " + (num1 - num2));
                } else if (op == '*') {
                    System.out.println("Результат: " + (num1 * num2));
                } else if (op == '/') {
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль невозможно!");
                    } else {
                        System.out.println("Результат: " + (num1 / num2));
                    }
                } else if (op == '%') {
                    if (num2 == 0) {
                        System.out.println("Ошибка: деление на ноль невозможно!");
                    } else {
                        System.out.println("Результат: " + (num1 % num2));
                    }
                } else {
                    System.out.println("Ошибка: неизвестная операция!");
                }
                break;

            case "3":
                int secret = (int) (Math.random() * 100) + 1;
                int attempts = 0;
                int guess = 0;

                System.out.println("Число от 1 до 100 загадано. Попробуйте угадать!");

                while (guess != secret) {
                    System.out.print("Ваш вариант: ");
                    guess = scanner.nextInt();

                    if (guess < 1 || guess > 100) {
                        System.out.println("Предупреждение: число должно быть от 1 до 100!");
                        continue;
                    }

                    attempts++;

                    if (guess < secret) {
                        System.out.println("Больше!");
                    } else if (guess > secret) {
                        System.out.println("Меньше!");
                    } else {
                        System.out.println("Правильно! Попыток затрачено: " + attempts);
                    }
                }
                break;

            case "4":

                System.out.println("Выберите страну Belarus");
                String goroda = scanner.next();

                switch (goroda) {
                    case "Belarus":
                        System.out.print("Minsk");
                }
                break;

            default:
                System.out.println("Ошибка: такого задания не существует (введите 1, 2 или 3).");
                break;
        }
    }
}