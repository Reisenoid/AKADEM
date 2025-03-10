package org.example;


import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        while (continueCalculation)
        {
            // Запрос первого числа
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            // Запрос второго числа
            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            // Запрос операции
            System.out.print("Введите операцию (+, -, *, /): ");
            char operation = scanner.next().charAt(0);

            // Выполнение операции и вывод результата
            double result = 0;
            boolean error = false;

            switch (operation)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                    {
                        result = num1 / num2;
                    } else
                    {
                        System.out.println("Ошибка: Деление на ноль невозможно.");
                        error = true;
                    }
                    break;
                default:
                    System.out.println("Ошибка: Неверная операция.");
                    error = true;
            }

            if (!error)
            {
                System.out.println("Результат: " + result);
            }

            // Запрос о продолжении работы
            System.out.print("Хотите продолжить? (да/нет): ");
            String choice = scanner.next();

            if (!choice.equalsIgnoreCase("да"))
            {
                continueCalculation = false;
            }
        }

        System.out.println("Программа завершена.");
        scanner.close();
    }
}