package animals;

/**
 * Dog class - inherits from Animal
 * Shows: inheritance, extends, super, method overriding
 */
public class Dog extends Animal {

    private String breed;
    private boolean isTrained;
    private String furColor;

    public Dog() {
        super();
        this.species = "Canine";
        this.breed = "Mixed";
        this.isTrained = false;
        this.furColor = "Brown";
        System.out.println("Dog created");
    }

    public Dog(String name, int age, String breed) {
        super(name, age, "Canine");
        this.breed = breed;
        this.isTrained = false;
        this.furColor = "Brown";
        System.out.println("Dog created: " + name);
    }

    public Dog(String name, int age, String breed, String furColor, boolean isTrained) {
        super(name, age, "Canine");
        this.breed = breed;
        this.furColor = furColor;
        this.isTrained = isTrained;
    }

    // overriding parent methods

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating dog food");
    }

    @Override
    public void showInfo() {
        super.showInfo(); // call parent method first
        System.out.println("--- Dog Extra Info ---");
        System.out.println("Breed: " + breed);
        System.out.println("Fur color: " + furColor);
        System.out.println("Trained: " + (isTrained ? "Yes" : "No"));
        System.out.println("----------------------");
    }

    // dog specific methods

    public void bark() {
        System.out.println(getName() + ": WOOF WOOF!");
    }

    public void fetchBall() {
        System.out.println(getName() + " is fetching the ball...");
        System.out.println(getName() + " got it!");
    }

    public void doTrick(String trick) {
        if (isTrained) {
            System.out.println(getName() + " does: " + trick);
        } else {
            System.out.println(getName() + " doesnt know any tricks yet");
        }
    }

    public void train() {
        System.out.println("Training " + getName() + "...");
        this.isTrained = true;
        System.out.println(getName() + " is now trained!");
    }

    public void restAfterPlaying() {
        System.out.println(getName() + " is tired");
        sleep(); // protected method from parent
    }

    // getters and setters

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "Dog[name=" + getName() + ", breed=" + breed + ", trained=" + isTrained + "]";
    }
}
