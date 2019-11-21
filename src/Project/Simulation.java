package Project;

import java.util.Random;

/**
 * http://www.cburch.com/proj/jett/05/handouts/hunt/
 * A Simulation class for the interaction of animal stock
 * <p>
 * (not configurated so far)
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Simulation {
    private final Random rand = new Random();

    /**
     * The number of directions available (8).
     */
    public static final int NUM_DIRECTIONS = 8;

    /**
     * The north direction.
     */
    public static final Simulation NORTH = new Simulation("north", 0, 1);

    /**
     * The northeast direction.
     */
    public static final Simulation NORTHEAST = new Simulation("northeast", 1, 1);

    /**
     * The east direction.
     */
    public static final Simulation EAST = new Simulation("east", 1, 0);

    /**
     * The southeast direction.
     */
    public static final Simulation SOUTHEAST = new Simulation("southeast", 1, -1);

    /**
     * The south direction.
     */
    public static final Simulation SOUTH = new Simulation("south", 0, -1);

    /**
     * The southwest direction.
     */
    public static final Simulation SOUTHWEST = new Simulation("southwest", -1, -1);

    /**
     * The west direction.
     */
    public static final Simulation WEST = new Simulation("west", -1, 0);

    /**
     * The northwest direction.
     */
    public static final Simulation NORTHWEST = new Simulation("northwest", -1, 1);

    /**
     * An array of all directions listed in clockwise order.
     */
    private static final Simulation[] VALUES = {
            NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST
    };

    //
    // instance variables
    //
    /**
     * The name of this direction.
     */
    private String name;

    /**
     * The change in x for this direction.
     */
    private int dx;

    /**
     * The change in y for this direction.
     */
    private int dy;

    /**
     * The index of this direction within its array.
     */
    private int index;

    /**
     * Other classes cannot create new directions. They must use one of
     * the eight defined constants.
     *
     * @param myName the name to associate with the direction.
     * @param myDx   the change in x to associate with the direction.
     * @param myDy   the change in y to associate with the direction.
     */
    private Simulation(String myName, int myDx, int myDy) {
        name = myName;
        dx = myDx;
        dy = myDy;
        index = -1;
    }

    /**
     * Returns the number of columns changed with each step in this
     * direction. An eastward direction will return 1, a westward
     * direction will return -1, and north/south will return 0.
     *
     * @return the number of columns for each step in this direction.
     */
    public int getDeltaX() {
        return dx;
    }

    /**
     * Returns the number of rows changed with each step in this
     * direction. A northward direction will return 1, a southward
     * direction will return -1, and east/west will return 0.
     *
     * @return the number of rows for each step in this direction.
     */
    public int getDeltaY() {
        return dy;
    }


    /**
     * Returns a descriptive name for this direction.
     *
     * @return the descriptive name.
     */
    public String toString() {
        return name;
    }

    public Simulation random() {
        int i = rand.nextInt(8);
        return VALUES[i];
    }
}


