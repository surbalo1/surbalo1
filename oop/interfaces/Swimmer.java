package interfaces;

/**
 * Swimmer interface - defines what a swimmer can do
 * Any class that implements this must define these methods
 * 
 * Note: interfaces are like contracts - they say WHAT to do,
 * not HOW to do it. The implementing class decides the how.
 */
public interface Swimmer {

    // constants (automatically public static final)
    int MAX_SWIM_SPEED = 50;
    String DEFAULT_STYLE = "Freestyle";

    // abstract methods - implementing class must define these
    void swim();

    void swim(int meters);

    int getSwimSpeed();

    boolean canSwim();

    // default methods - have implementation but can be overriden
    default void floatOnWater() {
        System.out.println("Floating on water...");
    }

    default void dive(int depth) {
        System.out.println("Diving " + depth + " meters deep");
    }

    default void race(int distance) {
        if (canSwim()) {
            System.out.println("Starting " + distance + "m race!");
            swim(distance);
            System.out.println("Race finished!");
        } else {
            System.out.println("Cant race - cant swim");
        }
    }

    // static method - belongs to interface itself
    static void showSwimmingInfo() {
        System.out.println("--- Swimmer Interface ---");
        System.out.println("Max speed: " + MAX_SWIM_SPEED + " km/h");
        System.out.println("Default style: " + DEFAULT_STYLE);
        System.out.println("-------------------------");
    }
}
