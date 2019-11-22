package Project;

import java.awt.*;

/**
 * A simple definition of a Fish swarm.
 * Fish swarms can die, (can get eaten, give birth to new Fish swarms.)
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Fish extends Animal {
    // The amount of Fish swarms.
    private static int sumOfFishSwarms = 0;
    private final Color COLOUR = new Color(0,100,0);


    /**
     * Creates a Fish swarm.
     */
    public Fish() {
        sumOfFishSwarms++;
    }

    /**
     * Sets the amount of Fish swarms to zero.
     */
    public static void resetSumOfFishSwarms() {
        sumOfFishSwarms = 0;
    }

    /**
     * Sets the amount of Fish swarms to inserted num.
     *
     * @param sumOfFishSwarms this int is the new value of sumOfFishSwarms.
     */
    public static void setSumOfFishSwarms(int sumOfFishSwarms) {
        Fish.sumOfFishSwarms = sumOfFishSwarms;
    }

    /**
     * Shows the amount of created Fish swarms. Increases with every new Fish-Object.
     *
     * @return Amount of Fish swarms
     */
    public static int getSumOfFishSwarms() {
        return sumOfFishSwarms;
    }

    /**
     * Gets the colour shown on the grid for Animal-Type Fish.
     *
     * @return colour of Fish.
     */
    @Override
    public Color getColour() {
        return COLOUR;
    }

@Override
    public void swim() {
    }
}



