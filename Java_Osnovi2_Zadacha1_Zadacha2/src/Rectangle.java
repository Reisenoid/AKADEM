public class Rectangle implements Shape
{
    private double width;
    private double height;

    // Конструктор
    public Rectangle(double width, double height)
    {
        if (width <= 0 || height <= 0)
        {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea()
    {
        return width * height;
    }

    @Override
    public double calculatePerimeter()
    {
        return 2 * (width + height);
    }

    @Override
    public String toString()
    {
        return "Прямоугольник [ширина=" + width + ", высота=" + height + "]";
    }
}