package Project;

import Project.Animal;

public class Fish extends Animal {
    private static int sumOfFishSwarms;

    public Fish(){
        super();
        this.sumOfFishSwarms++;
    }

    public static int getSumOfFishSwarms() {
        return sumOfFishSwarms;
    }

}
