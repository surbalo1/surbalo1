package shapes;

/**
 * Circle class - extends Shape
 * Has to implement all the abstract methods from Shape
 */
public class Circle extends Shape {

    private double radius;

    public Circle() {
        super("Circle", "Red");
        this.radius = 1.0;
    }

    public Circle(double radius) {
        super("Circle", "Red");
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        super("Circle", color);
        this.radius = radius;
    }

    // implementing abstract methods

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius; // pi * r^2
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius; // 2 * pi * r
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + color + " circle with radius " + radius);
        // simple ascii circle
        int size = (int) Math.min(radius * 2, 8);
        for (int y = -size; y <= size; y++) {
            for (int x = -size; x <= size; x++) {
                double dist = Math.sqrt(x * x + y * y);
                if (Math.abs(dist - size) < 0.5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public void scale(double factor) {
        double oldRadius = this.radius;
        this.radius *= factor;
        System.out.println("Circle scaled: " + oldRadius + " -> " + radius);
    }

    // circle specific methods

    public double getDiameter() {
        return radius * 2;
    }

    public void increaseRadius(double amount) {
        if (amount > 0) {
            this.radius += amount;
        }
    }

    // getters setters

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    @Override
    public String toString() {
        return "Circle[r=" + radius + ", area=" + String.format("%.2f", calculateArea()) + "]";
    }
}
