public class Circle implements Shape
{
    private double radius;

    // Конструктор
    public Circle(double radius)
    {
        if (radius <= 0)
        {
            throw new IllegalArgumentException("Радиус должен быть положительным числом.");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        return "Круг [радиус=" + radius + "]";
    }
}