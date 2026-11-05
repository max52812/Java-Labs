import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание:");
        System.out.println("1 - Разница между max и min в одномерном массиве");
        System.out.println("2 - Max и min в матрице (с учетом суммы индексов)");
        System.out.print("Ваш выбор: ");

        // введен ли вообще номер задания числом
        if (!scanner.hasNextInt()) {
            System.out.println("Ошибка: нужно ввести число (1 или 2)!");
            return;
        }

        int task = scanner.nextInt();

        switch (task) {
            case 1:
                // 1 найти разницу между макс и мин элементом
                System.out.print("Введите размер массива: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: размер массива должен быть целым числом!");
                    return;
                }
                int n = scanner.nextInt();

                // массив не может быть нулевой или отрицательной длины
                if (n <= 0) {
                    System.out.println("Ошибка: размер массива должен быть больше 0!");
                    break;
                }

                int[] arr = new int[n];
                System.out.println("Введите " + n + " элементов массива через пробел или Enter:");
                for (int i = 0; i < arr.length; i++) {
                    if (!scanner.hasNextInt()) {
                        System.out.println("Ошибка: введено не число!");
                        return;
                    }
                    arr[i] = scanner.nextInt();
                }

                // поиск макс и мин
                int min = Integer.MAX_VALUE;
                int max = arr[0];

                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                }

                System.out.println("Максимальный элемент: " + max);
                System.out.println("Минимальный элемент: " + min);
                System.out.println("Разница (max - min): " + (max - min));
                break;

            case 2:
                // 2 в квадратной матрице определить мин и макс.
                System.out.print("Введите размер квадратной матрицы N: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: размер матрицы должен быть целым числом!");
                    return;
                }
                int size = scanner.nextInt();

                // правильность размера
                if (size <= 0) {
                    System.out.println("Ошибка: размер матрицы должен быть больше 0!");
                    break;
                }

                int[][] matrix = new int[size][size];
                System.out.println("Введите элементы матрицы (" + (size * size) + " чисел):");
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (!scanner.hasNextInt()) {
                            System.out.println("Ошибка: введено не число!");
                            return;
                        }
                        matrix[i][j] = scanner.nextInt();
                    }
                }

                // начальные значения берем с первого элемента 00
                int maxVal = matrix[0][0], maxRow = 0, maxCol = 0;
                int minVal = matrix[0][0], minRow = 0, minCol = 0;

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        // поиск макс: число строго больше текущего max, либо число равно max, но сумма индексов (i + j) больше
                        if (matrix[i][j] > maxVal) {
                            maxVal = matrix[i][j];
                            maxRow = i;
                            maxCol = j;
                        } else if (matrix[i][j] == maxVal && (i + j) > (maxRow + maxCol)) {
                            maxRow = i;
                            maxCol = j;
                        }

                        // поиск мин: число строго меньше текущего min, либо число равно min, но сумма индексов (i + j) меньше
                        if (matrix[i][j] < minVal) {
                            minVal = matrix[i][j];
                            minRow = i;
                            minCol = j;
                        } else if (matrix[i][j] == minVal && (i + j) < (minRow + minCol)) {
                            minRow = i;
                            minCol = j;
                        }
                    }
                }

                System.out.println("\nРезультат:");
                System.out.println("Максимум: " + maxVal + " на индексе [" + maxRow + "][" + maxCol + "] (сумма индексов: " + (maxRow + maxCol) + ")");
                System.out.println("Минимум: " + minVal + " на индексе [" + minRow + "][" + minCol + "] (сумма индексов: " + (minRow + minCol) + ")");
                break;

            default:
                System.out.println("Ошибка: такого задания нет (выберите 1 или 2).");
                break;
        }
    }
}