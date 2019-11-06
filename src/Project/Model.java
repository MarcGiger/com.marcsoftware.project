package Project;

import java.util.Random;

public class Model {

    public Animal[][] animal;
    private int width, column;
    private Fish fish;
    private Shark shark;
    private Random rand;

    public Model(int width, int column) {
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
                if (rand.nextInt(30) < 1) {
                    animal[i][j] = new Shark();

                }
            }
        }
    }

    public Animal getObject(int i, int j) {
        Animal a1;
        return a1 = animal[i][j];
    }

    public void tellMeWhatsInside() {
        Animal a1 = null;
System.out.println("Test");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                System.out.println(a1);
                a1 = animal[i][j];
                System.out.println(a1);
                if (a1 instanceof Fish)
                System.out.println("blubb");
                if (a1 instanceof Shark)
                    System.out.println("rawwwr");
                else System.out.println("blueee water");
             }

        }
    }
}
