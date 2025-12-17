package animals;

/**
 * Cat class - another child of Animal
 * Similar to Dog but with cat-specific behavior
 */
public class Cat extends Animal {

    private String eyeColor;
    private boolean isStray;
    private int livesRemaining; // cats have 9 lives lol

    public Cat() {
        super();
        this.species = "Feline";
        this.eyeColor = "Green";
        this.isStray = false;
        this.livesRemaining = 9;
        System.out.println("Cat created");
    }

    public Cat(String name, int age) {
        super(name, age, "Feline");
        this.eyeColor = "Green";
        this.isStray = false;
        this.livesRemaining = 9;
    }

    public Cat(String name, int age, String eyeColor, boolean isStray) {
        super(name, age, "Feline");
        this.eyeColor = eyeColor;
        this.isStray = isStray;
        this.livesRemaining = 9;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating fish");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("--- Cat Extra Info ---");
        System.out.println("Eye color: " + eyeColor);
        System.out.println("Stray: " + (isStray ? "Yes" : "No"));
        System.out.println("Lives left: " + livesRemaining + "/9");
        System.out.println("----------------------");
    }

    // cat methods

    public void meow() {
        System.out.println(getName() + ": MEOW!");
    }

    public void purr() {
        System.out.println(getName() + " is purring... purrr");
    }

    public void huntMouse() {
        System.out.println(getName() + " is hunting a mouse...");
        System.out.println("Got it!");
    }

    public void climb() {
        System.out.println(getName() + " is climbing a tree");
    }

    public void loseLife() {
        if (livesRemaining > 0) {
            livesRemaining--;
            System.out.println(getName() + " lost a life! " + livesRemaining + " left");
        } else {
            System.out.println(getName() + " is out of lives :(");
        }
    }

    public void adopt() {
        if (isStray) {
            this.isStray = false;
            System.out.println(getName() + " got adopted!");
        } else {
            System.out.println(getName() + " already has a home");
        }
    }

    // getters

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String c) {
        this.eyeColor = c;
    }

    public boolean isStray() {
        return isStray;
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    @Override
    public String toString() {
        return "Cat[name=" + getName() + ", eyes=" + eyeColor + ", lives=" + livesRemaining + "]";
    }
}
