import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadacha2
{
    public static void main(String[] args)
    {
        List<Shape> shapes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("Выберите тип фигуры (круг, квадрат, прямоугольник) или введите 'хватит' для завершения:");
            String shapeType = scanner.nextLine();

            if (shapeType.equalsIgnoreCase("хватит"))
            {
                break;
            }

            try
            {
                switch (shapeType.toLowerCase())
                {
                    case "круг":
                        System.out.print("Введите радиус круга: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                        shapes.add(new Circle(radius));
                        break;
                    case "квадрат":
                        System.out.print("Введите сторону квадрата: ");
                        double side = Double.parseDouble(scanner.nextLine());
                        shapes.add(new Square(side));
                        break;
                    case "прямоугольник":
                        System.out.print("Введите ширину прямоугольника: ");
                        double width = Double.parseDouble(scanner.nextLine());
                        System.out.print("Введите высоту прямоугольника: ");
                        double height = Double.parseDouble(scanner.nextLine());
                        shapes.add(new Rectangle(width, height));
                        break;
                    default:
                        System.out.println("Неизвестный тип фигуры: " + shapeType);
                }
            } catch (NumberFormatException e)
            {
                System.out.println("Ошибка: Введено некорректное число.");
            } catch (IllegalArgumentException e)
            {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        // Вывод площади и периметра для каждой фигуры
        System.out.println("\nРезультаты:");
        for (Shape shape : shapes)
        {
            System.out.println(shape);
            System.out.println("Площадь: " + shape.calculateArea());
            System.out.println("Периметр: " + shape.calculatePerimeter());
            System.out.println();
        }

        scanner.close();
    }
}