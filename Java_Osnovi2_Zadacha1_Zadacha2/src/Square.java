public class Square implements Shape
{
    private double side;

    // Конструктор
    public Square(double side)
    {
        if (side <= 0)
        {
            throw new IllegalArgumentException("Сторона квадрата должна быть положительным числом.");
        }
        this.side = side;
    }

    @Override
    public double calculateArea()
    {
        return side * side;
    }

    @Override
    public double calculatePerimeter()
    {
        return 4 * side;
    }

    @Override
    public String toString()
    {
        return "Квадрат [сторона=" + side + "]";
    }
}