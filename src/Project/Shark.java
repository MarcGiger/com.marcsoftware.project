package Project;

import java.awt.Color;

/**
 * A simple definition of a Shark.
 * A Shark can die, (can get eaten, give birth to new Fish swarms.)
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Shark extends Animal {
    // The amount of sharks.
    private static int sumOfSharks = 0;

    /**
     * Creates a Shark.
     */
    public Shark() {
        sumOfSharks++;
    }

    /**
     * Sets the amount of Sharks to zero.
     */
    public static void resetSumOfSharks() {
        sumOfSharks = 0;
    }

    /**
     * Sets the amount of Sharks to inserted num.
     *
     * @param sumOfSharks this int is the new value of sumOfSharks.
     */
    public static void setSumOfSharks(int sumOfSharks) {
        Shark.sumOfSharks = sumOfSharks;
    }

    /**
     * Shows the amount of created Sharks. Increases with every new Shark-Object.
     *
     * @return Amount of Sharks
     */
    public static int getNumOfSharks() {
        return sumOfSharks;
    }

    /**
     * Gets the colour shown on the grid for Animal-Type Shark.
     *
     * @return colour of Shark
     */
    @Override
    public Color getColour() {
        return Color.red;
    }

    @Override
    public void swim() {

    }
}