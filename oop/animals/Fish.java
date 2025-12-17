package animals;

import interfaces.Swimmer;

/**
 * Fish class - inherits Animal AND implements Swimmer interface
 * This shows you can do both at the same time
 */
public class Fish extends Animal implements Swimmer {

    private String waterType; // freshwater or saltwater
    private String scaleColor;
    private int swimSpeed;
    private boolean isVenomous;

    public Fish() {
        super();
        this.species = "Fish";
        this.waterType = "freshwater";
        this.scaleColor = "Silver";
        this.swimSpeed = 20;
        this.isVenomous = false;
        System.out.println("Fish created");
    }

    public Fish(String name, int age, String waterType, String scaleColor) {
        super(name, age, "Fish");
        this.waterType = waterType;
        this.scaleColor = scaleColor;
        this.swimSpeed = 20;
        this.isVenomous = false;
    }

    // overriding Animal methods

    @Override
    public void makeSound() {
        System.out.println("*blub blub blub*");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating fish food");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("--- Fish Extra Info ---");
        System.out.println("Water: " + waterType);
        System.out.println("Color: " + scaleColor);
        System.out.println("Speed: " + swimSpeed + " km/h");
        System.out.println("Venomous: " + (isVenomous ? "Yes!" : "No"));
        System.out.println("-----------------------");
    }

    // implementing Swimmer interface methods (required)

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming");
    }

    @Override
    public void swim(int meters) {
        System.out.println(getName() + " swam " + meters + " meters");
    }

    @Override
    public int getSwimSpeed() {
        return swimSpeed;
    }

    @Override
    public boolean canSwim() {
        return true; // fish can always swim
    }

    @Override
    public void floatOnWater() {
        System.out.println(getName() + " is floating using swim bladder");
    }

    // fish specific methods

    public void makeBubbles() {
        System.out.println(getName() + " is making bubbles: o o O o");
    }

    public void moveFins() {
        System.out.println(getName() + " moves its fins");
    }

    public void hide() {
        System.out.println(getName() + " hides in the rocks");
    }

    // getters and setters

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String t) {
        this.waterType = t;
    }

    public String getScaleColor() {
        return scaleColor;
    }

    public void setScaleColor(String c) {
        this.scaleColor = c;
    }

    public void setSwimSpeed(int s) {
        this.swimSpeed = s;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean v) {
        this.isVenomous = v;
    }

    @Override
    public String toString() {
        return "Fish[name=" + getName() + ", water=" + waterType + ", color=" + scaleColor + "]";
    }
}
