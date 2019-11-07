package Project;

import java.util.Random;

public class Model {

    public Animal[][] animal;
    private int width, column;
    private Random rand;

    public Model(int width, int column) {
        this.width = width;
        this.column = column;
        animal = new Animal[width][column];
        rand = new Random();
        placeAnimal();
        tellMeWhatsInside();
    }

    public Animal[][] getAnimal() {
        return animal;
    }

    public void placeAnimal() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(5) < 1) {
                    animal[i][j] = new Fish();
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(30) < 1 && !(animal[i][j] instanceof Fish)) {
                    animal[i][j] = new Shark();

                }
            }
        }
    }

    public Animal getObject(int i, int j) {
        Animal a1;
        return a1 = animal[i][j];
    }

    public void resetAnimal() {
        Fish.reSetSumOfFishSwarms();
        Shark.reSetSumOfSharks();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                animal[i][j] = null;
            }
        }
    }

    //This method is for testing purposes. Is the populating of the grid working?

    public void tellMeWhatsInside() {
        Animal a1 = null;

        System.out.println("Test");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {

                a1 = animal[i][j];

                if (a1 instanceof Fish)
                    System.out.println("blubb");
                if (a1 instanceof Shark)
                    System.out.println("rawwwr");
                else System.out.println("blue water");
            }
        }
        System.out.println("Fish: " + Fish.getSumOfFishSwarms() + "\nSharks: " + Shark.getNumOfSharks());

    }


}
