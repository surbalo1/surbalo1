import animals.*;
import shapes.*;
import bank.*;
import interfaces.*;

/**
 * Main class - runs all the OOP examples
 * 
 * To compile: javac Main.java animals/*.java shapes/*.java bank/*.java
 * interfaces/*.java
 * To run: java Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("       JAVA OOP LEARNING PROJECT           ");
        System.out.println("===========================================\n");

        // Testing each concept
        testClassesAndObjects();
        testEncapsulation();
        testInheritance();
        testPolymorphism();
        testAbstraction();
        testInterfaces();

        System.out.println("\nDone! All concepts demonstrated.");
    }

    // 1. Classes and Objects
    static void testClassesAndObjects() {
        printHeader("1. CLASSES AND OBJECTS");

        Animal animal1 = new Animal(); // default constructor
        Animal animal2 = new Animal("Lion", 5, "Feline");

        animal2.showInfo();
        animal2.makeSound();

        System.out.println("Total animals created: " + Animal.getAnimalCount());
    }

    // 2. Encapsulation
    static void testEncapsulation() {
        printHeader("2. ENCAPSULATION");

        BankAccount myAccount = new BankAccount("John Smith", 1000, "Savings");
        myAccount.showInfo();

        // testing the methods
        myAccount.deposit(500);
        myAccount.withdraw(200, "0000"); // correct pin
        myAccount.withdraw(5000, "0000"); // should fail - not enough money
        myAccount.changePin("0000", "1234");
    }

    // 3. Inheritance
    static void testInheritance() {
        printHeader("3. INHERITANCE");

        Dog myDog = new Dog("Buddy", 3, "Labrador");
        myDog.showInfo();

        myDog.eat(); // overriden method
        myDog.restAfterPlaying();
        myDog.bark();
        myDog.fetchBall();
    }

    // 4. Polymorphism - same method behaves differently
    static void testPolymorphism() {
        printHeader("4. POLYMORPHISM");

        // array of Animal type but with different subclasses
        Animal[] animals = {
                new Animal("Generic", 1, "?"),
                new Dog("Rex", 4, "German Shepherd"),
                new Cat("Whiskers", 2),
                new Fish("Nemo", 1, "saltwater", "Orange")
        };

        System.out.println("Same method, different behavior:\n");
        for (Animal a : animals) {
            System.out.print(a.getClass().getSimpleName() + ": ");
            a.makeSound();
        }
    }

    // 5. Abstraction
    static void testAbstraction() {
        printHeader("5. ABSTRACTION");

        // cant do: Shape s = new Shape(); because its abstract

        Circle circle = new Circle(5, "Red");
        Rectangle rect = new Rectangle(4, 3, "Green");

        Shape[] shapes = { circle, rect };

        for (Shape s : shapes) {
            System.out.println("\n" + s.getName() + ":");
            System.out.println("  Area: " + String.format("%.2f", s.calculateArea()));
            System.out.println("  Perimeter: " + String.format("%.2f", s.calculatePerimeter()));
            s.draw();
        }
    }

    // 6. Interfaces
    static void testInterfaces() {
        printHeader("6. INTERFACES");

        Fish fish = new Fish("Dory", 2, "saltwater", "Blue");

        // fish as Animal
        fish.makeSound();
        fish.eat();

        // fish as Swimmer (interface)
        fish.swim();
        fish.swim(100);
        fish.floatOnWater();

        Swimmer.showSwimmingInfo();
    }

    // helper method to print section headers
    static void printHeader(String title) {
        System.out.println("\n");
        System.out.println("-------------------------------------------");
        System.out.println("  " + title);
        System.out.println("-------------------------------------------");
    }
}
