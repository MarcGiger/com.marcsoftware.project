package Project;

import java.awt.Color;

public class Shark extends Animal implements Colourful {
    private static int sumOfSharks = 0;

    public Shark() {
        super();
        this.sumOfSharks++;
    }

    public static void reSetSumOfSharks() {
        Shark.sumOfSharks = 0;
    }

    public static int getNumOfSharks() {
        return sumOfSharks;
    }
}
