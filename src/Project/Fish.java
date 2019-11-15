package Project;

import java.awt.*;

/**
 * A simple definition of a Fish swarm.
 * Fish swarms can die, (can get eaten, give birth to new Fish swarms.)
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Fish extends Animal implements Colourful {
    // The amount of Fish swarms.
    private static int sumOfFishSwarms = 0;

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


    @Override
    public Color getColor() {
        return new Color(0, 100, 0);
    }
}



