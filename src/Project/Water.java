package Project;

import java.awt.Color;

/**
 * A simple definition of Water.
 * <p>
 * Note: I am not proud on this class yet, as it should run under environment and not under animal.
 * (But as the program is not developed that far, it has to stick with animal)
 * Class Water got created due to the fact, that loading Arrays with null in it causes troubles.
 *
 * @author Marc Giger
 * @version 0.1
 */


public class Water extends Animal {
    private final Color COLOUR = Color.blue;

    /**
     * Creates a water field. Water is not an animal, therefore is not alive.
     */
    public Water() {
        alive = false;
    }

    @Override
    public String toString() {
        return "Water";
    }

    /**
     * Gets the colour shown on the grid for Animal-Type Water.
     *
     * @return colour of Water
     */
    @Override
    public Color getColour() {
        return COLOUR;
    }


    @Override
    public void swim() {
    }
}

