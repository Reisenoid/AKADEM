package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите задачу (1-6):");
        int choice = scanner.nextInt();

        switch (choice)
        {
            case 1:
                calculateCircleArea(scanner);
                break;
            case 2:
                convertCurrency(scanner);
                break;
            case 3:
                findMaxNumber();
                break;
            case 4:
                sortAndDisplayArray();
                break;
            case 5:
                removeSpaces(scanner);
                break;
            case 6:
                checkAdult(scanner);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    // Задача 1: Вычисление площади круга
    public static void calculateCircleArea(Scanner scanner)
    {
        System.out.print("Введите радиус круга: ");
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println("Площадь круга: " + area);
    }

    // Задача 2: Конвертация валюты
    public static void convertCurrency(Scanner scanner)
    {
        System.out.print("Введите сумму в долларах: ");
        double dollars = scanner.nextDouble();
        double euros = dollars * 0.95;
        System.out.println("Сумма в евро: " + euros);
    }

    // Задача 3: Определение максимального числа
    public static void findMaxNumber()
    {
        Random random = new Random();
        int[] numbers = new int[10]; // Массив из 10 элементов

        // Заполнение массива случайными числами
        for (int i = 0; i < numbers.length; i++)
        {
            numbers[i] = random.nextInt(100); // Случайные числа от 0 до 99
        }

        // Вывод массива
        System.out.println("Сгенерированный массив: " + Arrays.toString(numbers));

        // Поиск максимального числа
        int max = numbers[0];
        for (int number : numbers)
        {
            if (number > max)
            {
                max = number;
            }
        }
        System.out.println("Максимальное число: " + max);
    }

    // Задача 4: Сортировка массива
    public static void sortAndDisplayArray() {
        int[][] array = new int[5][5];
        Random random = new Random();

        // Заполнение массива случайными числами
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                array[i][j] = random.nextInt(100); // Случайные числа от 0 до 99
            }
        }

        // Вывод исходного массива
        System.out.println("Исходный массив:");
        for (int[] row : array)
        {
            System.out.println(Arrays.toString(row));
        }

        // Сортировка каждой строки массива
        for (int[] row : array)
        {
            Arrays.sort(row);
        }

        // Вывод отсортированного массива
        System.out.println("Отсортированный массив:");
        for (int[] row : array)
        {
            System.out.println(Arrays.toString(row));
        }

        // Вывод элементов по диагонали
        System.out.println("Элементы по диагонали:");
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Элемент " + i + " в массиве " + i + ": " + array[i][i]);
        }
    }

    // Задача 5: Удаление пробелов
    public static void removeSpaces(Scanner scanner)
    {
        scanner.nextLine(); // Очистка буфера
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        String result = input.replaceAll(" ", "");
        System.out.println("Строка без пробелов: " + result);
    }

    // Задача 6: Определение возраста
    public static void checkAdult(Scanner scanner)
    {
        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        if (age >= 18)
        {
            System.out.println("Вы совершеннолетний.");
        } else
        {
            System.out.println("Вы несовершеннолетний.");
        }
    }
}