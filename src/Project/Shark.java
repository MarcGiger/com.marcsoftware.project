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
    private final Color COLOUR = Color.red;
    private int positionX,positionY;

    /**
     * Creates a Shark.
     */
    public Shark(int x, int y) {
        positionX = x;
        positionY = y;
        sumOfSharks++;
        System.out.println("X: "+positionX+" "+positionY);
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

    public int getNegativeNeighbourX(){
        int a;
        a = getPositionX()-1;
if (a<0) return -1000;
else return a;
    }
    public int getPositiveNeighbourX(){
        int a;
        a = getPositionX()+1;
        if (a>15) return -1000;
        else return a;
    }

    public int getNegativeNeighbourY(){
        int a;
        a = getPositionY()-1;
        if (a<0) return -1000;
        else return a;
    }
    public int getPositiveNeighbourY(){
        int a;
        a = getPositionY()+1;
        if (a>8) return -1000;
        else return a;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Gets the colour shown on the grid for Animal-Type Shark.
     *
     * @return colour of Shark
     */
    @Override
    public Color getColour() {
        return COLOUR;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "COLOUR=" + COLOUR +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}'+"Neighbour: "+getNegativeNeighbourX()+" "+getPositiveNeighbourX();
    }

    @Override
    public void swim() {

    }
}