package Project;

import java.awt.Color;

/**
 * Colourful is an Interface for animals.
 * It contains the following method: getColour
 *
 * @author Marc Giger
 * @version 0.1
 */

public interface Colourful {
    /**
     * This method gets the colour shown on the grid in respect of the animal-type. To ease differentiation animal background colours vary.
     */
    Color getColour();
}
