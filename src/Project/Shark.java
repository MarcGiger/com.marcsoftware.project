package Project;

import java.awt.Color;

public class Shark extends Animal implements Colourful {
    private static int sumOfSharks = 0;

    public Shark() {
        super();
        sumOfSharks++;
    }

    public static void resetSumOfSharks() {
        sumOfSharks = 0;
    }

    public static void setSumOfSharks(int sumOfSharks) {
        Shark.sumOfSharks = sumOfSharks;
    }

    public static int getNumOfSharks() {
        return sumOfSharks;
    }


    @Override
    public Color getColor() {
        return Color.red;
    }
}