package Project;

public class Shark extends Animal {
    private static int sumOfSharks;

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
