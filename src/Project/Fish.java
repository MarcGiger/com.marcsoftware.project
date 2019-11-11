package Project;

/**
 * A simple definition of a Fish swarm.
 * Fish swarms can die, (can get eaten, give birth to new Fish swarms.)
 *
 * @author Marc Giger
 * @version 0.1
 *
 */
public class Fish extends Animal {
    // The amount of Fish swarms.
    private static int sumOfFishSwarms;

    /**
     * Creates a Fish swarm.
     */
    public Fish() {
        super();
        this.sumOfFishSwarms++;
    }

    /**
     * Sets the amount of Fish swarms to zero.
     */
    public static void reSetSumOfFishSwarms() {
        Fish.sumOfFishSwarms = 0;
    }

    /**
     * Shows the amount of created Fish swarms. Increases with every new Fish-Object.
     * @return Amount of Fish swarms
     */
    public static int getSumOfFishSwarms() {
        return sumOfFishSwarms;
    }

}
