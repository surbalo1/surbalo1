package animals;

/**
 * Animal class - the parent class for all animals
 * This shows: classes, objects, attributes, methods, constructors
 */
public class Animal {

    // attributes
    private String name;
    protected int age; // protected so child classes can access
    public String species; // public for demo purposes (not best practice)

    private static int animalCount = 0; // shared by all instances
    public static final String KINGDOM = "Animalia";

    // default constructor
    public Animal() {
        this.name = "Unnamed";
        this.age = 0;
        this.species = "Unknown";
        animalCount++;
        System.out.println("Animal created (default)");
    }

    // constructor with parameters
    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
        animalCount++;
        System.out.println("Animal created: " + name);
    }

    // constructor with just name
    public Animal(String name) {
        this(name, 0, "Unknown");
    }

    // methods

    public void makeSound() {
        System.out.println("*generic animal sound*");
    }

    public void showInfo() {
        System.out.println("--- Animal Info ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Species: " + species);
        System.out.println("Kingdom: " + KINGDOM);
        System.out.println("-------------------");
    }

    protected void sleep() {
        System.out.println(name + " is sleeping... zzz");
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food);
    }

    public boolean isAdult() {
        return this.age >= 1;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cant be empty");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Error: age cant be negative");
        }
    }

    // static methods

    public static int getAnimalCount() {
        return animalCount;
    }

    public static void showClassInfo() {
        System.out.println("Class: Animal");
        System.out.println("Kingdom: " + KINGDOM);
        System.out.println("Total created: " + animalCount);
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + ", age=" + age + ", species=" + species + "]";
    }
}
