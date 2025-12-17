package shapes;

/**
 * Rectangle class - extends Shape
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle() {
        super("Rectangle", "Blue");
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height, String color) {
        super("Rectangle", color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + color + " rectangle " + width + "x" + height);
        int w = (int) Math.min(width * 2, 12);
        int h = (int) Math.min(height, 5);

        // top border
        for (int i = 0; i < w + 2; i++)
            System.out.print("-");
        System.out.println();

        // middle
        for (int i = 0; i < h; i++) {
            System.out.print("|");
            for (int j = 0; j < w; j++)
                System.out.print(" ");
            System.out.println("|");
        }

        // bottom border
        for (int i = 0; i < w + 2; i++)
            System.out.print("-");
        System.out.println();
    }

    @Override
    public void scale(double factor) {
        this.width *= factor;
        this.height *= factor;
        System.out.println("Rectangle scaled to " + width + "x" + height);
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    public boolean isSquare() {
        return width == height;
    }

    // getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Rectangle[" + width + "x" + height + ", area=" + calculateArea() + "]";
    }
}
