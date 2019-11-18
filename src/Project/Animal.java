package Project;

import java.io.Serializable;

/**
 * Animal is an abstract Superclass for animals.
 * It manages the characteristic and behaviours the all animals have in common.
 *
 * @author Marc Giger
 * @version 0.1
 */
public abstract class Animal implements Serializable, Colourful {
    // Is the animal alive?
    protected boolean alive;

    /**
     * Creates an animal and sets the status to alive.
     */
    public Animal() {
        this.alive = true;
    }

}
