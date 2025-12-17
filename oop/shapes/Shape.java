package shapes;

/**
 * Shape class - abstract class (cant instantiate directly)
 * Child classes must implement the abstract methods
 */
public abstract class Shape {

    protected String name;
    protected String color;
    protected double positionX;
    protected double positionY;

    public Shape() {
        this.name = "Shape";
        this.color = "Black";
        this.positionX = 0;
        this.positionY = 0;
    }

    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
        this.positionX = 0;
        this.positionY = 0;
    }

    // abstract methods - no body, child classes must implement these
    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    public abstract void draw();

    public abstract void scale(double factor);

    // concrete methods - have implementation
    public void showInfo() {
        System.out.println("--- Shape Info ---");
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Position: (" + positionX + ", " + positionY + ")");
        System.out.println("------------------");
    }

    public void move(double dx, double dy) {
        this.positionX += dx;
        this.positionY += dy;
        System.out.println(name + " moved to (" + positionX + ", " + positionY + ")");
    }

    public void changeColor(String newColor) {
        String old = this.color;
        this.color = newColor;
        System.out.println(name + " color changed from " + old + " to " + newColor);
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    @Override
    public String toString() {
        return name + "[color=" + color + ", pos=(" + positionX + "," + positionY + ")]";
    }
}
