package Project;

import Project.Animal;

public class Shark extends Animal {
    private static int numOfSharks;

    public Shark(){
        super();
        this.numOfSharks++;
    }

    public static int getNumOfSharks() {
        return numOfSharks;
    }


}
