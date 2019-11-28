package Project;

import java.awt.Color;

/**
 * A simple definition of a Shark.
 * A Shark can die, give birth.
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Shark extends Animal {
    //  The maximum age of a Shark
    private static final int MAX_AGE = 60;
    // The probability a Shark gives birth to a new Shark
    private static final double BIRTH_PROBABILITY = 0.02;
    // The actual age of the Shark
    private int age;
    // The amount of sharks.
    private static int sumOfSharks = 0;
    //private final Color COLOUR = Color.red;
    //stores position within grid
    private int positionX, positionY;

    /**
     * Create a Shark.
     *
     * @param positionX giving the position on the x-axis.
     * @param positionY giving the position on the y-axis.
     */
    public Shark(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        sumOfSharks++;
        setAge(0);
    }

    /**
     * Set the amount of Sharks to zero.
     */
    public static void resetSumOfSharks() {
        sumOfSharks = 0;
    }

    /**
     * Set the amount of Sharks to inserted num.
     *
     * @param sumOfSharks this int is the new value of sumOfSharks.
     */
    public static void setSumOfSharks(int sumOfSharks) {
        Shark.sumOfSharks = sumOfSharks;
    }

    /**
     * Get the amount of created Sharks. Increases with every new Shark-Object.
     *
     * @return Amount of Sharks
     */
    public static int getNumOfSharks() {
        return sumOfSharks;
    }

    /**
     * Get the value of the field on the left if it exists. Otherwise, it returns -1000.
     *
     * @return a value of 0 - 14 or -1000
     */
    public int getNegativeNeighbourX() {
        if (getPositionX() - 1 < 0) return -1000;
        else return getPositionX() - 1;
    }

    /**
     * Get the value of the field on the right if it exists. Otherwise, it returns -1000.
     *
     * @return a value of 1 - 15 or -1000
     */
    public int getPositiveNeighbourX() {
        if (getPositionX() + 1 > 15) return -1000;
        else return getPositionX() + 1;
    }

    /**
     * Get the value of the field above if it exists. Otherwise, it returns -1000.
     *
     * @return a value of 0 - 7
     */
    public int getNegativeNeighbourY() {
        if (getPositionY() - 1 < 0) return -1000;
        else return getPositionY() - 1;
    }

    /**
     * Get the value of the field below if it exists. Otherwise, it returns -1000.
     *
     * @return a value of 1 - 8
     */
    public int getPositiveNeighbourY() {
        if (getPositionY() + 1 > 8) {
            return -1000;
        } else {
            return getPositionY() + 1;
        }
    }

    /**
     * Get the position on which the shark is placed on the x-axis.
     *
     * @return the position on the x-axis (width)
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     * Set the position on the x-axis.
     *
     * @param positionX the number of the position within the grid. (width)
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Get the position on which the shark is placed on the y-axis.
     *
     * @return the position on the y-axis (row)
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     * Set the position on the x-axis.
     *
     * @param positionY the number of the position within the grid. (row)
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Get the birth probability.
     *
     * @return the constant defined birth probability
     */
    public static double getBirthProbability() {
        return BIRTH_PROBABILITY;
    }


    /**
     * Increase the age of the Shark by one.
     */
    public void increaseAge() {
        age++;
        if (age == MAX_AGE) {
            alive = false;
        }
    }

    /**
     * Set the age of the Shark.
     *
     * @param age an int 0<
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Get the colour shown on the grid for Animal-Type Shark.
     *
     * @return colour of Shark
     */
    @Override
    public Color getColour() {
        return new Color(0, 0, 210);
    }

    @Override
    public String toString() {
        return "Shark:" +
                ", positionX:" + positionX +
                ", positionY:" + positionY +
                "Neighbour: " + getNegativeNeighbourX() + " " + getPositiveNeighbourX();
    }


}